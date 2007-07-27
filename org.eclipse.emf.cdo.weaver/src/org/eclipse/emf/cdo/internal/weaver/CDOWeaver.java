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

import org.eclipse.net4j.util.ImplementationError;
import org.eclipse.net4j.util.ReflectUtil;
import org.eclipse.net4j.util.WrappedException;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;

import org.aspectj.weaver.tools.GeneratedClassHandler;
import org.aspectj.weaver.tools.WeavingAdaptor;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.security.CodeSource;

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

  public void test()
  {
    try
    {
      URL urls[] = { new File("/org.eclipse.emf.ecore_2.3.1.v200707242120.jar").toURL() };

      URL[] aspectURLs = { getAspectURL() };
      URL[] classURLs = new URL[urls.length + 2];
      System.arraycopy(urls, 0, classURLs, 2, urls.length);
      classURLs[0] = getEMFCommonURL();
      classURLs[1] = getCDOStubURL();

      ClassLoader classLoader = new CDOWeaverURLClassLoader(classURLs, aspectURLs, null)
      {
        @Override
        protected void woven(String name, byte[] newb, CodeSource cs)
        {
          System.out.println("Woven " + name);
        }
      };

      Class<?> c = classLoader.loadClass("org.eclipse.emf.ecore.impl.EObjectImpl");
      Method method = ReflectUtil.getMethod(c, "getPersistenceCallback");
      if (method == null)
      {
        throw new ImplementationError();
      }
    }
    catch (Throwable t)
    {
      t.printStackTrace();
    }
  }

  public WeavingAdaptor weave(URL[] urls)
  {
    // ClassLoader parent = OM.class.getClassLoader();
    URL[] aspectURLs = { getAspectURL() };
    URL[] classURLs = new URL[urls.length + 2];
    System.arraycopy(urls, 0, classURLs, 2, urls.length);
    classURLs[0] = getEMFCommonURL();
    classURLs[1] = getCDOStubURL();
    WeavingAdaptor weavingAdaptor = new WeavingAdaptor(new GeneratedClassHandler()
    {
      public void acceptClass(String name, byte[] bytes)
      {
        System.out.println("acceptClass: " + name);
      }
    }, classURLs, aspectURLs);

    return weavingAdaptor;
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
