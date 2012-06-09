package nl.esa.tec.swe.taste.graphic;


import nl.esa.tec.swe.taste.commands.Utils;
import nl.esa.tec.swe.taste.metamodel.taste.Board;
import nl.esa.tec.swe.taste.metamodel.taste.Processor;
import nl.esa.tec.swe.taste.metamodel.taste.TasteFactory;

import org.eclipse.graphiti.examples.common.ExampleUtil;
import org.eclipse.graphiti.features.*;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.*;


public class CreateProcessor extends AbstractCreateFeature {
	private static final String TITLE = "New Processor";
	private static final String USER_QUESTION = "Enter Processor Name";
	public CreateProcessor(IFeatureProvider fp) {
		super(fp, "Processor", "Add Processor");
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
		/*
		return context.getTargetContainer() instanceof Diagram;
		*/
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
		Processor newClass = TasteFactory.eINSTANCE.createProcessor();
		getDiagram().eResource().getContents().add(newClass);
		newClass.setName(newClassName);
		addGraphicalRepresentation(context, newClass);

		return new Object[] {newClass};
	}
}