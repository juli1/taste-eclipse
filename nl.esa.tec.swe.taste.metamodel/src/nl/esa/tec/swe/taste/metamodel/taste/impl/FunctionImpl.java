/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package nl.esa.tec.swe.taste.metamodel.taste.impl;

import java.util.Collection;
import nl.esa.tec.swe.taste.metamodel.taste.Board;
import nl.esa.tec.swe.taste.metamodel.taste.Function;
import nl.esa.tec.swe.taste.metamodel.taste.Interface;
import nl.esa.tec.swe.taste.metamodel.taste.TastePackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Function</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link nl.esa.tec.swe.taste.metamodel.taste.impl.FunctionImpl#getLanguage <em>Language</em>}</li>
 *   <li>{@link nl.esa.tec.swe.taste.metamodel.taste.impl.FunctionImpl#getInterfaces <em>Interfaces</em>}</li>
 *   <li>{@link nl.esa.tec.swe.taste.metamodel.taste.impl.FunctionImpl#getAssociatedBoard <em>Associated Board</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FunctionImpl extends TasteComponentImpl implements Function {
	/**
	 * The default value of the '{@link #getLanguage() <em>Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLanguage()
	 * @generated
	 * @ordered
	 */
	protected static final String LANGUAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLanguage() <em>Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLanguage()
	 * @generated
	 * @ordered
	 */
	protected String language = LANGUAGE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getInterfaces() <em>Interfaces</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInterfaces()
	 * @generated
	 * @ordered
	 */
	protected EList<Interface> interfaces;

	/**
	 * The cached value of the '{@link #getAssociatedBoard() <em>Associated Board</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssociatedBoard()
	 * @generated
	 * @ordered
	 */
	protected Board associatedBoard;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FunctionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TastePackage.Literals.FUNCTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLanguage(String newLanguage) {
		String oldLanguage = language;
		language = newLanguage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TastePackage.FUNCTION__LANGUAGE, oldLanguage, language));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Interface> getInterfaces() {
		if (interfaces == null) {
			interfaces = new EObjectResolvingEList<Interface>(Interface.class, this, TastePackage.FUNCTION__INTERFACES);
		}
		return interfaces;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Board getAssociatedBoard() {
		if (associatedBoard != null && associatedBoard.eIsProxy()) {
			InternalEObject oldAssociatedBoard = (InternalEObject)associatedBoard;
			associatedBoard = (Board)eResolveProxy(oldAssociatedBoard);
			if (associatedBoard != oldAssociatedBoard) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TastePackage.FUNCTION__ASSOCIATED_BOARD, oldAssociatedBoard, associatedBoard));
			}
		}
		return associatedBoard;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Board basicGetAssociatedBoard() {
		return associatedBoard;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAssociatedBoard(Board newAssociatedBoard) {
		Board oldAssociatedBoard = associatedBoard;
		associatedBoard = newAssociatedBoard;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TastePackage.FUNCTION__ASSOCIATED_BOARD, oldAssociatedBoard, associatedBoard));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TastePackage.FUNCTION__LANGUAGE:
				return getLanguage();
			case TastePackage.FUNCTION__INTERFACES:
				return getInterfaces();
			case TastePackage.FUNCTION__ASSOCIATED_BOARD:
				if (resolve) return getAssociatedBoard();
				return basicGetAssociatedBoard();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TastePackage.FUNCTION__LANGUAGE:
				setLanguage((String)newValue);
				return;
			case TastePackage.FUNCTION__INTERFACES:
				getInterfaces().clear();
				getInterfaces().addAll((Collection<? extends Interface>)newValue);
				return;
			case TastePackage.FUNCTION__ASSOCIATED_BOARD:
				setAssociatedBoard((Board)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case TastePackage.FUNCTION__LANGUAGE:
				setLanguage(LANGUAGE_EDEFAULT);
				return;
			case TastePackage.FUNCTION__INTERFACES:
				getInterfaces().clear();
				return;
			case TastePackage.FUNCTION__ASSOCIATED_BOARD:
				setAssociatedBoard((Board)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case TastePackage.FUNCTION__LANGUAGE:
				return LANGUAGE_EDEFAULT == null ? language != null : !LANGUAGE_EDEFAULT.equals(language);
			case TastePackage.FUNCTION__INTERFACES:
				return interfaces != null && !interfaces.isEmpty();
			case TastePackage.FUNCTION__ASSOCIATED_BOARD:
				return associatedBoard != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (language: ");
		result.append(language);
		result.append(')');
		return result.toString();
	}

} //FunctionImpl
