package nl.esa.tec.swe.taste.graphic;

import nl.esa.tec.swe.taste.metamodel.taste.Interface;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IMoveShapeContext;
import org.eclipse.graphiti.features.impl.DefaultMoveShapeFeature;
import org.eclipse.graphiti.mm.algorithms.Polygon;
import org.eclipse.graphiti.mm.algorithms.styles.Point;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;

public class MoveInterface extends DefaultMoveShapeFeature {

	private static final int MARGIN = 20;
	private static final int FIGURE_SIZE = Constants.INTERFACE_TRIANGLE_SIZE;
	private static final int POSITION_TOP = 1;
	private static final int POSITION_BOTTOM = 2;
	private static final int POSITION_LEFT = 3;
	private static final int POSITION_RIGHT = 4;
	
	
	public MoveInterface(IFeatureProvider fp) 
	{
		super(fp);
	}

	protected void postMoveShape(IMoveShapeContext context)
	{
		int position = POSITION_LEFT;
		Shape shape = context.getShape();
		Object bo = getBusinessObjectForPictogramElement(shape);
		if (bo instanceof Interface)
		{
			Interface itf = (Interface) bo;
			ContainerShape container = shape.getContainer();
			int container_x = container.getGraphicsAlgorithm().getX();
			int container_y = container.getGraphicsAlgorithm().getY();
			int container_w = container.getGraphicsAlgorithm().getWidth();
			int container_h = container.getGraphicsAlgorithm().getHeight();
			int new_x = context.getX();
			int new_y = context.getY();
			
			System.out.println ("[MoveInterface] container_x = " + container_x);
			System.out.println ("[MoveInterface] container_y = " + container_y);
			System.out.println ("[MoveInterface] container_w = " + container_w);
			System.out.println ("[MoveInterface] container_h = " + container_h);
			System.out.println ("[MoveInterface] new_x = " + new_x);
			System.out.println ("[MoveInterface] new_y = " + new_y);
			int xy[];
			 xy = new int[] { FIGURE_SIZE, 0, FIGURE_SIZE * 2, FIGURE_SIZE * 2, 0, FIGURE_SIZE * 2 };
			 
			// Move on the top
			if ((new_y < 20) && 
				(new_x <= container_w))
			{
				position = POSITION_TOP;
				if (! itf.isIsProvidedInterface())
				{
					xy = new int[] { FIGURE_SIZE, 0,  FIGURE_SIZE * 2, FIGURE_SIZE * 2,  0, FIGURE_SIZE * 2 };
				}
				else
				{
					xy = new int[] { 0,   0, FIGURE_SIZE * 2,   0, FIGURE_SIZE,  FIGURE_SIZE * 2 };
				}

				System.out.println ("[MoveInterface] ON TOP");
			}
			// Move on the left				
			if ((new_x < 20) && 
				(new_y <= container_h))
			{
				position = POSITION_LEFT;
				if (! itf.isIsProvidedInterface())
				{
					xy = new int[] { 0,  FIGURE_SIZE, FIGURE_SIZE * 2,   0, FIGURE_SIZE * 2,   FIGURE_SIZE * 2 };
				}
				else
				{
					xy = new int[] { 0,  0, FIGURE_SIZE * 2, FIGURE_SIZE,  0,  FIGURE_SIZE * 2 };
				}

				System.out.println ("[MoveInterface] ON LEFT");
			}
			
			if ((new_x < container_w) && 
				(new_y <= container_h + MARGIN)&&
				(new_y >= container_h - MARGIN - 40))
			{
				if (! itf.isIsProvidedInterface())
				{
					xy = new int[] { 0,   0, FIGURE_SIZE * 2,   0, FIGURE_SIZE,  FIGURE_SIZE * 2 };
				}
				else
				{
					xy = new int[] { FIGURE_SIZE, 0,  FIGURE_SIZE * 2, FIGURE_SIZE * 2,  0, FIGURE_SIZE * 2 };
				}
				position = POSITION_BOTTOM;
				System.out.println ("[MoveInterface] ON BOTTOM");
			}
				// Move on the right				
			if ((new_y < container_h) && 
				(new_x <= container_w + MARGIN)&&
				(new_x >= container_w - MARGIN - 20))
			{
				position = POSITION_RIGHT;
				if (! itf.isIsProvidedInterface())
				{
					xy = new int[] { 0,  0, FIGURE_SIZE * 2, FIGURE_SIZE,  0,  FIGURE_SIZE * 2 };
				}
				else
				{
					xy = new int[] { 0,  FIGURE_SIZE, FIGURE_SIZE * 2,   0, FIGURE_SIZE * 2,   FIGURE_SIZE * 2 };
				}

			 	System.out.println ("[MoveInterface] ON RIGHT");
			}
		 
			System.out.println ("[MoveInterface] shape = " + shape);
			if (shape.getGraphicsAlgorithm() instanceof Polygon)
			{
				Polygon pg = (Polygon) shape.getGraphicsAlgorithm();
				System.out.println ("[MoveInterface] instance of polygon");
				int iter = 0;
				for ( Point point : pg.getPoints())
				{
					System.out.println ("[MoveInterface] iter = " + iter + "x=" + xy[iter] + " y= " + xy[iter+1]);
					point.setX(xy[iter]);
					iter++;
					point.setY(xy[iter]);
					iter++;
				}
				
				new_x = pg.getX();
				new_y = pg.getY();
				
				switch(position)
				{
					case POSITION_LEFT:
					{
						new_x = 0;
						break;
					}
					case POSITION_RIGHT:
					{
						new_x = container.getGraphicsAlgorithm().getWidth() - FIGURE_SIZE * 2;
						break;
					}
					case POSITION_BOTTOM:
					{
						new_y = container.getGraphicsAlgorithm().getHeight() - FIGURE_SIZE * 2 ;
						break;
					}
					case POSITION_TOP:
					{
						new_y = 0;
						break;
					}
				}
				
				System.out.println ("[MoveInterface] Moving to x=" + new_x + " y=" + new_y);

				Graphiti.getGaService().setLocation(pg, new_x, new_y);
			}
		}
	}

