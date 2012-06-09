package nl.esa.tec.swe.taste.commands;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.HashMap;
import java.util.Vector;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import nl.esa.tec.swe.taste.graphic.properties.Constants;
import nl.esa.tec.swe.taste.main.Activator;
import nl.esa.tec.swe.taste.main.DeploymentViewGeneration;
import nl.esa.tec.swe.taste.main.InterfaceViewGeneration;
import nl.esa.tec.swe.taste.main.Tasted;
import nl.esa.tec.swe.taste.metamodel.taste.Board;
import nl.esa.tec.swe.taste.metamodel.taste.Bus;
import nl.esa.tec.swe.taste.metamodel.taste.BusConnection;
import nl.esa.tec.swe.taste.metamodel.taste.Driver;
import nl.esa.tec.swe.taste.metamodel.taste.Function;
import nl.esa.tec.swe.taste.metamodel.taste.Interface;
import nl.esa.tec.swe.taste.metamodel.taste.InterfaceConnection;
import nl.esa.tec.swe.taste.metamodel.taste.InterfaceParameter;
import nl.esa.tec.swe.taste.metamodel.taste.TasteComponent;
import nl.esa.tec.swe.taste.views.Navigator;
import nl.esa.tec.swe.taste.views.NavigatorLabel;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.editor.DiagramEditorInput;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.contentoutline.ContentOutline;
import org.eclipse.ui.views.navigator.ResourceNavigator;

public class Utils {

	private static Tasted tastedServer;
	private static HashMap<IProject,Diagram> diagrams = new HashMap<IProject,Diagram>();

	public Object search (ContainerShape shape, Class businessClass)
	{
		for (int i = 0 ; i < shape.getChildren().size() ; i++)
		{
			if (shape.getChildren().get(i) instanceof ContainerShape)
			{
				ContainerShape di = (ContainerShape)shape.getChildren().get(i);
				Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(di);

				if (bo == null)
				{
					System.out.println("[Utils] bo null");
				}
				else
				{
					if (bo.getClass() == businessClass)
					{
						return bo;
					}
					return search (di,businessClass);
				}
			}
		}
		return null;
	}


	public static Diagram loadCurrentDiagram ()
	{
		IViewPart [] parts =
				Activator.getDefault().getWorkbench().getActiveWorkbenchWindow().getActivePage().getViews();

		for(int i=0;i<parts.length;i++)
		{
			if(parts[i] instanceof ContentOutline)
			{
				ContentOutline content = (ContentOutline)parts[i];
				IEditorPart  editorPart = content.getSite().getWorkbenchWindow().getActivePage().getActiveEditor();

				if(editorPart  != null)
				{
					if (editorPart.getEditorInput() instanceof DiagramEditorInput)
					{
						DiagramEditorInput input = (DiagramEditorInput)editorPart.getEditorInput();
						// FIXMEs
						//return (input.getDiagram());
					}
				}
			}
		}

		return null;
	}		


	public static Diagram loadDiagram(IProject activeProject)
	{
		URI uri = null;

		if (diagrams.get(activeProject) != null)
		{
			System.out.println("[Utils] Diagram found in cache !");
			return (diagrams.get(activeProject));
		}
		System.out.println("[Utils] Diagram not found in cache, trying to load it ...");

		String activeProjectName = activeProject .getName();
		IWorkspace workspace = ResourcesPlugin.getWorkspace();  

		File workspaceDirectory = workspace.getRoot().getLocation().toFile();

		String inputFile = workspaceDirectory.toString() + "/" + activeProjectName + "/models/architecture.diagram";
		if (Platform. getOS().equals(Platform.OS_WIN32))
		{
			inputFile = inputFile.replace('/', '\\');
		}
		else
		{
			inputFile = inputFile.replace('\\', '/');
		}

		System.out.println("[Utils] File to load" + inputFile);
		File toOpen = new File (inputFile);
		if (! toOpen.exists())
		{ 
			System.out.println("[Utils] Diagram not found");
			return null;
		}

		IFile ifile = activeProject.getFile("models/architecture.diagram");
		if (ifile.exists())
		{
			System.out.println("[Utils] Found right ifile   : " + ifile);


		}
		else
		{
			System.out.println("[Utils] Error while finding the ifile");

			return null;

		}
		uri = URI.createPlatformResourceURI(activeProjectName + "/models/architecture.diagram", true);
		final ResourceSet resourceSet = new ResourceSetImpl();
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(ifile);
		System.out.println("[Utils] resourceSet   : " + resourceSet);
		System.out.println("[Utils] editingDomain : " + editingDomain);
		System.out.println("[Utils] uri           : " + uri);
		if (editingDomain == null)
		{
			System.out.println("[Utils] editingDomain null, try to create one by hand");
			editingDomain = TransactionalEditingDomain.Factory.INSTANCE.createEditingDomain(resourceSet);
			System.out.println("[Utils] editingDomain : " + editingDomain);
		}

		URI uridiagram = uri.appendFragment("/0");   // diagram is first object
		System.out.println("[Utils] uri           : " + uridiagram);
		EObject diagram = editingDomain.getResourceSet().getEObject(uridiagram, true);
		if (diagram == null) 
			diagram = editingDomain.getResourceSet().getEObject(uridiagram, true);
		//diagrams.put(activeProject, (Diagram) diagram);
		return (Diagram) diagram;
	}

	
	public static Shape getRootComponent (Shape shape)
	{
		if (shape.getContainer () != null)
		{
			System.out.println("[Utils] get Container for component: " + shape);
			return getRootComponent (shape.getContainer());
		}
		else	
		{
			System.out.println("[Utils] Found root: " + shape);
			return shape;
		}
	}
	
