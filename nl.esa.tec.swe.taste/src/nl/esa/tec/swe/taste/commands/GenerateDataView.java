package nl.esa.tec.swe.taste.commands;


import nl.esa.tec.swe.taste.main.Activator;
import nl.esa.tec.swe.taste.main.DataViewWrapper;
import nl.esa.tec.swe.taste.utils.*;
import nl.esa.tec.swe.taste.views.NavigatorLabel;
import nl.esa.tec.swe.taste.wizard.preferences.PreferencesHelper;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import java.io.*;

import org.eclipse.core.commands.*;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.QualifiedName;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.views.navigator.ResourceNavigator;
public class GenerateDataView extends AbstractHandler implements IWorkbenchWindowActionDelegate {

	public Object execute(ExecutionEvent event) throws ExecutionException {
		System.out.println("[GenerateDataView] call execute in GenerateDataView");
		IStructuredSelection selection = (IStructuredSelection) HandlerUtil.getActiveMenuSelection(event);
		if (! PreferencesHelper.generateDataViewWithCommand())
		{
			Utils.showError("DataView generation method cannot be used with this action");
			return null;
		}
		
		Object firstElement = selection.getFirstElement();
		if (firstElement instanceof IFile) {
			IFile f = (IFile) firstElement;
		    //get object which represents the workspace  
		    IWorkspace workspace = ResourcesPlugin.getWorkspace();  
		   
		    //get location of workspace (java.io.File)  
		    File workspaceDirectory = workspace.getRoot().getLocation().toFile();

			String inputFile = workspaceDirectory.toString() + f.getFullPath().toString();
			String outputFile = workspaceDirectory.toString()  + f.getParent().getFullPath().toString() + "/dataview.aadl";
			if (Platform. getOS().equals(Platform.OS_WIN32))
			{
				inputFile = inputFile.replace('/', '\\');
				outputFile = outputFile.replace('/', '\\');
			}
			else
			{
				inputFile = inputFile.replace('\\', '/');
				outputFile = outputFile.replace('\\', '/');
			}
			System.out.println("[GenerateDataView] input asn file  : " + inputFile);
			System.out.println("[GenerateDataView] output aadl file: " + outputFile);
			DataViewWrapper.doConversionLocal(inputFile, outputFile);
		
			try {
				f.getProject().refreshLocal(IResource.DEPTH_INFINITE, null);
			} catch (CoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
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
		System.out.println("[GenerateDataView] call run in GenerateDataView");
		
		IProject activeProject = null;

		activeProject = Utils.getActiveProject();
		
		if (activeProject == null)
		{
			Utils.showError("Project not selected, please select one in the navigator", "Please select a project in the navigator");
			return;
		}
		
		System.out.println("[GenerateDataView] current project name" + activeProject.getName());
		DataViewWrapper.generateDataView(activeProject, true);

	}


	public void selectionChanged(IAction action, ISelection selection) {
		System.out.println("[GenerateDataView] call selectionChanged in GenerateDataView");
		
	}


	public void init(IWorkbenchWindow window) {
		System.out.println("[GenerateDataView] call init in GenerateDataView");
		
	}

}
