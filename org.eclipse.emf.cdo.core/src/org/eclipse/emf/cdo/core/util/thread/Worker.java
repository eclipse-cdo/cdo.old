/***************************************************************************
 * Copyright (c) 2004, 2005, 2006 Eike Stepper, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 **************************************************************************/
package org.eclipse.emf.cdo.core.util.thread;


import org.eclipse.net4j.util.om.trace.ContextTracer;

import org.eclipse.emf.cdo.core.ImplementationError;
import org.eclipse.emf.cdo.core.internal.CDOCore;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public abstract class Worker extends Thread
{
  public static final long TERMINATE = -1;

  public static final long NO_PAUSE = 0;

  private static final ContextTracer TRACER = new ContextTracer(CDOCore.DEBUG_WORKER, Worker.class);

  private List<ProgressListener> progressListeners;

  private List<ShutdownListener> shutdownListeners;

  private int progress;

  private boolean running;

  private Object waitMonitor;

  /**
   * 
   */
  public Worker()
  {
    super();
  }

  /**
   * @param target
   */
  public Worker(Runnable target)
  {
    super(target);
  }

  /**
   * @param name
   */
  public Worker(String name)
  {
    super(name);
  }

  /**
   * @param group
   * @param target
   */
  public Worker(ThreadGroup group, Runnable target)
  {
    super(group, target);
  }

  /**
   * @param target
   * @param name
   */
  public Worker(Runnable target, String name)
  {
    super(target, name);
  }

  /**
   * @param group
   * @param name
   */
  public Worker(ThreadGroup group, String name)
  {
    super(group, name);
  }

  /**
   * @param group
   * @param target
   * @param name
   */
  public Worker(ThreadGroup group, Runnable target, String name)
  {
    super(group, target, name);
  }

  /**
   * @param group
   * @param target
   * @param name
   * @param stackSize
   */
  public Worker(ThreadGroup group, Runnable target, String name, long stackSize)
  {
    super(group, target, name, stackSize);
  }

  public String getLabel()
  {
    String name = getName();
    return name == null ? toString() : name;
  }

  /**
   * @return Returns the running.
   */
  public boolean isRunning()
  {
    return running;
  }

  /* (non-Javadoc)
   * @see java.lang.Runnable#run()
   */
  public final void run()
  {
    notifyProgress();

    try
    {
      while (running && !isInterrupted())
      {
        if (progress == Integer.MAX_VALUE)
        {
          progress = 0;
        }
        else
        {
          ++progress;
        }

        long pause = doWorkStep(progress);
        notifyProgress();

        if (pause == TERMINATE)
        {
          break;
        }

        if (pause > 0)
        {
          try
          {
            Thread.sleep(pause);
          }
          catch (InterruptedException ex)
          {
            if (TRACER.isEnabled())
            {
              TRACER.trace("Interrupted while pausing worker " + getLabel());
            }

            break;
          }
        }
      }
    }
    catch (Throwable t)
    {
      CDOCore.LOG.error("Error in worker " + getLabel(), t);
    }

    notifyShutdown();
  }

  protected void doWait(Object object) throws InterruptedException
  {
    synchronized (this)
    {
      waitMonitor = object;
    }

    DeadlockDetector.wait(waitMonitor);

    synchronized (this)
    {
      waitMonitor = null;
    }

    if (!running)
    {
      throw new InterruptedException();
    }
  }

  /**
   * 
   * @param progress
   * @return The duration to sleep after this step in milliseconds.
   */
  protected abstract long doWorkStep(int progress);

  /* (non-Javadoc)
   * @see java.lang.Thread#start()
   */
  public final void start()
  {
    throw new ImplementationError("use startup()");
  }

  public void startup()
  {
    running = true;
    super.start();
  }

  public void shutdown()
  {
    shutdown(0);
  }

  public void shutdown(long timeoutMillis)
  {
    if (TRACER.isEnabled())
    {
      TRACER.trace("Shutting down worker " + getLabel());
    }

    running = false;

    synchronized (this)
    {
      if (waitMonitor != null)
      {
        synchronized (waitMonitor)
        {
          waitMonitor.notifyAll();
        }
      }
    }

    try
    {
      join(timeoutMillis);
    }
    catch (InterruptedException ex)
    {
      if (TRACER.isEnabled())
      {
        TRACER.trace(ex);
      }
    }

    if (running)
    {
      if (TRACER.isEnabled())
      {
        TRACER.trace("Shutdown timeout expired. Interrupting worker " + getLabel());
      }

      interrupt();

      try
      {
        join();
      }
      catch (InterruptedException ex)
      {
        if (TRACER.isEnabled())
        {
          TRACER.trace(ex);
        }
      }
    }
  }

  public void addProgressListener(ProgressListener listener)
  {
    if (progressListeners == null)
    {
      progressListeners = new ArrayList<ProgressListener>();
    }

    progressListeners.add(listener);
  }

  public void removeProgressListener(ProgressListener listener)
  {
    if (progressListeners != null)
    {
      progressListeners.remove(listener);
    }
  }

  public void addShutdownListener(ShutdownListener listener)
  {
    if (shutdownListeners == null)
    {
      shutdownListeners = new ArrayList<ShutdownListener>();
    }
    shutdownListeners.add(listener);
  }

  public void removeShutdownListener(ShutdownListener listener)
  {
    if (shutdownListeners != null)
    {
      shutdownListeners.remove(listener);
    }
  }

  protected void notifyProgress()
  {
    if (progressListeners != null)
    {
      for (Iterator<ProgressListener> it = progressListeners.iterator(); it.hasNext();)
      {
        ProgressListener listener = it.next();
        listener.notifyProgress(this, progress);
      }
    }
  }

  protected void notifyShutdown()
  {
    if (shutdownListeners != null)
    {
      for (Iterator<ShutdownListener> it = shutdownListeners.iterator(); it.hasNext();)
      {
        ShutdownListener listener = it.next();
        listener.notifyShutdown(this);
      }
    }
  }


  public interface ProgressListener
  {
    public void notifyProgress(Worker worker, int progress);
  }


  public interface ShutdownListener
  {
    public void notifyShutdown(Worker worker);
  }
}