	public static Object nameExists (String name, Shape root)
	{
		System.out.println("[Utils] nameExists on component " + root);
		Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(root);
		
		if (bo != null)
		{
		
			if (bo instanceof TasteComponent)
			{
				TasteComponent tc = (TasteComponent) bo;
				if (tc.getName().toLowerCase().equals(name))
				{
					return tc;
				}
			}
	
			if (bo instanceof Interface)
			{
				Interface itf = (Interface) bo;
				if (itf.getName().toLowerCase().equals(name))
				{
					return itf;
				}				
			}
		}
		if (root instanceof ContainerShape)
		{
			ContainerShape cont = (ContainerShape)root;
			for (Shape s : cont.getChildren())
			{	
				Object o = null;
				o = nameExists (name, s);
				if (o != null)
				{
					return o;
				}
			}
		}
		
		return null;
	}

	public static boolean isTasteProject (IProject p)
	{
		return (( p.getFolder("models") != null) && (p.getFolder("models").exists()));
	}
	
	
	
	public static IProject getActiveProject ()
	{
		IProject activeProject = null;

		if (Activator.getDefault().getWorkbench().getActiveWorkbenchWindow().getActivePage() == null)
		{
			return null;
		}
		IEditorPart currentEditor = Activator.getDefault().getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();

		IWorkbenchPart currentPart = currentEditor.getSite().getPart();
//		System.out.println("[Utils] current part=" + currentPart);
//		System.out.println("[Utils] current part class=" + currentPart.getClass().getName());
		if (currentPart instanceof IEditorPart)
		{
//			System.out.println("[Utils] we have a ieditor part=" + currentPart);
			IEditorPart editorPart = (IEditorPart) currentPart;
			if (editorPart instanceof IFileEditorInput)
			{
				IFileEditorInput input = (IFileEditorInput)editorPart.getEditorInput() ;
				IFile file = input.getFile();
				activeProject = file.getProject();
				if (isTasteProject(activeProject))
				{
					return activeProject;
				}
			}
		}
		
		ISelection currentSelection = Activator.getDefault().getWorkbench().getActiveWorkbenchWindow().getActivePage().getSelection();
		
//		System.out.println("current selection=" + currentSelection);
//		System.out.println("current selection class=" + currentSelection.getClass().getName());
		
		if (currentSelection instanceof TreeSelection)
		{
			TreeSelection ts = (TreeSelection) currentSelection;
//			System.out.println ("First element = " + ts.getFirstElement());
//			System.out.println ("First element class = " + ts.getFirstElement().getClass().getName());
			if (ts.getFirstElement() instanceof NavigatorLabel)
			{
				NavigatorLabel nl = (NavigatorLabel) ts.getFirstElement();
				return nl.getProject();
			}
			if (ts.getFirstElement() instanceof IProject)
			{
				IProject tmp = (IProject) ts.getFirstElement();
				if (isTasteProject(tmp))
				{
					return tmp;
				}
			}
		}
		

		
		IViewPart [] parts =
				Activator.getDefault().getWorkbench().getActiveWorkbenchWindow().getActivePage().getViews();

		if( parts == null)
		{
			return null;
		}
		for(int i=0;i<parts.length;i++)
		{

//			System.out.println("[Utils] parts instance " + parts[i]);
			/*
			if(parts[i] instanceof ResourceNavigator)
			{
				ResourceNavigator navigator = (ResourceNavigator)parts[i];
				StructuredSelection sel   =
						(StructuredSelection)navigator.getTreeViewer().getSelection();
				if(sel.getFirstElement() instanceof NavigatorLabel)
				{
					activeProject = ((NavigatorLabel)sel.getFirstElement()).getProject();
				}
				if(sel.getFirstElement() instanceof IResource)
				{
					IResource resource = (IResource)sel.getFirstElement();
					if (resource != null)
					{
						activeProject = resource.getProject();
					}
				}
				if (activeProject != null)
				{
					if (isTasteProject(activeProject))
					{
						return activeProject;
					}
				}
			}*/
			if(parts[i] instanceof Navigator)
			{
				Navigator navigator = (Navigator)parts[i];
				StructuredSelection sel   = (StructuredSelection) navigator.getViewer().getSelection();
				//	(StructuredSelection)navigator.getTreeViewer().getSelection();
				System.out.println("[Utils] sel first element " + sel.getFirstElement());

				if(sel.getFirstElement() instanceof NavigatorLabel)
				{
					activeProject = ((NavigatorLabel)sel.getFirstElement()).getProject();
				}
				if(sel.getFirstElement() instanceof IResource)
				{
					IResource resource = (IResource)sel.getFirstElement();
					if (resource != null)
					{
						activeProject = resource.getProject();
					}
				}
				if ((activeProject != null) && (isTasteProject(activeProject)))
				{
					return activeProject;

				}
			}
			if(parts[i] instanceof ContentOutline)
			{
				ContentOutline content = (ContentOutline)parts[i];
				IEditorPart  editorPart = content.getSite().getWorkbenchWindow().getActivePage().getActiveEditor();

				if(editorPart  != null)
				{
					if (editorPart.getEditorInput() instanceof IFileEditorInput)
					{
						IFileEditorInput input = (IFileEditorInput)editorPart.getEditorInput() ;
						IFile file = input.getFile();
						activeProject = file.getProject();
					}
					if (editorPart.getEditorInput() instanceof DiagramEditorInput)
					{
						DiagramEditorInput input = (DiagramEditorInput)editorPart.getEditorInput() ;
						System.out.println("[Utils] getAdapter result="+editorPart.getEditorInput().getAdapter(IFile.class));
						/*activeProject = getWorkspaceProjectFromEObject (input.getEObject());*/
					}
					if ((activeProject != null) && (isTasteProject(activeProject)))
					{
						return activeProject;

					}
				}

				StructuredSelection sel   =
						(StructuredSelection)content.getSelection();
				System.out.println("[Utils] sel instance " + sel);

				if(sel.getFirstElement() instanceof IResource)
				{
					IResource resource = (IResource)sel.getFirstElement();
					if (resource != null)
					{
						activeProject = resource.getProject();
					}
				}
				if ((activeProject != null) && (isTasteProject(activeProject)))
				{
					return activeProject;

				}
			}
		}

		return null;
	}


