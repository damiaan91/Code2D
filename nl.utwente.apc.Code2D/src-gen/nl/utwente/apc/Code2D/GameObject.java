/**
 */
package nl.utwente.apc.Code2D;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Game Object</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link nl.utwente.apc.Code2D.GameObject#getName <em>Name</em>}</li>
 *   <li>{@link nl.utwente.apc.Code2D.GameObject#getTexture <em>Texture</em>}</li>
 * </ul>
 * </p>
 *
 * @see nl.utwente.apc.Code2D.Code2DPackage#getGameObject()
 * @model abstract="true"
 * @generated
 */
public interface GameObject extends EObject
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
   * @see nl.utwente.apc.Code2D.Code2DPackage#getGameObject_Name()
   * @model required="true"
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link nl.utwente.apc.Code2D.GameObject#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Texture</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Texture</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Texture</em>' attribute.
   * @see #setTexture(String)
   * @see nl.utwente.apc.Code2D.Code2DPackage#getGameObject_Texture()
   * @model
   * @generated
   */
  String getTexture();

  /**
   * Sets the value of the '{@link nl.utwente.apc.Code2D.GameObject#getTexture <em>Texture</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Texture</em>' attribute.
   * @see #getTexture()
   * @generated
   */
  void setTexture(String value);

} // GameObject
