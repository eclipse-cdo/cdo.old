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
package org.eclipse.net4j.examples.prov.server;


import org.eclipse.net4j.examples.prov.server.protocol.ProvisioningServerProtocol;
import org.eclipse.net4j.examples.server.internal.ExampleServerPlugin;
import org.eclipse.net4j.spring.Container;
import org.eclipse.net4j.spring.ContainerCreationException;
import org.eclipse.net4j.spring.impl.ContainerImpl;
import org.eclipse.net4j.util.eclipse.AbstractPlugin;
import org.eclipse.net4j.util.eclipse.ResourcesHelper;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;

import java.io.IOException;
import java.net.URL;


public class ProvServerPlugin extends AbstractPlugin
{
  public static final String PROJECT_NAME = "Provisioning";

  public static final String PLUGIN_RESOURCES_NAME = "resources";

  public static final String DOCUMENT_ROOT_NAME = "site";

  public static final String CONTEXT_PATH = "META-INF/";

  // The shared instance.
  private static ProvServerPlugin plugin;

  private static Container container;

  private static IProject project;

  /**
   * The constructor.
   */
  public ProvServerPlugin()
  {
    if (plugin == null) plugin = this;
  }

  /**
   * Returns the shared instance.
   */
  public static ProvServerPlugin getDefault()
  {
    return plugin;
  }

  protected void doStart() throws Exception
  {
    try
    {
      copyPluginResource("favicon.ico");
      copyPluginResource("index.html");
      copyPluginResource("web/site.css");
      copyPluginResource("web/site.xsl");
    }
    catch (Exception ex)
    {
      throw new HttpdException("Error while initializing HTML pages", ex);
    }
  }

  protected void doStop() throws Exception
  {
    if (container != null)
    {
      container.close();
      container = null;
    }

    plugin = null;
  }

  public static Container getContainer()
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

      String location = CONTEXT_PATH + "density.server.provisioning.xml";
      String name = "provisioning";
      Container parent = ExampleServerPlugin.getNet4jContainer();
      ClassLoader classLoader = getDefault().getClassLoader();
      container = new ContainerImpl(baseResourcePath, location, name, parent, classLoader);
    }

    return container;
  }

  public static ProvisioningServerProtocol getProvisioningServerProtocol()
  {
    return (ProvisioningServerProtocol)getContainer().getBean("provisioningServerProtocol");
  }

  public static SiteHttpd getHttpd()
  {
    return (SiteHttpd)getContainer().getBean("httpd");
  }

  public static DateFormatter getDateFormatter()
  {
    return (DateFormatter)getContainer().getBean("dateFormatter");
  }

  public static UrlCodec getUrlCodec()
  {
    return (UrlCodec)getContainer().getBean("urlCodec");
  }

  public static SiteManager getSiteManager()
  {
    return (SiteManager)getContainer().getBean("siteManager");
  }

  public static IProject getProject()
  {
    if (project == null)
    {
      try
      {
        project = ResourcesHelper.ensureProject(PROJECT_NAME);
      }
      catch (CoreException ex)
      {
        throw new ProvException("Error while creating project " + PROJECT_NAME, ex);
      }
    }

    return project;
  }

  public static void copyPluginResource(String path) throws IOException, CoreException
  {
    IFile file = getProject().getFile(new Path(DOCUMENT_ROOT_NAME + "/" + path));
    copyPluginResource(PLUGIN_RESOURCES_NAME + "/" + path, file);
  }

  public static void copyPluginResource(String fromPath, IFile toFile) throws IOException,
          CoreException
  {
    if (toFile.exists())
    {
      return;
    }

    if (toFile.getParent() != null && toFile.getParent() instanceof IFolder)
    {
      ResourcesHelper.mkdirs((IFolder)toFile.getParent(), new NullProgressMonitor());
    }

    URL url = getDefault().getBundle().getEntry(fromPath);
    String[] content = ResourcesHelper.readFileIntoStringArray(url.openStream());
    ResourcesHelper.writeFile(toFile, content, new NullProgressMonitor());
  }
}
