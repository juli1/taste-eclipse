package nl.esa.tec.swe.taste.graphic;


import nl.esa.tec.swe.taste.commands.Utils;
import nl.esa.tec.swe.taste.metamodel.taste.Board;
import nl.esa.tec.swe.taste.metamodel.taste.Bus;
import nl.esa.tec.swe.taste.metamodel.taste.TasteFactory;

import org.eclipse.graphiti.examples.common.ExampleUtil;
import org.eclipse.graphiti.features.*;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.*;
import org.eclipse.graphiti.mm.pictograms.Diagram;


public class CreateBus extends AbstractCreateFeature {
	private static final String TITLE = "New Processor";
	private static final String USER_QUESTION = "Enter Bus Name";
	public CreateBus(IFeatureProvider fp) {
		super(fp, "Bus", "Add Bus");
	}

	public boolean canCreate(ICreateContext context) {

		return context.getTargetContainer() instanceof Diagram;

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
		Bus newClass = TasteFactory.eINSTANCE.createBus();
		getDiagram().eResource().getContents().add(newClass);
		newClass.setName(newClassName);
		addGraphicalRepresentation(context, newClass);

		return new Object[] {newClass};
	}
}