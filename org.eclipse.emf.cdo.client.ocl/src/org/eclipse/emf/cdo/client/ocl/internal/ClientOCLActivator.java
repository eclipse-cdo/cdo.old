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
package org.eclipse.emf.cdo.client.ocl.internal;


import org.eclipse.emf.cdo.client.internal.Activator;
import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.ResourceLocator;


public final class ClientOCLActivator extends EMFPlugin
{
  public static final String PLUGIN_ID = "org.eclipse.emf.cdo.client.ocl";

  public static final ClientOCLActivator INSTANCE = new ClientOCLActivator();

  private static Implementation plugin;

  public ClientOCLActivator()
  {
    super(new ResourceLocator[] { Activator.INSTANCE});
  }

  public ResourceLocator getPluginResourceLocator()
  {
    return plugin;
  }

  public static Implementation getPlugin()
  {
    return plugin;
  }


  public static class Implementation extends EclipsePlugin
  {
    public Implementation()
    {
      plugin = this;
    }
  }
}
