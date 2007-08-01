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
import org.eclipse.emf.cdo.weaver.BundleInfo;
import org.eclipse.emf.cdo.weaver.ICDOWeaver;

import org.eclipse.net4j.util.ImplementationError;
import org.eclipse.net4j.util.WrappedException;
import org.eclipse.net4j.util.io.IOFilter;
import org.eclipse.net4j.util.io.IORuntimeException;
import org.eclipse.net4j.util.io.IOUtil;
import org.eclipse.net4j.util.io.NIOUtil;
import org.eclipse.net4j.util.io.TMPUtil;
import org.eclipse.net4j.util.io.ZIPUtil;
import org.eclipse.net4j.util.io.ZIPUtil.UnzipHandler;
import org.eclipse.net4j.util.om.monitor.MonitorUtil;
import org.eclipse.net4j.util.om.monitor.OMMonitor;
import org.eclipse.net4j.util.om.monitor.OMSubMonitor;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;

import org.aspectj.weaver.tools.GeneratedClassHandler;
import org.aspectj.weaver.tools.WeavingAdaptor;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * @author Eike Stepper
 */
public class CDOWeaver implements ICDOWeaver
{
  public static final CDOWeaver INSTANCE = new CDOWeaver();

  private static final String[] ASPECT_TYPES = { "CDOAspectList", "CDOAspectMixin", "CDOAspectObject", "CDOAware",
      "CDOCallback" };

  private static final String MANIFEST_PATH = "/META-INF/MANIFEST.MF".replace('/', File.separatorChar);

  private static final String ASPECTJ_RT_PATH = "/aspectjrt".replace('/', File.separatorChar);

  private static final String ASPECTJ_WEAVER_PATH = "/aspectjweaver.jar".replace('/', File.separatorChar);

  private static final String MIXIN_PATH = "/mixin".replace('/', File.separatorChar);

  private static final String ECORE_PATH = "/org/eclipse/emf/ecore/impl".replace('/', File.separatorChar);

  private static final String BUNDLE_VERSION_HEADER = Constants.BUNDLE_VERSION.toLowerCase();

