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
import org.eclipse.net4j.buddies.protocol.ICollaboration;
import org.eclipse.net4j.buddies.protocol.IMembership;
import org.eclipse.net4j.internal.util.event.Notifier;

import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.PlatformObject;

/**
 * @author Eike Stepper
 */
public class Membership extends Notifier implements IMembership
{
  private IBuddy buddy;

  private ICollaboration collaboration;

  private long startTime;

  public Membership(IBuddy buddy, ICollaboration collaboration)
  {
    this.buddy = buddy;
    this.collaboration = collaboration;
    startTime = System.currentTimeMillis();
  }

  public IBuddy getBuddy()
  {
    return buddy;
  }

  public ICollaboration getCollaboration()
  {
    return collaboration;
  }

  public long getStartTime()
  {
    return startTime;
  }

  /**
   * @see PlatformObject#getAdapter(Class)
   */
  @SuppressWarnings("unchecked")
  public Object getAdapter(Class adapter)
  {
    return Platform.getAdapterManager().getAdapter(this, adapter);
  }
}
