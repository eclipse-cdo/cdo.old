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
package org.eclipse.emf.cdo.core;


/**
 * Defines symbolic constants for the data types to be 
 * used in payload traffic of the CDO protocol.<p>
 * 
 * There are three ranges of constants:
 * <ol>
 * <li>Constants for <b>primitive types</b> have negative values.
 * <li>Constants for <b>wrapper types</b> have the values of the primitive types
 *     multiplied by -1.
 * <li><b>Strings</b> and <b>user defined types</b> have values greater than 
 *     {@link #MAX_PRIMITIVE}. 
 * </ol>
 * 
 * @author Eike Stepper
 */
public interface CDODataTypes
{
  /**
   * Enumeration constant for the CDO data type CHAR.<p>
   */
  public static final int CHAR = -1;

  /**
   * Enumeration constant for the CDO data type BOOLEAN.<p>
   */
  public static final int BOOLEAN = -2;

  /**
   * Enumeration constant for the CDO data type BYTE.<p>
   */
  public static final int BYTE = -3;

  /**
   * Enumeration constant for the CDO data type SHORT.<p>
   */
  public static final int SHORT = -4;

  /**
   * Enumeration constant for the CDO data type INT.<p>
   */
  public static final int INT = -5;

  /**
   * Enumeration constant for the CDO data type LONG.<p>
   */
  public static final int LONG = -6;

  /**
   * Enumeration constant for the CDO data type FLOAT.<p>
   */
  public static final int FLOAT = -7;

  /**
   * Enumeration constant for the CDO data type DOUBLE.<p>
   */
  public static final int DOUBLE = -8;

  /**
   * For internal use only.<p>
   */
  public static final int MIN_PRIMITIVE = 0;

  /**
   * Enumeration constant for the CDO data type CHAR_OBJECT.<p>
   */
  public static final int CHAR_OBJECT = -CHAR;

  /**
   * Enumeration constant for the CDO data type BOOLEAN_OBJECT.<p>
   */
  public static final int BOOLEAN_OBJECT = -BOOLEAN;

  /**
   * Enumeration constant for the CDO data type BYTE_OBJECT.<p>
   */
  public static final int BYTE_OBJECT = -BYTE;

  /**
   * Enumeration constant for the CDO data type SHORT_OBJECT.<p>
   */
  public static final int SHORT_OBJECT = -SHORT;

  /**
   * TODO Document field INT_OBJECT
   * Enumeration constant for the CDO data type INT_OBJECT.<p>
   */
  public static final int INT_OBJECT = -INT;

  /**
   * Enumeration constant for the CDO data type LONG_OBJECT.<p>
   */
  public static final int LONG_OBJECT = -LONG;

  /**
   * Enumeration constant for the CDO data type FLOAT_OBJECT.<p>
   */
  public static final int FLOAT_OBJECT = -FLOAT;

  /**
   * Enumeration constant for the CDO data type DOUBLE_OBJECT.<p>
   */
  public static final int DOUBLE_OBJECT = -DOUBLE;

  /**
   * For internal use only.<p>
   */
  public static final int MAX_PRIMITIVE = DOUBLE_OBJECT + 1;

  /**
   * Enumeration constant for the CDO data type STRING.<p>
   */
  public static final int STRING = MAX_PRIMITIVE + 1;

  /**
   * For internal use only.<p>
   */
  public static final int USER_DEFINED = MAX_PRIMITIVE + 2;
}
