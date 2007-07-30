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

import org.eclipse.net4j.util.ImplementationError;
import org.eclipse.net4j.util.WrappedException;
import org.eclipse.net4j.util.io.IORuntimeException;
import org.eclipse.net4j.util.io.IOUtil;
import org.eclipse.net4j.util.io.NIOUtil;
import org.eclipse.net4j.util.io.TMPUtil;
import org.eclipse.net4j.util.io.ZIPUtil;
import org.eclipse.net4j.util.om.monitor.MonitorUtil;
import org.eclipse.net4j.util.om.monitor.OMMonitor;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;

import org.aspectj.weaver.tools.GeneratedClassHandler;
import org.aspectj.weaver.tools.WeavingAdaptor;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

/**
 * @author Eike Stepper
 */
public class CDOWeaver implements ICDOWeaver
{
  private static final String JAR_SUFFIX = ".jar";

  private static final String CLASS_SUFFIX = ".class";

  public static final CDOWeaver INSTANCE = new CDOWeaver();

  private BundleContext bundleContext;

  private URL[] basicClassURLs;

  private CDOWeaver()
  {
  }

  public void setBundleContext(BundleContext bundleContext)
  {
    this.bundleContext = bundleContext;
    if (bundleContext != null)
    {
      basicClassURLs = new URL[] { getRTJarURL(), getAspectJRuntimeURL(), getAspectJWeaverURL(), getEMFCommonURL(),
          getCDOStubURL() };
    }
  }

  public File[] weave(final File[] bundleLocations) throws IORuntimeException
  {
    OMMonitor monitor = MonitorUtil.begin(bundleLocations.length, "Converting " + bundleLocations.length + " bundles");
    final File[] newBundleLocations = new File[bundleLocations.length];
    final URL[] classURLs = getClassURLs(bundleLocations);
    final URL[] aspectURLs = { getAspectURL() };

    for (int i = 0; i < bundleLocations.length; i++)
    {
      final int ii = i;
      monitor.fork(new Runnable()
      {
        public void run()
        {
          newBundleLocations[ii] = weaveBundle(bundleLocations[ii], classURLs, aspectURLs);
        }
      }, "Woven bundle " + bundleLocations[i]);
    }

    return newBundleLocations;
  }

  private File weaveBundle(File bundleLocation, URL[] classURLs, URL[] aspectURLs)
  {
    OMMonitor monitor = MonitorUtil.begin(2, "Converting bundle " + bundleLocation.getAbsolutePath());
    final WeavingAdaptor weavingAdaptor = new WeavingAdaptor(new WeaverHandler(), classURLs, aspectURLs);
    monitor.worked("Initialized weaving adapter");

    File unzippedFolder = null;
    File wovenFolder = null;

    try
    {
      String name = bundleLocation.getName();
      if (bundleLocation.isDirectory())
      {
        wovenFolder = new File(bundleLocation.getParentFile(), getTargetName(name));
        weaveFolder(bundleLocation, wovenFolder, "", weavingAdaptor);

        return wovenFolder;
      }

      if (name.endsWith(JAR_SUFFIX))
      {
        name = name.substring(0, name.length() - JAR_SUFFIX.length());
        unzippedFolder = TMPUtil.createTempFolder(name + "-unzipped");
        ZIPUtil.unzip(bundleLocation, unzippedFolder);

        wovenFolder = TMPUtil.createTempFolder(name + "-woven");
        weaveFolder(unzippedFolder, wovenFolder, "", weavingAdaptor);

        File jarFile = new File(bundleLocation.getParentFile(), getTargetName(name) + JAR_SUFFIX);
        ZIPUtil.zip(jarFile, wovenFolder, true);

        return jarFile;
      }
    }
    catch (RuntimeException ex)
    {
      OM.LOG.error(ex);
      IOUtil.delete(wovenFolder);
    }
    finally
    {
      IOUtil.delete(unzippedFolder);
      monitor.worked();
    }

    return null;
  }