  private static final String CDO_VERSION_SUFFIX = "-CDO";

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
      basicClassURLs = new URL[] { getRTJarURL(), getAspectJRuntimeURL(), getAspectJWeaverURL(), getEMFCommonURL() };
    }
  }

  public void weave(Collection<BundleInfo> bundleInfos) throws IORuntimeException
  {
    int count = bundleInfos.size();
    OMMonitor monitor = MonitorUtil.begin(count, "Weaving " + count + " bundles");
    URL[] classURLs = getClassURLs(bundleInfos);
    URL[] aspectURLs = { getAspectURL() };

    for (BundleInfo bundleInfo : bundleInfos)
    {
      OMSubMonitor subMonitor = monitor.fork();
      try
      {
        weaveBundle(bundleInfo, classURLs, aspectURLs);
      }
      finally
      {
        subMonitor.join();
      }
    }
  }

  private File weaveBundle(BundleInfo bundleInfo, URL[] classURLs, URL[] aspectURLs)
  {
    String name = bundleInfo.getName();
    File bundleLocation = bundleInfo.getLocation();
    boolean dir = bundleLocation.isDirectory();
    OMMonitor monitor = MonitorUtil.begin(dir ? 2 : 4, "Weaving bundle " + name);

    WeavingAdaptor weavingAdaptor = new WeavingAdaptor(new WeavingHandler(), classURLs, aspectURLs);
    monitor.worked("Initialized weaving adapter");

    File unzippedFolder = null;
    File wovenFolder = null;

    try
    {
      if (dir)
      {
        OMSubMonitor sm = monitor.fork();
        try
        {
          wovenFolder = new File(bundleLocation.getParentFile(), getTargetName(bundleInfo));
          weaveFolder(bundleInfo, bundleLocation, wovenFolder, weavingAdaptor);
        }
        finally
        {
          sm.join("Woven bundle " + name);
        }

        return wovenFolder;
      }

      OMSubMonitor sm1 = monitor.fork();
      try
      {
        unzippedFolder = TMPUtil.createTempFolder(name + "-unzipped");
        ZIPUtil.unzip(bundleLocation, unzippedFolder);
      }
      finally
      {
        sm1.join("Unzipped bundle " + name);
      }

      OMSubMonitor sm2 = monitor.fork();
      try
      {
        wovenFolder = TMPUtil.createTempFolder(name + "-woven");
        weaveFolder(bundleInfo, unzippedFolder, wovenFolder, weavingAdaptor);
      }
      finally
      {
        sm2.join("Woven bundle " + name);
      }

      File jarFile = new File(bundleLocation.getParentFile(), getTargetName(bundleInfo) + ICDOWeaver.JAR_SUFFIX);
      OMSubMonitor sm3 = monitor.fork();
      try
      {
        ZIPUtil.zip(wovenFolder, true, jarFile);
      }
      finally
      {
        sm3.join("Zipped bundle " + name);
      }

      return jarFile;
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

  private void weaveFolder(BundleInfo bundleInfo, File sourceFolder, File targetFolder, WeavingAdaptor weavingAdaptor)
  {
    int sourceLength = sourceFolder.getAbsolutePath().length();
    List<File> sources = IOUtil.listBreadthFirst(sourceFolder);
    OMMonitor monitor = MonitorUtil.begin(3 * sources.size(), "Processing " + sourceFolder.getAbsolutePath());

    for (File source : sources)
    {
      String path = source.getAbsolutePath().substring(sourceLength);
      File target = new File(targetFolder, path);

      if (source.isDirectory())
      {
        boolean exists = target.exists();
        if (!exists)
        {
          target.mkdirs();
        }

        if (path.equals(ECORE_PATH))
        {
          mixinEcore(target, monitor);
          copyAspectJRT(targetFolder, monitor);
        }

        monitor.worked(3, exists ? null : "Created folder " + target.getAbsolutePath());
      }
      else
      {
        weaveFile(bundleInfo, source, target, path, weavingAdaptor, monitor);
      }
    }
  }

  private void weaveFile(BundleInfo bundleInfo, File source, File target, String path, WeavingAdaptor weavingAdaptor,
      OMMonitor monitor)
  {
    String name = source.getName();
    if (name.endsWith(CLASS_SUFFIX))
    {
      weaveClass(source, target, path, weavingAdaptor, monitor);
    }
    else
    {
      boolean isManifest = path.equalsIgnoreCase(MANIFEST_PATH);
      OMSubMonitor sm = monitor.fork(3);
      try
      {
        if (isManifest)
        {
          IOUtil.copyText(source, target, new ReversioningFilter(bundleInfo.getVersion()));
        }
        else
        {
          NIOUtil.copyFile(source, target);
        }
      }
      finally
      {
        sm.join(isManifest ? "Reversioned " + MANIFEST_PATH : "Copied file "
            + (path.length() == 0 ? File.separator : path));
      }
    }
  }

  private void weaveClass(File source, File target, String path, WeavingAdaptor weavingAdaptor, OMMonitor monitor)
      throws ImplementationError
  {
    try
    {
      String className = path.substring(1, path.length() - CLASS_SUFFIX.length()).replace(File.separatorChar, '.');

      byte[] inBytes = null;
      OMSubMonitor sm1 = monitor.fork();
      try
      {
        inBytes = IOUtil.readFile(source);
      }
      finally
      {
        sm1.join();
      }

      byte[] outBytes = null;
      OMSubMonitor sm2 = monitor.fork();
      try
      {
        outBytes = weavingAdaptor.weaveClass(className, inBytes);
        if (outBytes == null)
        {
          throw new ImplementationError();
        }
      }
      finally
      {
        if (outBytes == null)
        {
          sm2.join();
        }
        else
        {
          sm2.join();
        }
      }

      boolean unchanged = Arrays.equals(inBytes, outBytes);
      OMSubMonitor sm3 = monitor.fork();
      try
      {
        IOUtil.writeFile(target, outBytes);
      }
      finally
      {
        sm3.join((unchanged ? "Copied class " : "Woven class ") + className);
      }
    }
    catch (IOException ex)
    {
      throw new IORuntimeException(ex);
    }
  }

  private void mixinEcore(File ecoreFolder, OMMonitor monitor)
  {
    String path = (MIXIN_PATH + ECORE_PATH).replace(File.separatorChar, '/') + "/";
    Bundle bundle = bundleContext.getBundle();
    for (String type : ASPECT_TYPES)
    {
      InputStream input = null;
      OutputStream output = IOUtil.openOutputStream(new File(ecoreFolder, type + CLASS_SUFFIX));

      try
      {
        URL entry = bundle.getEntry(path + type + CLASS_SUFFIX);
        input = entry.openStream();
        IOUtil.copy(input, output);
      }
      catch (IOException ex)
      {
        throw new IORuntimeException(ex);
      }
      finally
      {
        IOUtil.closeSilent(input);
        IOUtil.closeSilent(output);
      }

      monitor.message("Mixed in org.eclipse.emf.ecore.impl." + type);
    }
  }

  private void copyAspectJRT(File targetFolder, OMMonitor monitor)
  {
    Bundle bundle = bundleContext.getBundle();
    URL entry = getURL(bundle, ASPECTJ_RT_PATH);
    File rtFolder = new File(entry.getFile());
    int rtLength = rtFolder.getAbsolutePath().length();

    List<File> sources = IOUtil.listBreadthFirst(rtFolder);
    for (File source : sources)
    {
      if (source.isFile())
      {
        String path = source.getAbsolutePath().substring(rtLength);
        File target = new File(targetFolder, path);
        NIOUtil.copyFile(source, target);

        String className = path.substring(1, path.length() - CLASS_SUFFIX.length()).replace(File.separatorChar, '.');
        monitor.message("Copied class " + className);
      }
    }
  }

  private String getTargetName(BundleInfo bundleInfo)
  {
    return bundleInfo.getName() + "_" + bundleInfo.getVersion() + CDO_VERSION_SUFFIX;
  }

  private URL getAspectJRuntimeURL()
  {
    return getURL(bundleContext.getBundle(), ASPECTJ_RT_PATH.replace(File.separatorChar, '/'));
  }

  private URL getAspectJWeaverURL()
  {
    return getURL(bundleContext.getBundle(), ASPECTJ_WEAVER_PATH.replace(File.separatorChar, '/'));
  }

  private URL getEMFCommonURL()
  {
    return getBundleURL("org.eclipse.emf.common");
  }

  private URL getAspectURL()
  {
    return getURL(bundleContext.getBundle(), MIXIN_PATH.replace(File.separatorChar, '/'));
  }

  private URL[] getClassURLs(Collection<BundleInfo> bundleInfos)
  {
    URL[] classURLs = new URL[basicClassURLs.length + bundleInfos.size()];
    System.arraycopy(basicClassURLs, 0, classURLs, 0, basicClassURLs.length);
    int i = 0;
    for (BundleInfo bundleInfo : bundleInfos)
    {
      File bundleLocation = bundleInfo.getLocation();
      if (!bundleLocation.exists())
      {
        throw new IORuntimeException("Bundle not found: " + bundleLocation.getAbsolutePath());
      }

      try
      {
        classURLs[basicClassURLs.length + i++] = bundleLocation.toURL();
      }
      catch (MalformedURLException ex)
      {
        throw new IORuntimeException(ex);
      }
    }

    return classURLs;
  }

  public static void main(String[] args) throws Exception
  {
    // XXX
    // ZIPUtil.unzip(new
    // File("C:\\ws\\cdo.0.8.0\\.metadata\\org.eclipse.emf.ecore_2.3.1.v200707242120.zip"),
    // new UnzipHandler()
    // {
    // public void unzipDirectory(String name) throws IOException
    // {
    // System.out.println(name);
    // }
    //
    // public void unzipFile(String name, InputStream zipStream) throws
    // IOException
    // {
    // System.out.println(name);
    // }
    // });
    //
    // System.out.println();
    // System.out.println();
    // System.out.println();
    // System.out.println();
    // System.out.println();
    // System.out.println();
    // System.out.println();

    ZIPUtil.unzip(new File("C:\\develop\\eclipse\\plugins\\org.eclipse.emf.ecore_2.3.1.v200707242120-CDO.jar"),
        new UnzipHandler()
        {
          public void unzipDirectory(String name) throws IOException
          {
            System.out.println(name);
          }

          public void unzipFile(String name, InputStream zipStream) throws IOException
          {
            System.out.println(name);
          }
        });
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
      return FileLocator.toFileURL(url);
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

  /**
   * @author Eike Stepper
   */
  private static final class ReversioningFilter implements IOFilter<String>
  {
    private String version;

    private ReversioningFilter(String version)
    {
      this.version = version;
    }

    public String filter(String line)
    {
      if (line.toLowerCase().startsWith(BUNDLE_VERSION_HEADER))
      {
        line = line.replaceFirst(version, version + CDO_VERSION_SUFFIX);
      }

      return line;
    }
  }

  /**
   * @author Eike Stepper
   */
  private static final class WeavingHandler implements GeneratedClassHandler
  {
    public WeavingHandler()
    {
    }

    public void acceptClass(String name, byte[] bytes)
    {
      throw new ImplementationError("Must have overseen something");
    }
  }
}
