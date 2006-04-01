/*******************************************************************************
 * Copyright (c) 2004, 2005, 2006 Eike Stepper, Sympedia Methods and Tools.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Eike Stepper - initial API and implementation
 *******************************************************************************/
package org.eclipse.net4j.core;


import org.eclipse.net4j.util.eclipse.AbstractPlugin;


/**
 * The main plugin class to be used in the desktop.
 */
public class Net4jCorePlugin extends AbstractPlugin
{
  // The shared instance.
  private static Net4jCorePlugin plugin;

  /**
   * The constructor.
   */
  public Net4jCorePlugin()
  {
    if (plugin == null) plugin = this;
  }

  protected void doStart() throws Exception
  {
  }

  protected void doStop() throws Exception
  {
    plugin = null;
  }

  /**
   * Returns the shared instance.
   */
  public static Net4jCorePlugin getDefault()
  {
    return plugin;
  }
}
