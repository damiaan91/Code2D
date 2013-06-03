/**
 */
package nl.utwente.apc.Code2D;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Game</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link nl.utwente.apc.Code2D.Game#getName <em>Name</em>}</li>
 *   <li>{@link nl.utwente.apc.Code2D.Game#getGameObjects <em>Game Objects</em>}</li>
 *   <li>{@link nl.utwente.apc.Code2D.Game#getGameWorld <em>Game World</em>}</li>
 * </ul>
 * </p>
 *
 * @see nl.utwente.apc.Code2D.Code2DPackage#getGame()
 * @model
 * @generated
 */
public interface Game extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see nl.utwente.apc.Code2D.Code2DPackage#getGame_Name()
   * @model required="true"
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link nl.utwente.apc.Code2D.Game#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Game World</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Game World</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Game World</em>' containment reference.
   * @see #setGameWorld(World)
   * @see nl.utwente.apc.Code2D.Code2DPackage#getGame_GameWorld()
   * @model containment="true" required="true"
   * @generated
   */
  World getGameWorld();

  /**
   * Sets the value of the '{@link nl.utwente.apc.Code2D.Game#getGameWorld <em>Game World</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Game World</em>' containment reference.
   * @see #getGameWorld()
   * @generated
   */
  void setGameWorld(World value);

  /**
   * Returns the value of the '<em><b>Game Objects</b></em>' containment reference list.
   * The list contents are of type {@link nl.utwente.apc.Code2D.GameObject}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Game Objects</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Game Objects</em>' containment reference list.
   * @see nl.utwente.apc.Code2D.Code2DPackage#getGame_GameObjects()
   * @model containment="true"
   * @generated
   */
  EList<GameObject> getGameObjects();

} // Game
