package nl.esa.tec.swe.taste.graphic.properties;

import nl.esa.tec.swe.taste.metamodel.taste.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.platform.AbstractPropertySectionFilter;


public class NameFilter extends AbstractPropertySectionFilter {
	protected boolean accept(PictogramElement pe) {
		EObject eObject =
				Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
		if ((eObject instanceof Processor) ||
		    (eObject instanceof Driver) ||
		    (eObject instanceof Bus) ||
		    (eObject instanceof Function) ||
		    (eObject instanceof Interface) ||
		    (eObject instanceof Board))
			
		{
			return true;
		}
		return false;
	}

}