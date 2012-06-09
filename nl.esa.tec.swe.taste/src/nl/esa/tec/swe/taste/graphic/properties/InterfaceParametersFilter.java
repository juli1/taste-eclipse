package nl.esa.tec.swe.taste.graphic.properties;

import nl.esa.tec.swe.taste.metamodel.taste.Interface;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.platform.AbstractPropertySectionFilter;


public class InterfaceParametersFilter extends AbstractPropertySectionFilter {
	protected boolean accept(PictogramElement pe) {
		EObject eObject =
				Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
		if (eObject instanceof Interface)
		{
			Interface itf = (Interface) eObject;
			
			if ( (itf.isIsProvidedInterface()) && (itf.getInterfaceType() != Constants.INTERFACE_CYCLIC_INDEX))
			{
				return true;
			}
		}
		return false;
	}

}