	public static void refreshNavigator ()
	{
		IViewPart [] parts =
				Activator.getDefault().getWorkbench().getActiveWorkbenchWindow().getActivePage().getViews();

		for(int i=0;i<parts.length;i++)
		{

			System.out.println("[Utils] parts instance " + parts[i]);
			if(parts[i] instanceof ResourceNavigator)
			{
				System.out.println("[Utils] refresh " + parts[i]);
				ResourceNavigator navigator = (ResourceNavigator)parts[i];
				navigator.getViewer().refresh();
				navigator.getTreeViewer().refresh();
			}
			if(parts[i] instanceof Navigator)
			{
				System.out.println("[Utils] refresh " + parts[i]);
				Navigator navigator = (Navigator)parts[i];
				navigator.getViewer().refresh();
				navigator.getTreeViewer().refresh();
			}
		}
	}



	public static void createFunctionSkeleton(Function f)
	{
		IProgressMonitor monitor = new NullProgressMonitor(); 
		IFile file;
		String toWrite;
		PipedInputStream in;

		file 	= getFunctionFile(f);
		toWrite = getSourceContentForFunction (f);
		in 		= new PipedInputStream();

		PipedOutputStream out;

		try {
			out = new PipedOutputStream(in);


			out.write(toWrite.getBytes());

			out.close();

			if (! file.exists())
			{
				System.out.println ("[Utils] Create file " + file);

				file.create(in, true, monitor);
			}
			else
			{
				System.out.println ("[Utils] Set file contents " + file);

				file.setContents(in, true, true, monitor);
			}

			file.refreshLocal(0, monitor);


		} catch (IOException e) {
			System.out.println ("[Utils] ERROR: IOException raised");
			e.printStackTrace();
		} catch (CoreException e) {
			System.out.println ("[Utils] ERROR: Core Exception raised");
			e.printStackTrace();
		}


		file = getHeaderFile(f);
		toWrite = getHeadContentForFunction (f);
		if (toWrite != null)
		{
			in = new PipedInputStream();


			try {
				out = new PipedOutputStream(in);


				out.write(toWrite.getBytes());

				out.close();

				if (! file.exists())
				{
					System.out.println ("[Utils] Create file " + file);

					file.create(in, true, monitor);
				}
				else
				{
					System.out.println ("[Utils] Set file contents " + file);

					file.setContents(in, true, true, monitor);
				}

				file.refreshLocal(0, monitor);


			} catch (IOException e) {
				System.out.println ("[Utils] ERROR: IOException raised");
				e.printStackTrace();
			} catch (CoreException e) {
				System.out.println ("[Utils] ERROR: Core Exception raised");
				e.printStackTrace();
			}
		}

	}

	private static String getHeadContentForFunction(Function f) 
	{
		if (f.getLanguage().toLowerCase().equals("c"))
		{
			return getHeaderContentForFunctionLanguageC(f);
		}
		if (f.getLanguage().toLowerCase().equals("ada"))
		{
			return getSpecsContentForFunctionLanguageAda(f);
		}
		return "";
	}


	private static String getHeaderContentForFunctionLanguageC(Function f) {

		return null;
	}


	private static IFile getHeaderFile(Function f) {

		IFolder skeletonsFolder = null;
		IFolder functionFolder = null;
		String fileName = null;

		skeletonsFolder = getActiveProject().getFolder("skeletons");
		if( ! skeletonsFolder.exists())
		{
			System.out.println ("[Utils] ERROR: " + skeletonsFolder.toString() + " does not exist");

			try {
				skeletonsFolder.create(true, true, null);
			} catch (CoreException e) {
				System.out.println ("[Utils] exception when trying to create skeletons folder");
				e.printStackTrace();
			}
		}

		functionFolder = skeletonsFolder.getFolder(f.getName());
		if( ! functionFolder.exists())
		{
			System.out.println ("[Utils] ERROR: " + functionFolder.toString() + " does not exist");

			try {
				functionFolder.create(true, true, null);
			} catch (CoreException e) {
				System.out.println ("[Utils] exception when trying to create function folder" + f.getName());
				e.printStackTrace();
			}
		}


		fileName = f.getName() + ".h";

		if (f.getLanguage().toLowerCase().equals ("c"))
		{
			fileName = f.getName() + ".h";
		}
		if (f.getLanguage().toLowerCase().equals ("ada"))
		{
			fileName = f.getName() + ".ads";
		}


		IFile functionFile = functionFolder.getFile (fileName);
		if ( ! functionFile.exists())
		{
			System.out.println ("[Utils] ERROR: " + functionFile.toString() + " does not exist");
		}
		return functionFile;

	}


