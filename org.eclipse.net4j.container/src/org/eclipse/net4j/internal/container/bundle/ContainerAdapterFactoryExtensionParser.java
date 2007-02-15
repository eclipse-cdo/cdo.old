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

import org.eclipse.core.runtime.IConfigurationElement;

/**
 * @author Eike Stepper
 */
public class ContainerAdapterFactoryExtensionParser extends ExtensionParser
{
  public static final String NAMESPACE = ContainerBundle.BUNDLE_ID;

  public static final String EXT_POINT_NAME = "containerAdapterFactories";

  public static final String PATH = "";

  public ContainerAdapterFactoryExtensionParser()
  {
    super(NAMESPACE, EXT_POINT_NAME);
  }

  @Override
  protected boolean handleElement(IConfigurationElement element, String path)
  {
    if (PATH.equals(path))
    {
    }

    return true;
  }
}
