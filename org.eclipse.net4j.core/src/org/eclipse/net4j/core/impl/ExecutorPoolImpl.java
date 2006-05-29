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


import org.eclipse.net4j.core.Executor;

import java.util.Iterator;


public class ExecutorPoolImpl extends AbstractPool
{

  protected int nextExecutorId;

  public ExecutorPoolImpl()
  {
  }

  public Class<Executor> doGetPooledClass(Object key)
  {
    return Executor.class;
  }

  protected Object newPooled(Object key) throws Exception
  {

    Executor executor = (Executor)getContainer().getBean("executor");
    return executor;
  }

  public void deactivate() throws Exception
  {
    for (Iterator queueIt = keyToQueueMap.values().iterator(); queueIt.hasNext();)
    {
      Queue queue = (Queue)queueIt.next();
      for (Iterator executorIt = queue.iterator(); executorIt.hasNext();)
      {
        BlockingExecutorImpl blockingExecutor = (BlockingExecutorImpl)executorIt.next();
        blockingExecutor.stop();
      }
    }

    for (Iterator it = checkouts.values().iterator(); it.hasNext();)
    {
      BlockingExecutorImpl blockingExecutor = (BlockingExecutorImpl)it.next();
      blockingExecutor.stop();
    }

    super.deactivate();
  }

  // @Override
  // public Object get(Object key)
  // {
  // try
  // {
  // return newPooled(key);
  // }
  // catch (Exception ex)
  // {
  // ex.printStackTrace();
  // return null;
  // }
  // }
  //
  // @Override
  // public void put(Object key, Object object)
  // {
  // if (object instanceof Executor)
  // {
  // try
  // {
  // ((Executor)object).stop();
  // }
  // catch (Exception ex)
  // {
  // }
  // }
  // }
}
