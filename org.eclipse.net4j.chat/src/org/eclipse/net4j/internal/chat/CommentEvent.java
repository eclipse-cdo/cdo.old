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

import org.eclipse.net4j.chat.IChat;
import org.eclipse.net4j.chat.IComment;
import org.eclipse.net4j.chat.ICommentEvent;
import org.eclipse.net4j.internal.util.event.Event;

/**
 * @author Eike Stepper
 */
public class CommentEvent extends Event implements ICommentEvent
{
  private static final long serialVersionUID = 1L;

  private IComment comment;

  public CommentEvent(IChat chat, IComment comment)
  {
    super(chat);
    this.comment = comment;
  }

  public IChat getChat()
  {
    return (IChat)getSource();
  }

  public IComment getComment()
  {
    return comment;
  }
}
