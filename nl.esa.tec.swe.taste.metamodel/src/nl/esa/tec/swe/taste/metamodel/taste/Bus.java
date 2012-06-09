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
 * A representation of the model object '<em><b>Bus</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link nl.esa.tec.swe.taste.metamodel.taste.Bus#getType <em>Type</em>}</li>
 *   <li>{@link nl.esa.tec.swe.taste.metamodel.taste.Bus#getConnections <em>Connections</em>}</li>
 * </ul>
 * </p>
 *
 * @see nl.esa.tec.swe.taste.metamodel.taste.TastePackage#getBus()
 * @model
 * @generated
 */
public interface Bus extends TasteComponent {
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
	 * @see nl.esa.tec.swe.taste.metamodel.taste.TastePackage#getBus_Type()
	 * @model
	 * @generated
	 */
	String getType();

	/**
	 * Sets the value of the '{@link nl.esa.tec.swe.taste.metamodel.taste.Bus#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);

	/**
	 * Returns the value of the '<em><b>Connections</b></em>' reference list.
	 * The list contents are of type {@link nl.esa.tec.swe.taste.metamodel.taste.BusConnection}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Connections</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connections</em>' reference list.
	 * @see nl.esa.tec.swe.taste.metamodel.taste.TastePackage#getBus_Connections()
	 * @model
	 * @generated
	 */
	EList<BusConnection> getConnections();

} // Bus
