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
 * A representation of the model object '<em><b>Driver</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link nl.esa.tec.swe.taste.metamodel.taste.Driver#getEReference0 <em>EReference0</em>}</li>
 *   <li>{@link nl.esa.tec.swe.taste.metamodel.taste.Driver#getAssociatedBoard <em>Associated Board</em>}</li>
 *   <li>{@link nl.esa.tec.swe.taste.metamodel.taste.Driver#getDrvbus <em>Drvbus</em>}</li>
 *   <li>{@link nl.esa.tec.swe.taste.metamodel.taste.Driver#getType <em>Type</em>}</li>
 *   <li>{@link nl.esa.tec.swe.taste.metamodel.taste.Driver#getConfig <em>Config</em>}</li>
 *   <li>{@link nl.esa.tec.swe.taste.metamodel.taste.Driver#getConnections <em>Connections</em>}</li>
 * </ul>
 * </p>
 *
 * @see nl.esa.tec.swe.taste.metamodel.taste.TastePackage#getDriver()
 * @model
 * @generated
 */
public interface Driver extends TasteComponent {
	/**
	 * Returns the value of the '<em><b>EReference0</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EReference0</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>EReference0</em>' reference.
	 * @see #setEReference0(Driver)
	 * @see nl.esa.tec.swe.taste.metamodel.taste.TastePackage#getDriver_EReference0()
	 * @model
	 * @generated
	 */
	Driver getEReference0();

	/**
	 * Sets the value of the '{@link nl.esa.tec.swe.taste.metamodel.taste.Driver#getEReference0 <em>EReference0</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>EReference0</em>' reference.
	 * @see #getEReference0()
	 * @generated
	 */
	void setEReference0(Driver value);

	/**
	 * Returns the value of the '<em><b>Associated Board</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Associated Board</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Associated Board</em>' reference.
	 * @see #setAssociatedBoard(Board)
	 * @see nl.esa.tec.swe.taste.metamodel.taste.TastePackage#getDriver_AssociatedBoard()
	 * @model
	 * @generated
	 */
	Board getAssociatedBoard();

	/**
	 * Sets the value of the '{@link nl.esa.tec.swe.taste.metamodel.taste.Driver#getAssociatedBoard <em>Associated Board</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Associated Board</em>' reference.
	 * @see #getAssociatedBoard()
	 * @generated
	 */
	void setAssociatedBoard(Board value);

	/**
	 * Returns the value of the '<em><b>Drvbus</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Drvbus</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Drvbus</em>' reference.
	 * @see #setDrvbus(Bus)
	 * @see nl.esa.tec.swe.taste.metamodel.taste.TastePackage#getDriver_Drvbus()
	 * @model
	 * @generated
	 */
	Bus getDrvbus();

	/**
	 * Sets the value of the '{@link nl.esa.tec.swe.taste.metamodel.taste.Driver#getDrvbus <em>Drvbus</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Drvbus</em>' reference.
	 * @see #getDrvbus()
	 * @generated
	 */
	void setDrvbus(Bus value);

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
	 * @see nl.esa.tec.swe.taste.metamodel.taste.TastePackage#getDriver_Type()
	 * @model
	 * @generated
	 */
	String getType();

	/**
	 * Sets the value of the '{@link nl.esa.tec.swe.taste.metamodel.taste.Driver#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);

	/**
	 * Returns the value of the '<em><b>Config</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Config</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Config</em>' attribute.
	 * @see #setConfig(String)
	 * @see nl.esa.tec.swe.taste.metamodel.taste.TastePackage#getDriver_Config()
	 * @model
	 * @generated
	 */
	String getConfig();

	/**
	 * Sets the value of the '{@link nl.esa.tec.swe.taste.metamodel.taste.Driver#getConfig <em>Config</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Config</em>' attribute.
	 * @see #getConfig()
	 * @generated
	 */
	void setConfig(String value);

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
	 * @see nl.esa.tec.swe.taste.metamodel.taste.TastePackage#getDriver_Connections()
	 * @model
	 * @generated
	 */
	EList<BusConnection> getConnections();

} // Driver
