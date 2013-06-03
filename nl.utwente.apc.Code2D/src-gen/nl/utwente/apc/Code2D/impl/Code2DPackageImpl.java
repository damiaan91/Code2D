/**
 */
package nl.utwente.apc.Code2D.impl;

import nl.utwente.apc.Code2D.Code2DFactory;
import nl.utwente.apc.Code2D.Code2DPackage;
import nl.utwente.apc.Code2D.ControllableObject;
import nl.utwente.apc.Code2D.Game;

import nl.utwente.apc.Code2D.GameObject;
import nl.utwente.apc.Code2D.Item;
import nl.utwente.apc.Code2D.MoveableObject;
import nl.utwente.apc.Code2D.NPCBehaviour;
import nl.utwente.apc.Code2D.Player;
import nl.utwente.apc.Code2D.Scenery;
import nl.utwente.apc.Code2D.Terrain;
import nl.utwente.apc.Code2D.Trap;
import nl.utwente.apc.Code2D.World;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Code2DPackageImpl extends EPackageImpl implements Code2DPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass gameEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass worldEClass = null;
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass terrainEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass trapEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass sceneryEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass gameObjectEClass = null;
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass moveableObjectEClass = null;
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass controllableObjectEClass = null;
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass playerEClass = null;
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass npcEClass = null;
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass itemEClass = null;
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum npcBehaviourEEnum = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see nl.utwente.apc.Code2D.Code2DPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private Code2DPackageImpl()
  {
    super(eNS_URI, Code2DFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   * 
   * <p>This method is used to initialize {@link Code2DPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static Code2DPackage init()
  {
    if (isInited) return (Code2DPackage)EPackage.Registry.INSTANCE.getEPackage(Code2DPackage.eNS_URI);

    // Obtain or create and register package
    Code2DPackageImpl theCode2DPackage = (Code2DPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof Code2DPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new Code2DPackageImpl());

    isInited = true;

    // Create package meta-data objects
    theCode2DPackage.createPackageContents();

    // Initialize created meta-data
    theCode2DPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theCode2DPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(Code2DPackage.eNS_URI, theCode2DPackage);
    return theCode2DPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getGame()
  {
    return gameEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getGame_Name()
  {
    return (EAttribute)gameEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getGame_GameWorld()
  {
    return (EReference)gameEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getGame_GameObjects()
  {
    return (EReference)gameEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getWorld()
  {
    return worldEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getWorld_Name()
  {
    return (EAttribute)worldEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getWorld_Terrain()
  {
    return (EAttribute)worldEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getWorld_WorldBlocks()
  {
    return (EReference)worldEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTerrain()
  {
    return terrainEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTerrain_CanStand()
  {
    return (EAttribute)terrainEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTerrain_CanHaveItem()
  {
    return (EAttribute)terrainEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTrap()
  {
    return trapEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getScenery()
  {
    return sceneryEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getGameObject()
  {
    return gameObjectEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getGameObject_Name()
  {
    return (EAttribute)gameObjectEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getGameObject_Texture()
  {
    return (EAttribute)gameObjectEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMoveableObject()
  {
    return moveableObjectEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getControllableObject()
  {
    return controllableObjectEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPlayer()
  {
    return playerEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNPC()
  {
    return npcEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getNPC_Behaviour()
  {
    return (EAttribute)npcEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNPC_Extends()
  {
    return (EReference)npcEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getItem()
  {
    return itemEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getNPCBehaviour()
  {
    return npcBehaviourEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Code2DFactory getCode2DFactory()
  {
    return (Code2DFactory)getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void createPackageContents()
  {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    gameEClass = createEClass(GAME);
    createEAttribute(gameEClass, GAME__NAME);
    createEReference(gameEClass, GAME__GAME_OBJECTS);
    createEReference(gameEClass, GAME__GAME_WORLD);

    gameObjectEClass = createEClass(GAME_OBJECT);
    createEAttribute(gameObjectEClass, GAME_OBJECT__NAME);
    createEAttribute(gameObjectEClass, GAME_OBJECT__TEXTURE);

    moveableObjectEClass = createEClass(MOVEABLE_OBJECT);

    controllableObjectEClass = createEClass(CONTROLLABLE_OBJECT);

    playerEClass = createEClass(PLAYER);

    npcEClass = createEClass(NPC);
    createEAttribute(npcEClass, NPC__BEHAVIOUR);
    createEReference(npcEClass, NPC__EXTENDS);

    itemEClass = createEClass(ITEM);

    worldEClass = createEClass(WORLD);
    createEAttribute(worldEClass, WORLD__NAME);
    createEAttribute(worldEClass, WORLD__TERRAIN);
    createEReference(worldEClass, WORLD__WORLD_BLOCKS);

    terrainEClass = createEClass(TERRAIN);
    createEAttribute(terrainEClass, TERRAIN__CAN_STAND);
    createEAttribute(terrainEClass, TERRAIN__CAN_HAVE_ITEM);

    trapEClass = createEClass(TRAP);

    sceneryEClass = createEClass(SCENERY);

    // Create enums
    npcBehaviourEEnum = createEEnum(NPC_BEHAVIOUR);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void initializePackageContents()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    moveableObjectEClass.getESuperTypes().add(this.getGameObject());
    controllableObjectEClass.getESuperTypes().add(this.getMoveableObject());
    playerEClass.getESuperTypes().add(this.getControllableObject());
    npcEClass.getESuperTypes().add(this.getMoveableObject());
    itemEClass.getESuperTypes().add(this.getGameObject());
    trapEClass.getESuperTypes().add(this.getGameObject());
    sceneryEClass.getESuperTypes().add(this.getGameObject());

    // Initialize classes and features; add operations and parameters
    initEClass(gameEClass, Game.class, "Game", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getGame_Name(), ecorePackage.getEString(), "Name", null, 1, 1, Game.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getGame_GameObjects(), this.getGameObject(), null, "GameObjects", null, 0, -1, Game.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getGame_GameWorld(), this.getWorld(), null, "GameWorld", null, 1, 1, Game.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(gameObjectEClass, GameObject.class, "GameObject", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getGameObject_Name(), ecorePackage.getEString(), "Name", null, 1, 1, GameObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getGameObject_Texture(), ecorePackage.getEString(), "Texture", null, 0, 1, GameObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(moveableObjectEClass, MoveableObject.class, "MoveableObject", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(controllableObjectEClass, ControllableObject.class, "ControllableObject", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(playerEClass, Player.class, "Player", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(npcEClass, nl.utwente.apc.Code2D.NPC.class, "NPC", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getNPC_Behaviour(), this.getNPCBehaviour(), "Behaviour", null, 0, 1, nl.utwente.apc.Code2D.NPC.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getNPC_Extends(), this.getNPC(), null, "Extends", null, 0, 1, nl.utwente.apc.Code2D.NPC.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(itemEClass, Item.class, "Item", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(worldEClass, World.class, "World", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getWorld_Name(), ecorePackage.getEString(), "Name", null, 1, 1, World.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getWorld_Terrain(), ecorePackage.getEString(), "Terrain", null, 0, 1, World.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getWorld_WorldBlocks(), this.getTerrain(), null, "WorldBlocks", null, 1, -1, World.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(terrainEClass, Terrain.class, "Terrain", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTerrain_CanStand(), ecorePackage.getEBoolean(), "CanStand", null, 0, 1, Terrain.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTerrain_CanHaveItem(), ecorePackage.getEBoolean(), "CanHaveItem", null, 0, 1, Terrain.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(trapEClass, Trap.class, "Trap", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(sceneryEClass, Scenery.class, "Scenery", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    // Initialize enums and add enum literals
    initEEnum(npcBehaviourEEnum, NPCBehaviour.class, "NPCBehaviour");
    addEEnumLiteral(npcBehaviourEEnum, NPCBehaviour.FRIENDLY);
    addEEnumLiteral(npcBehaviourEEnum, NPCBehaviour.NEUTRAL);
    addEEnumLiteral(npcBehaviourEEnum, NPCBehaviour.HOSTILE);

    // Create resource
    createResource(eNS_URI);
  }

} //Code2DPackageImpl
