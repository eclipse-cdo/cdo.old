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

import org.eclipse.net4j.pop.internal.ui.mylyn.TaskListUtil;

import org.eclipse.mylyn.tasks.core.ITask;
import org.eclipse.mylyn.tasks.core.TaskRepository;
import org.eclipse.mylyn.tasks.core.data.TaskData;

/**
 * @author Eike Stepper
 */
public class CheckoutPopAction extends TaskDataAction
{
  public CheckoutPopAction()
  {
  }

  @Override
  protected void run(TaskRepository repository, ITask task, TaskData taskData) throws Exception
  {
    TaskListUtil.test();
  }
}
