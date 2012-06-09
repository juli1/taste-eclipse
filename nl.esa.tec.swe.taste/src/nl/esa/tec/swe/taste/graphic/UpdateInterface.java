package nl.esa.tec.swe.taste.graphic;


import nl.esa.tec.swe.taste.metamodel.taste.Interface;

import org.eclipse.graphiti.features.*;
import org.eclipse.graphiti.features.context.*;
import org.eclipse.graphiti.features.impl.*;
import org.eclipse.graphiti.mm.algorithms.*;
import org.eclipse.graphiti.mm.pictograms.*;


public class UpdateInterface extends AbstractUpdateFeature {

	public UpdateInterface (IFeatureProvider fp) {
		super(fp);
	}


	public boolean canUpdate(IUpdateContext context) {

		Object bo = getBusinessObjectForPictogramElement(context.getPictogramElement()); 
		return (bo instanceof Interface);
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
		if (bo instanceof Interface) {
			Interface eClass = (Interface) bo;
			businessName = eClass.getName();
		}

		boolean updateNameNeeded = ((pictogramName == null && businessName != null) || (pictogramName != null && !pictogramName.equals(businessName)));
		if (updateNameNeeded) {
			return Reason.createTrueReason("[UpdateInterface] Name is out of date");
		} else {
			return Reason.createFalseReason();


		}
	}

	public boolean update(IUpdateContext context) {
		String businessName = null;
		String newStr = "";
		Interface eClass = null;
		PictogramElement pictogramElement = context.getPictogramElement();
		Object bo = getBusinessObjectForPictogramElement(pictogramElement);
		if (bo instanceof Interface) {
			eClass = (Interface) bo;
			businessName = eClass.getName();
		}

		if (pictogramElement instanceof ContainerShape) {
			ContainerShape cs = (ContainerShape) pictogramElement;
			for (Shape shape : cs.getChildren()) {
				if (shape.getGraphicsAlgorithm() instanceof Text) {
					Text text = (Text) shape.getGraphicsAlgorithm();
					newStr = "Interface " + businessName;
					if ((eClass != null) && (eClass.isIsProvidedInterface()))
					{
						newStr += " (PI)";
					}
					else
					{
						newStr += " (RI)";
					}
					text.setValue(newStr);
					return true;
				}
			}
		}
		return false;
	}
}
