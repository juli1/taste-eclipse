package nl.esa.tec.swe.taste.graphic;


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
import nl.esa.tec.swe.taste.metamodel.taste.Board;

 
public class AddBoard extends AbstractAddShapeFeature
{

	private static final IColorConstant CLASS_TEXT_FOREGROUND =
			new ColorConstant(51, 51, 153);

	private static final IColorConstant CLASS_FOREGROUND =
			new ColorConstant(255, 102, 0);

	private static final IColorConstant CLASS_BACKGROUND =
			new ColorConstant(255, 204, 153);

	public AddBoard(IFeatureProvider fp) {

		super(fp);
	}

	public boolean canAdd(IAddContext context) {

		if (context.getNewObject() instanceof Board) {
			if (context.getTargetContainer() instanceof Diagram) {

				return true;
			}
		}
		return false;
	}

	public PictogramElement add(IAddContext context) {
		RoundedRectangle roundedRectangle ;
		Board addedClass = (Board) context.getNewObject();
		Diagram targetDiagram = (Diagram) context.getTargetContainer();
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
			roundedRectangle.setFilled(false);
			gaService.setLocationAndSize(roundedRectangle,
					context.getX(), context.getY(), width, height);
			if (addedClass.eResource() == null) {
				getDiagram().eResource().getContents().add(addedClass);
			}
			link(containerShape, addedClass);
		}
		{
			Shape shape = peCreateService.createShape(containerShape, false);
			Polyline polyline =
					gaService.createPolyline(shape, new int[] { 0, 20, width, 20 });
			polyline.setForeground(manageColor(CLASS_FOREGROUND));
			polyline.setLineWidth(2);
		}
		{
			Shape shape = peCreateService.createShape(containerShape, false);
			Text text = gaService.createDefaultText(getDiagram(), shape,
					"Board " + addedClass.getName());
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

		
		 return containerShape;
	}
}
