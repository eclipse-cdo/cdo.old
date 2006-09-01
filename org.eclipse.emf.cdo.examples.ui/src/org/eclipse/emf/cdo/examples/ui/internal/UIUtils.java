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


import org.eclipse.emf.cdo.client.ResourceInfo;
import org.eclipse.emf.cdo.client.ResourceManager;
import org.eclipse.emf.cdo.examples.ui.internal.editors.CDOEditor;
import org.eclipse.emf.cdo.examples.ui.internal.editors.CDOEditorInput;
import org.eclipse.emf.cdo.examples.ui.internal.wizards.CDONewWizard;
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
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.PropertySheetPage;


public class UIUtils
{
  public static void openCDONewWizard(ResourceManager resourceManager, boolean commit)
  {
    CDONewWizard wizard = new CDONewWizard(resourceManager, commit);
    wizard.init(PlatformUI.getWorkbench(), null);
    wizard.setNeedsProgressMonitor(true);

    WizardDialog dialog = new WizardDialog(new Shell(), wizard);
    dialog.create();
    dialog.open();
  }

  public static void openCDONewWizard()
  {
    openCDONewWizard(null, true);
  }

  public static IEditorPart openCDOEditor(ResourceInfo resourceInfo)
  {
    IWorkbench workbench = PlatformUI.getWorkbench();
    IWorkbenchWindow activeWorkbenchWindow = workbench.getActiveWorkbenchWindow();
    IWorkbenchPage activePage = activeWorkbenchWindow.getActivePage();

    try
    {
      return activePage.openEditor(new CDOEditorInput(resourceInfo), CDOEditor.EDITOR_ID);
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
            ExampleUIActivator.INSTANCE.getImage(key));
  }

  public static Image getImage(String key)
  {
    return ExtendedImageRegistry.getInstance().getImage(ExampleUIActivator.INSTANCE.getImage(key));
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

  public static void refreshPropertySheetPage(final IPropertySheetPage propertySheetPage)
  {
    if (propertySheetPage instanceof PropertySheetPage)
    {
      final PropertySheetPage page = (PropertySheetPage)propertySheetPage;
      Display display = page.getControl().getDisplay();
      display.asyncExec(new Runnable()
      {
        public void run()
        {
          if (page != null && !page.getControl().isDisposed())
          {
            try
            {
              page.refresh();
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
}
