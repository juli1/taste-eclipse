/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package nl.esa.tec.swe.taste.metamodel.taste.impl;

import java.util.Collection;

import nl.esa.tec.swe.taste.metamodel.taste.Bus;
import nl.esa.tec.swe.taste.metamodel.taste.BusConnection;
import nl.esa.tec.swe.taste.metamodel.taste.Driver;
import nl.esa.tec.swe.taste.metamodel.taste.Interface;
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
 * An implementation of the model object '<em><b>Bus Connection</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link nl.esa.tec.swe.taste.metamodel.taste.impl.BusConnectionImpl#getBusconn <em>Busconn</em>}</li>
 *   <li>{@link nl.esa.tec.swe.taste.metamodel.taste.impl.BusConnectionImpl#getAssociatedBus <em>Associated Bus</em>}</li>
 *   <li>{@link nl.esa.tec.swe.taste.metamodel.taste.impl.BusConnectionImpl#getAssociatedDriver <em>Associated Driver</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BusConnectionImpl extends EObjectImpl implements BusConnection {
	/**
	 * The cached value of the '{@link #getBusconn() <em>Busconn</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBusconn()
	 * @generated
	 * @ordered
	 */
	protected Interface busconn;

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
	 * The cached value of the '{@link #getAssociatedDriver() <em>Associated Driver</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssociatedDriver()
	 * @generated
	 * @ordered
	 */
	protected Driver associatedDriver;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BusConnectionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TastePackage.Literals.BUS_CONNECTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Interface getBusconn() {
		if (busconn != null && busconn.eIsProxy()) {
			InternalEObject oldBusconn = (InternalEObject)busconn;
			busconn = (Interface)eResolveProxy(oldBusconn);
			if (busconn != oldBusconn) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TastePackage.BUS_CONNECTION__BUSCONN, oldBusconn, busconn));
			}
		}
		return busconn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Interface basicGetBusconn() {
		return busconn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBusconn(Interface newBusconn) {
		Interface oldBusconn = busconn;
		busconn = newBusconn;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TastePackage.BUS_CONNECTION__BUSCONN, oldBusconn, busconn));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TastePackage.BUS_CONNECTION__ASSOCIATED_BUS, oldAssociatedBus, associatedBus));
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
			eNotify(new ENotificationImpl(this, Notification.SET, TastePackage.BUS_CONNECTION__ASSOCIATED_BUS, oldAssociatedBus, associatedBus));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Driver getAssociatedDriver() {
		if (associatedDriver != null && associatedDriver.eIsProxy()) {
			InternalEObject oldAssociatedDriver = (InternalEObject)associatedDriver;
			associatedDriver = (Driver)eResolveProxy(oldAssociatedDriver);
			if (associatedDriver != oldAssociatedDriver) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TastePackage.BUS_CONNECTION__ASSOCIATED_DRIVER, oldAssociatedDriver, associatedDriver));
			}
		}
		return associatedDriver;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Driver basicGetAssociatedDriver() {
		return associatedDriver;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAssociatedDriver(Driver newAssociatedDriver) {
		Driver oldAssociatedDriver = associatedDriver;
		associatedDriver = newAssociatedDriver;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TastePackage.BUS_CONNECTION__ASSOCIATED_DRIVER, oldAssociatedDriver, associatedDriver));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TastePackage.BUS_CONNECTION__BUSCONN:
				if (resolve) return getBusconn();
				return basicGetBusconn();
			case TastePackage.BUS_CONNECTION__ASSOCIATED_BUS:
				if (resolve) return getAssociatedBus();
				return basicGetAssociatedBus();
			case TastePackage.BUS_CONNECTION__ASSOCIATED_DRIVER:
				if (resolve) return getAssociatedDriver();
				return basicGetAssociatedDriver();
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
			case TastePackage.BUS_CONNECTION__BUSCONN:
				setBusconn((Interface)newValue);
				return;
			case TastePackage.BUS_CONNECTION__ASSOCIATED_BUS:
				setAssociatedBus((Bus)newValue);
				return;
			case TastePackage.BUS_CONNECTION__ASSOCIATED_DRIVER:
				setAssociatedDriver((Driver)newValue);
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
			case TastePackage.BUS_CONNECTION__BUSCONN:
				setBusconn((Interface)null);
				return;
			case TastePackage.BUS_CONNECTION__ASSOCIATED_BUS:
				setAssociatedBus((Bus)null);
				return;
			case TastePackage.BUS_CONNECTION__ASSOCIATED_DRIVER:
				setAssociatedDriver((Driver)null);
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
			case TastePackage.BUS_CONNECTION__BUSCONN:
				return busconn != null;
			case TastePackage.BUS_CONNECTION__ASSOCIATED_BUS:
				return associatedBus != null;
			case TastePackage.BUS_CONNECTION__ASSOCIATED_DRIVER:
				return associatedDriver != null;
		}
		return super.eIsSet(featureID);
	}

} //BusConnectionImpl
