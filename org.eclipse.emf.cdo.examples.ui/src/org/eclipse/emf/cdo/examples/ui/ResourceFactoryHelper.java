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
package org.eclipse.emf.cdo.examples.ui;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Factory;
import org.eclipse.emf.ecore.resource.Resource.Factory.Registry;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceFactoryImpl;

import java.util.Collection;
import java.util.Map;

public class ResourceFactoryHelper
{
  public static final Registry REGISTRY = Resource.Factory.Registry.INSTANCE;

  public static final String XMI = "xmi";

  public static final String XML = "xml";

  public static Collection<String> getExtensions()
  {
    Map map = REGISTRY.getExtensionToFactoryMap();
    if (!map.containsKey(XML))
    {
      Factory factory = new XMLResourceFactoryImpl();
      map.put(XML, factory);
    }

    if (!map.containsKey(XMI))
    {
      Factory factory = new XMIResourceFactoryImpl();
      map.put(XMI, factory);
    }

    return map.keySet();
  }

  public static Factory getResourceFactory(String ext)
  {
    Map map = REGISTRY.getExtensionToFactoryMap();
    return (Resource.Factory)map.get(ext);
  }

}
