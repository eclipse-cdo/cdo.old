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
package org.eclipse.net4j.core.protocol;


import org.eclipse.net4j.core.Indication;
import org.eclipse.net4j.util.ImplementationError;


public class ServerControlProtocol extends AbstractControlProtocol
{
  public int getType()
  {
    return SERVER;
  }

  public Indication createIndication(short signalId)
  {
    switch (signalId)
    {
    case CHANNEL_REGISTRATION:
      return new ChannelRegistrationIndication();

    case CHANNEL_DEREGISTRATION:
      return new ChannelDeregistrationIndication();

    case GET_PROTOCOLS:
      return new GetProtocolsIndication(getProtocolManager());

    case CANCELATION:
      return new CancelationIndication();

    default:
      throw new ImplementationError("Invalid signalId: " + signalId);
    }
  }
}
