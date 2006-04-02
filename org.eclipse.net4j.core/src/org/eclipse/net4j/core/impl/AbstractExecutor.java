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
import org.eclipse.net4j.core.Task;
import org.eclipse.net4j.core.TaskListener;
import org.eclipse.net4j.spring.impl.ServiceImpl;


public abstract class AbstractExecutor extends ServiceImpl implements Executor
{
  protected int executeCount;

  public void execute(Task task, TaskListener listener) throws Exception
  {
    ++executeCount;
    doExecute(task, listener);
  }

  public int getExecuteCount()
  {
    return executeCount;
  }

  protected abstract void doExecute(Task task, TaskListener listener) throws Exception;
}
