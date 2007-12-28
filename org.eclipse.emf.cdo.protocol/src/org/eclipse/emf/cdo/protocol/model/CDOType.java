/***************************************************************************
 * Copyright (c) 2004 - 2008 Eike Stepper, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 **************************************************************************/
package org.eclipse.emf.cdo.protocol.model;

import org.eclipse.emf.cdo.internal.protocol.model.CDOTypeImpl;

/**
 * @author Eike Stepper
 */
public interface CDOType
{
  public static final CDOType OBJECT = CDOTypeImpl.OBJECT;

  public static final CDOType BOOLEAN = CDOTypeImpl.BOOLEAN;

  public static final CDOType BOOLEAN_OBJECT = CDOTypeImpl.BOOLEAN_OBJECT;

  public static final CDOType BYTE = CDOTypeImpl.BYTE;

  public static final CDOType BYTE_OBJECT = CDOTypeImpl.BYTE_OBJECT;

  public static final CDOType CHAR = CDOTypeImpl.CHAR;

  public static final CDOType CHARACTER_OBJECT = CDOTypeImpl.CHARACTER_OBJECT;

  public static final CDOType DATE = CDOTypeImpl.DATE;

  public static final CDOType DOUBLE = CDOTypeImpl.DOUBLE;

  public static final CDOType DOUBLE_OBJECT = CDOTypeImpl.DOUBLE_OBJECT;

  public static final CDOType FLOAT = CDOTypeImpl.FLOAT;

  public static final CDOType FLOAT_OBJECT = CDOTypeImpl.FLOAT_OBJECT;

  public static final CDOType INT = CDOTypeImpl.INT;

  public static final CDOType INTEGER_OBJECT = CDOTypeImpl.INTEGER_OBJECT;

  public static final CDOType LONG = CDOTypeImpl.LONG;

  public static final CDOType LONG_OBJECT = CDOTypeImpl.LONG_OBJECT;

  public static final CDOType SHORT = CDOTypeImpl.SHORT;

  public static final CDOType SHORT_OBJECT = CDOTypeImpl.SHORT_OBJECT;

  public static final CDOType STRING = CDOTypeImpl.STRING;

  public String getName();

  public int getTypeID();

  public boolean canBeNull();

  public Object getDefaultValue();
}