	private static String getInterfaceParametersLanguageC (Interface i)
	{
		boolean hasParameters = false;
		String ret = "";

		for ( InterfaceParameter p : i.getParameters())
		{
			if (hasParameters)
			{
				ret += ",";
			}
			hasParameters = true;
			ret += "asn1Scc" + p.getType();
			ret += "* ";
			if (p.getDirection() == Constants.PARAMETER_DIRECTION_IN)
			{
				ret += " IN_";
			}
			else
			{
				ret += "OUT_";
			}
			ret += p.getName();
		}
		return ret;
	}

	
	

	private static String getSourceContentForFunction(Function f)
	{
		if (f.getLanguage().toLowerCase().equals("c"))
		{
			return getSourceContentForFunctionLanguageC(f);
		}
		if (f.getLanguage().toLowerCase().equals("ada"))
		{
			return getSourceContentForFunctionLanguageAda(f);
		}
		return "";
	}



	private static String getSpecsContentForFunctionLanguageAda(Function f) 
	{
		System.out.println ("[Utils] Get content for function " + f.getName() );

		String ret = "";
		ret += "pragma style_checks (off);";
		ret += "\n";
		ret += "pragma warnings (off);";
		ret += "\n";
		ret += "with adaasn1rtl;";
		ret += "\n";
		ret += "use adaasn1rtl;";
		ret += "\n";
		ret += "\n";

		ret += "with dataview;";
		ret += "\n";
		ret += "use dataview;";
		ret += "\n";

		ret += "package " + f.getName() + " is";
		ret += "\n";

		ret += "\n";
		ret += "\tprocedure " + f.getName() + "_startup is";
		ret += "\n";
		ret += "\tbegin";
		ret += "\n";
		ret += "\t\t-- Write initialization code here";
		ret += "\n";
		ret += "\tend " + f.getName() + "_startup;";
		ret += "\n";
		ret += "\n";

		for (Interface i : f.getInterfaces())
		{
			System.out.println ("[Utils] Function " + f.getName() + " has interface " + i.getName() );

			if ( ! i.isIsProvidedInterface())
			{
				System.out.println ("[Utils] Function " + f.getName()  + " has the required interface " + i.getName());

				EList <InterfaceConnection> ics = i.getConnections();
				if (ics.size() <= 0)
				{
					continue;
				}
				else
				{
					System.out.println ("[Utils] Size of connection list to zero");
				}

				for (int k = 0 ; k < ics.size() ; k++)
				{
					InterfaceConnection ic = ics.get(k);
					Interface provided = ic.getProvidedInterface();
					if (provided != null)
					{
						System.out.println ("[Utils] Required interface " + i.getName()  + " connected to the following provided " + provided.getName());
						ret += "\tprocedure "+ f.getName() + "_" + i.getName()+"(";
						ret += getInterfaceParametersLanguageAda (provided);
						ret += ")";
						ret += "\n";
						ret += "\n";
						ret += "pragma import (C, " + provided.getAssociatedFunction().getName() + "_" + provided.getName() + " , \""+f.getName() + "_RI_" + i.getName() + "\");";

					}
					else
					{
						System.out.println ("[Utils] Required interface " + i.getName()  + " NOT connected");
					}
				}

			}
		}

		System.out.println ("[Utils] Look for provided and cyclic interfaces in " + f.getName() );

		for (Interface i : f.getInterfaces())
		{
			if ( ! i.isIsProvidedInterface())
			{
				continue;
			}

			if (i.getInterfaceType() == Constants.INTERFACE_CYCLIC_INDEX)
			{
				ret += "\tprocedure "+ f.getName() + "_" + i.getName() + "\n;";
				ret += "\n";
			}

			if (i.getInterfaceType() == Constants.INTERFACE_SPORADIC_INDEX)
			{
				ret += "\tprocedure "+ f.getName() + "_" + i.getName()+"(";
				ret += getInterfaceParametersLanguageAda (i);
				ret += ")";
				ret += "\n";
				ret += "\n";
				ret += "pragma export(C, " + f.getName() + "_" + i.getName() + " , \""+f.getName() + "_PI_" + i.getName() + "\");";
			}
		}
		ret += "end " + f.getName() + ";";
		ret += "\n";
		ret += "\n";
		return ret;
	}


