/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package nl.esa.tec.swe.taste.metamodel.taste.impl;

import nl.esa.tec.swe.taste.metamodel.taste.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TasteFactoryImpl extends EFactoryImpl implements TasteFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TasteFactory init() {
		try {
			TasteFactory theTasteFactory = (TasteFactory)EPackage.Registry.INSTANCE.getEFactory("http://taste/1.0"); 
			if (theTasteFactory != null) {
				return theTasteFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new TasteFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TasteFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case TastePackage.FUNCTION: return createFunction();
			case TastePackage.BOARD: return createBoard();
			case TastePackage.PROCESSOR: return createProcessor();
			case TastePackage.DRIVER: return createDriver();
			case TastePackage.BUS: return createBus();
			case TastePackage.FCTCONN: return createfctconn();
			case TastePackage.INTERFACE: return createInterface();
			case TastePackage.BUS_CONNECTION: return createBusConnection();
			case TastePackage.INTERFACE_CONNECTION: return createInterfaceConnection();
			case TastePackage.INTERFACE_PARAMETER: return createInterfaceParameter();
			case TastePackage.TASTE_COMPONENT: return createTasteComponent();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Function createFunction() {
		FunctionImpl function = new FunctionImpl();
		return function;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Board createBoard() {
		BoardImpl board = new BoardImpl();
		return board;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Processor createProcessor() {
		ProcessorImpl processor = new ProcessorImpl();
		return processor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Driver createDriver() {
		DriverImpl driver = new DriverImpl();
		return driver;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Bus createBus() {
		BusImpl bus = new BusImpl();
		return bus;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public fctconn createfctconn() {
		fctconnImpl fctconn = new fctconnImpl();
		return fctconn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Interface createInterface() {
		InterfaceImpl interface_ = new InterfaceImpl();
		return interface_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BusConnection createBusConnection() {
		BusConnectionImpl busConnection = new BusConnectionImpl();
		return busConnection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InterfaceConnection createInterfaceConnection() {
		InterfaceConnectionImpl interfaceConnection = new InterfaceConnectionImpl();
		return interfaceConnection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InterfaceParameter createInterfaceParameter() {
		InterfaceParameterImpl interfaceParameter = new InterfaceParameterImpl();
		return interfaceParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TasteComponent createTasteComponent() {
		TasteComponentImpl tasteComponent = new TasteComponentImpl();
		return tasteComponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TastePackage getTastePackage() {
		return (TastePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static TastePackage getPackage() {
		return TastePackage.eINSTANCE;
	}

} //TasteFactoryImpl
