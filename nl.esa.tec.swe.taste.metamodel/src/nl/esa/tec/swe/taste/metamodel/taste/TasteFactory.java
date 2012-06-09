/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package nl.esa.tec.swe.taste.metamodel.taste;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see nl.esa.tec.swe.taste.metamodel.taste.TastePackage
 * @generated
 */
public interface TasteFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TasteFactory eINSTANCE = nl.esa.tec.swe.taste.metamodel.taste.impl.TasteFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Function</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Function</em>'.
	 * @generated
	 */
	Function createFunction();

	/**
	 * Returns a new object of class '<em>Board</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Board</em>'.
	 * @generated
	 */
	Board createBoard();

	/**
	 * Returns a new object of class '<em>Processor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Processor</em>'.
	 * @generated
	 */
	Processor createProcessor();

	/**
	 * Returns a new object of class '<em>Driver</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Driver</em>'.
	 * @generated
	 */
	Driver createDriver();

	/**
	 * Returns a new object of class '<em>Bus</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Bus</em>'.
	 * @generated
	 */
	Bus createBus();

	/**
	 * Returns a new object of class '<em>fctconn</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>fctconn</em>'.
	 * @generated
	 */
	fctconn createfctconn();

	/**
	 * Returns a new object of class '<em>Interface</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Interface</em>'.
	 * @generated
	 */
	Interface createInterface();

	/**
	 * Returns a new object of class '<em>Bus Connection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Bus Connection</em>'.
	 * @generated
	 */
	BusConnection createBusConnection();

	/**
	 * Returns a new object of class '<em>Interface Connection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Interface Connection</em>'.
	 * @generated
	 */
	InterfaceConnection createInterfaceConnection();

	/**
	 * Returns a new object of class '<em>Interface Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Interface Parameter</em>'.
	 * @generated
	 */
	InterfaceParameter createInterfaceParameter();

	/**
	 * Returns a new object of class '<em>Component</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Component</em>'.
	 * @generated
	 */
	TasteComponent createTasteComponent();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	TastePackage getTastePackage();

} //TasteFactory
