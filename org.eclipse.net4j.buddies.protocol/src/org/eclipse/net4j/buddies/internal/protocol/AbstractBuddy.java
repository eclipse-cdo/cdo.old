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
import org.eclipse.net4j.internal.util.event.Event;
import org.eclipse.net4j.internal.util.event.Notifier;
import org.eclipse.net4j.util.event.IEvent;

/**
 * @author Eike Stepper
 */
public abstract class AbstractBuddy extends Notifier implements IBuddy
{
  private State state = State.AVAILABLE;

  public AbstractBuddy()
  {
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
      super(AbstractBuddy.this);
      this.oldState = oldState;
      this.newState = newState;
    }

    public IBuddy getBuddy()
    {
      return AbstractBuddy.this;
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
