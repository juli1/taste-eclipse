package nl.esa.tec.swe.taste.graphic.properties;

import nl.esa.tec.swe.taste.metamodel.taste.Board;
import nl.esa.tec.swe.taste.metamodel.taste.Processor;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.platform.AbstractPropertySectionFilter;


public class PlatformFilter extends AbstractPropertySectionFilter {
	protected boolean accept(PictogramElement pe) {
		EObject eObject =
				Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
		if (eObject instanceof Processor)
		{
			return true;
		}
		
		if (eObject instanceof Board)
		{
			return true;
		}
		return false;
	}

} 