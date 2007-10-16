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

import org.eclipse.net4j.buddies.protocol.ICollaboration;
import org.eclipse.net4j.buddies.protocol.IFacility;
import org.eclipse.net4j.buddies.protocol.IMessage;
import org.eclipse.net4j.internal.util.lifecycle.Lifecycle;

import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.PlatformObject;

/**
 * @author Eike Stepper
 */
public abstract class Facility extends Lifecycle implements IFacility
{
  private String type;

  private Collaboration collaboration;

  public Facility(String type)
  {
    this.type = type;
  }

  public String getType()
  {
    return type;
  }

  public Collaboration getCollaboration()
  {
    return collaboration;
  }

  public void setCollaboration(ICollaboration collaboration)
  {
    this.collaboration = (Collaboration)collaboration;
  }

  /**
   * @see PlatformObject#getAdapter(Class)
   */
  @SuppressWarnings("unchecked")
  public Object getAdapter(Class adapter)
  {
    return Platform.getAdapterManager().getAdapter(this, adapter);
  }

  public void sendMessage(IMessage message)
  {
    collaboration.sendMessage(collaboration.getID(), type, message);
  }

  protected abstract void handleMessage(IMessage message);
}
