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


import org.eclipse.net4j.core.impl.BufferImpl;
import org.eclipse.net4j.spring.Service;


public interface Connector extends Service
{
  public static final int CLIENT = 0;

  public static final int SERVER = 1;

  public Protocol findProtocol(String protocolName);

  public Channel addChannel(String protocolName);

  public Channel createChannel(Protocol protocol);

  public int getChannelCount();

  public Channel getChannel(int id);

  public Channel[] getChannels(String protocolName);

  public Channel[] getChannels();

  public BufferPool getBufferPool();

  public int getType();

  public String getTypeString();

  public boolean isClient();

  public boolean isServer();

  public void removeChannel(Channel channel);

  public void transmit(int channelIndex, BufferImpl buffer);

  public void transmitNegotiation(byte[] data) throws NegotiationException;

  public byte[] receiveNegotiation() throws NegotiationException;

  public boolean isAuthenticated();

  public String getUserName();

  public void setUserName(String userName);

  /**
   * Internal
   */
  public void adjustTransmitterBuffer(BufferImpl transmitterBuffer);
}
