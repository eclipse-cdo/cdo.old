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
package org.eclipse.net4j.internal.fileshare;

import org.eclipse.net4j.buddies.internal.protocol.Message;

/**
 * @author Eike Stepper
 */
public class AddMessage extends Message
{
  private static final long serialVersionUID = 1L;

  private String name;

  private byte[] content;

  public AddMessage(byte[] content, String name)
  {
    this.content = content;
    this.name = name;
  }

  protected AddMessage()
  {
  }

  public String getName()
  {
    return name;
  }

  public byte[] getContent()
  {
    return content;
  }
}
