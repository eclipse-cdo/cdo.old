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


import org.eclipse.net4j.transport.Channel;
import org.eclipse.net4j.util.lifecycle.AbstractLifecycle;
import org.eclipse.net4j.util.om.trace.ContextTracer;

import org.eclipse.emf.cdo.client.AttributeConverter;
import org.eclipse.emf.cdo.client.ClassInfo;
import org.eclipse.emf.cdo.client.MappingProvider;
import org.eclipse.emf.cdo.client.PackageInfo;
import org.eclipse.emf.cdo.client.PackageListener;
import org.eclipse.emf.cdo.client.PackageManager;
import org.eclipse.emf.cdo.client.internal.Activator;
import org.eclipse.emf.cdo.client.internal.CDOClient;
import org.eclipse.emf.cdo.client.internal.Activator.MappingElement;
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


public class PackageManagerImpl extends AbstractLifecycle implements PackageManager
{
  private static final ContextTracer TRACER = new ContextTracer(CDOClient.DEBUG_MODEL,
      PackageManagerImpl.class);

  public static final boolean DEFAULT_AUTO_PERSISTENT = true;

  private boolean autoPersistent = DEFAULT_AUTO_PERSISTENT;

  private OIDEncoder oidEncoder;

  private AttributeConverter attributeConverter;

  private transient boolean newPackagesToAnnounce = false;

  private transient Map<EClass, ClassInfo> eClassToClassInfoMap = new HashMap<EClass, ClassInfo>(
      2111);

  private transient Map<Integer, ClassInfo> cidToClassInfoMap = new HashMap<Integer, ClassInfo>(
      2111);

  private transient List<PackageInfo> packages = new ArrayList<PackageInfo>();

  private transient List<PackageListener> listeners = new ArrayList<PackageListener>();

  public OIDEncoder getOidEncoder() // Don't change case! Spring will be irritated
  {
    return oidEncoder;
  }

  public void setOidEncoder(OIDEncoder oidEncoder) // Don't change case! Spring will be irritated
  {
    this.oidEncoder = oidEncoder;
  }

  public AttributeConverter getAttributeConverter()
  {
    return attributeConverter;
  }

  public void setAttributeConverter(AttributeConverter attributeConverter)
  {
    this.attributeConverter = attributeConverter;
  }

  @SuppressWarnings("unchecked")
  public void addPackage(EPackage ePackage, String mappingFile)
  {
    if (TRACER.isEnabled())
    {
      TRACER.trace(this, "Analyzing package " + ePackage.getNsURI());
    }

    MappingProvider provider = getMappingProvider(ePackage, mappingFile);
    PackageInfo packageInfo = new PackageInfoImpl(ePackage, provider.getPackageMapping(), this);

    EList classifiers = ePackage.getEClassifiers();
    for (Iterator<EClassifier> classifierIt = classifiers.iterator(); classifierIt.hasNext();)
    {
      EClassifier classifier = classifierIt.next();
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
    if (TRACER.isEnabled())
    {
      TRACER.trace(this, "Analyzing class " + eClass.getName());
    }

    ClassMapping classMapping = provider.getClassMapping(eClass.getName());

    if (classMapping != null)
    {
      ClassInfo classInfo = new ClassInfoImpl(eClass, packageInfo, classMapping);
      eClassToClassInfoMap.put(eClass, classInfo);
      packageInfo.addClass(classInfo);
    }
  }

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
        if (TRACER.isEnabled())
        {
          TRACER.trace(this, "Using mapping file " + mappingFile);
        }

        MappingProvider provider = new XMLMappingProviderImpl(mappingFile);
        return provider;
      }
      else
      {
        if (TRACER.isEnabled())
        {
          TRACER.trace(this, "Creating mapping file " + mappingFile);
        }

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
    for (Iterator<PackageListener> iter = listeners.iterator(); iter.hasNext();)
    {
      PackageListener listener = iter.next();
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
    return eClassToClassInfoMap.get(eClass);
  }

  public ClassInfo getClassInfo(EObject eObject)
  {
    EClass eClass = eObject.eClass();
    return getClassInfo(eClass);
  }

  public ClassInfo getClassInfo(int cid)
  {
    return cidToClassInfoMap.get(new Integer(cid));
  }

  public Iterator<ClassInfo> getClassInfos()
  {
    return eClassToClassInfoMap.values().iterator();
  }

  public boolean isAutoPersistent()
  {
    return autoPersistent;
  }

  public void setAutoPersistent(boolean autoPersistent)
  {
    this.autoPersistent = autoPersistent;
  }

  @SuppressWarnings("unchecked")
  protected void saveMappingModel(String fileName, PackageMapping model) throws IOException
  {
    ResourceSet resourceSet = new ResourceSetImpl();
    Map<String, Resource.Factory> map = resourceSet.getResourceFactoryRegistry()
        .getExtensionToFactoryMap();
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
    if (TRACER.isEnabled())
    {
      TRACER.trace(this, "Announcing new packages");
    }

    if (newPackagesToAnnounce)
    {
      for (PackageInfo packageInfo : packages)
      {
        if (!packageInfo.isAnnounced())
        {
          if (TRACER.isEnabled())
          {
            TRACER.trace(this, "Announcing package " + packageInfo.getFullName());
          }

          try
          {
            packageInfo.announce(channel);
          }
          catch (Exception ex)
          {
            CDOClient.LOG.error(ex);
          }
        }
      }

      newPackagesToAnnounce = false;
    }
  }

  public void processMappings()
  {
    List<?> elements = Activator.getPlugin().getMappingElements();

    if (elements == null)
    {
      throw new IllegalStateException("Mapping elements are not parsed yet");
    }

    for (Iterator<?> it = elements.iterator(); it.hasNext();)
    {
      MappingElement element = (MappingElement) it.next();
      String uri = element.getUri();
      String map = element.getMap();

      EPackage ePackage = EPackage.Registry.INSTANCE.getEPackage(uri);
      if (ePackage == null)
        throw new IllegalStateException("There is no EPackage registered under the specified URI "
            + uri);

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
        throw new IllegalStateException("Error while computing location of bundle " + id, ex);
      }

      addPackage(ePackage, mappingFileName);
    }
  }

  @Override
  protected void onAboutToActivate() throws Exception
  {
    super.onAboutToActivate();
    if (oidEncoder == null)
    {
      throw new IllegalStateException("oidEncoder == null");
    }

    if (attributeConverter == null)
    {
      throw new IllegalStateException("attributeConverter == null");
    }
  }

  @Override
  protected void onActivate() throws Exception
  {
    super.onActivate();
    processMappings();
  }

  @Override
  protected void onDeactivate() throws Exception
  {
    attributeConverter = null;
    cidToClassInfoMap = null;
    eClassToClassInfoMap = null;
    listeners = null;
    oidEncoder = null;
    packages = null;
    super.onDeactivate();
  }
}
