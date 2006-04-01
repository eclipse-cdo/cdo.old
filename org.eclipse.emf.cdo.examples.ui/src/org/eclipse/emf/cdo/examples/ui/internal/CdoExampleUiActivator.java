/*******************************************************************************
 * Copyright (c) 2004, 2005 Eike Stepper, Sympedia Methods and Tools.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Eike Stepper - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.cdo.example.ui.internal;


import org.eclipse.emf.cdo.client.impl.CdoClientActivator;
import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.ui.EclipseUIPlugin;
import org.eclipse.emf.common.util.ResourceLocator;


public final class CdoExampleUiActivator extends EMFPlugin
{
  public static final CdoExampleUiActivator INSTANCE = new CdoExampleUiActivator();

  private static Implementation plugin;

  public CdoExampleUiActivator()
  {
    super(new ResourceLocator[] {CdoClientActivator.INSTANCE});
  }

  public ResourceLocator getPluginResourceLocator()
  {
    return plugin;
  }

  public static Implementation getPlugin()
  {
    return plugin;
  }

  public static class Implementation extends EclipseUIPlugin
  {
    public Implementation()
    {
      plugin = this;
    }
  }
}
