/***************************************************************************
 * Copyright (c) 2004 - 2008 Eike Stepper, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 **************************************************************************/
package org.eclipse.net4j.internal.pop;

import org.eclipse.mylyn.tasks.core.IRepositoryManager;
import org.eclipse.mylyn.tasks.core.ITask;
import org.eclipse.mylyn.tasks.core.data.ITaskDataManager;

/**
 * @author Eike Stepper
 */
public class MylynPopManager extends PopManager
{
  private IRepositoryManager repositoryManager;

  private ITaskDataManager taskDataManager;

  public MylynPopManager(IRepositoryManager repositoryManager, ITaskDataManager taskDataManager)
  {
    checkArgument(repositoryManager, "repositoryManager");
    checkArgument(taskDataManager, "taskDataManager");
    this.repositoryManager = repositoryManager;
    this.taskDataManager = taskDataManager;
  }

  @Override
  public String toString()
  {
    return "MylynPopManager";
  }

  public IRepositoryManager getRepositoryManager()
  {
    return repositoryManager;
  }

  public ITaskDataManager getTaskDataManager()
  {
    return taskDataManager;
  }

  public ITask getTask(String taskId)
  {
    // TODO Implement MylynPopManager.getTask(taskId)
    throw new UnsupportedOperationException("Not yet implemented");
  }
}
