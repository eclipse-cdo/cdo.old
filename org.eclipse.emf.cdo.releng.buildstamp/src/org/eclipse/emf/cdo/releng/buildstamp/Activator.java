/*
 * Copyright (c) 2012 Eike Stepper (Berlin, Germany) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Eike Stepper - initial API and implementation
 */
package org.eclipse.emf.cdo.releng.buildstamp;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import org.osgi.framework.BundleContext;

/**
 * @author Eike Stepper
 */
public class Activator extends AbstractUIPlugin
{
  public static final String PLUGIN_ID = "org.eclipse.emf.cdo.releng.buildstamp"; //$NON-NLS-1$

  private static Activator plugin;

  private BuildMonitor buildMonitor;

  public Activator()
  {
  }

  @Override
  public void start(BundleContext context) throws Exception
  {
    super.start(context);
    plugin = this;

    buildMonitor = new BuildMonitor();
  }

  @Override
  public void stop(BundleContext context) throws Exception
  {
    if (buildMonitor != null)
    {
      buildMonitor.dispose();
      buildMonitor = null;
    }

    plugin = null;
    super.stop(context);
  }

  public static Activator getDefault()
  {
    return plugin;
  }

  public static void log(String message, Throwable t)
  {
    getDefault().getLog().log(new Status(IStatus.ERROR, PLUGIN_ID, message, t));
  }
}
