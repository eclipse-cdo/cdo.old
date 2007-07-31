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
import org.eclipse.emf.cdo.weaver.internal.ui.ConfirmWeaveDialog;
import org.eclipse.emf.cdo.weaver.internal.ui.PackageInfo;

import org.eclipse.net4j.ui.UIActivator;
import org.eclipse.net4j.util.StringUtil;
import org.eclipse.net4j.util.om.OMBundle;
import org.eclipse.net4j.util.om.OMPlatform;
import org.eclipse.net4j.util.om.log.OMLogger;
import org.eclipse.net4j.util.om.pref.OMPreference;
import org.eclipse.net4j.util.om.pref.OMPreferences;
import org.eclipse.net4j.util.om.trace.OMTracer;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.widgets.Display;

import org.osgi.framework.BundleContext;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @author Eike Stepper
 */
public abstract class OM
{
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

  public static Map<String, SortedSet<PackageInfo>> getUnwovenBundles()
  {
    Set<String> persistentPackageURIs = CDOUtil.getPersistentPackageURIs();
    IConfigurationElement[] generatedPackages = Platform.getExtensionRegistry().getConfigurationElementsFor(
        "org.eclipse.emf.ecore.generated_package");
    Map<String, SortedSet<PackageInfo>> bundleMap = new TreeMap();

    for (IConfigurationElement generatedPackage : generatedPackages)
    {
      String symbolicName = generatedPackage.getContributor().getName();
      String uri = generatedPackage.getAttribute("uri");
      if (!StringUtil.isEmpty(uri))
      {
        if (!persistentPackageURIs.contains(uri))
        {
          SortedSet<PackageInfo> packageInfos = bundleMap.get(symbolicName);
          if (packageInfos == null)
          {
            packageInfos = new TreeSet();
            bundleMap.put(symbolicName, packageInfos);
          }

          packageInfos.add(new PackageInfo(uri, symbolicName));
        }
      }
    }

    return bundleMap;
  }

  private static void confirmWeave()
  {
    if (!PREF_CHECK_DURING_STARTUP.getValue())
    {
      return;
    }

    final Map<String, SortedSet<PackageInfo>> bundleMap = getUnwovenBundles();
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
