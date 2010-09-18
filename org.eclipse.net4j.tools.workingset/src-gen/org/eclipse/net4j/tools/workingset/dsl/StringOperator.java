/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.net4j.tools.workingset.dsl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>String Operator</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.net4j.tools.workingset.dsl.DslPackage#getStringOperator()
 * @model
 * @generated
 */
public enum StringOperator implements Enumerator
{
  /**
   * The '<em><b>EQ</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #EQ_VALUE
   * @generated
   * @ordered
   */
  EQ(0, "EQ", "="),

  /**
   * The '<em><b>EQ2</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #EQ2_VALUE
   * @generated
   * @ordered
   */
  EQ2(1, "EQ2", "=="),

  /**
   * The '<em><b>NE</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #NE_VALUE
   * @generated
   * @ordered
   */
  NE(2, "NE", "!="),

  /**
   * The '<em><b>NE2</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #NE2_VALUE
   * @generated
   * @ordered
   */
  NE2(3, "NE2", "<>"),

  /**
   * The '<em><b>GT</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #GT_VALUE
   * @generated
   * @ordered
   */
  GT(4, "GT", ">"),

  /**
   * The '<em><b>GE</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #GE_VALUE
   * @generated
   * @ordered
   */
  GE(5, "GE", ">="),

  /**
   * The '<em><b>LT</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #LT_VALUE
   * @generated
   * @ordered
   */
  LT(6, "LT", "<"),

  /**
   * The '<em><b>LE</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #LE_VALUE
   * @generated
   * @ordered
   */
  LE(7, "LE", "<="),

  /**
   * The '<em><b>LIKE</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #LIKE_VALUE
   * @generated
   * @ordered
   */
  LIKE(8, "LIKE", "like"),

  /**
   * The '<em><b>LIKE2</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #LIKE2_VALUE
   * @generated
   * @ordered
   */
  LIKE2(9, "LIKE2", "~"),

  /**
   * The '<em><b>UNLIKE</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #UNLIKE_VALUE
   * @generated
   * @ordered
   */
  UNLIKE(10, "UNLIKE", "unlike"),

  /**
   * The '<em><b>UNLIKE2</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #UNLIKE2_VALUE
   * @generated
   * @ordered
   */
  UNLIKE2(11, "UNLIKE2", "!~"),

  /**
   * The '<em><b>STARTS</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #STARTS_VALUE
   * @generated
   * @ordered
   */
  STARTS(12, "STARTS", "starts"),

  /**
   * The '<em><b>ENDS</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #ENDS_VALUE
   * @generated
   * @ordered
   */
  ENDS(13, "ENDS", "ends"),

  /**
   * The '<em><b>CONTAINS</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #CONTAINS_VALUE
   * @generated
   * @ordered
   */
  CONTAINS(14, "CONTAINS", "contains");

  /**
   * The '<em><b>EQ</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>EQ</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #EQ
   * @model literal="="
   * @generated
   * @ordered
   */
  public static final int EQ_VALUE = 0;

  /**
   * The '<em><b>EQ2</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>EQ2</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #EQ2
   * @model literal="=="
   * @generated
   * @ordered
   */
  public static final int EQ2_VALUE = 1;

  /**
   * The '<em><b>NE</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>NE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #NE
   * @model literal="!="
   * @generated
   * @ordered
   */
  public static final int NE_VALUE = 2;

  /**
   * The '<em><b>NE2</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>NE2</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #NE2
   * @model literal="<>"
   * @generated
   * @ordered
   */
  public static final int NE2_VALUE = 3;

  /**
   * The '<em><b>GT</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>GT</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #GT
   * @model literal=">"
   * @generated
   * @ordered
   */
  public static final int GT_VALUE = 4;

  /**
   * The '<em><b>GE</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>GE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #GE
   * @model literal=">="
   * @generated
   * @ordered
   */
  public static final int GE_VALUE = 5;

  /**
   * The '<em><b>LT</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>LT</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #LT
   * @model literal="<"
   * @generated
   * @ordered
   */
  public static final int LT_VALUE = 6;

  /**
   * The '<em><b>LE</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>LE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #LE
   * @model literal="<="
   * @generated
   * @ordered
   */
  public static final int LE_VALUE = 7;

  /**
   * The '<em><b>LIKE</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>LIKE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #LIKE
   * @model literal="like"
   * @generated
   * @ordered
   */
  public static final int LIKE_VALUE = 8;

  /**
   * The '<em><b>LIKE2</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>LIKE2</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #LIKE2
   * @model literal="~"
   * @generated
   * @ordered
   */
  public static final int LIKE2_VALUE = 9;

  /**
   * The '<em><b>UNLIKE</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>UNLIKE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #UNLIKE
   * @model literal="unlike"
   * @generated
   * @ordered
   */
  public static final int UNLIKE_VALUE = 10;

  /**
   * The '<em><b>UNLIKE2</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>UNLIKE2</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #UNLIKE2
   * @model literal="!~"
   * @generated
   * @ordered
   */
  public static final int UNLIKE2_VALUE = 11;

  /**
   * The '<em><b>STARTS</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>STARTS</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #STARTS
   * @model literal="starts"
   * @generated
   * @ordered
   */
  public static final int STARTS_VALUE = 12;

  /**
   * The '<em><b>ENDS</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>ENDS</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #ENDS
   * @model literal="ends"
   * @generated
   * @ordered
   */
  public static final int ENDS_VALUE = 13;

  /**
   * The '<em><b>CONTAINS</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>CONTAINS</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #CONTAINS
   * @model literal="contains"
   * @generated
   * @ordered
   */
  public static final int CONTAINS_VALUE = 14;

  /**
   * An array of all the '<em><b>String Operator</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final StringOperator[] VALUES_ARRAY =
    new StringOperator[]
    {
      EQ,
      EQ2,
      NE,
      NE2,
      GT,
      GE,
      LT,
      LE,
      LIKE,
      LIKE2,
      UNLIKE,
      UNLIKE2,
      STARTS,
      ENDS,
      CONTAINS,
    };

  /**
   * A public read-only list of all the '<em><b>String Operator</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<StringOperator> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>String Operator</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static StringOperator get(String literal)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      StringOperator result = VALUES_ARRAY[i];
      if (result.toString().equals(literal))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>String Operator</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static StringOperator getByName(String name)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      StringOperator result = VALUES_ARRAY[i];
      if (result.getName().equals(name))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>String Operator</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static StringOperator get(int value)
  {
    switch (value)
    {
      case EQ_VALUE: return EQ;
      case EQ2_VALUE: return EQ2;
      case NE_VALUE: return NE;
      case NE2_VALUE: return NE2;
      case GT_VALUE: return GT;
      case GE_VALUE: return GE;
      case LT_VALUE: return LT;
      case LE_VALUE: return LE;
      case LIKE_VALUE: return LIKE;
      case LIKE2_VALUE: return LIKE2;
      case UNLIKE_VALUE: return UNLIKE;
      case UNLIKE2_VALUE: return UNLIKE2;
      case STARTS_VALUE: return STARTS;
      case ENDS_VALUE: return ENDS;
      case CONTAINS_VALUE: return CONTAINS;
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
  private StringOperator(int value, String name, String literal)
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
  
} //StringOperator
