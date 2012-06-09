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
 * A representation of the model object '<em><b>Processor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link nl.esa.tec.swe.taste.metamodel.taste.Processor#getCpuboard <em>Cpuboard</em>}</li>
 *   <li>{@link nl.esa.tec.swe.taste.metamodel.taste.Processor#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see nl.esa.tec.swe.taste.metamodel.taste.TastePackage#getProcessor()
 * @model
 * @generated
 */
public interface Processor extends TasteComponent {
	/**
	 * Returns the value of the '<em><b>Cpuboard</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cpuboard</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cpuboard</em>' containment reference.
	 * @see #setCpuboard(Board)
	 * @see nl.esa.tec.swe.taste.metamodel.taste.TastePackage#getProcessor_Cpuboard()
	 * @model containment="true"
	 * @generated
	 */
	Board getCpuboard();

	/**
	 * Sets the value of the '{@link nl.esa.tec.swe.taste.metamodel.taste.Processor#getCpuboard <em>Cpuboard</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cpuboard</em>' containment reference.
	 * @see #getCpuboard()
	 * @generated
	 */
	void setCpuboard(Board value);

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
	 * @see nl.esa.tec.swe.taste.metamodel.taste.TastePackage#getProcessor_Type()
	 * @model
	 * @generated
	 */
	String getType();

	/**
	 * Sets the value of the '{@link nl.esa.tec.swe.taste.metamodel.taste.Processor#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);

} // Processor
