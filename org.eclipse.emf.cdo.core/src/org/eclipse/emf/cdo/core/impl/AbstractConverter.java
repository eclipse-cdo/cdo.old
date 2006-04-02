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
package org.eclipse.emf.cdo.core.impl;


import org.eclipse.net4j.core.Channel;
import org.eclipse.net4j.spring.impl.ServiceImpl;

import org.eclipse.emf.cdo.core.CDODataTypes;
import org.eclipse.emf.cdo.core.UnknownDataTypeException;


public abstract class AbstractConverter extends ServiceImpl implements CDODataTypes
{
  protected Object dispatchFromChannel(Channel channel, int dataType)
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

  protected void dispatchToChannel(Channel channel, int dataType, Object value)
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

  protected Object fromChannelChar(Channel channel)
  {
    char value = channel.receiveChar();
    return new Character(value);
  }

  protected void toChannelChar(Channel channel, Object value)
  {
    char v = ((Character) value).charValue();
    channel.transmitChar(v);
  }

  protected Object fromChannelBoolean(Channel channel)
  {
    boolean value = channel.receiveBoolean();
    return new Boolean(value);
  }

  protected void toChannelBoolean(Channel channel, Object value)
  {
    boolean v = ((Boolean) value).booleanValue();
    channel.transmitBoolean(v);
  }

  protected Object fromChannelByte(Channel channel)
  {
    byte value = channel.receiveByte();
    return new Byte(value);
  }

  protected void toChannelByte(Channel channel, Object value)
  {
    byte v = ((Byte) value).byteValue();
    channel.transmitByte(v);
  }

  protected Object fromChannelShort(Channel channel)
  {
    short value = channel.receiveShort();
    return new Short(value);
  }

  protected void toChannelShort(Channel channel, Object value)
  {
    short v = ((Short) value).shortValue();
    channel.transmitShort(v);
  }

  protected Object fromChannelInteger(Channel channel)
  {
    int value = channel.receiveInt();
    return new Integer(value);
  }

  protected void toChannelInteger(Channel channel, Object value)
  {
    int v = ((Integer) value).intValue();
    channel.transmitInt(v);
  }

  protected Object fromChannelLong(Channel channel)
  {
    long value = channel.receiveLong();
    return new Long(value);
  }

  protected void toChannelLong(Channel channel, Object value)
  {
    long v = ((Long) value).longValue();
    channel.transmitLong(v);
  }

  protected Object fromChannelFloat(Channel channel)
  {
    float value = channel.receiveFloat();
    return new Float(value);
  }

  protected void toChannelFloat(Channel channel, Object value)
  {
    float v = ((Float) value).floatValue();
    channel.transmitFloat(v);
  }

  protected Object fromChannelDouble(Channel channel)
  {
    double value = channel.receiveDouble();
    return new Double(value);
  }

  protected void toChannelDouble(Channel channel, Object value)
  {
    double v = ((Double) value).doubleValue();
    channel.transmitDouble(v);
  }

  protected Object fromChannelString(Channel channel)
  {
    return channel.receiveString();
  }

  protected void toChannelString(Channel channel, Object value)
  {
    channel.transmitString((String) value);
  }

  protected Object fromChannelUserDefined(Channel channel)
  {
    return fromChannelString(channel);
  }

  protected void toChannelUserDefined(Channel channel, Object value)
  {
    toChannelString(channel, value);
  }
}
