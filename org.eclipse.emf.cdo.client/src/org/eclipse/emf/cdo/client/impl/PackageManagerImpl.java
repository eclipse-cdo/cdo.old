/***************************************************************************
 * Copyright (c) 2004, 2005, 2006 Eike Stepper, Fuggerstr. 39, 10777 Berlin, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 **************************************************************************/
package org.eclipse.emf.cdo.client.impl;


import org.eclipse.net4j.core.Channel;
import org.eclipse.net4j.spring.ValidationException;
import org.eclipse.net4j.spring.impl.ServiceImpl;

import org.eclipse.emf.cdo.client.AttributeConverter;
import org.eclipse.emf.cdo.client.ClassInfo;
import org.eclipse.emf.cdo.client.MappingProvider;
import org.eclipse.emf.cdo.client.PackageInfo;
import org.eclipse.emf.cdo.client.PackageListener;
import org.eclipse.emf.cdo.client.PackageManager;
import org.eclipse.emf.cdo.client.internal.ClientActivator;
import org.eclipse.emf.cdo.client.internal.ClientActivator.MappingElement;
import org.eclipse.emf.cdo.core.OIDEncoder;
import org.eclipse.emf.cdo.mapping.ClassMapping;
import org.eclipse.emf.cdo.mapping.PackageMapping;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceFactoryImpl;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;

import org.osgi.framework.Bundle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import java.io.File;
import java.io.IOException;

import java.net.URL;


public class PackageManagerImpl extends ServiceImpl implements PackageManager
{
  public static final boolean DEFAULT_AUTO_PERSISTENT = true;

  private boolean autoPersistent = DEFAULT_AUTO_PERSISTENT;

  private OIDEncoder oidEncoder;

  private AttributeConverter attributeConverter;

  private transient boolean newPackagesToAnnounce = false;

  private transient Map eClassToClassInfoMap = new HashMap(2111);

  private transient Map cidToClassInfoMap = new HashMap(2111);

  private transient List<PackageInfo> packages = new ArrayList();

  private transient List listeners = new ArrayList();

  public OIDEncoder getOidEncoder() // Don't change case! Spring will be irritated
  {
    return oidEncoder;
  }

  public void setOidEncoder(OIDEncoder oidEncoder) // Don't change case! Spring will be irritated
  {
    doSet("oidEncoder", oidEncoder);
  }

  public AttributeConverter getAttributeConverter()
  {
    return attributeConverter;
  }

  public void setAttributeConverter(AttributeConverter attributeConverter)
  {
    doSet("attributeConverter", attributeConverter);
  }

  public void addPackage(EPackage ePackage, String mappingFile)
  {
    if (isDebugEnabled()) debug("Analyzing package " + ePackage.getNsURI());
    MappingProvider provider = getMappingProvider(ePackage, mappingFile);
    PackageInfo packageInfo = new PackageInfoImpl(ePackage, provider.getPackageMapping(), this);

    EList classifiers = ePackage.getEClassifiers();
    for (Iterator classifierIt = classifiers.iterator(); classifierIt.hasNext();)
    {
      EClassifier classifier = (EClassifier) classifierIt.next();
      if (classifier instanceof EClass)
      {
        addClass((EClass) classifier, packageInfo, provider);
      }
    }

    packages.add(packageInfo);
    notifyPackageListeners();
    newPackagesToAnnounce = true;
  }

  protected void addClass(EClass eClass, PackageInfo packageInfo, MappingProvider provider)
  {
    if (isDebugEnabled()) debug("Analyzing class " + eClass.getName());
    ClassMapping classMapping = provider.getClassMapping(eClass.getName());

    if (classMapping != null)
    {
      ClassInfo classInfo = new ClassInfoImpl(eClass, packageInfo, classMapping);
      eClassToClassInfoMap.put(eClass, classInfo);
      packageInfo.addClass(classInfo);
    }
  }

