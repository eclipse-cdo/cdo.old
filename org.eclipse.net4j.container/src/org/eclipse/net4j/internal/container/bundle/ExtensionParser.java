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
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;

/**
 * @author Eike Stepper
 */
public abstract class ExtensionParser
{
  private static final String PATH_SEPARATOR = "/";

  private String namespace;

  private String extPointName;

  protected ExtensionParser(String namespace, String extPointName)
  {
    this.namespace = namespace;
    this.extPointName = extPointName;
  }

  public final String getNamespace()
  {
    return namespace;
  }

  public final String getExtPointName()
  {
    return extPointName;
  }

  public final void parse()
  {
    IExtensionRegistry registry = Platform.getExtensionRegistry();
    parse(registry.getConfigurationElementsFor(namespace, extPointName), "");
  }

  public final void parse(IConfigurationElement[] elements, String path)
  {
    for (IConfigurationElement element : elements)
    {
      parse(element, path + PATH_SEPARATOR + element.getName());
    }
  }

  public final void parse(IConfigurationElement element, String path)
  {
    if (handleElement(element, path))
    {
      parse(element.getChildren(), path);
    }
  }

  protected abstract boolean handleElement(IConfigurationElement element, String path);
}
