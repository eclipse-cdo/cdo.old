/***************************************************************************
 * Copyright (c) 2004-2006 Eike Stepper, Fuggerstr. 39, 10777 Berlin, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 **************************************************************************/
package org.eclipse.net4j.core.impl;


import org.eclipse.net4j.core.Channel;
import org.eclipse.net4j.core.Protocol;
import org.eclipse.net4j.core.ProtocolManager;
import org.eclipse.net4j.spring.ValidationException;
import org.eclipse.net4j.spring.impl.ServiceImpl;
import org.eclipse.net4j.util.ImplementationError;

import java.util.HashSet;
import java.util.Set;


public abstract class AbstractProtocol extends ServiceImpl implements Protocol
{
  private ProtocolManager protocolManager;

  private Set<Channel> channels = new HashSet<Channel>();

  public static String typeString(int type)
  {
    switch (type)
    {
    case SERVER:
      return "server";
    case CLIENT:
      return "client";
    case SYMMETRIC:
      return "symmetric";
    default:
      throw new ImplementationError("Invalid type: " + type);
    }
  }

  public String getTypeString()
  {
    return typeString(getType());
  }

  public boolean isClient()
  {
    return (getType() & CLIENT) > 0;
  }

  public boolean isServer()
  {
    return (getType() & SERVER) > 0;
  }

  /**
   * @return Returns the protocolManager.
   */
  public ProtocolManager getProtocolManager()
  {
    return protocolManager;
  }

  /**
   * @param protocolManager
   *          The protocolManager to set.
   */
  public void setProtocolManager(ProtocolManager protocolManager)
  {
    doSet("protocolManager", protocolManager);
  }

  /**
   * @return Returns the channels.
   */
  public Channel[] getChannels()
  {
    return channels.toArray(new Channel[channels.size()]);
  }

  public void registerChannel(Channel channel) throws Exception
  {
    channels.add(channel);
  }

  public void deregisterChannel(Channel channel) throws Exception
  {
    channels.remove(channel);
  }

  protected void validate() throws ValidationException
  {
    super.validate();
    assertNotNull("protocolManager");
  }

  protected void activate() throws Exception
  {
    protocolManager.register(this);
  }

  protected void deactivate() throws Exception
  {
    protocolManager.deregister(this);
  }

}
