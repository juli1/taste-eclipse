/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package nl.esa.tec.swe.taste.metamodel.taste.impl;

import java.util.Collection;

import nl.esa.tec.swe.taste.metamodel.taste.Interface;
import nl.esa.tec.swe.taste.metamodel.taste.InterfaceParameter;
import nl.esa.tec.swe.taste.metamodel.taste.TastePackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Interface Parameter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link nl.esa.tec.swe.taste.metamodel.taste.impl.InterfaceParameterImpl#getName <em>Name</em>}</li>
 *   <li>{@link nl.esa.tec.swe.taste.metamodel.taste.impl.InterfaceParameterImpl#getType <em>Type</em>}</li>
 *   <li>{@link nl.esa.tec.swe.taste.metamodel.taste.impl.InterfaceParameterImpl#getDirection <em>Direction</em>}</li>
 *   <li>{@link nl.esa.tec.swe.taste.metamodel.taste.impl.InterfaceParameterImpl#getAssociatedInterface <em>Associated Interface</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InterfaceParameterImpl extends EObjectImpl implements InterfaceParameter {
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
	 * The default value of the '{@link #getDirection() <em>Direction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDirection()
	 * @generated
	 * @ordered
	 */
	protected static final int DIRECTION_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getDirection() <em>Direction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDirection()
	 * @generated
	 * @ordered
	 */
	protected int direction = DIRECTION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAssociatedInterface() <em>Associated Interface</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssociatedInterface()
	 * @generated
	 * @ordered
	 */
	protected Interface associatedInterface;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InterfaceParameterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TastePackage.Literals.INTERFACE_PARAMETER;
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
			eNotify(new ENotificationImpl(this, Notification.SET, TastePackage.INTERFACE_PARAMETER__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getDirection() {
		return direction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDirection(int newDirection) {
		int oldDirection = direction;
		direction = newDirection;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TastePackage.INTERFACE_PARAMETER__DIRECTION, oldDirection, direction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Interface getAssociatedInterface() {
		if (associatedInterface != null && associatedInterface.eIsProxy()) {
			InternalEObject oldAssociatedInterface = (InternalEObject)associatedInterface;
			associatedInterface = (Interface)eResolveProxy(oldAssociatedInterface);
			if (associatedInterface != oldAssociatedInterface) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TastePackage.INTERFACE_PARAMETER__ASSOCIATED_INTERFACE, oldAssociatedInterface, associatedInterface));
			}
		}
		return associatedInterface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Interface basicGetAssociatedInterface() {
		return associatedInterface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAssociatedInterface(Interface newAssociatedInterface) {
		Interface oldAssociatedInterface = associatedInterface;
		associatedInterface = newAssociatedInterface;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TastePackage.INTERFACE_PARAMETER__ASSOCIATED_INTERFACE, oldAssociatedInterface, associatedInterface));
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
			eNotify(new ENotificationImpl(this, Notification.SET, TastePackage.INTERFACE_PARAMETER__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TastePackage.INTERFACE_PARAMETER__NAME:
				return getName();
			case TastePackage.INTERFACE_PARAMETER__TYPE:
				return getType();
			case TastePackage.INTERFACE_PARAMETER__DIRECTION:
				return getDirection();
			case TastePackage.INTERFACE_PARAMETER__ASSOCIATED_INTERFACE:
				if (resolve) return getAssociatedInterface();
				return basicGetAssociatedInterface();
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
			case TastePackage.INTERFACE_PARAMETER__NAME:
				setName((String)newValue);
				return;
			case TastePackage.INTERFACE_PARAMETER__TYPE:
				setType((String)newValue);
				return;
			case TastePackage.INTERFACE_PARAMETER__DIRECTION:
				setDirection((Integer)newValue);
				return;
			case TastePackage.INTERFACE_PARAMETER__ASSOCIATED_INTERFACE:
				setAssociatedInterface((Interface)newValue);
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
			case TastePackage.INTERFACE_PARAMETER__NAME:
				setName(NAME_EDEFAULT);
				return;
			case TastePackage.INTERFACE_PARAMETER__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case TastePackage.INTERFACE_PARAMETER__DIRECTION:
				setDirection(DIRECTION_EDEFAULT);
				return;
			case TastePackage.INTERFACE_PARAMETER__ASSOCIATED_INTERFACE:
				setAssociatedInterface((Interface)null);
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
			case TastePackage.INTERFACE_PARAMETER__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case TastePackage.INTERFACE_PARAMETER__TYPE:
				return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
			case TastePackage.INTERFACE_PARAMETER__DIRECTION:
				return direction != DIRECTION_EDEFAULT;
			case TastePackage.INTERFACE_PARAMETER__ASSOCIATED_INTERFACE:
				return associatedInterface != null;
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
		result.append(", type: ");
		result.append(type);
		result.append(", direction: ");
		result.append(direction);
		result.append(')');
		return result.toString();
	}

} //InterfaceParameterImpl
