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
import org.eclipse.net4j.buddies.protocol.ICollaborationContainer;
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
public class CollaborationContainer extends Lifecycle implements ICollaborationContainer, IListener
{
  private Map<Long, ICollaboration> collaborations = new HashMap<Long, ICollaboration>();

  public CollaborationContainer()
  {
  }

  public void addCollaboration(ICollaboration collaboration)
  {
    long id = collaboration.getID();
    synchronized (collaborations)
    {
      if (!collaborations.containsKey(id))
      {
        collaborations.put(id, collaboration);
      }
    }

    fireEvent(new SingleDeltaContainerEvent<ICollaboration>(this, collaboration, IContainerDelta.Kind.ADDED));
    collaboration.addListener(this);
  }

  public ICollaboration removeCollaboration(String userID)
  {
    ICollaboration collaboration;
    synchronized (collaborations)
    {
      collaboration = collaborations.remove(userID);
    }

    if (collaboration != null)
    {
      collaboration.removeListener(this);
      fireEvent(new SingleDeltaContainerEvent<ICollaboration>(this, collaboration, IContainerDelta.Kind.REMOVED));
    }

    return collaboration;
  }

  public Map<Long, ICollaboration> getCollaborations()
  {
    return Collections.unmodifiableMap(collaborations);
  }

  public ICollaboration[] getElements()
  {
    synchronized (collaborations)
    {
      return collaborations.values().toArray(new ICollaboration[collaborations.size()]);
    }
  }

  public boolean isEmpty()
  {
    synchronized (collaborations)
    {
      return collaborations.isEmpty();
    }
  }

  public void notifyEvent(IEvent event)
  {
    if (event.getSource() instanceof ICollaboration)
    {
      notifyCollaborationEvent(event);
    }
  }

  protected void notifyCollaborationEvent(IEvent event)
  {
  }
}
