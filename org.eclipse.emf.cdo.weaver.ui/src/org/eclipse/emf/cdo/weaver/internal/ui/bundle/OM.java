/***************************************************************************
 * Copyright (c) 2004-2007 Eike Stepper, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 **************************************************************************/
package org.eclipse.emf.cdo.weaver.internal.ui.bundle;

import org.eclipse.emf.cdo.util.CDOUtil;
import org.eclipse.emf.cdo.weaver.BundleInfo;
import org.eclipse.emf.cdo.weaver.ICDOWeaver;
import org.eclipse.emf.cdo.weaver.internal.ui.ConfirmWeaveDialog;

import org.eclipse.net4j.ui.UIActivator;
import org.eclipse.net4j.util.StringUtil;
import org.eclipse.net4j.util.WrappedException;
import org.eclipse.net4j.util.om.OMBundle;
import org.eclipse.net4j.util.om.OMPlatform;
import org.eclipse.net4j.util.om.log.OMLogger;
import org.eclipse.net4j.util.om.pref.OMPreference;
import org.eclipse.net4j.util.om.pref.OMPreferences;
import org.eclipse.net4j.util.om.trace.OMTracer;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.update.configuration.IConfiguredSite;
import org.eclipse.update.configuration.IInstallConfiguration;
import org.eclipse.update.configuration.ILocalSite;
import org.eclipse.update.core.ISite;
import org.eclipse.update.core.SiteManager;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;

import java.io.File;
import java.net.URL;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author Eike Stepper
 */
public abstract class OM
{
  private static final String EMF_EXT_POINT = "org.eclipse.emf.ecore.generated_package";

  public static final String BUNDLE_ID = "org.eclipse.emf.cdo.weaver.ui"; //$NON-NLS-1$

  public static final OMBundle BUNDLE = OMPlatform.INSTANCE.bundle(BUNDLE_ID, OM.class);

  public static final OMTracer DEBUG = BUNDLE.tracer("debug"); //$NON-NLS-1$

  public static final OMLogger LOG = BUNDLE.logger();

  public static final OMPreferences PREFS = BUNDLE.preferences();

  public static final OMPreference<String[]> PREF_IGNORED_BUNDLES = PREFS.initArray("PREF_IGNORED_BUNDLES");

  public static final OMPreference<Boolean> PREF_SHOW_IGNORED_BUNDLES = PREFS.init("PREF_SHOW_IGNORED_BUNDLES", false);

  public static final OMPreference<Boolean> PREF_CHECK_DURING_STARTUP = PREFS.init("PREF_CHECK_DURING_STARTUP", true);

  public static Set<String> getIgnoredBundles()
  {
    return new HashSet(Arrays.asList(PREF_IGNORED_BUNDLES.getValue()));
  }

  public static void setIgnoredBundles(Set<String> ignoredBundles)
  {
    OM.PREF_IGNORED_BUNDLES.setValue(ignoredBundles.toArray(new String[ignoredBundles.size()]));
  }

  public static void resetIgnoredBundles()
  {
    OM.PREF_IGNORED_BUNDLES.unSet();
  }

  public static Map<String, BundleInfo> getUnwovenBundles()
  {
    File[] siteLocations = null;
    Map<String, BundleInfo> bundleMap = new TreeMap();

    Set<String> persistentPackageURIs = CDOUtil.getPersistentPackageURIs();
    for (IConfigurationElement element : Platform.getExtensionRegistry().getConfigurationElementsFor(EMF_EXT_POINT))
    {
      String symbolicName = element.getContributor().getName();
      String uri = element.getAttribute("uri");
      if (!StringUtil.isEmpty(uri))
      {
        if (persistentPackageURIs.contains(uri))
        {
          continue;
        }

        BundleInfo bundleInfo = bundleMap.get(symbolicName);
        if (bundleInfo != null)
        {
          bundleInfo.addPackageURI(uri);
          continue;
        }

        Bundle bundle = Platform.getBundle(symbolicName);
        if (isAlreadyWoven(bundle))
        {
          continue;
        }

        if (siteLocations == null)
        {
          siteLocations = getSiteLocations();
        }

        String version = (String)bundle.getHeaders().get(Constants.BUNDLE_VERSION);
        File location = getLocation(symbolicName + "_" + version, siteLocations);
        bundleInfo = new BundleInfo(symbolicName, version, location);
        bundleInfo.addPackageURI(uri);
        bundleMap.put(symbolicName, bundleInfo);
      }
    }

    return bundleMap;
  }

  private static boolean isAlreadyWoven(Bundle bundle)
  {
    return bundle.getEntry(ICDOWeaver.CDO_MARKER) != null;
  }

  private static File[] getSiteLocations()
  {
    try
    {
      ILocalSite localSite = SiteManager.getLocalSite();
      IInstallConfiguration configuration = localSite.getCurrentConfiguration();
      IConfiguredSite[] configuredSites = configuration.getConfiguredSites();
      File[] siteLocations = new File[configuredSites.length];

      for (int i = 0; i < configuredSites.length; i++)
      {
        ISite site = configuredSites[i].getSite();
        URL url = site.getURL();
        siteLocations[i] = new File(url.getFile());
      }

      return siteLocations;
    }
    catch (CoreException ex)
    {
      throw WrappedException.wrap(ex);
    }
  }

  private static File getLocation(String versionedIdentifier, File[] siteLocations)
  {
    for (File siteLocation : siteLocations)
    {
      File pluginsFolder = new File(siteLocation, "plugins");
      File archive = new File(pluginsFolder, versionedIdentifier + ICDOWeaver.JAR_SUFFIX);
      if (archive.exists())
      {
        if (!archive.isFile())
        {
          return null;
        }

        return archive;
      }

      File folder = new File(pluginsFolder, versionedIdentifier);
      if (folder.exists())
      {
        if (!folder.isDirectory())
        {
          return null;
        }

        return folder;
      }
    }

    return null;
  }

  private static void confirmWeave()
  {
    if (!PREF_CHECK_DURING_STARTUP.getValue())
    {
      return;
    }

    final Map<String, BundleInfo> bundleMap = getUnwovenBundles();
    HashSet copy = new HashSet(bundleMap.keySet());
    copy.removeAll(getIgnoredBundles());
    if (copy.isEmpty())
    {
      return;
    }

    Display display = getDisplay();
    display.asyncExec(new Runnable()
    {
      public void run()
      {
        try
        {
          Dialog dialog = new ConfirmWeaveDialog(bundleMap);
          dialog.open();
        }
        catch (RuntimeException ex)
        {
          LOG.error(ex);
        }
      }
    });
  }

  /**
   * TODO Factor out
   */
  private static Display getDisplay()
  {
    Display display = Display.getCurrent();
    if (display == null)
    {
      display = Display.getDefault();
    }

    if (display == null)
    {
      display = new Display();
    }

    return display;
  }

  /**
   * @author Eike Stepper
   */
  public static final class Activator extends UIActivator
  {
    public static Activator INSTANCE;

    public Activator()
    {
      super(BUNDLE);
      INSTANCE = this;
    }

    @Override
    public void start(BundleContext context) throws Exception
    {
      super.start(context);

      try
      {
        confirmWeave();
      }
      catch (RuntimeException ex)
      {
        LOG.error(ex);
      }
    }
  }
}
