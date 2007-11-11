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
import org.eclipse.net4j.buddies.protocol.IMembershipContainer;
import org.eclipse.net4j.internal.util.container.SingleDeltaContainerEvent;
import org.eclipse.net4j.internal.util.lifecycle.Lifecycle;
import org.eclipse.net4j.internal.util.lifecycle.LifecycleEvent;
import org.eclipse.net4j.util.container.IContainerDelta;
import org.eclipse.net4j.util.event.IEvent;
import org.eclipse.net4j.util.event.IListener;
import org.eclipse.net4j.util.lifecycle.ILifecycleEvent;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author Eike Stepper
 */
public class MembershipContainer extends Lifecycle implements IMembershipContainer, IListener
{
  private ConcurrentMap<IBuddy, IMembership> buddies = new ConcurrentHashMap<IBuddy, IMembership>();

  private ConcurrentMap<ICollaboration, IMembership> collaborations = new ConcurrentHashMap<ICollaboration, IMembership>();

  public MembershipContainer()
  {
  }

  public void addMembership(IMembership membership)
  {
    if (buddies.putIfAbsent(membership.getBuddy(), membership) == null)
    {
      collaborations.put(membership.getCollaboration(), membership);
      fireEvent(new SingleDeltaContainerEvent<IMembership>(this, membership, IContainerDelta.Kind.ADDED));
      membership.addListener(this);
    }
  }

  public void removeMembership(IMembership membership)
  {
    if (buddies.remove(membership.getBuddy()) != null)
    {
      collaborations.remove(membership.getCollaboration());
      membership.removeListener(this);
      fireEvent(new SingleDeltaContainerEvent<IMembership>(this, membership, IContainerDelta.Kind.REMOVED));
    }
  }

  public IMembership removeMembership(IBuddy buddy)
  {
    IMembership membership = buddies.remove(buddy);
    if (membership != null)
    {
      collaborations.remove(membership.getCollaboration());
      membership.removeListener(this);
      fireEvent(new SingleDeltaContainerEvent<IMembership>(this, membership, IContainerDelta.Kind.REMOVED));
    }

    return membership;
  }

  public IMembership removeMembership(ICollaboration collaboration)
  {
    IMembership membership = collaborations.remove(collaboration);
    if (membership != null)
    {
      buddies.remove(membership.getBuddy());
      membership.removeListener(this);
      fireEvent(new SingleDeltaContainerEvent<IMembership>(this, membership, IContainerDelta.Kind.REMOVED));
    }

    return membership;
  }

  public IMembership[] getMemberships()
  {
    return collaborations.values().toArray(new IMembership[collaborations.size()]);
  }

  public IMembership getMembership(IBuddy buddy)
  {
    return buddies.get(buddy);
  }

  public IMembership getMembership(ICollaboration collaboration)
  {
    return collaborations.get(collaboration);
  }

  public IMembership[] getElements()
  {
    return getMemberships();
  }

  public boolean isEmpty()
  {
    return collaborations.isEmpty();
  }

  public void notifyEvent(IEvent event)
  {
    if (event.getSource() instanceof IMembership)
    {
      IMembership membership = (IMembership)event.getSource();
      notifyMembershipEvent(event);
      if (event instanceof LifecycleEvent)
      {
        LifecycleEvent e = (LifecycleEvent)event;
        if (e.getKind() == ILifecycleEvent.Kind.DEACTIVATED)
        {
          removeMembership(membership);
        }
      }
    }
  }

  protected void notifyMembershipEvent(IEvent event)
  {
  }

  @Override
  protected void doDeactivate() throws Exception
  {
    for (IMembership membership : getMemberships())
    {
      membership.removeListener(this);
    }

    super.doDeactivate();
  }
}
