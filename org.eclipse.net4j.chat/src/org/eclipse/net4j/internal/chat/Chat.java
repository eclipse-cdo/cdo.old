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

import org.eclipse.net4j.buddies.internal.protocol.Facility;
import org.eclipse.net4j.buddies.protocol.IMessage;
import org.eclipse.net4j.chat.IChat;
import org.eclipse.net4j.chat.IComment;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Eike Stepper
 */
public class Chat extends Facility implements IChat
{
  private List<IComment> comments = new ArrayList<IComment>();

  public Chat()
  {
    super(TYPE);
  }

  public IComment[] getComments()
  {
    synchronized (comments)
    {
      return comments.toArray(new IComment[comments.size()]);
    }
  }

  public void sendComment(String text)
  {
    TextMessage message = new TextMessage(text);
    sendMessage(message);
    addComment(message.getSenderID(), text);
  }

  @Override
  protected void handleMessage(IMessage message)
  {
    if (message instanceof TextMessage)
    {
      addComment(message.getSenderID(), ((TextMessage)message).getText());
    }
  }

  protected void addComment(String senderID, String text)
  {
    Comment comment = new Comment(System.currentTimeMillis(), senderID, text);
    synchronized (comments)
    {
      comments.add(comment);
    }

    fireEvent(new CommentEvent(this, comment));
  }
}
