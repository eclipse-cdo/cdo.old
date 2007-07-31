package org.eclipse.emf.cdo.weaver.internal.ui;

import org.eclipse.emf.cdo.weaver.internal.ui.bundle.OM;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.eclipse.update.configuration.IConfiguredSite;
import org.eclipse.update.configuration.IInstallConfiguration;
import org.eclipse.update.configuration.ILocalSite;
import org.eclipse.update.core.IFeature;
import org.eclipse.update.core.IFeatureReference;
import org.eclipse.update.core.IPluginEntry;
import org.eclipse.update.core.ISite;
import org.eclipse.update.core.SiteManager;

/**
 * TODO Remove
 * 
 * @author Eike Stepper
 */
public class SampleAction implements IWorkbenchWindowActionDelegate
{
  public SampleAction()
  {
  }

  public void run(IAction action)
  {
    // OM.PREF_IGNORED_BUNDLES.unSet();

    try
    {
      Dialog dialog = new ConfirmWeaveDialog(OM.getUnwovenBundles());
      dialog.open();
    }
    catch (RuntimeException ex)
    {
      OM.LOG.error(ex);
    }
  }

  public void selectionChanged(IAction action, ISelection selection)
  {
  }

  public void dispose()
  {
  }

  public void init(IWorkbenchWindow window)
  {
  }

  private static void analyzeLocalSite()
  {
    try
    {
      ILocalSite localSite = SiteManager.getLocalSite();
      IInstallConfiguration configuration = localSite.getCurrentConfiguration();
      System.out.println("IInstallConfiguration: " + configuration.getLabel());

      IConfiguredSite[] configuredSites = configuration.getConfiguredSites();
      for (IConfiguredSite configuredSite : configuredSites)
      {
        ISite site = configuredSite.getSite();
        System.out.println("  ISite:\t" + site.getURL());

        IFeatureReference[] featureReferences = configuredSite.getFeatureReferences();
        for (IFeatureReference featureReference : featureReferences)
        {
          System.out.println("    IFeatureReference:\t" + featureReference.getName() + "\t"
              + featureReference.getVersionedIdentifier() + "\t" + featureReference.getURL());

          IFeature feature = featureReference.getFeature(new NullProgressMonitor());
          IPluginEntry[] pluginEntries = feature.getPluginEntries();
          for (IPluginEntry pluginEntry : pluginEntries)
          {
            System.out.println("      IPluginEntry:\t" + pluginEntry.getVersionedIdentifier());
          }
        }
      }
    }
    catch (Exception ex)
    {
      ex.printStackTrace();
    }
  }
}