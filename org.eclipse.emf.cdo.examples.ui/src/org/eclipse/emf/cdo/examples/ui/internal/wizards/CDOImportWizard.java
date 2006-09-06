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
package org.eclipse.emf.cdo.examples.ui.internal.wizards;


import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.cdo.client.CDOResource;
import org.eclipse.emf.cdo.client.ResourceManager;
import org.eclipse.emf.cdo.client.impl.ResourceInfoImpl;
import org.eclipse.emf.cdo.core.CDOProtocol;
import org.eclipse.emf.cdo.examples.client.internal.ExampleClientPlugin;
import org.eclipse.emf.cdo.examples.ui.ResourceFactoryHelper;
import org.eclipse.emf.cdo.examples.ui.UIUtils;
import org.eclipse.emf.cdo.examples.ui.internal.ExampleUIActivator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IImportWizard;
import org.eclipse.ui.IWorkbench;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;


public class CDOImportWizard extends Wizard implements IImportWizard
{
  public static final String WIZARD_ID = "org.eclipse.emf.cdo.examples.ui.CDOImportWizard";

  public static final String TITLE = "Import CDO Resource";

  private CDOImportWizardPage page;

  private ResourceManager resourceManager;

  private boolean commit;

  private IStructuredSelection selection;

  public CDOImportWizard(ResourceManager resourceManager, boolean commit)
  {
    if (resourceManager == null && !commit)
    {
      throw new IllegalArgumentException("resourceManager == null && !commit");
    }

    this.resourceManager = resourceManager;
    this.commit = commit;
    setDialogSettings(getCDOImportWizardDialogSettings());
    setWindowTitle(TITLE);
    setNeedsProgressMonitor(true);
  }

  public CDOImportWizard()
  {
    this(null, true);
  }

  public void init(IWorkbench workbench, IStructuredSelection selection)
  {
    this.selection = selection;
  }

  public void addPages()
  {
    addPage(page = new CDOImportWizardPage(selection));
  }

  public static IDialogSettings getCDOImportWizardDialogSettings()
  {
    IDialogSettings workbenchSettings = ExampleUIActivator.getPlugin().getDialogSettings();
    IDialogSettings section = workbenchSettings.getSection("CDOImportWizard");//$NON-NLS-1$
    if (section == null)
    {
      section = workbenchSettings.addNewSection("CDOImportWizard");//$NON-NLS-1$
    }

    return section;
  }

  public boolean performFinish()
  {
    final String sourceURI = page.getSourceURI();
    final String resourceFactoryExtension = page.getResourceFactoryExtension();
    final String destinationPath = page.getDestinationPath();

    IRunnableWithProgress op = new IRunnableWithProgress()
    {
      public void run(IProgressMonitor monitor) throws InvocationTargetException
      {
        try
        {
          doFinish(sourceURI, resourceFactoryExtension, destinationPath, monitor);
        }
        catch (Exception ex)
        {
          throw new InvocationTargetException(ex);
        }
      }
    };

    try
    {
      getContainer().run(true, false, op);
    }
    catch (InterruptedException e)
    {
      return false;
    }
    catch (InvocationTargetException e)
    {
      e.printStackTrace();
      Throwable realException = e.getTargetException();
      MessageDialog.openError(getShell(), "Error", realException.getMessage());
      return false;
    }

    page.saveValues();

    if (this.resourceManager == null)
    {
      UIUtils.openCDOEditor(new ResourceInfoImpl(destinationPath, 0, true));
    }

    return true;
  }

  private void doFinish(String sourceURI, String resourceFactoryExtension, String destinationPath,
          IProgressMonitor monitor) throws Exception
  {
    // Prepare source
    ResourceSet resourceSet = new ResourceSetImpl();
    Map map = resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap();
    map.put("*", ResourceFactoryHelper.getResourceFactory(resourceFactoryExtension));
    Resource source = resourceSet.getResource(URI.createURI(sourceURI), true);

    // Prepare destination
    ResourceManager resourceManager = this.resourceManager == null ? ExampleClientPlugin
            .createResourceManager(new ResourceSetImpl()) : this.resourceManager;
    URI uri = URI.createURI(CDOProtocol.PROTOCOL_SCHEME + destinationPath);
    CDOResource target = (CDOResource)resourceManager.createResource(uri);

    // Move contents
    EObject[] contents = (EObject[])source.getContents().toArray();
    for (EObject object : contents)
    {
      target.getContents().add(object);
    }

    if (commit)
    {
      resourceManager.commit();
    }

    if (this.resourceManager == null)
    {
      resourceManager.stop();
    }
  }
}
