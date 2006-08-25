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
package org.eclipse.net4j.examples.mvc.swt;


import org.eclipse.net4j.util.eclipse.AbstractPlugin;


/**
 * The main plugin class to be used in the desktop.
 */
public class DensityMvcSwtPlugin extends AbstractPlugin
{
  // The shared instance.
  private static DensityMvcSwtPlugin plugin;

  /**
   * The constructor.
   */
  public DensityMvcSwtPlugin()
  {
    if (plugin == null) plugin = this;
  }

  /**
   * Returns the shared instance.
   */
  public static DensityMvcSwtPlugin getDefault()
  {
    return plugin;
  }
}
