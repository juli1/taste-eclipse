package nl.esa.tec.swe.taste.commands;

import java.io.BufferedWriter;
import java.util.Vector;

import nl.esa.tec.swe.taste.graphic.properties.Constants;
import nl.esa.tec.swe.taste.metamodel.taste.Bus;
import nl.esa.tec.swe.taste.metamodel.taste.Driver;
import nl.esa.tec.swe.taste.metamodel.taste.Function;
import nl.esa.tec.swe.taste.metamodel.taste.Interface;
import nl.esa.tec.swe.taste.metamodel.taste.InterfaceConnection;
import nl.esa.tec.swe.taste.metamodel.taste.InterfaceParameter;

import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.services.Graphiti;

public class ModelValidation {

	private Diagram diagram;
	private boolean result;
	private String 	mainreason;
	private Vector<String> reasons;
	
	public ModelValidation (Diagram d)
	{
		this.diagram 		= d;
		this.result  		= false;
		this.mainreason 	= "unknown reason";
		this.reasons		= new Vector<String>();
	}
	
	private void addReason (String r)
	{
		this.reasons.add (r);
		this.mainreason 	= r;
		this.result 		= false;
	}
	
	private void browse (ContainerShape shape)
	{
		
		for (int i = 0 ; i < shape.getChildren().size() ; i++)
		{
			if (shape.getChildren().get(i) instanceof ContainerShape)
			{
				ContainerShape di = (ContainerShape)shape.getChildren().get(i);
				Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(di);

				if (bo == null)
				{
					System.out.println("[ModelValidation] null object");
				}
				else
				{
					System.out.println("[ModelValidation] Validate object" + bo );
					if (bo instanceof Function)
					{
						Function func = (Function) bo;
						boolean hasProvided = false;
						for (Interface myitf : func.getInterfaces())
						{
							if (myitf.isIsProvidedInterface())
							{
								hasProvided = true;
							}
						}
						if (! hasProvided)
						{
							addReason ("Function " + func.getName() + " has to have at least one provided interface");
						}
					}				
					if (bo instanceof Interface)
					{
						Interface itf = (Interface) bo;
						if ((itf.getInterfaceType() != Constants.INTERFACE_CYCLIC_INDEX ) && (itf.getConnections().size() <= 0))
						{
							addReason ("Interface " + itf.getName() + " not connected"); 
						}
						
						if ((! itf.isIsProvidedInterface()) && (itf.getConnections().size() <= 0))
						{
							addReason ("Interface " + itf.getName() + " not connected"); 
						}
					}
					if (bo instanceof Bus)
					{
						Bus mybus = (Bus) bo;
						if (mybus.getConnections().size() <= 0)
						{
							addReason ("Bus " + mybus.getName() + " not connected"); 
						}
					}
					
					if (bo instanceof Driver)
					{
						Driver mydriver = (Driver) bo;
						if (mydriver.getConnections().size() <= 0)
						{
							addReason ("Driver " + mydriver.getName() + " not connected"); 
						}
					}
				}
				browse (di);
			}
		}
	}
	
	public boolean validate()
	{
		this.result = true;
		browse (diagram);
		return result;
	}
	
	public boolean getResult ()
	{
		return this.result;
	}
	
	public String getReason ()
	{
		return this.mainreason;
	}
	

	public Vector<String> getReasons ()
	{
		return this.reasons;
	}
	
	
}
