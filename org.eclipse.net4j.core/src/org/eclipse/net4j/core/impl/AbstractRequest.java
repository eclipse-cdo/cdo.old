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
package org.eclipse.net4j.core.impl;


import org.eclipse.net4j.core.Request;


public abstract class AbstractRequest extends AbstractSignal implements Request
{
  public boolean hasResponse()
  {
    return false;
  }

  public void flush()
  {
    assertTransmittingAllowed();
    channel.flush();
  }

  public void transmitBoolean(boolean value)
  {
    assertTransmittingAllowed();
    channel.transmitBoolean(value);
  }

  public void transmitBytes(byte[] value)
  {
    assertTransmittingAllowed();
    channel.transmitBytes(value);
  }

  public void transmitByte(byte value)
  {
    assertTransmittingAllowed();
    channel.transmitByte(value);
  }

  public void transmitChar(char value)
  {
    assertTransmittingAllowed();
    channel.transmitChar(value);
  }

  public void transmitDouble(double value)
  {
    assertTransmittingAllowed();
    channel.transmitDouble(value);
  }

  public void transmitFloat(float value)
  {
    assertTransmittingAllowed();
    channel.transmitFloat(value);
  }

  public void transmitInt(int value)
  {
    assertTransmittingAllowed();
    channel.transmitInt(value);
  }

  public void transmitLong(long value)
  {
    assertTransmittingAllowed();
    channel.transmitLong(value);
  }

  public void transmitObject(Object value)
  {
    assertTransmittingAllowed();
    channel.transmitObject(value);
  }

  public void transmitShort(short value)
  {
    assertTransmittingAllowed();
    channel.transmitShort(value);
  }

  public void transmitString(String value)
  {
    assertTransmittingAllowed();
    channel.transmitString(value);
  }
}
