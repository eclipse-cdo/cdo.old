/***************************************************************************
 * Copyright (c) 2004, 2005, 2006 Eike Stepper, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 **************************************************************************/
package org.eclipse.net4j.core.protocol;


import org.eclipse.net4j.core.Channel;
import org.eclipse.net4j.core.Connector;
import org.eclipse.net4j.core.ControlProtocol;
import org.eclipse.net4j.core.impl.AbstractIndicationWithResponse;
import org.eclipse.net4j.util.ThreadInterruptedException;


public class CancelationIndication extends AbstractIndicationWithResponse
{
  public CancelationIndication()
  {
  }

  public short getSignalId()
  {
    return ControlProtocol.CANCELATION;
  }

  public void indicate()
  {
    short channelIndex = receiveShort();
    String code = receiveString();

    Connector connector = getChannel().getConnector();
    Channel channel = connector.getChannel(channelIndex);
    channel.cancel(code);

    try
    {
      Thread.sleep(250);
    }
    catch (InterruptedException ex)
    {
      throw new ThreadInterruptedException(ex);
    }
  }

  public void respond()
  {
  }
}
