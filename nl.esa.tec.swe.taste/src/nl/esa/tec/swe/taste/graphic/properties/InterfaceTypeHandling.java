package nl.esa.tec.swe.taste.graphic.properties;

import nl.esa.tec.swe.taste.commands.NavigatorCommands;
import nl.esa.tec.swe.taste.metamodel.taste.Interface;

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
import org.eclipse.swt.widgets.Table;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;


public class InterfaceTypeHandling extends GFPropertySection implements ITabbedPropertyConstants, SelectionListener, ModifyListener {
	private CCombo typeValue;

	public void createControls (Composite parent,
								TabbedPropertySheetPage tabbedPropertySheetPage)
	{
		
		super.createControls(parent, tabbedPropertySheetPage);

		TabbedPropertySheetWidgetFactory factory = getWidgetFactory();
		Composite composite = factory.createFlatFormComposite(parent);
		
		FormData data;


		typeValue = factory.createCCombo(composite,SWT.BORDER | SWT.V_SCROLL);

		typeValue.add ("Cyclic", Constants.INTERFACE_CYCLIC_INDEX);
		typeValue.add ("Sporadic", Constants.INTERFACE_SPORADIC_INDEX);		
		typeValue.add ("Protected", Constants.INTERFACE_PROTECTED_INDEX);
		typeValue.add ("Unprotected", Constants.INTERFACE_UNPROTECTED_INDEX);

		
		data = new FormData();
		data.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
		data.right = new FormAttachment(100, 0);
		data.top = new FormAttachment(0, VSPACE);
		typeValue.setLayoutData(data);
		
		CLabel valueLabel = factory.createCLabel(composite, "Type:");
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(typeValue, 0);
		data.top = new FormAttachment(typeValue, 0, SWT.CENTER);
		valueLabel.setLayoutData(data);
		
		typeValue.addSelectionListener(this);
		typeValue.addModifyListener(this);
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

			if (bo instanceof Interface)
			{
				name = NavigatorCommands.InterfaceTypeToName(((Interface) bo).getInterfaceType());
			}
			if ((typeValue != null) && (name != null) )
			{

				String[] propertyValues = typeValue.getItems();
				int idx = 0;
				System.out.println("[InterfaceTypeHandling] Function type val" + name);
				for (int i = 0 ; i < propertyValues.length ; i++)
				{
					if (propertyValues[i].equals(name))
					{
						idx = i;
						System.out.println("[InterfaceTypeHandling] change index to " + idx);
					}
				}
				typeValue.select (idx);
			}

		}
	}
	

	public void modifyText(ModifyEvent event)
	{

		IFeature feature = new AbstractFeature(getDiagramTypeProvider().getFeatureProvider()) {

			public void execute(IContext context) {
				PictogramElement pe = getSelectedPictogramElement();
				int newType;
				if ((pe != null) && (selectedProperty != "")) {
					Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
					// the filter assured, that it is a EClass
					if (bo instanceof Interface)
					{
						Interface f = (Interface) bo;
						System.out.println("[InterfaceTypeHandling]  new selected interface " + f.getName());
						System.out.println("[InterfaceTypeHandling]  new property value  " + selectedProperty);
						newType = NavigatorCommands.InterfaceNameToType(selectedProperty);
						if (newType == Constants.INTERFACE_CYCLIC_INDEX)
						{
							f.setIsProvidedInterface(true);
						}
						f.setInterfaceType(newType);
					} 
				}
			}

			@Override
			public boolean canExecute(IContext context) {
				return true;
			}
		};
		CustomContext context = new CustomContext();
		execute(feature, context);
		System.out.println("[InterfaceTypeHandling] EXECUTED ACTION");

	}



	public void widgetSelected(SelectionEvent e)
	{
		String[] propertyValues = typeValue.getItems();
		String propertyValue = propertyValues[typeValue.getSelectionIndex()];
		if ((typeValue.getSelectionIndex() < 0 ) || (typeValue.getSelectionIndex() > propertyValues.length ))
		{
			System.out.println("[InterfaceTypeHandling] index out of bounds !" + typeValue.getSelectionIndex());
			return;
		}

		PictogramElement pe = getSelectedPictogramElement();
		Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
		if (bo instanceof Interface)
		{

			selectedProperty = propertyValue;
			this.modifyText(null);

		} 
	}
	public void widgetDefaultSelected(SelectionEvent e) {

	}



}