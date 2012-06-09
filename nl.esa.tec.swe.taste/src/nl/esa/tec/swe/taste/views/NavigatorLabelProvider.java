package nl.esa.tec.swe.taste.views;

import java.net.MalformedURLException;
import java.net.URL;

import nl.esa.tec.swe.taste.commands.NavigatorCommands;
import nl.esa.tec.swe.taste.main.Activator;
import nl.esa.tec.swe.taste.metamodel.taste.Function;

import org.eclipse.core.internal.resources.Project;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPluginDescriptor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.DecoratingLabelProvider;
import org.eclipse.jface.viewers.ILabelDecorator;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.ui.model.WorkbenchLabelProvider;


public class NavigatorLabelProvider extends DecoratingLabelProvider {

	public NavigatorLabelProvider(ILabelProvider provider, ILabelDecorator decorator)
	{
		super(provider, decorator);
	}

	public Image getImage(Object element) 
	{

		String icon = null;
		
		
		System.out.println("[NavigatorLabel] call getText in LabelProvider");

		if (element != null)
		{
			System.out.println("[NavigatorLabel] element class + " + element.getClass().toString());
			if (Project.class.isInstance(element))
			{
				icon = "taste-logo16.gif";
			}
			
			
			if (NavigatorLabel.class.isInstance(element))
			{

				NavigatorLabel nl = (NavigatorLabel)element;
				
				System.out.println("[NavigatorLabel] getAction + " + nl.getAction());

				if (nl.getAction().equals ("Data View"))
				{
					icon = "dataview16.png";
				}

				if (nl.getAction().equals ("Architecture"))
				{
					icon = "aadllogo16.png";
				}
				
				if (nl.getAction().equals ("Functional code"))
				{
					icon = "skel16.png";
				}
				
				if (nl.getAction().equals ("Binaries"))
				{
					icon = "taste-logo16.gif";
				}
				
				if (nl.getCommandId() == NavigatorCommands.COMMAND_EDIT_DATAVIEW_C_SOURCE)
				{
					icon = "srcc16.png";
				}
				if (nl.getCommandId() == NavigatorCommands.COMMAND_EDIT_DATAVIEW_C_HEADER)
				{
					icon = "srcc16.png";
				}
				if (nl.getCommandId() == NavigatorCommands.COMMAND_EDIT_DATAVIEW_ADA_SOURCE)
				{
					icon = "srcada16.png";
				}
				if (nl.getCommandId() == NavigatorCommands.COMMAND_EDIT_DATAVIEW_ADA_HEADER)
				{
					icon = "srcada16.png";
				}
				
				if (nl.getAssoFunction() != null)
				{
					Function f = nl.getAssoFunction();
					if (f.getLanguage().toLowerCase().equals("c"))
					{
						icon = "srcc16.png";
					}
					
					if (f.getLanguage().toLowerCase().equals("ada"))
					{
						icon = "srcada16.png";
					}
					if (f.getLanguage().toLowerCase().contains("sdl"))
					{
						icon = "sdl16.png";
					}
					if (f.getLanguage().toLowerCase().contains("matlab"))
					{
						icon = "matlab16.png";
					}
					if (f.getLanguage().toLowerCase().contains("simulink"))
					{
						icon = "matlab16.png";
					}
				}
			}
		}
		
		
		if (icon != null)
		{
			try {
				URL url;
				
				url = new URL("platform:/plugin/nl.esa.tec.swe.taste/icons/" + icon);

				ImageDescriptor desc = ImageDescriptor.createFromURL(url);

				Image img = new Image(null, desc.getImageData());

				return img;
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		}
		return null;
	}


	public String getText(Object element) {
		String text = "";
		System.out.println("[NavigatorLabel] call getText in LabelProvider");

		if (element != null)
		{
			System.out.println("[NavigatorLabel] element class + " + element.getClass().toString());
			if (IProject.class.isInstance(element))
			{
				return ((IProject)element).getProject().getName();
			}
			else
			{
				if (NavigatorLabel.class.isInstance(element))
				{
					return ((NavigatorLabel)element).getAction();
				}
			}
		}
		return "";
	}

}
