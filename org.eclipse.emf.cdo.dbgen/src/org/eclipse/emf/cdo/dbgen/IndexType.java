/*******************************************************************************
 * Copyright (c) 2004, 2005, 2006 Eike Stepper, Sympedia Methods and Tools.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Eike Stepper - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.cdo.dbgen;


import org.eclipse.emf.common.util.AbstractEnumerator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Index Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.emf.cdo.dbgen.DBGenPackage#getIndexType()
 * @model
 * @generated
 */
public final class IndexType extends AbstractEnumerator
{
  /**
   * The '<em><b>NON UNIQUE</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>NON UNIQUE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #NON_UNIQUE_LITERAL
   * @model
   * @generated
   * @ordered
   */
  public static final int NON_UNIQUE = 0;

  /**
   * The '<em><b>UNIQUE</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>UNIQUE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #UNIQUE_LITERAL
   * @model
   * @generated
   * @ordered
   */
  public static final int UNIQUE = 1;

  /**
   * The '<em><b>PRIMARY</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>PRIMARY</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #PRIMARY_LITERAL
   * @model
   * @generated
   * @ordered
   */
  public static final int PRIMARY = 2;

  /**
   * The '<em><b>NON UNIQUE</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #NON_UNIQUE
   * @generated
   * @ordered
   */
  public static final IndexType NON_UNIQUE_LITERAL = new IndexType(NON_UNIQUE, "NON_UNIQUE",
      "NON_UNIQUE");

  /**
   * The '<em><b>UNIQUE</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #UNIQUE
   * @generated
   * @ordered
   */
  public static final IndexType UNIQUE_LITERAL = new IndexType(UNIQUE, "UNIQUE", "UNIQUE");

  /**
   * The '<em><b>PRIMARY</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #PRIMARY
   * @generated
   * @ordered
   */
  public static final IndexType PRIMARY_LITERAL = new IndexType(PRIMARY, "PRIMARY", "PRIMARY");

  /**
   * An array of all the '<em><b>Index Type</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final IndexType[] VALUES_ARRAY = new IndexType[] { NON_UNIQUE_LITERAL,
      UNIQUE_LITERAL, PRIMARY_LITERAL,};

  /**
   * A public read-only list of all the '<em><b>Index Type</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>Index Type</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static IndexType get(String literal)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      IndexType result = VALUES_ARRAY[i];
      if (result.toString().equals(literal))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Index Type</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static IndexType getByName(String name)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      IndexType result = VALUES_ARRAY[i];
      if (result.getName().equals(name))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Index Type</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static IndexType get(int value)
  {
    switch (value)
    {
      case NON_UNIQUE:
        return NON_UNIQUE_LITERAL;
      case UNIQUE:
        return UNIQUE_LITERAL;
      case PRIMARY:
        return PRIMARY_LITERAL;
    }
    return null;
  }

  /**
   * Only this class can construct instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private IndexType(int value, String name, String literal)
  {
    super(value, name, literal);
  }

} //IndexType
