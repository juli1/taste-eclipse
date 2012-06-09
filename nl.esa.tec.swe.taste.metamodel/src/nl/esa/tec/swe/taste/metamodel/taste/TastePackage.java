/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package nl.esa.tec.swe.taste.metamodel.taste;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see nl.esa.tec.swe.taste.metamodel.taste.TasteFactory
 * @model kind="package"
 * @generated
 */
public interface TastePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "taste";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://taste/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "taste";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TastePackage eINSTANCE = nl.esa.tec.swe.taste.metamodel.taste.impl.TastePackageImpl.init();

	/**
	 * The meta object id for the '{@link nl.esa.tec.swe.taste.metamodel.taste.impl.TasteComponentImpl <em>Component</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see nl.esa.tec.swe.taste.metamodel.taste.impl.TasteComponentImpl
	 * @see nl.esa.tec.swe.taste.metamodel.taste.impl.TastePackageImpl#getTasteComponent()
	 * @generated
	 */
	int TASTE_COMPONENT = 10;

	/**
	 * The feature id for the '<em><b>Component Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASTE_COMPONENT__COMPONENT_TYPE = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASTE_COMPONENT__NAME = 1;

	/**
	 * The number of structural features of the '<em>Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASTE_COMPONENT_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link nl.esa.tec.swe.taste.metamodel.taste.impl.FunctionImpl <em>Function</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see nl.esa.tec.swe.taste.metamodel.taste.impl.FunctionImpl
	 * @see nl.esa.tec.swe.taste.metamodel.taste.impl.TastePackageImpl#getFunction()
	 * @generated
	 */
	int FUNCTION = 0;

	/**
	 * The feature id for the '<em><b>Component Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__COMPONENT_TYPE = TASTE_COMPONENT__COMPONENT_TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__NAME = TASTE_COMPONENT__NAME;

	/**
	 * The feature id for the '<em><b>Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__LANGUAGE = TASTE_COMPONENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Interfaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__INTERFACES = TASTE_COMPONENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Associated Board</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__ASSOCIATED_BOARD = TASTE_COMPONENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_FEATURE_COUNT = TASTE_COMPONENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link nl.esa.tec.swe.taste.metamodel.taste.impl.BoardImpl <em>Board</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see nl.esa.tec.swe.taste.metamodel.taste.impl.BoardImpl
	 * @see nl.esa.tec.swe.taste.metamodel.taste.impl.TastePackageImpl#getBoard()
	 * @generated
	 */
	int BOARD = 1;

	/**
	 * The feature id for the '<em><b>Component Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOARD__COMPONENT_TYPE = TASTE_COMPONENT__COMPONENT_TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOARD__NAME = TASTE_COMPONENT__NAME;

	/**
	 * The feature id for the '<em><b>Boardcpu</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOARD__BOARDCPU = TASTE_COMPONENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOARD__TYPE = TASTE_COMPONENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Functions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOARD__FUNCTIONS = TASTE_COMPONENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Drivers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOARD__DRIVERS = TASTE_COMPONENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Board</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOARD_FEATURE_COUNT = TASTE_COMPONENT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link nl.esa.tec.swe.taste.metamodel.taste.impl.ProcessorImpl <em>Processor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see nl.esa.tec.swe.taste.metamodel.taste.impl.ProcessorImpl
	 * @see nl.esa.tec.swe.taste.metamodel.taste.impl.TastePackageImpl#getProcessor()
	 * @generated
	 */
	int PROCESSOR = 2;

	/**
	 * The feature id for the '<em><b>Component Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSOR__COMPONENT_TYPE = TASTE_COMPONENT__COMPONENT_TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSOR__NAME = TASTE_COMPONENT__NAME;

	/**
	 * The feature id for the '<em><b>Cpuboard</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSOR__CPUBOARD = TASTE_COMPONENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSOR__TYPE = TASTE_COMPONENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Processor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSOR_FEATURE_COUNT = TASTE_COMPONENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link nl.esa.tec.swe.taste.metamodel.taste.impl.DriverImpl <em>Driver</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see nl.esa.tec.swe.taste.metamodel.taste.impl.DriverImpl
	 * @see nl.esa.tec.swe.taste.metamodel.taste.impl.TastePackageImpl#getDriver()
	 * @generated
	 */
	int DRIVER = 3;

	/**
	 * The feature id for the '<em><b>Component Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRIVER__COMPONENT_TYPE = TASTE_COMPONENT__COMPONENT_TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRIVER__NAME = TASTE_COMPONENT__NAME;

	/**
	 * The feature id for the '<em><b>EReference0</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRIVER__EREFERENCE0 = TASTE_COMPONENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Associated Board</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRIVER__ASSOCIATED_BOARD = TASTE_COMPONENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Drvbus</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRIVER__DRVBUS = TASTE_COMPONENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRIVER__TYPE = TASTE_COMPONENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Config</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRIVER__CONFIG = TASTE_COMPONENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Connections</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRIVER__CONNECTIONS = TASTE_COMPONENT_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Driver</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRIVER_FEATURE_COUNT = TASTE_COMPONENT_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link nl.esa.tec.swe.taste.metamodel.taste.impl.BusImpl <em>Bus</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see nl.esa.tec.swe.taste.metamodel.taste.impl.BusImpl
	 * @see nl.esa.tec.swe.taste.metamodel.taste.impl.TastePackageImpl#getBus()
	 * @generated
	 */
	int BUS = 4;

	/**
	 * The feature id for the '<em><b>Component Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS__COMPONENT_TYPE = TASTE_COMPONENT__COMPONENT_TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS__NAME = TASTE_COMPONENT__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS__TYPE = TASTE_COMPONENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Connections</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS__CONNECTIONS = TASTE_COMPONENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Bus</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS_FEATURE_COUNT = TASTE_COMPONENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link nl.esa.tec.swe.taste.metamodel.taste.impl.fctconnImpl <em>fctconn</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see nl.esa.tec.swe.taste.metamodel.taste.impl.fctconnImpl
	 * @see nl.esa.tec.swe.taste.metamodel.taste.impl.TastePackageImpl#getfctconn()
	 * @generated
	 */
	int FCTCONN = 5;

	/**
	 * The feature id for the '<em><b>Connbus</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FCTCONN__CONNBUS = 0;

	/**
	 * The feature id for the '<em><b>Connfct</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FCTCONN__CONNFCT = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FCTCONN__NAME = 2;

	/**
	 * The number of structural features of the '<em>fctconn</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FCTCONN_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link nl.esa.tec.swe.taste.metamodel.taste.impl.InterfaceImpl <em>Interface</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see nl.esa.tec.swe.taste.metamodel.taste.impl.InterfaceImpl
	 * @see nl.esa.tec.swe.taste.metamodel.taste.impl.TastePackageImpl#getInterface()
	 * @generated
	 */
	int INTERFACE = 6;

	/**
	 * The feature id for the '<em><b>Direction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE__DIRECTION = 0;

	/**
	 * The feature id for the '<em><b>Intfct</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE__INTFCT = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE__NAME = 2;

	/**
	 * The feature id for the '<em><b>Is Provided Interface</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE__IS_PROVIDED_INTERFACE = 3;

	/**
	 * The feature id for the '<em><b>Connectedto</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE__CONNECTEDTO = 4;

	/**
	 * The feature id for the '<em><b>Interface Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE__INTERFACE_TYPE = 5;

	/**
	 * The feature id for the '<em><b>Connections</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE__CONNECTIONS = 6;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE__PARAMETERS = 7;

	/**
	 * The feature id for the '<em><b>Associated Function</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE__ASSOCIATED_FUNCTION = 8;

	/**
	 * The feature id for the '<em><b>Period</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE__PERIOD = 9;

	/**
	 * The feature id for the '<em><b>Deadline</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE__DEADLINE = 10;

	/**
	 * The number of structural features of the '<em>Interface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_FEATURE_COUNT = 11;

	/**
	 * The meta object id for the '{@link nl.esa.tec.swe.taste.metamodel.taste.impl.BusConnectionImpl <em>Bus Connection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see nl.esa.tec.swe.taste.metamodel.taste.impl.BusConnectionImpl
	 * @see nl.esa.tec.swe.taste.metamodel.taste.impl.TastePackageImpl#getBusConnection()
	 * @generated
	 */
	int BUS_CONNECTION = 7;

	/**
	 * The feature id for the '<em><b>Busconn</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS_CONNECTION__BUSCONN = 0;

	/**
	 * The feature id for the '<em><b>Associated Bus</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS_CONNECTION__ASSOCIATED_BUS = 1;

	/**
	 * The feature id for the '<em><b>Associated Driver</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS_CONNECTION__ASSOCIATED_DRIVER = 2;

	/**
	 * The number of structural features of the '<em>Bus Connection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUS_CONNECTION_FEATURE_COUNT = 3;


	/**
	 * The meta object id for the '{@link nl.esa.tec.swe.taste.metamodel.taste.impl.InterfaceConnectionImpl <em>Interface Connection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see nl.esa.tec.swe.taste.metamodel.taste.impl.InterfaceConnectionImpl
	 * @see nl.esa.tec.swe.taste.metamodel.taste.impl.TastePackageImpl#getInterfaceConnection()
	 * @generated
	 */
	int INTERFACE_CONNECTION = 8;

	/**
	 * The feature id for the '<em><b>Provided Interface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_CONNECTION__PROVIDED_INTERFACE = 0;

	/**
	 * The feature id for the '<em><b>Required Interface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_CONNECTION__REQUIRED_INTERFACE = 1;

	/**
	 * The feature id for the '<em><b>Associated Bus</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_CONNECTION__ASSOCIATED_BUS = 2;

	/**
	 * The number of structural features of the '<em>Interface Connection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_CONNECTION_FEATURE_COUNT = 3;


	/**
	 * The meta object id for the '{@link nl.esa.tec.swe.taste.metamodel.taste.impl.InterfaceParameterImpl <em>Interface Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see nl.esa.tec.swe.taste.metamodel.taste.impl.InterfaceParameterImpl
	 * @see nl.esa.tec.swe.taste.metamodel.taste.impl.TastePackageImpl#getInterfaceParameter()
	 * @generated
	 */
	int INTERFACE_PARAMETER = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_PARAMETER__NAME = 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_PARAMETER__TYPE = 1;

	/**
	 * The feature id for the '<em><b>Direction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_PARAMETER__DIRECTION = 2;

	/**
	 * The feature id for the '<em><b>Associated Interface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_PARAMETER__ASSOCIATED_INTERFACE = 3;

	/**
	 * The number of structural features of the '<em>Interface Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_PARAMETER_FEATURE_COUNT = 4;


	/**
	 * Returns the meta object for class '{@link nl.esa.tec.swe.taste.metamodel.taste.Function <em>Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Function</em>'.
	 * @see nl.esa.tec.swe.taste.metamodel.taste.Function
	 * @generated
	 */
	EClass getFunction();

	/**
	 * Returns the meta object for the attribute '{@link nl.esa.tec.swe.taste.metamodel.taste.Function#getLanguage <em>Language</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Language</em>'.
	 * @see nl.esa.tec.swe.taste.metamodel.taste.Function#getLanguage()
	 * @see #getFunction()
	 * @generated
	 */
	EAttribute getFunction_Language();

	/**
	 * Returns the meta object for the reference list '{@link nl.esa.tec.swe.taste.metamodel.taste.Function#getInterfaces <em>Interfaces</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Interfaces</em>'.
	 * @see nl.esa.tec.swe.taste.metamodel.taste.Function#getInterfaces()
	 * @see #getFunction()
	 * @generated
	 */
	EReference getFunction_Interfaces();

	/**
	 * Returns the meta object for the reference '{@link nl.esa.tec.swe.taste.metamodel.taste.Function#getAssociatedBoard <em>Associated Board</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Associated Board</em>'.
	 * @see nl.esa.tec.swe.taste.metamodel.taste.Function#getAssociatedBoard()
	 * @see #getFunction()
	 * @generated
	 */
	EReference getFunction_AssociatedBoard();

	/**
	 * Returns the meta object for class '{@link nl.esa.tec.swe.taste.metamodel.taste.Board <em>Board</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Board</em>'.
	 * @see nl.esa.tec.swe.taste.metamodel.taste.Board
	 * @generated
	 */
	EClass getBoard();

	/**
	 * Returns the meta object for the containment reference '{@link nl.esa.tec.swe.taste.metamodel.taste.Board#getBoardcpu <em>Boardcpu</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Boardcpu</em>'.
	 * @see nl.esa.tec.swe.taste.metamodel.taste.Board#getBoardcpu()
	 * @see #getBoard()
	 * @generated
	 */
	EReference getBoard_Boardcpu();

	/**
	 * Returns the meta object for the attribute '{@link nl.esa.tec.swe.taste.metamodel.taste.Board#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see nl.esa.tec.swe.taste.metamodel.taste.Board#getType()
	 * @see #getBoard()
	 * @generated
	 */
	EAttribute getBoard_Type();

	/**
	 * Returns the meta object for the reference list '{@link nl.esa.tec.swe.taste.metamodel.taste.Board#getFunctions <em>Functions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Functions</em>'.
	 * @see nl.esa.tec.swe.taste.metamodel.taste.Board#getFunctions()
	 * @see #getBoard()
	 * @generated
	 */
	EReference getBoard_Functions();

	/**
	 * Returns the meta object for the reference list '{@link nl.esa.tec.swe.taste.metamodel.taste.Board#getDrivers <em>Drivers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Drivers</em>'.
	 * @see nl.esa.tec.swe.taste.metamodel.taste.Board#getDrivers()
	 * @see #getBoard()
	 * @generated
	 */
	EReference getBoard_Drivers();

	/**
	 * Returns the meta object for class '{@link nl.esa.tec.swe.taste.metamodel.taste.Processor <em>Processor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Processor</em>'.
	 * @see nl.esa.tec.swe.taste.metamodel.taste.Processor
	 * @generated
	 */
	EClass getProcessor();

	/**
	 * Returns the meta object for the containment reference '{@link nl.esa.tec.swe.taste.metamodel.taste.Processor#getCpuboard <em>Cpuboard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Cpuboard</em>'.
	 * @see nl.esa.tec.swe.taste.metamodel.taste.Processor#getCpuboard()
	 * @see #getProcessor()
	 * @generated
	 */
	EReference getProcessor_Cpuboard();

	/**
	 * Returns the meta object for the attribute '{@link nl.esa.tec.swe.taste.metamodel.taste.Processor#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see nl.esa.tec.swe.taste.metamodel.taste.Processor#getType()
	 * @see #getProcessor()
	 * @generated
	 */
	EAttribute getProcessor_Type();

	/**
	 * Returns the meta object for class '{@link nl.esa.tec.swe.taste.metamodel.taste.Driver <em>Driver</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Driver</em>'.
	 * @see nl.esa.tec.swe.taste.metamodel.taste.Driver
	 * @generated
	 */
	EClass getDriver();

	/**
	 * Returns the meta object for the reference '{@link nl.esa.tec.swe.taste.metamodel.taste.Driver#getEReference0 <em>EReference0</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>EReference0</em>'.
	 * @see nl.esa.tec.swe.taste.metamodel.taste.Driver#getEReference0()
	 * @see #getDriver()
	 * @generated
	 */
	EReference getDriver_EReference0();

	/**
	 * Returns the meta object for the reference '{@link nl.esa.tec.swe.taste.metamodel.taste.Driver#getAssociatedBoard <em>Associated Board</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Associated Board</em>'.
	 * @see nl.esa.tec.swe.taste.metamodel.taste.Driver#getAssociatedBoard()
	 * @see #getDriver()
	 * @generated
	 */
	EReference getDriver_AssociatedBoard();

	/**
	 * Returns the meta object for the reference '{@link nl.esa.tec.swe.taste.metamodel.taste.Driver#getDrvbus <em>Drvbus</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Drvbus</em>'.
	 * @see nl.esa.tec.swe.taste.metamodel.taste.Driver#getDrvbus()
	 * @see #getDriver()
	 * @generated
	 */
	EReference getDriver_Drvbus();

	/**
	 * Returns the meta object for the attribute '{@link nl.esa.tec.swe.taste.metamodel.taste.Driver#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see nl.esa.tec.swe.taste.metamodel.taste.Driver#getType()
	 * @see #getDriver()
	 * @generated
	 */
	EAttribute getDriver_Type();

	/**
	 * Returns the meta object for the attribute '{@link nl.esa.tec.swe.taste.metamodel.taste.Driver#getConfig <em>Config</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Config</em>'.
	 * @see nl.esa.tec.swe.taste.metamodel.taste.Driver#getConfig()
	 * @see #getDriver()
	 * @generated
	 */
	EAttribute getDriver_Config();

	/**
	 * Returns the meta object for the reference list '{@link nl.esa.tec.swe.taste.metamodel.taste.Driver#getConnections <em>Connections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Connections</em>'.
	 * @see nl.esa.tec.swe.taste.metamodel.taste.Driver#getConnections()
	 * @see #getDriver()
	 * @generated
	 */
	EReference getDriver_Connections();

	/**
	 * Returns the meta object for class '{@link nl.esa.tec.swe.taste.metamodel.taste.Bus <em>Bus</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bus</em>'.
	 * @see nl.esa.tec.swe.taste.metamodel.taste.Bus
	 * @generated
	 */
	EClass getBus();

	/**
	 * Returns the meta object for the attribute '{@link nl.esa.tec.swe.taste.metamodel.taste.Bus#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see nl.esa.tec.swe.taste.metamodel.taste.Bus#getType()
	 * @see #getBus()
	 * @generated
	 */
	EAttribute getBus_Type();

	/**
	 * Returns the meta object for the reference list '{@link nl.esa.tec.swe.taste.metamodel.taste.Bus#getConnections <em>Connections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Connections</em>'.
	 * @see nl.esa.tec.swe.taste.metamodel.taste.Bus#getConnections()
	 * @see #getBus()
	 * @generated
	 */
	EReference getBus_Connections();

	/**
	 * Returns the meta object for class '{@link nl.esa.tec.swe.taste.metamodel.taste.fctconn <em>fctconn</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>fctconn</em>'.
	 * @see nl.esa.tec.swe.taste.metamodel.taste.fctconn
	 * @generated
	 */
	EClass getfctconn();

	/**
	 * Returns the meta object for the reference '{@link nl.esa.tec.swe.taste.metamodel.taste.fctconn#getConnbus <em>Connbus</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Connbus</em>'.
	 * @see nl.esa.tec.swe.taste.metamodel.taste.fctconn#getConnbus()
	 * @see #getfctconn()
	 * @generated
	 */
	EReference getfctconn_Connbus();

	/**
	 * Returns the meta object for the reference list '{@link nl.esa.tec.swe.taste.metamodel.taste.fctconn#getConnfct <em>Connfct</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Connfct</em>'.
	 * @see nl.esa.tec.swe.taste.metamodel.taste.fctconn#getConnfct()
	 * @see #getfctconn()
	 * @generated
	 */
	EReference getfctconn_Connfct();

	/**
	 * Returns the meta object for the attribute '{@link nl.esa.tec.swe.taste.metamodel.taste.fctconn#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see nl.esa.tec.swe.taste.metamodel.taste.fctconn#getName()
	 * @see #getfctconn()
	 * @generated
	 */
	EAttribute getfctconn_Name();

	/**
	 * Returns the meta object for class '{@link nl.esa.tec.swe.taste.metamodel.taste.Interface <em>Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Interface</em>'.
	 * @see nl.esa.tec.swe.taste.metamodel.taste.Interface
	 * @generated
	 */
	EClass getInterface();

	/**
	 * Returns the meta object for the attribute '{@link nl.esa.tec.swe.taste.metamodel.taste.Interface#getDirection <em>Direction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Direction</em>'.
	 * @see nl.esa.tec.swe.taste.metamodel.taste.Interface#getDirection()
	 * @see #getInterface()
	 * @generated
	 */
	EAttribute getInterface_Direction();

	/**
	 * Returns the meta object for the attribute '{@link nl.esa.tec.swe.taste.metamodel.taste.Interface#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see nl.esa.tec.swe.taste.metamodel.taste.Interface#getName()
	 * @see #getInterface()
	 * @generated
	 */
	EAttribute getInterface_Name();

	/**
	 * Returns the meta object for the attribute '{@link nl.esa.tec.swe.taste.metamodel.taste.Interface#isIsProvidedInterface <em>Is Provided Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Provided Interface</em>'.
	 * @see nl.esa.tec.swe.taste.metamodel.taste.Interface#isIsProvidedInterface()
	 * @see #getInterface()
	 * @generated
	 */
	EAttribute getInterface_IsProvidedInterface();

	/**
	 * Returns the meta object for the containment reference list '{@link nl.esa.tec.swe.taste.metamodel.taste.Interface#getConnectedto <em>Connectedto</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Connectedto</em>'.
	 * @see nl.esa.tec.swe.taste.metamodel.taste.Interface#getConnectedto()
	 * @see #getInterface()
	 * @generated
	 */
	EReference getInterface_Connectedto();

	/**
	 * Returns the meta object for the attribute '{@link nl.esa.tec.swe.taste.metamodel.taste.Interface#getInterfaceType <em>Interface Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Interface Type</em>'.
	 * @see nl.esa.tec.swe.taste.metamodel.taste.Interface#getInterfaceType()
	 * @see #getInterface()
	 * @generated
	 */
	EAttribute getInterface_InterfaceType();

	/**
	 * Returns the meta object for the reference list '{@link nl.esa.tec.swe.taste.metamodel.taste.Interface#getConnections <em>Connections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Connections</em>'.
	 * @see nl.esa.tec.swe.taste.metamodel.taste.Interface#getConnections()
	 * @see #getInterface()
	 * @generated
	 */
	EReference getInterface_Connections();

	/**
	 * Returns the meta object for the containment reference list '{@link nl.esa.tec.swe.taste.metamodel.taste.Interface#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see nl.esa.tec.swe.taste.metamodel.taste.Interface#getParameters()
	 * @see #getInterface()
	 * @generated
	 */
	EReference getInterface_Parameters();

	/**
	 * Returns the meta object for the reference '{@link nl.esa.tec.swe.taste.metamodel.taste.Interface#getAssociatedFunction <em>Associated Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Associated Function</em>'.
	 * @see nl.esa.tec.swe.taste.metamodel.taste.Interface#getAssociatedFunction()
	 * @see #getInterface()
	 * @generated
	 */
	EReference getInterface_AssociatedFunction();

	/**
	 * Returns the meta object for the attribute '{@link nl.esa.tec.swe.taste.metamodel.taste.Interface#getPeriod <em>Period</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Period</em>'.
	 * @see nl.esa.tec.swe.taste.metamodel.taste.Interface#getPeriod()
	 * @see #getInterface()
	 * @generated
	 */
	EAttribute getInterface_Period();

	/**
	 * Returns the meta object for the attribute '{@link nl.esa.tec.swe.taste.metamodel.taste.Interface#getDeadline <em>Deadline</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Deadline</em>'.
	 * @see nl.esa.tec.swe.taste.metamodel.taste.Interface#getDeadline()
	 * @see #getInterface()
	 * @generated
	 */
	EAttribute getInterface_Deadline();

	/**
	 * Returns the meta object for the reference '{@link nl.esa.tec.swe.taste.metamodel.taste.Interface#getIntfct <em>Intfct</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Intfct</em>'.
	 * @see nl.esa.tec.swe.taste.metamodel.taste.Interface#getIntfct()
	 * @see #getInterface()
	 * @generated
	 */
	EReference getInterface_Intfct();

	/**
	 * Returns the meta object for class '{@link nl.esa.tec.swe.taste.metamodel.taste.BusConnection <em>Bus Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bus Connection</em>'.
	 * @see nl.esa.tec.swe.taste.metamodel.taste.BusConnection
	 * @generated
	 */
	EClass getBusConnection();

	/**
	 * Returns the meta object for the reference '{@link nl.esa.tec.swe.taste.metamodel.taste.BusConnection#getBusconn <em>Busconn</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Busconn</em>'.
	 * @see nl.esa.tec.swe.taste.metamodel.taste.BusConnection#getBusconn()
	 * @see #getBusConnection()
	 * @generated
	 */
	EReference getBusConnection_Busconn();

	/**
	 * Returns the meta object for the reference '{@link nl.esa.tec.swe.taste.metamodel.taste.BusConnection#getAssociatedBus <em>Associated Bus</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Associated Bus</em>'.
	 * @see nl.esa.tec.swe.taste.metamodel.taste.BusConnection#getAssociatedBus()
	 * @see #getBusConnection()
	 * @generated
	 */
	EReference getBusConnection_AssociatedBus();

	/**
	 * Returns the meta object for the reference '{@link nl.esa.tec.swe.taste.metamodel.taste.BusConnection#getAssociatedDriver <em>Associated Driver</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Associated Driver</em>'.
	 * @see nl.esa.tec.swe.taste.metamodel.taste.BusConnection#getAssociatedDriver()
	 * @see #getBusConnection()
	 * @generated
	 */
	EReference getBusConnection_AssociatedDriver();

	/**
	 * Returns the meta object for class '{@link nl.esa.tec.swe.taste.metamodel.taste.InterfaceConnection <em>Interface Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Interface Connection</em>'.
	 * @see nl.esa.tec.swe.taste.metamodel.taste.InterfaceConnection
	 * @generated
	 */
	EClass getInterfaceConnection();

	/**
	 * Returns the meta object for the reference '{@link nl.esa.tec.swe.taste.metamodel.taste.InterfaceConnection#getProvidedInterface <em>Provided Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Provided Interface</em>'.
	 * @see nl.esa.tec.swe.taste.metamodel.taste.InterfaceConnection#getProvidedInterface()
	 * @see #getInterfaceConnection()
	 * @generated
	 */
	EReference getInterfaceConnection_ProvidedInterface();

	/**
	 * Returns the meta object for the reference '{@link nl.esa.tec.swe.taste.metamodel.taste.InterfaceConnection#getRequiredInterface <em>Required Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Required Interface</em>'.
	 * @see nl.esa.tec.swe.taste.metamodel.taste.InterfaceConnection#getRequiredInterface()
	 * @see #getInterfaceConnection()
	 * @generated
	 */
	EReference getInterfaceConnection_RequiredInterface();

	/**
	 * Returns the meta object for the reference '{@link nl.esa.tec.swe.taste.metamodel.taste.InterfaceConnection#getAssociatedBus <em>Associated Bus</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Associated Bus</em>'.
	 * @see nl.esa.tec.swe.taste.metamodel.taste.InterfaceConnection#getAssociatedBus()
	 * @see #getInterfaceConnection()
	 * @generated
	 */
	EReference getInterfaceConnection_AssociatedBus();

	/**
	 * Returns the meta object for class '{@link nl.esa.tec.swe.taste.metamodel.taste.InterfaceParameter <em>Interface Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Interface Parameter</em>'.
	 * @see nl.esa.tec.swe.taste.metamodel.taste.InterfaceParameter
	 * @generated
	 */
	EClass getInterfaceParameter();

	/**
	 * Returns the meta object for the attribute '{@link nl.esa.tec.swe.taste.metamodel.taste.InterfaceParameter#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see nl.esa.tec.swe.taste.metamodel.taste.InterfaceParameter#getName()
	 * @see #getInterfaceParameter()
	 * @generated
	 */
	EAttribute getInterfaceParameter_Name();

	/**
	 * Returns the meta object for the attribute '{@link nl.esa.tec.swe.taste.metamodel.taste.InterfaceParameter#getDirection <em>Direction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Direction</em>'.
	 * @see nl.esa.tec.swe.taste.metamodel.taste.InterfaceParameter#getDirection()
	 * @see #getInterfaceParameter()
	 * @generated
	 */
	EAttribute getInterfaceParameter_Direction();

	/**
	 * Returns the meta object for the reference '{@link nl.esa.tec.swe.taste.metamodel.taste.InterfaceParameter#getAssociatedInterface <em>Associated Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Associated Interface</em>'.
	 * @see nl.esa.tec.swe.taste.metamodel.taste.InterfaceParameter#getAssociatedInterface()
	 * @see #getInterfaceParameter()
	 * @generated
	 */
	EReference getInterfaceParameter_AssociatedInterface();

	/**
	 * Returns the meta object for the attribute '{@link nl.esa.tec.swe.taste.metamodel.taste.InterfaceParameter#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see nl.esa.tec.swe.taste.metamodel.taste.InterfaceParameter#getType()
	 * @see #getInterfaceParameter()
	 * @generated
	 */
	EAttribute getInterfaceParameter_Type();

	/**
	 * Returns the meta object for class '{@link nl.esa.tec.swe.taste.metamodel.taste.TasteComponent <em>Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component</em>'.
	 * @see nl.esa.tec.swe.taste.metamodel.taste.TasteComponent
	 * @generated
	 */
	EClass getTasteComponent();

	/**
	 * Returns the meta object for the attribute '{@link nl.esa.tec.swe.taste.metamodel.taste.TasteComponent#getComponentType <em>Component Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Component Type</em>'.
	 * @see nl.esa.tec.swe.taste.metamodel.taste.TasteComponent#getComponentType()
	 * @see #getTasteComponent()
	 * @generated
	 */
	EAttribute getTasteComponent_ComponentType();

	/**
	 * Returns the meta object for the attribute '{@link nl.esa.tec.swe.taste.metamodel.taste.TasteComponent#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see nl.esa.tec.swe.taste.metamodel.taste.TasteComponent#getName()
	 * @see #getTasteComponent()
	 * @generated
	 */
	EAttribute getTasteComponent_Name();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TasteFactory getTasteFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link nl.esa.tec.swe.taste.metamodel.taste.impl.FunctionImpl <em>Function</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see nl.esa.tec.swe.taste.metamodel.taste.impl.FunctionImpl
		 * @see nl.esa.tec.swe.taste.metamodel.taste.impl.TastePackageImpl#getFunction()
		 * @generated
		 */
		EClass FUNCTION = eINSTANCE.getFunction();

		/**
		 * The meta object literal for the '<em><b>Language</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FUNCTION__LANGUAGE = eINSTANCE.getFunction_Language();

		/**
		 * The meta object literal for the '<em><b>Interfaces</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION__INTERFACES = eINSTANCE.getFunction_Interfaces();

		/**
		 * The meta object literal for the '<em><b>Associated Board</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION__ASSOCIATED_BOARD = eINSTANCE.getFunction_AssociatedBoard();

		/**
		 * The meta object literal for the '{@link nl.esa.tec.swe.taste.metamodel.taste.impl.BoardImpl <em>Board</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see nl.esa.tec.swe.taste.metamodel.taste.impl.BoardImpl
		 * @see nl.esa.tec.swe.taste.metamodel.taste.impl.TastePackageImpl#getBoard()
		 * @generated
		 */
		EClass BOARD = eINSTANCE.getBoard();

		/**
		 * The meta object literal for the '<em><b>Boardcpu</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOARD__BOARDCPU = eINSTANCE.getBoard_Boardcpu();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOARD__TYPE = eINSTANCE.getBoard_Type();

		/**
		 * The meta object literal for the '<em><b>Functions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOARD__FUNCTIONS = eINSTANCE.getBoard_Functions();

		/**
		 * The meta object literal for the '<em><b>Drivers</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOARD__DRIVERS = eINSTANCE.getBoard_Drivers();

		/**
		 * The meta object literal for the '{@link nl.esa.tec.swe.taste.metamodel.taste.impl.ProcessorImpl <em>Processor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see nl.esa.tec.swe.taste.metamodel.taste.impl.ProcessorImpl
		 * @see nl.esa.tec.swe.taste.metamodel.taste.impl.TastePackageImpl#getProcessor()
		 * @generated
		 */
		EClass PROCESSOR = eINSTANCE.getProcessor();

		/**
		 * The meta object literal for the '<em><b>Cpuboard</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROCESSOR__CPUBOARD = eINSTANCE.getProcessor_Cpuboard();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROCESSOR__TYPE = eINSTANCE.getProcessor_Type();

		/**
		 * The meta object literal for the '{@link nl.esa.tec.swe.taste.metamodel.taste.impl.DriverImpl <em>Driver</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see nl.esa.tec.swe.taste.metamodel.taste.impl.DriverImpl
		 * @see nl.esa.tec.swe.taste.metamodel.taste.impl.TastePackageImpl#getDriver()
		 * @generated
		 */
		EClass DRIVER = eINSTANCE.getDriver();

		/**
		 * The meta object literal for the '<em><b>EReference0</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DRIVER__EREFERENCE0 = eINSTANCE.getDriver_EReference0();

		/**
		 * The meta object literal for the '<em><b>Associated Board</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DRIVER__ASSOCIATED_BOARD = eINSTANCE.getDriver_AssociatedBoard();

		/**
		 * The meta object literal for the '<em><b>Drvbus</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DRIVER__DRVBUS = eINSTANCE.getDriver_Drvbus();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DRIVER__TYPE = eINSTANCE.getDriver_Type();

		/**
		 * The meta object literal for the '<em><b>Config</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DRIVER__CONFIG = eINSTANCE.getDriver_Config();

		/**
		 * The meta object literal for the '<em><b>Connections</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DRIVER__CONNECTIONS = eINSTANCE.getDriver_Connections();

		/**
		 * The meta object literal for the '{@link nl.esa.tec.swe.taste.metamodel.taste.impl.BusImpl <em>Bus</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see nl.esa.tec.swe.taste.metamodel.taste.impl.BusImpl
		 * @see nl.esa.tec.swe.taste.metamodel.taste.impl.TastePackageImpl#getBus()
		 * @generated
		 */
		EClass BUS = eINSTANCE.getBus();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUS__TYPE = eINSTANCE.getBus_Type();

		/**
		 * The meta object literal for the '<em><b>Connections</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUS__CONNECTIONS = eINSTANCE.getBus_Connections();

		/**
		 * The meta object literal for the '{@link nl.esa.tec.swe.taste.metamodel.taste.impl.fctconnImpl <em>fctconn</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see nl.esa.tec.swe.taste.metamodel.taste.impl.fctconnImpl
		 * @see nl.esa.tec.swe.taste.metamodel.taste.impl.TastePackageImpl#getfctconn()
		 * @generated
		 */
		EClass FCTCONN = eINSTANCE.getfctconn();

		/**
		 * The meta object literal for the '<em><b>Connbus</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FCTCONN__CONNBUS = eINSTANCE.getfctconn_Connbus();

		/**
		 * The meta object literal for the '<em><b>Connfct</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FCTCONN__CONNFCT = eINSTANCE.getfctconn_Connfct();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FCTCONN__NAME = eINSTANCE.getfctconn_Name();

		/**
		 * The meta object literal for the '{@link nl.esa.tec.swe.taste.metamodel.taste.impl.InterfaceImpl <em>Interface</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see nl.esa.tec.swe.taste.metamodel.taste.impl.InterfaceImpl
		 * @see nl.esa.tec.swe.taste.metamodel.taste.impl.TastePackageImpl#getInterface()
		 * @generated
		 */
		EClass INTERFACE = eINSTANCE.getInterface();

		/**
		 * The meta object literal for the '<em><b>Direction</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERFACE__DIRECTION = eINSTANCE.getInterface_Direction();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERFACE__NAME = eINSTANCE.getInterface_Name();

		/**
		 * The meta object literal for the '<em><b>Is Provided Interface</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERFACE__IS_PROVIDED_INTERFACE = eINSTANCE.getInterface_IsProvidedInterface();

		/**
		 * The meta object literal for the '<em><b>Connectedto</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERFACE__CONNECTEDTO = eINSTANCE.getInterface_Connectedto();

		/**
		 * The meta object literal for the '<em><b>Interface Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERFACE__INTERFACE_TYPE = eINSTANCE.getInterface_InterfaceType();

		/**
		 * The meta object literal for the '<em><b>Connections</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERFACE__CONNECTIONS = eINSTANCE.getInterface_Connections();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERFACE__PARAMETERS = eINSTANCE.getInterface_Parameters();

		/**
		 * The meta object literal for the '<em><b>Associated Function</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERFACE__ASSOCIATED_FUNCTION = eINSTANCE.getInterface_AssociatedFunction();

		/**
		 * The meta object literal for the '<em><b>Period</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERFACE__PERIOD = eINSTANCE.getInterface_Period();

		/**
		 * The meta object literal for the '<em><b>Deadline</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERFACE__DEADLINE = eINSTANCE.getInterface_Deadline();

		/**
		 * The meta object literal for the '<em><b>Intfct</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERFACE__INTFCT = eINSTANCE.getInterface_Intfct();

		/**
		 * The meta object literal for the '{@link nl.esa.tec.swe.taste.metamodel.taste.impl.BusConnectionImpl <em>Bus Connection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see nl.esa.tec.swe.taste.metamodel.taste.impl.BusConnectionImpl
		 * @see nl.esa.tec.swe.taste.metamodel.taste.impl.TastePackageImpl#getBusConnection()
		 * @generated
		 */
		EClass BUS_CONNECTION = eINSTANCE.getBusConnection();

		/**
		 * The meta object literal for the '<em><b>Busconn</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUS_CONNECTION__BUSCONN = eINSTANCE.getBusConnection_Busconn();

		/**
		 * The meta object literal for the '<em><b>Associated Bus</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUS_CONNECTION__ASSOCIATED_BUS = eINSTANCE.getBusConnection_AssociatedBus();

		/**
		 * The meta object literal for the '<em><b>Associated Driver</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUS_CONNECTION__ASSOCIATED_DRIVER = eINSTANCE.getBusConnection_AssociatedDriver();

		/**
		 * The meta object literal for the '{@link nl.esa.tec.swe.taste.metamodel.taste.impl.InterfaceConnectionImpl <em>Interface Connection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see nl.esa.tec.swe.taste.metamodel.taste.impl.InterfaceConnectionImpl
		 * @see nl.esa.tec.swe.taste.metamodel.taste.impl.TastePackageImpl#getInterfaceConnection()
		 * @generated
		 */
		EClass INTERFACE_CONNECTION = eINSTANCE.getInterfaceConnection();

		/**
		 * The meta object literal for the '<em><b>Provided Interface</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERFACE_CONNECTION__PROVIDED_INTERFACE = eINSTANCE.getInterfaceConnection_ProvidedInterface();

		/**
		 * The meta object literal for the '<em><b>Required Interface</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERFACE_CONNECTION__REQUIRED_INTERFACE = eINSTANCE.getInterfaceConnection_RequiredInterface();

		/**
		 * The meta object literal for the '<em><b>Associated Bus</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERFACE_CONNECTION__ASSOCIATED_BUS = eINSTANCE.getInterfaceConnection_AssociatedBus();

		/**
		 * The meta object literal for the '{@link nl.esa.tec.swe.taste.metamodel.taste.impl.InterfaceParameterImpl <em>Interface Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see nl.esa.tec.swe.taste.metamodel.taste.impl.InterfaceParameterImpl
		 * @see nl.esa.tec.swe.taste.metamodel.taste.impl.TastePackageImpl#getInterfaceParameter()
		 * @generated
		 */
		EClass INTERFACE_PARAMETER = eINSTANCE.getInterfaceParameter();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERFACE_PARAMETER__NAME = eINSTANCE.getInterfaceParameter_Name();

		/**
		 * The meta object literal for the '<em><b>Direction</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERFACE_PARAMETER__DIRECTION = eINSTANCE.getInterfaceParameter_Direction();

		/**
		 * The meta object literal for the '<em><b>Associated Interface</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERFACE_PARAMETER__ASSOCIATED_INTERFACE = eINSTANCE.getInterfaceParameter_AssociatedInterface();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERFACE_PARAMETER__TYPE = eINSTANCE.getInterfaceParameter_Type();

		/**
		 * The meta object literal for the '{@link nl.esa.tec.swe.taste.metamodel.taste.impl.TasteComponentImpl <em>Component</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see nl.esa.tec.swe.taste.metamodel.taste.impl.TasteComponentImpl
		 * @see nl.esa.tec.swe.taste.metamodel.taste.impl.TastePackageImpl#getTasteComponent()
		 * @generated
		 */
		EClass TASTE_COMPONENT = eINSTANCE.getTasteComponent();

		/**
		 * The meta object literal for the '<em><b>Component Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TASTE_COMPONENT__COMPONENT_TYPE = eINSTANCE.getTasteComponent_ComponentType();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TASTE_COMPONENT__NAME = eINSTANCE.getTasteComponent_Name();

	}

} //TastePackage
