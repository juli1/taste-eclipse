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
 * A representation of the model object '<em><b>Board</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link nl.esa.tec.swe.taste.metamodel.taste.Board#getBoardcpu <em>Boardcpu</em>}</li>
 *   <li>{@link nl.esa.tec.swe.taste.metamodel.taste.Board#getType <em>Type</em>}</li>
 *   <li>{@link nl.esa.tec.swe.taste.metamodel.taste.Board#getFunctions <em>Functions</em>}</li>
 *   <li>{@link nl.esa.tec.swe.taste.metamodel.taste.Board#getDrivers <em>Drivers</em>}</li>
 * </ul>
 * </p>
 *
 * @see nl.esa.tec.swe.taste.metamodel.taste.TastePackage#getBoard()
 * @model
 * @generated
 */
public interface Board extends TasteComponent {
	/**
	 * Returns the value of the '<em><b>Boardcpu</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Boardcpu</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Boardcpu</em>' containment reference.
	 * @see #setBoardcpu(Processor)
	 * @see nl.esa.tec.swe.taste.metamodel.taste.TastePackage#getBoard_Boardcpu()
	 * @model containment="true"
	 * @generated
	 */
	Processor getBoardcpu();

	/**
	 * Sets the value of the '{@link nl.esa.tec.swe.taste.metamodel.taste.Board#getBoardcpu <em>Boardcpu</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Boardcpu</em>' containment reference.
	 * @see #getBoardcpu()
	 * @generated
	 */
	void setBoardcpu(Processor value);

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
	 * @see nl.esa.tec.swe.taste.metamodel.taste.TastePackage#getBoard_Type()
	 * @model
	 * @generated
	 */
	String getType();

	/**
	 * Sets the value of the '{@link nl.esa.tec.swe.taste.metamodel.taste.Board#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);

	/**
	 * Returns the value of the '<em><b>Functions</b></em>' reference list.
	 * The list contents are of type {@link nl.esa.tec.swe.taste.metamodel.taste.Function}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Functions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Functions</em>' reference list.
	 * @see nl.esa.tec.swe.taste.metamodel.taste.TastePackage#getBoard_Functions()
	 * @model
	 * @generated
	 */
	EList<Function> getFunctions();

	/**
	 * Returns the value of the '<em><b>Drivers</b></em>' reference list.
	 * The list contents are of type {@link nl.esa.tec.swe.taste.metamodel.taste.Driver}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Drivers</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Drivers</em>' reference list.
	 * @see nl.esa.tec.swe.taste.metamodel.taste.TastePackage#getBoard_Drivers()
	 * @model
	 * @generated
	 */
	EList<Driver> getDrivers();

} // Board
