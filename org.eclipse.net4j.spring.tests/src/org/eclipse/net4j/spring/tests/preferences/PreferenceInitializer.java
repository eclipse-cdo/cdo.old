package org.eclipse.net4j.spring.test.preferences;


import org.eclipse.net4j.spring.test.Net4jSpringTestPlugin;

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
    IPreferenceStore store = Net4jSpringTestPlugin.getDefault().getPreferenceStore();
    store.setDefault(PreferenceConstants.P_BOOLEAN, true);
    store.setDefault(PreferenceConstants.P_CHOICE, "choice2");
    store.setDefault(PreferenceConstants.P_STRING, "Default value");
  }

}
