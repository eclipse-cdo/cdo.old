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
import org.eclipse.emf.cdo.client.ClassInfo;
import org.eclipse.emf.cdo.client.ResourceManager;
import org.eclipse.emf.cdo.client.impl.ResourceInfoImpl;
import org.eclipse.emf.cdo.core.CDOProtocol;
import org.eclipse.emf.cdo.examples.client.internal.ExampleClientPlugin;
import org.eclipse.emf.cdo.examples.ui.UIUtils;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;

import java.lang.reflect.InvocationTargetException;


public class CDONewWizard extends Wizard implements INewWizard
{
  public static final String WIZARD_ID = "org.eclipse.emf.cdo.examples.ui.CDONewWizard";

  public static final String TITLE = "New CDO Resource";

  private CDONewWizardPage page;

  private ResourceManager resourceManager;

  private boolean commit;

  public CDONewWizard()
  {
    this(null, true);
  }

  public CDONewWizard(ResourceManager resourceManager, boolean commit)
  {
    if (resourceManager == null && !commit)
    {
      throw new IllegalArgumentException("resourceManager == null && !commit");
    }

    setWindowTitle(TITLE);
    setNeedsProgressMonitor(true);
    this.resourceManager = resourceManager;
    this.commit = commit;
  }

  public void init(IWorkbench workbench, IStructuredSelection selection)
  {
  }

  public void addPages()
  {
    page = new CDONewWizardPage();
    addPage(page);
  }

  public boolean performFinish()
  {
    final String resourcePath = page.getResourcePath();
    final ClassInfo rootElement = page.getRootElement();

    IRunnableWithProgress op = new IRunnableWithProgress()
    {
      public void run(IProgressMonitor monitor) throws InvocationTargetException
      {
        try
        {
          doFinish(resourcePath, rootElement, monitor);
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

    if (this.resourceManager == null)
    {
      UIUtils.openCDOEditor(new ResourceInfoImpl(resourcePath, 0, false));
    }

    return true;
  }

  private void doFinish(String resourcePath, ClassInfo rootElement, IProgressMonitor monitor)
          throws Exception
  {
    ResourceManager resourceManager = this.resourceManager == null ? ExampleClientPlugin
            .createResourceManager(new ResourceSetImpl()) : this.resourceManager;

    URI uri = URI.createURI(CDOProtocol.PROTOCOL_SCHEME + resourcePath);
    CDOResource resource = (CDOResource)resourceManager.createResource(uri);

    EClass eClass = rootElement.getEClass();
    EPackage ePackage = eClass.getEPackage();
    EFactory eFactory = ePackage.getEFactoryInstance();
    EObject eObject = eFactory.create(eClass);

    resource.getContents().add(eObject);
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
