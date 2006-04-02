/***************************************************************************
 * Copyright (c) 2004, 2005, 2006 Eike Stepper, Fuggerstr. 39, 10777 Berlin, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 **************************************************************************/
package org.eclipse.emf.cdo.core.protocol;


import org.eclipse.net4j.core.Channel;


public final class ResourceChangeInfo
{
  public static final byte NONE = 0;

  public static final byte ADDED = 1;

  public static final byte REMOVED = 2;

  private byte changeKind;

  private int rid;

  private String path;

  public ResourceChangeInfo(byte changeKind, int rid, String path)
  {
    this.changeKind = changeKind;
    this.rid = rid;
    this.path = path;
  }

  public ResourceChangeInfo(Channel channel) throws NoMoreResourceChangesException
  {
    changeKind = channel.receiveByte();
    if (changeKind == NONE) throw new NoMoreResourceChangesException();
    rid = channel.receiveInt();
    path = channel.receiveString();
  }

  public byte getChangeKind()
  {
    return changeKind;
  }

  public String getPath()
  {
    return path;
  }

  public int getRID()
  {
    return rid;
  }

  public void transmit(Channel channel)
  {
    channel.transmitByte(changeKind);
    channel.transmitInt(rid);
    channel.transmitString(path);
  }
}
