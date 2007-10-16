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
  private long collaborationID;

  private String facilityType;

  private IMessage message;

  public MessageNotification(IChannel channel, long collaborationID, String facilityType, IMessage message)
  {
    super(channel);
    this.collaborationID = collaborationID;
    this.facilityType = facilityType;
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
    out.writeLong(collaborationID);
    out.writeString(facilityType);
    ProtocolUtil.writeMessage(out, message);
  }
}
