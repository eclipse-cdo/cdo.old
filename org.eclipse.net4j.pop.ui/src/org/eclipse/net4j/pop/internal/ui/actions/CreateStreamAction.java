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
package org.eclipse.net4j.pop.internal.ui.actions;

import org.eclipse.net4j.pop.util.StreamOperationExtractor;

import org.eclipse.mylyn.tasks.core.ITask;
import org.eclipse.mylyn.tasks.core.TaskRepository;
import org.eclipse.mylyn.tasks.core.data.TaskAttribute;
import org.eclipse.mylyn.tasks.core.data.TaskData;

/**
 * @author Eike Stepper
 */
public abstract class CreateStreamAction extends TaskDataAction
{
  private String operation;

  protected CreateStreamAction(String operation)
  {
    this.operation = operation;
  }

  @Override
  protected void run(TaskRepository repository, ITask task, TaskData taskData) throws Exception
  {
    TaskAttribute root = taskData.getRoot();
    TaskAttribute commentAttribute = root.createMappedAttribute(TaskAttribute.COMMENT_NEW);
    commentAttribute.setValue(StreamOperationExtractor.PREFIX_OPERATION + operation);

    postTaskData(repository, task, taskData);
  }

  /**
   * @author Eike Stepper
   */
  public static class Development extends CreateStreamAction
  {
    public Development()
    {
      super(StreamOperationExtractor.CREATED_DEVELOPMENT_STREAM);
    }
  }

  /**
   * @author Eike Stepper
   */
  public static class Maintenance extends CreateStreamAction
  {
    public Maintenance()
    {
      super(StreamOperationExtractor.CREATED_MAINTENANCE_STREAM);
    }
  }

  /**
   * @author Eike Stepper
   */
  public static class Task extends CreateStreamAction
  {
    public Task()
    {
      super(StreamOperationExtractor.CREATED_TASK_STREAM);
    }
  }
}
