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

import org.eclipse.net4j.buddies.protocol.IBuddy;
import org.eclipse.net4j.buddies.protocol.IMessage;

import org.eclipse.core.runtime.PlatformObject;

import java.io.Serializable;

/**
 * @author Eike Stepper
 */
public class Message extends PlatformObject implements IMessage, Serializable
{
  private static final long serialVersionUID = 1L;

  private IBuddy sender;

  public Message()
  {
  }

  public IBuddy getSender()
  {
    return sender;
  }

  protected final void setSender(IBuddy sender)
  {
    this.sender = sender;
  }
}
