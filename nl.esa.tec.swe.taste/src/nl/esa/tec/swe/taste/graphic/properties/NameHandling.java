package nl.esa.tec.swe.taste.graphic.properties;

import nl.esa.tec.swe.taste.commands.Utils;
import nl.esa.tec.swe.taste.metamodel.taste.*;

import org.eclipse.graphiti.features.IFeature;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.impl.CustomContext;
import org.eclipse.graphiti.features.impl.AbstractFeature;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.platform.GFPropertySection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

public class NameHandling extends GFPropertySection implements ITabbedPropertyConstants, ModifyListener {
	private Text nameText;

	public void createControls (Composite parent,
								TabbedPropertySheetPage tabbedPropertySheetPage)
	{

		super.createControls(parent, tabbedPropertySheetPage);

		TabbedPropertySheetWidgetFactory factory = getWidgetFactory();
		Composite composite = factory.createFlatFormComposite(parent);
		FormData data;
		
		nameText = factory.createText(composite, "");
		data = new FormData();
		data.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
		data.right = new FormAttachment(100, 0);
		data.top = new FormAttachment(0, VSPACE);
		nameText.setLayoutData(data);

		CLabel valueLabel = factory.createCLabel(composite, "Name:");
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(nameText, 0);
		data.top = new FormAttachment(nameText, 0, SWT.CENTER);
		valueLabel.setLayoutData(data);
		
		nameText.addModifyListener(this);
	}

	public void refresh()
	{
		PictogramElement pe = getSelectedPictogramElement();
		String name = "";
		if (pe != null)
		{
			Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);

			if (bo == null)
			{
				return;
			}
			
			if (bo instanceof TasteComponent)
			{
				name = ((TasteComponent) bo).getName();
			}
			
			if (bo instanceof Interface)
			{
				name = ((Interface) bo).getName();
			}
			
			nameText.setText(name);
		}
	}
	

	
	public void modifyText(ModifyEvent event)
	{
		final String newName = nameText.getText();
			
		PictogramElement petmp = getSelectedPictogramElement();
		
		if (! Utils.isNameValid(newName))
		{
			Utils.showError("Invalid name, please respect naming rules", "");
			return;
		}
		
		if (petmp instanceof Shape)
		{
			Object o;
			o = Utils.nameExists(newName, Utils.getRootComponent((Shape)petmp));
			if ((o != null) && 
			     ( o != Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(petmp)))
			{
				Utils.showError("Invalid name, already exists in the model", "");
				return;
			}
		}

		
		IFeature feature = new AbstractFeature(getDiagramTypeProvider().getFeatureProvider()) {
	
			public void execute(IContext context) {
				PictogramElement pe = getSelectedPictogramElement();
				System.out.println("[NameHandling] PictogramElement: " + pe);
				System.out.println("[NameHandling] PictogramElement class: " + pe.getClass());

				try
				{
					if (pe != null)  {
						Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
						// the filter assured, that it is a EClass
						if (bo instanceof TasteComponent)
						{
							TasteComponent f = (TasteComponent) bo;
							System.out.println("[NameHandling] new selected object " + f.getName());
							System.out.println("[NameHandling] new property value  " + nameText.getText());
							f.setName(newName);
						}
						if (bo instanceof Interface)
						{
							Interface f = (Interface) bo;
							System.out.println("[NameHandling] new selected interface " + f.getName());
							System.out.println("[NameHandling] new property value  " + nameText.getText());
							f.setName(newName);
						}
						
					}
				}
				catch (IllegalStateException e)
				{
					System.out.println("[NameHandling] IllegalStateException raised");
					return;
				}
			}
	
			public boolean canExecute(IContext context) {
				return true;
			}
		};
		CustomContext context = new CustomContext();
		execute(feature, context);
		System.out.println("[NameHandling] EXECUTED ACTION");
	}

}