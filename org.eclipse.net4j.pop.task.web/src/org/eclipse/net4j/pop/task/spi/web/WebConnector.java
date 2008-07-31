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
package org.eclipse.net4j.pop.task.spi.web;

import org.eclipse.net4j.pop.spi.task.TaskRepositoryConnector;
import org.eclipse.net4j.pop.task.ITaskRepositoryConfiguration;
import org.eclipse.net4j.util.StringUtil;

/**
 * @author Eike Stepper
 */
public abstract class WebConnector extends TaskRepositoryConnector
{
  protected WebConnector(String name)
  {
    super(name);
  }

  public WebConfiguration createConfiguration()
  {
    return new WebConfiguration(this);
  }

  public void validateConfiguration(ITaskRepositoryConfiguration configuration)
  {
    WebConfiguration config = (WebConfiguration)configuration;
    if (StringUtil.isEmpty(config.getUrl()))
    {
      throw new IllegalArgumentException("URL is empty");
    }
  }
}
