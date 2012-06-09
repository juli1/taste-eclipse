package nl.esa.tec.swe.taste.graphic;


import nl.esa.tec.swe.taste.commands.Utils;
import nl.esa.tec.swe.taste.metamodel.taste.Board;
import nl.esa.tec.swe.taste.metamodel.taste.Function;
import nl.esa.tec.swe.taste.metamodel.taste.TasteFactory;

import org.eclipse.graphiti.examples.common.ExampleUtil;
import org.eclipse.graphiti.features.*;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.*;


public class CreateFunction extends AbstractCreateFeature {
	private static final String TITLE = "New Function";
	private static final String USER_QUESTION = "Enter Function Name";
	public CreateFunction(IFeatureProvider fp) {
		super(fp, "Function", "Add Function");
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
		Function newClass = TasteFactory.eINSTANCE.createFunction();
		getDiagram().eResource().getContents().add(newClass);
		newClass.setName(newClassName);
		newClass.setLanguage("C");
		
		Object bo = getBusinessObjectForPictogramElement(context.getTargetContainer());

		if (bo instanceof Board)
		{
			newClass.setAssociatedBoard((Board) bo);
			((Board) bo).getFunctions().add(newClass);
		}
		
		addGraphicalRepresentation(context, newClass);
		
		Utils.refreshNavigator();
		return new Object[] {newClass};
	}
}