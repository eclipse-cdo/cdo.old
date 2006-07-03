/***************************************************************************
 * Copyright (c) 2004-2006 Eike Stepper, Fuggerstr. 39, 10777 Berlin, Germany.
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
import org.eclipse.net4j.spring.ValidationException;
import org.eclipse.net4j.util.thread.Worker;

import java.util.LinkedList;
import java.util.List;


public class QueueingExecutorImpl extends AbstractExecutor
{
  private transient List queue = new LinkedList();

  // private transient TaskInfo currentTaskInfo;

  private transient Worker monitor;

  protected void activate() throws Exception
  {
    super.activate();
    monitor = new Monitor();
    monitor.setDaemon(true);
    monitor.startup();
  }

  protected void deactivate() throws Exception
  {
    super.deactivate();
    monitor.shutdown(200);
    monitor = null;
  }

  protected void validate() throws ValidationException
  {
    super.validate();
  }

  protected void doExecute(Task task, TaskListener listener)
  {
    synchronized (queue)
    {
      queue.add(new TaskInfo(task, listener));
      queue.notifyAll();
    }
  }

  private static class TaskInfo
  {
    private Task task;

    private TaskListener listener;

    public TaskInfo(Task task, TaskListener listener)
    {
      this.task = task;
      this.listener = listener;
    }

    public TaskListener getListener()
    {
      return listener;
    }

    public Task getTask()
    {
      return task;
    }
  }

  private class Monitor extends Worker
  {
    public Monitor()
    {
      super(getFullBeanName() + ".Monitor");
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.net4j.util.thread.Worker#doWorkStep(int)
     */
    protected long doWorkStep(int progress)
    {
      TaskInfo taskInfo;

      synchronized (queue)
      {
        try
        {
          while (queue.isEmpty())
          {
            doWait(queue);
          }
        }
        catch (InterruptedException ex)
        {
          return TERMINATE;
        }

        taskInfo = (TaskInfo)queue.remove(0);
      }

      try
      {
        taskInfo.getTask().execute();

        if (taskInfo.getListener() != null)
        {
          taskInfo.getListener().notifyFinished(taskInfo.getTask());
        }
      }
      catch (Exception ex)
      {
        // TODO notify Listeners!
        error("Error while executing task " + taskInfo.getTask(), ex);
      }

      // TODO workerPool.put(BlockingExecutorImpl.this);
      return NO_PAUSE;
    }
  }
}
