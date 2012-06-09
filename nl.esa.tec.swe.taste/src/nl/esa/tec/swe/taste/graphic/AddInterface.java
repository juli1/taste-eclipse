package nl.esa.tec.swe.taste.graphic;


import org.eclipse.graphiti.mm.algorithms.Polygon;
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

import nl.esa.tec.swe.taste.metamodel.taste.Interface;
import nl.esa.tec.swe.taste.metamodel.taste.Function;

 
public class AddInterface extends AbstractAddShapeFeature
{

	private static final IColorConstant CLASS_TEXT_FOREGROUND =
			new ColorConstant(51, 01, 153);

	private static final IColorConstant CLASS_FOREGROUND =
			new ColorConstant(255, 02, 0);

	private static final IColorConstant CLASS_BACKGROUND =
			new ColorConstant(255, 04, 153);

	public AddInterface(IFeatureProvider fp) {

		super(fp);
	}

	public boolean canAdd(IAddContext context) 
	{

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

	public PictogramElement add(IAddContext context) {
		//RoundedRectangle roundedRectangle ;
		Polygon triangle;
		Interface addedClass = (Interface) context.getNewObject();
		addedClass.setIsProvidedInterface(true);
		ContainerShape targetDiagram =  context.getTargetContainer();
		IPeCreateService peCreateService = Graphiti.getPeCreateService();
		ContainerShape containerShape =
				peCreateService.createContainerShape(targetDiagram, true);
		int width = 50;
		int height = 50;
		
		IGaService gaService = Graphiti.getGaService();
		{
			int xy[] = new int[] { Constants.INTERFACE_TRIANGLE_SIZE, 0, Constants.INTERFACE_TRIANGLE_SIZE * 2, Constants.INTERFACE_TRIANGLE_SIZE * 2, 0, Constants.INTERFACE_TRIANGLE_SIZE * 2 };
			if (addedClass.isIsProvidedInterface())
			{
				xy = new int[] { 0,  0, Constants.INTERFACE_TRIANGLE_SIZE * 2, Constants.INTERFACE_TRIANGLE_SIZE,  0,  Constants.INTERFACE_TRIANGLE_SIZE * 2 };
			}
			else
			{
				xy = new int[] { 0,  Constants.INTERFACE_TRIANGLE_SIZE, Constants.INTERFACE_TRIANGLE_SIZE * 2,   0, Constants.INTERFACE_TRIANGLE_SIZE * 2,   Constants.INTERFACE_TRIANGLE_SIZE * 2 };
			}
			
			int x;
			int y;
			triangle = gaService.createPolygon(containerShape, xy);
			triangle.setForeground(manageColor(CLASS_FOREGROUND));
			triangle.setBackground(manageColor(CLASS_BACKGROUND));
			triangle.setLineWidth(2);
			triangle.setFilled(false);
			if (addedClass.isIsProvidedInterface())
			{
				x = containerShape.getGraphicsAlgorithm().getX();
				y = containerShape.getGraphicsAlgorithm().getY() + height;
			}
			else
			{
				x = containerShape.getGraphicsAlgorithm().getX() - width;
				y = containerShape.getGraphicsAlgorithm().getY();
			}
			gaService.setLocationAndSize(triangle, x, y, width, height);
			//gaService.setLocationAndSize(triangle,
			//		context.getX(), context.getY(), width, height);
			/*
			roundedRectangle = gaService.createRoundedRectangle(containerShape, 5, 5);
			roundedRectangle.setForeground(manageColor(CLASS_FOREGROUND));
			roundedRectangle.setBackground(manageColor(CLASS_BACKGROUND));
			roundedRectangle.setLineWidth(2);
			roundedRectangle.setFilled(false);
			gaService.setLocationAndSize(roundedRectangle,
					context.getX(), context.getY(), width, height);
					*/
			if (addedClass.eResource() == null) {
				getDiagram().eResource().getContents().add(addedClass);
			}
			link(containerShape, addedClass);
		}
		{
			Shape shape = peCreateService.createShape(containerShape, false);
			Text text = gaService.createDefaultText(getDiagram(), shape, addedClass.getName());
			text.setForeground(manageColor(CLASS_TEXT_FOREGROUND));
			text.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER);
			text.setVerticalAlignment(Orientation.ALIGNMENT_CENTER);
			text.setFont (gaService.manageFont(getDiagram(), "Arial", 14, true, true));
			gaService.setLocationAndSize(text, 0, 20, 100, 20);
			link(shape, addedClass);
		}
		{
			peCreateService.createChopboxAnchor(containerShape);
		
			layoutPictogramElement(containerShape);
		}

		
		 return containerShape;
	}
}
