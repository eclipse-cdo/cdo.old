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
package org.eclipse.net4j.pop.internal.task;

import org.eclipse.net4j.pop.task.ITaskManager;
import org.eclipse.net4j.util.lifecycle.Lifecycle;

import org.eclipse.core.runtime.Platform;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Eike Stepper
 */
public class TaskManager extends Lifecycle implements ITaskManager
{
  public static final TaskManager INSTANCE = new TaskManager();

  private List<Task> elements = new ArrayList<Task>();

  private TaskManager()
  {
  }

  public Task[] getTasks()
  {
    synchronized (elements)
    {
      return elements.toArray(new Task[elements.size()]);
    }
  }

  @SuppressWarnings("unchecked")
  public Object getAdapter(Class adapter)
  {
    return Platform.getAdapterManager().getAdapter(this, adapter);
  }
}
