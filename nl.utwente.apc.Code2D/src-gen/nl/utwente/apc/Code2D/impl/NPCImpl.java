/**
 */
package nl.utwente.apc.Code2D.impl;

import nl.utwente.apc.Code2D.Code2DPackage;
import nl.utwente.apc.Code2D.NPC;
import nl.utwente.apc.Code2D.NPCBehaviour;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>NPC</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link nl.utwente.apc.Code2D.impl.NPCImpl#getBehaviour <em>Behaviour</em>}</li>
 *   <li>{@link nl.utwente.apc.Code2D.impl.NPCImpl#getExtends <em>Extends</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NPCImpl extends MoveableObjectImpl implements NPC
{
  /**
   * The default value of the '{@link #getBehaviour() <em>Behaviour</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBehaviour()
   * @generated
   * @ordered
   */
  protected static final NPCBehaviour BEHAVIOUR_EDEFAULT = NPCBehaviour.FRIENDLY;

  /**
   * The cached value of the '{@link #getBehaviour() <em>Behaviour</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBehaviour()
   * @generated
   * @ordered
   */
  protected NPCBehaviour behaviour = BEHAVIOUR_EDEFAULT;

  /**
   * The cached value of the '{@link #getExtends() <em>Extends</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExtends()
   * @generated
   * @ordered
   */
  protected NPC extends_;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected NPCImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return Code2DPackage.Literals.NPC;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NPCBehaviour getBehaviour()
  {
    return behaviour;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBehaviour(NPCBehaviour newBehaviour)
  {
    NPCBehaviour oldBehaviour = behaviour;
    behaviour = newBehaviour == null ? BEHAVIOUR_EDEFAULT : newBehaviour;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Code2DPackage.NPC__BEHAVIOUR, oldBehaviour, behaviour));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NPC getExtends()
  {
    if (extends_ != null && extends_.eIsProxy())
    {
      InternalEObject oldExtends = (InternalEObject)extends_;
      extends_ = (NPC)eResolveProxy(oldExtends);
      if (extends_ != oldExtends)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, Code2DPackage.NPC__EXTENDS, oldExtends, extends_));
      }
    }
    return extends_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NPC basicGetExtends()
  {
    return extends_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExtends(NPC newExtends)
  {
    NPC oldExtends = extends_;
    extends_ = newExtends;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Code2DPackage.NPC__EXTENDS, oldExtends, extends_));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case Code2DPackage.NPC__BEHAVIOUR:
        return getBehaviour();
      case Code2DPackage.NPC__EXTENDS:
        if (resolve) return getExtends();
        return basicGetExtends();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case Code2DPackage.NPC__BEHAVIOUR:
        setBehaviour((NPCBehaviour)newValue);
        return;
      case Code2DPackage.NPC__EXTENDS:
        setExtends((NPC)newValue);
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
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case Code2DPackage.NPC__BEHAVIOUR:
        setBehaviour(BEHAVIOUR_EDEFAULT);
        return;
      case Code2DPackage.NPC__EXTENDS:
        setExtends((NPC)null);
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
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case Code2DPackage.NPC__BEHAVIOUR:
        return behaviour != BEHAVIOUR_EDEFAULT;
      case Code2DPackage.NPC__EXTENDS:
        return extends_ != null;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (Behaviour: ");
    result.append(behaviour);
    result.append(')');
    return result.toString();
  }

} //NPCImpl
