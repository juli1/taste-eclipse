package nl.esa.tec.swe.taste.graphic;


import nl.esa.tec.swe.taste.metamodel.taste.Driver;

import org.eclipse.graphiti.features.*;
import org.eclipse.graphiti.features.context.*;
import org.eclipse.graphiti.features.impl.*;
import org.eclipse.graphiti.mm.algorithms.*;
import org.eclipse.graphiti.mm.pictograms.*;


public class UpdateDriver extends AbstractUpdateFeature {

	public UpdateDriver (IFeatureProvider fp) {
		super(fp);
	}


	public boolean canUpdate(IUpdateContext context) {

		Object bo = getBusinessObjectForPictogramElement(context.getPictogramElement()); 
		return (bo instanceof Driver);
	}

	public IReason updateNeeded(IUpdateContext context) {

		String pictogramName = null;

		PictogramElement pictogramElement = context.getPictogramElement();

		if (pictogramElement instanceof ContainerShape) {

			ContainerShape cs = (ContainerShape) pictogramElement;

			for (Shape shape : cs.getChildren()) {

				if (shape.getGraphicsAlgorithm() instanceof Text) {

					Text text = (Text) shape.getGraphicsAlgorithm();

					pictogramName = text.getValue();}}}

		String businessName = null;
		Object bo = getBusinessObjectForPictogramElement(pictogramElement);
		if (bo instanceof Driver) {
			Driver eClass = (Driver) bo;
			businessName = eClass.getName();
		}

		boolean updateNameNeeded = ((pictogramName == null && businessName != null) || (pictogramName != null && !pictogramName.equals(businessName)));
		if (updateNameNeeded) {
			return Reason.createTrueReason("Name is out of date");
		} else {
			return Reason.createFalseReason();


		}
	}

	public boolean update(IUpdateContext context) {
		String businessName = null;
		PictogramElement pictogramElement = context.getPictogramElement();
		Object bo = getBusinessObjectForPictogramElement(pictogramElement);
		if (bo instanceof Driver) {
			Driver eClass = (Driver) bo;
			businessName = eClass.getName();
		}

		if (pictogramElement instanceof ContainerShape) {
			ContainerShape cs = (ContainerShape) pictogramElement;
			for (Shape shape : cs.getChildren()) {
				if (shape.getGraphicsAlgorithm() instanceof Text) {
					Text text = (Text) shape.getGraphicsAlgorithm();
					text.setValue("Driver " + businessName);
					return true;
				}
			}
		}
		return false;
	}
}
