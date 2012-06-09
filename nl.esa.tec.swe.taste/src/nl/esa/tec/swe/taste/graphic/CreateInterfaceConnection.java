package nl.esa.tec.swe.taste.graphic;

import nl.esa.tec.swe.taste.graphic.properties.Constants;
import nl.esa.tec.swe.taste.metamodel.taste.*;


import org.eclipse.graphiti.features.context.*;
import org.eclipse.graphiti.features.context.impl.AddConnectionContext;
import org.eclipse.graphiti.features.impl.*;
import org.eclipse.graphiti.features.*;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;

public class CreateInterfaceConnection extends AbstractCreateConnectionFeature {

	public CreateInterfaceConnection (IFeatureProvider fp)
	{
		super (fp, "Interface Connection", "Connect a Provided and a Required Interface");
	}

	public boolean canCreate(ICreateConnectionContext context) {
		Interface src;
		Interface dst;
		

		src = getRequiredInterface (context.getSourceAnchor());
		dst = getProvidedInterface (context.getTargetAnchor());

		if (src.getConnections().size() != 0)
		{
			return false;
		}
		if (dst == null)
		{
			return false;
		}
		if (dst.getConnections().size() != 0)
		{
			return false;
		}
		
		if ((src != null) && (dst != null))
		{
			if (dst.getInterfaceType() != Constants.INTERFACE_CYCLIC_INDEX)
			{
				return true;
			}
		}
		
		return false;
	}

	public boolean canStartConnection(ICreateConnectionContext context) {

		if (getRequiredInterface(context.getSourceAnchor()) != null)
		{
			return true;
		}
		return false;
	}

	public Connection create(ICreateConnectionContext context) {
		Connection newConnection = null;
		Interface src;
		Interface dst;
		
		src = getProvidedInterface (context.getSourceAnchor());
		if (src == null)
		{
			src = getProvidedInterface (context.getTargetAnchor());
		}
		
		dst = getRequiredInterface (context.getSourceAnchor());
		if (dst == null)
		{
			dst = getRequiredInterface (context.getTargetAnchor());
		}
		
		
		if (src != null && dst != null) {

			InterfaceConnection eReference = createInterfaceConnection(src, dst);
			getDiagram().eResource().getContents().add(eReference);
			
			AddConnectionContext addContext =

					new AddConnectionContext(context.getSourceAnchor(), context.getTargetAnchor());
			addContext.setNewObject(eReference);
			newConnection =
					(Connection) getFeatureProvider().addIfPossible(addContext);
		}
		return newConnection;
	}


	private Interface getRequiredInterface(Anchor anchor)
	{
		Object obj;
		obj = null;
		if (anchor != null)
		{
			obj = getBusinessObjectForPictogramElement(anchor.getParent());
			if (obj instanceof Interface)
			{
				if (((Interface)obj).isIsProvidedInterface() == false)
				{
					return (Interface) obj;
				}
			}
		}
		return null;
	}

	private Interface getProvidedInterface(Anchor anchor)
	{
		Object obj;
		obj = null;
		if (anchor != null)
		{
			obj = getBusinessObjectForPictogramElement(anchor.getParent());
			if (obj instanceof Interface)
			{
				if (((Interface)obj).isIsProvidedInterface() == true)
				{
					return (Interface) obj;
				}
			}
		}
		return null;
	}
	
	private InterfaceConnection createInterfaceConnection(Interface pi, Interface ri) {
		InterfaceConnection eReference = TasteFactory.eINSTANCE.createInterfaceConnection();
		eReference.setProvidedInterface(pi);
		eReference.setRequiredInterface(ri);
		pi.getConnections().add(eReference);
		ri.getConnections().add(eReference);
		
		return eReference;
	}
}