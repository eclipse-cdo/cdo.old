/***************************************************************************
 * Copyright (c) 2004, 2005, 2006 Eike Stepper, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 **************************************************************************/
package org.eclipse.emf.cdo.dbgen;


import org.eclipse.emf.common.util.AbstractEnumerator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Column Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.emf.cdo.dbgen.DBGenPackage#getColumnType()
 * @model
 * @generated
 */
public final class ColumnType extends AbstractEnumerator
{
  /**
   * The '<em><b>BOOLEAN</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>BOOLEAN</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #BOOLEAN_LITERAL
   * @model
   * @generated
   * @ordered
   */
  public static final int BOOLEAN = 16;

  /**
   * The '<em><b>BIT</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>BIT</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #BIT_LITERAL
   * @model
   * @generated
   * @ordered
   */
  public static final int BIT = -7;

  /**
   * The '<em><b>TINYINT</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>TINYINT</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #TINYINT_LITERAL
   * @model
   * @generated
   * @ordered
   */
  public static final int TINYINT = -6;

  /**
   * The '<em><b>SMALLINT</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>SMALLINT</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #SMALLINT_LITERAL
   * @model
   * @generated
   * @ordered
   */
  public static final int SMALLINT = 5;

  /**
   * The '<em><b>INTEGER</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>INTEGER</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #INTEGER_LITERAL
   * @model
   * @generated
   * @ordered
   */
  public static final int INTEGER = 4;

  /**
   * The '<em><b>BIGINT</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>BIGINT</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #BIGINT_LITERAL
   * @model
   * @generated
   * @ordered
   */
  public static final int BIGINT = -5;

  /**
   * The '<em><b>FLOAT</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>FLOAT</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #FLOAT_LITERAL
   * @model
   * @generated
   * @ordered
   */
  public static final int FLOAT = 6;

  /**
   * The '<em><b>REAL</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>REAL</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #REAL_LITERAL
   * @model
   * @generated
   * @ordered
   */
  public static final int REAL = 7;

  /**
   * The '<em><b>DOUBLE</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>DOUBLE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #DOUBLE_LITERAL
   * @model
   * @generated
   * @ordered
   */
  public static final int DOUBLE = 8;

  /**
   * The '<em><b>NUMERIC</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>NUMERIC</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #NUMERIC_LITERAL
   * @model
   * @generated
   * @ordered
   */
  public static final int NUMERIC = 2;

  /**
   * The '<em><b>DECIMAL</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>DECIMAL</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #DECIMAL_LITERAL
   * @model
   * @generated
   * @ordered
   */
  public static final int DECIMAL = 3;

  /**
   * The '<em><b>CHAR</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>CHAR</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #CHAR_LITERAL
   * @model
   * @generated
   * @ordered
   */
  public static final int CHAR = 1;

  /**
   * The '<em><b>VARCHAR</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>VARCHAR</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #VARCHAR_LITERAL
   * @model
   * @generated
   * @ordered
   */
  public static final int VARCHAR = 12;

  /**
   * The '<em><b>LONGVARCHAR</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>LONGVARCHAR</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #LONGVARCHAR_LITERAL
   * @model
   * @generated
   * @ordered
   */
  public static final int LONGVARCHAR = -1;

  /**
   * The '<em><b>DATE</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>DATE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #DATE_LITERAL
   * @model
   * @generated
   * @ordered
   */
  public static final int DATE = 91;

  /**
   * The '<em><b>TIME</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>TIME</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #TIME_LITERAL
   * @model
   * @generated
   * @ordered
   */
  public static final int TIME = 92;

  /**
   * The '<em><b>TIMESTAMP</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>TIMESTAMP</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #TIMESTAMP_LITERAL
   * @model
   * @generated
   * @ordered
   */
  public static final int TIMESTAMP = 93;

  /**
   * The '<em><b>BINARY</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>BINARY</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #BINARY_LITERAL
   * @model
   * @generated
   * @ordered
   */
  public static final int BINARY = -2;

  /**
   * The '<em><b>VARBINARY</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>VARBINARY</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #VARBINARY_LITERAL
   * @model
   * @generated
   * @ordered
   */
  public static final int VARBINARY = -3;

