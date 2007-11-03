/***************************************************************************
 * Copyright (c) 2004 - 2007 Eike Stepper, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 **************************************************************************/
package org.eclipse.emf.cdo.weaver.internal.ui;

import org.eclipse.emf.cdo.weaver.internal.ui.bundle.OM;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.plugin.AbstractUIPlugin;

/**
 * @author Eike Stepper
 */
public class SharedIcons
{
  private static final ImageRegistry REGISTRY = new ImageRegistry(getDisplay());

  private static final String ETOOL = "etool16/";

  private static final String EVIEW = "eview16/";

  private static final String OBJ = "obj16/";

  public static final String ETOOL_CONVERT = ETOOL + "convert";

  public static final String ETOOL_BROWSE_ARCHIVES = OBJ + "archive";

  public static final String ETOOL_BROWSE_FOLDERS = OBJ + "folder";

  public static final String EVIEW_CLOSE = EVIEW + "close";

  public static final String OBJ_ERROR = OBJ + "error";

  public static final String OBJ_ARCHIVE = OBJ + "archive";

  public static final String OBJ_FOLDER = OBJ + "folder";

  public static final String OBJ_PLUGIN_CONVERT = OBJ + "plugin_convert";

  public static final String OBJ_PLUGIN_SKIP = OBJ + "plugin_skip";

  public static final String OBJ_PLUGIN_IGNORE = OBJ + "plugin_ignore";

  public static final String OBJ_PACKAGE = OBJ + "EPackage";

  public static final String OBJ_CLASS = OBJ + "EClass";

  public static final String OBJ_FEATURE = OBJ + "EFeature";

  public static Image getImage(String key)
  {
    key = mangleKey(key);
    Image image = REGISTRY.get(key);
    if (image == null)
    {
      createDescriptor(key);
      image = REGISTRY.get(key);
    }

    return image;
  }

  public static ImageDescriptor getDescriptor(String key)
  {
    key = mangleKey(key);
    ImageDescriptor descriptor = REGISTRY.getDescriptor(key);
    if (descriptor == null)
    {
      descriptor = createDescriptor(key);
    }

    return descriptor;
  }

  private static ImageDescriptor createDescriptor(String key)
  {
    ImageDescriptor descriptor = AbstractUIPlugin.imageDescriptorFromPlugin(OM.BUNDLE_ID, key);
    if (descriptor != null)
    {
      REGISTRY.put(key, descriptor);
    }

    return descriptor;
  }

  private static Display getDisplay()
  {
    Display display = Display.getCurrent();
    if (display == null)
    {
      display = Display.getDefault();
    }

    if (display == null)
    {
      throw new IllegalStateException("display == null");
    }

    return display;
  }

  private static String mangleKey(String key)
  {
    return "icons/full/" + key + ".gif";
  }
}
