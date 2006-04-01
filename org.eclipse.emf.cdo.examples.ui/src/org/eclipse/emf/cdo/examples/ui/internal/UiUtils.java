package org.eclipse.emf.cdo.example.ui.internal;


import org.eclipse.emf.cdo.client.ResourceInfo;
import org.eclipse.emf.cdo.example.ui.internal.editors.CdoEditor;
import org.eclipse.emf.cdo.example.ui.internal.editors.CdoEditorInput;
import org.eclipse.emf.cdo.example.ui.internal.wizards.CdoNewWizard;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;


public class UiUtils
{
  public static void openCdoNewWizard()
  {
    CdoNewWizard wizard = new CdoNewWizard();
    wizard.init(PlatformUI.getWorkbench(), null);
    wizard.setNeedsProgressMonitor(true);

    WizardDialog dialog = new WizardDialog(new Shell(), wizard);
    dialog.create();
    dialog.open();
  }

  public static IEditorPart openCdoEditor(ResourceInfo resourceInfo)
  {
    IWorkbench workbench = PlatformUI.getWorkbench();
    IWorkbenchWindow activeWorkbenchWindow = workbench.getActiveWorkbenchWindow();
    IWorkbenchPage activePage = activeWorkbenchWindow.getActivePage();

    try
    {
      return activePage.openEditor(new CdoEditorInput(resourceInfo), CdoEditor.EDITOR_ID);
    }
    catch (PartInitException ex)
    {
      MessageDialog.openError(new Shell(), "CDO Explorer", "Can't open CDO Editor for "
              + resourceInfo);
      return null;
    }
  }

  public static ImageDescriptor getImageDescriptor(String key)
  {
    return ExtendedImageRegistry.getInstance().getImageDescriptor(
            CdoExampleUiActivator.INSTANCE.getImage(key));
  }

  public static Image getImage(String key)
  {
    return ExtendedImageRegistry.getInstance().getImage(
            CdoExampleUiActivator.INSTANCE.getImage(key));
  }

  public static void refreshViewer(final Viewer viewer)
  {
    Display display = viewer.getControl().getDisplay();
    display.asyncExec(new Runnable()
    {
      public void run()
      {
        if (viewer != null && !viewer.getControl().isDisposed())
        {
          try
          {
            viewer.refresh();
          }
          catch (Exception ex)
          {
            ex.printStackTrace();
          }
        }
      }
    });
  }
}
