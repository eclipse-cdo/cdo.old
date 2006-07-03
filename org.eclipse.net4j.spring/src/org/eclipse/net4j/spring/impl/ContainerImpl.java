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
package org.eclipse.net4j.spring.impl;


import org.eclipse.net4j.spring.Container;
import org.eclipse.net4j.spring.ContainerCreationException;

import org.apache.log4j.Logger;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.Resource;


public class ContainerImpl extends FileSystemXmlApplicationContext implements Container
{
  protected String name;

  protected String fullName;

  protected String parentName;

  protected String baseResourcePath;

  protected ClassLoader classLoader;

  private static final String PLUGIN_PROTOCOL_PREFIX = URL_PROTOCOL_PLUGIN + ":";

  protected static Logger logger = Logger.getLogger(ContainerImpl.class.getName());

  public ContainerImpl(String baseResourcePath, String[] configLocations, String name,
      Container parent, ClassLoader classLoader) throws BeansException
  {
    super(configLocations, false, parent);
    this.baseResourcePath = baseResourcePath;
    this.name = name;
    this.classLoader = classLoader;
    setDisplayName(getFullName());

    ClassLoader originalClassLoader = Thread.currentThread().getContextClassLoader();

    try
    {
      if (classLoader != null) Thread.currentThread().setContextClassLoader(classLoader);
      refresh();
    }
    catch (Throwable t)
    {
      throw new ContainerCreationException(t);
    }
    finally
    {
      if (classLoader != null) Thread.currentThread().setContextClassLoader(originalClassLoader);
    }
  }

  public ContainerImpl(String baseResourcePath, String configLocation, String name,
      Container parent, ClassLoader classLoader) throws BeansException
  {
    this(baseResourcePath, new String[] { configLocation}, name, parent, classLoader);
  }

  /* (non-Javadoc)
   * @see org.springframework.context.support.AbstractXmlApplicationContext#initBeanDefinitionReader(org.springframework.beans.factory.xml.XmlBeanDefinitionReader)
   */
  protected void initBeanDefinitionReader(XmlBeanDefinitionReader beanDefinitionReader)
  {
    super.initBeanDefinitionReader(beanDefinitionReader);
    if (classLoader != null) beanDefinitionReader.setBeanClassLoader(classLoader);
  }

  public String getFullName()
  {
    if (fullName == null)
    {
      String parentName = getParentName();
      fullName = (parentName.length() == 0 ? "" : parentName + CONTAINER_PATH_SEPARATOR) + name;
    }

    return fullName;
  }

  public String getName()
  {
    return name;
  }

  public String getParentName()
  {
    if (parentName == null)
    {
      Container parent = getParentContainer();
      parentName = parent == null ? "" : parent.getFullName();
    }

    return parentName;
  }

  public Container getParentContainer()
  {
    return (Container) getParent();
  }

  public void stop()
  {
    close();
  }

  /* (non-Javadoc)
   * @see org.springframework.core.io.ResourceLoader#getResource(java.lang.String)
   */
  public Resource getResource(String location)
  {
    if (location.startsWith(PLUGIN_PROTOCOL_PREFIX))
    {
      String relative = location.substring(PLUGIN_PROTOCOL_PREFIX.length());
      if (relative.startsWith("/")) relative = relative.substring(1);

      String path = baseResourcePath + "/" + relative;
      return new PluginResource(path);
    }
    return super.getResource(location);
  }

  /* (non-Javadoc)
   * @see org.springframework.core.io.DefaultResourceLoader#getResourceByPath(java.lang.String)
   */
  protected Resource getResourceByPath(String path)
  {
    return getResource(PLUGIN_PROTOCOL_PREFIX + path);
  }
}
