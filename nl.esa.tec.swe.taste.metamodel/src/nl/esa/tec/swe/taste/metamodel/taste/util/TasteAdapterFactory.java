/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package nl.esa.tec.swe.taste.metamodel.taste.util;

import nl.esa.tec.swe.taste.metamodel.taste.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see nl.esa.tec.swe.taste.metamodel.taste.TastePackage
 * @generated
 */
public class TasteAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static TastePackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TasteAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = TastePackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TasteSwitch<Adapter> modelSwitch =
		new TasteSwitch<Adapter>() {
			@Override
			public Adapter caseFunction(Function object) {
				return createFunctionAdapter();
			}
			@Override
			public Adapter caseBoard(Board object) {
				return createBoardAdapter();
			}
			@Override
			public Adapter caseProcessor(Processor object) {
				return createProcessorAdapter();
			}
			@Override
			public Adapter caseDriver(Driver object) {
				return createDriverAdapter();
			}
			@Override
			public Adapter caseBus(Bus object) {
				return createBusAdapter();
			}
			@Override
			public Adapter casefctconn(fctconn object) {
				return createfctconnAdapter();
			}
			@Override
			public Adapter caseInterface(Interface object) {
				return createInterfaceAdapter();
			}
			@Override
			public Adapter caseBusConnection(BusConnection object) {
				return createBusConnectionAdapter();
			}
			@Override
			public Adapter caseInterfaceConnection(InterfaceConnection object) {
				return createInterfaceConnectionAdapter();
			}
			@Override
			public Adapter caseInterfaceParameter(InterfaceParameter object) {
				return createInterfaceParameterAdapter();
			}
			@Override
			public Adapter caseTasteComponent(TasteComponent object) {
				return createTasteComponentAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link nl.esa.tec.swe.taste.metamodel.taste.Function <em>Function</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see nl.esa.tec.swe.taste.metamodel.taste.Function
	 * @generated
	 */
	public Adapter createFunctionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link nl.esa.tec.swe.taste.metamodel.taste.Board <em>Board</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see nl.esa.tec.swe.taste.metamodel.taste.Board
	 * @generated
	 */
	public Adapter createBoardAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link nl.esa.tec.swe.taste.metamodel.taste.Processor <em>Processor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see nl.esa.tec.swe.taste.metamodel.taste.Processor
	 * @generated
	 */
	public Adapter createProcessorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link nl.esa.tec.swe.taste.metamodel.taste.Driver <em>Driver</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see nl.esa.tec.swe.taste.metamodel.taste.Driver
	 * @generated
	 */
	public Adapter createDriverAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link nl.esa.tec.swe.taste.metamodel.taste.Bus <em>Bus</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see nl.esa.tec.swe.taste.metamodel.taste.Bus
	 * @generated
	 */
	public Adapter createBusAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link nl.esa.tec.swe.taste.metamodel.taste.fctconn <em>fctconn</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see nl.esa.tec.swe.taste.metamodel.taste.fctconn
	 * @generated
	 */
	public Adapter createfctconnAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link nl.esa.tec.swe.taste.metamodel.taste.Interface <em>Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see nl.esa.tec.swe.taste.metamodel.taste.Interface
	 * @generated
	 */
	public Adapter createInterfaceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link nl.esa.tec.swe.taste.metamodel.taste.BusConnection <em>Bus Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see nl.esa.tec.swe.taste.metamodel.taste.BusConnection
	 * @generated
	 */
	public Adapter createBusConnectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link nl.esa.tec.swe.taste.metamodel.taste.InterfaceConnection <em>Interface Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see nl.esa.tec.swe.taste.metamodel.taste.InterfaceConnection
	 * @generated
	 */
	public Adapter createInterfaceConnectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link nl.esa.tec.swe.taste.metamodel.taste.InterfaceParameter <em>Interface Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see nl.esa.tec.swe.taste.metamodel.taste.InterfaceParameter
	 * @generated
	 */
	public Adapter createInterfaceParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link nl.esa.tec.swe.taste.metamodel.taste.TasteComponent <em>Component</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see nl.esa.tec.swe.taste.metamodel.taste.TasteComponent
	 * @generated
	 */
	public Adapter createTasteComponentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //TasteAdapterFactory