  private void weaveFolder(File sourceFolder, File targetFolder, String path, WeavingAdaptor weavingAdaptor)
  {
    File source = new File(sourceFolder, path);
    File target = new File(targetFolder, path);

    if (source.isDirectory())
    {
      if (!target.exists())
      {
        target.mkdirs();
        System.out.println("Created folder " + target.getAbsolutePath());
      }

      for (String name : source.list())
      {
        weaveFolder(sourceFolder, targetFolder, path + File.separator + name, weavingAdaptor);
      }
    }
    else
    {
      String name = source.getName();
      if (name.endsWith(CLASS_SUFFIX))
      {
        try
        {
          String className = path.substring(1, path.length() - CLASS_SUFFIX.length()).replace(File.separatorChar, '.');
          byte[] inBytes = IOUtil.readFile(source);
          byte[] outBytes = weavingAdaptor.weaveClass(className, inBytes);
          if (outBytes == null)
          {
            throw new ImplementationError();
          }

          IOUtil.writeFile(target, outBytes);
          if (Arrays.equals(inBytes, outBytes))
          {
            System.out.println("Copied file    " + target.getAbsolutePath());
          }
          else
          {
            System.out.println("Woven class    " + className);
          }
        }
        catch (IOException ex)
        {
          throw new IORuntimeException(ex);
        }
      }
      else
      {
        NIOUtil.copyFile(source, target);
        System.out.println("Copied file    " + target.getAbsolutePath());
      }
    }
  }

  private String getTargetName(String name)
  {
    return name + "-CDO";
  }

  private URL getAspectJRuntimeURL()
  {
    Bundle bundle = Platform.getBundle("org.aspectj.runtime");
    return getURL(bundle, "aspectjrt.jar");
  }

  private URL getAspectJWeaverURL()
  {
    Bundle bundle = Platform.getBundle("org.aspectj.weaver");
    return getURL(bundle, "aspectjweaver.jar");
  }

  private URL getEMFCommonURL()
  {
    return getBundleURL("org.eclipse.emf.common");
  }

  private URL getCDOStubURL()
  {
    return getURL(bundleContext.getBundle(), "lib/cdo-stub.jar");
  }

  private URL getAspectURL()
  {
    return getURL(bundleContext.getBundle(), "lib/persistence-aspect.jar");
  }

  private URL[] getClassURLs(File[] bundleLocations)
  {
    URL[] classURLs = new URL[basicClassURLs.length + bundleLocations.length];
    System.arraycopy(basicClassURLs, 0, classURLs, 0, basicClassURLs.length);
    for (int i = 0; i < bundleLocations.length; i++)
    {
      File bundleLocation = bundleLocations[i];
      if (!bundleLocation.exists())
      {
        throw new IORuntimeException("Bundle not found: " + bundleLocation.getAbsolutePath());
      }

      try
      {
        classURLs[basicClassURLs.length + i] = bundleLocation.toURL();
      }
      catch (MalformedURLException ex)
      {
        throw new IORuntimeException(ex);
      }
    }

    return classURLs;
  }

  public static URL getRTJarURL()
  {
    try
    {
      String javaHome = System.getProperty("java.home");
      File javaLib = new File(javaHome, "lib");
      File rtJar = new File(javaLib, "rt.jar");
      return rtJar.toURL();
    }
    catch (MalformedURLException ex)
    {
      throw WrappedException.wrap(ex);
    }
  }

  public static URL getURL(Bundle bundle, String path)
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

  public static URL getBundleURL(String symbolicName)
  {
    return getURL(Platform.getBundle(symbolicName), "/");
  }

  public static URL[] addURLs(URL[] urls1, URL[] urls2)
  {
    URL[] result = new URL[urls1.length + urls2.length];
    System.arraycopy(urls1, 0, result, 0, urls1.length);
    System.arraycopy(urls2, 0, result, urls1.length, urls2.length);
    return result;
  }

  /**
   * @author Eike Stepper
   */
  private final class WeaverHandler implements GeneratedClassHandler
  {
    public WeaverHandler()
    {
    }

    public void acceptClass(String name, byte[] bytes)
    {
      throw new ImplementationError("Must have overseen something");
    }
  }
}
