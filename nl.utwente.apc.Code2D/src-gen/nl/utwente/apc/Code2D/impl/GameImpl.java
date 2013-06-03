/**
 */
package nl.utwente.apc.Code2D.impl;

import java.util.Collection;
import nl.utwente.apc.Code2D.Code2DPackage;
import nl.utwente.apc.Code2D.Game;

import nl.utwente.apc.Code2D.GameObject;
import nl.utwente.apc.Code2D.World;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Game</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link nl.utwente.apc.Code2D.impl.GameImpl#getName <em>Name</em>}</li>
 *   <li>{@link nl.utwente.apc.Code2D.impl.GameImpl#getGameObjects <em>Game Objects</em>}</li>
 *   <li>{@link nl.utwente.apc.Code2D.impl.GameImpl#getGameWorld <em>Game World</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GameImpl extends EObjectImpl implements Game
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
   * The cached value of the '{@link #getGameObjects() <em>Game Objects</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGameObjects()
   * @generated
   * @ordered
   */
  protected EList<GameObject> gameObjects;

  /**
   * The cached value of the '{@link #getGameWorld() <em>Game World</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGameWorld()
   * @generated
   * @ordered
   */
  protected World gameWorld;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected GameImpl()
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
    return Code2DPackage.Literals.GAME;
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
      eNotify(new ENotificationImpl(this, Notification.SET, Code2DPackage.GAME__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public World getGameWorld()
  {
    return gameWorld;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetGameWorld(World newGameWorld, NotificationChain msgs)
  {
    World oldGameWorld = gameWorld;
    gameWorld = newGameWorld;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Code2DPackage.GAME__GAME_WORLD, oldGameWorld, newGameWorld);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setGameWorld(World newGameWorld)
  {
    if (newGameWorld != gameWorld)
    {
      NotificationChain msgs = null;
      if (gameWorld != null)
        msgs = ((InternalEObject)gameWorld).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Code2DPackage.GAME__GAME_WORLD, null, msgs);
      if (newGameWorld != null)
        msgs = ((InternalEObject)newGameWorld).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Code2DPackage.GAME__GAME_WORLD, null, msgs);
      msgs = basicSetGameWorld(newGameWorld, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Code2DPackage.GAME__GAME_WORLD, newGameWorld, newGameWorld));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<GameObject> getGameObjects()
  {
    if (gameObjects == null)
    {
      gameObjects = new EObjectContainmentEList<GameObject>(GameObject.class, this, Code2DPackage.GAME__GAME_OBJECTS);
    }
    return gameObjects;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case Code2DPackage.GAME__GAME_OBJECTS:
        return ((InternalEList<?>)getGameObjects()).basicRemove(otherEnd, msgs);
      case Code2DPackage.GAME__GAME_WORLD:
        return basicSetGameWorld(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
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
      case Code2DPackage.GAME__NAME:
        return getName();
      case Code2DPackage.GAME__GAME_OBJECTS:
        return getGameObjects();
      case Code2DPackage.GAME__GAME_WORLD:
        return getGameWorld();
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
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case Code2DPackage.GAME__NAME:
        setName((String)newValue);
        return;
      case Code2DPackage.GAME__GAME_OBJECTS:
        getGameObjects().clear();
        getGameObjects().addAll((Collection<? extends GameObject>)newValue);
        return;
      case Code2DPackage.GAME__GAME_WORLD:
        setGameWorld((World)newValue);
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
      case Code2DPackage.GAME__NAME:
        setName(NAME_EDEFAULT);
        return;
      case Code2DPackage.GAME__GAME_OBJECTS:
        getGameObjects().clear();
        return;
      case Code2DPackage.GAME__GAME_WORLD:
        setGameWorld((World)null);
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
      case Code2DPackage.GAME__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case Code2DPackage.GAME__GAME_OBJECTS:
        return gameObjects != null && !gameObjects.isEmpty();
      case Code2DPackage.GAME__GAME_WORLD:
        return gameWorld != null;
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
    result.append(')');
    return result.toString();
  }

} //GameImpl
