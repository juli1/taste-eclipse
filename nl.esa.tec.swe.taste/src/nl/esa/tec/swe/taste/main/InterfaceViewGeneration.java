package nl.esa.tec.swe.taste.main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

import nl.esa.tec.swe.taste.commands.NavigatorCommands;
import nl.esa.tec.swe.taste.commands.Utils;
import nl.esa.tec.swe.taste.graphic.properties.Constants;
import nl.esa.tec.swe.taste.metamodel.taste.Function;
import nl.esa.tec.swe.taste.metamodel.taste.Interface;
import nl.esa.tec.swe.taste.metamodel.taste.InterfaceConnection;
import nl.esa.tec.swe.taste.metamodel.taste.InterfaceParameter;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.services.Graphiti;

public class InterfaceViewGeneration {
	private static Vector<Function> interfaceviewFunctionsList;
	private static Vector<InterfaceConnection> interfaceviewInterfaceConnectionList;
	private static Vector<Interface> interfaceviewInterfaceList;
	


	public static void browseInterfaceView (ContainerShape shape,BufferedWriter out) throws IOException
	{
		String functionName = null;
		Function function = null;

		Vector<Interface> interfaceList = null;
		Vector<Interface> interfaceListSubprogram = new Vector<Interface>();
		boolean subcomponentsDeclared = false;
		boolean featuresDeclared = false;

		for (int i = 0 ; i < shape.getChildren().size() ; i++)
		{
			if (shape.getChildren().get(i) instanceof ContainerShape)
			{
				ContainerShape di = (ContainerShape)shape.getChildren().get(i);
				Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(di);

				if (bo == null)
				{
					System.out.println("bo null");
				}
				else
				{
					if (bo instanceof Function)
					{
						interfaceviewFunctionsList.add ((Function)bo);
					}
					
					if (bo instanceof Interface)
					{
						interfaceviewInterfaceList.add ((Interface)bo);
						Interface tmp = (Interface)bo;
						for (InterfaceConnection ictmp: tmp.getConnections())
						{
							if (! interfaceviewInterfaceConnectionList.contains(ictmp))
							{
								interfaceviewInterfaceConnectionList.add (ictmp);
							}
						}
					}
					
					if (bo instanceof InterfaceConnection)
					{
						interfaceviewInterfaceConnectionList.add ((InterfaceConnection)bo);
					}
					
					if (bo instanceof Function)
					{
						
						subcomponentsDeclared = false;
						featuresDeclared = false;
						interfaceList = new Vector<Interface>();
						interfaceListSubprogram = new Vector <Interface>();
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

								if (bo2 instanceof Interface)
								{
									interfaceList.add ((Interface)bo2);
								}
							}
						}
						
						
						function = (Function)bo;
						functionName = function.getName().toLowerCase();
						
						out.write ("system " + functionName) ;
						out.newLine();
						for (Interface itf : interfaceList)
						{
							System.out.println("[InterfaceViewGeneration] handle interface " + itf.getName());
							if (! featuresDeclared)
							{
								out.write ("features") ;
								out.newLine();
								featuresDeclared = true;
							}
							if (itf.isIsProvidedInterface())
							{
								interfaceListSubprogram.add (itf);
								out.write ("   " + itf.getName() + " : provides subprogram access interfaceview::IV::" + itf.getName() ) ;
								out.write ("   {Taste::RCMoperationKind => "+NavigatorCommands.InterfaceTypeToName(itf.getInterfaceType()).toLowerCase()+"; Taste::RCMperiod => "+itf.getPeriod()+" ms;Taste::Deadline => "+itf.getDeadline()+" ms;Taste::Importance => MEDIUM ;};");
								out.newLine();
							}
							else
							{
								InterfaceConnection itfc;
								Interface correspondingProvided;
								itfc = itf.getConnections().get(0);
								correspondingProvided = itfc.getProvidedInterface();
								out.write ("   " + itf.getName() + " : requires subprogram access interfaceview::IV::" + correspondingProvided.getName() );
								out.write ("   {Taste::RCMoperationKind => "+NavigatorCommands.InterfaceTypeToName(correspondingProvided.getInterfaceType()).toLowerCase()+";};");
								out.newLine();
							}							
						}
						out.write ("properties");
						out.newLine();
						out.write ("   Source_Language => " + function.getLanguage() + ";");
						out.newLine();
						out.write ("end " + functionName + ";") ;
						out.newLine();
						out.newLine();

						
						out.write ("system implementation " + functionName + ".i") ;
						out.newLine();
						for (Interface itf : interfaceList)
						{
							if (itf.isIsProvidedInterface())
							{
								if (! subcomponentsDeclared)
								{
									out.write ("subcomponents") ;
									out.newLine();
									subcomponentsDeclared = true;
								}
								out.write ("   " + itf.getName() + "_sub : subprogram " + itf.getName() + ";") ;
								out.newLine();
							}
						}
						
						if (subcomponentsDeclared)
						{
							out.write ("connections") ;
							out.newLine();
						}
						for (Interface itf : interfaceList)
						{
							if (itf.isIsProvidedInterface())
							{

								out.write ("   subprogram access " + itf.getName() + "_sub -> " + itf.getName() + ";") ;
								out.newLine();
							}
						}
						out.write ("end " + functionName + ".i;") ;
						out.newLine();
						out.newLine();
						
						for (Interface itf: interfaceListSubprogram)
						{
							boolean isFeaturesDeclared = false;
							
							out.write ("subprogram " + itf.getName());
							out.newLine();
							if (itf.getInterfaceType() != Constants.INTERFACE_CYCLIC_INDEX)
							{
								for (InterfaceParameter itfParam : itf.getParameters())
								{
									if (! isFeaturesDeclared)
									{
										out.write ("features");
										out.newLine();
										isFeaturesDeclared = true;
									}
									out.write ("   " + itfParam.getName() + " : " );
									if (itfParam.getDirection() == Constants.PARAMETER_DIRECTION_IN)
									{
										out.write (" in ");
									}
									else
									{
										out.write (" out ");
									}
									out.write (" parameter DataView::");
									out.write (itfParam.getType());
									out.write ("{TASTE::Encoding => uPER; };");
									
									out.newLine();
								}
								
							}
							if (itf.getInterfaceType() == Constants.INTERFACE_SPORADIC_INDEX)
							{
								out.write ("properties");
								out.newLine();
								out.write ("TASTE::Associated_Queue_Size => 1;");
								out.newLine();
							}
							out.write ("end " + itf.getName() + ";");
							out.newLine();
							
							out.write ("subprogram implementation " + itf.getName() + ".i");
							out.newLine();
							out.write ("end " + itf.getName() + ".i;");
							out.newLine();
						}
					}
				}
				browseInterfaceView (di, out);
			}
		}
	}


	public static void generate (IProject project)
	{
		boolean subcomponentsDeclared = false;
		boolean connectionsDeclared = false;
		IWorkspace workspace = ResourcesPlugin.getWorkspace();  

		//get location of workspace (java.io.File)  
		File workspaceDirectory = workspace.getRoot().getLocation().toFile();

		interfaceviewFunctionsList = new Vector<Function>();
		interfaceviewInterfaceConnectionList = new Vector<InterfaceConnection>();
		interfaceviewInterfaceList = new Vector<Interface>();
		
		String outputFolder = workspaceDirectory.toString()  + "/" + project.getName().toString() + "/models/";
		
		File outputFolderTmp = new File (outputFolder);
		if (! outputFolderTmp.exists())
		{
			return;
		}
		
		String outputFileName = workspaceDirectory.toString()  + "/" + project.getName().toString() + "/models/interfaceview.aadl2";
		System.out.println("Output file:" + outputFileName);
		FileWriter fstream = null;
		try {
			fstream = new FileWriter(outputFileName);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		BufferedWriter outBuffer = new BufferedWriter(fstream);



		Diagram test = Utils.loadDiagram(project);

		if (test != null)
		{
			System.out.println("[InterfaceViewGeneration] Diagram successfully loaded ! ");
			System.out.println(test.toString());
		}
		else
		{
			System.out.println("[InterfaceViewGeneration] Error while loading diagram");
			return;
		}
		try
		{
		outBuffer.write ("package interfaceview::IV");
		outBuffer.newLine();
		outBuffer.write ("public");
		outBuffer.newLine();
		
		outBuffer.write ("with taste;");
		outBuffer.newLine();
		
		outBuffer.write ("with dataview;");
		outBuffer.newLine();
		
		outBuffer.write ("with deployment;");
		outBuffer.newLine();
		outBuffer.newLine();


		browseInterfaceView (test, outBuffer);
		

		outBuffer.newLine();
		outBuffer.newLine();
		

		outBuffer.write ("system interfaceview");
		outBuffer.newLine();
		outBuffer.write ("end interfaceview;");
		outBuffer.newLine();
		outBuffer.newLine();
		outBuffer.newLine();
		
		
		outBuffer.write ("system implementation interfaceview.others");
		outBuffer.newLine();
		for (Function f : interfaceviewFunctionsList)
		{
			if (! subcomponentsDeclared)
			{
				outBuffer.write ("subcomponents");
				outBuffer.newLine();
				subcomponentsDeclared = true;
			}
			outBuffer.write ("   " + f.getName() + " : system " + f.getName() + ".i;");
			outBuffer.newLine();
		}
		for (InterfaceConnection ic : interfaceviewInterfaceConnectionList)
		{
			if (! connectionsDeclared)
			{
				outBuffer.write ("connections");
				outBuffer.newLine();
				connectionsDeclared = true;
			}
			outBuffer.write ("   ri_pi_"+ic.getRequiredInterface().getName().toLowerCase() + " : subprogram access " + ic.getProvidedInterface().getAssociatedFunction().getName().toLowerCase() + "." + ic.getProvidedInterface().getName().toLowerCase() + " ->  " + ic.getRequiredInterface().getAssociatedFunction().getName().toLowerCase() + "." + ic.getRequiredInterface().getName().toLowerCase() + ";");
			outBuffer.newLine();
		}
		outBuffer.write ("end interfaceview.others;");
		outBuffer.newLine();
		outBuffer.newLine();
		
		outBuffer.write ("properties");
		outBuffer.newLine();
		outBuffer.write ("Taste::dataView => (\"DataView\");");
		outBuffer.newLine();
		outBuffer.write ("Taste::dataViewPath => (\"dataview.aadl\");");
		outBuffer.newLine();
		outBuffer.newLine();
		

		outBuffer.write ("end interfaceview::IV;");

		outBuffer.newLine();
		
		//Close the output stream
		outBuffer.close();
		fstream.close();

		
		}
		catch (Exception e)
		{
			Utils.showError("Error when generating interface view, exception was raised");
			e.printStackTrace();
			System.err.println("[InterfaceViewGeneration] Error: " + e.getMessage());
		}

	}


}
