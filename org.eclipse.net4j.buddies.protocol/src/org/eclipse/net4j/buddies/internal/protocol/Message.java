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

import org.eclipse.net4j.buddies.protocol.IMessage;
import org.eclipse.net4j.util.StringUtil;

import org.eclipse.core.runtime.PlatformObject;

import java.io.Serializable;

/**
 * @author Eike Stepper
 */
public abstract class Message extends PlatformObject implements IMessage, Serializable
{
  private static final long serialVersionUID = 1L;

  private String senderID;

  protected Message()
  {
  }

  public String getSenderID()
  {
    return senderID;
  }

  public void setSenderID(String senderID)
  {
    this.senderID = senderID;
  }

  protected String encode(String text)
  {
    return text.replaceAll(StringUtil.NL, "\n");
  }

  protected String decode(String text)
  {
    return text.replaceAll("\n", StringUtil.NL);
  }
}