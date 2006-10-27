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
package org.eclipse.emf.cdo.utilities.migrator.internal;

import org.eclipse.ui.plugin.AbstractUIPlugin;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * The main plugin class to be used in the desktop.
 */
public class MigratorPlugin extends AbstractUIPlugin
{
  // The shared instance.
  private static MigratorPlugin plugin;

  // Resource bundle.
  private ResourceBundle resourceBundle;

  /**
   * The constructor.
   */
  public MigratorPlugin()
  {
    super();
    plugin = this;
    try
    {
      resourceBundle = ResourceBundle
          .getBundle("org.eclipse.emf.cdo.utilities.migrator.MigratorPluginResources");
    }
    catch (MissingResourceException x)
    {
      resourceBundle = null;
    }
  }

  /**
   * Returns the shared instance.
   */
  public static MigratorPlugin getDefault()
  {
    return plugin;
  }

  /**
   * Returns the string from the plugin's resource bundle, or 'key' if not
   * found.
   */
  public static String getResourceString(String key)
  {
    ResourceBundle bundle = MigratorPlugin.getDefault().getResourceBundle();
    try
    {
      return (bundle != null) ? bundle.getString(key) : key;
    }
    catch (MissingResourceException e)
    {
      return key;
    }
  }

  /**
   * Returns the plugin's resource bundle,
   */
  public ResourceBundle getResourceBundle()
  {
    return resourceBundle;
  }
}
