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


import org.eclipse.net4j.core.Task;
import org.eclipse.net4j.core.TaskListener;
import org.eclipse.net4j.util.thread.Worker;


public class BlockingExecutorImpl extends AbstractExecutor
{
  private transient WorkerThread workerThread;

  private transient TaskListener listener;

  protected void activate() throws Exception
  {
    super.activate();
    workerThread = new WorkerThread();
    workerThread.startup();
  }

  protected void deactivate() throws Exception
  {
    workerThread.shutdown(200);
    workerThread = null;
    super.deactivate();
  }

  protected void doExecute(Task task, TaskListener listener)
  {
    this.listener = listener;
    if (workerThread != null)
    {
      workerThread.setTask(task);
    }
  }

  protected class WorkerThread extends Worker
  {
    protected Task task;

    public WorkerThread()
    {
      super(getFullBeanName() + ".Worker");
    }

    public long doWorkStep(int progress)
    {
      synchronized (this)
      {
        try
        {
          while (task == null)
          {
            doWait(this);
          }
        }
        catch (InterruptedException ex)
        {
          return TERMINATE;
        }

        tryExecute();
      }

      // TODO workerPool.put(BlockingExecutorImpl.this);
      return NO_PAUSE;
    }

    /**
     * 
     */
    private void tryExecute()
    {
      if (task != null)
      {
        try
        {
          task.execute();

          if (listener != null)
          {
            listener.notifyFinished(task);
          }
        }
        catch (Exception ex)
        {
          // TODO notify Listeners!
          error("Error while executing task " + task, ex);
        }

        task = null;
        notifyAll();
      }
    }

    public void setTask(Task newTask)
    {
      synchronized (this)
      {
        while (task != null)
        {
          try
          {
            task.wait();
          }
          catch (InterruptedException ex)
          {
            error("Error while waiting for task " + task, ex);
            return;
          }
        }

        task = newTask;
        notifyAll();
      }

      if (isDebugEnabled())
      {
        debug("Set task = " + newTask);
      }
    }
  }
}
