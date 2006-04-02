/***************************************************************************
 * Copyright (c) 2004, 2005, 2006 Eike Stepper, Fuggerstr. 39, 10777 Berlin, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 **************************************************************************/
package org.eclipse.net4j.core.impl;


import org.eclipse.net4j.core.Channel;
import org.eclipse.net4j.core.Multiplexer;
import org.eclipse.net4j.spring.impl.ServiceImpl;
import org.eclipse.net4j.util.thread.Worker;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


public class MultiplexerImpl extends ServiceImpl implements Multiplexer
{
  protected BlockingQueue<Channel> queue = new LinkedBlockingQueue();

  protected Scheduler scheduler;

  public void cancel(Channel channel)
  {
    // TODO Auto-generated method stub
  }

  public void schedule(Channel channel)
  {
    if (isDebugEnabled()) debug("Scheduling channel " + channel);
    queue.offer(channel);
    if (isDebugEnabled()) debug("Scheduled channel " + channel);
  }

  public int getQueueLength()
  {
    return queue.size();
  }

  protected void activate() throws Exception
  {
    scheduler = new Scheduler();
    scheduler.setDaemon(true);
    scheduler.startup();
  }

  protected void deactivate() throws Exception
  {
    scheduler.shutdown(200);
    scheduler = null;
  }

  protected final class Scheduler extends Worker
  {
    public Scheduler()
    {
      super(getFullBeanName() + ".Scheduler");
    }

    public long doWorkStep(int progress)
    {
      try
      {
        Channel channel = queue.take();
        channel.handleTransmission();
      }
      catch (InterruptedException ex)
      {
        return TERMINATE;
      }

      return NO_PAUSE;
    }
  }
}