	protected void preMoveShape(IMoveShapeContext context) {
	}
	
	
	public boolean canMoveShape(IMoveShapeContext context) 
	{
		boolean canMove = super.canMoveShape(context);
		if (canMove)
		{
			Shape shape = context.getShape();
			Object bo = getBusinessObjectForPictogramElement(shape);
			if (bo instanceof Interface)
			{
				canMove = false;
				Interface itf = (Interface) bo;
				ContainerShape container = shape.getContainer();
				int container_x = container.getGraphicsAlgorithm().getX();
				int container_y = container.getGraphicsAlgorithm().getY();
				int container_w = container.getGraphicsAlgorithm().getWidth();
				int container_h = container.getGraphicsAlgorithm().getHeight();
				int new_x = context.getX();
				int new_y = context.getY();
				
				System.out.println ("[MoveInterface] container_x = " + container_x);
				System.out.println ("[MoveInterface] container_y = " + container_y);
				System.out.println ("[MoveInterface] container_w = " + container_w);
				System.out.println ("[MoveInterface] container_h = " + container_h);
				System.out.println ("[MoveInterface] new_x = " + new_x);
				System.out.println ("[MoveInterface] new_y = " + new_y);
				
				// Move on the top
				if ((new_y < 20) && 
					(new_x <= container_w))
				{
					System.out.println ("[MoveInterface] Can move on the top");
					canMove = true;
				}
				// Move on the left				
				if ((new_x < 20) && 
					(new_y <= container_h))
					{
						System.out.println ("[MoveInterface] Can move on the left");
						canMove = true;
					}
				// Move on the bottom				
				if ((new_x < container_w) && 
						
					(new_y <= container_h + MARGIN)&&
					(new_y >= container_h - MARGIN - 40))
					{
						System.out.println ("[MoveInterface] Can move on the bottom");
						canMove = true;
					}
				// Move on the right				
				if ((new_y < container_h) && 
					(new_x <= container_w + MARGIN)&&
					(new_x >= container_w - MARGIN - 20))
					{
					 	System.out.println ("[MoveInterface] Can move on the right");
						canMove = true;
					}
			}
		}
		return canMove;
	}
}

