package nl.esa.tec.swe.taste.graphic;

import java.util.Random;

import nl.esa.tec.swe.taste.metamodel.taste.Interface;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.datatypes.IDimension;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ILayoutContext;
import org.eclipse.graphiti.features.impl.AbstractLayoutFeature;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Polygon;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.Point;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;

public class LayoutInterface extends AbstractLayoutFeature {

	private static final int MIN_HEIGHT = 30;

	private static final int MIN_WIDTH = 50;
	private static final int MARGIN = 20;

	public LayoutInterface(IFeatureProvider fp) {
		super(fp);
	}


	public boolean canLayout(ILayoutContext context) {
		PictogramElement pe = context.getPictogramElement();
		if (!(pe instanceof ContainerShape))
		{
			System.out.println ("[LayoutInterface] Cannot Layout, not a container shape");
			return false;
		}
		EList<EObject> businessObjects = pe.getLink().getBusinessObjects();
		if (businessObjects.size() == 1 && businessObjects.get(0) instanceof Interface)
		{
			System.out.println ("[LayoutInterface] We have an interface");
			return true;
		}
		System.out.println ("[LayoutInterface] We DON'T have an interface, cannot layout");
		return false;
	}


	public boolean layout(ILayoutContext context) {
		boolean anythingChanged = false;

		ContainerShape containerShape = (ContainerShape) context.getPictogramElement();
		GraphicsAlgorithm containerGa = containerShape.getGraphicsAlgorithm();

		ContainerShape parentShape = containerShape.getContainer();
		/*
		int container_x = parentShape.getGraphicsAlgorithm().getX();
		int container_y = parentShape.getGraphicsAlgorithm().getY();
		int container_w = parentShape.getGraphicsAlgorithm().getWidth();
		int container_h = parentShape.getGraphicsAlgorithm().getHeight();
		int new_x = containerGa.getX();
		int new_y = containerGa.getY();
		
		System.out.println ("[LayoutInterface] container_x = " + container_x);
		System.out.println ("[LayoutInterface] container_y = " + container_y);
		System.out.println ("[LayoutInterface] container_w = " + container_w);
		System.out.println ("[LayoutInterface] container_h = " + container_h);
		System.out.println ("[LayoutInterface] my_x = " + new_x);
		System.out.println ("[LayoutInterface] my_y = " + new_y);
		int xy[];
		 xy = new int[] { 20, 0, 40, 40, 0, 40 };
		// Move on the top
		if ((new_y < 20) && 
			(new_x <= container_w))
		{
			 xy = new int[] { 20, 0, 40, 40, 0, 40 };
			System.out.println ("[LayoutInterface] Is on the top");
		}
		// Move on the left				
		if ((new_x < 20) && 
			(new_y <= container_h))
			{
			 	xy = new int[] { 0, 20, 40, 0, 40, 40 };
				System.out.println ("[LayoutInterface] Is on the left");
			}
		// Move on the bottom				
		if ((new_x < container_w) && 
				
			(new_y <= container_h + MARGIN)&&
			(new_y >= container_h - MARGIN))
			{
				xy = new int[] { 0, 0, 40, 0, 20, 40 };
				System.out.println ("[LayoutInterface] Is on the bottom");
			}
		// Move on the right				
		if ((new_y < container_h) && 
			(new_x <= container_w + MARGIN)&&
			(new_x >= container_w - MARGIN - 20))
			{
				xy = new int[] { 0, 0, 40, 20, 0, 40 };
			 	System.out.println ("[LayoutInterface] Is on the right");
			}
	
		IGaService gaService = Graphiti.getGaService();
		Polygon newTriangle = gaService.createPolygon(containerShape, xy);

		containerShape.setGraphicsAlgorithm(newTriangle.getParentGraphicsAlgorithm());
		*/
		//containerGa.setPictogramElement(newTriangle.getPictogramElement());
		anythingChanged = true;

		if (containerGa.getHeight() < MIN_HEIGHT) {
			containerGa.setHeight(MIN_HEIGHT);
			anythingChanged = true;
		}


		if (containerGa.getWidth() < MIN_WIDTH) {
			containerGa.setWidth(MIN_WIDTH);
			anythingChanged = true;
		}

		int containerWidth = containerGa.getWidth();

		for (Shape shape : containerShape.getChildren()){
			GraphicsAlgorithm graphicsAlgorithm = shape.getGraphicsAlgorithm();
			IGaService gaService = Graphiti.getGaService();
			if (shape.getGraphicsAlgorithm() instanceof Text)
			{
				System.out.println ("[LayoutInterface] change size of text ");
				gaService.setLocationAndSize(shape.getGraphicsAlgorithm(), 0, 00, 100, 20);

				anythingChanged = true;
			}
			/*
			IDimension size = gaService.calculateSize(graphicsAlgorithm);
			if (containerWidth != size.getWidth()) {
				if (graphicsAlgorithm instanceof Polyline) {
					Polyline polyline = (Polyline) graphicsAlgorithm;
					Point secondPoint = polyline.getPoints().get(1);
					Point newSecondPoint =gaService.createPoint(containerWidth, secondPoint.getY());
					polyline.getPoints().set(1, newSecondPoint);
					anythingChanged = true;
				} else {
					gaService.setWidth(graphicsAlgorithm,
							containerWidth);
					anythingChanged = true;
				}
			}*/
		}
		return anythingChanged;
	}
}