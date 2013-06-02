/**
 */
package nl.utwente.apc.Code2D;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>NPC Behaviour</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see nl.utwente.apc.Code2D.Code2DPackage#getNPCBehaviour()
 * @model
 * @generated
 */
public enum NPCBehaviour implements Enumerator
{
  /**
   * The '<em><b>Friendly</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #FRIENDLY_VALUE
   * @generated
   * @ordered
   */
  FRIENDLY(0, "Friendly", "Friendly"),

  /**
   * The '<em><b>Neutral</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #NEUTRAL_VALUE
   * @generated
   * @ordered
   */
  NEUTRAL(1, "Neutral", "Neutral"),

  /**
   * The '<em><b>Hostile</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #HOSTILE_VALUE
   * @generated
   * @ordered
   */
  HOSTILE(2, "Hostile", "Hostile");

  /**
   * The '<em><b>Friendly</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Friendly</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #FRIENDLY
   * @model name="Friendly"
   * @generated
   * @ordered
   */
  public static final int FRIENDLY_VALUE = 0;

  /**
   * The '<em><b>Neutral</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Neutral</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #NEUTRAL
   * @model name="Neutral"
   * @generated
   * @ordered
   */
  public static final int NEUTRAL_VALUE = 1;

  /**
   * The '<em><b>Hostile</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Hostile</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #HOSTILE
   * @model name="Hostile"
   * @generated
   * @ordered
   */
  public static final int HOSTILE_VALUE = 2;

  /**
   * An array of all the '<em><b>NPC Behaviour</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final NPCBehaviour[] VALUES_ARRAY =
    new NPCBehaviour[]
    {
      FRIENDLY,
      NEUTRAL,
      HOSTILE,
    };

  /**
   * A public read-only list of all the '<em><b>NPC Behaviour</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<NPCBehaviour> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>NPC Behaviour</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static NPCBehaviour get(String literal)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      NPCBehaviour result = VALUES_ARRAY[i];
      if (result.toString().equals(literal))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>NPC Behaviour</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static NPCBehaviour getByName(String name)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      NPCBehaviour result = VALUES_ARRAY[i];
      if (result.getName().equals(name))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>NPC Behaviour</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static NPCBehaviour get(int value)
  {
    switch (value)
    {
      case FRIENDLY_VALUE: return FRIENDLY;
      case NEUTRAL_VALUE: return NEUTRAL;
      case HOSTILE_VALUE: return HOSTILE;
    }
    return null;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final int value;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final String name;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final String literal;

  /**
   * Only this class can construct instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private NPCBehaviour(int value, String name, String literal)
  {
    this.value = value;
    this.name = name;
    this.literal = literal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getValue()
  {
    return value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getLiteral()
  {
    return literal;
  }

  /**
   * Returns the literal value of the enumerator, which is its string representation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    return literal;
  }
  
} //NPCBehaviour