  /**
   * The '<em><b>LONGVARBINARY</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>LONGVARBINARY</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #LONGVARBINARY_LITERAL
   * @model
   * @generated
   * @ordered
   */
  public static final int LONGVARBINARY = -4;

  /**
   * The '<em><b>BLOB</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>BLOB</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #BLOB_LITERAL
   * @model
   * @generated
   * @ordered
   */
  public static final int BLOB = 2004;

  /**
   * The '<em><b>CLOB</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>CLOB</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #CLOB_LITERAL
   * @model
   * @generated
   * @ordered
   */
  public static final int CLOB = 2005;

  /**
   * The '<em><b>BOOLEAN</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #BOOLEAN
   * @generated
   * @ordered
   */
  public static final ColumnType BOOLEAN_LITERAL = new ColumnType(BOOLEAN, "BOOLEAN", "BOOLEAN");

  /**
   * The '<em><b>BIT</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #BIT
   * @generated
   * @ordered
   */
  public static final ColumnType BIT_LITERAL = new ColumnType(BIT, "BIT", "BIT");

  /**
   * The '<em><b>TINYINT</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #TINYINT
   * @generated
   * @ordered
   */
  public static final ColumnType TINYINT_LITERAL = new ColumnType(TINYINT, "TINYINT", "TINYINT");

  /**
   * The '<em><b>SMALLINT</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #SMALLINT
   * @generated
   * @ordered
   */
  public static final ColumnType SMALLINT_LITERAL = new ColumnType(SMALLINT, "SMALLINT", "SMALLINT");

  /**
   * The '<em><b>INTEGER</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #INTEGER
   * @generated
   * @ordered
   */
  public static final ColumnType INTEGER_LITERAL = new ColumnType(INTEGER, "INTEGER", "INTEGER");

  /**
   * The '<em><b>BIGINT</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #BIGINT
   * @generated
   * @ordered
   */
  public static final ColumnType BIGINT_LITERAL = new ColumnType(BIGINT, "BIGINT", "BIGINT");

  /**
   * The '<em><b>FLOAT</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #FLOAT
   * @generated
   * @ordered
   */
  public static final ColumnType FLOAT_LITERAL = new ColumnType(FLOAT, "FLOAT", "FLOAT");

  /**
   * The '<em><b>REAL</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #REAL
   * @generated
   * @ordered
   */
  public static final ColumnType REAL_LITERAL = new ColumnType(REAL, "REAL", "REAL");

  /**
   * The '<em><b>DOUBLE</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #DOUBLE
   * @generated
   * @ordered
   */
  public static final ColumnType DOUBLE_LITERAL = new ColumnType(DOUBLE, "DOUBLE", "DOUBLE");

  /**
   * The '<em><b>NUMERIC</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #NUMERIC
   * @generated
   * @ordered
   */
  public static final ColumnType NUMERIC_LITERAL = new ColumnType(NUMERIC, "NUMERIC", "NUMERIC");

  /**
   * The '<em><b>DECIMAL</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #DECIMAL
   * @generated
   * @ordered
   */
  public static final ColumnType DECIMAL_LITERAL = new ColumnType(DECIMAL, "DECIMAL", "DECIMAL");

  /**
   * The '<em><b>CHAR</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #CHAR
   * @generated
   * @ordered
   */
  public static final ColumnType CHAR_LITERAL = new ColumnType(CHAR, "CHAR", "CHAR");

  /**
   * The '<em><b>VARCHAR</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #VARCHAR
   * @generated
   * @ordered
   */
  public static final ColumnType VARCHAR_LITERAL = new ColumnType(VARCHAR, "VARCHAR", "VARCHAR");

  /**
   * The '<em><b>LONGVARCHAR</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #LONGVARCHAR
   * @generated
   * @ordered
   */
  public static final ColumnType LONGVARCHAR_LITERAL = new ColumnType(LONGVARCHAR, "LONGVARCHAR",
      "LONGVARCHAR");

  /**
   * The '<em><b>DATE</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #DATE
   * @generated
   * @ordered
   */
  public static final ColumnType DATE_LITERAL = new ColumnType(DATE, "DATE", "DATE");

  /**
   * The '<em><b>TIME</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #TIME
   * @generated
   * @ordered
   */
  public static final ColumnType TIME_LITERAL = new ColumnType(TIME, "TIME", "TIME");

