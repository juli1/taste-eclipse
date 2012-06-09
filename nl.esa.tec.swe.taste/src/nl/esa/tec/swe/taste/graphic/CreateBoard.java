package nl.esa.tec.swe.taste.graphic;


import nl.esa.tec.swe.taste.metamodel.taste.Board;
import nl.esa.tec.swe.taste.metamodel.taste.TasteFactory;

import org.eclipse.graphiti.examples.common.ExampleUtil;
import org.eclipse.graphiti.features.*;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.*;
import org.eclipse.graphiti.mm.pictograms.Diagram;


public class CreateBoard extends AbstractCreateFeature {
	private static final String TITLE = "New Board";
	private static final String USER_QUESTION = "Enter Board Name";
	public CreateBoard(IFeatureProvider fp) {
		super(fp, "Board", "Add Board");
	}

	public boolean canCreate(ICreateContext context) {
		return context.getTargetContainer() instanceof Diagram;
	}

	public Object[] create(ICreateContext context) {


		String newClassName = ExampleUtil.askString(TITLE, USER_QUESTION, "");

		if (newClassName == null || newClassName.trim().length() == 0) {
			return EMPTY;
		}

		Board newClass = TasteFactory.eINSTANCE.createBoard();
		getDiagram().eResource().getContents().add(newClass);
		newClass.setName(newClassName);
		newClass.setType ("Native");
		addGraphicalRepresentation(context, newClass);

		return new Object[] {newClass};
	}
}