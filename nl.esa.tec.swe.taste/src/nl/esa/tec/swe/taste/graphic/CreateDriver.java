package nl.esa.tec.swe.taste.graphic;


import nl.esa.tec.swe.taste.commands.Utils;
import nl.esa.tec.swe.taste.metamodel.taste.Board;
import nl.esa.tec.swe.taste.metamodel.taste.Driver;
import nl.esa.tec.swe.taste.metamodel.taste.TasteFactory;

import org.eclipse.graphiti.examples.common.ExampleUtil;
import org.eclipse.graphiti.features.*;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.*;


public class CreateDriver extends AbstractCreateFeature {
	private static final String TITLE = "New Driver";
	private static final String USER_QUESTION = "Enter Driver Name";
	public CreateDriver(IFeatureProvider fp) {
		super(fp, "Driver", "Add Driver");
	}

	public boolean canCreate(ICreateContext context) {
		Object bo = getBusinessObjectForPictogramElement(context.getTargetContainer());
		if (bo == null)
		{
			return false;
		}

		if (bo instanceof Board)
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
		if ( ! Utils.isNameValid (newClassName))
		{
			Utils.showError("Invalid name, please respect naming rules", "");
			return null;
		}
		
		if (Utils.nameExists (newClassName, Utils.getRootComponent (context.getTargetContainer()))!=null)
		{
			Utils.showError("Invalid name, already exists in the model", "");
			return null;
		}
		
		Driver newClass = TasteFactory.eINSTANCE.createDriver();
		getDiagram().eResource().getContents().add(newClass);
		newClass.setName(newClassName);
		newClass.setConfig("driver configuration");
		System.out.println("[CreateDriver] class=" + bo.getClass());
		System.out.println("[CreateDriver] bo=" + bo);
		addGraphicalRepresentation(context, newClass);

		if (bo instanceof Board)
		{
			newClass.setAssociatedBoard((Board) bo);
			((Board) bo).getDrivers().add(newClass);
		}
		return new Object[] {newClass};
	}
}