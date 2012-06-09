package nl.esa.tec.swe.taste.graphic.properties;

import java.util.HashMap;

import nl.esa.tec.swe.taste.commands.Utils;
import nl.esa.tec.swe.taste.metamodel.taste.Driver;

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

public class DriverTypeHandling extends GFPropertySection implements ITabbedPropertyConstants, ModifyListener, SelectionListener {
	private CCombo drvValue;	
	HashMap<Driver,String> selectedProperty = new HashMap<Driver,String>();

	public void createControls (Composite parent,
								TabbedPropertySheetPage tabbedPropertySheetPage)
	{
		
		super.createControls(parent, tabbedPropertySheetPage);

		TabbedPropertySheetWidgetFactory factory = getWidgetFactory();
		Composite composite = factory.createFlatFormComposite(parent);
		
		FormData data;

		drvValue = factory.createCCombo(composite,SWT.BORDER | SWT.V_SCROLL);

		drvValue.add ("Ethernet", Constants.DRIVER_ETHERNET_INDEX);
		drvValue.add ("SpaceWire", Constants.DRIVER_SPACEWIRE_INDEX);
		drvValue.add ("Serial", Constants.DRIVER_SERIAL_INDEX);

		data = new FormData();
		data.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
		data.right = new FormAttachment(100, 0);
		data.top = new FormAttachment(0, VSPACE);
		drvValue.setLayoutData(data);
		
		CLabel valueLabel = factory.createCLabel(composite, "Driver type:");
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(drvValue, 0);
		data.top = new FormAttachment(drvValue, 0, SWT.CENTER);
		valueLabel.setLayoutData(data);
		
		drvValue.addSelectionListener(this);
		drvValue.addModifyListener(this);
		

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
	
			if (bo instanceof Driver)
			{
				name = ((Driver) bo).getType();
				Driver d = (Driver)bo;
				selectedProperty.put(d,name);
			}
			if ((drvValue != null) && (name != null) )
			{
	
				String[] propertyValues = drvValue.getItems();
				int idx = 0;
				System.out.println("[DriverTypeHandling] Platform val" + name);
				for (int i = 0 ; i < propertyValues.length ; i++)
				{
					if (propertyValues[i].equals(name))
					{
						idx = i;
						System.out.println("[DriverTypeHandling] change index to " + idx);
					}
				}
				drvValue.select (idx);
			}
	
		}
	}
	
	
	public void modifyText(ModifyEvent event)
	{

		IFeature feature = new AbstractFeature(getDiagramTypeProvider().getFeatureProvider()) {
	
			public void execute(IContext context) {
				PictogramElement pe = getSelectedPictogramElement();
	
				if (pe != null)
				{
					Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
					if (bo instanceof Driver)
					{
						Driver f = (Driver) bo;

						
						if (selectedProperty.get (f) != null)
						{
							if (selectedProperty.get(f).equals (f.getType()))
							{
								return;
							}
							
							if (f.getConnections().size() != 0)
							{
								Utils.showError("You cannot change the type of a driver already connected", "");
								return;
							}
							System.out.println("new selected object " + f.getName());
							System.out.println("new property value  " + selectedProperty);
							f.setType(selectedProperty.get(f));
						}
					} 
				}
			}
	
			public boolean canExecute(IContext context) {
				return true;
			}
		};
		CustomContext context = new CustomContext();
		execute(feature, context);
		System.out.println("[DriverTypeHandling] EXECUTED ACTION");
	
	}
	
	
	
	public void widgetSelected(SelectionEvent e)
	{
		String[] propertyValues = drvValue.getItems();
		String propertyValue = propertyValues[drvValue.getSelectionIndex()];
		if ((drvValue.getSelectionIndex() < 0 ) || (drvValue.getSelectionIndex() > propertyValues.length ))
		{
			System.out.println("[DriverTypeHandling] index out of bounds !" + drvValue.getSelectionIndex());
			return;
		}
	
		PictogramElement pe = getSelectedPictogramElement();
		Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
		if (bo instanceof Driver)
		{
			Driver d = (Driver)bo;
			selectedProperty.put(d,propertyValue);
			this.modifyText(null);
	
		} 
	}
	
	
	public void widgetDefaultSelected(SelectionEvent e) {
	
	}

}