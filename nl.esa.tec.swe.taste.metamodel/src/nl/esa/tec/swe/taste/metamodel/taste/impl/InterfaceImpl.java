/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package nl.esa.tec.swe.taste.metamodel.taste.impl;

import java.util.Collection;
import nl.esa.tec.swe.taste.metamodel.taste.Function;
import nl.esa.tec.swe.taste.metamodel.taste.Interface;
import nl.esa.tec.swe.taste.metamodel.taste.InterfaceConnection;
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
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Interface</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link nl.esa.tec.swe.taste.metamodel.taste.impl.InterfaceImpl#getDirection <em>Direction</em>}</li>
 *   <li>{@link nl.esa.tec.swe.taste.metamodel.taste.impl.InterfaceImpl#getIntfct <em>Intfct</em>}</li>
 *   <li>{@link nl.esa.tec.swe.taste.metamodel.taste.impl.InterfaceImpl#getName <em>Name</em>}</li>
 *   <li>{@link nl.esa.tec.swe.taste.metamodel.taste.impl.InterfaceImpl#isIsProvidedInterface <em>Is Provided Interface</em>}</li>
 *   <li>{@link nl.esa.tec.swe.taste.metamodel.taste.impl.InterfaceImpl#getConnectedto <em>Connectedto</em>}</li>
 *   <li>{@link nl.esa.tec.swe.taste.metamodel.taste.impl.InterfaceImpl#getInterfaceType <em>Interface Type</em>}</li>
 *   <li>{@link nl.esa.tec.swe.taste.metamodel.taste.impl.InterfaceImpl#getConnections <em>Connections</em>}</li>
 *   <li>{@link nl.esa.tec.swe.taste.metamodel.taste.impl.InterfaceImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link nl.esa.tec.swe.taste.metamodel.taste.impl.InterfaceImpl#getAssociatedFunction <em>Associated Function</em>}</li>
 *   <li>{@link nl.esa.tec.swe.taste.metamodel.taste.impl.InterfaceImpl#getPeriod <em>Period</em>}</li>
 *   <li>{@link nl.esa.tec.swe.taste.metamodel.taste.impl.InterfaceImpl#getDeadline <em>Deadline</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InterfaceImpl extends EObjectImpl implements Interface {
	/**
	 * The default value of the '{@link #getDirection() <em>Direction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDirection()
	 * @generated
	 * @ordered
	 */
	protected static final String DIRECTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDirection() <em>Direction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDirection()
	 * @generated
	 * @ordered
	 */
	protected String direction = DIRECTION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getIntfct() <em>Intfct</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntfct()
	 * @generated
	 * @ordered
	 */
	protected Function intfct;

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
	 * The default value of the '{@link #isIsProvidedInterface() <em>Is Provided Interface</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsProvidedInterface()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_PROVIDED_INTERFACE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsProvidedInterface() <em>Is Provided Interface</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsProvidedInterface()
	 * @generated
	 * @ordered
	 */
	protected boolean isProvidedInterface = IS_PROVIDED_INTERFACE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getConnectedto() <em>Connectedto</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnectedto()
	 * @generated
	 * @ordered
	 */
	protected EList<Interface> connectedto;

	/**
	 * The default value of the '{@link #getInterfaceType() <em>Interface Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInterfaceType()
	 * @generated
	 * @ordered
	 */
	protected static final int INTERFACE_TYPE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getInterfaceType() <em>Interface Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInterfaceType()
	 * @generated
	 * @ordered
	 */
	protected int interfaceType = INTERFACE_TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getConnections() <em>Connections</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnections()
	 * @generated
	 * @ordered
	 */
	protected EList<InterfaceConnection> connections;

	/**
	 * The cached value of the '{@link #getParameters() <em>Parameters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<InterfaceParameter> parameters;

	/**
	 * The cached value of the '{@link #getAssociatedFunction() <em>Associated Function</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssociatedFunction()
	 * @generated
	 * @ordered
	 */
	protected Function associatedFunction;

	/**
	 * The default value of the '{@link #getPeriod() <em>Period</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPeriod()
	 * @generated
	 * @ordered
	 */
	protected static final int PERIOD_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getPeriod() <em>Period</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPeriod()
	 * @generated
	 * @ordered
	 */
	protected int period = PERIOD_EDEFAULT;

	/**
	 * The default value of the '{@link #getDeadline() <em>Deadline</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeadline()
	 * @generated
	 * @ordered
	 */
	protected static final int DEADLINE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getDeadline() <em>Deadline</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeadline()
	 * @generated
	 * @ordered
	 */
	protected int deadline = DEADLINE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InterfaceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TastePackage.Literals.INTERFACE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDirection() {
		return direction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDirection(String newDirection) {
		String oldDirection = direction;
		direction = newDirection;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TastePackage.INTERFACE__DIRECTION, oldDirection, direction));
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
			eNotify(new ENotificationImpl(this, Notification.SET, TastePackage.INTERFACE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsProvidedInterface() {
		return isProvidedInterface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsProvidedInterface(boolean newIsProvidedInterface) {
		boolean oldIsProvidedInterface = isProvidedInterface;
		isProvidedInterface = newIsProvidedInterface;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TastePackage.INTERFACE__IS_PROVIDED_INTERFACE, oldIsProvidedInterface, isProvidedInterface));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Interface> getConnectedto() {
		if (connectedto == null) {
			connectedto = new EObjectContainmentEList<Interface>(Interface.class, this, TastePackage.INTERFACE__CONNECTEDTO);
		}
		return connectedto;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getInterfaceType() {
		return interfaceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInterfaceType(int newInterfaceType) {
		int oldInterfaceType = interfaceType;
		interfaceType = newInterfaceType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TastePackage.INTERFACE__INTERFACE_TYPE, oldInterfaceType, interfaceType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<InterfaceConnection> getConnections() {
		if (connections == null) {
			connections = new EObjectResolvingEList<InterfaceConnection>(InterfaceConnection.class, this, TastePackage.INTERFACE__CONNECTIONS);
		}
		return connections;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<InterfaceParameter> getParameters() {
		if (parameters == null) {
			parameters = new EObjectContainmentEList<InterfaceParameter>(InterfaceParameter.class, this, TastePackage.INTERFACE__PARAMETERS);
		}
		return parameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Function getAssociatedFunction() {
		if (associatedFunction != null && associatedFunction.eIsProxy()) {
			InternalEObject oldAssociatedFunction = (InternalEObject)associatedFunction;
			associatedFunction = (Function)eResolveProxy(oldAssociatedFunction);
			if (associatedFunction != oldAssociatedFunction) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TastePackage.INTERFACE__ASSOCIATED_FUNCTION, oldAssociatedFunction, associatedFunction));
			}
		}
		return associatedFunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Function basicGetAssociatedFunction() {
		return associatedFunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAssociatedFunction(Function newAssociatedFunction) {
		Function oldAssociatedFunction = associatedFunction;
		associatedFunction = newAssociatedFunction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TastePackage.INTERFACE__ASSOCIATED_FUNCTION, oldAssociatedFunction, associatedFunction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getPeriod() {
		return period;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPeriod(int newPeriod) {
		int oldPeriod = period;
		period = newPeriod;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TastePackage.INTERFACE__PERIOD, oldPeriod, period));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getDeadline() {
		return deadline;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeadline(int newDeadline) {
		int oldDeadline = deadline;
		deadline = newDeadline;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TastePackage.INTERFACE__DEADLINE, oldDeadline, deadline));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TastePackage.INTERFACE__CONNECTEDTO:
				return ((InternalEList<?>)getConnectedto()).basicRemove(otherEnd, msgs);
			case TastePackage.INTERFACE__PARAMETERS:
				return ((InternalEList<?>)getParameters()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Function getIntfct() {
		if (intfct != null && intfct.eIsProxy()) {
			InternalEObject oldIntfct = (InternalEObject)intfct;
			intfct = (Function)eResolveProxy(oldIntfct);
			if (intfct != oldIntfct) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TastePackage.INTERFACE__INTFCT, oldIntfct, intfct));
			}
		}
		return intfct;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Function basicGetIntfct() {
		return intfct;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIntfct(Function newIntfct) {
		Function oldIntfct = intfct;
		intfct = newIntfct;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TastePackage.INTERFACE__INTFCT, oldIntfct, intfct));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TastePackage.INTERFACE__DIRECTION:
				return getDirection();
			case TastePackage.INTERFACE__INTFCT:
				if (resolve) return getIntfct();
				return basicGetIntfct();
			case TastePackage.INTERFACE__NAME:
				return getName();
			case TastePackage.INTERFACE__IS_PROVIDED_INTERFACE:
				return isIsProvidedInterface();
			case TastePackage.INTERFACE__CONNECTEDTO:
				return getConnectedto();
			case TastePackage.INTERFACE__INTERFACE_TYPE:
				return getInterfaceType();
			case TastePackage.INTERFACE__CONNECTIONS:
				return getConnections();
			case TastePackage.INTERFACE__PARAMETERS:
				return getParameters();
			case TastePackage.INTERFACE__ASSOCIATED_FUNCTION:
				if (resolve) return getAssociatedFunction();
				return basicGetAssociatedFunction();
			case TastePackage.INTERFACE__PERIOD:
				return getPeriod();
			case TastePackage.INTERFACE__DEADLINE:
				return getDeadline();
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
			case TastePackage.INTERFACE__DIRECTION:
				setDirection((String)newValue);
				return;
			case TastePackage.INTERFACE__INTFCT:
				setIntfct((Function)newValue);
				return;
			case TastePackage.INTERFACE__NAME:
				setName((String)newValue);
				return;
			case TastePackage.INTERFACE__IS_PROVIDED_INTERFACE:
				setIsProvidedInterface((Boolean)newValue);
				return;
			case TastePackage.INTERFACE__CONNECTEDTO:
				getConnectedto().clear();
				getConnectedto().addAll((Collection<? extends Interface>)newValue);
				return;
			case TastePackage.INTERFACE__INTERFACE_TYPE:
				setInterfaceType((Integer)newValue);
				return;
			case TastePackage.INTERFACE__CONNECTIONS:
				getConnections().clear();
				getConnections().addAll((Collection<? extends InterfaceConnection>)newValue);
				return;
			case TastePackage.INTERFACE__PARAMETERS:
				getParameters().clear();
				getParameters().addAll((Collection<? extends InterfaceParameter>)newValue);
				return;
			case TastePackage.INTERFACE__ASSOCIATED_FUNCTION:
				setAssociatedFunction((Function)newValue);
				return;
			case TastePackage.INTERFACE__PERIOD:
				setPeriod((Integer)newValue);
				return;
			case TastePackage.INTERFACE__DEADLINE:
				setDeadline((Integer)newValue);
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
			case TastePackage.INTERFACE__DIRECTION:
				setDirection(DIRECTION_EDEFAULT);
				return;
			case TastePackage.INTERFACE__INTFCT:
				setIntfct((Function)null);
				return;
			case TastePackage.INTERFACE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case TastePackage.INTERFACE__IS_PROVIDED_INTERFACE:
				setIsProvidedInterface(IS_PROVIDED_INTERFACE_EDEFAULT);
				return;
			case TastePackage.INTERFACE__CONNECTEDTO:
				getConnectedto().clear();
				return;
			case TastePackage.INTERFACE__INTERFACE_TYPE:
				setInterfaceType(INTERFACE_TYPE_EDEFAULT);
				return;
			case TastePackage.INTERFACE__CONNECTIONS:
				getConnections().clear();
				return;
			case TastePackage.INTERFACE__PARAMETERS:
				getParameters().clear();
				return;
			case TastePackage.INTERFACE__ASSOCIATED_FUNCTION:
				setAssociatedFunction((Function)null);
				return;
			case TastePackage.INTERFACE__PERIOD:
				setPeriod(PERIOD_EDEFAULT);
				return;
			case TastePackage.INTERFACE__DEADLINE:
				setDeadline(DEADLINE_EDEFAULT);
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
			case TastePackage.INTERFACE__DIRECTION:
				return DIRECTION_EDEFAULT == null ? direction != null : !DIRECTION_EDEFAULT.equals(direction);
			case TastePackage.INTERFACE__INTFCT:
				return intfct != null;
			case TastePackage.INTERFACE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case TastePackage.INTERFACE__IS_PROVIDED_INTERFACE:
				return isProvidedInterface != IS_PROVIDED_INTERFACE_EDEFAULT;
			case TastePackage.INTERFACE__CONNECTEDTO:
				return connectedto != null && !connectedto.isEmpty();
			case TastePackage.INTERFACE__INTERFACE_TYPE:
				return interfaceType != INTERFACE_TYPE_EDEFAULT;
			case TastePackage.INTERFACE__CONNECTIONS:
				return connections != null && !connections.isEmpty();
			case TastePackage.INTERFACE__PARAMETERS:
				return parameters != null && !parameters.isEmpty();
			case TastePackage.INTERFACE__ASSOCIATED_FUNCTION:
				return associatedFunction != null;
			case TastePackage.INTERFACE__PERIOD:
				return period != PERIOD_EDEFAULT;
			case TastePackage.INTERFACE__DEADLINE:
				return deadline != DEADLINE_EDEFAULT;
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
		result.append(" (direction: ");
		result.append(direction);
		result.append(", name: ");
		result.append(name);
		result.append(", isProvidedInterface: ");
		result.append(isProvidedInterface);
		result.append(", interfaceType: ");
		result.append(interfaceType);
		result.append(", period: ");
		result.append(period);
		result.append(", deadline: ");
		result.append(deadline);
		result.append(')');
		return result.toString();
	}

} //InterfaceImpl
