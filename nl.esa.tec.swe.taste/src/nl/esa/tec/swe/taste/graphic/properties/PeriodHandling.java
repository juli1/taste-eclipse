package nl.esa.tec.swe.taste.graphic.properties;

import nl.esa.tec.swe.taste.metamodel.taste.Interface;
import nl.esa.tec.swe.taste.metamodel.taste.TasteComponent;

import org.eclipse.graphiti.features.IFeature;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.impl.CustomContext;
import org.eclipse.graphiti.features.impl.AbstractFeature;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.platform.GFPropertySection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

public class PeriodHandling extends GFPropertySection implements ITabbedPropertyConstants, ModifyListener{
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

		CLabel valueLabel = factory.createCLabel(composite, "Period (ms):");
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(nameText, -HSPACE);
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
			
			if (bo instanceof Interface)
			{
				name = ""+((Interface) bo).getPeriod();
			}
			if (nameText != null)
			{
				nameText.setText(name);
			}
		}
	}
	
	
	public void modifyText(ModifyEvent event)
	{
	
		IFeature feature = new AbstractFeature(getDiagramTypeProvider().getFeatureProvider()) {
	
			public void execute(IContext context) {
				PictogramElement pe = getSelectedPictogramElement();
	
				if (pe != null)  {
					Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
					// the filter assured, that it is a EClass
					if (bo instanceof Interface)
					{
						Interface f = (Interface) bo;
						System.out.println("[PeriodHandling] new selected object " + f.getName());
						System.out.println("[PeriodHandling] new property value  " + nameText.getText());
						f.setPeriod(Integer.parseInt(nameText.getText()));
					} 
				}
			}
	
			public boolean canExecute(IContext context) {
				return true;
			}
		};
		CustomContext context = new CustomContext();
		execute(feature, context);
		System.out.println("[PeriodHandling] EXECUTED ACTION");
	
	}
}