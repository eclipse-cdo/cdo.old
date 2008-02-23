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
package org.eclipse.emf.cdo.protocol.id;

import org.eclipse.emf.cdo.internal.protocol.id.CDOIDMetaImpl;
import org.eclipse.emf.cdo.internal.protocol.id.CDOIDMetaRangeImpl;
import org.eclipse.emf.cdo.internal.protocol.id.CDOIDObjectImpl;
import org.eclipse.emf.cdo.internal.protocol.id.CDOIDTempMetaImpl;
import org.eclipse.emf.cdo.internal.protocol.id.CDOIDTempObjectImpl;
import org.eclipse.emf.cdo.protocol.id.CDOID.Type;
import org.eclipse.emf.cdo.protocol.model.CDOClassRef;
import org.eclipse.emf.cdo.protocol.model.CDOModelUtil;

import org.eclipse.net4j.util.ImplementationError;
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

  public static long getLong(CDOID id)
  {
    switch (id.getType())
    {
    case NULL:
      return 0L;
    case OBJECT:
    case LEGACY_OBJECT:
      if (id instanceof CDOIDObjectImpl)
      {
        return ((CDOIDObjectImpl)id).getLongValue();
      }

      throw new IllegalArgumentException("Unknown CDOIDObject implementation: " + id.getClass().getName());

    case META:
      return ((CDOIDMeta)id).getLongValue();
    case TEMP_META:
    case TEMP_OBJECT:
      throw new IllegalArgumentException("id instanceof CDOIDTemp");
    default:
      throw new ImplementationError();
    }
  }

  public static CDOIDTemp createCDOIDTempObject(int value)
  {
    return new CDOIDTempObjectImpl(value);
  }

  public static CDOID createCDOID(long value)
  {
    if (value == 0L)
    {
      return CDOID.NULL;
    }

    return new CDOIDObjectImpl(value);
  }

  public static CDOID read(ExtendedDataInput in, CDOIDObjectFactory factory) throws IOException
  {
    return read(in, factory, false);
  }

  public static CDOID read(ExtendedDataInput in, CDOIDObjectFactory factory, boolean asLegacy) throws IOException
  {
    Type type = Type.values()[in.readByte()];
    if (asLegacy)
    {
      switch (type)
      {
      case NULL:
      case TEMP_OBJECT:
      case TEMP_META:
      case META:
      case OBJECT:
        throw new IllegalStateException("Missing classRef");

      case LEGACY_OBJECT:
        CDOIDObject id = factory.createCDOIDObject(in);
        id.read(in);
        CDOClassRef classRef = CDOModelUtil.readClassRef(in);
        return id.asLegacy(classRef);

      default:
        throw new ImplementationError();
      }
    }

    // Not asLegacy
    switch (type)
    {
    case NULL:
      return CDOID.NULL;

    case TEMP_OBJECT:
      return new CDOIDTempObjectImpl(in.readInt());

    case TEMP_META:
      return new CDOIDTempMetaImpl(in.readInt());

    case META:
      return new CDOIDMetaImpl(in.readLong());

    case OBJECT:
      return new CDOIDObjectImpl(in.readLong());

    case LEGACY_OBJECT:
      CDOIDObject id = factory.createCDOIDObject(in);
      id.read(in);
      CDOModelUtil.readClassRef(in); // Discard classRef from stream
      return id;

    default:
      throw new ImplementationError();
    }
  }

  public static void write(ExtendedDataOutput out, CDOID id) throws IOException
  {
    write(out, id, false);
  }

  public static void write(ExtendedDataOutput out, CDOID id, boolean asLegacy) throws IOException
  {
    if (id == null)
    {
      out.writeByte(Type.NULL.ordinal());
      return;
    }

    Type type = id.getType();
    out.writeByte(type.ordinal());
    if (asLegacy)
    {
      switch (type)
      {
      case NULL:
      case TEMP_OBJECT:
      case TEMP_META:
      case META:
      case OBJECT:
        throw new IllegalStateException("Missing classRef");

      case LEGACY_OBJECT:
        CDOIDObject legacy = (CDOIDObject)id;
        legacy.write(out);
        CDOModelUtil.writeClassRef(out, legacy.getClassRef());
        return;

      default:
        throw new ImplementationError();
      }
    }

    // Not asLegacy
    id.write(out);
  }

  public static CDOIDMetaRange createMetaRange(CDOID lowerBound, int count)
  {
    return new CDOIDMetaRangeImpl(lowerBound, count);
  }

  public static CDOIDMetaRange readMetaRange(ExtendedDataInput in) throws IOException
  {
    return new CDOIDMetaRangeImpl(read(in, null), in.readInt());
  }

  public static void writeMetaRange(ExtendedDataOutput out, CDOIDMetaRange idRange) throws IOException
  {
    write(out, idRange.getLowerBound());
    out.writeInt(idRange.size());
  }
}
