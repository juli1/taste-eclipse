package nl.esa.tec.swe.taste.main;

import nl.esa.tec.swe.taste.graphic.*;
import nl.esa.tec.swe.taste.metamodel.taste.*;

import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.ICreateConnectionFeature;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IFeature;
import org.eclipse.graphiti.features.ILayoutFeature;
import org.eclipse.graphiti.features.IMoveShapeFeature;
import org.eclipse.graphiti.features.IUpdateFeature;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ILayoutContext;
import org.eclipse.graphiti.features.context.IMoveShapeContext;
import org.eclipse.graphiti.features.context.IPictogramElementContext;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.ui.features.DefaultFeatureProvider;


public class MyFeatureProvider extends DefaultFeatureProvider {
	
	
	
	public MyFeatureProvider(IDiagramTypeProvider dtp) {
		super (dtp);
		
	}

	
	public IUpdateFeature getUpdateMethod (IUpdateContext c)
	{
		return getUpdateFeature(c);
	}
	
	public IMoveShapeFeature getMoveShapeFeature(IMoveShapeContext context) {
		Shape shape = context.getShape();
		Object bo = getBusinessObjectForPictogramElement(shape);
		if (bo instanceof Interface) 
		{
			return new MoveInterface(this);
		}
		return super.getMoveShapeFeature(context);
	}
	
	
	public IAddFeature getAddFeature(IAddContext context) {
		if (context.getNewObject() instanceof Board)
		{
			return new AddBoard(this);
		}
/*
		if (context.getNewObject() instanceof Processor)
		{
			return new AddProcessor(this);
		}
*/
		if (context.getNewObject() instanceof Function)
		{
			return new AddFunction(this);
		}

		if (context.getNewObject() instanceof Interface)
		{
			return new AddInterface(this);
		}		
		
		if (context.getNewObject() instanceof Bus)
		{
			return new AddBus(this);
		}
		
		if (context.getNewObject() instanceof Driver)
		{
			return new AddDriver(this);
		}
		
		if (context.getNewObject() instanceof BusConnection)
		{
			return new AddBusConnection(this);
		}
		
		
		if (context.getNewObject() instanceof InterfaceConnection)
		{
			return new AddInterfaceConnection(this);
		}
		
		return super.getAddFeature(context);
	}

	public ICreateFeature[] getCreateFeatures() {

		return new ICreateFeature[]
				{ new CreateBoard(this),
				/*
				  new CreateProcessor(this),
				*/ 
				  new CreateDriver (this),
				  new CreateBus (this),
				  new CreateFunction (this),
				  new CreateProvidedInterface (this),
				  new CreateRequiredInterface (this)
				  };
	}
	
	public ICreateConnectionFeature[] getCreateConnectionFeatures() {
		return new ICreateConnectionFeature[] {
				new CreateBusConnection (this),
				new CreateInterfaceConnection(this)
		};
	}
	public IFeature[] getDragAndDropFeatures(IPictogramElementContext context) {
		return getCreateConnectionFeatures();
	}

	public IUpdateFeature getUpdateFeature(IUpdateContext context)
	{

		PictogramElement pictogramElement = context.getPictogramElement(); 
		if (pictogramElement instanceof ContainerShape) {
			Object bo = getBusinessObjectForPictogramElement(pictogramElement);
			if (bo instanceof Board)
			{
				return new UpdateBoard(this);
			}
			
			if (bo instanceof Processor)
			{
				return new UpdateProcessor (this);
			}
			
			if (bo instanceof Driver)
			{
				return new UpdateDriver (this);
			}
			
			if (bo instanceof Bus)
			{
				return new UpdateBus (this);
			}

			if (bo instanceof Function)
			{
				return new UpdateFunction (this);
			}	
			
			if (bo instanceof Interface)
			{
				return new UpdateInterface (this);
			}	
			
		}
		return super.getUpdateFeature(context);
	}
	
	
	public ILayoutFeature getLayoutFeature(ILayoutContext context)
	{
		PictogramElement pictogramElement = context.getPictogramElement();
		Object bo = getBusinessObjectForPictogramElement(pictogramElement);
		
		if (bo instanceof Board)
		{
			return new LayoutBoard(this);
		}
		
		if (bo instanceof Processor)
		{
			return new LayoutProcessor(this);
		}
		
		if (bo instanceof Driver)
		{
			return new LayoutDriver(this);
		}
		
		if (bo instanceof Bus)
		{
			return new LayoutBus(this);
		}
		
		if (bo instanceof Function)
		{
			return new LayoutFunction(this);
		}
	
		if (bo instanceof Interface)
		{
			return new LayoutInterface(this);
		}
		
		return super.getLayoutFeature(context);
	}
}