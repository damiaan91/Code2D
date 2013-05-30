/**
 */
package nl.utwente.apc.Code2D;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Feature</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link nl.utwente.apc.Code2D.Feature#getKind <em>Kind</em>}</li>
 *   <li>{@link nl.utwente.apc.Code2D.Feature#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see nl.utwente.apc.Code2D.Code2DPackage#getFeature()
 * @model
 * @generated
 */
public interface Feature extends NamedElement
{
  /**
   * Returns the value of the '<em><b>Kind</b></em>' attribute.
   * The literals are from the enumeration {@link nl.utwente.apc.Code2D.FeatureKind}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Kind</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Kind</em>' attribute.
   * @see nl.utwente.apc.Code2D.FeatureKind
   * @see #setKind(FeatureKind)
   * @see nl.utwente.apc.Code2D.Code2DPackage#getFeature_Kind()
   * @model required="true"
   * @generated
   */
  FeatureKind getKind();

  /**
   * Sets the value of the '{@link nl.utwente.apc.Code2D.Feature#getKind <em>Kind</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Kind</em>' attribute.
   * @see nl.utwente.apc.Code2D.FeatureKind
   * @see #getKind()
   * @generated
   */
  void setKind(FeatureKind value);

  /**
   * Returns the value of the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' reference.
   * @see #setType(Type)
   * @see nl.utwente.apc.Code2D.Code2DPackage#getFeature_Type()
   * @model required="true"
   * @generated
   */
  Type getType();

  /**
   * Sets the value of the '{@link nl.utwente.apc.Code2D.Feature#getType <em>Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' reference.
   * @see #getType()
   * @generated
   */
  void setType(Type value);

} // Feature
