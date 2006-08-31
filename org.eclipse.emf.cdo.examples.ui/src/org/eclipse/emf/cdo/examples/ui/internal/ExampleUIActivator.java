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
package org.eclipse.emf.cdo.examples.ui.internal;


import org.eclipse.emf.cdo.client.internal.ClientActivator;
import org.eclipse.emf.cdo.examples.ui.internal.preferences.PreferenceConstants;
import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.ui.EclipseUIPlugin;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;
import org.osgi.framework.BundleContext;


public final class ExampleUIActivator extends EMFPlugin
{
  public static final ExampleUIActivator INSTANCE = new ExampleUIActivator();

  private static Implementation plugin;

  public ExampleUIActivator()
  {
    super(new ResourceLocator[] {ClientActivator.INSTANCE});
  }

  public ResourceLocator getPluginResourceLocator()
  {
    return plugin;
  }

  public static Implementation getPlugin()
  {
    return plugin;
  }

  public static class Implementation extends EclipseUIPlugin
  {
    private RGB invalidationColorSpec;

    private Color invalidationColor;

    public Implementation()
    {
      plugin = this;
    }

    @Override
    public void start(BundleContext context) throws Exception
    {
      super.start(context);
    }

    @Override
    public void stop(BundleContext context) throws Exception
    {
      if (invalidationColor != null)
      {
        invalidationColor.dispose();
        invalidationColor = null;
      }

      super.stop(context);
    }

    public boolean isGlobalExtents()
    {
      IPreferenceStore store = ExampleUIActivator.getPlugin().getPreferenceStore();
      return store.getBoolean(PreferenceConstants.PREF_GLOBAL_EXTENTS);
    }

    public boolean isGlobalXRefs()
    {
      IPreferenceStore store = ExampleUIActivator.getPlugin().getPreferenceStore();
      return store.getBoolean(PreferenceConstants.PREF_GLOBAL_XREFS);
    }

    public boolean isAutoReload()
    {
      IPreferenceStore store = ExampleUIActivator.getPlugin().getPreferenceStore();
      return store.getBoolean(PreferenceConstants.PREF_AUTO_RELOAD);
    }

    public Color getInvalidationColor()
    {
      IPreferenceStore store = ExampleUIActivator.getPlugin().getPreferenceStore();
      RGB spec = PreferenceConverter.getColor(store, PreferenceConstants.PREF_INVALIDATION_COLOR);
      if (spec != null && !spec.equals(invalidationColorSpec))
      {
        if (invalidationColor != null)
        {
          invalidationColor.dispose();
        }

        invalidationColor = new Color(Display.getDefault(), spec);
        invalidationColorSpec = spec;
      }

      return invalidationColor;
    }

    public boolean isShowChanges()
    {
      IPreferenceStore store = ExampleUIActivator.getPlugin().getPreferenceStore();
      return store.getBoolean(PreferenceConstants.PREF_SHOW_CHANGES);
    }

    public boolean isShowConflicts()
    {
      IPreferenceStore store = ExampleUIActivator.getPlugin().getPreferenceStore();
      return store.getBoolean(PreferenceConstants.PREF_SHOW_CONFLICTS);
    }
  }
}
