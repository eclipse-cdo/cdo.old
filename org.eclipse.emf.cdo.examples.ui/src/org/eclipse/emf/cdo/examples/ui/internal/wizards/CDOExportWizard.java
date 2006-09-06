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


import org.eclipse.core.resources.IContainer;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.cdo.client.CDOResource;
import org.eclipse.emf.cdo.client.ResourceManager;
import org.eclipse.emf.cdo.core.CDOProtocol;
import org.eclipse.emf.cdo.examples.client.internal.ExampleClientPlugin;
import org.eclipse.emf.cdo.examples.ui.ResourceFactoryHelper;
import org.eclipse.emf.cdo.examples.ui.internal.ExampleUIActivator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IImportWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.dialogs.ContainerGenerator;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;


public class CDOExportWizard extends Wizard implements IImportWizard
{
  public static final String WIZARD_ID = "org.eclipse.emf.cdo.examples.ui.CDOExportWizard";

  public static final String TITLE = "Export CDO Resource";

  private CDOExportWizardPage page;

  private CDOResource resource;

  private IStructuredSelection selection;

  public CDOExportWizard(CDOResource resource)
  {
    this.resource = resource;
    setDialogSettings(getCDOExportWizardDialogSettings());
    setWindowTitle(TITLE);
    setNeedsProgressMonitor(true);
  }

  public CDOExportWizard()
  {
    this(null);
  }

  public void init(IWorkbench workbench, IStructuredSelection selection)
  {
    this.selection = selection;
  }

  public void addPages()
  {
    addPage(page = new CDOExportWizardPage(resource, selection));
  }

  public static IDialogSettings getCDOExportWizardDialogSettings()
  {
    IDialogSettings workbenchSettings = ExampleUIActivator.getPlugin().getDialogSettings();
    IDialogSettings section = workbenchSettings.getSection("CDOExportWizard");//$NON-NLS-1$
    if (section == null)
    {
      section = workbenchSettings.addNewSection("CDOExportWizard");//$NON-NLS-1$
    }

    return section;
  }

  public boolean performFinish()
  {
    final String sourcePath = page.getSourcePath();
    final String destinationURI = page.getDestinationURI();
    final String resourceFactoryExtension = page.getResourceFactoryExtension();

    IRunnableWithProgress op = new IRunnableWithProgress()
    {
      public void run(IProgressMonitor monitor) throws InvocationTargetException
      {
        try
        {
          doFinish(sourcePath, resourceFactoryExtension, destinationURI, monitor);
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
    return true;
  }

  private void doFinish(String sourcePath, String resourceFactoryExtension, String destinationURI,
          IProgressMonitor monitor) throws Exception
  {
    // Prepare source
    ResourceManager resourceManager;
    CDOResource source;

    if (resource == null)
    {
      resourceManager = ExampleClientPlugin.createResourceManager(new ResourceSetImpl());
      URI uri = URI.createURI(CDOProtocol.PROTOCOL_SCHEME + sourcePath);
      source = (CDOResource)resourceManager.getResource(uri, true);
    }
    else
    {
      resourceManager = resource.getResourceManager();
      source = resource;
    }

    // Prepare destination
    URI uri = URI.createURI(destinationURI);
    IPath path = new Path( uri.path()).removeLastSegments(1);
    ContainerGenerator gen = new ContainerGenerator(path);
    gen.generateContainer(monitor);
    
    ResourceSet resourceSet = new ResourceSetImpl();
    Map map = resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap();
    map.put("*", ResourceFactoryHelper.getResourceFactory(resourceFactoryExtension));
    Resource destination = resourceSet.createResource(uri);

    // Copy contents
    source.preLoad();
    Collection<EObject> contents = EcoreUtil.copyAll(source.getContents());
    for (EObject object : contents)
    {
      destination.getContents().add(object);
    }

    destination.save(Collections.EMPTY_MAP);

    if (resource == null)
    {
      resourceManager.stop();
    }
  }
}
