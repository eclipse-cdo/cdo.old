/**
 * Copyright (c) 2004 - 2009 Eike Stepper (Berlin, Germany) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 */
package org.eclipse.emf.cdo.tests.hibernate;

import org.eclipse.core.runtime.Plugin;

import org.osgi.framework.BundleContext;

/**
 * @author Eike Stepper
 */
public class Activator extends Plugin
{
  public static final String PLUGIN_ID = "org.eclipse.emf.cdo.tests.hibernate";

  private static Activator plugin;

  public Activator()
  {
  }

  @Override
  public void start(BundleContext context) throws Exception
  {
    super.start(context);
    plugin = this;
  }

  @Override
  public void stop(BundleContext context) throws Exception
  {
    plugin = null;
    super.stop(context);
  }

  public static Activator getDefault()
  {
    return plugin;
  }
}
