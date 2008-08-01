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

import org.eclipse.net4j.util.AdapterUtil;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.mylyn.tasks.core.IRepositoryManager;
import org.eclipse.mylyn.tasks.core.ITask;
import org.eclipse.mylyn.tasks.core.data.ITaskDataManager;
import org.eclipse.mylyn.tasks.ui.TasksUi;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

/**
 * @author Eike Stepper
 */
public abstract class TaskAction implements IObjectActionDelegate
{
  public static final IRepositoryManager REPOSITORY_MANAGER = TasksUi.getRepositoryManager();

  public static final ITaskDataManager TASK_DATA_MANAGER = TasksUi.getTaskDataManager();

  private Shell shell;

  private ISelection selection;

  public TaskAction()
  {
  }

  public final Shell getShell()
  {
    return shell;
  }

  public final ISelection getSelection()
  {
    return selection;
  }

  public final void setActivePart(IAction action, IWorkbenchPart targetPart)
  {
    shell = targetPart.getSite().getShell();
  }

  public final void selectionChanged(IAction action, ISelection selection)
  {
    this.selection = selection;
  }

  public final void run(IAction action)
  {
    try
    {
      ITask task = getTask();
      if (task != null)
      {
        run(task);
      }
    }
    catch (Exception ex)
    {
      handleException(ex);
    }
  }

  protected ITask getTask()
  {
    if (selection instanceof IStructuredSelection)
    {
      IStructuredSelection ssel = (IStructuredSelection)selection;
      Object element = ssel.getFirstElement();
      ITask task = AdapterUtil.adapt(element, ITask.class);
      return task;
    }

    return null;
  }

  protected void handleException(Exception ex)
  {
    ex.printStackTrace();
    MessageDialog.openInformation(shell, "Task Action", "Action failed.");
  }

  protected abstract void run(ITask task) throws Exception;
}
