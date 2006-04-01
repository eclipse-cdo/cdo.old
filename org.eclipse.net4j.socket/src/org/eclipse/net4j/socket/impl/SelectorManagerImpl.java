/*******************************************************************************
 * Copyright (c) 2004, 2005, 2006 Eike Stepper, Sympedia Methods and Tools.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Eike Stepper - initial API and implementation
 *******************************************************************************/
package org.eclipse.net4j.socket.impl;


import org.eclipse.net4j.core.SelectionListener;
import org.eclipse.net4j.socket.SelectorManager;
import org.eclipse.net4j.spring.impl.ServiceImpl;
import org.eclipse.net4j.util.Pair;
import org.eclipse.net4j.util.UnderlyingIOException;
import org.eclipse.net4j.util.thread.Worker;

import java.util.Iterator;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;

import java.io.IOException;

import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;


public class SelectorManagerImpl extends ServiceImpl implements SelectorManager
{
  protected transient Controller controller;

  protected transient Selector selector;

  protected transient Queue<Pair<SelectableChannel, SelectionListener>> toBeRegistered = new ConcurrentLinkedQueue();

  public SelectorManagerImpl()
  {
  }

  public void deregister(SelectableChannel selectable)
  {
  }

  public void register(SelectableChannel selectable, SelectionListener listener)
  {
    if (isDebugEnabled()) debug("Ordering registration of " + selectable + " with " + selector);
    toBeRegistered.add(new Pair<SelectableChannel, SelectionListener>(selectable, listener));
  }

  @Override
  protected void activate() throws Exception
  {
    super.activate();
    selector = Selector.open();
    controller = new Controller();
  }

  @Override
  protected void deactivate() throws Exception
  {
    if (controller != null)
    {
      controller.shutdown(200);
      controller = null;
    }

    if (selector != null)
    {
      selector.close();
      selector = null;
    }

    super.deactivate();
  }


  protected final class Controller extends Worker
  {
    public Controller()
    {
      setName(getFullBeanName() + ".Controller");
      startup();
    }

    public long doWorkStep(int progress)
    {
      try
      {
        handleNewSelectables();

        // TODO make configurable
        int count = selector.select(500);
        if (count == 0) return NO_PAUSE;

        Set readyKeys = selector.selectedKeys();
        for (Iterator it = readyKeys.iterator(); it.hasNext();)
        {
          SelectionKey key = (SelectionKey) it.next();
          it.remove();

          try
          {
            if (key.isValid())
            {
              key.interestOps(0);
              if (key.isReadable())
              {
                SelectionListener listener = (SelectionListener) key.attachment();
                if (listener != null)
                {
                  listener.readyForRead(key.channel());
                }
              }
            }
          }
          finally
          {
            if (key.isValid()) key.interestOps(SelectionKey.OP_READ);
          }
        }
      }
      catch (IOException ex)
      {
        throw new UnderlyingIOException(ex);
      }

      return NO_PAUSE;
    }

    protected void handleNewSelectables() throws ClosedChannelException
    {
      Pair<SelectableChannel, SelectionListener> pair;
      while ((pair = toBeRegistered.poll()) != null)
      {
        SelectableChannel selectable = pair.getFirst();
        SelectionListener listener = pair.getSecond();

        if (isDebugEnabled()) debug("Registering " + selectable + " with " + selector);
        // Can't happen (docs): DeadlockDetector.preLock();
        SelectionKey key = selectable.register(selector, SelectionKey.OP_READ, listener);
        //      Can't happen (docs): DeadlockDetector.postLock();
        listener.notifyRegistration(selectable, key);
      }
    }
  }
}