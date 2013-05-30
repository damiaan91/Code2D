/**
 */
package nl.utwente.apc.Code2D;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Entity Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link nl.utwente.apc.Code2D.EntityModel#getTypes <em>Types</em>}</li>
 * </ul>
 * </p>
 *
 * @see nl.utwente.apc.Code2D.Code2DPackage#getEntityModel()
 * @model
 * @generated
 */
public interface EntityModel extends EObject
{
  /**
   * Returns the value of the '<em><b>Types</b></em>' containment reference list.
   * The list contents are of type {@link nl.utwente.apc.Code2D.Type}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Types</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Types</em>' containment reference list.
   * @see nl.utwente.apc.Code2D.Code2DPackage#getEntityModel_Types()
   * @model containment="true"
   * @generated
   */
  EList<Type> getTypes();

} // EntityModel
