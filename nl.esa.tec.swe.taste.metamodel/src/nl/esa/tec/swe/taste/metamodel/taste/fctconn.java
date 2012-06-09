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
 * A representation of the model object '<em><b>fctconn</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link nl.esa.tec.swe.taste.metamodel.taste.fctconn#getConnbus <em>Connbus</em>}</li>
 *   <li>{@link nl.esa.tec.swe.taste.metamodel.taste.fctconn#getConnfct <em>Connfct</em>}</li>
 *   <li>{@link nl.esa.tec.swe.taste.metamodel.taste.fctconn#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see nl.esa.tec.swe.taste.metamodel.taste.TastePackage#getfctconn()
 * @model
 * @generated
 */
public interface fctconn extends EObject {
	/**
	 * Returns the value of the '<em><b>Connbus</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Connbus</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connbus</em>' reference.
	 * @see #setConnbus(Bus)
	 * @see nl.esa.tec.swe.taste.metamodel.taste.TastePackage#getfctconn_Connbus()
	 * @model
	 * @generated
	 */
	Bus getConnbus();

	/**
	 * Sets the value of the '{@link nl.esa.tec.swe.taste.metamodel.taste.fctconn#getConnbus <em>Connbus</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Connbus</em>' reference.
	 * @see #getConnbus()
	 * @generated
	 */
	void setConnbus(Bus value);

	/**
	 * Returns the value of the '<em><b>Connfct</b></em>' reference list.
	 * The list contents are of type {@link nl.esa.tec.swe.taste.metamodel.taste.Interface}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Connfct</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connfct</em>' reference list.
	 * @see nl.esa.tec.swe.taste.metamodel.taste.TastePackage#getfctconn_Connfct()
	 * @model
	 * @generated
	 */
	EList<Interface> getConnfct();

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
	 * @see nl.esa.tec.swe.taste.metamodel.taste.TastePackage#getfctconn_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link nl.esa.tec.swe.taste.metamodel.taste.fctconn#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // fctconn
