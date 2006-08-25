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
package org.eclipse.net4j.examples.mvc.adapter;


import org.eclipse.net4j.examples.mvc.DensityMvcPlugin.AdapterFactoryElement;
import org.eclipse.net4j.examples.mvc.IAdapter.Factory;

import org.apache.log4j.Logger;

import java.util.List;


public class PluginAdapterManager extends AbstractAdapterManager<Object>
{
  private static final Logger logger = Logger.getLogger(PluginAdapterManager.class);

  public PluginAdapterManager(List adapterFactoryElements)
  {
    for (Object element : adapterFactoryElements)
    {
      AdapterFactoryElement factoryElement = (AdapterFactoryElement)element;

      try
      {
        Factory<Object> factory = (Factory<Object>)factoryElement.createExecutableExtension();
        addAdapterFactory(factory);
      }
      catch (Exception ex)
      {
        logger.warn("Factory not created", ex);
      }
    }
  }
}
