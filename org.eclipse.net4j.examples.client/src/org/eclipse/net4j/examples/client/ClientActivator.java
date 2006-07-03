/***************************************************************************
 * Copyright (c) 2004-2006 Eike Stepper, Fuggerstr. 39, 10777 Berlin, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 **************************************************************************/
package org.eclipse.net4j.examples.client;


import org.eclipse.net4j.core.Connector;
import org.eclipse.net4j.core.ITempManager;
import org.eclipse.net4j.spring.Container;
import org.eclipse.net4j.spring.ContainerCreationException;
import org.eclipse.net4j.spring.impl.ContainerImpl;
import org.eclipse.net4j.util.eclipse.AbstractPlugin;

import java.io.IOException;


/**
 * The main plugin class to be used in the desktop.
 */
public class ClientActivator extends AbstractPlugin
{
  public static final String CONTEXT_PATH = "META-INF/";

  //The shared instance.
  private static ClientActivator plugin;

  private static Container container;

  private static Connector connector;

  /**
   * The constructor.
   */
  public ClientActivator()
  {
    if (plugin == null) plugin = this;
  }

  /**
   * Returns the shared instance.
   */
  public static ClientActivator getDefault()
  {
    return plugin;
  }

  protected void doStart() throws Exception
  {
  }

  protected void doStop() throws Exception
  {
    if (connector != null)
    {
      connector.stop();
      connector = null;
    }

    if (container != null)
    {
      container.stop();
      container = null;
    }

    plugin = null;
  }

  public static Container getNet4jContainer()
  {
    if (container == null)
    {
      String baseResourcePath;

      try
      {
        baseResourcePath = getBundleLocation(getDefault().getBundle());
      }
      catch (IOException ex)
      {
        throw new ContainerCreationException("Error while computing location of bundle "
                + getDefault().getBundle(), ex);
      }

      String location = CONTEXT_PATH + "net4j.xml";
      String name = "net4j";

      ClassLoader classLoader = getDefault().getClassLoader();
      container = new ContainerImpl(baseResourcePath, location, name, null, classLoader);
    }

    return container;
  }

  public static ITempManager getTempManager()
  {
    return (ITempManager)getNet4jContainer().getBean("tempManager");
  }

  public static Connector getConnector()
  {
    if (connector == null)
    {
      connector = (Connector)getNet4jContainer().getBean("connector", Connector.class);
    }

    return connector;
  }
}
