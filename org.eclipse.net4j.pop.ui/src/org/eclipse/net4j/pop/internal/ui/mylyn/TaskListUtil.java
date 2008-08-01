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
package org.eclipse.net4j.pop.internal.ui.mylyn;

import org.eclipse.mylyn.internal.tasks.core.ITaskListChangeListener;
import org.eclipse.mylyn.internal.tasks.core.RepositoryQuery;
import org.eclipse.mylyn.internal.tasks.core.TaskContainerDelta;
import org.eclipse.mylyn.internal.tasks.core.TaskList;
import org.eclipse.mylyn.internal.tasks.ui.TasksUiPlugin;
import org.eclipse.mylyn.tasks.core.IRepositoryElement;
import org.eclipse.mylyn.tasks.core.ITask;
import org.eclipse.mylyn.tasks.core.ITaskContainer;

import java.util.Map;
import java.util.Set;

/**
 * @author Eike Stepper
 */
public final class TaskListUtil
{
  private static ITaskListChangeListener listener = new ITaskListChangeListener()
  {
    public void containersChanged(Set<TaskContainerDelta> deltas)
    {
      for (TaskContainerDelta delta : deltas)
      {
        TaskContainerDelta.Kind kind = delta.getKind();
        System.out.println(kind);

        IRepositoryElement element = delta.getElement();
        System.out.println(element);

        ITaskContainer container = delta.getParent();
        System.out.println(container);
        System.out.println();

        switch (kind)
        {
        case ADDED:
          break;

        case REMOVED:
          break;

        case CONTENT:
          break;

        case DELETED:
          break;

        case ROOT:
          break;
        }
      }
    }
  };

  private TaskListUtil()
  {
  }

  public static void test()
  {
    TaskList taskList = TasksUiPlugin.getTaskList();
    taskList.addChangeListener(listener);
    Set<RepositoryQuery> queries = taskList.getQueries();
    for (RepositoryQuery query : queries)
    {
      System.out.println("QUERY:");
      String handleIdentifier = query.getHandleIdentifier();
      System.out.println(handleIdentifier);

      String connectorKind = query.getConnectorKind();
      System.out.println(connectorKind);

      String repositoryUrl = query.getRepositoryUrl();
      System.out.println(repositoryUrl);

      String summary = query.getSummary();
      System.out.println(summary);

      String url = query.getUrl();
      System.out.println(url);

      Map<String, String> attributes = query.getAttributes();
      System.out.println(attributes);
      System.out.println();
    }

    ITask task = taskList.getTask("https://bugs.eclipse.org/bugs", "204890");
    System.out.println(task);
  }
}
