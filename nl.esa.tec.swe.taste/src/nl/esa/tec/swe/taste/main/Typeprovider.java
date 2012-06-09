package nl.esa.tec.swe.taste.main;


import org.eclipse.graphiti.dt.*;


public class Typeprovider extends AbstractDiagramTypeProvider implements
		IDiagramTypeProvider {

	public Typeprovider ()
	{
		super ();
		setFeatureProvider (new MyFeatureProvider (this)); 
	} 
}
