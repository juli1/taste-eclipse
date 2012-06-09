/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package nl.esa.tec.swe.taste.metamodel.taste.impl;

import java.util.Collection;
import nl.esa.tec.swe.taste.metamodel.taste.Board;
import nl.esa.tec.swe.taste.metamodel.taste.Bus;
import nl.esa.tec.swe.taste.metamodel.taste.BusConnection;
import nl.esa.tec.swe.taste.metamodel.taste.Driver;
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
 * An implementation of the model object '<em><b>Driver</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link nl.esa.tec.swe.taste.metamodel.taste.impl.DriverImpl#getEReference0 <em>EReference0</em>}</li>
 *   <li>{@link nl.esa.tec.swe.taste.metamodel.taste.impl.DriverImpl#getAssociatedBoard <em>Associated Board</em>}</li>
 *   <li>{@link nl.esa.tec.swe.taste.metamodel.taste.impl.DriverImpl#getDrvbus <em>Drvbus</em>}</li>
 *   <li>{@link nl.esa.tec.swe.taste.metamodel.taste.impl.DriverImpl#getType <em>Type</em>}</li>
 *   <li>{@link nl.esa.tec.swe.taste.metamodel.taste.impl.DriverImpl#getConfig <em>Config</em>}</li>
 *   <li>{@link nl.esa.tec.swe.taste.metamodel.taste.impl.DriverImpl#getConnections <em>Connections</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DriverImpl extends TasteComponentImpl implements Driver {
	/**
	 * The cached value of the '{@link #getEReference0() <em>EReference0</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEReference0()
	 * @generated
	 * @ordered
	 */
	protected Driver eReference0;

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
	 * The cached value of the '{@link #getDrvbus() <em>Drvbus</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDrvbus()
	 * @generated
	 * @ordered
	 */
	protected Bus drvbus;

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
	 * The default value of the '{@link #getConfig() <em>Config</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConfig()
	 * @generated
	 * @ordered
	 */
	protected static final String CONFIG_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getConfig() <em>Config</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConfig()
	 * @generated
	 * @ordered
	 */
	protected String config = CONFIG_EDEFAULT;

	/**
	 * The cached value of the '{@link #getConnections() <em>Connections</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnections()
	 * @generated
	 * @ordered
	 */
	protected EList<BusConnection> connections;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DriverImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TastePackage.Literals.DRIVER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Driver getEReference0() {
		if (eReference0 != null && eReference0.eIsProxy()) {
			InternalEObject oldEReference0 = (InternalEObject)eReference0;
			eReference0 = (Driver)eResolveProxy(oldEReference0);
			if (eReference0 != oldEReference0) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TastePackage.DRIVER__EREFERENCE0, oldEReference0, eReference0));
			}
		}
		return eReference0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Driver basicGetEReference0() {
		return eReference0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEReference0(Driver newEReference0) {
		Driver oldEReference0 = eReference0;
		eReference0 = newEReference0;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TastePackage.DRIVER__EREFERENCE0, oldEReference0, eReference0));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TastePackage.DRIVER__ASSOCIATED_BOARD, oldAssociatedBoard, associatedBoard));
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
			eNotify(new ENotificationImpl(this, Notification.SET, TastePackage.DRIVER__ASSOCIATED_BOARD, oldAssociatedBoard, associatedBoard));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Bus getDrvbus() {
		if (drvbus != null && drvbus.eIsProxy()) {
			InternalEObject oldDrvbus = (InternalEObject)drvbus;
			drvbus = (Bus)eResolveProxy(oldDrvbus);
			if (drvbus != oldDrvbus) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TastePackage.DRIVER__DRVBUS, oldDrvbus, drvbus));
			}
		}
		return drvbus;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Bus basicGetDrvbus() {
		return drvbus;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDrvbus(Bus newDrvbus) {
		Bus oldDrvbus = drvbus;
		drvbus = newDrvbus;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TastePackage.DRIVER__DRVBUS, oldDrvbus, drvbus));
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
			eNotify(new ENotificationImpl(this, Notification.SET, TastePackage.DRIVER__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getConfig() {
		return config;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConfig(String newConfig) {
		String oldConfig = config;
		config = newConfig;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TastePackage.DRIVER__CONFIG, oldConfig, config));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BusConnection> getConnections() {
		if (connections == null) {
			connections = new EObjectResolvingEList<BusConnection>(BusConnection.class, this, TastePackage.DRIVER__CONNECTIONS);
		}
		return connections;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TastePackage.DRIVER__EREFERENCE0:
				if (resolve) return getEReference0();
				return basicGetEReference0();
			case TastePackage.DRIVER__ASSOCIATED_BOARD:
				if (resolve) return getAssociatedBoard();
				return basicGetAssociatedBoard();
			case TastePackage.DRIVER__DRVBUS:
				if (resolve) return getDrvbus();
				return basicGetDrvbus();
			case TastePackage.DRIVER__TYPE:
				return getType();
			case TastePackage.DRIVER__CONFIG:
				return getConfig();
			case TastePackage.DRIVER__CONNECTIONS:
				return getConnections();
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
			case TastePackage.DRIVER__EREFERENCE0:
				setEReference0((Driver)newValue);
				return;
			case TastePackage.DRIVER__ASSOCIATED_BOARD:
				setAssociatedBoard((Board)newValue);
				return;
			case TastePackage.DRIVER__DRVBUS:
				setDrvbus((Bus)newValue);
				return;
			case TastePackage.DRIVER__TYPE:
				setType((String)newValue);
				return;
			case TastePackage.DRIVER__CONFIG:
				setConfig((String)newValue);
				return;
			case TastePackage.DRIVER__CONNECTIONS:
				getConnections().clear();
				getConnections().addAll((Collection<? extends BusConnection>)newValue);
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
			case TastePackage.DRIVER__EREFERENCE0:
				setEReference0((Driver)null);
				return;
			case TastePackage.DRIVER__ASSOCIATED_BOARD:
				setAssociatedBoard((Board)null);
				return;
			case TastePackage.DRIVER__DRVBUS:
				setDrvbus((Bus)null);
				return;
			case TastePackage.DRIVER__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case TastePackage.DRIVER__CONFIG:
				setConfig(CONFIG_EDEFAULT);
				return;
			case TastePackage.DRIVER__CONNECTIONS:
				getConnections().clear();
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
			case TastePackage.DRIVER__EREFERENCE0:
				return eReference0 != null;
			case TastePackage.DRIVER__ASSOCIATED_BOARD:
				return associatedBoard != null;
			case TastePackage.DRIVER__DRVBUS:
				return drvbus != null;
			case TastePackage.DRIVER__TYPE:
				return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
			case TastePackage.DRIVER__CONFIG:
				return CONFIG_EDEFAULT == null ? config != null : !CONFIG_EDEFAULT.equals(config);
			case TastePackage.DRIVER__CONNECTIONS:
				return connections != null && !connections.isEmpty();
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
		result.append(", config: ");
		result.append(config);
		result.append(')');
		return result.toString();
	}

} //DriverImpl
