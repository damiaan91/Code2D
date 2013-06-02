/**
 */
package nl.utwente.apc.Code2D.util;

import nl.utwente.apc.Code2D.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see nl.utwente.apc.Code2D.Code2DPackage
 * @generated
 */
public class Code2DSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static Code2DPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Code2DSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = Code2DPackage.eINSTANCE;
    }
  }

  /**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @parameter ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
  @Override
  protected boolean isSwitchFor(EPackage ePackage)
  {
    return ePackage == modelPackage;
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  @Override
  protected T doSwitch(int classifierID, EObject theEObject)
  {
    switch (classifierID)
    {
      case Code2DPackage.GAME:
      {
        Game game = (Game)theEObject;
        T result = caseGame(game);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Code2DPackage.WORLD:
      {
        World world = (World)theEObject;
        T result = caseWorld(world);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Code2DPackage.GAME_OBJECT:
      {
        GameObject gameObject = (GameObject)theEObject;
        T result = caseGameObject(gameObject);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Code2DPackage.MOVEABLE_OBJECT:
      {
        MoveableObject moveableObject = (MoveableObject)theEObject;
        T result = caseMoveableObject(moveableObject);
        if (result == null) result = caseGameObject(moveableObject);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Code2DPackage.CONTROLLABLE_OBJECT:
      {
        ControllableObject controllableObject = (ControllableObject)theEObject;
        T result = caseControllableObject(controllableObject);
        if (result == null) result = caseMoveableObject(controllableObject);
        if (result == null) result = caseGameObject(controllableObject);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Code2DPackage.PLAYER:
      {
        Player player = (Player)theEObject;
        T result = casePlayer(player);
        if (result == null) result = caseControllableObject(player);
        if (result == null) result = caseMoveableObject(player);
        if (result == null) result = caseGameObject(player);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Code2DPackage.NPC:
      {
        NPC npc = (NPC)theEObject;
        T result = caseNPC(npc);
        if (result == null) result = caseMoveableObject(npc);
        if (result == null) result = caseGameObject(npc);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Code2DPackage.ITEM:
      {
        Item item = (Item)theEObject;
        T result = caseItem(item);
        if (result == null) result = caseGameObject(item);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Game</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Game</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseGame(Game object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>World</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>World</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseWorld(World object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Game Object</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Game Object</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseGameObject(GameObject object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Moveable Object</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Moveable Object</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMoveableObject(MoveableObject object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Controllable Object</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Controllable Object</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseControllableObject(ControllableObject object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Player</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Player</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePlayer(Player object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>NPC</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>NPC</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNPC(NPC object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Item</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Item</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseItem(Item object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  @Override
  public T defaultCase(EObject object)
  {
    return null;
  }

} //Code2DSwitch