	private static String getSourceContentForFunctionLanguageAda(Function f) 
	{
		System.out.println ("[Utils] Get content for function " + f.getName() );

		String ret = "";
		ret += "pragma style_checks (off);";
		ret += "\n";
		ret += "pragma warnings (off);";
		ret += "\n";
		ret += "with adaasn1rtl;";
		ret += "\n";
		ret += "use adaasn1rtl;";
		ret += "\n";
		ret += "\n";

		ret += "with dataview;";
		ret += "\n";
		ret += "use dataview;";
		ret += "\n";

		ret += "package body " + f.getName() + " is";
		ret += "\n";

		ret += "\n";
		ret += "\tprocedure " + f.getName() + "_startup is";
		ret += "\n";
		ret += "\tbegin";
		ret += "\n";
		ret += "\t\t-- Write initialization code here";
		ret += "\n";
		ret += "\tend " + f.getName() + "_startup;";
		ret += "\n";
		ret += "\n";

		System.out.println ("[Utils] Look for provided and cyclic interfaces in " + f.getName() );

		for (Interface i : f.getInterfaces())
		{
			if ( ! i.isIsProvidedInterface())
			{
				continue;
			}

			if (i.getInterfaceType() == Constants.INTERFACE_CYCLIC_INDEX)
			{
				ret += "\tprocedure "+ f.getName() + "_" + i.getName();
				ret += "\n";
				ret += "\tbegin";
				ret += "\n";
				ret += "\t\tnull;";
				ret += "\n";
				ret += "\t\t   -- Write interface code here";
				ret += "\n";
				ret += "\tend "+ i.getName() + ";";
				ret += "\n";
			}

			if (i.getInterfaceType() == Constants.INTERFACE_SPORADIC_INDEX)
			{
				ret += "\tprocedure "+f.getName() + "_" + i.getName()+"(";
				ret += getInterfaceParametersLanguageAda (i);
				ret += ") is";
				ret += "\n";
				ret += "\tbegin";
				ret += "\n";
				ret += "\t\tnull;";
				ret += "\n";
				ret += "\t\t   -- Write interface code here";
				ret += "\n";
				ret += "\tend "+ i.getName() + ";";
				ret += "\n";
			}
		}
		ret += "end " + f.getName() + ";";
		ret += "\n";
		ret += "\n";
		return ret;
	}

	private static String getInterfaceParametersLanguageAda(Interface i) 
	{
		boolean hasParameters = false;
		String ret = "";

		for ( InterfaceParameter p : i.getParameters())
		{
			if (hasParameters)
			{
				ret += "; ";
			}
			hasParameters = true;
			ret += p.getName();
			ret += ": access asn1scc" + p.getType();		
		}
		return ret;
	}


	private static String getSourceContentForFunctionLanguageC(Function f) 
	{
		System.out.println ("[Utils] Get content for function " + f.getName() );

		String ret = "";
		//ret += "#include <"+f.getName()+".h>";
		ret += "#include \"C_ASN1_Types.h\"";
		ret += "\n";
		ret += "\n";
		ret += "void " + f.getName() + "_startup()";
		ret += "\n";
		ret += "{";
		ret += "\n";
		ret += "   /* Write initialization code here */";
		ret += "\n";
		ret += "}";
		ret += "\n";
		ret += "\n";

		System.out.println ("[Utils] Look for required interfaces in " + f.getName() );

		for (Interface i : f.getInterfaces())
		{
			System.out.println ("[Utils] Function " + f.getName() + " has interface " + i.getName() );

			if ( ! i.isIsProvidedInterface())
			{
				System.out.println ("[Utils] Function " + f.getName()  + " has the required interface " + i.getName());

				EList <InterfaceConnection> ics = i.getConnections();
				if (ics.size() <= 0)
				{
					continue;
				}
				else
				{
					System.out.println ("[Utils] Size of connection list to zero");
				}

				for (int k = 0 ; k < ics.size() ; k++)
				{
					InterfaceConnection ic = ics.get(k);
					Interface provided = ic.getProvidedInterface();
					if (provided != null)
					{
						System.out.println ("[Utils] Required interface " + i.getName()  + " connected to the following provided " + provided.getName());
						ret += "extern void " + f.getName() + "_RI_"+ i.getName()+"(";
						ret += getInterfaceParametersLanguageC (provided);
						ret += ");\n\n";
					}
					else
					{
						System.out.println ("[Utils] Required interface " + i.getName()  + " NOT connected");
					}
				}

			}
		}


		System.out.println ("[Utils] Look for provided and cyclic interfaces in " + f.getName() );

		for (Interface i : f.getInterfaces())
		{
			if ( ! i.isIsProvidedInterface())
			{
				continue;
			}
			System.out.println ("[Utils] Generate provided interface" + i.getName() + " type=" + i.getInterfaceType() );

			if (i.getInterfaceType() == Constants.INTERFACE_CYCLIC_INDEX)
			{
				ret += "void " + f.getName() + "_PI_"+i.getName()+"()";
				ret += "\n";
				ret += "{";
				ret += "\n";
				ret += "   /* Write interface code here */";
				ret += "\n";
				ret += "}";
				ret += "\n";
			}

			if (i.getInterfaceType() == Constants.INTERFACE_SPORADIC_INDEX)
			{
				ret += "void " + f.getName() + "_PI_"+i.getName()+"(";
				ret += getInterfaceParametersLanguageC (i);
				ret += ")";
				ret += "\n";
				ret += "{";
				ret += "\n";
				ret += "   /* Write interface code here */";
				ret += "\n";
				ret += "}";
				ret += "\n";
			}
		}
		return ret;
	}


