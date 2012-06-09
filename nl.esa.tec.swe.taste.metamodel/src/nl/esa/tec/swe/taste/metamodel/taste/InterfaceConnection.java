/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package nl.esa.tec.swe.taste.metamodel.taste;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Interface Connection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link nl.esa.tec.swe.taste.metamodel.taste.InterfaceConnection#getProvidedInterface <em>Provided Interface</em>}</li>
 *   <li>{@link nl.esa.tec.swe.taste.metamodel.taste.InterfaceConnection#getRequiredInterface <em>Required Interface</em>}</li>
 *   <li>{@link nl.esa.tec.swe.taste.metamodel.taste.InterfaceConnection#getAssociatedBus <em>Associated Bus</em>}</li>
 * </ul>
 * </p>
 *
 * @see nl.esa.tec.swe.taste.metamodel.taste.TastePackage#getInterfaceConnection()
 * @model
 * @generated
 */
public interface InterfaceConnection extends EObject {

	/**
	 * Returns the value of the '<em><b>Provided Interface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Provided Interface</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Provided Interface</em>' reference.
	 * @see #setProvidedInterface(Interface)
	 * @see nl.esa.tec.swe.taste.metamodel.taste.TastePackage#getInterfaceConnection_ProvidedInterface()
	 * @model
	 * @generated
	 */
	Interface getProvidedInterface();

	/**
	 * Sets the value of the '{@link nl.esa.tec.swe.taste.metamodel.taste.InterfaceConnection#getProvidedInterface <em>Provided Interface</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Provided Interface</em>' reference.
	 * @see #getProvidedInterface()
	 * @generated
	 */
	void setProvidedInterface(Interface value);

	/**
	 * Returns the value of the '<em><b>Required Interface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Required Interface</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Required Interface</em>' reference.
	 * @see #setRequiredInterface(Interface)
	 * @see nl.esa.tec.swe.taste.metamodel.taste.TastePackage#getInterfaceConnection_RequiredInterface()
	 * @model
	 * @generated
	 */
	Interface getRequiredInterface();

	/**
	 * Sets the value of the '{@link nl.esa.tec.swe.taste.metamodel.taste.InterfaceConnection#getRequiredInterface <em>Required Interface</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Required Interface</em>' reference.
	 * @see #getRequiredInterface()
	 * @generated
	 */
	void setRequiredInterface(Interface value);

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
	 * @see nl.esa.tec.swe.taste.metamodel.taste.TastePackage#getInterfaceConnection_AssociatedBus()
	 * @model
	 * @generated
	 */
	Bus getAssociatedBus();

	/**
	 * Sets the value of the '{@link nl.esa.tec.swe.taste.metamodel.taste.InterfaceConnection#getAssociatedBus <em>Associated Bus</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Associated Bus</em>' reference.
	 * @see #getAssociatedBus()
	 * @generated
	 */
	void setAssociatedBus(Bus value);
} // InterfaceConnection
