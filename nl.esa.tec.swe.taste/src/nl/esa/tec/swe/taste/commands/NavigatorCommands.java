package nl.esa.tec.swe.taste.commands;

import java.util.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import nl.esa.tec.swe.taste.graphic.properties.Constants;
import nl.esa.tec.swe.taste.metamodel.taste.Function;
import nl.esa.tec.swe.taste.views.NavigatorLabel;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.core.internal.resources.Project;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.QualifiedName;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.eclipse.ui.handlers.HandlerUtil;

public class NavigatorCommands extends AbstractHandler implements IWorkbenchWindowActionDelegate {
	public final static int COMMAND_UNKNOWN               		= 0;
	public final static int COMMAND_EDIT_DATAVIEW         		= 1;
	public final static int COMMAND_EDIT_ARCHITECTURE     		= 2;
	public final static int COMMAND_VIEW_FUNCTIONAL_CODE  		= 3;
	public static final int COMMAND_EDIT_FUNCTION         		= 4;
	public static final int COMMAND_EDIT_FUNCTION_FILE    		= 4;
	public static final int COMMAND_EDIT_DATAVIEW_C_SOURCE 		= 10;
	public static final int COMMAND_EDIT_DATAVIEW_C_HEADER 		= 11;
	public static final int COMMAND_EDIT_DATAVIEW_ADA_SOURCE 	= 12;
	public static final int COMMAND_EDIT_DATAVIEW_ADA_HEADER 	= 13;
	
	
	public static final int COMMAND_VIEW_BINARIES   	        = 50;

	
	


	public Object execute(ExecutionEvent event) throws ExecutionException {
		System.out.println("[NavigatorCommands] call execute in NavigatorCommands");
		return null;
	}
	
	protected String getPersistentProperty(IResource res, QualifiedName qn) {
		try {
			return res.getPersistentProperty(qn);
		} catch (CoreException e) {
			return "";
		}
	}
	
	
	public void run(IAction action) {
		System.out.println("[NavigatorCommands] call run in NavigatorCommands");
		
	}


	public void selectionChanged(IAction action, ISelection selection) {
		System.out.println("[NavigatorCommands] call selectionChanged in NavigatorCommands");
		if (action != null)
		{
			System.out.println("action" + action);
		}
		if (selection != null)
		{
			System.out.println("[NavigatorCommands] selection" + selection);			
			System.out.println("[NavigatorCommands] selection class" + selection.getClass().toString());
			if (TreeSelection.class.isInstance(selection))
			{
				TreeSelection ts = (TreeSelection) selection;
				Object o = ts.getFirstElement();
				if (o instanceof NavigatorLabel)
				{
					NavigatorLabel nl = (NavigatorLabel)o;
					switch (nl.getCommandId())
					{
						case NavigatorCommands.COMMAND_EDIT_ARCHITECTURE:
							IFolder diagramFolder = nl.getProject().getFolder("models");
							if( ! diagramFolder.exists())
							{
								System.out.println ("ERROR: " + diagramFolder.toString() + " does not exist");
								return;
							}
							IFile diagramFile = diagramFolder.getFile ("architecture.diagram");
							if ( ! diagramFile.exists())
							{
								System.out.println ("ERROR: " + diagramFile.toString() + " does not exist");
								return;
							}
							else
							{
								System.out.println ("EDIT: " + diagramFile.toString() + " diagram");


								
							}
							
							break;
					}
					if (nl.getAction().equals("Functional code"))
					{
						try {
							System.out.println ("Try to refresh project");

							(nl.getProject()).refreshLocal(IResource.DEPTH_INFINITE, null);
							Utils.refreshNavigator();

						} catch (CoreException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					System.out.println("[NavigatorCommands] click on " + nl.getAction());
					System.out.println("[NavigatorCommands] project  " + nl.getProject().getName());

				}
			}


		}	

	}


	public void init(IWorkbenchWindow window) {
		System.out.println("[NavigatorCommands] call init in NavigatorCommands");
		
	}

	public static int InterfaceNameToType(String selectedProperty) {
		System.out.println("[NavigatorCommands] InterfaceNameToType with " + selectedProperty);

		if (selectedProperty.toLowerCase().equals("sporadic"))
			return Constants.INTERFACE_SPORADIC_INDEX;
		if (selectedProperty.toLowerCase().equals("cyclic"))
			return Constants.INTERFACE_CYCLIC_INDEX;
		if (selectedProperty.toLowerCase().equals("protected"))
			return Constants.INTERFACE_PROTECTED_INDEX;
		if (selectedProperty.toLowerCase().equals("unprotected"))
			return Constants.INTERFACE_UNPROTECTED_INDEX;
		return 0;
	}

	public static String InterfaceTypeToName(int interfaceType) {
		System.out.println("[NavigatorCommands] InterfaceTypeToName with " + interfaceType);
		switch (interfaceType)
		{
		case Constants.INTERFACE_SPORADIC_INDEX:
			return "Sporadic";
		case Constants.INTERFACE_CYCLIC_INDEX:
			return "Cyclic";
		case Constants.INTERFACE_PROTECTED_INDEX:
			return "Protected";
		case Constants.INTERFACE_UNPROTECTED_INDEX:
			return "Unprotected";
		}
		return "Unknown";
	}

}
