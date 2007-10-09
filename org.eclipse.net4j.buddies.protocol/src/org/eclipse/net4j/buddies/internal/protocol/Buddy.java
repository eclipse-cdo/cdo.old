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
import org.eclipse.net4j.buddies.protocol.IMessage;
import org.eclipse.net4j.buddies.protocol.IBuddyStateChangedEvent;
import org.eclipse.net4j.buddies.protocol.ISession;
import org.eclipse.net4j.internal.util.event.Event;
import org.eclipse.net4j.internal.util.event.Notifier;
import org.eclipse.net4j.util.event.IEvent;

import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.PlatformObject;

/**
 * @author Eike Stepper
 */
public abstract class Buddy extends Notifier implements IBuddy
{
  private ISession session;

  private State state = State.AVAILABLE;

  public Buddy()
  {
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

  public void sendMessage(IMessage message)
  {
    if (message instanceof Message)
    {
      ((Message)message).setSender(this);
    }
  }

  /**
   * @see PlatformObject#getAdapter(Class)
   */
  @SuppressWarnings("unchecked")
  public Object getAdapter(Class adapter)
  {
    return Platform.getAdapterManager().getAdapter(this, adapter);
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
