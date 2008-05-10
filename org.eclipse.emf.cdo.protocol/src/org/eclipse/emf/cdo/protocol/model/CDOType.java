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

import org.eclipse.emf.cdo.protocol.id.CDOIDObjectFactory;

import org.eclipse.net4j.util.io.ExtendedDataInput;
import org.eclipse.net4j.util.io.ExtendedDataOutput;

import java.io.IOException;

/**
 * @author Eike Stepper
 */
public interface CDOType
{
  public static final CDOType OBJECT = org.eclipse.emf.cdo.internal.protocol.model.CDOTypeImpl.OBJECT;

  public static final CDOType BOOLEAN = org.eclipse.emf.cdo.internal.protocol.model.CDOTypeImpl.BOOLEAN;

  public static final CDOType BOOLEAN_OBJECT = org.eclipse.emf.cdo.internal.protocol.model.CDOTypeImpl.BOOLEAN_OBJECT;

  public static final CDOType BYTE = org.eclipse.emf.cdo.internal.protocol.model.CDOTypeImpl.BYTE;

  public static final CDOType BYTE_OBJECT = org.eclipse.emf.cdo.internal.protocol.model.CDOTypeImpl.BYTE_OBJECT;

  public static final CDOType CHAR = org.eclipse.emf.cdo.internal.protocol.model.CDOTypeImpl.CHAR;

  public static final CDOType CHARACTER_OBJECT = org.eclipse.emf.cdo.internal.protocol.model.CDOTypeImpl.CHARACTER_OBJECT;

  public static final CDOType DATE = org.eclipse.emf.cdo.internal.protocol.model.CDOTypeImpl.DATE;

  public static final CDOType DOUBLE = org.eclipse.emf.cdo.internal.protocol.model.CDOTypeImpl.DOUBLE;

  public static final CDOType DOUBLE_OBJECT = org.eclipse.emf.cdo.internal.protocol.model.CDOTypeImpl.DOUBLE_OBJECT;

  public static final CDOType FLOAT = org.eclipse.emf.cdo.internal.protocol.model.CDOTypeImpl.FLOAT;

  public static final CDOType FLOAT_OBJECT = org.eclipse.emf.cdo.internal.protocol.model.CDOTypeImpl.FLOAT_OBJECT;

  public static final CDOType INT = org.eclipse.emf.cdo.internal.protocol.model.CDOTypeImpl.INT;

  public static final CDOType INTEGER_OBJECT = org.eclipse.emf.cdo.internal.protocol.model.CDOTypeImpl.INTEGER_OBJECT;

  public static final CDOType LONG = org.eclipse.emf.cdo.internal.protocol.model.CDOTypeImpl.LONG;

  public static final CDOType LONG_OBJECT = org.eclipse.emf.cdo.internal.protocol.model.CDOTypeImpl.LONG_OBJECT;

  public static final CDOType SHORT = org.eclipse.emf.cdo.internal.protocol.model.CDOTypeImpl.SHORT;

  public static final CDOType SHORT_OBJECT = org.eclipse.emf.cdo.internal.protocol.model.CDOTypeImpl.SHORT_OBJECT;

  public static final CDOType STRING = org.eclipse.emf.cdo.internal.protocol.model.CDOTypeImpl.STRING;

  public static final CDOType BYTE_ARRAY = org.eclipse.emf.cdo.internal.protocol.model.CDOTypeImpl.BYTE_ARRAY;

  public static final CDOType CUSTOM = org.eclipse.emf.cdo.internal.protocol.model.CDOTypeImpl.CUSTOM;

  public String getName();

  public int getTypeID();

  public boolean canBeNull();

  public Object getDefaultValue();

  public Object copyValue(Object value);

  public Object readValue(ExtendedDataInput in, CDOIDObjectFactory factory) throws IOException;

  public void writeValue(ExtendedDataOutput out, Object value) throws IOException;
}
