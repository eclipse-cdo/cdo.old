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

import org.eclipse.core.runtime.IAdaptable;

import java.util.Map;

/**
 * @author Eike Stepper
 */
public interface ITaskRepository extends Comparable<ITaskRepository>, IAdaptable
{
  public String getName();

  public ITaskRepositoryConnector getConnector();

  public ITaskRepositoryConfiguration getConfiguration();

  public void change(ITaskRepositoryConnector connector, ITaskRepositoryConfiguration configuration);

  public void validate();

  public Map<String, ITaskUser> getUsers();

  public ITask createTask();

  public ITask[] queryComments(String messagePrefix);
}
