/***************************************************************************
 * Copyright (c) 2004 - 2007 Eike Stepper, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 **************************************************************************/
package org.eclipse.net4j.buddies.internal.protocol;

import org.eclipse.net4j.IChannel;
import org.eclipse.net4j.buddies.protocol.IMessage;
import org.eclipse.net4j.buddies.protocol.ProtocolUtil;
import org.eclipse.net4j.signal.Request;
import org.eclipse.net4j.util.io.ExtendedDataOutputStream;

import java.io.IOException;

/**
 * @author Eike Stepper
 */
public class MessageNotification extends Request
{
  private IMessage message;

  public MessageNotification(IChannel channel, IMessage message)
  {
    super(channel);
    this.message = message;
  }

  @Override
  protected short getSignalID()
  {
    return ProtocolConstants.SIGNAL_MESSAGE;
  }

  @Override
  protected void requesting(ExtendedDataOutputStream out) throws IOException
  {
    ProtocolUtil.writeMessage(out, message);
  }
}
