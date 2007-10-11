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

import org.eclipse.net4j.chat.IChat;
import org.eclipse.net4j.chat.ITextEvent;
import org.eclipse.net4j.internal.util.event.Event;

/**
 * @author Eike Stepper
 */
public class TextEvent extends Event implements ITextEvent
{
  private static final long serialVersionUID = 1L;

  private long receiveTime;

  private String senderID;

  private String text;

  public TextEvent(IChat chat, long receiveTime, String senderID, String text)
  {
    super(chat);
    this.receiveTime = receiveTime;
    this.senderID = senderID;
    this.text = text;
  }

  public IChat getChat()
  {
    return (IChat)getSource();
  }

  public long getReceiveTime()
  {
    return receiveTime;
  }

  public String getSenderID()
  {
    return senderID;
  }

  public String getText()
  {
    return text;
  }
}