	public static IFile getFunctionFile(Function f)
	{
		IFolder skeletonsFolder = null;
		IFolder functionFolder = null;
		String fileName = null;

		skeletonsFolder = getActiveProject().getFolder("skeletons");
		if( ! skeletonsFolder.exists())
		{
			System.out.println ("[Utils] ERROR: " + skeletonsFolder.toString() + " does not exist");

			try {
				skeletonsFolder.create(true, true, null);
			} catch (CoreException e) {
				System.out.println ("[Utils] exception when trying to create skeletons folder");
				e.printStackTrace();
			}
		}

		functionFolder = skeletonsFolder.getFolder(f.getName());
		if( ! functionFolder.exists())
		{
			System.out.println ("[Utils] ERROR: " + functionFolder.toString() + " does not exist");

			try {
				functionFolder.create(true, true, null);
			} catch (CoreException e) {
				System.out.println ("[Utils] exception when trying to create function folder" + f.getName());
				e.printStackTrace();
			}
		}


		fileName = f.getName() + ".c";

		if (f.getLanguage().toLowerCase().equals ("c"))
		{
			fileName = f.getName() + ".c";
		}
		if (f.getLanguage().toLowerCase().equals ("ada"))
		{
			fileName = f.getName() + ".adb";
		}


		IFile functionFile = functionFolder.getFile (fileName);
		if ( ! functionFile.exists())
		{
			System.out.println ("[Utils] ERROR: " + functionFile.toString() + " does not exist");
		}
		return functionFile;
	}

	public static void retrieveFunctionsNames (ContainerShape shape, Vector<String> v)
	{
		for (int i = 0 ; i < shape.getChildren().size() ; i++)
		{
			if (shape.getChildren().get(i) instanceof ContainerShape)
			{
				ContainerShape di = (ContainerShape)shape.getChildren().get(i);
				Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(di);

				if (bo == null)
				{
					System.out.println("[Utils] bo null");
				}
				else
				{
					if (bo instanceof Function)
					{
						v.add (((Function)bo).getName());
					}
				}
				retrieveFunctionsNames (di, v);
			}
		}
	}

	public static void retrieveFunctions (ContainerShape shape, Vector<Function> v)
	{
		for (int i = 0 ; i < shape.getChildren().size() ; i++)
		{
			if (shape.getChildren().get(i) instanceof ContainerShape)
			{
				ContainerShape di = (ContainerShape)shape.getChildren().get(i);
				Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(di);

				if (bo == null)
				{
					System.out.println("[Utils] bo null");
				}
				else
				{
					if (bo instanceof Function)
					{
						System.out.println("[Utils] add " + ((Function)bo).getName() + " to the vector");

						v.add (((Function)bo));

					}
				}
				retrieveFunctions (di, v);
			}
		}
	}

	public static String[] GetFunctionNames(IProject project)
	{
		System.out.println("[NavigatorCommands] call GetFunctionNames");
		String[] ret;
		Vector<String> v = new Vector<String>();

		if (project != null)
		{
			Diagram diag = null;
			diag = Utils.loadDiagram(project);


			Utils.retrieveFunctionsNames (diag, v);
			ret = new String[v.size()];
			for (int i = 0 ; i < v.size() ; i++)
			{
				System.out.println("[NavigatorCommands] found function " + v.get(i));

				ret[i] = v.get(i);
			}
			return ret;
		}
		return new String[]{"func1", "func2"};
	}

	public static Function[] getFunctions(IProject project)
	{
		System.out.println("[NavigatorCommands] call GetFunctions");
		Function[] ret;
		Vector<Function> v = new Vector<Function>();

		if (project != null)
		{
			Diagram diag = null;
			diag = Utils.loadDiagram(project);

			System.out.println("[Utils] diagram =  " + diag);
			if (diag == null)
			{
				System.out.println("[Utils] NULL DIAGRAM)");

			}
			else
			{
				Utils.retrieveFunctions (diag, v);
				ret = new Function[v.size()];
				for (int i = 0 ; i < v.size() ; i++)
				{
					System.out.println("[Utils] found function " + v.get(i));
	
					ret[i] = v.get(i);
				}
				return ret;
			}
		}
		return new Function[]{};
	}


	public static Function getFunctionObject(String action) 
	{
		Diagram diag = loadDiagram(getActiveProject());
		Vector<Function> v = new Vector<Function>();
		retrieveFunctions(diag, v);
		for (Function f : v)
		{
			if (f.getName().equals(action))
			{
				return f;
			}
		}
		return null;
	}


	public static void showError (String msg, String explain)
	{
		String msglong;
		if (explain != null)
		{
			msglong = explain;
		}
		else
		{
			msglong = msg;
		}
		IStatus status = new Status(IStatus.ERROR, Activator.PLUGIN_ID,  msg);
		ErrorDialog.openError(Activator.getDefault().getWorkbench().getActiveWorkbenchWindow().getShell(),msglong, null,status);
	}
	
	public static void showError (String msg)
	{
		showError(msg, msg);
	}

	public static String getWorkSpaceDirectory ()
	{
		IWorkspace workspace = ResourcesPlugin.getWorkspace();  

		File workspaceDirectory = workspace.getRoot().getLocation().toFile();
		return workspaceDirectory.toString();
	}

	public static String getCurrentTasteProjectPath ()
	{
		IProject activeProject = null;

		activeProject = getActiveProject();
		if (activeProject == null)
		{
			return null;
		}

		String directory = getWorkSpaceDirectory() +  "/" + activeProject.getName();
		return directory;
	}

	public static String getProjectPath (IProject project)
	{
		IWorkspace workspace = ResourcesPlugin.getWorkspace();  

		File workspaceDirectory = workspace.getRoot().getLocation().toFile();
		String directory = workspaceDirectory.toString() + "/" + project.getName();
		return directory;
	}


	public static boolean exportCurrentProject (String exportFile)
	{
		IProject currentProject = Utils.getActiveProject();
		if (currentProject == null)
		{
			Utils.showError("Project not selected, please select one in the navigator", "Please select a project in the navigator");
			return false;
		}
		return exportProject (currentProject, exportFile);
	}


