/*
 * Copyright (c) 2008 Open Canarias S.L. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *    Victor Roldan Betancort - GMF models creation and initial generation
 *    Eike Stepper - maintenance
 */
package org.eclipse.emf.cdo.tests.model1.diagram.preferences;

import org.eclipse.emf.cdo.tests.model1.diagram.part.Model1DiagramEditorPlugin;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

/**
 * @generated
 */
public class DiagramPreferenceInitializer extends AbstractPreferenceInitializer
{

  /**
   * @generated
   */
  public void initializeDefaultPreferences()
  {
    IPreferenceStore store = getPreferenceStore();
    DiagramPrintingPreferencePage.initDefaults(store);
    DiagramGeneralPreferencePage.initDefaults(store);
    DiagramAppearancePreferencePage.initDefaults(store);
    DiagramConnectionsPreferencePage.initDefaults(store);
    DiagramRulersAndGridPreferencePage.initDefaults(store);
  }

  /**
   * @generated
   */
  protected IPreferenceStore getPreferenceStore()
  {
    return Model1DiagramEditorPlugin.getInstance().getPreferenceStore();
  }
}
