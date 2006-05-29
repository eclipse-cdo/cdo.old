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
package org.eclipse.net4j.core.impl;


import org.eclipse.net4j.core.BufferPool;
import org.eclipse.net4j.core.Channel;
import org.eclipse.net4j.core.ConnectionManager;
import org.eclipse.net4j.core.Connector;
import org.eclipse.net4j.core.ControlProtocol;
import org.eclipse.net4j.core.Negotiator;
import org.eclipse.net4j.core.NoControlProtocolException;
import org.eclipse.net4j.core.Protocol;
import org.eclipse.net4j.core.ProtocolManager;
import org.eclipse.net4j.core.UnknownProtocolException;
import org.eclipse.net4j.core.protocol.AbstractControlProtocol;
import org.eclipse.net4j.core.protocol.ChannelDeregistrationRequest;
import org.eclipse.net4j.core.protocol.ChannelRegistrationRequest;
import org.eclipse.net4j.spring.ValidationException;
import org.eclipse.net4j.spring.impl.ServiceImpl;
import org.eclipse.net4j.util.ImplementationError;
import org.eclipse.net4j.util.UnderlyingIOException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public abstract class AbstractConnector extends ServiceImpl implements Connector
{
  private BufferPool bufferPool;

  private Negotiator negotiator;

  private ConnectionManager connectionManager;

  private ProtocolManager protocolManager;

  private String userName;

  private transient List<Channel> channels = new ArrayList<Channel>();

  public Negotiator getNegotiator()
  {
    return negotiator;
  }

  public void setNegotiator(Negotiator negotiator)
  {
    doSet("negotiator", negotiator);
  }

  public ConnectionManager getConnectionManager()
  {
    return connectionManager;
  }

  public void setConnectionManager(ConnectionManager connectionManager)
  {
    doSet("connectionManager", connectionManager);
  }

  /**
   * @return Returns the bufferPool.
   */
  public BufferPool getBufferPool()
  {
    return bufferPool;
  }

  /**
   * @param bufferPool
   *          The bufferPool to set.
   */
  public void setBufferPool(BufferPool bufferPool)
  {
    doSet("bufferPool", bufferPool);
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

  public String getUserName()
  {
    return userName;
  }

  public void setUserName(String userName)
  {
    doSet("userName", userName);
  }

  public boolean isAuthenticated()
  {
    return userName != null;
  }

  public Channel addChannel(String protocolName)
  {
    Protocol protocol = findProtocol(protocolName);
    boolean withSignal = true;

    if (channels.isEmpty())
    {
      if (protocolName.equals(AbstractControlProtocol.PROTOCOL_NAME))
      {
        withSignal = false;
      }
      else
      {
        throw new NoControlProtocolException();
      }
    }

    Channel channel = createChannel(protocol);

    if (withSignal)
    {
      Channel basicChannel = getChannel(0);
      ChannelRegistrationRequest signal = new ChannelRegistrationRequest(protocolName);

      try
      {
        basicChannel.transmit(signal);
      }
      catch (Exception ex)
      {
        error("Problem while requesting signal " + signal + " through channel " + basicChannel, ex);
        return null;
      }
    }

    return channel;
  }

  public void removeChannel(Channel channel)
  {
    int channelIndex = channel.getChannelIndex();

    if (channelIndex != 0 && isClient())
    {
      Channel basicChannel = getChannel(0);
      if (basicChannel != null)
      {
        ChannelDeregistrationRequest signal = new ChannelDeregistrationRequest(channelIndex);

        try
        {
          basicChannel.transmit(signal);
        }
        catch (Exception ex)
        {
          error("Problem while requesting signal " + signal + " through channel " + basicChannel,
                  ex);
        }
      }
    }

    channels.set(channelIndex, null);
  }

  public Channel[] getChannels(String protocolName)
  {
    List<Channel> list = new ArrayList<Channel>();

    for (Iterator<Channel> it = channels.iterator(); it.hasNext();)
    {
      Channel channel = it.next();
      Protocol protocol = channel.getProtocol();

      if (protocol != null && protocol.getName().equals(protocolName))
      {
        list.add(channel);
      }
    }

    return list.toArray(new Channel[list.size()]);
  }

  public int getChannelCount()
  {
    return channels.size();
  }

  public Channel[] getChannels()
  {
    return channels.toArray(new Channel[channels.size()]);
  }

  public Channel getChannel(int id)
  {
    // Check if basic channel is already activated
    if (id == 0 && channels.size() == 0)
    {
      try
      {
        Thread.sleep(500);
      }
      catch (InterruptedException ex)
      {
        throw new UnderlyingIOException(ex);
      }
    }

    return (Channel)channels.get(id);
  }

  public boolean isClient()
  {
    return getType() == CLIENT;
  }

  public boolean isServer()
  {
    return getType() == SERVER;
  }

  public String getTypeString()
  {
    return getTypeString(getType());
  }

  public static String getTypeString(int type)
  {
    switch (type)
    {
    case SERVER:
      return "server";
    case CLIENT:
      return "client";
    }

    throw new ImplementationError("Invalid type: " + type);
  }

  protected short findFreeChannelIndex()
  {
    int size = channels.size();
    for (short i = 0; i < size; i++)
    {
      if (channels.get(i) == null) return i;
    }

    channels.add(null);
    return (short)size;
  }

  public Protocol findProtocol(String protocolName)
  {
    Protocol protocol = null;

    if (isServer())
    {
      protocol = protocolManager.lookupServer(protocolName);
    }
    else if (isClient())
    {
      protocol = protocolManager.lookupClient(protocolName);
    }
    else
    {
      throw new ImplementationError("Connector is neither server nor client");
    }

    if (protocol == null)
    {
      throw new UnknownProtocolException("Protocol " + protocolName + " is not registered with "
              + (isServer() ? "server" : "client"));
    }

    return protocol;
  }

  public Channel createChannel(Protocol protocol)
  {
    if (protocol == null) throw new IllegalArgumentException("protocol == null");

    try
    {
      short channelIndex = findFreeChannelIndex();

      if (isDebugEnabled())
      {
        debug("Adding " + protocol.getName() + " channel");
      }

      Channel channel = (Channel)getContainer().getBean("channel");
      channel.setConnector(this);
      channel.setProtocol(protocol);
      channel.setChannelIndex(channelIndex);

      channels.set(channelIndex, channel);
      channel.start();
      return channel;
    }
    catch (Exception ex)
    {
      error("Error while creating channel for protocol " + protocol, ex);
      return null;
    }
  }

  public void releaseBuffer(BufferImpl buffer)
  {
    bufferPool.releaseBuffer(buffer);
  }

  public void adjustTransmitterBuffer(BufferImpl transmitterBuffer)
  {
  }

  @Override
  protected void dump(boolean withInternals)
  {
    List attributes = new ArrayList();
    attributes.add("type = " + (isServer() ? "SERVER" : "CLIENT"));
    super.dump(withInternals, attributes);
  }

  @Override
  protected void validate() throws ValidationException
  {
    super.validate();
    assertNotNull("bufferPool");
    assertNotNull("protocolManager");

    if (isServer())
    {
      assertNotNull("connectionManager");
    }
  }

  @Override
  protected void activate() throws Exception
  {
    super.activate();

    if (negotiator != null)
    {
      negotiator.negotiate(this);
    }

    addChannel(ControlProtocol.PROTOCOL_NAME);

    if (isServer())
    {
      connectionManager.registerConnector(this);
    }
  }

  @Override
  protected void deactivate() throws Exception
  {
    if (isServer())
    {
      connectionManager.deregisterConnector(this);
    }

    for (short i = 0; i < channels.size(); i++)
    {
      Channel channel = channels.get(i);

      if (channel != null)
      {
        channel.stop();
      }
    }

    super.deactivate();
  }
}
