/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package nl.esa.tec.swe.taste.metamodel.taste.impl;

import java.util.Collection;
import nl.esa.tec.swe.taste.metamodel.taste.Board;
import nl.esa.tec.swe.taste.metamodel.taste.Driver;
import nl.esa.tec.swe.taste.metamodel.taste.Function;
import nl.esa.tec.swe.taste.metamodel.taste.Processor;
import nl.esa.tec.swe.taste.metamodel.taste.TastePackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Board</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link nl.esa.tec.swe.taste.metamodel.taste.impl.BoardImpl#getBoardcpu <em>Boardcpu</em>}</li>
 *   <li>{@link nl.esa.tec.swe.taste.metamodel.taste.impl.BoardImpl#getType <em>Type</em>}</li>
 *   <li>{@link nl.esa.tec.swe.taste.metamodel.taste.impl.BoardImpl#getFunctions <em>Functions</em>}</li>
 *   <li>{@link nl.esa.tec.swe.taste.metamodel.taste.impl.BoardImpl#getDrivers <em>Drivers</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BoardImpl extends TasteComponentImpl implements Board {
	/**
	 * The cached value of the '{@link #getBoardcpu() <em>Boardcpu</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBoardcpu()
	 * @generated
	 * @ordered
	 */
	protected Processor boardcpu;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final String TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected String type = TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getFunctions() <em>Functions</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFunctions()
	 * @generated
	 * @ordered
	 */
	protected EList<Function> functions;

	/**
	 * The cached value of the '{@link #getDrivers() <em>Drivers</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDrivers()
	 * @generated
	 * @ordered
	 */
	protected EList<Driver> drivers;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BoardImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TastePackage.Literals.BOARD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Processor getBoardcpu() {
		return boardcpu;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBoardcpu(Processor newBoardcpu, NotificationChain msgs) {
		Processor oldBoardcpu = boardcpu;
		boardcpu = newBoardcpu;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TastePackage.BOARD__BOARDCPU, oldBoardcpu, newBoardcpu);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBoardcpu(Processor newBoardcpu) {
		if (newBoardcpu != boardcpu) {
			NotificationChain msgs = null;
			if (boardcpu != null)
				msgs = ((InternalEObject)boardcpu).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TastePackage.BOARD__BOARDCPU, null, msgs);
			if (newBoardcpu != null)
				msgs = ((InternalEObject)newBoardcpu).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TastePackage.BOARD__BOARDCPU, null, msgs);
			msgs = basicSetBoardcpu(newBoardcpu, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TastePackage.BOARD__BOARDCPU, newBoardcpu, newBoardcpu));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(String newType) {
		String oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TastePackage.BOARD__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Function> getFunctions() {
		if (functions == null) {
			functions = new EObjectResolvingEList<Function>(Function.class, this, TastePackage.BOARD__FUNCTIONS);
		}
		return functions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Driver> getDrivers() {
		if (drivers == null) {
			drivers = new EObjectResolvingEList<Driver>(Driver.class, this, TastePackage.BOARD__DRIVERS);
		}
		return drivers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TastePackage.BOARD__BOARDCPU:
				return basicSetBoardcpu(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TastePackage.BOARD__BOARDCPU:
				return getBoardcpu();
			case TastePackage.BOARD__TYPE:
				return getType();
			case TastePackage.BOARD__FUNCTIONS:
				return getFunctions();
			case TastePackage.BOARD__DRIVERS:
				return getDrivers();
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
			case TastePackage.BOARD__BOARDCPU:
				setBoardcpu((Processor)newValue);
				return;
			case TastePackage.BOARD__TYPE:
				setType((String)newValue);
				return;
			case TastePackage.BOARD__FUNCTIONS:
				getFunctions().clear();
				getFunctions().addAll((Collection<? extends Function>)newValue);
				return;
			case TastePackage.BOARD__DRIVERS:
				getDrivers().clear();
				getDrivers().addAll((Collection<? extends Driver>)newValue);
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
			case TastePackage.BOARD__BOARDCPU:
				setBoardcpu((Processor)null);
				return;
			case TastePackage.BOARD__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case TastePackage.BOARD__FUNCTIONS:
				getFunctions().clear();
				return;
			case TastePackage.BOARD__DRIVERS:
				getDrivers().clear();
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
			case TastePackage.BOARD__BOARDCPU:
				return boardcpu != null;
			case TastePackage.BOARD__TYPE:
				return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
			case TastePackage.BOARD__FUNCTIONS:
				return functions != null && !functions.isEmpty();
			case TastePackage.BOARD__DRIVERS:
				return drivers != null && !drivers.isEmpty();
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
		result.append(" (type: ");
		result.append(type);
		result.append(')');
		return result.toString();
	}

} //BoardImpl
