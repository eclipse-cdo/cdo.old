/***************************************************************************
 * Copyright (c) 2004 - 2007 Eike Stepper, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 **************************************************************************/
package org.eclipse.emf.cdo.internal.weaver;

import org.eclipse.emf.cdo.internal.weaver.bundle.OM;
import org.eclipse.emf.cdo.weaver.ICDOWeaver;

import org.eclipse.net4j.util.WrappedException;

import org.eclipse.core.runtime.FileLocator;

import org.aspectj.weaver.loadtime.WeavingURLClassLoader;
import org.osgi.framework.BundleContext;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * @author Eike Stepper
 */
public class CDOWeaver implements ICDOWeaver
{
  public static final CDOWeaver INSTANCE = new CDOWeaver();

  private BundleContext bundleContext;

  private CDOWeaver()
  {
  }

  public ClassLoader weave(URL[] classURLs)
  {
    ClassLoader parent = OM.class.getClassLoader();
    URL[] aspectURLs = { getAspectURL() };
    WeavingURLClassLoader classLoader = new WeavingURLClassLoader(classURLs, aspectURLs, parent)
    {
      @Override
      public void acceptClass(String name, byte[] bytes)
      {
        System.out.println("acceptClass: " + name);
        super.acceptClass(name, bytes);
      }
    };

    return classLoader;
  }

  private URL getAspectURL()
  {
    try
    {
      URL url = bundleContext.getBundle().getEntry("lib/persistence-aspect.jar");
      url = FileLocator.toFileURL(url);
      return url;
    }
    catch (IOException ex)
    {
      throw WrappedException.wrap(ex);
    }
  }

  public void setBundleContext(BundleContext bundleContext)
  {
    this.bundleContext = bundleContext;
  }

  public static void main(String[] args) throws Exception
  {
    URL classURLs[] = { new File("/org.eclipse.emf.ecore_2.3.1.v200707242120.jar").toURL() };
    INSTANCE.weave(classURLs);
  }
}
