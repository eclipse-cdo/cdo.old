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

import org.eclipse.net4j.buddies.internal.protocol.Message;

/**
 * @author Eike Stepper
 */
public class TextMessage extends Message
{
  private static final long serialVersionUID = 1L;

  private String text;

  public TextMessage(String text)
  {
    this.text = encode(text);
  }

  protected TextMessage()
  {
  }

  public String getText()
  {
    return decode(text);
  }
}
