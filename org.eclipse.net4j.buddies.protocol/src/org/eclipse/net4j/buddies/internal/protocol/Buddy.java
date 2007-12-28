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
import org.eclipse.net4j.buddies.protocol.IBuddyStateEvent;
import org.eclipse.net4j.buddies.protocol.ICollaboration;
import org.eclipse.net4j.buddies.protocol.IMembership;
import org.eclipse.net4j.buddies.protocol.ISession;
import org.eclipse.net4j.internal.util.event.Event;
import org.eclipse.net4j.util.ObjectUtil;
import org.eclipse.net4j.util.event.IEvent;

import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.PlatformObject;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Eike Stepper
 */
public abstract class Buddy extends MembershipContainer implements IBuddy
{
  private ISession session;

  private State state = State.AVAILABLE;

  private Set<String> facilityTypes;

  public Buddy(ISession session, Set<String> facilityTypes)
  {
    this.session = session;
    this.facilityTypes = facilityTypes == null ? null : Collections.unmodifiableSet(facilityTypes);
  }

  public ISession getSession()
  {
    return session;
  }

  public void setSession(ISession session)
  {
    this.session = session;
  }

  public State getState()
  {
    return state;
  }

  public void setState(State state)
  {
    if (this.state != state)
    {
      IEvent event = new BuddyStateEvent(this.state, state);
      this.state = state;
      fireEvent(event);
    }
  }

  public Set<String> getFacilityTypes()
  {
    if (facilityTypes == null)
    {
      facilityTypes = Collections.unmodifiableSet(loadFacilityTypes());
    }

    return facilityTypes;
  }

  public IMembership getMembership(Collaboration collaboration)
  {
    return getMembership(this, collaboration);
  }

  public IMembership removeMembership(Collaboration collaboration)
  {
    return removeMembership(this, collaboration);
  }

  public ICollaboration getCollaboration(long collaborationID)
  {
    for (IMembership membership : getMemberships())
    {
      ICollaboration collaboration = membership.getCollaboration();
      if (collaboration.getID() == collaborationID)
      {
        return collaboration;
      }
    }

    return null;
  }

  public ICollaboration[] getCollaborations()
  {
    List<ICollaboration> collaborations = new ArrayList<ICollaboration>();
    for (IMembership membership : getMemberships())
    {
      ICollaboration collaboration = membership.getCollaboration();
      collaborations.add(collaboration);
    }

    return collaborations.toArray(new ICollaboration[collaborations.size()]);
  }

  public IMembership initiate()
  {
    return initiate((IBuddy)null);
  }

  public IMembership initiate(IBuddy buddy)
  {
    HashSet<IBuddy> buddies = new HashSet<IBuddy>();
    if (buddy != null)
    {
      buddies.add(buddy);
    }

    IMembership[] memberships = initiate(buddies);
    return memberships.length == 0 ? null : memberships[0];
  }

  /**
   * @see PlatformObject#getAdapter(Class)
   */
  @SuppressWarnings("unchecked")
  public Object getAdapter(Class adapter)
  {
    return Platform.getAdapterManager().getAdapter(this, adapter);
  }

  @Override
  public boolean equals(Object obj)
  {
    if (obj == this)
    {
      return true;
    }

    if (obj instanceof IBuddy)
    {
      IBuddy buddy = (IBuddy)obj;
      return ObjectUtil.equals(getUserID(), buddy.getUserID());
    }

    return false;
  }

  @Override
  public int hashCode()
  {
    return ObjectUtil.hashCode(getUserID());
  }

  @Override
  public String toString()
  {
    return MessageFormat.format("{0}[{1}]", getClass().getSimpleName(), getUserID());
  }

  protected Set<String> loadFacilityTypes()
  {
    throw new UnsupportedOperationException();
  }

  /**
   * @author Eike Stepper
   */
  private final class BuddyStateEvent extends Event implements IBuddyStateEvent
  {
    private static final long serialVersionUID = 1L;

    private State oldState;

    private State newState;

    public BuddyStateEvent(State oldState, State newState)
    {
      super(Buddy.this);
      this.oldState = oldState;
      this.newState = newState;
    }

    public IBuddy getBuddy()
    {
      return Buddy.this;
    }

    public State getOldState()
    {
      return oldState;
    }

    public State getNewState()
    {
      return newState;
    }

    @Override
    public String toString()
    {
      return MessageFormat.format("BuddyStateEvent[source={0}, oldState={1}, newState={2}]", getSource(),
          getOldState(), getNewState());
    }
  }
}
