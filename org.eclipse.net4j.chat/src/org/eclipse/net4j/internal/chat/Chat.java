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

import org.eclipse.net4j.buddies.protocol.ICollaboration;
import org.eclipse.net4j.buddies.protocol.IMessage;
import org.eclipse.net4j.chat.IChat;
import org.eclipse.net4j.internal.util.lifecycle.Lifecycle;

/**
 * @author Eike Stepper
 */
public class Chat extends Lifecycle implements IChat
{

  public Chat()
  {
  }

  public ICollaboration getCollaboration()
  {
    return null;
  }

  public String getType()
  {
    return null;
  }

  public void handleMessage(IMessage message)
  {
  }

}
