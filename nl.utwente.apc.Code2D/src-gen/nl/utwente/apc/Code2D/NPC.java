/**
 */
package nl.utwente.apc.Code2D;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>NPC</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link nl.utwente.apc.Code2D.NPC#getBehaviour <em>Behaviour</em>}</li>
 *   <li>{@link nl.utwente.apc.Code2D.NPC#getExtends <em>Extends</em>}</li>
 * </ul>
 * </p>
 *
 * @see nl.utwente.apc.Code2D.Code2DPackage#getNPC()
 * @model
 * @generated
 */
public interface NPC extends MoveableObject
{
  /**
   * Returns the value of the '<em><b>Behaviour</b></em>' attribute.
   * The literals are from the enumeration {@link nl.utwente.apc.Code2D.NPCBehaviour}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Behaviour</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Behaviour</em>' attribute.
   * @see nl.utwente.apc.Code2D.NPCBehaviour
   * @see #setBehaviour(NPCBehaviour)
   * @see nl.utwente.apc.Code2D.Code2DPackage#getNPC_Behaviour()
   * @model
   * @generated
   */
  NPCBehaviour getBehaviour();

  /**
   * Sets the value of the '{@link nl.utwente.apc.Code2D.NPC#getBehaviour <em>Behaviour</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Behaviour</em>' attribute.
   * @see nl.utwente.apc.Code2D.NPCBehaviour
   * @see #getBehaviour()
   * @generated
   */
  void setBehaviour(NPCBehaviour value);

  /**
   * Returns the value of the '<em><b>Extends</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Extends</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Extends</em>' reference.
   * @see #setExtends(NPC)
   * @see nl.utwente.apc.Code2D.Code2DPackage#getNPC_Extends()
   * @model
   * @generated
   */
  NPC getExtends();

  /**
   * Sets the value of the '{@link nl.utwente.apc.Code2D.NPC#getExtends <em>Extends</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Extends</em>' reference.
   * @see #getExtends()
   * @generated
   */
  void setExtends(NPC value);

} // NPC