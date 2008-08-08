/***************************************************************************
 * Copyright (c) 2004 - 2008 Eike Stepper, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 **************************************************************************/
package org.eclipse.net4j.pop.base.util;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;

import java.util.Map;

/**
 * @author Eike Stepper
 */
public final class EMFUtil
{
  private EMFUtil()
  {
  }

  public static void prepareSupportForUUIDs(ResourceSet resourceSet)
  {
    Map<String, Object> map = resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap();
    map.put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl()
    {
      @Override
      public Resource createResource(URI uri)
      {
        return new XMIResourceImpl(uri)
        {
          @Override
          protected boolean useUUIDs()
          {
            return true;
          }
        };
      }
    });
  }

  public static EObject getObjectById(ResourceSet resourceSet, String id)
  {
    if (resourceSet == null)
    {
      return null;
    }

    for (Resource resource : resourceSet.getResources())
    {
      EObject element = resource.getEObject(id);
      if (element != null)
      {
        return element;
      }
    }

    return null;
  }
}
