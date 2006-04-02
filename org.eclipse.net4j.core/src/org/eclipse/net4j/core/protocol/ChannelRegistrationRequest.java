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
package org.eclipse.net4j.core.protocol;


import org.eclipse.net4j.core.ControlProtocol;
import org.eclipse.net4j.core.impl.AbstractRequestWithConfirmation;


public class ChannelRegistrationRequest extends AbstractRequestWithConfirmation
{
  protected String protocolName;

  public ChannelRegistrationRequest(String protocolName)
  {
    this.protocolName = protocolName;
  }

  public short getSignalId()
  {
    return ControlProtocol.CHANNEL_REGISTRATION;
  }

  public void request()
  {
    transmitString(protocolName);
  }

  public Object confirm()
  {
    short channelIndex = receiveShort();
    return new Short(channelIndex);
  }
}
