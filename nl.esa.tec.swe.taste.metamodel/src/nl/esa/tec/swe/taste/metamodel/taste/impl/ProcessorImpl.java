/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package nl.esa.tec.swe.taste.metamodel.taste.impl;

import nl.esa.tec.swe.taste.metamodel.taste.Board;
import nl.esa.tec.swe.taste.metamodel.taste.Processor;
import nl.esa.tec.swe.taste.metamodel.taste.TastePackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Processor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link nl.esa.tec.swe.taste.metamodel.taste.impl.ProcessorImpl#getCpuboard <em>Cpuboard</em>}</li>
 *   <li>{@link nl.esa.tec.swe.taste.metamodel.taste.impl.ProcessorImpl#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ProcessorImpl extends TasteComponentImpl implements Processor {
	/**
	 * The cached value of the '{@link #getCpuboard() <em>Cpuboard</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCpuboard()
	 * @generated
	 * @ordered
	 */
	protected Board cpuboard;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProcessorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TastePackage.Literals.PROCESSOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Board getCpuboard() {
		return cpuboard;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCpuboard(Board newCpuboard, NotificationChain msgs) {
		Board oldCpuboard = cpuboard;
		cpuboard = newCpuboard;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TastePackage.PROCESSOR__CPUBOARD, oldCpuboard, newCpuboard);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCpuboard(Board newCpuboard) {
		if (newCpuboard != cpuboard) {
			NotificationChain msgs = null;
			if (cpuboard != null)
				msgs = ((InternalEObject)cpuboard).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TastePackage.PROCESSOR__CPUBOARD, null, msgs);
			if (newCpuboard != null)
				msgs = ((InternalEObject)newCpuboard).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TastePackage.PROCESSOR__CPUBOARD, null, msgs);
			msgs = basicSetCpuboard(newCpuboard, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TastePackage.PROCESSOR__CPUBOARD, newCpuboard, newCpuboard));
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
			eNotify(new ENotificationImpl(this, Notification.SET, TastePackage.PROCESSOR__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TastePackage.PROCESSOR__CPUBOARD:
				return basicSetCpuboard(null, msgs);
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
			case TastePackage.PROCESSOR__CPUBOARD:
				return getCpuboard();
			case TastePackage.PROCESSOR__TYPE:
				return getType();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TastePackage.PROCESSOR__CPUBOARD:
				setCpuboard((Board)newValue);
				return;
			case TastePackage.PROCESSOR__TYPE:
				setType((String)newValue);
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
			case TastePackage.PROCESSOR__CPUBOARD:
				setCpuboard((Board)null);
				return;
			case TastePackage.PROCESSOR__TYPE:
				setType(TYPE_EDEFAULT);
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
			case TastePackage.PROCESSOR__CPUBOARD:
				return cpuboard != null;
			case TastePackage.PROCESSOR__TYPE:
				return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
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

} //ProcessorImpl
