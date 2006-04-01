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
package org.eclipse.net4j.embedded.impl;


import org.eclipse.net4j.core.Channel;
import org.eclipse.net4j.core.NegotiationException;
import org.eclipse.net4j.core.Negotiator;
import org.eclipse.net4j.core.impl.AbstractConnector;
import org.eclipse.net4j.core.impl.BufferImpl;
import org.eclipse.net4j.embedded.EmbeddedConnector;
import org.eclipse.net4j.util.ImplementationError;


public abstract class AbstractEmbeddedConnector extends AbstractConnector implements
    EmbeddedConnector
{
  protected EmbeddedConnector peer;

  public void receive(int channelIndex, BufferImpl buffer)
  {
    Channel channel = getChannel(channelIndex);
    channel.notifyData(buffer);
  }

  @Override
  public Negotiator getNegotiator()
  {
    throw new ImplementationError("Negotiation is not supported for embedded transport");
  }

  @Override
  public void setNegotiator(Negotiator negotiator)
  {
    throw new ImplementationError("Negotiation is not supported for embedded transport");
  }

  public byte[] receiveNegotiation() throws NegotiationException
  {
    throw new ImplementationError("Negotiation is not supported for embedded transport");
  }

  public void transmitNegotiation(byte[] data) throws NegotiationException
  {
    throw new ImplementationError("Negotiation is not supported for embedded transport");
  }

  /**
   * @return Returns the peer.
   */
  public EmbeddedConnector getPeer()
  {
    return peer;
  }

  /**
   * @param peer The peer to set.
   */
  public void setPeer(EmbeddedConnector peer)
  {
    doSet("peer", peer);
  }

  public void transmit(int channelIndex, BufferImpl buffer)
  {
    peer.receive(channelIndex, buffer);
  }
}