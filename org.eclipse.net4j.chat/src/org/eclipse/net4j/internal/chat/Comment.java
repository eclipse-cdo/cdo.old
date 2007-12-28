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

import org.eclipse.net4j.chat.IComment;

import java.io.Serializable;

/**
 * @author Eike Stepper
 */
public class Comment implements IComment, Serializable
{
  private static final long serialVersionUID = 1L;

  private long receiveTime;

  private String senderID;

  private String text;

  public Comment(long receiveTime, String senderID, String text)
  {
    this.receiveTime = receiveTime;
    this.senderID = senderID;
    this.text = text;
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
