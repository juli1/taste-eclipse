package nl.esa.tec.swe.taste.graphic.properties;

import java.util.HashMap;

import nl.esa.tec.swe.taste.metamodel.taste.Board;

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
import org.eclipse.swt.events.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.*;

public class PlatformHandling extends GFPropertySection implements ITabbedPropertyConstants,  SelectionListener, ModifyListener {
	private CCombo platformValue;
	HashMap<Board,String> selectedProperty = new HashMap<Board,String>();

	public void createControls (Composite parent,
								TabbedPropertySheetPage tabbedPropertySheetPage)
	{
		
		super.createControls(parent, tabbedPropertySheetPage);

		TabbedPropertySheetWidgetFactory factory = getWidgetFactory();
		Composite composite = factory.createFlatFormComposite(parent);
		
		FormData data;

		platformValue = factory.createCCombo(composite,SWT.BORDER | SWT.V_SCROLL);

		platformValue.add ("Native", Constants.PLATFORM_NATIVE_INDEX);
		platformValue.add("Linux with 32 bits", Constants.PLATFORM_LINUX32_INDEX);
		platformValue.add("Linux with 64 bits", Constants.PLATFORM_LINUX64_INDEX);
		platformValue.add("Leon2", Constants.PLATFORM_LEON2_INDEX);
		platformValue.add("Win32", Constants.PLATFORM_WIN32_INDEX);

		data = new FormData();
		data.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
		data.right = new FormAttachment(100, 0);
		data.top = new FormAttachment(0, VSPACE);
		platformValue.setLayoutData(data);
		
		CLabel valueLabel = factory.createCLabel(composite, "Platform:");
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(platformValue, 0);
		data.top = new FormAttachment(platformValue, 0, SWT.CENTER);
		valueLabel.setLayoutData(data);

		platformValue.addSelectionListener(this);


		platformValue.addModifyListener(this);
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

			if (bo instanceof Board)
			{
				Board b = (Board)bo;
				name = ((Board) bo).getType();
				selectedProperty.put(b,name);
			}
			if ((platformValue != null) && (name != null) )
			{

				String[] propertyValues = platformValue.getItems();
				int idx = 0;
				System.out.println("[PlatformHandling] Platform val" + name);
				for (int i = 0 ; i < propertyValues.length ; i++)
				{
					if (propertyValues[i].equals(name))
					{
						idx = i;
						System.out.println("[PlatformHandling] change index to " + idx);
					}
				}
				platformValue.select (idx);
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

					if (bo instanceof Board)
					{
						Board f = (Board) bo;
						if (selectedProperty.get(f) != null)
						{
							System.out.println("[PlatformHandling] new selected object " + f.getName());
							System.out.println("[PlatformHandling] new property value  " + selectedProperty.get(f));
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
		System.out.println("[PlatformHandling] EXECUTED ACTION");

	}



	public void widgetSelected(SelectionEvent e)
	{
		String[] propertyValues = platformValue.getItems();
		String propertyValue = propertyValues[platformValue.getSelectionIndex()];
		if ((platformValue.getSelectionIndex() < 0 ) || (platformValue.getSelectionIndex() > propertyValues.length ))
		{
			System.out.println("[PlatformHandling] index out of bounds !" + platformValue.getSelectionIndex());
			return;
		}

		PictogramElement pe = getSelectedPictogramElement();
		Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
		if (bo instanceof Board)
		{
			Board b = (Board) bo;
			System.out.println("[PlatformHandling] Widget Selected, platformValue="+ propertyValue);

			selectedProperty.put(b, propertyValue);
			modifyText(null);
		} 
	}
	public void widgetDefaultSelected(SelectionEvent e) {

	}


}