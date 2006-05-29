/***************************************************************************
 * Copyright (c) 2004, 2005, 2006 Eike Stepper, Fuggerstr. 39, 10777 Berlin, Germany.
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
import org.eclipse.emf.cdo.examples.client.internal.ExampleClientPlugin;
import org.eclipse.emf.cdo.examples.ui.internal.UIUtils;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
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

  private CDONewWizardPage page;

  public CDONewWizard()
  {
    setWindowTitle("New CDO Resource");
    setNeedsProgressMonitor(true);
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

    UIUtils.openCDOEditor(new ResourceInfoImpl(resourcePath, 0, false));
    return true;
  }

  private void doFinish(String resourcePath, ClassInfo rootElement, IProgressMonitor monitor)
          throws Exception
  {
    ResourceSet resourceSet = new ResourceSetImpl();
    ResourceManager resourceManager = ExampleClientPlugin.createResourceManager(resourceSet);

    URI uri = URI.createURI("cdo://" + resourcePath);
    CDOResource resource = (CDOResource)resourceSet.createResource(uri);

    EClass eClass = rootElement.getEClass();
    EPackage ePackage = eClass.getEPackage();
    EFactory eFactory = ePackage.getEFactoryInstance();
    EObject eObject = eFactory.create(eClass);

    resource.getContents().add(eObject);
    resourceManager.commit();
    resourceManager.stop();
  }
}
