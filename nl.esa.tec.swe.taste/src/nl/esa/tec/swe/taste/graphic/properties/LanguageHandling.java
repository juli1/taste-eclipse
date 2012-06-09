package nl.esa.tec.swe.taste.graphic.properties;


import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import nl.esa.tec.swe.taste.metamodel.taste.Function;

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
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.*;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

public class LanguageHandling extends GFPropertySection implements ITabbedPropertyConstants, SelectionListener, ModifyListener {
	private CCombo languageValue;
	String selectedProperty = "";

	public void modifyText(ModifyEvent event)
	{

		IFeature feature = new AbstractFeature(getDiagramTypeProvider().getFeatureProvider()) {

			public void execute(IContext context) {
				PictogramElement pe = getSelectedPictogramElement();

				if ((pe != null) && (selectedProperty != "")) {
					Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
					// the filter assured, that it is a EClass
					if (bo instanceof Function)
					{
						Function f = (Function) bo;
						System.out.println("[LanguageHandling] new selected object " + f.getName());
						System.out.println("[LanguageHandling] new property value  " + selectedProperty);
						f.setLanguage(selectedProperty);
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
		System.out.println("[LanguageHandling] EXECUTED ACTION");

	}



	public void widgetSelected(SelectionEvent e)
	{
		String[] propertyValues = languageValue.getItems();
		String propertyValue = propertyValues[languageValue.getSelectionIndex()];
		if ((languageValue.getSelectionIndex() < 0 ) || (languageValue.getSelectionIndex() > propertyValues.length ))
		{
			System.out.println("[LanguageHandling] index out of bounds !" + languageValue.getSelectionIndex());
			return;
		}

		PictogramElement pe = getSelectedPictogramElement();
		Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
		if (bo instanceof Function)
		{
			Function f = (Function) bo;

			selectedProperty = propertyValue;
			this.modifyText(null);

		} 
	}




	public void createControls (Composite parent,
			TabbedPropertySheetPage tabbedPropertySheetPage)
	{

		super.createControls(parent, tabbedPropertySheetPage);

		TabbedPropertySheetWidgetFactory factory = getWidgetFactory();
		Composite composite = factory.createFlatFormComposite(parent);

		FormData data;
		final String selectedString;
		languageValue = factory.createCCombo(composite,SWT.BORDER | SWT.V_SCROLL);

		languageValue.add ("C", Constants.LANGUAGE_C_INDEX);
		languageValue.add("Ada", Constants.LANGUAGE_ADA_INDEX);
		languageValue.add("SDL/RTDS", Constants.LANGUAGE_RTDS_INDEX);
		languageValue.add("Simulink", Constants.LANGUAGE_SIMULINK_INDEX);

		data = new FormData();
		data.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
		data.right = new FormAttachment(100, 0);
		data.top = new FormAttachment(0, VSPACE);
		languageValue.setLayoutData(data);

		CLabel valueLabel = factory.createCLabel(composite, "Language:");
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(languageValue, 0);
		data.top = new FormAttachment(languageValue, 0, SWT.CENTER);
		valueLabel.setLayoutData(data);



		languageValue.addSelectionListener(this);


		languageValue.addModifyListener(this);

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

			if (bo instanceof Function)
			{
				name = ((Function) bo).getLanguage();
			}
			if ((languageValue != null) && (name != null) )
			{

				String[] propertyValues = languageValue.getItems();
				int idx = 0;
				System.out.println("[LanguageHandling] Function language" + name);
				for (int i = 0 ; i < propertyValues.length ; i++)
				{
					if (propertyValues[i].equals(name))
					{
						idx = i;
						System.out.println("[LanguageHandling] change index to " + idx);
					}
				}
				languageValue.select (idx);
			}

		}

	}

	public void widgetDefaultSelected(SelectionEvent e) {

	}
}