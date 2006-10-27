package org.eclipse.emf.cdo.examples.ui.internal.preferences;

import org.eclipse.emf.cdo.examples.ui.internal.ExampleUIActivator;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.ColorFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

/**
 * This class represents a preference page that is contributed to the
 * Preferences dialog. By subclassing <samp>FieldEditorPreferencePage</samp>,
 * we can use the field support built into JFace that allows us to create a page
 * that is small and knows how to save, restore and apply itself.
 * <p>
 * This page is used to modify preferences only. They are stored in the
 * preference store that belongs to the main plug-in class. That way,
 * preferences can be accessed directly via the preference store.
 */
public class CDOEditorPreferencePage extends FieldEditorPreferencePage implements
    IWorkbenchPreferencePage
{
  public CDOEditorPreferencePage()
  {
    super(GRID);
    setPreferenceStore(ExampleUIActivator.getPlugin().getPreferenceStore());
    setDescription("CDO Editor preferences");
  }

  /**
   * Creates the field editors. Field editors are abstractions of the common GUI
   * blocks needed to manipulate various types of preferences. Each field editor
   * knows how to save and restore itself.
   */
  public void createFieldEditors()
  {
    final Composite parent = getFieldEditorParent();
    addField(new BooleanFieldEditor(PreferenceConstants.PREF_AUTO_RELOAD,
        "&Auto reload invalidated objects", parent));
    addField(new ColorFieldEditor(PreferenceConstants.PREF_INVALIDATION_COLOR,
        "&Color of invalidated objects", parent));
    addField(new BooleanFieldEditor(PreferenceConstants.PREF_SHOW_CHANGES, "Show changes in &bold",
        parent));
    addField(new BooleanFieldEditor(PreferenceConstants.PREF_SHOW_CONFLICTS,
        "Show conflicts in &red", parent));
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
   */
  public void init(IWorkbench workbench)
  {
  }
}
