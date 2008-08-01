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

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.mylyn.tasks.core.AbstractRepositoryConnector;
import org.eclipse.mylyn.tasks.core.ITask;
import org.eclipse.mylyn.tasks.core.RepositoryResponse;
import org.eclipse.mylyn.tasks.core.TaskRepository;
import org.eclipse.mylyn.tasks.core.data.ITaskDataWorkingCopy;
import org.eclipse.mylyn.tasks.core.data.TaskAttribute;
import org.eclipse.mylyn.tasks.core.data.TaskData;
import org.eclipse.mylyn.tasks.core.data.TaskDataModel;

/**
 * @author Eike Stepper
 */
public abstract class TaskDataAction extends TaskAction
{
  public TaskDataAction()
  {
  }

  @Override
  protected final void run(ITask task) throws Exception
  {
    ITaskDataWorkingCopy taskDataState = TASK_DATA_MANAGER.getWorkingCopy(task);
    String connectorKind = taskDataState.getConnectorKind();
    String repositoryUrl = taskDataState.getRepositoryUrl();
    TaskRepository repository = REPOSITORY_MANAGER.getRepository(connectorKind, repositoryUrl);

    TaskDataModel model = new TaskDataModel(repository, task, taskDataState);
    TaskData taskData = model.getTaskData();

    run(repository, task, taskData);
  }

  protected final TaskData postTaskData(TaskRepository repository, ITask task, TaskData taskData) throws CoreException
  {
    AbstractRepositoryConnector connector = REPOSITORY_MANAGER.getRepositoryConnector(repository.getConnectorKind());
    RepositoryResponse response = connector.getTaskDataHandler().postTaskData(repository, taskData, null,
        new NullProgressMonitor());

    String taskId = response.getTaskId();
    TaskData updatedTaskData = connector.getTaskData(repository, taskId, new NullProgressMonitor());
    if (taskData.isNew())
    {
      task = new org.eclipse.mylyn.internal.tasks.core.TaskTask(connector.getConnectorKind(), repository
          .getRepositoryUrl(), updatedTaskData.getTaskId());
    }

    ((org.eclipse.mylyn.internal.tasks.core.data.TaskDataManager)TASK_DATA_MANAGER).putSubmittedTaskData(task,
        updatedTaskData);
    return updatedTaskData;
  }

  protected final String getDescription(TaskData taskData)
  {
    TaskAttribute root = taskData.getRoot();
    TaskAttribute attribute = root.getMappedAttribute(TaskAttribute.DESCRIPTION);
    if (attribute == null)
    {
      attribute = root.getMappedAttribute(TaskAttribute.COMMENT_NEW);
    }

    return attribute != null ? taskData.getAttributeMapper().getValueLabel(attribute) : "";
  }

  protected abstract void run(TaskRepository repository, ITask task, TaskData taskData) throws Exception;
}
