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
package org.eclipse.net4j.examples.server.internal;


import org.eclipse.net4j.core.Acceptor;
import org.eclipse.net4j.core.ITempManager;
import org.eclipse.net4j.core.Net4jCorePlugin;
import org.eclipse.net4j.spring.Container;
import org.eclipse.net4j.spring.ContainerCreationException;
import org.eclipse.net4j.spring.impl.ContainerImpl;
import org.eclipse.net4j.util.eclipse.AbstractPlugin;
import org.eclipse.net4j.util.eclipse.Element;
import org.eclipse.net4j.util.eclipse.ExecutableElement;
import org.eclipse.net4j.util.eclipse.ExtensionParser;
import org.eclipse.net4j.util.eclipse.ListExtensionParser;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

import java.io.IOException;


/**
 * The main plugin class to be used in the desktop.
 */
public class ExampleServerPlugin extends AbstractPlugin
{
  private static final Logger logger = Logger.getLogger(ExampleServerPlugin.class);

  public static final String PLUGIN_ID = "org.eclipse.net4j.examples.server";

  public static final String EXTENSION_POINT_ID = "backends";

  public static final String CONTEXT_PATH = "META-INF/";

  //The shared instance.
  private static ExampleServerPlugin plugin;

  private List<BackendElement> backendElements = new ArrayList<BackendElement>();

  private static Container container;

  private Acceptor acceptor;

  /**
   * The constructor.
   */
  public ExampleServerPlugin()
  {
    if (plugin == null) plugin = this;
  }

  /**
   * Returns the shared instance.
   */
  public static ExampleServerPlugin getDefault()
  {
    return plugin;
  }

  protected void doStart() throws Exception
  {
    ExtensionParser mappingParser = new BackendExtensionParser(backendElements);
    IExtensionRegistry registry = Platform.getExtensionRegistry();
    IExtensionPoint point = registry.getExtensionPoint(PLUGIN_ID + "." + EXTENSION_POINT_ID);
    mappingParser.parse(point);

    Net4jCorePlugin.getDefault();
    if (logger.isDebugEnabled())
    {
      logger.debug("Loading Net4j container");
    }

    Container net4jContainer = getNet4jContainer();
    for (BackendElement element : backendElements)
    {
      element.initializeBackend(net4jContainer);
    }

    acceptor = (Acceptor) net4jContainer.getBean("acceptor", Acceptor.class);
    acceptor.start();
  }

  protected void doStop() throws Exception
  {
    try
    {
      acceptor.stop();
    }
    catch (Exception ignore)
    {
      ; // Intentionally empty
    }

    for (BackendElement element : backendElements)
    {
      try
      {
        element.disposeBackend();
      }
      catch (Exception ignore)
      {
        ; // Intentionally empty
      }
    }

    if (container != null)
    {
      try
      {
        container.stop();
      }
      catch (Exception ignore)
      {
        ; // Intentionally empty
      }
      container = null;
    }

    plugin = null;
  }

  public Acceptor getAcceptor()
  {
    return acceptor;
  }

  public List<BackendElement> getBackendElements()
  {
    return backendElements;
  }

  public static Container getNet4jContainer()
  {
    if (container == null)
    {
      String baseResourcePath;

      try
      {
        baseResourcePath = getBundleLocation(getDefault().getBundle());
      }
      catch (IOException ex)
      {
        throw new ContainerCreationException("Error while computing location of bundle "
            + getDefault().getBundle(), ex);
      }

      String location = CONTEXT_PATH + "net4j.xml";
      String name = "net4j";
      Container parent = null;
      ClassLoader classLoader = getDefault().getClassLoader();
      container = new ContainerImpl(baseResourcePath, location, name, parent, classLoader);
    }

    return container;
  }

  public static ITempManager getTempManager()
  {
    return (ITempManager) getNet4jContainer().getBean("tempManager");
  }


  public static class BackendElement extends ExecutableElement
  {
    protected String name;

    protected Container container;

    public String getName()
    {
      return name;
    }

    public void setName(String url)
    {
      this.name = url;
    }

    public Container getContainer()
    {
      return container;
    }

    public void initializeBackend(Container parent) throws CoreException
    {
      IBackendInitializer initializer = createInitializer();
      container = initializer.initializeContainer(name, parent);
    }

    public void disposeBackend()
    {
      if (container != null)
      {
        container.stop();
        container = null;
      }
    }

    public String toString()
    {
      return "Backend(" + name + ", " + className + ")";
    }

    private IBackendInitializer createInitializer() throws CoreException
    {
      return (IBackendInitializer) createExecutableExtension();
    }
  }


  public static class BackendExtensionParser extends ListExtensionParser
  {
    public BackendExtensionParser(List<BackendElement> list)
    {
      super(list);

      addFactory("backend", new Element.Factory()
      {
        public Element createElementData()
        {
          return new BackendElement();
        }
      });
    }
  }

}
