package nl.esa.tec.swe.taste.commands;


import nl.esa.tec.swe.taste.main.Activator;
import nl.esa.tec.swe.taste.main.DataViewWrapper;
import nl.esa.tec.swe.taste.main.ProcessExecutor;
import nl.esa.tec.swe.taste.utils.*;
import nl.esa.tec.swe.taste.views.NavigatorLabel;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import java.io.*;
import java.util.Map;

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
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.views.navigator.ResourceNavigator;
public class TastedGenerateDataview extends AbstractHandler implements IWorkbenchWindowActionDelegate {

	public Object execute(ExecutionEvent event) throws ExecutionException {

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
		System.out.println("[TastedBuild] call run");
		
		IProject activeProject = null;

		activeProject = Utils.getActiveProject();
		
		if (activeProject == null)
		{
			Utils.showError("Project not selected, please select one in the navigator", "Please select a project in the navigator");
			return;
		}
		
		System.out.println("[TastedBuild] current project name" + activeProject.getName());
		
		TastedThread builder = new TastedThread(activeProject, true, false, false);
		
		BusyIndicator.showWhile(Activator.getDefault().getWorkbench().getDisplay(), builder);
		
	}


	public void selectionChanged(IAction action, ISelection selection) {
		System.out.println("[TastedBuild] call selectionChanged");
		
	}


	public void init(IWorkbenchWindow window) {
		System.out.println("[TastedBuild] call init");
		
	}

}
