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
package org.eclipse.net4j.pop.task;

import org.eclipse.net4j.util.container.IContainer;

import org.eclipse.core.runtime.IAdaptable;

import java.util.Map;

/**
 * @author Eike Stepper
 */
public interface ITaskRepositoryManager extends IContainer<ITaskRepository>, IAdaptable
{
  public static final ITaskRepositoryManager INSTANCE = org.eclipse.net4j.pop.internal.task.TaskRepositoryManager.INSTANCE;

  public Map<String, ITaskRepositoryConnector> getConnectors();

  public ITaskRepository createRepository(String name, ITaskRepositoryConnector connector,
      ITaskRepositoryConfiguration configuration);

  public void removeRepository(String name);

  public ITaskRepository[] getRepositories();

}
