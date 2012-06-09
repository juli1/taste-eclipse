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
 * A representation of the model object '<em><b>Component</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link nl.esa.tec.swe.taste.metamodel.taste.TasteComponent#getComponentType <em>Component Type</em>}</li>
 *   <li>{@link nl.esa.tec.swe.taste.metamodel.taste.TasteComponent#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see nl.esa.tec.swe.taste.metamodel.taste.TastePackage#getTasteComponent()
 * @model
 * @generated
 */
public interface TasteComponent extends EObject {
	/**
	 * Returns the value of the '<em><b>Component Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Component Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Component Type</em>' attribute.
	 * @see #setComponentType(int)
	 * @see nl.esa.tec.swe.taste.metamodel.taste.TastePackage#getTasteComponent_ComponentType()
	 * @model
	 * @generated
	 */
	int getComponentType();

	/**
	 * Sets the value of the '{@link nl.esa.tec.swe.taste.metamodel.taste.TasteComponent#getComponentType <em>Component Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Component Type</em>' attribute.
	 * @see #getComponentType()
	 * @generated
	 */
	void setComponentType(int value);

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
	 * @see nl.esa.tec.swe.taste.metamodel.taste.TastePackage#getTasteComponent_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link nl.esa.tec.swe.taste.metamodel.taste.TasteComponent#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // TasteComponent
