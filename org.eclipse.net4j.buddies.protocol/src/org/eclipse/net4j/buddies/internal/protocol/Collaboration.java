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
import org.eclipse.net4j.buddies.protocol.IMessage;

/**
 * @author Eike Stepper
 */
public abstract class Collaboration extends BuddyContainer implements ICollaboration
{
  private String id;

  private Visibility visibility;

  public Collaboration(String id)
  {
    this.id = id;
  }

  public String getID()
  {
    return id;
  }

  public Visibility getVisibility()
  {
    return visibility;
  }

  public boolean isPublic()
  {
    return visibility == Visibility.PUBLIC;
  }

  public void notifyMessage(IMessage message)
  {
    fireEvent(new MessageEvent(this, message));
  }
}
