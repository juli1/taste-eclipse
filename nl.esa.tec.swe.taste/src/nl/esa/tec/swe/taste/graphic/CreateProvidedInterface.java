package nl.esa.tec.swe.taste.graphic;


import nl.esa.tec.swe.taste.metamodel.taste.Interface;
import nl.esa.tec.swe.taste.metamodel.taste.Function;
import nl.esa.tec.swe.taste.metamodel.taste.TasteFactory;

import org.eclipse.graphiti.examples.common.ExampleUtil;
import org.eclipse.graphiti.features.*;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.*;


public class CreateProvidedInterface extends AbstractCreateFeature {
	private static final String TITLE = "New Interface";
	private static final String USER_QUESTION = "Enter Interface Name";
	public CreateProvidedInterface(IFeatureProvider fp) {
		super(fp, "Provided Interface", "Add Provided Interface");
	}

	public boolean canCreate(ICreateContext context) {
		Object bo = getBusinessObjectForPictogramElement(context.getTargetContainer());

		if (bo == null)
		{

			return false;
		}

		if (bo instanceof Function)
		{
			return true;
		}
		return false;

	}

	public Object[] create(ICreateContext context) {

		Object bo = getBusinessObjectForPictogramElement(context.getTargetContainer());


		String newClassName = ExampleUtil.askString(TITLE, USER_QUESTION, "");

		if (newClassName == null || newClassName.trim().length() == 0) {
			return EMPTY;
		}

		Interface newClass = TasteFactory.eINSTANCE.createInterface();
		getDiagram().eResource().getContents().add(newClass);
		newClass.setName(newClassName);
		newClass.setPeriod(1000);
		newClass.setDeadline(1000);
		newClass.setIsProvidedInterface(true);
		addGraphicalRepresentation(context, newClass);

		if (bo instanceof Function)
		{
			Function f = (Function) bo;
			f.getInterfaces().add (newClass);
			newClass.setAssociatedFunction(f);
		}
		
		return new Object[] {newClass};
	}
}