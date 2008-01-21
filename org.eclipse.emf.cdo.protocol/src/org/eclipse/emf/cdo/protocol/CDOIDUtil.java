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
package org.eclipse.emf.cdo.protocol;

import org.eclipse.emf.cdo.internal.protocol.CDOIDImpl;
import org.eclipse.emf.cdo.internal.protocol.model.CDOClassRefImpl;
import org.eclipse.emf.cdo.protocol.model.CDOClassRef;

import org.eclipse.net4j.util.io.ExtendedDataInput;
import org.eclipse.net4j.util.io.ExtendedDataOutput;

import java.io.IOException;

/**
 * @author Eike Stepper
 */
public final class CDOIDUtil
{
  private CDOIDUtil()
  {
  }

  public static CDOID create(long value)
  {
    if (value == 0)
    {
      return CDOID.NULL;
    }

    return new CDOIDImpl(value);
  }

  public static CDOIDTyped create(long value, CDOClassRef type)
  {
    if (value == 0)
    {
      throw new IllegalArgumentException("value == 0");
    }

    if (type == null)
    {
      throw new IllegalArgumentException("type == null");
    }

    return new CDOIDImpl.Typed(value, type);
  }

  public static CDOID copy(CDOID source)
  {
    return source;
  }

  public static CDOID parse(String s) throws NumberFormatException
  {
    long value = Long.parseLong(s);
    return create(value);
  }

  public static CDOID read(ExtendedDataInput in) throws IOException
  {
    return read(in, false);
  }

  public static CDOID read(ExtendedDataInput in, boolean withType) throws IOException
  {
    long value = in.readLong();
    if (withType)
    {
      boolean typed = in.readBoolean();
      if (typed)
      {
        CDOClassRefImpl type = new CDOClassRefImpl(in, null);
        return create(value, type);
      }
    }

    return create(value);
  }

  public static void write(ExtendedDataOutput out, CDOID id) throws IOException
  {
    write(out, id, false);
  }

  public static void write(ExtendedDataOutput out, CDOID id, boolean withType) throws IOException
  {
    out.writeLong(id == null ? 0L : id.getValue());
    if (withType)
    {
      if (id instanceof CDOIDTyped)
      {
        CDOIDTyped typed = (CDOIDTyped)id;
        out.writeBoolean(true);

        CDOClassRefImpl type = (CDOClassRefImpl)typed.getType();
        type.write(out, null);
      }
      else
      {
        out.writeBoolean(false);
      }
    }
  }
}
