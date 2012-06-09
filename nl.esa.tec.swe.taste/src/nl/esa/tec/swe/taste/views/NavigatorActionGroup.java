package nl.esa.tec.swe.taste.views;

import java.io.IOException;
import java.util.HashSet;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourceAttributes;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.RefreshAction;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.views.navigator.IResourceNavigator;
import org.eclipse.ui.views.navigator.MainActionGroup;
import org.eclipse.ui.views.navigator.ResourceNavigatorActionGroup;

public class NavigatorActionGroup extends MainActionGroup
{
	private static final String OPEN_FOR_MODIFICATION_ACTION_ID = "nl.esa.tec.swe.taste.actions.OpenForModificationAction";

	private Action openForModificationAction;
	private static final HashSet<String> validIds;

	public NavigatorActionGroup(IResourceNavigator navigator)
	{
		super(navigator);
	}
	
	static
	{
		validIds = new HashSet<String>();
		validIds.add(OPEN_FOR_MODIFICATION_ACTION_ID);

	}
	
	public void fillContextMenu(IMenuManager menu)
	{

	}
	
	
	protected void makeActions()
	{
		super.makeActions();
		openForModificationAction = new Action("[NavigatorActionGroup] Open For Modification")
		{
			@Override
			public void run()
			{
				System.out.println("[NavigatorActionGroup] Open makeActions");
				IFile file = (IFile)((IStructuredSelection)getNavigator().getViewer().getSelection()).getFirstElement();
				ResourceAttributes attributes = file.getResourceAttributes();
				attributes.setReadOnly(false);
				try
				{
					file.setResourceAttributes(attributes);
					getNavigator().getViewer().update(file, null);
					IDE.openEditor(getNavigator().getViewSite().getPage(), file, "nl.esa.tec.swe.taste.main.TypeProvider");
				}
				catch (CoreException e)
				{
					e.printStackTrace();
				}
			}
		};
		openForModificationAction.setId(OPEN_FOR_MODIFICATION_ACTION_ID);

	}
}
