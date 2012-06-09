package nl.esa.tec.swe.taste.commands;


import nl.esa.tec.swe.taste.metamodel.taste.Function;
import nl.esa.tec.swe.taste.utils.*;

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
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.eclipse.ui.handlers.HandlerUtil;
public class GenerateCodeSkeletons extends AbstractHandler implements IWorkbenchWindowActionDelegate {

	public Object execute(ExecutionEvent event) throws ExecutionException {
		System.out.println("[GenerateCodeSkeletons] call execute in GenerateCodeSkeletons");
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
		System.out.println("[GenerateCodeSkeletons] call run in GenerateCodeSkeletons");
		IProject currentProject = Utils.getActiveProject();
		int generate = 1;
		int result;
		
		if (currentProject == null)
		{
			Utils.showError("Project not selected, please select one in the navigator", "Please select a project in the navigator");
			return;
		}
		
		Function[] funcs = Utils.getFunctions(currentProject);
		for (int i = 0 ; i < funcs.length ; i++)
		{
			generate = 1;
			IFile mainFile = Utils.getFunctionFile(funcs[i]);
			
			if (mainFile.exists())
			{
			   MessageDialog dialog = new MessageDialog(
					      null, "Code already exists", null, "Code for function " + funcs[i].getName() + " already exists, do you want to overwrite the current file ?",
					      MessageDialog.QUESTION,
					      new String[] {"Yes", "No"},
					      1);
			   result = dialog.open();
			   if (result == 1)
			   {
				   generate = 0;
			   }
			}
			if (generate == 1)
			{
				Utils.createFunctionSkeleton(funcs[i]);
			}
		}
	}


	public void selectionChanged(IAction action, ISelection selection) {
		System.out.println("[GenerateCodeSkeletons] call selectionChanged in GenerateCodeSkeletons");
		
	}


	public void init(IWorkbenchWindow window) {
		System.out.println("[GenerateCodeSkeletons] call init in GenerateDataView");
		
	}

}
