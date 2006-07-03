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
package org.eclipse.net4j.examples.mvc;


import org.eclipse.net4j.examples.mvc.adapter.PluginAdapterManager;
import org.eclipse.net4j.util.eclipse.AbstractPlugin;
import org.eclipse.net4j.util.eclipse.Element;
import org.eclipse.net4j.util.eclipse.ExecutableElement;
import org.eclipse.net4j.util.eclipse.ExtensionParser;
import org.eclipse.net4j.util.eclipse.ListExtensionParser;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;

import java.util.ArrayList;
import java.util.List;


/**
 * The main plugin class to be used in the desktop.
 */
public class DensityMvcPlugin extends AbstractPlugin
{
  public static final String EXTENSION_POINT_ID = "adapterFactories";

  // The shared instance.
  private static DensityMvcPlugin plugin;

  private static PluginAdapterManager adapterManager;

  private List adapterFactoryElements = new ArrayList();

  private ExtensionParser adapterFactoryParser = new AdapterFactoryParser(adapterFactoryElements);

  /**
   * The constructor.
   */
  public DensityMvcPlugin()
  {
    if (plugin == null) plugin = this;
  }

  /**
   * Returns the shared instance.
   */
  public static DensityMvcPlugin getDefault()
  {
    return plugin;
  }

  public static PluginAdapterManager getAdapterManager()
  {
    if (adapterManager == null)
    {
      adapterManager = new PluginAdapterManager(getDefault().getAdapterFactoryElements());
    }

    return adapterManager;
  }

  public List getAdapterFactoryElements()
  {
    return adapterFactoryElements;
  }

  protected void doStart() throws Exception
  {
    processAdapterFactories();
  }

  private void processAdapterFactories() throws CoreException
  {
    IExtensionRegistry registry = Platform.getExtensionRegistry();
    IExtensionPoint point = registry.getExtensionPoint(getPluginId() + "." + EXTENSION_POINT_ID);
    adapterFactoryParser.parse(point);
  }

  public class AdapterFactoryElement extends ExecutableElement
  {
    public String toString()
    {
      return "AdapterFactory(" + className + ")";
    }
  }

  public class AdapterFactoryParser extends ListExtensionParser
  {
    public AdapterFactoryParser(List list)
    {
      super(list);

      addFactory("factory", new Element.Factory()
      {
        public Element createElementData()
        {
          return new AdapterFactoryElement();
        }
      });
    }
  }
}
