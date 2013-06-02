/**
 */
package nl.utwente.apc.Code2D;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see nl.utwente.apc.Code2D.Code2DFactory
 * @model kind="package"
 * @generated
 */
public interface Code2DPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "Code2D";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.utwente.nl/apc/Code2D";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "Code2D";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  Code2DPackage eINSTANCE = nl.utwente.apc.Code2D.impl.Code2DPackageImpl.init();

  /**
   * The meta object id for the '{@link nl.utwente.apc.Code2D.impl.GameImpl <em>Game</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see nl.utwente.apc.Code2D.impl.GameImpl
   * @see nl.utwente.apc.Code2D.impl.Code2DPackageImpl#getGame()
   * @generated
   */
  int GAME = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GAME__NAME = 0;

  /**
   * The feature id for the '<em><b>Game World</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GAME__GAME_WORLD = 1;

  /**
   * The feature id for the '<em><b>Game Objects</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GAME__GAME_OBJECTS = 2;

  /**
   * The number of structural features of the '<em>Game</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GAME_FEATURE_COUNT = 3;


  /**
   * The meta object id for the '{@link nl.utwente.apc.Code2D.impl.WorldImpl <em>World</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see nl.utwente.apc.Code2D.impl.WorldImpl
   * @see nl.utwente.apc.Code2D.impl.Code2DPackageImpl#getWorld()
   * @generated
   */
  int WORLD = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WORLD__NAME = 0;

  /**
   * The number of structural features of the '<em>World</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WORLD_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link nl.utwente.apc.Code2D.impl.GameObjectImpl <em>Game Object</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see nl.utwente.apc.Code2D.impl.GameObjectImpl
   * @see nl.utwente.apc.Code2D.impl.Code2DPackageImpl#getGameObject()
   * @generated
   */
  int GAME_OBJECT = 2;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GAME_OBJECT__NAME = 0;

  /**
   * The feature id for the '<em><b>Texture</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GAME_OBJECT__TEXTURE = 1;

  /**
   * The number of structural features of the '<em>Game Object</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GAME_OBJECT_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link nl.utwente.apc.Code2D.impl.MoveableObjectImpl <em>Moveable Object</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see nl.utwente.apc.Code2D.impl.MoveableObjectImpl
   * @see nl.utwente.apc.Code2D.impl.Code2DPackageImpl#getMoveableObject()
   * @generated
   */
  int MOVEABLE_OBJECT = 3;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MOVEABLE_OBJECT__NAME = GAME_OBJECT__NAME;

  /**
   * The feature id for the '<em><b>Texture</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MOVEABLE_OBJECT__TEXTURE = GAME_OBJECT__TEXTURE;

  /**
   * The number of structural features of the '<em>Moveable Object</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MOVEABLE_OBJECT_FEATURE_COUNT = GAME_OBJECT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link nl.utwente.apc.Code2D.impl.ControllableObjectImpl <em>Controllable Object</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see nl.utwente.apc.Code2D.impl.ControllableObjectImpl
   * @see nl.utwente.apc.Code2D.impl.Code2DPackageImpl#getControllableObject()
   * @generated
   */
  int CONTROLLABLE_OBJECT = 4;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTROLLABLE_OBJECT__NAME = MOVEABLE_OBJECT__NAME;

  /**
   * The feature id for the '<em><b>Texture</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTROLLABLE_OBJECT__TEXTURE = MOVEABLE_OBJECT__TEXTURE;

  /**
   * The number of structural features of the '<em>Controllable Object</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTROLLABLE_OBJECT_FEATURE_COUNT = MOVEABLE_OBJECT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link nl.utwente.apc.Code2D.impl.PlayerImpl <em>Player</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see nl.utwente.apc.Code2D.impl.PlayerImpl
   * @see nl.utwente.apc.Code2D.impl.Code2DPackageImpl#getPlayer()
   * @generated
   */
  int PLAYER = 5;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLAYER__NAME = CONTROLLABLE_OBJECT__NAME;

  /**
   * The feature id for the '<em><b>Texture</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLAYER__TEXTURE = CONTROLLABLE_OBJECT__TEXTURE;

  /**
   * The number of structural features of the '<em>Player</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLAYER_FEATURE_COUNT = CONTROLLABLE_OBJECT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link nl.utwente.apc.Code2D.impl.NPCImpl <em>NPC</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see nl.utwente.apc.Code2D.impl.NPCImpl
   * @see nl.utwente.apc.Code2D.impl.Code2DPackageImpl#getNPC()
   * @generated
   */
  int NPC = 6;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NPC__NAME = MOVEABLE_OBJECT__NAME;

  /**
   * The feature id for the '<em><b>Texture</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NPC__TEXTURE = MOVEABLE_OBJECT__TEXTURE;

  /**
   * The feature id for the '<em><b>Behaviour</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NPC__BEHAVIOUR = MOVEABLE_OBJECT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Extends</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NPC__EXTENDS = MOVEABLE_OBJECT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>NPC</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NPC_FEATURE_COUNT = MOVEABLE_OBJECT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link nl.utwente.apc.Code2D.impl.ItemImpl <em>Item</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see nl.utwente.apc.Code2D.impl.ItemImpl
   * @see nl.utwente.apc.Code2D.impl.Code2DPackageImpl#getItem()
   * @generated
   */
  int ITEM = 7;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ITEM__NAME = GAME_OBJECT__NAME;

  /**
   * The feature id for the '<em><b>Texture</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ITEM__TEXTURE = GAME_OBJECT__TEXTURE;

  /**
   * The number of structural features of the '<em>Item</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ITEM_FEATURE_COUNT = GAME_OBJECT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link nl.utwente.apc.Code2D.NPCBehaviour <em>NPC Behaviour</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see nl.utwente.apc.Code2D.NPCBehaviour
   * @see nl.utwente.apc.Code2D.impl.Code2DPackageImpl#getNPCBehaviour()
   * @generated
   */
  int NPC_BEHAVIOUR = 8;


  /**
   * Returns the meta object for class '{@link nl.utwente.apc.Code2D.Game <em>Game</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Game</em>'.
   * @see nl.utwente.apc.Code2D.Game
   * @generated
   */
  EClass getGame();

  /**
   * Returns the meta object for the attribute '{@link nl.utwente.apc.Code2D.Game#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see nl.utwente.apc.Code2D.Game#getName()
   * @see #getGame()
   * @generated
   */
  EAttribute getGame_Name();

  /**
   * Returns the meta object for the containment reference '{@link nl.utwente.apc.Code2D.Game#getGameWorld <em>Game World</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Game World</em>'.
   * @see nl.utwente.apc.Code2D.Game#getGameWorld()
   * @see #getGame()
   * @generated
   */
  EReference getGame_GameWorld();

  /**
   * Returns the meta object for the containment reference list '{@link nl.utwente.apc.Code2D.Game#getGameObjects <em>Game Objects</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Game Objects</em>'.
   * @see nl.utwente.apc.Code2D.Game#getGameObjects()
   * @see #getGame()
   * @generated
   */
  EReference getGame_GameObjects();

  /**
   * Returns the meta object for class '{@link nl.utwente.apc.Code2D.World <em>World</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>World</em>'.
   * @see nl.utwente.apc.Code2D.World
   * @generated
   */
  EClass getWorld();

  /**
   * Returns the meta object for the attribute '{@link nl.utwente.apc.Code2D.World#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see nl.utwente.apc.Code2D.World#getName()
   * @see #getWorld()
   * @generated
   */
  EAttribute getWorld_Name();

  /**
   * Returns the meta object for class '{@link nl.utwente.apc.Code2D.GameObject <em>Game Object</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Game Object</em>'.
   * @see nl.utwente.apc.Code2D.GameObject
   * @generated
   */
  EClass getGameObject();

  /**
   * Returns the meta object for the attribute '{@link nl.utwente.apc.Code2D.GameObject#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see nl.utwente.apc.Code2D.GameObject#getName()
   * @see #getGameObject()
   * @generated
   */
  EAttribute getGameObject_Name();

  /**
   * Returns the meta object for the attribute '{@link nl.utwente.apc.Code2D.GameObject#getTexture <em>Texture</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Texture</em>'.
   * @see nl.utwente.apc.Code2D.GameObject#getTexture()
   * @see #getGameObject()
   * @generated
   */
  EAttribute getGameObject_Texture();

  /**
   * Returns the meta object for class '{@link nl.utwente.apc.Code2D.MoveableObject <em>Moveable Object</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Moveable Object</em>'.
   * @see nl.utwente.apc.Code2D.MoveableObject
   * @generated
   */
  EClass getMoveableObject();

  /**
   * Returns the meta object for class '{@link nl.utwente.apc.Code2D.ControllableObject <em>Controllable Object</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Controllable Object</em>'.
   * @see nl.utwente.apc.Code2D.ControllableObject
   * @generated
   */
  EClass getControllableObject();

  /**
   * Returns the meta object for class '{@link nl.utwente.apc.Code2D.Player <em>Player</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Player</em>'.
   * @see nl.utwente.apc.Code2D.Player
   * @generated
   */
  EClass getPlayer();

  /**
   * Returns the meta object for class '{@link nl.utwente.apc.Code2D.NPC <em>NPC</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>NPC</em>'.
   * @see nl.utwente.apc.Code2D.NPC
   * @generated
   */
  EClass getNPC();

  /**
   * Returns the meta object for the attribute '{@link nl.utwente.apc.Code2D.NPC#getBehaviour <em>Behaviour</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Behaviour</em>'.
   * @see nl.utwente.apc.Code2D.NPC#getBehaviour()
   * @see #getNPC()
   * @generated
   */
  EAttribute getNPC_Behaviour();

  /**
   * Returns the meta object for the reference '{@link nl.utwente.apc.Code2D.NPC#getExtends <em>Extends</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Extends</em>'.
   * @see nl.utwente.apc.Code2D.NPC#getExtends()
   * @see #getNPC()
   * @generated
   */
  EReference getNPC_Extends();

  /**
   * Returns the meta object for class '{@link nl.utwente.apc.Code2D.Item <em>Item</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Item</em>'.
   * @see nl.utwente.apc.Code2D.Item
   * @generated
   */
  EClass getItem();

  /**
   * Returns the meta object for enum '{@link nl.utwente.apc.Code2D.NPCBehaviour <em>NPC Behaviour</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>NPC Behaviour</em>'.
   * @see nl.utwente.apc.Code2D.NPCBehaviour
   * @generated
   */
  EEnum getNPCBehaviour();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  Code2DFactory getCode2DFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link nl.utwente.apc.Code2D.impl.GameImpl <em>Game</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see nl.utwente.apc.Code2D.impl.GameImpl
     * @see nl.utwente.apc.Code2D.impl.Code2DPackageImpl#getGame()
     * @generated
     */
    EClass GAME = eINSTANCE.getGame();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute GAME__NAME = eINSTANCE.getGame_Name();

    /**
     * The meta object literal for the '<em><b>Game World</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference GAME__GAME_WORLD = eINSTANCE.getGame_GameWorld();

    /**
     * The meta object literal for the '<em><b>Game Objects</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference GAME__GAME_OBJECTS = eINSTANCE.getGame_GameObjects();

    /**
     * The meta object literal for the '{@link nl.utwente.apc.Code2D.impl.WorldImpl <em>World</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see nl.utwente.apc.Code2D.impl.WorldImpl
     * @see nl.utwente.apc.Code2D.impl.Code2DPackageImpl#getWorld()
     * @generated
     */
    EClass WORLD = eINSTANCE.getWorld();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute WORLD__NAME = eINSTANCE.getWorld_Name();

    /**
     * The meta object literal for the '{@link nl.utwente.apc.Code2D.impl.GameObjectImpl <em>Game Object</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see nl.utwente.apc.Code2D.impl.GameObjectImpl
     * @see nl.utwente.apc.Code2D.impl.Code2DPackageImpl#getGameObject()
     * @generated
     */
    EClass GAME_OBJECT = eINSTANCE.getGameObject();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute GAME_OBJECT__NAME = eINSTANCE.getGameObject_Name();

    /**
     * The meta object literal for the '<em><b>Texture</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute GAME_OBJECT__TEXTURE = eINSTANCE.getGameObject_Texture();

    /**
     * The meta object literal for the '{@link nl.utwente.apc.Code2D.impl.MoveableObjectImpl <em>Moveable Object</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see nl.utwente.apc.Code2D.impl.MoveableObjectImpl
     * @see nl.utwente.apc.Code2D.impl.Code2DPackageImpl#getMoveableObject()
     * @generated
     */
    EClass MOVEABLE_OBJECT = eINSTANCE.getMoveableObject();

    /**
     * The meta object literal for the '{@link nl.utwente.apc.Code2D.impl.ControllableObjectImpl <em>Controllable Object</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see nl.utwente.apc.Code2D.impl.ControllableObjectImpl
     * @see nl.utwente.apc.Code2D.impl.Code2DPackageImpl#getControllableObject()
     * @generated
     */
    EClass CONTROLLABLE_OBJECT = eINSTANCE.getControllableObject();

    /**
     * The meta object literal for the '{@link nl.utwente.apc.Code2D.impl.PlayerImpl <em>Player</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see nl.utwente.apc.Code2D.impl.PlayerImpl
     * @see nl.utwente.apc.Code2D.impl.Code2DPackageImpl#getPlayer()
     * @generated
     */
    EClass PLAYER = eINSTANCE.getPlayer();

    /**
     * The meta object literal for the '{@link nl.utwente.apc.Code2D.impl.NPCImpl <em>NPC</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see nl.utwente.apc.Code2D.impl.NPCImpl
     * @see nl.utwente.apc.Code2D.impl.Code2DPackageImpl#getNPC()
     * @generated
     */
    EClass NPC = eINSTANCE.getNPC();

    /**
     * The meta object literal for the '<em><b>Behaviour</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute NPC__BEHAVIOUR = eINSTANCE.getNPC_Behaviour();

    /**
     * The meta object literal for the '<em><b>Extends</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NPC__EXTENDS = eINSTANCE.getNPC_Extends();

    /**
     * The meta object literal for the '{@link nl.utwente.apc.Code2D.impl.ItemImpl <em>Item</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see nl.utwente.apc.Code2D.impl.ItemImpl
     * @see nl.utwente.apc.Code2D.impl.Code2DPackageImpl#getItem()
     * @generated
     */
    EClass ITEM = eINSTANCE.getItem();

    /**
     * The meta object literal for the '{@link nl.utwente.apc.Code2D.NPCBehaviour <em>NPC Behaviour</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see nl.utwente.apc.Code2D.NPCBehaviour
     * @see nl.utwente.apc.Code2D.impl.Code2DPackageImpl#getNPCBehaviour()
     * @generated
     */
    EEnum NPC_BEHAVIOUR = eINSTANCE.getNPCBehaviour();

  }

} //Code2DPackage
