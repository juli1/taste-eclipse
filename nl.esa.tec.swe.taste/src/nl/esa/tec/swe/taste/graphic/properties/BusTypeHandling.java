package nl.esa.tec.swe.taste.graphic.properties;

import nl.esa.tec.swe.taste.commands.Utils;
import nl.esa.tec.swe.taste.metamodel.taste.Bus;

import org.eclipse.graphiti.features.IFeature;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.impl.CustomContext;
import org.eclipse.graphiti.features.impl.AbstractFeature;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.platform.GFPropertySection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

public class BusTypeHandling extends GFPropertySection implements ITabbedPropertyConstants, ModifyListener, SelectionListener {
	private CCombo busValue;

	public void createControls (Composite parent,
								TabbedPropertySheetPage tabbedPropertySheetPage)
	{
		
		super.createControls(parent, tabbedPropertySheetPage);

		TabbedPropertySheetWidgetFactory factory = getWidgetFactory();
		Composite composite = factory.createFlatFormComposite(parent);
		
		FormData data;

		busValue = factory.createCCombo(composite,SWT.BORDER | SWT.V_SCROLL);

		busValue.add ("Ethernet", Constants.BUS_ETHERNET_INDEX);
		busValue.add ("SpaceWire", Constants.BUS_SPACEWIRE_INDEX);
		busValue.add ("Serial", Constants.BUS_SERIAL_INDEX);
		
		data = new FormData();
		data.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
		data.right = new FormAttachment(100, 0);
		data.top = new FormAttachment(0, VSPACE);
		busValue.setLayoutData(data);
		
		CLabel valueLabel = factory.createCLabel(composite, "Bus type:");
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(busValue, 0);
		data.top = new FormAttachment(busValue, 0, SWT.CENTER);
		valueLabel.setLayoutData(data);
		
		busValue.addModifyListener(this);
		busValue.addSelectionListener(this);
	}

	String selectedProperty = "";
	
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
	
			if (bo instanceof Bus)
			{
				name = ((Bus) bo).getType();
			}
			if ((busValue != null) && (name != null) )
			{
	
				String[] propertyValues = busValue.getItems();
				int idx = 0;
				System.out.println("[BusTypeHandling] Bus val" + name);
				for (int i = 0 ; i < propertyValues.length ; i++)
				{
					if (propertyValues[i].equals(name))
					{
						idx = i;
						System.out.println("[BusTypeHandling] change index to " + idx);
					}
				}
				busValue.select (idx);
			}
	
		}
	}
	
	
	public void modifyText(ModifyEvent event)
	{
	
		IFeature feature = new AbstractFeature(getDiagramTypeProvider().getFeatureProvider()) {
	
			public void execute(IContext context) {
				PictogramElement pe = getSelectedPictogramElement();
	
				if ((pe != null) && (selectedProperty != "")) {
					Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
					// the filter assured, that it is a EClass
					if (bo instanceof Bus)
					{
						Bus f = (Bus) bo;
						if (f.getConnections().size() != 0)
						{
							Utils.showError("You cannot change the type of a bus already connected", "");
							return;
						}
						System.out.println("[BusTypeHandling] new selected object " + f.getName());
						System.out.println("[BusTypeHandling] new property value  " + selectedProperty);
						f.setType(selectedProperty);
					} 
				}
			}
	
			public boolean canExecute(IContext context) {
				return true;
			}
		};
		CustomContext context = new CustomContext();
		execute(feature, context);
		System.out.println("[BusTypeHandling] EXECUTED ACTION");
	
	}
	
	
	
	public void widgetSelected(SelectionEvent e)
	{
		String[] propertyValues = busValue.getItems();
		String propertyValue = propertyValues[busValue.getSelectionIndex()];
		if ((busValue.getSelectionIndex() < 0 ) || (busValue.getSelectionIndex() > propertyValues.length ))
		{
			System.out.println("[BusTypeHandling] index out of bounds !" + busValue.getSelectionIndex());
			return;
		}
	
		PictogramElement pe = getSelectedPictogramElement();
		Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
		if (bo instanceof Bus)
		{
	
			selectedProperty = propertyValue;
			this.modifyText(null);
	
		} 
	}
	
	
	public void widgetDefaultSelected(SelectionEvent e) {
	
	}

}