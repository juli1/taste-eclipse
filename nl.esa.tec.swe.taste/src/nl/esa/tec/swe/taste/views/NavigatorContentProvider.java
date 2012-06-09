package nl.esa.tec.swe.taste.views;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import nl.esa.tec.swe.taste.commands.NavigatorCommands;
import nl.esa.tec.swe.taste.commands.Utils;
import nl.esa.tec.swe.taste.metamodel.taste.Function;
import nl.esa.tec.swe.taste.utils.FunctionalCode;
import nl.esa.tec.swe.taste.wizard.preferences.*;

import org.eclipse.core.resources.*;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.model.WorkbenchContentProvider;


public class NavigatorContentProvider extends WorkbenchContentProvider {
	String[] potentialActions = {"Data View", "Architecture model", "Functional code"};

	public Object[] getChildren(Object element) {
		System.out.println("[NavigatorContentProvider] invoke getChildren with" + element.toString() );

		if (element instanceof IProject)
		{

			NavigatorLabel[] labels = new NavigatorLabel[4];
			labels [0] = new NavigatorLabel((IProject)element, "Data View", NavigatorCommands.COMMAND_EDIT_DATAVIEW);
			labels [1] = new NavigatorLabel((IProject)element, "Architecture", NavigatorCommands.COMMAND_EDIT_ARCHITECTURE);
			labels [2] = new NavigatorLabel((IProject)element, "Functional code", NavigatorCommands.COMMAND_VIEW_FUNCTIONAL_CODE);
			labels [3] = new NavigatorLabel((IProject)element, "Binaries", NavigatorCommands.COMMAND_VIEW_BINARIES);

			return labels;

		}


		if (element instanceof NavigatorLabel)
		{
			NavigatorLabel nl = (NavigatorLabel) element;
			System.out.println("[NavigatorContentProvider] invoke getChildren with NavigatorLabel" + nl.getAction() );

			switch (nl.getCommandId())
			{

				case NavigatorCommands.COMMAND_EDIT_DATAVIEW:
				{
					if (PreferencesHelper.getExpertModeEnable())
					{ 
						NavigatorLabel[] labels = new NavigatorLabel[3];
						labels [0] = new NavigatorLabel(nl.getProject(), "Edit C Source", NavigatorCommands.COMMAND_EDIT_DATAVIEW_C_SOURCE);
						labels [1] = new NavigatorLabel(nl.getProject(), "Edit C Header", NavigatorCommands.COMMAND_EDIT_DATAVIEW_C_HEADER);
						labels [2] = new NavigatorLabel(nl.getProject(), "Edit Ada Definition", NavigatorCommands.COMMAND_EDIT_DATAVIEW_ADA_HEADER);
						//labels [3] = new NavigatorLabel(nl.getProject(), "Edit Ada Source", NavigatorCommands.COMMAND_EDIT_DATAVIEW_ADA_SOURCE);
						return labels;
					}
					else
					{
						return super.getChildren(element);
					}
				}
				case NavigatorCommands.COMMAND_VIEW_FUNCTIONAL_CODE:
				{
					String[] functionNames = null;
					Function[] functions = Utils.getFunctions(nl.getProject());

					if ((functions == null ) || (functions.length <= 0))
					{
						System.out.println("[NavigatorContentProvider] functions null or 0 sized");
						return super.getChildren(element);
					}
					NavigatorLabel labels[] = new NavigatorLabel[functions.length];
					for(int i = 0 ; i < functions.length ; i++)
					{

						System.out.println("[NavigatorContentProvider] create new label with name" + functions[i].getName());
						labels[i] = new NavigatorLabel(nl.getProject(), functions[i].getName(), NavigatorCommands.COMMAND_EDIT_FUNCTION, functions[i]);
					}
					return labels; 
				}
			/*
				Desktop desktop = Desktop.getDesktop();
				try {
					desktop.open(new File("C:/"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 */

				default:
				{
					return super.getChildren(element);
				}
			
			}
	
		}
		return super.getChildren(element);
	}
}
