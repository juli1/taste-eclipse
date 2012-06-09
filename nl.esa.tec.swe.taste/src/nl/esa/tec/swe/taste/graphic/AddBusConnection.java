package nl.esa.tec.swe.taste.graphic;

import nl.esa.tec.swe.taste.metamodel.taste.BusConnection;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.graphiti.features.*;
import org.eclipse.graphiti.features.context.*;
import org.eclipse.graphiti.features.impl.*;
import org.eclipse.graphiti.mm.GraphicsAlgorithmContainer;
import org.eclipse.graphiti.mm.algorithms.*;
import org.eclipse.graphiti.mm.pictograms.*;
import org.eclipse.graphiti.services.*;
import org.eclipse.graphiti.util.IColorConstant;


public class AddBusConnection extends AbstractAddFeature {

	private Polyline createArrow(GraphicsAlgorithmContainer gaContainer) {

		IGaService gaService = Graphiti.getGaService();

		Polyline polyline = gaService.createPolyline(gaContainer, new int[] { -15, 10, 0, 0, -15, -10 });
		polyline.setForeground(manageColor(IColorConstant.BLACK));
		polyline.setLineWidth(2);
		return polyline;
	}


	public AddBusConnection (IFeatureProvider fp) {

		super(fp);
	}
	public PictogramElement add(IAddContext context) {
		IAddConnectionContext addConContext = (IAddConnectionContext) context;
		BusConnection addedEReference = (BusConnection) context.getNewObject();
		IPeCreateService peCreateService = Graphiti.getPeCreateService();


		Connection connection = peCreateService.createFreeFormConnection(getDiagram());
		connection.setStart(addConContext.getSourceAnchor());
		connection.setEnd(addConContext.getTargetAnchor());

		IGaService gaService = Graphiti.getGaService();
		Polyline polyline = gaService.createPolyline(connection);
		polyline.setLineWidth(2);
		polyline.setForeground(manageColor(IColorConstant.BLACK));

		link(connection, addedEReference);

		ConnectionDecorator textDecorator = peCreateService.createConnectionDecorator(connection, true,  0.5, true);
		Text text = gaService.createDefaultText(null,textDecorator);
		text.setForeground(manageColor(IColorConstant.BLACK));
		gaService.setLocation(text, 10, 0);
		BusConnection eReference = (BusConnection) context.getNewObject();
		
		text.setValue("bus connection");
		ConnectionDecorator cd;
		cd = peCreateService.createConnectionDecorator(connection, false, 1.0, true);
		createArrow(cd);
		System.out.println("added");
		return connection;
	}

	public boolean canAdd(IAddContext context) {
		if (context instanceof IAddConnectionContext
				&& context.getNewObject() instanceof BusConnection)
		{
			System.out.println("can add true");
			return true;
		}
		System.out.println("can add false");
		return false;
	}
}