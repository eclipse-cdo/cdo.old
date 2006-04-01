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
package org.eclipse.net4j.core.impl;


import org.eclipse.net4j.core.RequestWithConfirmation;


public abstract class AbstractRequestWithConfirmation extends AbstractRequest implements
        RequestWithConfirmation
{
  public AbstractRequestWithConfirmation()
  {
  }

  public boolean hasResponse()
  {
    return true;
  }

  public boolean receiveBoolean()
  {
    assertReceivingAllowed();
    return channel.receiveBoolean();
  }

  public byte[] receiveBytes()
  {
    assertReceivingAllowed();
    return channel.receiveBytes();
  }

  public byte receiveByte()
  {
    assertReceivingAllowed();
    return channel.receiveByte();
  }

  public char receiveChar()
  {
    assertReceivingAllowed();
    return channel.receiveChar();
  }

  public double receiveDouble()
  {
    assertReceivingAllowed();
    return channel.receiveDouble();
  }

  public float receiveFloat()
  {
    assertReceivingAllowed();
    return channel.receiveFloat();
  }

  public int receiveInt()
  {
    assertReceivingAllowed();
    return channel.receiveInt();
  }

  public long receiveLong()
  {
    assertReceivingAllowed();
    return channel.receiveLong();
  }

  public Object receiveObject()
  {
    assertReceivingAllowed();
    return channel.receiveObject();
  }

  public short receiveShort()
  {
    assertReceivingAllowed();
    return channel.receiveShort();
  }

  public String receiveString()
  {
    assertReceivingAllowed();
    return channel.receiveString();
  }
}
