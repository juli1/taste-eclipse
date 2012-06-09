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
 * A representation of the model object '<em><b>Interface</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link nl.esa.tec.swe.taste.metamodel.taste.Interface#getDirection <em>Direction</em>}</li>
 *   <li>{@link nl.esa.tec.swe.taste.metamodel.taste.Interface#getIntfct <em>Intfct</em>}</li>
 *   <li>{@link nl.esa.tec.swe.taste.metamodel.taste.Interface#getName <em>Name</em>}</li>
 *   <li>{@link nl.esa.tec.swe.taste.metamodel.taste.Interface#isIsProvidedInterface <em>Is Provided Interface</em>}</li>
 *   <li>{@link nl.esa.tec.swe.taste.metamodel.taste.Interface#getConnectedto <em>Connectedto</em>}</li>
 *   <li>{@link nl.esa.tec.swe.taste.metamodel.taste.Interface#getInterfaceType <em>Interface Type</em>}</li>
 *   <li>{@link nl.esa.tec.swe.taste.metamodel.taste.Interface#getConnections <em>Connections</em>}</li>
 *   <li>{@link nl.esa.tec.swe.taste.metamodel.taste.Interface#getParameters <em>Parameters</em>}</li>
 *   <li>{@link nl.esa.tec.swe.taste.metamodel.taste.Interface#getAssociatedFunction <em>Associated Function</em>}</li>
 *   <li>{@link nl.esa.tec.swe.taste.metamodel.taste.Interface#getPeriod <em>Period</em>}</li>
 *   <li>{@link nl.esa.tec.swe.taste.metamodel.taste.Interface#getDeadline <em>Deadline</em>}</li>
 * </ul>
 * </p>
 *
 * @see nl.esa.tec.swe.taste.metamodel.taste.TastePackage#getInterface()
 * @model
 * @generated
 */
public interface Interface extends EObject {
	/**
	 * Returns the value of the '<em><b>Direction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Direction</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Direction</em>' attribute.
	 * @see #setDirection(String)
	 * @see nl.esa.tec.swe.taste.metamodel.taste.TastePackage#getInterface_Direction()
	 * @model
	 * @generated
	 */
	String getDirection();

	/**
	 * Sets the value of the '{@link nl.esa.tec.swe.taste.metamodel.taste.Interface#getDirection <em>Direction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Direction</em>' attribute.
	 * @see #getDirection()
	 * @generated
	 */
	void setDirection(String value);

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
	 * @see nl.esa.tec.swe.taste.metamodel.taste.TastePackage#getInterface_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link nl.esa.tec.swe.taste.metamodel.taste.Interface#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Is Provided Interface</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Provided Interface</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Provided Interface</em>' attribute.
	 * @see #setIsProvidedInterface(boolean)
	 * @see nl.esa.tec.swe.taste.metamodel.taste.TastePackage#getInterface_IsProvidedInterface()
	 * @model
	 * @generated
	 */
	boolean isIsProvidedInterface();

	/**
	 * Sets the value of the '{@link nl.esa.tec.swe.taste.metamodel.taste.Interface#isIsProvidedInterface <em>Is Provided Interface</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Provided Interface</em>' attribute.
	 * @see #isIsProvidedInterface()
	 * @generated
	 */
	void setIsProvidedInterface(boolean value);

	/**
	 * Returns the value of the '<em><b>Connectedto</b></em>' containment reference list.
	 * The list contents are of type {@link nl.esa.tec.swe.taste.metamodel.taste.Interface}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Connectedto</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connectedto</em>' containment reference list.
	 * @see nl.esa.tec.swe.taste.metamodel.taste.TastePackage#getInterface_Connectedto()
	 * @model containment="true"
	 * @generated
	 */
	EList<Interface> getConnectedto();

	/**
	 * Returns the value of the '<em><b>Interface Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Interface Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Interface Type</em>' attribute.
	 * @see #setInterfaceType(int)
	 * @see nl.esa.tec.swe.taste.metamodel.taste.TastePackage#getInterface_InterfaceType()
	 * @model
	 * @generated
	 */
	int getInterfaceType();

	/**
	 * Sets the value of the '{@link nl.esa.tec.swe.taste.metamodel.taste.Interface#getInterfaceType <em>Interface Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Interface Type</em>' attribute.
	 * @see #getInterfaceType()
	 * @generated
	 */
	void setInterfaceType(int value);

	/**
	 * Returns the value of the '<em><b>Connections</b></em>' reference list.
	 * The list contents are of type {@link nl.esa.tec.swe.taste.metamodel.taste.InterfaceConnection}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Connections</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connections</em>' reference list.
	 * @see nl.esa.tec.swe.taste.metamodel.taste.TastePackage#getInterface_Connections()
	 * @model
	 * @generated
	 */
	EList<InterfaceConnection> getConnections();

	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link nl.esa.tec.swe.taste.metamodel.taste.InterfaceParameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' containment reference list.
	 * @see nl.esa.tec.swe.taste.metamodel.taste.TastePackage#getInterface_Parameters()
	 * @model containment="true"
	 * @generated
	 */
	EList<InterfaceParameter> getParameters();

	/**
	 * Returns the value of the '<em><b>Associated Function</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Associated Function</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Associated Function</em>' reference.
	 * @see #setAssociatedFunction(Function)
	 * @see nl.esa.tec.swe.taste.metamodel.taste.TastePackage#getInterface_AssociatedFunction()
	 * @model
	 * @generated
	 */
	Function getAssociatedFunction();

	/**
	 * Sets the value of the '{@link nl.esa.tec.swe.taste.metamodel.taste.Interface#getAssociatedFunction <em>Associated Function</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Associated Function</em>' reference.
	 * @see #getAssociatedFunction()
	 * @generated
	 */
	void setAssociatedFunction(Function value);

	/**
	 * Returns the value of the '<em><b>Period</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Period</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Period</em>' attribute.
	 * @see #setPeriod(int)
	 * @see nl.esa.tec.swe.taste.metamodel.taste.TastePackage#getInterface_Period()
	 * @model
	 * @generated
	 */
	int getPeriod();

	/**
	 * Sets the value of the '{@link nl.esa.tec.swe.taste.metamodel.taste.Interface#getPeriod <em>Period</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Period</em>' attribute.
	 * @see #getPeriod()
	 * @generated
	 */
	void setPeriod(int value);

	/**
	 * Returns the value of the '<em><b>Deadline</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Deadline</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Deadline</em>' attribute.
	 * @see #setDeadline(int)
	 * @see nl.esa.tec.swe.taste.metamodel.taste.TastePackage#getInterface_Deadline()
	 * @model
	 * @generated
	 */
	int getDeadline();

	/**
	 * Sets the value of the '{@link nl.esa.tec.swe.taste.metamodel.taste.Interface#getDeadline <em>Deadline</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Deadline</em>' attribute.
	 * @see #getDeadline()
	 * @generated
	 */
	void setDeadline(int value);

	/**
	 * Returns the value of the '<em><b>Intfct</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Intfct</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Intfct</em>' reference.
	 * @see #setIntfct(Function)
	 * @see nl.esa.tec.swe.taste.metamodel.taste.TastePackage#getInterface_Intfct()
	 * @model
	 * @generated
	 */
	Function getIntfct();

	/**
	 * Sets the value of the '{@link nl.esa.tec.swe.taste.metamodel.taste.Interface#getIntfct <em>Intfct</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Intfct</em>' reference.
	 * @see #getIntfct()
	 * @generated
	 */
	void setIntfct(Function value);

} // Interface
