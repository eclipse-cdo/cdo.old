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
package org.eclipse.net4j.pop.task.internal.bugzilla;

import org.eclipse.net4j.pop.spi.task.TaskRepositoryConfiguration;
import org.eclipse.net4j.pop.spi.task.TaskRepositoryConnector;
import org.eclipse.net4j.pop.task.ITaskAttribute;
import org.eclipse.net4j.pop.task.ITaskRepositoryConfiguration;
import org.eclipse.net4j.pop.task.ITaskRepositoryConnector;

import org.eclipse.equinox.security.storage.ISecurePreferences;
import org.eclipse.equinox.security.storage.StorageException;

/**
 * @author Eike Stepper
 */
public abstract class DummyConnector extends TaskRepositoryConnector
{
  protected DummyConnector(String name)
  {
    super(name);
  }

  public DummyConfiguration createConfiguration()
  {
    return new DummyConfiguration(this);
  }

  public void validateConfiguration(ITaskRepositoryConfiguration configuration)
  {
  }

  @Override
  protected void initAttributes()
  {
    addTitleAttribute("Title");
    addStateAttribute("State");
  }

  public String[] getAttributeChoices(ITaskAttribute attribute)
  {
    return null;
  }

  /**
   * @author Eike Stepper
   */
  public class DummyConfiguration extends TaskRepositoryConfiguration
  {

    public DummyConfiguration(ITaskRepositoryConnector connector)
    {
      super(connector);
    }

    protected DummyConfiguration(DummyConfiguration source)
    {
      super(source);
    }

    public DummyConfiguration copy()
    {
      return new DummyConfiguration(this);
    }

    public void load(ISecurePreferences preferences) throws StorageException
    {
    }

    public void save(ISecurePreferences preferences) throws StorageException
    {
    }
  }
}
