/**
 */
package nl.utwente.apc.Code2D.util;

import nl.utwente.apc.Code2D.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see nl.utwente.apc.Code2D.Code2DPackage
 * @generated
 */
public class Code2DAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static Code2DPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Code2DAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = Code2DPackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object)
  {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Code2DSwitch<Adapter> modelSwitch =
    new Code2DSwitch<Adapter>()
    {
      @Override
      public Adapter caseGame(Game object)
      {
        return createGameAdapter();
      }
      @Override
      public Adapter caseGameObject(GameObject object)
      {
        return createGameObjectAdapter();
      }
      @Override
      public Adapter caseMoveableObject(MoveableObject object)
      {
        return createMoveableObjectAdapter();
      }
      @Override
      public Adapter caseControllableObject(ControllableObject object)
      {
        return createControllableObjectAdapter();
      }
      @Override
      public Adapter casePlayer(Player object)
      {
        return createPlayerAdapter();
      }
      @Override
      public Adapter caseNPC(NPC object)
      {
        return createNPCAdapter();
      }
      @Override
      public Adapter caseItem(Item object)
      {
        return createItemAdapter();
      }
      @Override
      public Adapter caseWorld(World object)
      {
        return createWorldAdapter();
      }
      @Override
      public Adapter caseTerrain(Terrain object)
      {
        return createTerrainAdapter();
      }
      @Override
      public Adapter caseTrap(Trap object)
      {
        return createTrapAdapter();
      }
      @Override
      public Adapter caseScenery(Scenery object)
      {
        return createSceneryAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target)
  {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link nl.utwente.apc.Code2D.Game <em>Game</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see nl.utwente.apc.Code2D.Game
   * @generated
   */
  public Adapter createGameAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link nl.utwente.apc.Code2D.World <em>World</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see nl.utwente.apc.Code2D.World
   * @generated
   */
  public Adapter createWorldAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link nl.utwente.apc.Code2D.Terrain <em>Terrain</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see nl.utwente.apc.Code2D.Terrain
   * @generated
   */
  public Adapter createTerrainAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link nl.utwente.apc.Code2D.Trap <em>Trap</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see nl.utwente.apc.Code2D.Trap
   * @generated
   */
  public Adapter createTrapAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link nl.utwente.apc.Code2D.Scenery <em>Scenery</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see nl.utwente.apc.Code2D.Scenery
   * @generated
   */
  public Adapter createSceneryAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link nl.utwente.apc.Code2D.GameObject <em>Game Object</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see nl.utwente.apc.Code2D.GameObject
   * @generated
   */
  public Adapter createGameObjectAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link nl.utwente.apc.Code2D.MoveableObject <em>Moveable Object</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see nl.utwente.apc.Code2D.MoveableObject
   * @generated
   */
  public Adapter createMoveableObjectAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link nl.utwente.apc.Code2D.ControllableObject <em>Controllable Object</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see nl.utwente.apc.Code2D.ControllableObject
   * @generated
   */
  public Adapter createControllableObjectAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link nl.utwente.apc.Code2D.Player <em>Player</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see nl.utwente.apc.Code2D.Player
   * @generated
   */
  public Adapter createPlayerAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link nl.utwente.apc.Code2D.NPC <em>NPC</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see nl.utwente.apc.Code2D.NPC
   * @generated
   */
  public Adapter createNPCAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link nl.utwente.apc.Code2D.Item <em>Item</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see nl.utwente.apc.Code2D.Item
   * @generated
   */
  public Adapter createItemAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter()
  {
    return null;
  }

} //Code2DAdapterFactory
