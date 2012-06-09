/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package nl.esa.tec.swe.taste.metamodel.taste.impl;

import nl.esa.tec.swe.taste.metamodel.taste.TasteComponent;
import nl.esa.tec.swe.taste.metamodel.taste.TastePackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Component</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link nl.esa.tec.swe.taste.metamodel.taste.impl.TasteComponentImpl#getComponentType <em>Component Type</em>}</li>
 *   <li>{@link nl.esa.tec.swe.taste.metamodel.taste.impl.TasteComponentImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TasteComponentImpl extends EObjectImpl implements TasteComponent {
	/**
	 * The default value of the '{@link #getComponentType() <em>Component Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComponentType()
	 * @generated
	 * @ordered
	 */
	protected static final int COMPONENT_TYPE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getComponentType() <em>Component Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComponentType()
	 * @generated
	 * @ordered
	 */
	protected int componentType = COMPONENT_TYPE_EDEFAULT;

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
	protected TasteComponentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TastePackage.Literals.TASTE_COMPONENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getComponentType() {
		return componentType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComponentType(int newComponentType) {
		int oldComponentType = componentType;
		componentType = newComponentType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TastePackage.TASTE_COMPONENT__COMPONENT_TYPE, oldComponentType, componentType));
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
			eNotify(new ENotificationImpl(this, Notification.SET, TastePackage.TASTE_COMPONENT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TastePackage.TASTE_COMPONENT__COMPONENT_TYPE:
				return getComponentType();
			case TastePackage.TASTE_COMPONENT__NAME:
				return getName();
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
			case TastePackage.TASTE_COMPONENT__COMPONENT_TYPE:
				setComponentType((Integer)newValue);
				return;
			case TastePackage.TASTE_COMPONENT__NAME:
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
			case TastePackage.TASTE_COMPONENT__COMPONENT_TYPE:
				setComponentType(COMPONENT_TYPE_EDEFAULT);
				return;
			case TastePackage.TASTE_COMPONENT__NAME:
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
			case TastePackage.TASTE_COMPONENT__COMPONENT_TYPE:
				return componentType != COMPONENT_TYPE_EDEFAULT;
			case TastePackage.TASTE_COMPONENT__NAME:
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
		result.append(" (componentType: ");
		result.append(componentType);
		result.append(", name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //TasteComponentImpl
