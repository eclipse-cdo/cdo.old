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
package org.eclipse.net4j.core;




public interface Receiver
{
  public boolean receiveBoolean();

  public byte[] receiveBytes();

  public byte receiveByte();

  public char receiveChar();

  public double receiveDouble();

  public float receiveFloat();

  public int receiveInt();

  public long receiveLong();

  public Object receiveObject();

  public short receiveShort();

  public String receiveString();
}
