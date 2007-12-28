/***************************************************************************
 * Copyright (c) 2004 - 2008 Eike Stepper, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 **************************************************************************/
package org.eclipse.net4j.internal.chat;

import org.eclipse.net4j.buddies.protocol.IMessage;
import org.eclipse.net4j.chat.IChatRoom;

/**
 * @author Eike Stepper
 */
public class ChatRoom extends Chat implements IChatRoom
{
  public ChatRoom()
  {
  }

  @Override
  public void sendComment(String text)
  {
    throw new UnsupportedOperationException();
  }

  @Override
  public void handleMessage(IMessage message)
  {
    sendMessage(message);
  }
}
