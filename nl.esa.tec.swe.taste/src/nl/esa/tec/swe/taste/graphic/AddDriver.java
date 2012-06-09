package nl.esa.tec.swe.taste.graphic;


import nl.esa.tec.swe.taste.metamodel.taste.Driver;
import nl.esa.tec.swe.taste.metamodel.taste.Board;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.algorithms.Rectangle;
import org.eclipse.graphiti.mm.algorithms.RoundedRectangle;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.Orientation;
import org.eclipse.graphiti.mm.pictograms.*;
import org.eclipse.graphiti.services.*;
import org.eclipse.graphiti.util.*;
import org.eclipse.graphiti.features.*;
import org.eclipse.graphiti.features.context.*;
import org.eclipse.graphiti.features.impl.*;

 
public class AddDriver extends AbstractAddShapeFeature
{

	private static final IColorConstant CLASS_TEXT_FOREGROUND =
			new ColorConstant(90, 51, 153);

	private static final IColorConstant CLASS_FOREGROUND =
			new ColorConstant(10, 102, 0);

	private static final IColorConstant CLASS_BACKGROUND =
			new ColorConstant(205, 204, 153);

	public AddDriver(IFeatureProvider fp) {

		super(fp);
	}

	public boolean canAdd(IAddContext context) {

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

	public PictogramElement add(IAddContext context) {

		RoundedRectangle roundedRectangle ;
		Driver addedClass = (Driver) context.getNewObject();
		System.out.println("target diagram" + context.getTargetContainer().toString());
		ContainerShape targetDiagram =  context.getTargetContainer();
		IPeCreateService peCreateService = Graphiti.getPeCreateService();
		ContainerShape containerShape =
				peCreateService.createContainerShape(targetDiagram, true);
		int width = context.getWidth() <= 0 ? 100 : context.getWidth();
		int height = context.getHeight() <= 0 ? 50 : context.getHeight();
		IGaService gaService = Graphiti.getGaService();
		{
			roundedRectangle = gaService.createRoundedRectangle(containerShape, 5, 5);
			roundedRectangle.setForeground(manageColor(CLASS_FOREGROUND));
			roundedRectangle.setBackground(manageColor(CLASS_BACKGROUND));
			roundedRectangle.setLineWidth(2);
			gaService.setLocationAndSize(roundedRectangle,
					context.getX(), context.getY(), width, height);

			if (addedClass.eResource() == null) {
				getDiagram().eResource().getContents().add(addedClass);
			}
			link(containerShape, addedClass);
		}
		
		{
			Shape shape = peCreateService.createShape(containerShape, false);
			Text text = gaService.createDefaultText(getDiagram(), shape,
					"Driver " + addedClass.getName());
			text.setForeground(manageColor(CLASS_TEXT_FOREGROUND));
			text.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER);
			text.setVerticalAlignment(Orientation.ALIGNMENT_CENTER);
			text.setFont (gaService.manageFont(getDiagram(), "Arial", 14, true, true));
			gaService.setLocationAndSize(text, 0, 0, width, 20);
			link(shape, addedClass);
		}
		{
			peCreateService.createChopboxAnchor(containerShape);
		
			layoutPictogramElement(containerShape);
		}
		
		/*
		{
		 peCreateService.createChopboxAnchor(containerShape);
		 
		 final BoxRelativeAnchor boxAnchor = peCreateService.createBoxRelativeAnchor(containerShape);
		 
		 boxAnchor.setRelativeWidth(1.0);
		 boxAnchor.setRelativeHeight(0.5);
		 
		 
		 boxAnchor.setReferencedGraphicsAlgorithm(roundedRectangle);
		 
		 Rectangle rectangle = gaService.createRectangle(boxAnchor);
		 rectangle.setFilled(true);
		 int w = 6;
		 gaService.setLocationAndSize(rectangle, -2 * w, -w, 2 * w, 2 * w);
		 rectangle.setForeground(manageColor(CLASS_FOREGROUND));
		 rectangle.setBackground(manageColor(CLASS_BACKGROUND));
		 
		 layoutPictogramElement(containerShape);
		}
		*/
		
		
		
		 return containerShape;
		 
	}
}
