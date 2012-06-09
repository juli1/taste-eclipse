/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package nl.esa.tec.swe.taste.metamodel.taste;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Bus Connection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link nl.esa.tec.swe.taste.metamodel.taste.BusConnection#getBusconn <em>Busconn</em>}</li>
 *   <li>{@link nl.esa.tec.swe.taste.metamodel.taste.BusConnection#getAssociatedBus <em>Associated Bus</em>}</li>
 *   <li>{@link nl.esa.tec.swe.taste.metamodel.taste.BusConnection#getAssociatedDriver <em>Associated Driver</em>}</li>
 * </ul>
 * </p>
 *
 * @see nl.esa.tec.swe.taste.metamodel.taste.TastePackage#getBusConnection()
 * @model
 * @generated
 */
public interface BusConnection extends EObject {
	/**
	 * Returns the value of the '<em><b>Busconn</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Busconn</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Busconn</em>' reference.
	 * @see #setBusconn(Interface)
	 * @see nl.esa.tec.swe.taste.metamodel.taste.TastePackage#getBusConnection_Busconn()
	 * @model
	 * @generated
	 */
	Interface getBusconn();

	/**
	 * Sets the value of the '{@link nl.esa.tec.swe.taste.metamodel.taste.BusConnection#getBusconn <em>Busconn</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Busconn</em>' reference.
	 * @see #getBusconn()
	 * @generated
	 */
	void setBusconn(Interface value);

	/**
	 * Returns the value of the '<em><b>Associated Bus</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Associated Bus</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Associated Bus</em>' reference.
	 * @see #setAssociatedBus(Bus)
	 * @see nl.esa.tec.swe.taste.metamodel.taste.TastePackage#getBusConnection_AssociatedBus()
	 * @model
	 * @generated
	 */
	Bus getAssociatedBus();

	/**
	 * Sets the value of the '{@link nl.esa.tec.swe.taste.metamodel.taste.BusConnection#getAssociatedBus <em>Associated Bus</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Associated Bus</em>' reference.
	 * @see #getAssociatedBus()
	 * @generated
	 */
	void setAssociatedBus(Bus value);

	/**
	 * Returns the value of the '<em><b>Associated Driver</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Associated Driver</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Associated Driver</em>' reference.
	 * @see #setAssociatedDriver(Driver)
	 * @see nl.esa.tec.swe.taste.metamodel.taste.TastePackage#getBusConnection_AssociatedDriver()
	 * @model
	 * @generated
	 */
	Driver getAssociatedDriver();

	/**
	 * Sets the value of the '{@link nl.esa.tec.swe.taste.metamodel.taste.BusConnection#getAssociatedDriver <em>Associated Driver</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Associated Driver</em>' reference.
	 * @see #getAssociatedDriver()
	 * @generated
	 */
	void setAssociatedDriver(Driver value);

} // BusConnection
