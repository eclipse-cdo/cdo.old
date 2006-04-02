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
package org.eclipse.net4j.core.protocol;


import org.eclipse.net4j.core.Channel;
import org.eclipse.net4j.core.Connector;
import org.eclipse.net4j.core.ControlProtocol;
import org.eclipse.net4j.core.Protocol;
import org.eclipse.net4j.core.impl.AbstractIndicationWithResponse;


public class ChannelRegistrationIndication extends AbstractIndicationWithResponse
{
  private Channel newChannel;

  public ChannelRegistrationIndication()
  {
  }

  public short getSignalId()
  {
    return ControlProtocol.CHANNEL_REGISTRATION;
  }

  public void indicate()
  {
    String protocolName = receiveString();
    Connector connector = channel.getConnector();
    Protocol protocol = connector.findProtocol(protocolName);
    newChannel = connector.createChannel(protocol);
  }

  public void respond()
  {
    transmitShort(newChannel.getChannelIndex());
  }
}
