/**
 */
package nl.utwente.apc.Code2D.impl;

import java.util.Collection;
import java.util.Map;
import nl.utwente.apc.Code2D.Code2DPackage;
import nl.utwente.apc.Code2D.Terrain;
import nl.utwente.apc.Code2D.World;

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
 * An implementation of the model object '<em><b>World</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link nl.utwente.apc.Code2D.impl.WorldImpl#getName <em>Name</em>}</li>
 *   <li>{@link nl.utwente.apc.Code2D.impl.WorldImpl#getTerrain <em>Terrain</em>}</li>
 *   <li>{@link nl.utwente.apc.Code2D.impl.WorldImpl#getWorldBlocks <em>World Blocks</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WorldImpl extends EObjectImpl implements World
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
   * The default value of the '{@link #getTerrain() <em>Terrain</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTerrain()
   * @generated
   * @ordered
   */
  protected static final String TERRAIN_EDEFAULT = null;
  /**
   * The cached value of the '{@link #getTerrain() <em>Terrain</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTerrain()
   * @generated
   * @ordered
   */
  protected String terrain = TERRAIN_EDEFAULT;
  /**
   * The cached value of the '{@link #getWorldBlocks() <em>World Blocks</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getWorldBlocks()
   * @generated
   * @ordered
   */
  protected EList<Terrain> worldBlocks;
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected WorldImpl()
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
    return Code2DPackage.Literals.WORLD;
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
      eNotify(new ENotificationImpl(this, Notification.SET, Code2DPackage.WORLD__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getTerrain()
  {
    return terrain;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTerrain(String newTerrain)
  {
    String oldTerrain = terrain;
    terrain = newTerrain;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Code2DPackage.WORLD__TERRAIN, oldTerrain, terrain));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Terrain> getWorldBlocks()
  {
    if (worldBlocks == null)
    {
      worldBlocks = new EObjectContainmentEList<Terrain>(Terrain.class, this, Code2DPackage.WORLD__WORLD_BLOCKS);
    }
    return worldBlocks;
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
      case Code2DPackage.WORLD__WORLD_BLOCKS:
        return ((InternalEList<?>)getWorldBlocks()).basicRemove(otherEnd, msgs);
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
      case Code2DPackage.WORLD__NAME:
        return getName();
      case Code2DPackage.WORLD__TERRAIN:
        return getTerrain();
      case Code2DPackage.WORLD__WORLD_BLOCKS:
        return getWorldBlocks();
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
      case Code2DPackage.WORLD__NAME:
        setName((String)newValue);
        return;
      case Code2DPackage.WORLD__TERRAIN:
        setTerrain((String)newValue);
        return;
      case Code2DPackage.WORLD__WORLD_BLOCKS:
        getWorldBlocks().clear();
        getWorldBlocks().addAll((Collection<? extends Terrain>)newValue);
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
      case Code2DPackage.WORLD__NAME:
        setName(NAME_EDEFAULT);
        return;
      case Code2DPackage.WORLD__TERRAIN:
        setTerrain(TERRAIN_EDEFAULT);
        return;
      case Code2DPackage.WORLD__WORLD_BLOCKS:
        getWorldBlocks().clear();
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
      case Code2DPackage.WORLD__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case Code2DPackage.WORLD__TERRAIN:
        return TERRAIN_EDEFAULT == null ? terrain != null : !TERRAIN_EDEFAULT.equals(terrain);
      case Code2DPackage.WORLD__WORLD_BLOCKS:
        return worldBlocks != null && !worldBlocks.isEmpty();
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
    result.append(", Terrain: ");
    result.append(terrain);
    result.append(')');
    return result.toString();
  }

} //WorldImpl
