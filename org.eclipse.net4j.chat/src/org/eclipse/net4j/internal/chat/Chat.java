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
package org.eclipse.net4j.internal.chat;

import org.eclipse.net4j.buddies.internal.protocol.Facility;
import org.eclipse.net4j.buddies.protocol.IMessage;
import org.eclipse.net4j.chat.IChat;
import org.eclipse.net4j.chat.ITextMessage;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Eike Stepper
 */
public class Chat extends Facility implements IChat
{
  private List<String> messages = new ArrayList<String>();

  public Chat()
  {
    super(ChatFactory.TYPE);
  }

  public String[] getMessages()
  {
    synchronized (messages)
    {
      return messages.toArray(new String[messages.size()]);
    }
  }

  public void sendMessage(String text)
  {
    sendMessage(new TextMessage(text));
  }

  public void handleMessage(IMessage message)
  {
    if (message instanceof ITextMessage)
    {

    }
  }
}