	public static void createBuildScript (IProject project)
	{

		IProgressMonitor monitor = new NullProgressMonitor(); 
		IFile file = project.getFile("build-script.sh");
		String toWrite = "#!/bin/sh";
		toWrite += "\n";
		toWrite += "\n";

		Function[] functions = getFunctions(project);
		for (int i = 0 ; i < functions.length ; i++)
		{
			Function f = functions[i];
			toWrite += "( cd skels ; rm -f " + f.getName() + ".zip ; zip " + f.getName() + " " + f.getName() + "/* )";
			toWrite += "\n";
		}
		toWrite += "\n";
		toWrite += "[ ! -z \"$CLEANUP\" ] && rm -rf binary";
		toWrite += "\n";
		toWrite += "\n";
		toWrite += "assert-builder-ocarina.py --no-retry -f -g -p --aadlv2 --keep-case --interfaceView interfaceview.aadl  --deploymentView deploymentview.aadl -o binary";

		for (int i = 0 ; i < functions.length ; i++)
		{
			Function f = functions[i];
			if (f.getLanguage().toLowerCase().equals("c"))
			{
				toWrite += " --subC " + f.getName()+":skels/" + f.getName() + ".zip";
			}
			if (f.getLanguage().toLowerCase().equals("ada"))
			{
				toWrite += " --subAda " + f.getName()+":skels/" + f.getName() + ".zip";
			}
		}

		PipedInputStream in = new PipedInputStream();

		PipedOutputStream out;

		try {
			out = new PipedOutputStream(in);



			out.write(toWrite.getBytes());

			out.close();

			if (! file.exists())
			{
				System.out.println ("[Utils] Create file " + file);

				file.create(in, true, monitor);
			}
			else
			{
				System.out.println ("[Utils] Set file contents " + file);

				file.setContents(in, true, true, monitor);

			}

			file.refreshLocal(0, monitor);
		} catch (IOException e) 
		{
			System.out.println ("[Utils] Exception raised when writing build-script");
			e.printStackTrace();
		}
		catch (CoreException e) 
		{
			System.out.println ("[Utils] Exception raised when writing build-script");

			e.printStackTrace();
		}

	}

	public static boolean isValidProject (IProject project)
	{
		IFile tmp;
		tmp = project.getFile("models/architecture.diagram");
		if (! tmp.exists())
		{
			System.out.println ("[Utils] Invalid project, following file is missing: " + tmp.getName()+ ";" + tmp.getFullPath());
			return false;
		}
		tmp = project.getFile("models/interfaceview.aadl2");
		if (! tmp.exists())
		{
			System.out.println ("[Utils] Invalid project, following file is missing: " + tmp.getName() + ";" + tmp.getFullPath());
			return false;
		}
		tmp = project.getFile("models/deploymentview.aadl2");
		if (! tmp.exists())
		{
			System.out.println ("[Utils] Invalid project, following file is missing: " + tmp.getName()+ ";" + tmp.getFullPath());
			return false;
		}
		tmp = project.getFile("dataview/dataview.asn");
		if (! tmp.exists())
		{
			System.out.println ("[Utils] Invalid project, following file is missing: " + tmp.getName()+ ";" + tmp.getFullPath());
			return false;
		}
		return true;
	}

	public static boolean isNameValid (String name)
	{
		if (name.matches("[a-zA-Z0-9]+"))
		{
			return true;
		}
		return false;
	}
	
	
	public static boolean exportProject (IProject project, String exportFile)
	{
		return exportProject (project, exportFile, true);
	}
	
