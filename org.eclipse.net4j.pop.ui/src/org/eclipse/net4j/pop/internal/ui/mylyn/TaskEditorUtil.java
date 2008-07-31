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

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.mylyn.commons.core.StatusHandler;
import org.eclipse.mylyn.tasks.core.AbstractRepositoryConnector;
import org.eclipse.mylyn.tasks.core.ITask;
import org.eclipse.mylyn.tasks.core.TaskRepository;
import org.eclipse.mylyn.tasks.core.ITask.SynchronizationState;
import org.eclipse.mylyn.tasks.ui.AbstractRepositoryConnectorUi;
import org.eclipse.mylyn.tasks.ui.TasksUi;
import org.eclipse.mylyn.tasks.ui.editors.TaskEditor;
import org.eclipse.mylyn.tasks.ui.editors.TaskEditorInput;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

/**
 * @author Eike Stepper
 */
public final class TaskEditorUtil
{
  private TaskEditorUtil()
  {
  }

  public static TaskEditor openTask(ITask task)
  {
    Assert.isNotNull(task);
    IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
    if (window == null)
    {
      return null;
    }

    TaskRepository taskRepository = TasksUi.getRepositoryManager().getRepository(task.getConnectorKind(),
        task.getRepositoryUrl());
    IEditorInput editorInput = new TaskEditorInput(taskRepository, task);
    TaskEditor editor = refreshEditorContentsIfOpen(task, editorInput);
    if (editor != null)
    {
      synchronizeTask(taskRepository, task);
      return editor;
    }

    IWorkbenchPage page = window.getActivePage();
    editor = (TaskEditor)openEditor(editorInput, getTaskEditorId(task), page);
    if (editor != null)
    {
      synchronizeTask(taskRepository, task);
      return editor;
    }

    return null;
  }

  public static TaskEditor refreshEditorContentsIfOpen(ITask task, IEditorInput editorInput)
  {
    if (task != null)
    {
      if (task.getSynchronizationState() == SynchronizationState.INCOMING
          || task.getSynchronizationState() == SynchronizationState.CONFLICT)
      {
        for (TaskEditor editor : org.eclipse.mylyn.internal.tasks.ui.util.TasksUiInternal
            .getActiveRepositoryTaskEditors())
        {
          if (editor.getEditorInput().equals(editorInput))
          {
            editor.refreshPages();
            editor.getEditorSite().getPage().activate(editor);
            return editor;
          }
        }
      }
    }

    return null;
  }

  public static void synchronizeTask(TaskRepository taskRepository, ITask task)
  {
    if (task instanceof org.eclipse.mylyn.internal.tasks.core.LocalTask)
    {
      return;
    }

    AbstractRepositoryConnector connector = TasksUi.getRepositoryManager().getRepositoryConnector(
        task.getConnectorKind());
    if (connector.canSynchronizeTask(taskRepository, task))
    {
      org.eclipse.mylyn.internal.tasks.ui.util.TasksUiInternal.synchronizeTask(connector, task, false, null);
    }
  }

  public static String getTaskEditorId(final ITask task)
  {
    String taskEditorId = TaskEditor.ID_EDITOR;
    if (task != null)
    {
      ITask repositoryTask = task;
      AbstractRepositoryConnectorUi repositoryUi = org.eclipse.mylyn.internal.tasks.ui.TasksUiPlugin
          .getConnectorUi(repositoryTask.getConnectorKind());
      String customTaskEditorId = repositoryUi.getTaskEditorId(repositoryTask);
      if (customTaskEditorId != null)
      {
        taskEditorId = customTaskEditorId;
      }
    }

    return taskEditorId;
  }

  public static IEditorPart openEditor(IEditorInput input, String editorId, IWorkbenchPage page)
  {
    if (page == null)
    {
      IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
      if (window != null)
      {
        page = window.getActivePage();
      }
    }

    if (page == null)
    {
      StatusHandler.log(new Status(IStatus.ERROR, org.eclipse.mylyn.internal.tasks.ui.TasksUiPlugin.ID_PLUGIN,
          "Unable to open editor for \"" + input + "\": no active workbench window"));
      return null;
    }

    try
    {
      return page.openEditor(input, editorId);
    }
    catch (PartInitException e)
    {
      StatusHandler.fail(new Status(IStatus.ERROR, org.eclipse.mylyn.internal.tasks.ui.TasksUiPlugin.ID_PLUGIN,
          "Open for editor failed: " + input + ", taskId: " + editorId, e));
    }

    return null;
  }
}
