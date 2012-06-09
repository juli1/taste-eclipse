package nl.esa.tec.swe.taste.views;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import nl.esa.tec.swe.taste.commands.NavigatorCommands;
import nl.esa.tec.swe.taste.commands.Utils;
import nl.esa.tec.swe.taste.main.DataViewWrapper;
import nl.esa.tec.swe.taste.metamodel.taste.Function;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkingSetManager;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.eclipse.ui.navigator.CommonNavigator;
import org.eclipse.ui.views.navigator.ResourceComparator;
import org.eclipse.ui.views.navigator.ResourceNavigator;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.eclipse.ui.views.navigator.ResourceComparator;
import org.eclipse.ui.views.navigator.ResourceNavigator;

public class Navigator extends ResourceNavigator implements IResourceChangeListener, ISelectionChangedListener {

	public Navigator() {
		super();
		System.out.println("[Navigator] Called navigator builder");

	} 

	private String lastResourceName = "";

	public void createPartControl(Composite parent)
	{
		System.out.println("[Navigator] called createpartcontrol");
		super.createPartControl(parent);
		ResourcesPlugin.getWorkspace().addResourceChangeListener(this);
		this.addListenerObject(this);
	}

	public void dispose()
	{
		ResourcesPlugin.getWorkspace().removeResourceChangeListener(this);
		super.dispose();
	}
	
	protected void initContentProvider(TreeViewer viewer)
	{
		viewer.setContentProvider(new NavigatorContentProvider());
	}
	
	protected void initLabelProvider(TreeViewer viewer)
	{
		viewer.setLabelProvider
		(new NavigatorLabelProvider(
				new WorkbenchLabelProvider(), getPlugin().getWorkbench().getDecoratorManager().getLabelDecorator()));
		viewer.addSelectionChangedListener(this);
	}
	
	protected void initResourceComparator()
	{
		System.out.println("[Navigator] called initresourcecomparator");

		super.initResourceComparator();
		setComparator(
				new ResourceComparator(getComparator().getCriteria())
				{
					public int compare(Viewer viewer, Object o1, Object o2)
					{					
						System.out.println("[Navigator] called compare in resourcecomparator , o1=" + o1 + ";o2=" + o2 );
						if (  (o1 instanceof NavigatorLabel) && (o2 instanceof NavigatorLabel) )
						{
							NavigatorLabel nl1 = (NavigatorLabel) o1;
							NavigatorLabel nl2 = (NavigatorLabel) o2;
							if (nl2.getProject() == nl1.getProject())
							{
								return nl1.getCommandId() - nl2.getCommandId();
							}
						}

						return super.compare(viewer, o1, o2);
						/*
						if (o1 instanceof IProject && ((IProject)o1).getName().equals(OsateResourceUtil.PLUGIN_RESOURCES_DIRECTORY_NAME))
							return 1;
						else if (o2 instanceof IProject &&
								((IProject)o2).getName().equals(OsateResourceUtil.PLUGIN_RESOURCES_DIRECTORY_NAME))
						{
							return -1;
						}
						else
					}*/
					}
				});
	}
	
	protected void initFilters(TreeViewer viewer)
	{
		super.initFilters(viewer);
		
		viewer.addFilter(
				new ViewerFilter()
				{
					public boolean select(Viewer viewer, Object parentElement, Object element)
					{
						if (element instanceof IResource)
						{
							IResource elementAsIResource = (IResource)element;
							return !elementAsIResource.getName().startsWith(".") ;
						}
						else
							return true;
					}
				});
	}
	
	protected void makeActions()
	{
		/*
		setActionGroup(new NavigatorActionGroup(this));
*/
		super.makeActions();
	}
	

	

