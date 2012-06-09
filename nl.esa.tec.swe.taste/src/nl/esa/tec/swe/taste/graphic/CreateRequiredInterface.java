package nl.esa.tec.swe.taste.graphic;


import nl.esa.tec.swe.taste.metamodel.taste.Interface;
import nl.esa.tec.swe.taste.metamodel.taste.Function;
import nl.esa.tec.swe.taste.metamodel.taste.TasteFactory;

import org.eclipse.graphiti.examples.common.ExampleUtil;
import org.eclipse.graphiti.features.*;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.*;


public class CreateRequiredInterface extends AbstractCreateFeature {
	private static final String TITLE = "New Interface";
	private static final String USER_QUESTION = "Enter Interface Name";
	public CreateRequiredInterface(IFeatureProvider fp) {
		super(fp, "Required Interface", "Add Required Interface");
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
		
		addGraphicalRepresentation(context, newClass);
		newClass.setIsProvidedInterface(false);
		if (bo instanceof Function)
		{
			Function f = (Function)bo;
			newClass.setAssociatedFunction(f);
			f.getInterfaces().add(newClass);
			
		}
		
		return new Object[] {newClass};
	}
}