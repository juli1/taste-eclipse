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
 * A representation of the model object '<em><b>Function</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link nl.esa.tec.swe.taste.metamodel.taste.Function#getLanguage <em>Language</em>}</li>
 *   <li>{@link nl.esa.tec.swe.taste.metamodel.taste.Function#getInterfaces <em>Interfaces</em>}</li>
 *   <li>{@link nl.esa.tec.swe.taste.metamodel.taste.Function#getAssociatedBoard <em>Associated Board</em>}</li>
 * </ul>
 * </p>
 *
 * @see nl.esa.tec.swe.taste.metamodel.taste.TastePackage#getFunction()
 * @model
 * @generated
 */
public interface Function extends TasteComponent {
	/**
	 * Returns the value of the '<em><b>Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Language</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Language</em>' attribute.
	 * @see #setLanguage(String)
	 * @see nl.esa.tec.swe.taste.metamodel.taste.TastePackage#getFunction_Language()
	 * @model
	 * @generated
	 */
	String getLanguage();

	/**
	 * Sets the value of the '{@link nl.esa.tec.swe.taste.metamodel.taste.Function#getLanguage <em>Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Language</em>' attribute.
	 * @see #getLanguage()
	 * @generated
	 */
	void setLanguage(String value);

	/**
	 * Returns the value of the '<em><b>Interfaces</b></em>' reference list.
	 * The list contents are of type {@link nl.esa.tec.swe.taste.metamodel.taste.Interface}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Interfaces</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Interfaces</em>' reference list.
	 * @see nl.esa.tec.swe.taste.metamodel.taste.TastePackage#getFunction_Interfaces()
	 * @model
	 * @generated
	 */
	EList<Interface> getInterfaces();

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
	 * @see nl.esa.tec.swe.taste.metamodel.taste.TastePackage#getFunction_AssociatedBoard()
	 * @model
	 * @generated
	 */
	Board getAssociatedBoard();

	/**
	 * Sets the value of the '{@link nl.esa.tec.swe.taste.metamodel.taste.Function#getAssociatedBoard <em>Associated Board</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Associated Board</em>' reference.
	 * @see #getAssociatedBoard()
	 * @generated
	 */
	void setAssociatedBoard(Board value);

} // Function