	public static boolean exportProject (IProject project, String exportFile, boolean mustValidate)
	{
		if (mustValidate)
		{
			ModelValidation validation;

			validation = new ModelValidation (loadDiagram(project));

			if ( ! validation.validate())
			{
				String err = "Cannot export the project, design has the following error: " + validation.getReason();
				Utils.showError(err , err);
				return false;
			}
		}
		
		DeploymentViewGeneration.generate (project);
		InterfaceViewGeneration.generate (project);
		try {
			project.getFile("models").refreshLocal(IResource.DEPTH_INFINITE, null);
			project.refreshLocal(IResource.DEPTH_INFINITE, null);
		} catch (CoreException e1) {
			System.out.println("[GenerateProject] Error when refreshing project " + project.getName());
			e1.printStackTrace();
		}
		System.out.println("[GenerateProject] File selected to export project: " + exportFile);

		if ( ! isValidProject (project))
		{
			Utils.showError("Project Export Error, some files are missing", "");

			return false;
		}

		IProject currentProject = Utils.getActiveProject();
		createBuildScript(project);
		String[] in_filenames = new String[]{"dataview/dataview.asn",
				"dataview/dataview.aadl",
				"models/interfaceview.aadl2",
				"models/deploymentview.aadl2",
				"build-script.sh",
		"models/architecture.diagram"};
		String[] out_filenames = new String[]{"dataview.asn",
				"dataview.aadl",
				"interfaceview.aadl",
				"deploymentview.aadl",
				"build-script.sh",
		        "architecture.diagram"};

		// Create a buffer for reading the files
		byte[] buf = new byte[1024];

		try {
			// Create the ZIP file
			String outFilename = exportFile;
			ZipOutputStream out = new ZipOutputStream(new FileOutputStream(outFilename));

			// Compress the files
			for (int i=0; i<in_filenames.length; i++) {
				String tmpName = Utils.getCurrentTasteProjectPath() + "/" + in_filenames[i];
				File f = new File (tmpName);
				if ( ! f.exists())
				{
					continue;
				}
				FileInputStream in = new FileInputStream(tmpName);

				// Add ZIP entry to output stream.
				out.putNextEntry(new ZipEntry(out_filenames[i]));

				// Transfer bytes from the file to the ZIP file
				int len;
				while ((len = in.read(buf)) > 0) {
					out.write(buf, 0, len);
				}

				// Complete the entry
				out.closeEntry();
				in.close();
			}

			Function functions[] = Utils.getFunctions(currentProject);
			for (int i = 0 ; i < functions.length ; i++)
			{
				Function currentFunction = functions[i];
				String inFile;
				String outFile;
				File funcDir;
				File ftmp;
				String functionDirectory = Utils.getCurrentTasteProjectPath() + "/skeletons/" + currentFunction.getName();
				funcDir = new File(functionDirectory);
				if (! funcDir.exists())
				{
					continue;
				}
				String[] functionFiles = funcDir.list();
				for (int j = 0 ; j < functionFiles.length ; j++)
				{
					inFile = functionDirectory + "/" + functionFiles[j];
					outFile = "skels/"+currentFunction.getName() + "/" + functionFiles[j];
					
					ftmp = new File (inFile);
					if (! ftmp.isDirectory())
					{
						FileInputStream in = new FileInputStream(inFile);
	
						// Add ZIP entry to output stream.
						out.putNextEntry(new ZipEntry(outFile));
	
						// Transfer bytes from the file to the ZIP file
						int len;
						while ((len = in.read(buf)) > 0) {
							out.write(buf, 0, len);
						}
	
						// Complete the entry
						out.closeEntry();
						in.close();
					}
					else
					{
						String[] lst = ftmp.list();
						String inFile2;
						String outFile2;
						for (int k = 0 ; k < lst.length ; k++)
						{
							inFile2 = inFile + "/" + lst[k];
							outFile2 = outFile  + "/" + lst[k];

							File ftmp2 = new File (inFile2);
							if (! ftmp2.isDirectory())
							{
								System.out.println ("Add to zip" + inFile2);
								FileInputStream in2 = new FileInputStream(inFile2);

								// Add ZIP entry to output stream.
								out.putNextEntry(new ZipEntry(outFile2));

								// Transfer bytes from the file to the ZIP file
								int len;
								while ((len = in2.read(buf)) > 0) {
									out.write(buf, 0, len);
								}

								// Complete the entry
								out.closeEntry();
								in2.close();
							}
						}
					}
				}
			}

			// Complete the ZIP file
			out.close();
		}
		catch (IOException e) {
		}

		return true;
	}


	public static Board getBoard(Interface tmpif)
	{
		return (tmpif.getAssociatedFunction().getAssociatedBoard());
		
	}


	public static Bus getBoundBus(Interface tmpif) {
		Board ifBoard = getBoard (tmpif);
		InterfaceConnection ifConnection;
		System.out.println ("[Utils] Search bus bound to interface " + tmpif.getName());
		if (ifBoard == null)
		{
			System.out.println ("[Utils] corresponding board is null");
			return null;
		}
		ifConnection = tmpif.getConnections().get(0);
		if (ifConnection == null)
		{
			return null;
		}
		
		if (ifConnection.getAssociatedBus() == null)
		{
			return null;
		}
		
		for (Driver drv : ifBoard.getDrivers())
		{
			System.out.println ("[Utils] Search on driver " + drv.getName());
			for ( BusConnection bc : drv.getConnections())
			{
				if ( (bc.getAssociatedBus() != null) &&
				     (bc.getAssociatedBus().getName().toLowerCase().equals(ifConnection.getAssociatedBus().getName().toLowerCase())))
				{
					System.out.println ("[Utils] Found bus: " + bc.getAssociatedBus().getName());
					return bc.getAssociatedBus();
				}	
			}
		}
		return null;
	}


	public static Bus getDefaultBus(Board boardSource) 
	{
		System.out.println ("[Utils] Search default bus for board " + boardSource.getName());
		for (Driver d : boardSource.getDrivers())
		{
			System.out.println ("[Utils] Search on driver " + d.getName());
			for (BusConnection bc : d.getConnections())
			{
				
				if (bc.getAssociatedBus() != null)
				{
					System.out.println ("[Utils] Default bus found: " + bc.getAssociatedBus().getName());
					return bc.getAssociatedBus();
				}
			}
		}
		return null;
	}
	
	
    public static IProject getWorkspaceProjectFromEObject(EObject eobject) {
        URI uri = EcoreUtil.getURI( eobject );
        uri = uri.trimFragment();
        // remove "platform:..." from uri
        if (uri.isPlatform()) {
            uri = URI.createURI( uri.toPlatformString( true ) );
        }

        IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
        IProject project = null;

        // try to get project from whole uri resource
        IResource resource = workspaceRoot.findMember( uri.toString() );
        if (resource != null) {
            project = resource.getProject();
        }

        // another try,by first segment with project name
        if (project == null && uri.segmentCount() > 0) {
            String projectName = uri.segment( 0 );
            IResource projectResource = workspaceRoot.findMember( projectName );
            if (projectResource != null) {
                project = projectResource.getProject();
            }
        }

        return project;   
 }


    public static Tasted getTastedServer ()
    {
    	if (tastedServer == null)
    	{
    		tastedServer = new Tasted();
    	}
    	return tastedServer;
    }
    
}