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
package org.eclipse.net4j.pop.spi.task;

import org.eclipse.net4j.pop.task.ITaskRepositoryConfiguration;
import org.eclipse.net4j.pop.task.ITaskRepositoryConnector;
import org.eclipse.net4j.util.event.Event;
import org.eclipse.net4j.util.event.Notifier;

import org.eclipse.core.runtime.Platform;

/**
 * @author Eike Stepper
 */
public abstract class TaskRepositoryConfiguration extends Notifier implements ITaskRepositoryConfiguration
{
  private ITaskRepositoryConnector connector;

  public TaskRepositoryConfiguration(ITaskRepositoryConnector connector)
  {
    this.connector = connector;
  }

  protected TaskRepositoryConfiguration(TaskRepositoryConfiguration source)
  {
    connector = source.connector;
  }

  public ITaskRepositoryConnector getConnector()
  {
    return connector;
  }

  @SuppressWarnings("unchecked")
  public Object getAdapter(Class adapter)
  {
    return Platform.getAdapterManager().getAdapter(this, adapter);
  }

  protected void fireConfigurationChangedEvent()
  {
    fireEvent(new ConfigurationChangedEvent(this));
  }

  /**
   * @author Eike Stepper
   */
  public static class ConfigurationChangedEvent extends Event implements IConfigurationChangedEvent
  {
    private static final long serialVersionUID = 1L;

    public ConfigurationChangedEvent(TaskRepositoryConfiguration configuration)
    {
      super(configuration);
    }

    public TaskRepositoryConfiguration getConfiguration()
    {
      return (TaskRepositoryConfiguration)getSource();
    }
  }
}