	public void resourceChanged(IResourceChangeEvent event)
	{
		
		System.out.println("[Navigator] call resource changed in Navigator");
		/*
		 * final Control ctrl = getTreeViewer().getControl();
		if (ctrl != null && !ctrl.isDisposed())
		{
			if (event.getResource() != null)
			{
				IResource res = event.getResource();

				System.out.println("[Navigator] Resource changed, new resource" + res.getName());
				if (res.getName().equals(lastResourceName))
						return;
				lastResourceName = res.getName();
			}
			
			ctrl.getDisplay().asyncExec(
					new Runnable()
					{
						public void run()
						{
							if (!ctrl.isDisposed())
								getTreeViewer().refresh();
						}
					});
		}
		*/
	}


	
	public void selectionChanged(SelectionChangedEvent event) {
		System.out.println("[Navigator] call selection changed in Navigator");
		final Control ctrl = getTreeViewer().getControl();

		TreeSelection ts = null;
		Object o = null;
		if (event.getSelection() instanceof TreeSelection)
		{
			ts = (TreeSelection) event.getSelection();
			o = ts.getFirstElement();
		}
		else
		{
			return;
		}
		
		if ((ctrl != null) && (!ctrl.isDisposed()) && (o != null))
		{
			System.out.println("[Navigator] selection: " + event.getSelection().toString());

			if (o instanceof NavigatorLabel)
			{
				NavigatorLabel nl = (NavigatorLabel) o;
				System.out.println("[Navigator] command: " + nl.getCommandId() + " ; project = " + nl.getProject());
				
				switch (nl.getCommandId())
				{
					case NavigatorCommands.COMMAND_EDIT_DATAVIEW:
					{
						IFolder dataviewFolder = nl.getProject().getFolder("dataview");
						if( ! dataviewFolder.exists())
						{
							System.out.println ("[Navigator] ERROR: " + dataviewFolder.toString() + " does not exist");
							return;
						}
						IFile dataviewFile = dataviewFolder.getFile ("dataview.asn");
						if ( ! dataviewFile.exists())
						{
							System.out.println ("[Navigator] ERROR: " + dataviewFile.toString() + " does not exist");
							return;
						}
						else
						{
							System.out.println ("[Navigator] EDIT: " + dataviewFile.toString() + " asn file");
	
	
							   HashMap map = new HashMap();
							   
							 
							 //  map.put(IMarker.LINE_NUMBER, new Integer(5));
							   
							 //  map.put(IWorkbenchPage.EDITOR_ID_ATTR, 
							 //     "org.eclipse.ui.DefaultTextEditor");
							
							   IMarker marker;
							try {
								marker = dataviewFile.createMarker(IMarker.TEXT);
	
							   marker.setAttributes(map);
							   //page.openEditor(marker); //2.1 API
							   
							   org.eclipse.ui.ide.IDE.openEditor(this.getSite().getPage(), marker); //3.0 API
							   marker.delete();
							} catch (CoreException e) {
								e.printStackTrace();
							}
							
						}
						break;
					}
				
					case NavigatorCommands.COMMAND_VIEW_BINARIES:
					{
						if (Desktop.isDesktopSupported()) {
							Desktop desktop = Desktop.getDesktop();
							try {
								File binDirectory = new File(Utils.getWorkSpaceDirectory() + "/" + nl.getProject().getName() +  "/binaries");
								if (! binDirectory.exists())
								{
									Utils.showError("Binaries have not yet been generated");
								}
								desktop.open(binDirectory);
							} catch (IOException e) {
								Utils.showError("Cannot open the workspace");

								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						else
						{
							Utils.showError("Desktop manager not supported");
						}
					}
				
					case NavigatorCommands.COMMAND_EDIT_ARCHITECTURE:
					{
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


							   HashMap map = new HashMap();
							   
							 
							 //  map.put(IMarker.LINE_NUMBER, new Integer(5));
							   
							 //  map.put(IWorkbenchPage.EDITOR_ID_ATTR, 
							 //     "org.eclipse.ui.DefaultTextEditor");
							
							   IMarker marker;
							try {
								marker = diagramFile.createMarker(IMarker.TEXT);

							   marker.setAttributes(map);
							   //page.openEditor(marker); //2.1 API
							   
							   org.eclipse.ui.ide.IDE.openEditor(this.getSite().getPage(), marker); //3.0 API
							   marker.delete();
							} catch (CoreException e) {
								e.printStackTrace();
							}
							
						}
						break;
					}
					
					case NavigatorCommands.COMMAND_EDIT_DATAVIEW_C_SOURCE:
					case NavigatorCommands.COMMAND_EDIT_DATAVIEW_C_HEADER:
					case NavigatorCommands.COMMAND_EDIT_DATAVIEW_ADA_SOURCE:
					case NavigatorCommands.COMMAND_EDIT_DATAVIEW_ADA_HEADER:
					{
						String fileName = "dataview.c";
						int targetLang = DataViewWrapper.LANGUAGE_C;
						
						switch (nl.getCommandId())
						{
							case NavigatorCommands.COMMAND_EDIT_DATAVIEW_C_SOURCE:
							{
								fileName = "dataview.c";
								targetLang = DataViewWrapper.LANGUAGE_C;
								break;
							}
							
							case NavigatorCommands.COMMAND_EDIT_DATAVIEW_C_HEADER:
							{
								fileName = "dataview.h";
								targetLang = DataViewWrapper.LANGUAGE_C;
								break;
							}
							
							case NavigatorCommands.COMMAND_EDIT_DATAVIEW_ADA_SOURCE:
							{
								fileName = "dataview.adb";
								targetLang = DataViewWrapper.LANGUAGE_ADA;
								break;
							}
							
							case NavigatorCommands.COMMAND_EDIT_DATAVIEW_ADA_HEADER:
							{
								fileName = "dataview.ads";
								targetLang = DataViewWrapper.LANGUAGE_ADA;
								break;
							}
						}
						
						File dataviewFolder = new File (Utils.getProjectPath(nl.getProject()) + "/dataview");			

						
						if( ! dataviewFolder.exists())
						{
							System.out.println ("[Navigator] ERROR: " + dataviewFolder.toString() + " does not exist");
							return;
						}
						
						File fileAsn = new File (Utils.getProjectPath(nl.getProject()) + "/dataview/dataview.asn");			
						
						if ( ! fileAsn.exists())
						{
							System.out.println ("[Navigator] ERROR: " + fileAsn.toString() + " does not exist");
							Utils.showError("ASN.1 file not found", "ASN.1 file not found");
							return;
							
						}
						
						DataViewWrapper.generateSources (fileAsn.toString(), dataviewFolder.toString(), targetLang);
						
						
						IFolder fileFolder = nl.getProject().getFolder("dataview");
						

						if ( ! fileFolder.exists())
						{
							System.out.println ("[Navigator] ERROR: " + fileFolder.toString() + " does not exist");
							Utils.showError("Cannot find generated dataview folder", "Cannot find generated dataview folder");
							return;
						}
						
						try {
							fileFolder.refreshLocal(1,null);
						} catch (CoreException e1) {
							System.out.println ("[Navigator] ERROR wile refreshing " + fileFolder.toString());
							e1.printStackTrace();
						}
						
						IFile fileToEdit = fileFolder.getFile(fileName);			
						
						if ( ! fileToEdit.exists())
						{
							System.out.println ("[Navigator] ERROR: " + fileToEdit.toString() + " does not exist");
							Utils.showError("Cannot find generated dataview implementation", "Cannot find generated dataview implementation");
							return;
							
						}
						else
						{
							System.out.println ("[Navigator] EDIT: " + fileToEdit.toString() + " file");
							HashMap map = new HashMap();
							   
							IMarker marker;
							try {
								marker = fileToEdit.createMarker(IMarker.TEXT);
							   marker.setAttributes(map);
							   
							   org.eclipse.ui.ide.IDE.openEditor(this.getSite().getPage(), marker); //3.0 API
							   marker.delete();
							} catch (CoreException e) {
								e.printStackTrace();
							}
							
						}
						
						break;
					}
					
					case NavigatorCommands.COMMAND_EDIT_FUNCTION:
					{
						IFolder skelsFolder = null;
						IFolder functionFolder = null;
						Function f = null;
						
						f = Utils.getFunctionObject (nl.getAction());
						
						
						if (f == null)
						{
							System.out.println ("[Navigator] ERROR: cannot retrieve function object " + nl.getAction());
							return;
						}
						
						skelsFolder = nl.getProject().getFolder("skeletons");
						if( ! skelsFolder.exists())
						{
							System.out.println ("[Navigator] ERROR: " + skelsFolder.toString() + " does not exist");
							return;
						}
						
						functionFolder = skelsFolder.getFolder(f.getName());
						if (! functionFolder.exists())
						{
							Utils.createFunctionSkeleton (f);
						}
						
									
						IFile functionFile = Utils.getFunctionFile (f);
						if ( ! functionFile.exists())
						{
							System.out.println ("[Navigator] ERROR: " + functionFile.toString() + " does not exist");
							Utils.createFunctionSkeleton (f);
							
						}
						else
						{
							System.out.println ("[Navigator] EDIT: " + functionFile.toString() + " file");
	
	
							   HashMap map = new HashMap();
							   

							   IMarker marker;
							try {
								marker = functionFile.createMarker(IMarker.TEXT);
	
							   marker.setAttributes(map);
							   //page.openEditor(marker); //2.1 API
							   
							   org.eclipse.ui.ide.IDE.openEditor(this.getSite().getPage(), marker); //3.0 API
							   marker.delete();
							} catch (CoreException e) {
								e.printStackTrace();
							}
							
						}
						break;	
					}
				}
				
			}
			/*
			if ( event.getSelection() getResource() != null)
			{
				IResource res = event.getResource();

				System.out.println("[Navigator] Resource changed, new resource" + res.getName());
				if (res.getName().equals(lastResourceName))
						return;
				lastResourceName = res.getName();
			}
			
			ctrl.getDisplay().asyncExec(
					new Runnable()
					{
						public void run()
						{
							if (!ctrl.isDisposed())
								getTreeViewer().refresh();
						}
					});
					*/
		}
	}	
	

	  
}