  /**
   * @param mappingFile
   * @return
   */
  protected MappingProvider getMappingProvider(EPackage ePackage, String mappingFile)
  {
    // TODO Move mapping file to configuration area
    // TODO Detect model changes also, if mapping file already exists

    if (mappingFile == null)
    {
      mappingFile = ePackage.getName().replace('.', '_') + ".xml";
    }

    File file = new File(mappingFile);
    mappingFile = file.getAbsolutePath();
    boolean mappingExists = file.exists();

    try
    {
      if (mappingExists)
      {
        if (isDebugEnabled()) debug("Using mapping file " + mappingFile);
        MappingProvider provider = new XMLMappingProviderImpl(mappingFile);
        return provider;
      }
      else
      {
        if (isDebugEnabled()) debug("Creating mapping file " + mappingFile);

        MappingProvider provider = new AnnotationMappingProviderImpl(ePackage, autoPersistent,
            attributeConverter);
        saveMappingModel(mappingFile, provider.getPackageMapping());
        return provider;
      }
    }
    catch (IOException ex)
    {
      // TODO Better exception
      throw new RuntimeException(ex);
    }
  }

  public void notifyPackageListeners()
  {
    for (Iterator iter = listeners.iterator(); iter.hasNext();)
    {
      PackageListener listener = (PackageListener) iter.next();
      listener.notifyAddedPackage();
    }
  }

  public void addPackageListener(PackageListener listener)
  {
    listeners.add(listener);
  }

  public void removePackageListener(PackageListener listener)
  {
    listeners.remove(listener);
  }

  public List<PackageInfo> getPackages()
  {
    return packages;
  }

  public ClassInfo getClassInfo(EClass eClass)
  {
    return (ClassInfo) eClassToClassInfoMap.get(eClass);
  }

  public ClassInfo getClassInfo(EObject eObject)
  {
    EClass eClass = eObject.eClass();
    return getClassInfo(eClass);
  }

  public ClassInfo getClassInfo(int cid)
  {
    return (ClassInfo) cidToClassInfoMap.get(new Integer(cid));
  }

  public Iterator getClassInfos()
  {
    return eClassToClassInfoMap.values().iterator();
  }

  /**
   * @return Returns the autoPersistent.
   */
  public boolean isAutoPersistent()
  {
    return autoPersistent;
  }

  /**
   * @param autoPersistent The autoPersistent to set.
   */
  public void setAutoPersistent(boolean autoPersistent)
  {
    doSet("autoPersistent", autoPersistent);
  }

  protected void saveMappingModel(String fileName, PackageMapping model) throws IOException
  {
    ResourceSet resourceSet = new ResourceSetImpl();
    Map map = resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap();
    map.put("xml", new XMLResourceFactoryImpl());

    URI uri = URI.createFileURI(fileName);
    Resource resource = resourceSet.createResource(uri);
    resource.getContents().add(model);
    resource.save(Collections.EMPTY_MAP);
  }

  public void initCID(ClassInfo classInfo)
  {
    int cid = classInfo.getCID();
    cidToClassInfoMap.put(new Integer(cid), classInfo);
  }

  public void announceNewPackages(Channel channel)
  {
    if (isDebugEnabled())
    {
      debug("Announcing new packages");
    }

    if (newPackagesToAnnounce)
    {
      for (PackageInfo packageInfo : packages)
      {
        if (!packageInfo.isAnnounced())
        {
          if (isDebugEnabled())
          {
            debug("Announcing package " + packageInfo.getFullName());
          }

          packageInfo.announce(channel);
        }
      }

      newPackagesToAnnounce = false;
    }
  }

  public void processMappings()
  {
    List elements = ClientActivator.getPlugin().getMappingElements();

    if (elements == null)
    {
      throw new IllegalStateException("Mapping elements are not parsed yet");
    }

    for (Iterator it = elements.iterator(); it.hasNext();)
    {
      MappingElement element = (MappingElement) it.next();
      String uri = element.getUri();
      String map = element.getMap();

      EPackage ePackage = EPackage.Registry.INSTANCE.getEPackage(uri);
      if (ePackage == null)
        throw new ValidationException("There is no EPackage registered under the specified URI "
            + uri); // TODO Better Exception

      String mappingFileName;
      String id = element.configurationElement().getNamespaceIdentifier();

      try
      {
        Bundle bundle = Platform.getBundle(id);
        URL entry = bundle.getEntry(map);
        mappingFileName = entry == null ? null : FileLocator.toFileURL(entry).getFile();
      }
      catch (IOException ex)
      {
        throw new ValidationException("Error while computing location of bundle " + id, ex);
      }

      addPackage(ePackage, mappingFileName);
    }
  }

  @Override
  protected void validate() throws ValidationException
  {
    super.validate();
    assertNotNull("oidEncoder");
    assertNotNull("attributeConverter");
    processMappings();
  }
}
