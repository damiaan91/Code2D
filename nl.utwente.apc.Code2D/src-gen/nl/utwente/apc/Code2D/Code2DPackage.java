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
   * The number of structural features of the '<em>Game</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GAME_FEATURE_COUNT = 1;


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

  }

} //Code2DPackage
