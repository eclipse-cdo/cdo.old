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

import org.eclipse.net4j.pop.task.ITaskAttribute;
import org.eclipse.net4j.pop.task.ITaskRepositoryConfiguration;
import org.eclipse.net4j.pop.task.spi.web.SearchLineHandler;
import org.eclipse.net4j.pop.task.spi.web.WebConfiguration;
import org.eclipse.net4j.pop.task.spi.web.WebConnector;
import org.eclipse.net4j.util.WrappedException;

import java.io.IOException;

/**
 * @author Eike Stepper
 */
public class BugzillaConnector extends WebConnector
{
  public static final String NAME = "Bugzilla";

  public BugzillaConnector()
  {
    super(NAME);
  }

  @Override
  public void validateConfiguration(ITaskRepositoryConfiguration configuration)
  {
    super.validateConfiguration(configuration);
    WebConfiguration config = (WebConfiguration)configuration;

    try
    {
      SearchLineHandler handler = new SearchLineHandler("<title>User Preferences</title>");
      config.request("userprefs.cgi", null, handler);
      if (!handler.isFound())
      {
        throw new IllegalStateException("Unable to connect to task repository: " + config.getUrl());
      }
    }
    catch (IOException ex)
    {
      throw WrappedException.wrap(ex);
    }
  }

  @Override
  protected void initAttributes()
  {
    addTitleAttribute("Summary");
    addStateAttribute("State");
    addUserAttribute("Reporter", false, true, false);
    addUserAttribute("CC", true, false, true);
  }

  public String[] getAttributeChoices(ITaskAttribute attribute)
  {
    return null;
  }
}
