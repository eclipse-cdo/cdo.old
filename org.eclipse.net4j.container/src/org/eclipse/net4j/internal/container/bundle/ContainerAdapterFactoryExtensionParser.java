/***************************************************************************
 * Copyright (c) 2004-2007 Eike Stepper, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 **************************************************************************/
package org.eclipse.net4j.internal.container.bundle;

import org.eclipse.net4j.container.ContainerAdapterFactory;
import org.eclipse.net4j.container.ContainerManager;

import org.eclipse.core.runtime.IConfigurationElement;

/**
 * @author Eike Stepper
 */
public class ContainerAdapterFactoryExtensionParser extends ExtensionParser
{
  public static final String NAMESPACE = ContainerBundle.BUNDLE_ID;

  public static final String EXT_POINT_NAME = "containerAdapterFactories";

  public static final String PATH = "/containerAdapterFactory";

  public static final String TYPE_ATTR = "type";

  public static final String CLASS_ATTR = "class";

  public ContainerAdapterFactoryExtensionParser()
  {
    super(NAMESPACE, EXT_POINT_NAME);
  }

  @Override
  protected boolean handleElement(IConfigurationElement element, String path)
  {
    if (PATH.equals(path))
    {
      try
      {
        ContainerAdapterFactory factory = (ContainerAdapterFactory)element.createExecutableExtension(CLASS_ATTR);
        ContainerManager.INSTANCE.getContainer().register(factory);
      }
      catch (Exception ex)
      {
        ContainerBundle.LOG.error(ex);
      }

      return false;
    }

    return true;
  }
}
