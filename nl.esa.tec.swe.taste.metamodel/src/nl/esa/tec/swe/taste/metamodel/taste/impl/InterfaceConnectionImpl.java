/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package nl.esa.tec.swe.taste.metamodel.taste.impl;

import nl.esa.tec.swe.taste.metamodel.taste.Bus;
import nl.esa.tec.swe.taste.metamodel.taste.Interface;
import nl.esa.tec.swe.taste.metamodel.taste.InterfaceConnection;
import nl.esa.tec.swe.taste.metamodel.taste.TastePackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Interface Connection</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link nl.esa.tec.swe.taste.metamodel.taste.impl.InterfaceConnectionImpl#getProvidedInterface <em>Provided Interface</em>}</li>
 *   <li>{@link nl.esa.tec.swe.taste.metamodel.taste.impl.InterfaceConnectionImpl#getRequiredInterface <em>Required Interface</em>}</li>
 *   <li>{@link nl.esa.tec.swe.taste.metamodel.taste.impl.InterfaceConnectionImpl#getAssociatedBus <em>Associated Bus</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InterfaceConnectionImpl extends EObjectImpl implements InterfaceConnection {
	/**
	 * The cached value of the '{@link #getProvidedInterface() <em>Provided Interface</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProvidedInterface()
	 * @generated
	 * @ordered
	 */
	protected Interface providedInterface;
	/**
	 * The cached value of the '{@link #getRequiredInterface() <em>Required Interface</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequiredInterface()
	 * @generated
	 * @ordered
	 */
	protected Interface requiredInterface;

	/**
	 * The cached value of the '{@link #getAssociatedBus() <em>Associated Bus</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssociatedBus()
	 * @generated
	 * @ordered
	 */
	protected Bus associatedBus;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InterfaceConnectionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TastePackage.Literals.INTERFACE_CONNECTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Interface getProvidedInterface() {
		if (providedInterface != null && providedInterface.eIsProxy()) {
			InternalEObject oldProvidedInterface = (InternalEObject)providedInterface;
			providedInterface = (Interface)eResolveProxy(oldProvidedInterface);
			if (providedInterface != oldProvidedInterface) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TastePackage.INTERFACE_CONNECTION__PROVIDED_INTERFACE, oldProvidedInterface, providedInterface));
			}
		}
		return providedInterface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Interface basicGetProvidedInterface() {
		return providedInterface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProvidedInterface(Interface newProvidedInterface) {
		Interface oldProvidedInterface = providedInterface;
		providedInterface = newProvidedInterface;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TastePackage.INTERFACE_CONNECTION__PROVIDED_INTERFACE, oldProvidedInterface, providedInterface));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Interface getRequiredInterface() {
		if (requiredInterface != null && requiredInterface.eIsProxy()) {
			InternalEObject oldRequiredInterface = (InternalEObject)requiredInterface;
			requiredInterface = (Interface)eResolveProxy(oldRequiredInterface);
			if (requiredInterface != oldRequiredInterface) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TastePackage.INTERFACE_CONNECTION__REQUIRED_INTERFACE, oldRequiredInterface, requiredInterface));
			}
		}
		return requiredInterface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Interface basicGetRequiredInterface() {
		return requiredInterface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRequiredInterface(Interface newRequiredInterface) {
		Interface oldRequiredInterface = requiredInterface;
		requiredInterface = newRequiredInterface;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TastePackage.INTERFACE_CONNECTION__REQUIRED_INTERFACE, oldRequiredInterface, requiredInterface));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Bus getAssociatedBus() {
		if (associatedBus != null && associatedBus.eIsProxy()) {
			InternalEObject oldAssociatedBus = (InternalEObject)associatedBus;
			associatedBus = (Bus)eResolveProxy(oldAssociatedBus);
			if (associatedBus != oldAssociatedBus) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TastePackage.INTERFACE_CONNECTION__ASSOCIATED_BUS, oldAssociatedBus, associatedBus));
			}
		}
		return associatedBus;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Bus basicGetAssociatedBus() {
		return associatedBus;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAssociatedBus(Bus newAssociatedBus) {
		Bus oldAssociatedBus = associatedBus;
		associatedBus = newAssociatedBus;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TastePackage.INTERFACE_CONNECTION__ASSOCIATED_BUS, oldAssociatedBus, associatedBus));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TastePackage.INTERFACE_CONNECTION__PROVIDED_INTERFACE:
				if (resolve) return getProvidedInterface();
				return basicGetProvidedInterface();
			case TastePackage.INTERFACE_CONNECTION__REQUIRED_INTERFACE:
				if (resolve) return getRequiredInterface();
				return basicGetRequiredInterface();
			case TastePackage.INTERFACE_CONNECTION__ASSOCIATED_BUS:
				if (resolve) return getAssociatedBus();
				return basicGetAssociatedBus();
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
			case TastePackage.INTERFACE_CONNECTION__PROVIDED_INTERFACE:
				setProvidedInterface((Interface)newValue);
				return;
			case TastePackage.INTERFACE_CONNECTION__REQUIRED_INTERFACE:
				setRequiredInterface((Interface)newValue);
				return;
			case TastePackage.INTERFACE_CONNECTION__ASSOCIATED_BUS:
				setAssociatedBus((Bus)newValue);
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
			case TastePackage.INTERFACE_CONNECTION__PROVIDED_INTERFACE:
				setProvidedInterface((Interface)null);
				return;
			case TastePackage.INTERFACE_CONNECTION__REQUIRED_INTERFACE:
				setRequiredInterface((Interface)null);
				return;
			case TastePackage.INTERFACE_CONNECTION__ASSOCIATED_BUS:
				setAssociatedBus((Bus)null);
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
			case TastePackage.INTERFACE_CONNECTION__PROVIDED_INTERFACE:
				return providedInterface != null;
			case TastePackage.INTERFACE_CONNECTION__REQUIRED_INTERFACE:
				return requiredInterface != null;
			case TastePackage.INTERFACE_CONNECTION__ASSOCIATED_BUS:
				return associatedBus != null;
		}
		return super.eIsSet(featureID);
	}

} //InterfaceConnectionImpl
