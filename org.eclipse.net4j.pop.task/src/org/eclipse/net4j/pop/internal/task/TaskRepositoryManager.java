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

import org.eclipse.net4j.pop.internal.task.bundle.OM;
import org.eclipse.net4j.pop.task.ITaskRepository;
import org.eclipse.net4j.pop.task.ITaskRepositoryConfiguration;
import org.eclipse.net4j.pop.task.ITaskRepositoryConnector;
import org.eclipse.net4j.pop.task.ITaskRepositoryManager;
import org.eclipse.net4j.util.container.Container;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.equinox.security.storage.ISecurePreferences;
import org.eclipse.equinox.security.storage.SecurePreferencesFactory;
import org.eclipse.equinox.security.storage.StorageException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Eike Stepper
 */
public class TaskRepositoryManager extends Container<ITaskRepository> implements ITaskRepositoryManager
{
  public static final TaskRepositoryManager INSTANCE = new TaskRepositoryManager();

  private Map<String, ITaskRepositoryConnector> connectors = new HashMap<String, ITaskRepositoryConnector>();

  private Map<String, TaskRepository> repositories = new HashMap<String, TaskRepository>();

  public static final String KEY_REPOSITORIES = "/org.eclipse.net4j.pop.task/repositories";

  private TaskRepositoryManager()
  {
  }

  public Map<String, ITaskRepositoryConnector> getConnectors()
  {
    return connectors;
  }

  public TaskRepository createRepository(String name, ITaskRepositoryConnector connector,
      ITaskRepositoryConfiguration configuration)
  {
    checkActive();
    TaskRepository repository = new TaskRepository(name);
    repository.change(connector, configuration);
    addRepository(repository);
    return repository;
  }

  public void addRepository(ITaskRepository repository)
  {
    String name = repository.getName();
    synchronized (repositories)
    {
      if (repositories.containsKey(name))
      {
        throw new IllegalStateException("Duplicate repository name: " + name);
      }

      repositories.put(name, (TaskRepository)repository);
      if (isActive())
      {
        fireElementAddedEvent(repository);
      }
    }
  }

  public void removeRepository(String name)
  {
    TaskRepository repository = repositories.remove(name);
    if (repository != null)
    {
      ISecurePreferences node = SecurePreferencesFactory.getDefault().node(KEY_REPOSITORIES + "/" + name);
      node.removeNode();
      if (isActive())
      {
        fireElementRemovedEvent(repository);
      }
    }
  }

  public TaskRepository[] getRepositories()
  {
    checkActive();
    synchronized (repositories)
    {
      List<TaskRepository> list = new ArrayList<TaskRepository>(repositories.values());
      Collections.sort(list);
      return list.toArray(new TaskRepository[list.size()]);
    }
  }

  public TaskRepository[] getElements()
  {
    return getRepositories();
  }

  @SuppressWarnings("unchecked")
  public Object getAdapter(Class adapter)
  {
    return Platform.getAdapterManager().getAdapter(this, adapter);
  }

  @Override
  protected void doActivate() throws Exception
  {
    super.doActivate();
    initConnectors();
    initRepositories();
  }

  @Override
  protected void doDeactivate() throws Exception
  {
    repositories.clear();
    connectors.clear();
    super.doDeactivate();
  }

  private void initConnectors()
  {
    IExtensionRegistry registry = Platform.getExtensionRegistry();
    if (registry == null)
    {
      OM.LOG.info("No extension registry available");
      return;
    }

    IConfigurationElement[] elements = registry.getConfigurationElementsFor(OM.BUNDLE_ID, "connectors");
    for (IConfigurationElement element : elements)
    {
      try
      {
        ITaskRepositoryConnector connector = (ITaskRepositoryConnector)element.createExecutableExtension("class");
        connectors.put(connector.getName(), connector);
      }
      catch (Exception ex)
      {
        OM.LOG.error(ex);
      }
    }
  }

  private void initRepositories() throws StorageException
  {
    ISecurePreferences preferences = getPreferences();
    if (preferences != null)
    {
      ISecurePreferences baseName = preferences.node(KEY_REPOSITORIES);
      for (String repositoryName : baseName.childrenNames())
      {
        try
        {
          ISecurePreferences node = baseName.node(repositoryName);
          TaskRepository repository = new TaskRepository(repositoryName);
          repository.load(node);
          addRepository(repository);
        }
        catch (Exception ex)
        {
          OM.LOG.error(ex);
        }
      }
    }
  }

  public static ISecurePreferences getPreferences()
  {
    ISecurePreferences preferences = null;

    try
    {
      preferences = SecurePreferencesFactory.getDefault();
    }
    catch (Exception ignore)
    {
    }

    if (preferences == null)
    {
      OM.LOG.info("No secure preferences available");
    }

    return preferences;
  }
}
