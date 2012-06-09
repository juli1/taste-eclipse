package nl.esa.tec.swe.taste.graphic.properties;

import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.platform.GFPropertySection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

public class InterfaceConnectionBusHandling extends GFPropertySection implements ITabbedPropertyConstants {
	private CCombo typeValue;

	public void createControls (Composite parent,
								TabbedPropertySheetPage tabbedPropertySheetPage)
	{
		
		super.createControls(parent, tabbedPropertySheetPage);

		TabbedPropertySheetWidgetFactory factory = getWidgetFactory();
		Composite composite = factory.createFlatFormComposite(parent);
		
		FormData data;

		typeValue = factory.createCCombo(parent,SWT.BORDER | SWT.V_SCROLL);

		typeValue.add ("default");

		CLabel valueLabel = factory.createCLabel(composite, "Bus association:");
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(typeValue, -HSPACE);
		data.top = new FormAttachment(typeValue, 0, SWT.CENTER);
		valueLabel.setLayoutData(typeValue.getLayoutData());
	}

	public void refresh()
	{
		PictogramElement pe = getSelectedPictogramElement();
		if (pe != null)
		{
			Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);

			if (bo == null)
			{
				return;
			}
		}
	}

}