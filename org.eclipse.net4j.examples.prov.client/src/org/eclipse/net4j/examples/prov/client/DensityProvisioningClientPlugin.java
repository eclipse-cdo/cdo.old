/***************************************************************************
 * Copyright (c) 2004, 2005, 2006 Eike Stepper, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 **************************************************************************/
package org.eclipse.net4j.examples.prov.client;


import org.eclipse.net4j.examples.client.ClientActivator;
import org.eclipse.net4j.examples.prov.client.protocol.ProvisioningClientProtocol;
import org.eclipse.net4j.spring.Container;
import org.eclipse.net4j.spring.ContainerCreationException;
import org.eclipse.net4j.spring.impl.ContainerImpl;
import org.eclipse.net4j.util.eclipse.AbstractPlugin;

import java.io.IOException;


/**
 * The main plugin class to be used in the desktop.
 */
public class DensityProvisioningClientPlugin extends AbstractPlugin
{
  public static final String CONTEXT_PATH = "META-INF/";

  // The shared instance.
  private static DensityProvisioningClientPlugin plugin;

  private static Container container;

  /**
   * The constructor.
   */
  public DensityProvisioningClientPlugin()
  {
    if (plugin == null) plugin = this;
  }

  /**
   * Returns the shared instance.
   */
  public static DensityProvisioningClientPlugin getDefault()
  {
    return plugin;
  }

  public static Container getContainer()
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

      String location = CONTEXT_PATH + "densityProvisioningClient.xml";
      String name = "provisioning.client";
      Container parent = ClientActivator.getNet4jContainer();
      ClassLoader classLoader = getDefault().getClassLoader();
      container = new ContainerImpl(baseResourcePath, location, name, parent, classLoader);
    }

    return container;
  }

  public static ProvisioningClientProtocol getProvisioningClientProtocol()
  {
    return (ProvisioningClientProtocol)getContainer().getBean("provisioningClientProtocol");
  }
}
