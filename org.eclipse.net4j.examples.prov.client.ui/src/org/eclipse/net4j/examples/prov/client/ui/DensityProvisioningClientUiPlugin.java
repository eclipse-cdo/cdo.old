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
package org.eclipse.net4j.examples.prov.client.ui;


import org.eclipse.net4j.util.eclipse.AbstractPlugin;


/**
 * The main plugin class to be used in the desktop.
 */
public class DensityProvisioningClientUiPlugin extends AbstractPlugin
{
  private static DensityProvisioningClientUiPlugin plugin;

  /**
   * The constructor.
   */
  public DensityProvisioningClientUiPlugin()
  {
    if (plugin == null) plugin = this;
  }

  /**
   * Returns the shared instance.
   */
  public static DensityProvisioningClientUiPlugin getDefault()
  {
    return plugin;
  }
}
