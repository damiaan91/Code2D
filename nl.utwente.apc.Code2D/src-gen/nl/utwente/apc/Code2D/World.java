/**
 */
package nl.utwente.apc.Code2D;

import java.util.Map;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>World</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link nl.utwente.apc.Code2D.World#getName <em>Name</em>}</li>
 *   <li>{@link nl.utwente.apc.Code2D.World#getTerrain <em>Terrain</em>}</li>
 *   <li>{@link nl.utwente.apc.Code2D.World#getWorldBlocks <em>World Blocks</em>}</li>
 * </ul>
 * </p>
 *
 * @see nl.utwente.apc.Code2D.Code2DPackage#getWorld()
 * @model
 * @generated
 */
public interface World extends EObject
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
   * @see nl.utwente.apc.Code2D.Code2DPackage#getWorld_Name()
   * @model required="true"
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link nl.utwente.apc.Code2D.World#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Terrain</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Terrain</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Terrain</em>' attribute.
   * @see #setTerrain(String)
   * @see nl.utwente.apc.Code2D.Code2DPackage#getWorld_Terrain()
   * @model
   * @generated
   */
  String getTerrain();

  /**
   * Sets the value of the '{@link nl.utwente.apc.Code2D.World#getTerrain <em>Terrain</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Terrain</em>' attribute.
   * @see #getTerrain()
   * @generated
   */
  void setTerrain(String value);

  /**
   * Returns the value of the '<em><b>World Blocks</b></em>' containment reference list.
   * The list contents are of type {@link nl.utwente.apc.Code2D.Terrain}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>World Blocks</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>World Blocks</em>' containment reference list.
   * @see nl.utwente.apc.Code2D.Code2DPackage#getWorld_WorldBlocks()
   * @model containment="true" required="true"
   * @generated
   */
  EList<Terrain> getWorldBlocks();
} // World
