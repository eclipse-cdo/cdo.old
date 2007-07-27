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

import org.eclipse.emf.cdo.weaver.ICDOWeaver;

import org.eclipse.net4j.util.WrappedException;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;

import org.aspectj.weaver.loadtime.WeavingURLClassLoader;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;

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

  public void setBundleContext(BundleContext bundleContext)
  {
    this.bundleContext = bundleContext;
  }

  public ClassLoader weave(URL[] urls)
  {
    // ClassLoader parent = OM.class.getClassLoader();
    URL[] aspectURLs = { getAspectURL() };
    URL[] classURLs = new URL[urls.length + 2];
    System.arraycopy(urls, 0, classURLs, 2, urls.length);
    classURLs[0] = getEMFCommonURL();
    classURLs[1] = getCDOStubURL();
    WeavingURLClassLoader classLoader = new WeavingURLClassLoader(classURLs, aspectURLs, null)
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

  private URL getEMFCommonURL()
  {
    return getURL(Platform.getBundle("org.eclipse.emf.common"), "/");
  }

  private URL getCDOStubURL()
  {
    return getURL(bundleContext.getBundle(), "lib/cdo-stub.jar");
  }

  private URL getAspectURL()
  {
    return getURL(bundleContext.getBundle(), "lib/persistence-aspect.jar");
  }

  private URL getURL(Bundle bundle, String path)
  {
    try
    {
      URL url = bundle.getEntry(path);
      url = FileLocator.toFileURL(url);
      return url;
    }
    catch (IOException ex)
    {
      throw WrappedException.wrap(ex);
    }
  }
}
