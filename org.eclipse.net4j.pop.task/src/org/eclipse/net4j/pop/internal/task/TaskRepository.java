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

import org.eclipse.net4j.pop.task.ITaskRepository;
import org.eclipse.net4j.pop.task.ITaskRepositoryConfiguration;
import org.eclipse.net4j.pop.task.ITaskRepositoryConnector;
import org.eclipse.net4j.pop.task.ITaskRepositoryManager;
import org.eclipse.net4j.pop.task.ITaskUser;
import org.eclipse.net4j.util.ObjectUtil;
import org.eclipse.net4j.util.StringUtil;
import org.eclipse.net4j.util.WrappedException;

import org.eclipse.core.runtime.PlatformObject;
import org.eclipse.equinox.security.storage.ISecurePreferences;
import org.eclipse.equinox.security.storage.StorageException;

import java.util.Map;

/**
 * @author Eike Stepper
 */
public class TaskRepository extends PlatformObject implements ITaskRepository
{
  private String name;

  private ITaskRepositoryConnector connector;

  private ITaskRepositoryConfiguration configuration;

  public TaskRepository(String name)
  {
    this.name = name;
  }

  public String getName()
  {
    return name;
  }

  public ITaskRepositoryConnector getConnector()
  {
    return connector;
  }

  public ITaskRepositoryConfiguration getConfiguration()
  {
    return configuration.copy();
  }

  public void change(ITaskRepositoryConnector connector, ITaskRepositoryConfiguration configuration)
  {
    connector.validateConfiguration(configuration);
    this.connector = connector;
    this.configuration = configuration.copy();

    try
    {
      ISecurePreferences preferences = TaskRepositoryManager.getPreferences();
      if (preferences != null)
      {
        ISecurePreferences node = preferences.node(name);
        save(node);
      }
    }
    catch (StorageException ex)
    {
      throw WrappedException.wrap(ex);
    }
  }

  public void validate()
  {
    connector.validateConfiguration(configuration);
  }

  public Map<String, ITaskUser> getUsers()
  {
    // TODO Implement TaskRepository.getUsers()
    throw new UnsupportedOperationException("Not yet implemented");
  }

  public Task createTask()
  {
    return new Task(this);
  }

  public Task[] queryComments(String messagePrefix)
  {
    // TODO Implement TaskRepository.queryComments(messagePrefix)
    throw new UnsupportedOperationException("Not yet implemented");
  }

  public int compareTo(ITaskRepository o)
  {
    return StringUtil.compare(name, o.getName());
  }

  @Override
  public boolean equals(Object obj)
  {
    if (obj == this)
    {
      return true;
    }

    if (obj instanceof ITaskRepository)
    {
      ITaskRepository that = (ITaskRepository)obj;
      return ObjectUtil.equals(name, that.getName());
    }

    return false;
  }

  @Override
  public int hashCode()
  {
    return ObjectUtil.hashCode(name);
  }

  @Override
  public String toString()
  {
    return name;
  }

  public void load(ISecurePreferences node) throws StorageException
  {
    String connectorName = node.get("connector", "");
    connector = ITaskRepositoryManager.INSTANCE.getConnectors().get(connectorName);
    configuration = connector.createConfiguration();
    configuration.load(node);
  }

  public void save(ISecurePreferences node) throws StorageException
  {
    String connectorName = connector.getName();
    node.put("connector", connectorName, false);
    configuration.save(node);
  }
}
