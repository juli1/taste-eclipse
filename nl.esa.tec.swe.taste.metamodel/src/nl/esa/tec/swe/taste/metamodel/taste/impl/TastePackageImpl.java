/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package nl.esa.tec.swe.taste.metamodel.taste.impl;

import nl.esa.tec.swe.taste.metamodel.taste.Board;
import nl.esa.tec.swe.taste.metamodel.taste.Bus;
import nl.esa.tec.swe.taste.metamodel.taste.BusConnection;
import nl.esa.tec.swe.taste.metamodel.taste.Driver;
import nl.esa.tec.swe.taste.metamodel.taste.Function;
import nl.esa.tec.swe.taste.metamodel.taste.Interface;
import nl.esa.tec.swe.taste.metamodel.taste.InterfaceConnection;
import nl.esa.tec.swe.taste.metamodel.taste.InterfaceParameter;
import nl.esa.tec.swe.taste.metamodel.taste.Processor;
import nl.esa.tec.swe.taste.metamodel.taste.TasteComponent;
import nl.esa.tec.swe.taste.metamodel.taste.TasteFactory;
import nl.esa.tec.swe.taste.metamodel.taste.TastePackage;
import nl.esa.tec.swe.taste.metamodel.taste.fctconn;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TastePackageImpl extends EPackageImpl implements TastePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass functionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass boardEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass processorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass driverEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass busEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fctconnEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass interfaceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass busConnectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass interfaceConnectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass interfaceParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tasteComponentEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see nl.esa.tec.swe.taste.metamodel.taste.TastePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private TastePackageImpl() {
		super(eNS_URI, TasteFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link TastePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static TastePackage init() {
		if (isInited) return (TastePackage)EPackage.Registry.INSTANCE.getEPackage(TastePackage.eNS_URI);

		// Obtain or create and register package
		TastePackageImpl theTastePackage = (TastePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof TastePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new TastePackageImpl());

		isInited = true;

		// Create package meta-data objects
		theTastePackage.createPackageContents();

		// Initialize created meta-data
		theTastePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theTastePackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(TastePackage.eNS_URI, theTastePackage);
		return theTastePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFunction() {
		return functionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFunction_Language() {
		return (EAttribute)functionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFunction_Interfaces() {
		return (EReference)functionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFunction_AssociatedBoard() {
		return (EReference)functionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBoard() {
		return boardEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBoard_Boardcpu() {
		return (EReference)boardEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBoard_Type() {
		return (EAttribute)boardEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBoard_Functions() {
		return (EReference)boardEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBoard_Drivers() {
		return (EReference)boardEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProcessor() {
		return processorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProcessor_Cpuboard() {
		return (EReference)processorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProcessor_Type() {
		return (EAttribute)processorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDriver() {
		return driverEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDriver_EReference0() {
		return (EReference)driverEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDriver_AssociatedBoard() {
		return (EReference)driverEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDriver_Drvbus() {
		return (EReference)driverEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDriver_Type() {
		return (EAttribute)driverEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDriver_Config() {
		return (EAttribute)driverEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDriver_Connections() {
		return (EReference)driverEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBus() {
		return busEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBus_Type() {
		return (EAttribute)busEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBus_Connections() {
		return (EReference)busEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getfctconn() {
		return fctconnEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getfctconn_Connbus() {
		return (EReference)fctconnEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getfctconn_Connfct() {
		return (EReference)fctconnEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getfctconn_Name() {
		return (EAttribute)fctconnEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInterface() {
		return interfaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInterface_Direction() {
		return (EAttribute)interfaceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInterface_Name() {
		return (EAttribute)interfaceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInterface_IsProvidedInterface() {
		return (EAttribute)interfaceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInterface_Connectedto() {
		return (EReference)interfaceEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInterface_InterfaceType() {
		return (EAttribute)interfaceEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInterface_Connections() {
		return (EReference)interfaceEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInterface_Parameters() {
		return (EReference)interfaceEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInterface_AssociatedFunction() {
		return (EReference)interfaceEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInterface_Period() {
		return (EAttribute)interfaceEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInterface_Deadline() {
		return (EAttribute)interfaceEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInterface_Intfct() {
		return (EReference)interfaceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBusConnection() {
		return busConnectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBusConnection_Busconn() {
		return (EReference)busConnectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBusConnection_AssociatedBus() {
		return (EReference)busConnectionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBusConnection_AssociatedDriver() {
		return (EReference)busConnectionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInterfaceConnection() {
		return interfaceConnectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInterfaceConnection_ProvidedInterface() {
		return (EReference)interfaceConnectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInterfaceConnection_RequiredInterface() {
		return (EReference)interfaceConnectionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInterfaceConnection_AssociatedBus() {
		return (EReference)interfaceConnectionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInterfaceParameter() {
		return interfaceParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInterfaceParameter_Name() {
		return (EAttribute)interfaceParameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInterfaceParameter_Direction() {
		return (EAttribute)interfaceParameterEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInterfaceParameter_AssociatedInterface() {
		return (EReference)interfaceParameterEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInterfaceParameter_Type() {
		return (EAttribute)interfaceParameterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTasteComponent() {
		return tasteComponentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTasteComponent_ComponentType() {
		return (EAttribute)tasteComponentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTasteComponent_Name() {
		return (EAttribute)tasteComponentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TasteFactory getTasteFactory() {
		return (TasteFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		functionEClass = createEClass(FUNCTION);
		createEAttribute(functionEClass, FUNCTION__LANGUAGE);
		createEReference(functionEClass, FUNCTION__INTERFACES);
		createEReference(functionEClass, FUNCTION__ASSOCIATED_BOARD);

		boardEClass = createEClass(BOARD);
		createEReference(boardEClass, BOARD__BOARDCPU);
		createEAttribute(boardEClass, BOARD__TYPE);
		createEReference(boardEClass, BOARD__FUNCTIONS);
		createEReference(boardEClass, BOARD__DRIVERS);

		processorEClass = createEClass(PROCESSOR);
		createEReference(processorEClass, PROCESSOR__CPUBOARD);
		createEAttribute(processorEClass, PROCESSOR__TYPE);

		driverEClass = createEClass(DRIVER);
		createEReference(driverEClass, DRIVER__EREFERENCE0);
		createEReference(driverEClass, DRIVER__ASSOCIATED_BOARD);
		createEReference(driverEClass, DRIVER__DRVBUS);
		createEAttribute(driverEClass, DRIVER__TYPE);
		createEAttribute(driverEClass, DRIVER__CONFIG);
		createEReference(driverEClass, DRIVER__CONNECTIONS);

		busEClass = createEClass(BUS);
		createEAttribute(busEClass, BUS__TYPE);
		createEReference(busEClass, BUS__CONNECTIONS);

		fctconnEClass = createEClass(FCTCONN);
		createEReference(fctconnEClass, FCTCONN__CONNBUS);
		createEReference(fctconnEClass, FCTCONN__CONNFCT);
		createEAttribute(fctconnEClass, FCTCONN__NAME);

		interfaceEClass = createEClass(INTERFACE);
		createEAttribute(interfaceEClass, INTERFACE__DIRECTION);
		createEReference(interfaceEClass, INTERFACE__INTFCT);
		createEAttribute(interfaceEClass, INTERFACE__NAME);
		createEAttribute(interfaceEClass, INTERFACE__IS_PROVIDED_INTERFACE);
		createEReference(interfaceEClass, INTERFACE__CONNECTEDTO);
		createEAttribute(interfaceEClass, INTERFACE__INTERFACE_TYPE);
		createEReference(interfaceEClass, INTERFACE__CONNECTIONS);
		createEReference(interfaceEClass, INTERFACE__PARAMETERS);
		createEReference(interfaceEClass, INTERFACE__ASSOCIATED_FUNCTION);
		createEAttribute(interfaceEClass, INTERFACE__PERIOD);
		createEAttribute(interfaceEClass, INTERFACE__DEADLINE);

		busConnectionEClass = createEClass(BUS_CONNECTION);
		createEReference(busConnectionEClass, BUS_CONNECTION__BUSCONN);
		createEReference(busConnectionEClass, BUS_CONNECTION__ASSOCIATED_BUS);
		createEReference(busConnectionEClass, BUS_CONNECTION__ASSOCIATED_DRIVER);

		interfaceConnectionEClass = createEClass(INTERFACE_CONNECTION);
		createEReference(interfaceConnectionEClass, INTERFACE_CONNECTION__PROVIDED_INTERFACE);
		createEReference(interfaceConnectionEClass, INTERFACE_CONNECTION__REQUIRED_INTERFACE);
		createEReference(interfaceConnectionEClass, INTERFACE_CONNECTION__ASSOCIATED_BUS);

		interfaceParameterEClass = createEClass(INTERFACE_PARAMETER);
		createEAttribute(interfaceParameterEClass, INTERFACE_PARAMETER__NAME);
		createEAttribute(interfaceParameterEClass, INTERFACE_PARAMETER__TYPE);
		createEAttribute(interfaceParameterEClass, INTERFACE_PARAMETER__DIRECTION);
		createEReference(interfaceParameterEClass, INTERFACE_PARAMETER__ASSOCIATED_INTERFACE);

		tasteComponentEClass = createEClass(TASTE_COMPONENT);
		createEAttribute(tasteComponentEClass, TASTE_COMPONENT__COMPONENT_TYPE);
		createEAttribute(tasteComponentEClass, TASTE_COMPONENT__NAME);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		functionEClass.getESuperTypes().add(this.getTasteComponent());
		boardEClass.getESuperTypes().add(this.getTasteComponent());
		processorEClass.getESuperTypes().add(this.getTasteComponent());
		driverEClass.getESuperTypes().add(this.getTasteComponent());
		busEClass.getESuperTypes().add(this.getTasteComponent());

		// Initialize classes and features; add operations and parameters
		initEClass(functionEClass, Function.class, "Function", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFunction_Language(), ecorePackage.getEString(), "language", null, 0, 1, Function.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFunction_Interfaces(), this.getInterface(), null, "interfaces", null, 0, -1, Function.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFunction_AssociatedBoard(), this.getBoard(), null, "associatedBoard", null, 0, 1, Function.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(boardEClass, Board.class, "Board", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBoard_Boardcpu(), this.getProcessor(), null, "boardcpu", null, 0, 1, Board.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBoard_Type(), ecorePackage.getEString(), "type", null, 0, 1, Board.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBoard_Functions(), this.getFunction(), null, "functions", null, 0, -1, Board.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBoard_Drivers(), this.getDriver(), null, "drivers", null, 0, -1, Board.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(processorEClass, Processor.class, "Processor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getProcessor_Cpuboard(), this.getBoard(), null, "cpuboard", null, 0, 1, Processor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProcessor_Type(), ecorePackage.getEString(), "type", null, 0, 1, Processor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(driverEClass, Driver.class, "Driver", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDriver_EReference0(), this.getDriver(), null, "EReference0", null, 0, 1, Driver.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDriver_AssociatedBoard(), this.getBoard(), null, "associatedBoard", null, 0, 1, Driver.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDriver_Drvbus(), this.getBus(), null, "drvbus", null, 0, 1, Driver.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDriver_Type(), ecorePackage.getEString(), "type", null, 0, 1, Driver.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDriver_Config(), ecorePackage.getEString(), "config", null, 0, 1, Driver.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDriver_Connections(), this.getBusConnection(), null, "connections", null, 0, -1, Driver.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(busEClass, Bus.class, "Bus", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBus_Type(), ecorePackage.getEString(), "type", null, 0, 1, Bus.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBus_Connections(), this.getBusConnection(), null, "connections", null, 0, -1, Bus.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(fctconnEClass, fctconn.class, "fctconn", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getfctconn_Connbus(), this.getBus(), null, "connbus", null, 0, 1, fctconn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getfctconn_Connfct(), this.getInterface(), null, "connfct", null, 0, -1, fctconn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getfctconn_Name(), ecorePackage.getEString(), "name", null, 0, 1, fctconn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(interfaceEClass, Interface.class, "Interface", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getInterface_Direction(), ecorePackage.getEString(), "direction", null, 0, 1, Interface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInterface_Intfct(), this.getFunction(), null, "intfct", null, 0, 1, Interface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInterface_Name(), ecorePackage.getEString(), "name", null, 0, 1, Interface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInterface_IsProvidedInterface(), ecorePackage.getEBoolean(), "isProvidedInterface", null, 0, 1, Interface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInterface_Connectedto(), this.getInterface(), null, "connectedto", null, 0, -1, Interface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInterface_InterfaceType(), ecorePackage.getEInt(), "interfaceType", null, 0, 1, Interface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInterface_Connections(), this.getInterfaceConnection(), null, "connections", null, 0, -1, Interface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInterface_Parameters(), this.getInterfaceParameter(), null, "parameters", null, 0, -1, Interface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInterface_AssociatedFunction(), this.getFunction(), null, "associatedFunction", null, 0, 1, Interface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInterface_Period(), ecorePackage.getEInt(), "period", null, 0, 1, Interface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInterface_Deadline(), ecorePackage.getEInt(), "deadline", null, 0, 1, Interface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(busConnectionEClass, BusConnection.class, "BusConnection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBusConnection_Busconn(), this.getInterface(), null, "busconn", null, 0, 1, BusConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBusConnection_AssociatedBus(), this.getBus(), null, "associatedBus", null, 0, 1, BusConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBusConnection_AssociatedDriver(), this.getDriver(), null, "associatedDriver", null, 0, 1, BusConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(interfaceConnectionEClass, InterfaceConnection.class, "InterfaceConnection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInterfaceConnection_ProvidedInterface(), this.getInterface(), null, "ProvidedInterface", null, 0, 1, InterfaceConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInterfaceConnection_RequiredInterface(), this.getInterface(), null, "RequiredInterface", null, 0, 1, InterfaceConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInterfaceConnection_AssociatedBus(), this.getBus(), null, "associatedBus", null, 0, 1, InterfaceConnection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(interfaceParameterEClass, InterfaceParameter.class, "InterfaceParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getInterfaceParameter_Name(), ecorePackage.getEString(), "name", null, 0, 1, InterfaceParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInterfaceParameter_Type(), ecorePackage.getEString(), "type", null, 0, 1, InterfaceParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInterfaceParameter_Direction(), ecorePackage.getEInt(), "direction", null, 0, 1, InterfaceParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInterfaceParameter_AssociatedInterface(), this.getInterface(), null, "associatedInterface", null, 0, 1, InterfaceParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tasteComponentEClass, TasteComponent.class, "TasteComponent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTasteComponent_ComponentType(), ecorePackage.getEInt(), "componentType", null, 0, 1, TasteComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTasteComponent_Name(), ecorePackage.getEString(), "name", null, 0, 1, TasteComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //TastePackageImpl