  /**
   * The '<em><b>TIMESTAMP</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #TIMESTAMP
   * @generated
   * @ordered
   */
  public static final ColumnType TIMESTAMP_LITERAL = new ColumnType(TIMESTAMP, "TIMESTAMP",
      "TIMESTAMP");

  /**
   * The '<em><b>BINARY</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #BINARY
   * @generated
   * @ordered
   */
  public static final ColumnType BINARY_LITERAL = new ColumnType(BINARY, "BINARY", "BINARY");

  /**
   * The '<em><b>VARBINARY</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #VARBINARY
   * @generated
   * @ordered
   */
  public static final ColumnType VARBINARY_LITERAL = new ColumnType(VARBINARY, "VARBINARY",
      "VARBINARY");

  /**
   * The '<em><b>LONGVARBINARY</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #LONGVARBINARY
   * @generated
   * @ordered
   */
  public static final ColumnType LONGVARBINARY_LITERAL = new ColumnType(LONGVARBINARY,
      "LONGVARBINARY", "LONGVARBINARY");

  /**
   * The '<em><b>BLOB</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #BLOB
   * @generated
   * @ordered
   */
  public static final ColumnType BLOB_LITERAL = new ColumnType(BLOB, "BLOB", "BLOB");

  /**
   * The '<em><b>CLOB</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #CLOB
   * @generated
   * @ordered
   */
  public static final ColumnType CLOB_LITERAL = new ColumnType(CLOB, "CLOB", "CLOB");

  /**
   * An array of all the '<em><b>Column Type</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final ColumnType[] VALUES_ARRAY = new ColumnType[] { BOOLEAN_LITERAL, BIT_LITERAL,
      TINYINT_LITERAL, SMALLINT_LITERAL, INTEGER_LITERAL, BIGINT_LITERAL, FLOAT_LITERAL,
      REAL_LITERAL, DOUBLE_LITERAL, NUMERIC_LITERAL, DECIMAL_LITERAL, CHAR_LITERAL,
      VARCHAR_LITERAL, LONGVARCHAR_LITERAL, DATE_LITERAL, TIME_LITERAL, TIMESTAMP_LITERAL,
      BINARY_LITERAL, VARBINARY_LITERAL, LONGVARBINARY_LITERAL, BLOB_LITERAL, CLOB_LITERAL,};

  /**
   * A public read-only list of all the '<em><b>Column Type</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>Column Type</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static ColumnType get(String literal)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      ColumnType result = VALUES_ARRAY[i];
      if (result.toString().equals(literal))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Column Type</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static ColumnType getByName(String name)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      ColumnType result = VALUES_ARRAY[i];
      if (result.getName().equals(name))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Column Type</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static ColumnType get(int value)
  {
    switch (value)
    {
      case BOOLEAN:
        return BOOLEAN_LITERAL;
      case BIT:
        return BIT_LITERAL;
      case TINYINT:
        return TINYINT_LITERAL;
      case SMALLINT:
        return SMALLINT_LITERAL;
      case INTEGER:
        return INTEGER_LITERAL;
      case BIGINT:
        return BIGINT_LITERAL;
      case FLOAT:
        return FLOAT_LITERAL;
      case REAL:
        return REAL_LITERAL;
      case DOUBLE:
        return DOUBLE_LITERAL;
      case NUMERIC:
        return NUMERIC_LITERAL;
      case DECIMAL:
        return DECIMAL_LITERAL;
      case CHAR:
        return CHAR_LITERAL;
      case VARCHAR:
        return VARCHAR_LITERAL;
      case LONGVARCHAR:
        return LONGVARCHAR_LITERAL;
      case DATE:
        return DATE_LITERAL;
      case TIME:
        return TIME_LITERAL;
      case TIMESTAMP:
        return TIMESTAMP_LITERAL;
      case BINARY:
        return BINARY_LITERAL;
      case VARBINARY:
        return VARBINARY_LITERAL;
      case LONGVARBINARY:
        return LONGVARBINARY_LITERAL;
      case BLOB:
        return BLOB_LITERAL;
      case CLOB:
        return CLOB_LITERAL;
    }
    return null;
  }

  /**
   * Only this class can construct instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private ColumnType(int value, String name, String literal)
  {
    super(value, name, literal);
  }

} //ColumnType
