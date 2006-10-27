package org.eclipse.emf.cdo.examples.ui.internal.preferences;

import org.eclipse.emf.cdo.examples.ui.internal.ExampleUIActivator;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

/**
 * Class used to initialize default preference values.
 */
public class PreferenceInitializer extends AbstractPreferenceInitializer
{
  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer#initializeDefaultPreferences()
   */
  public void initializeDefaultPreferences()
  {
    IPreferenceStore store = ExampleUIActivator.getPlugin().getPreferenceStore();
    store.setDefault(PreferenceConstants.PREF_GLOBAL_EXTENTS, true);
    store.setDefault(PreferenceConstants.PREF_GLOBAL_XREFS, true);
    store.setDefault(PreferenceConstants.PREF_AUTO_RELOAD, true);
    store.setDefault(PreferenceConstants.PREF_INVALIDATION_COLOR, "0,0,255");
    store.setDefault(PreferenceConstants.PREF_SHOW_CHANGES, true);
    store.setDefault(PreferenceConstants.PREF_SHOW_CONFLICTS, true);
  }
}
