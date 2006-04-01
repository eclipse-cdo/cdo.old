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
package org.eclipse.emf.cdo.core;


public interface CdoDataTypes
{
  public static final int CHAR = -1;

  public static final int BOOLEAN = -2;

  public static final int BYTE = -3;

  public static final int SHORT = -4;

  public static final int INT = -5;

  public static final int LONG = -6;

  public static final int FLOAT = -7;

  public static final int DOUBLE = -8;

  public static final int MIN_PRIMITIVE = 0;

  public static final int CHAR_OBJECT = -CHAR;

  public static final int BOOLEAN_OBJECT = -BOOLEAN;

  public static final int BYTE_OBJECT = -BYTE;

  public static final int SHORT_OBJECT = -SHORT;

  public static final int INT_OBJECT = -INT;

  public static final int LONG_OBJECT = -LONG;

  public static final int FLOAT_OBJECT = -FLOAT;

  public static final int DOUBLE_OBJECT = -DOUBLE;

  public static final int MAX_PRIMITIVE = DOUBLE_OBJECT + 1;

  public static final int STRING = MAX_PRIMITIVE + 1;

  public static final int USER_DEFINED = MAX_PRIMITIVE + 2;
}
