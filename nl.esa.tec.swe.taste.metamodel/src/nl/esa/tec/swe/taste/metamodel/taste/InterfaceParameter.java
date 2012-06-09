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
 * A representation of the model object '<em><b>Interface Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link nl.esa.tec.swe.taste.metamodel.taste.InterfaceParameter#getName <em>Name</em>}</li>
 *   <li>{@link nl.esa.tec.swe.taste.metamodel.taste.InterfaceParameter#getType <em>Type</em>}</li>
 *   <li>{@link nl.esa.tec.swe.taste.metamodel.taste.InterfaceParameter#getDirection <em>Direction</em>}</li>
 *   <li>{@link nl.esa.tec.swe.taste.metamodel.taste.InterfaceParameter#getAssociatedInterface <em>Associated Interface</em>}</li>
 * </ul>
 * </p>
 *
 * @see nl.esa.tec.swe.taste.metamodel.taste.TastePackage#getInterfaceParameter()
 * @model
 * @generated
 */
public interface InterfaceParameter extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see nl.esa.tec.swe.taste.metamodel.taste.TastePackage#getInterfaceParameter_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link nl.esa.tec.swe.taste.metamodel.taste.InterfaceParameter#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Direction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Direction</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Direction</em>' attribute.
	 * @see #setDirection(int)
	 * @see nl.esa.tec.swe.taste.metamodel.taste.TastePackage#getInterfaceParameter_Direction()
	 * @model
	 * @generated
	 */
	int getDirection();

	/**
	 * Sets the value of the '{@link nl.esa.tec.swe.taste.metamodel.taste.InterfaceParameter#getDirection <em>Direction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Direction</em>' attribute.
	 * @see #getDirection()
	 * @generated
	 */
	void setDirection(int value);

	/**
	 * Returns the value of the '<em><b>Associated Interface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Associated Interface</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Associated Interface</em>' reference.
	 * @see #setAssociatedInterface(Interface)
	 * @see nl.esa.tec.swe.taste.metamodel.taste.TastePackage#getInterfaceParameter_AssociatedInterface()
	 * @model
	 * @generated
	 */
	Interface getAssociatedInterface();

	/**
	 * Sets the value of the '{@link nl.esa.tec.swe.taste.metamodel.taste.InterfaceParameter#getAssociatedInterface <em>Associated Interface</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Associated Interface</em>' reference.
	 * @see #getAssociatedInterface()
	 * @generated
	 */
	void setAssociatedInterface(Interface value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(String)
	 * @see nl.esa.tec.swe.taste.metamodel.taste.TastePackage#getInterfaceParameter_Type()
	 * @model
	 * @generated
	 */
	String getType();

	/**
	 * Sets the value of the '{@link nl.esa.tec.swe.taste.metamodel.taste.InterfaceParameter#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);

} // InterfaceParameter
