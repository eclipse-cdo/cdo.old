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
package org.eclipse.net4j.core.impl;


import org.eclipse.net4j.core.Executor;
import org.eclipse.net4j.core.Pool;
import org.eclipse.net4j.core.Task;
import org.eclipse.net4j.core.TaskListener;
import org.eclipse.net4j.spring.ValidationException;
import org.eclipse.net4j.util.ImplementationError;

import java.util.HashMap;


public class DispatchingExecutorImpl extends AbstractExecutor implements TaskListener
{
  protected HashMap checkouts = new HashMap(211);

  protected Pool executorPool;

  protected static final class TaskInfo
  {
    protected Executor executor;

    protected TaskListener listener;

    public TaskInfo(Executor executor, TaskListener listener)
    {
      this.executor = executor;
      this.listener = listener;
    }

    public Executor getExecutor()
    {
      return executor;
    }

    public TaskListener getListener()
    {
      return listener;
    }
  }

  protected void doExecute(final Task task, TaskListener listener) throws Exception
  {
    // final Exception[] exception = new Exception[1];
    // checkouts.put(task, new TaskInfo(/* executor */null, listener));
    // executorService.execute(new Runnable()
    // {
    // public void run()
    // {
    // try
    // {
    // task.execute();
    // }
    // catch (Exception ex)
    // {
    // exception[0] = ex;
    // }
    // }
    // });
    //
    // if (exception[0] != null)
    // {
    // throw exception[0];
    // }

    Executor executor = (Executor)executorPool.get();
    checkouts.put(task, new TaskInfo(executor, listener));
    executor.execute(task, this);
  }

  public void notifyFinished(Task task)
  {
    TaskInfo info = (TaskInfo)checkouts.remove(task);
    if (info == null) throw new ImplementationError("task not executed by this dispatcher");

    executorPool.put(info.getExecutor());
    if (info.getListener() != null)
    {
      info.getListener().notifyFinished(task);
    }
  }

  /**
   * @return Returns the executorPool.
   */
  public Pool getExecutorPool()
  {
    return executorPool;
  }

  /**
   * @param executorPool
   *          The executorPool to set.
   */
  public void setExecutorPool(Pool executorPool)
  {
    doSet("executorPool", executorPool);
  }

  protected void validate() throws ValidationException
  {
    assertNotNull("executorPool");
    // executorService = Executors.newCachedThreadPool();
  }
}
