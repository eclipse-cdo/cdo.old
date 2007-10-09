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
import org.eclipse.net4j.buddies.protocol.IBuddyStateChangedEvent;
import org.eclipse.net4j.buddies.protocol.ICollaboration;
import org.eclipse.net4j.buddies.protocol.ISession;
import org.eclipse.net4j.internal.util.event.Event;
import org.eclipse.net4j.util.event.IEvent;

import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.PlatformObject;

import java.text.MessageFormat;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Eike Stepper
 */
public abstract class Buddy extends CollaborationContainer implements IBuddy
{
  private ISession session;

  private State state = State.AVAILABLE;

  private Set<String> facilityTypes;

  public Buddy(ISession session, Set<String> facilityTypes)
  {
    this.session = session;
    this.facilityTypes = facilityTypes;
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
      IEvent event = new StateChangedEvent(this.state, state);
      this.state = state;
      fireEvent(event);
    }
  }

  public Set<String> getFacilityTypes()
  {
    if (facilityTypes == null)
    {
      facilityTypes = loadFacilityTypes();
    }

    return Collections.unmodifiableSet(facilityTypes);
  }

  public ICollaboration initiate()
  {
    return initiate((Set<IBuddy>)null);
  }

  public ICollaboration initiate(IBuddy buddy)
  {
    HashSet<IBuddy> buddies = new HashSet<IBuddy>();
    buddies.add(buddy);
    return initiate(buddies);
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
  private final class StateChangedEvent extends Event implements IBuddyStateChangedEvent
  {
    private static final long serialVersionUID = 1L;

    private State oldState;

    private State newState;

    public StateChangedEvent(State oldState, State newState)
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
  }
}
