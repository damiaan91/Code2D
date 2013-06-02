/**
 */
package nl.utwente.apc.Code2D.impl;

import nl.utwente.apc.Code2D.Code2DPackage;
import nl.utwente.apc.Code2D.GameObject;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Game Object</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link nl.utwente.apc.Code2D.impl.GameObjectImpl#getName <em>Name</em>}</li>
 *   <li>{@link nl.utwente.apc.Code2D.impl.GameObjectImpl#getTexture <em>Texture</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class GameObjectImpl extends EObjectImpl implements GameObject
{
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
   * The default value of the '{@link #getTexture() <em>Texture</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTexture()
   * @generated
   * @ordered
   */
  protected static final String TEXTURE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getTexture() <em>Texture</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTexture()
   * @generated
   * @ordered
   */
  protected String texture = TEXTURE_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected GameObjectImpl()
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
    return Code2DPackage.Literals.GAME_OBJECT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Code2DPackage.GAME_OBJECT__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getTexture()
  {
    return texture;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTexture(String newTexture)
  {
    String oldTexture = texture;
    texture = newTexture;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Code2DPackage.GAME_OBJECT__TEXTURE, oldTexture, texture));
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
      case Code2DPackage.GAME_OBJECT__NAME:
        return getName();
      case Code2DPackage.GAME_OBJECT__TEXTURE:
        return getTexture();
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
      case Code2DPackage.GAME_OBJECT__NAME:
        setName((String)newValue);
        return;
      case Code2DPackage.GAME_OBJECT__TEXTURE:
        setTexture((String)newValue);
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
      case Code2DPackage.GAME_OBJECT__NAME:
        setName(NAME_EDEFAULT);
        return;
      case Code2DPackage.GAME_OBJECT__TEXTURE:
        setTexture(TEXTURE_EDEFAULT);
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
      case Code2DPackage.GAME_OBJECT__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case Code2DPackage.GAME_OBJECT__TEXTURE:
        return TEXTURE_EDEFAULT == null ? texture != null : !TEXTURE_EDEFAULT.equals(texture);
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
    result.append(" (Name: ");
    result.append(name);
    result.append(", Texture: ");
    result.append(texture);
    result.append(')');
    return result.toString();
  }

} //GameObjectImpl
