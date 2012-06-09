/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package nl.esa.tec.swe.taste.metamodel.taste.impl;

import java.util.Collection;

import nl.esa.tec.swe.taste.metamodel.taste.Bus;
import nl.esa.tec.swe.taste.metamodel.taste.Interface;
import nl.esa.tec.swe.taste.metamodel.taste.TastePackage;
import nl.esa.tec.swe.taste.metamodel.taste.fctconn;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>fctconn</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link nl.esa.tec.swe.taste.metamodel.taste.impl.fctconnImpl#getConnbus <em>Connbus</em>}</li>
 *   <li>{@link nl.esa.tec.swe.taste.metamodel.taste.impl.fctconnImpl#getConnfct <em>Connfct</em>}</li>
 *   <li>{@link nl.esa.tec.swe.taste.metamodel.taste.impl.fctconnImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class fctconnImpl extends EObjectImpl implements fctconn {
	/**
	 * The cached value of the '{@link #getConnbus() <em>Connbus</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnbus()
	 * @generated
	 * @ordered
	 */
	protected Bus connbus;

	/**
	 * The cached value of the '{@link #getConnfct() <em>Connfct</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnfct()
	 * @generated
	 * @ordered
	 */
	protected EList<Interface> connfct;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected fctconnImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TastePackage.Literals.FCTCONN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Bus getConnbus() {
		if (connbus != null && connbus.eIsProxy()) {
			InternalEObject oldConnbus = (InternalEObject)connbus;
			connbus = (Bus)eResolveProxy(oldConnbus);
			if (connbus != oldConnbus) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TastePackage.FCTCONN__CONNBUS, oldConnbus, connbus));
			}
		}
		return connbus;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Bus basicGetConnbus() {
		return connbus;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConnbus(Bus newConnbus) {
		Bus oldConnbus = connbus;
		connbus = newConnbus;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TastePackage.FCTCONN__CONNBUS, oldConnbus, connbus));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Interface> getConnfct() {
		if (connfct == null) {
			connfct = new EObjectResolvingEList<Interface>(Interface.class, this, TastePackage.FCTCONN__CONNFCT);
		}
		return connfct;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TastePackage.FCTCONN__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TastePackage.FCTCONN__CONNBUS:
				if (resolve) return getConnbus();
				return basicGetConnbus();
			case TastePackage.FCTCONN__CONNFCT:
				return getConnfct();
			case TastePackage.FCTCONN__NAME:
				return getName();
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
			case TastePackage.FCTCONN__CONNBUS:
				setConnbus((Bus)newValue);
				return;
			case TastePackage.FCTCONN__CONNFCT:
				getConnfct().clear();
				getConnfct().addAll((Collection<? extends Interface>)newValue);
				return;
			case TastePackage.FCTCONN__NAME:
				setName((String)newValue);
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
			case TastePackage.FCTCONN__CONNBUS:
				setConnbus((Bus)null);
				return;
			case TastePackage.FCTCONN__CONNFCT:
				getConnfct().clear();
				return;
			case TastePackage.FCTCONN__NAME:
				setName(NAME_EDEFAULT);
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
			case TastePackage.FCTCONN__CONNBUS:
				return connbus != null;
			case TastePackage.FCTCONN__CONNFCT:
				return connfct != null && !connfct.isEmpty();
			case TastePackage.FCTCONN__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
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
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //fctconnImpl
