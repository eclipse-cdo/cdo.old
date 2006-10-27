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
package org.eclipse.emf.cdo.core.impl;


import org.eclipse.net4j.util.lifecycle.AbstractLifecycle;
import org.eclipse.net4j.util.stream.ExtendedDataInput;
import org.eclipse.net4j.util.stream.ExtendedDataOutput;

import org.eclipse.emf.cdo.core.CDODataTypes;
import org.eclipse.emf.cdo.core.UnknownDataTypeException;

import java.io.IOException;


public abstract class AbstractConverter extends AbstractLifecycle implements CDODataTypes
{
  protected Object dispatchFromChannel(ExtendedDataInput channel, int dataType) throws IOException
  {
    switch (dataType)
    {
      case CHAR:
        return fromChannelChar(channel);
      case BOOLEAN:
        return fromChannelBoolean(channel);
      case BYTE:
        return fromChannelByte(channel);
      case SHORT:
        return fromChannelShort(channel);
      case INT:
        return fromChannelInteger(channel);
      case LONG:
        return fromChannelLong(channel);
      case FLOAT:
        return fromChannelFloat(channel);
      case DOUBLE:
        return fromChannelDouble(channel);
      case STRING:
        return fromChannelString(channel);
      case USER_DEFINED:
        return fromChannelUserDefined(channel);
      default:
        throw new UnknownDataTypeException("Can't handle type " + dataType);
    }
  }

  protected void dispatchToChannel(ExtendedDataOutput channel, int dataType, Object value)
      throws IOException
  {
    switch (dataType)
    {
      case CHAR:
        toChannelChar(channel, value);
        break;
      case BOOLEAN:
        toChannelBoolean(channel, value);
        break;
      case BYTE:
        toChannelByte(channel, value);
        break;
      case SHORT:
        toChannelShort(channel, value);
        break;
      case INT:
        toChannelInteger(channel, value);
        break;
      case LONG:
        toChannelLong(channel, value);
        break;
      case FLOAT:
        toChannelFloat(channel, value);
        break;
      case DOUBLE:
        toChannelDouble(channel, value);
        break;
      case STRING:
        toChannelString(channel, value);
        break;
      case USER_DEFINED:
        toChannelUserDefined(channel, value);
        break;
      default:
        throw new UnknownDataTypeException("Can't handle type " + dataType);
    }
  }

  protected Object fromChannelChar(ExtendedDataInput channel) throws IOException
  {
    char value = channel.readChar();
    return new Character(value);
  }

  protected void toChannelChar(ExtendedDataOutput channel, Object value) throws IOException
  {
    char v = ((Character) value).charValue();
    channel.writeChar(v);
  }

  protected Object fromChannelBoolean(ExtendedDataInput channel) throws IOException
  {
    boolean value = channel.readBoolean();
    return new Boolean(value);
  }

  protected void toChannelBoolean(ExtendedDataOutput channel, Object value) throws IOException
  {
    boolean v = ((Boolean) value).booleanValue();
    channel.writeBoolean(v);
  }

  protected Object fromChannelByte(ExtendedDataInput channel) throws IOException
  {
    byte value = channel.readByte();
    return new Byte(value);
  }

  protected void toChannelByte(ExtendedDataOutput channel, Object value) throws IOException
  {
    byte v = ((Byte) value).byteValue();
    channel.writeByte(v);
  }

  protected Object fromChannelShort(ExtendedDataInput channel) throws IOException
  {
    short value = channel.readShort();
    return new Short(value);
  }

  protected void toChannelShort(ExtendedDataOutput channel, Object value) throws IOException
  {
    short v = ((Short) value).shortValue();
    channel.writeShort(v);
  }

  protected Object fromChannelInteger(ExtendedDataInput channel) throws IOException
  {
    int value = channel.readInt();
    return new Integer(value);
  }

  protected void toChannelInteger(ExtendedDataOutput channel, Object value) throws IOException
  {
    int v = ((Integer) value).intValue();
    channel.writeInt(v);
  }

  protected Object fromChannelLong(ExtendedDataInput channel) throws IOException
  {
    long value = channel.readLong();
    return new Long(value);
  }

  protected void toChannelLong(ExtendedDataOutput channel, Object value) throws IOException
  {
    long v = ((Long) value).longValue();
    channel.writeLong(v);
  }

  protected Object fromChannelFloat(ExtendedDataInput channel) throws IOException
  {
    float value = channel.readFloat();
    return new Float(value);
  }

  protected void toChannelFloat(ExtendedDataOutput channel, Object value) throws IOException
  {
    float v = ((Float) value).floatValue();
    channel.writeFloat(v);
  }

  protected Object fromChannelDouble(ExtendedDataInput channel) throws IOException
  {
    double value = channel.readDouble();
    return new Double(value);
  }

  protected void toChannelDouble(ExtendedDataOutput channel, Object value) throws IOException
  {
    double v = ((Double) value).doubleValue();
    channel.writeDouble(v);
  }

  protected Object fromChannelString(ExtendedDataInput channel) throws IOException
  {
    return channel.readString();
  }

  protected void toChannelString(ExtendedDataOutput channel, Object value) throws IOException
  {
    channel.writeString((String) value);
  }

  protected Object fromChannelUserDefined(ExtendedDataInput channel) throws IOException
  {
    return fromChannelString(channel);
  }

  protected void toChannelUserDefined(ExtendedDataOutput channel, Object value) throws IOException
  {
    toChannelString(channel, value);
  }
}
