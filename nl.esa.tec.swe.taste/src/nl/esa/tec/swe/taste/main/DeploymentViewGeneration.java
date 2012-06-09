package nl.esa.tec.swe.taste.main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

import nl.esa.tec.swe.taste.commands.Utils;
import nl.esa.tec.swe.taste.graphic.properties.Constants;
import nl.esa.tec.swe.taste.metamodel.taste.Board;
import nl.esa.tec.swe.taste.metamodel.taste.Bus;
import nl.esa.tec.swe.taste.metamodel.taste.BusConnection;
import nl.esa.tec.swe.taste.metamodel.taste.Driver;
import nl.esa.tec.swe.taste.metamodel.taste.Function;
import nl.esa.tec.swe.taste.metamodel.taste.Interface;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.services.Graphiti;

public class DeploymentViewGeneration {
	
	public static void generate (IProject project)
	{
		Vector<Board> boardList = new Vector<Board>();
		Vector<Interface> allRequiredInterfaceList = new Vector<Interface>();
		Vector<Bus> busList = new Vector<Bus>();
		Vector<Function> functionList = null;
		Vector<Driver> driverList = null;
		Vector<BusConnection> busConnectionList = null;
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		String componentName = null;
		String functionName = null;
		String driverName = null;
		boolean connectionsSectionDeclared = false;
		boolean localConnectionsSectionDeclared = false;
		boolean featuresSectionDeclared = false;
		boolean propertiesSectionDeclared = false;

		//get location of workspace (java.io.File)  
		File workspaceDirectory = workspace.getRoot().getLocation().toFile();
		String outputFolder = workspaceDirectory.toString()  + "/" + project.getName().toString() + "/models/";
		
		File outputFolderTmp = new File (outputFolder);
		if (! outputFolderTmp.exists())
		{
			return;
		}
		
		String outputFileName = workspaceDirectory.toString()  + "/" + project.getName().toString() + "/models/deploymentview.aadl2";
		System.out.println("[DeploymentViewGeneration] Output file:" + outputFileName);
		FileWriter fstream = null;
		try {
			fstream = new FileWriter(outputFileName);
		} catch (IOException e1) {

			e1.printStackTrace();
		}
		BufferedWriter outBuffer = new BufferedWriter(fstream);



		Diagram diagram = Utils.loadDiagram(project);

		if (diagram != null)
		{
			System.out.println("Diagram successfully loaded ! ");
			System.out.println(diagram.toString());
		}
		else
		{
			System.out.println("Error while loading diagram");
			return;
		}
		
		busConnectionList = new Vector<BusConnection>();

		try
		{
			outBuffer.write ("package deploymentview::DV");
			outBuffer.newLine();
			outBuffer.write ("public");
			outBuffer.newLine();
			
			outBuffer.write ("with taste;");
			outBuffer.newLine();
			
			outBuffer.write ("with deployment;");
			outBuffer.newLine();
			
			outBuffer.write ("with interfaceview::IV;");
			outBuffer.newLine();
		
			outBuffer.write ("with ocarina_buses;");
			outBuffer.newLine();
			
			outBuffer.write ("with ocarina_drivers;");
			outBuffer.newLine();
			
			outBuffer.write ("with ocarina_processors_x86;");
			outBuffer.newLine();
			
			outBuffer.write ("with ocarina_processors_leon;");
			outBuffer.newLine();
			outBuffer.newLine();

			
			for (int i = 0 ; i < diagram.getChildren().size() ; i++)
			{
				System.out.println("children " + i + diagram.getChildren().get(i));
				if (diagram.getChildren().get(i) instanceof ContainerShape)
				{
					ContainerShape di = (ContainerShape)diagram.getChildren().get(i);
					Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(di);

					if (bo == null)
					{
						System.out.println("[GenerateTasteModels] bo null");
					}
					else
					{
						if (bo instanceof Board)
						{
							localConnectionsSectionDeclared = false;
							functionList = new Vector<Function>();
							driverList = new Vector<Driver>();

							componentName = ((Board)bo).getName();
							componentName = componentName.toLowerCase();
							featuresSectionDeclared = false;
							
							boardList.add ((Board) bo);
							try {
								outBuffer.write ("process process_" + componentName);
								outBuffer.newLine();
								outBuffer.write ("end process_" + componentName +";");
								outBuffer.newLine();
								outBuffer.newLine();

								outBuffer.write ("process implementation process_" + componentName + ".i");
								outBuffer.newLine();
								outBuffer.write ("end process_" + componentName + ".i;");
								outBuffer.newLine();
								outBuffer.newLine();


								outBuffer.write ("system " + componentName);
								outBuffer.newLine();
								for (int j = 0 ; j < di.getChildren().size() ; j++)
								{
									if (di.getChildren().get(j) instanceof ContainerShape)
									{
										ContainerShape di2 = (ContainerShape)di.getChildren().get(j);
										Object bo2 = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(di2);

										if (bo2 == null)
										{
											System.out.println("[GenerateTasteModels] bo null");
										}
										
										if (bo2 instanceof Driver)
										{
											Driver drv = (Driver) bo2;

											for (BusConnection tmpBc : drv.getConnections())
											{
												if (! featuresSectionDeclared)
												{
													featuresSectionDeclared = true;
													outBuffer.write ("features");
													outBuffer.newLine();	
												}
												outBuffer.write ("   " + tmpBc.getAssociatedBus().getName().toLowerCase() + "_link : requires bus access "+ Constants.getBusComponentName (tmpBc.getAssociatedBus()) +";");
												outBuffer.newLine();	
											}	
										}
									}
								}
								outBuffer.write ("end " + componentName + ";");
								outBuffer.newLine();
								outBuffer.newLine();

								outBuffer.write ("system implementation " + componentName + ".i");
								outBuffer.newLine();
								outBuffer.write ("subcomponents");
								outBuffer.newLine();

								outBuffer.write ("   cpu_"+componentName+" : processor " + Constants.getProcessorComponentName ((Board) bo) +";");
								outBuffer.newLine();
								outBuffer.write ("   process_"+componentName+" : process process_" + componentName + ".i;");
								outBuffer.newLine();

								for (int j = 0 ; j < di.getChildren().size() ; j++)
								{
									if (di.getChildren().get(j) instanceof ContainerShape)
									{
										ContainerShape di2 = (ContainerShape)di.getChildren().get(j);
										Object bo2 = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(di2);

										if (bo2 == null)
										{
											System.out.println("[GenerateTasteModels] bo null");
										}

										if (bo2 instanceof Function)
										{
											Function f = (Function)bo2;
											for (Interface tmpif : f.getInterfaces())
											{
												if ( ! tmpif.isIsProvidedInterface())
												{
													allRequiredInterfaceList.add (tmpif);
												}
											}
											functionName = ((Function)bo2).getName();
											functionList.add(f);
											outBuffer.write ("   " + functionName + " : system interfaceview::IV::" + functionName + ";");
											outBuffer.newLine();
										}
										
										if (bo2 instanceof Driver)
										{
											Driver tmp = (Driver)bo2;
											driverName = tmp.getName();
											driverList.add (tmp);
											outBuffer.write ("   " + driverName + " : device "+ Constants.getDriverComponentName (tmp));
											outBuffer.newLine();
											String config;
											config = tmp.getConfig();
											config = config.replaceAll("\"", "\"" + "\"");
											outBuffer.write ("   {Deployment::Configuration => \""+config+"\";};");
											outBuffer.newLine();
										}
									}
								}
								
								
								for (int j = 0 ; j < di.getChildren().size() ; j++)
								{
									if (di.getChildren().get(j) instanceof ContainerShape)
									{
										ContainerShape di2 = (ContainerShape)di.getChildren().get(j);
										Object bo2 = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(di2);

										if (bo2 == null)
										{
											System.out.println("[GenerateTasteModels] bo null");
										}
										
										if (bo2 instanceof Driver)
										{
											Driver drv = (Driver) bo2;

											for (BusConnection tmpBc : drv.getConnections())
											{
												if (! localConnectionsSectionDeclared)
												{
													localConnectionsSectionDeclared = true;
													outBuffer.write ("connections");
													outBuffer.newLine();
												}
												outBuffer.write ("   bus access "+ tmpBc.getAssociatedBus().getName().toLowerCase() +"_link -> "+drv.getName().toLowerCase()+".link;");
												outBuffer.newLine();	
											}
										}
									}
								}
								
								outBuffer.write ("properties");
								outBuffer.newLine();
								outBuffer.write ("   Actual_Processor_Binding => (reference(cpu_"+componentName+")) applies to process_"+componentName+";");
								outBuffer.newLine();
								for (Function f : functionList)
								{
									outBuffer.write ("   Taste::APLC_Binding => (reference(process_"+componentName+")) applies to "+ f.getName() + ";");
									outBuffer.newLine();
								}
								for (Driver d : driverList)
								{
									outBuffer.write ("   Actual_Processor_Binding => (reference(cpu_"+componentName+")) applies to "+ d.getName() + ";");
									outBuffer.newLine();
								}
								outBuffer.write ("end " + componentName + ".i;");
								outBuffer.newLine();
								outBuffer.newLine();



							} catch (IOException e) {
								System.out.println("[GenerateTasteModels] Error while generating deployment view");

								e.printStackTrace();
							}
						}
						if (bo instanceof Bus)
						{
							Bus b = (Bus) bo;

							for (BusConnection bc : b.getConnections())
							{
								if (! busConnectionList.contains (bc))
								{
									busConnectionList.add (bc);
								}
							}
							componentName = ((Bus)bo).getName();
							busList.add(b);

						}
					}
				}
			}
			outBuffer.write ("system deploymentview");
			outBuffer.newLine();
			outBuffer.write ("end deploymentview;");
			outBuffer.newLine();
			outBuffer.newLine();

			
			outBuffer.write ("system implementation deploymentview.others");
			outBuffer.newLine();
			outBuffer.write ("subcomponents");
			outBuffer.newLine();
			outBuffer.write ( "   interfaceview : system interfaceview::IV::interfaceview.others;");
			outBuffer.newLine();
			for (Board b : boardList)
			{
				outBuffer.write ( "   " + b.getName() + " : system " + b.getName() + ".i;");
				outBuffer.newLine();
			}
			for (Bus b : busList)
			{
				outBuffer.write ( "   " + b.getName() + " : bus " + Constants.getBusComponentName (b) + ";");
				outBuffer.newLine();
			}
			for (BusConnection bc : busConnectionList)
			{
				if (! connectionsSectionDeclared)
				{
					connectionsSectionDeclared = true;
					outBuffer.write ( "connections");
					outBuffer.newLine();
				}
				
				
				Bus b = bc.getAssociatedBus();
				System.out.println("[DeploymentViewGeneration] bus for bus access "+ b );
				if (b == null)
				{
					Utils.showError("Cannot get associated bus for bus connection");
					return;
				}
				
				Driver drv = bc.getAssociatedDriver();
				System.out.println("[DeploymentViewGeneration] drv for bus access "+ drv );
				if (drv == null)
				{
					Utils.showError("Cannot get associated driver to bus " + b.getName());
					return;
				}
				
				
				Board tmpboard = drv.getAssociatedBoard();
				System.out.println("[DeploymentViewGeneration] board for bus access "+ drv );
				if (tmpboard == null)
				{
					Utils.showError("Cannot get associated board to driver " + tmpboard.getName());
					return;
				}
				
				
				outBuffer.write ("   bus access "+b.getName().toLowerCase() + " -> " + tmpboard.getName().toLowerCase() +"."+b.getName()+"_link;");
				outBuffer.newLine();
			}
			
			outBuffer.newLine();
			
			for (Interface tmpif : allRequiredInterfaceList)
			{
				if (tmpif.getConnections().size() <= 0)
				{
					continue;
				}
				
				Interface correspondingProvided = tmpif.getConnections().get(0).getProvidedInterface();
				if (correspondingProvided == null)
				{
					Utils.showError("Cannot get associated provided interface for required interface " + tmpif.getName());
					return;
				}
				
				Board boardSource = Utils.getBoard (tmpif);
				if (boardSource == null)
				{
					Utils.showError("Cannot get associated board for interface " + tmpif.getName());
					return;
				}
				
				Board boardDestination = Utils.getBoard (correspondingProvided);
				if (boardDestination == null)
				{
					Utils.showError("Cannot get associated board for interface " + correspondingProvided.getName());
					return;
				}
				
				if (boardSource.getName().toLowerCase().equals(boardDestination.getName().toLowerCase()))
				{
					continue;
				}
				
				Bus b = Utils.getBoundBus (tmpif);
				
				if (b == null)
				{
					b = Utils.getDefaultBus (boardSource);
				}
				
				if (b == null)
				{
					Utils.showError("Cannot get associated bus for connection to " + tmpif.getName());
					continue;
				}
				
				if (! propertiesSectionDeclared)
				{
					propertiesSectionDeclared = true;
					outBuffer.write ( "properties");
					outBuffer.newLine();
				}
				outBuffer.write ("   Actual_Connection_Binding => (reference ("+b.getName().toLowerCase() + ")) applies to interfaceview.ri_pi_"+tmpif.getName().toLowerCase()+";");
				outBuffer.newLine();
			}
			outBuffer.write ("end deploymentview.others;");
			outBuffer.newLine();
			outBuffer.newLine();

			outBuffer.write ("properties");
			outBuffer.newLine();
			outBuffer.write ( "   Taste::interfaceView => \"interfaceview.aadl\";");
			outBuffer.newLine();
			outBuffer.newLine();
			outBuffer.write ("end deploymentview::DV;");
			outBuffer.newLine();
			outBuffer.newLine();

			outBuffer.newLine();
			//Close the output stream
			outBuffer.close();
			fstream.close();
		}
		catch (Exception e)
		{
			Utils.showError("Error when generating deployment view, exception was raised");
			e.printStackTrace();
			System.err.println("[DeploymentViewGeneration] Error: " + e.getMessage());
		}



	}

}
