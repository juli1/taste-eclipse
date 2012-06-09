package nl.esa.tec.swe.taste.commands;


import nl.esa.tec.swe.taste.graphic.properties.Constants;
import nl.esa.tec.swe.taste.main.Activator;
import nl.esa.tec.swe.taste.metamodel.taste.Board;
import nl.esa.tec.swe.taste.metamodel.taste.Bus;
import nl.esa.tec.swe.taste.metamodel.taste.BusConnection;
import nl.esa.tec.swe.taste.metamodel.taste.Driver;
import nl.esa.tec.swe.taste.metamodel.taste.Function;
import nl.esa.tec.swe.taste.metamodel.taste.Interface;
import nl.esa.tec.swe.taste.metamodel.taste.InterfaceConnection;
import nl.esa.tec.swe.taste.metamodel.taste.InterfaceParameter;
import nl.esa.tec.swe.taste.utils.*;
import nl.esa.tec.swe.taste.views.NavigatorLabel;

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
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.impl.DiagramImpl;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.editor.DiagramEditorInput;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchWindow;
import java.net.*;
import java.util.Vector;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.eclipse.ui.views.navigator.ResourceNavigator;
public class GenerateProject extends AbstractHandler implements IWorkbenchWindowActionDelegate {



	public Object execute(ExecutionEvent event)
	{
		System.out.println("[GenerateProject] call execute");

		FileDialog fd = new FileDialog(Activator.getDefault().getWorkbench().getActiveWorkbenchWindow().getShell(), SWT.SAVE);
		fd.setText("Export TASTE project");

		String[] filterExt = { "*.zip", "*.*" };
		fd.setFilterExtensions(filterExt);
		String selected = fd.open();
		Utils.exportCurrentProject(selected);
		return null;
	}



	protected String getPersistentProperty(IResource res, QualifiedName qn) {
		System.out.println("[GenerateProject] call getPersistentProperty");
		return null;
	}


	public void run(IAction action) {
		System.out.println("[GenerateProject] call run");

		FileDialog fd = new FileDialog(Activator.getDefault().getWorkbench().getActiveWorkbenchWindow().getShell(), SWT.SAVE);
		fd.setText("Export TASTE project");

		String[] filterExt = { "*.zip", "*.*" };
		fd.setFilterExtensions(filterExt);
		String selected = fd.open();
		Utils.exportCurrentProject(selected);
	}


	public void selectionChanged(IAction action, ISelection selection) 
	{
		System.out.println("[GenerateProject] call selectionChanged");
	}


	public void init(IWorkbenchWindow window) 
	{
		System.out.println("[GenerateProject] call init");
	}

}
