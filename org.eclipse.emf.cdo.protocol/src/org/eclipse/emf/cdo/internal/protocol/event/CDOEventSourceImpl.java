/***************************************************************************
 * Copyright (c) 2004-2007 Eike Stepper, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 **************************************************************************/
package org.eclipse.emf.cdo.internal.protocol.event;

import org.eclipse.emf.cdo.internal.protocol.bundle.CDOProtocol;
import org.eclipse.emf.cdo.protocol.event.CDOEvent;
import org.eclipse.emf.cdo.protocol.event.CDOEventListener;
import org.eclipse.emf.cdo.protocol.event.CDOEventSource;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author Eike Stepper
 */
public class CDOEventSourceImpl implements CDOEventSource
{
  private Queue<CDOEventListener> listeners = new ConcurrentLinkedQueue();

  public CDOEventSourceImpl()
  {
  }

  public CDOEventListener[] getListeners()
  {
    synchronized (listeners)
    {
      return listeners.toArray(new CDOEventListener[listeners.size()]);
    }
  }

  public void addListener(final CDOEventListener listener)
  {
    synchronized (listeners)
    {
      listeners.add(listener);
    }
  }

  public void removeListener(final CDOEventListener listener)
  {
    synchronized (listeners)
    {
      listeners.remove(listener);
    }
  }

  public void fireObjectEvent(final CDOEvent event, CDOEventListener excludedListener)
  {
    event.getSources().add(this);
    for (CDOEventListener listener : getListeners())
    {
      if (listener != excludedListener)
      {
        try
        {
          listener.notifyCDOEvent(event);
        }
        catch (Exception ex)
        {
          CDOProtocol.LOG.error(ex);
        }
      }
    }
  }

  public void fireObjectEvent(final CDOEvent event)
  {
    fireObjectEvent(event, null);
  }
}
