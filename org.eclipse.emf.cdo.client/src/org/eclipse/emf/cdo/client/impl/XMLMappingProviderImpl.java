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
package org.eclipse.emf.cdo.client.impl;


import org.eclipse.emf.cdo.client.MappingProvider;
import org.eclipse.emf.cdo.mapping.AttributeMapping;
import org.eclipse.emf.cdo.mapping.ClassMapping;
import org.eclipse.emf.cdo.mapping.PackageMapping;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceFactoryImpl;

import java.util.Collections;
import java.util.Map;

import java.io.IOException;


public class XMLMappingProviderImpl implements MappingProvider
{
  protected PackageMapping packageMapping;

  public XMLMappingProviderImpl(String fileName) throws IOException
  {
    loadMappingModel(fileName);
  }

  public PackageMapping getPackageMapping()
  {
    return packageMapping;
  }

  public ClassMapping getClassMapping(String className)
  {
    return packageMapping.getClassMapping(className);
  }

  public AttributeMapping getAttributeMapping(String className, String attributeName)
  {
    ClassMapping classMapping = packageMapping.getClassMapping(className);
    if (classMapping == null)
    {
      return null;
    }
    return classMapping.getAttributeMapping(attributeName);
  }

  protected void loadMappingModel(String fileName) throws IOException
  {
    ResourceSet resourceSet = new ResourceSetImpl();
    Map map = resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap();
    map.put("xml", new XMLResourceFactoryImpl());

    URI uri = URI.createFileURI(fileName);
    Resource resource = resourceSet.createResource(uri);
    resource.load(Collections.EMPTY_MAP);
    packageMapping = (PackageMapping) resource.getContents().get(0);
  }
}
