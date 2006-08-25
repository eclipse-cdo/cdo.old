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
package org.eclipse.net4j.core;


public interface Transmitter
{
  public void flush();

  public void transmitBoolean(boolean value);

  public void transmitBytes(byte[] value);

  public void transmitByte(byte value);

  public void transmitChar(char value);

  public void transmitDouble(double value);

  public void transmitFloat(float value);

  public void transmitInt(int value);

  public void transmitLong(long value);

  public void transmitObject(Object value);

  public void transmitShort(short value);

  public void transmitString(String value);
}
