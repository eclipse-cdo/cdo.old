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
package org.eclipse.net4j.buddies.internal.protocol;

import org.eclipse.net4j.buddies.protocol.IBuddy;
import org.eclipse.net4j.buddies.protocol.IBuddyContainer;
import org.eclipse.net4j.internal.util.container.SingleDeltaContainerEvent;
import org.eclipse.net4j.internal.util.lifecycle.Lifecycle;
import org.eclipse.net4j.internal.util.lifecycle.LifecycleEvent;
import org.eclipse.net4j.util.container.IContainerDelta;
import org.eclipse.net4j.util.event.IEvent;
import org.eclipse.net4j.util.event.IListener;
import org.eclipse.net4j.util.lifecycle.ILifecycleEvent;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Eike Stepper
 */
public class BuddyContainer extends Lifecycle implements IBuddyContainer, IListener
{
  private Map<String, IBuddy> buddies = new HashMap<String, IBuddy>();

  public BuddyContainer(Collection<IBuddy> buddies)
  {
    if (buddies != null)
    {
      for (IBuddy buddy : buddies)
      {
        this.buddies.put(buddy.getUserID(), buddy);
        buddy.addListener(this);
      }
    }
  }

  public BuddyContainer()
  {
  }

  public boolean addBuddy(IBuddy buddy)
  {
    String userID = buddy.getUserID();
    synchronized (buddies)
    {
      if (!buddies.containsKey(userID))
      {
        buddies.put(userID, buddy);
        fireEvent(new SingleDeltaContainerEvent<IBuddy>(this, buddy, IContainerDelta.Kind.ADDED));
        buddy.addListener(this);
        return true;
      }
    }

    return false;
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

  public IBuddy[] getBuddies()
  {
    synchronized (buddies)
    {
      return buddies.values().toArray(new IBuddy[buddies.size()]);
    }
  }

  public IBuddy getBuddy(String userID)
  {
    synchronized (buddies)
    {
      return buddies.get(userID);
    }
  }

  public IBuddy[] getElements()
  {
    return getBuddies();
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
      if (event instanceof LifecycleEvent)
      {
        LifecycleEvent e = (LifecycleEvent)event;
        if (e.getKind() == ILifecycleEvent.Kind.DEACTIVATED)
        {
          removeBuddy(((IBuddy)e.getSource()).getUserID());
        }
      }
    }
  }

  protected void notifyBuddyEvent(IEvent event)
  {
  }

  @Override
  protected void doDeactivate() throws Exception
  {
    for (IBuddy buddy : getBuddies())
    {
      buddy.removeListener(this);
    }

    super.doDeactivate();
  }
}
