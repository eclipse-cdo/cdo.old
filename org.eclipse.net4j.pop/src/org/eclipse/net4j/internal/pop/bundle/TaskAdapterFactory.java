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
package org.eclipse.net4j.internal.pop.bundle;

import org.eclipse.net4j.pop.IMaintenanceStream;
import org.eclipse.net4j.pop.IPop;
import org.eclipse.net4j.pop.ITaskStream;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.mylyn.tasks.core.ITask;

/**
 * @author Eike Stepper
 */
@SuppressWarnings("unchecked")
public class TaskAdapterFactory implements IAdapterFactory
{
  private static final Class[] ADAPTERS = { IPop.class, IMaintenanceStream.class, ITaskStream.class };

  public Class[] getAdapterList()
  {
    return ADAPTERS;
  }

  public Object getAdapter(Object adaptableObject, Class adapterType)
  {
    if (adaptableObject instanceof ITask)
    {
      ITask task = (ITask)adaptableObject;
      String taskID = task.getTaskId();
      if (adapterType.isAssignableFrom(ITaskStream.class))
      {
        return adaptTaskStream(task);
      }
      else if (adapterType.isAssignableFrom(IMaintenanceStream.class))
      {
        return adaptMaintenanceStream(task);
      }
      else if (adapterType.isAssignableFrom(IPop.class))
      {
        return adaptPop(task);
      }
    }

    return null;
  }

  protected IPop adaptPop(ITask task)
  {
    return null;
  }

  protected IMaintenanceStream adaptMaintenanceStream(ITask task)
  {
    return null;
  }

  protected ITaskStream adaptTaskStream(ITask task)
  {
    return null;
  }
}
