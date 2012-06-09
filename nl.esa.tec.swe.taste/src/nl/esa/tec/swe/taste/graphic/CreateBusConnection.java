package nl.esa.tec.swe.taste.graphic;

import nl.esa.tec.swe.taste.metamodel.taste.*;


import org.eclipse.graphiti.features.context.*;
import org.eclipse.graphiti.features.context.impl.AddConnectionContext;
import org.eclipse.graphiti.features.impl.*;
import org.eclipse.graphiti.features.*;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;

public class CreateBusConnection extends AbstractCreateConnectionFeature {

	public CreateBusConnection (IFeatureProvider fp)
	{
		super (fp, "Bus Connection", "Connect a Bus and a Driver");
	}

	public boolean canCreate(ICreateConnectionContext context) {
		Bus src;
		Driver dst;
		
		src = getBus (context.getSourceAnchor());
		if (src == null)
		{
			src = getBus (context.getTargetAnchor());
		}
		
		dst = getDriver (context.getSourceAnchor());
		if (dst == null)
		{
			dst = getDriver (context.getTargetAnchor());
		}
				

		if (dst.getConnections().size() > 0)
		{
			return false;
		}
		
		if ((src != null && dst != null) && (src.getType().equals(dst.getType())))
		{
			return true;
		}
		
		return false;
	}

	public boolean canStartConnection(ICreateConnectionContext context) {

		if (getDriver(context.getSourceAnchor()) != null)
		{
			return true;
		}
		return false;
	}

	public Connection create(ICreateConnectionContext context) {
		Connection newConnection = null;
		Bus src;
		Driver dst;
		
		src = getBus (context.getSourceAnchor());
		if (src == null)
		{
			src = getBus (context.getTargetAnchor());
		}
		
		dst = getDriver (context.getSourceAnchor());
		if (dst == null)
		{
			dst = getDriver (context.getTargetAnchor());
		}
		
		
		if (src != null && dst != null) {

			BusConnection eReference = createBusConnection(src, dst);
			getDiagram().eResource().getContents().add(eReference);
			
			AddConnectionContext addContext =

					new AddConnectionContext(context.getSourceAnchor(), context.getTargetAnchor());
			addContext.setNewObject(eReference);
			newConnection =
					(Connection) getFeatureProvider().addIfPossible(addContext);
		}
		return newConnection;
	}


	private Driver getDriver(Anchor anchor)
	{
		Object obj;
		obj = null;
		if (anchor != null)
		{
			obj = getBusinessObjectForPictogramElement(anchor.getParent());
			if (obj instanceof Driver)
			{
				return (Driver) obj;
			}
		}
		return null;
	}


	private Bus getBus(Anchor anchor)
	{
		Object obj;
		obj = null;
		if (anchor != null)
		{
			obj = getBusinessObjectForPictogramElement(anchor.getParent());
			if (obj instanceof Bus)
			{
				return (Bus) obj;
			}
		} 
		return null;
	}
	
	private BusConnection createBusConnection(Bus source, Driver target) {
		BusConnection eReference = TasteFactory.eINSTANCE.createBusConnection();
		System.out.println("[CreateBusConnection] source bus=" + source);
		System.out.println("[CreateBusConnection] target drv=" + target);
		eReference.setAssociatedBus(source);
		eReference.setAssociatedDriver(target);
		target.getConnections().add(eReference);
		source.getConnections().add(eReference);
		
		return eReference;
		
	}
}