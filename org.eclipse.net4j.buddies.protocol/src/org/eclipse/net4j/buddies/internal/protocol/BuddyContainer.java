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
import org.eclipse.net4j.buddies.protocol.IBuddyContainer;
import org.eclipse.net4j.internal.util.container.SingleDeltaContainerEvent;
import org.eclipse.net4j.internal.util.lifecycle.Lifecycle;
import org.eclipse.net4j.util.container.IContainerDelta;
import org.eclipse.net4j.util.event.IEvent;
import org.eclipse.net4j.util.event.IListener;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Eike Stepper
 */
public class BuddyContainer extends Lifecycle implements IBuddyContainer, IListener
{
  private Map<String, IBuddy> buddies = new HashMap<String, IBuddy>();

  public BuddyContainer()
  {
  }

  public void addBuddy(IBuddy buddy)
  {
    String userID = buddy.getUserID();
    synchronized (buddies)
    {
      if (!buddies.containsKey(userID))
      {
        buddies.put(userID, buddy);
      }
    }

    fireEvent(new SingleDeltaContainerEvent<IBuddy>(this, buddy, IContainerDelta.Kind.ADDED));
    buddy.addListener(this);
  }

  public IBuddy removeBuddy(String userID)
  {
    IBuddy buddy;
    synchronized (buddies)
    {
      buddy = buddies.remove(userID);
    }

    if (buddy != null)
    {
      buddy.removeListener(this);
      fireEvent(new SingleDeltaContainerEvent<IBuddy>(this, buddy, IContainerDelta.Kind.REMOVED));
    }

    return buddy;
  }

  public Map<String, IBuddy> getBuddies()
  {
    synchronized (buddies)
    {
      return Collections.unmodifiableMap(buddies);
    }
  }

  public IBuddy[] getElements()
  {
    synchronized (buddies)
    {
      return buddies.values().toArray(new IBuddy[buddies.size()]);
    }
  }

  public boolean isEmpty()
  {
    synchronized (buddies)
    {
      return buddies.isEmpty();
    }
  }

  public void notifyEvent(IEvent event)
  {
    if (event.getSource() instanceof IBuddy)
    {
      notifyBuddyEvent(event);
    }
  }

  protected void notifyBuddyEvent(IEvent event)
  {
  }
}
