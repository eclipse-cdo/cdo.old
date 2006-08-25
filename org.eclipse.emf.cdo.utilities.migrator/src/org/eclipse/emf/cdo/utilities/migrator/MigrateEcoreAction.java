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
package org.eclipse.emf.cdo.utilities.migrator;


import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IActionDelegate;

import java.util.Collections;
import java.util.Iterator;


public class MigrateEcoreAction extends AbstractResourceAction
{
  private EClass cdoPersistent;

  /**
   * @see IActionDelegate#run(IAction)
   */
  public void run(IAction action)
  {
    try
    {
      if (getCurrentFile() == null)
      {
        MessageDialog.openError(new Shell(), "Migrator Plug-in", "No file selected.");
        return;
      }

      ResourceSet resourceSet = new ResourceSetImpl();
      Resource cdoResource = loadResource(resourceSet, "org.eclipse.emf.cdo.client/model/client.ecore");
      EPackage cdoPackage = (EPackage) cdoResource.getContents().get(0);
      cdoPersistent = (EClass) cdoPackage.getEClassifier("CDOPersistent");

      Resource resource = loadResource(resourceSet, getCurrentFile().getFullPath().toString());
      handlePackage((EPackage) resource.getContents().get(0));

      resource.save(Collections.EMPTY_MAP);
      MessageDialog.openInformation(new Shell(), "Migrator Plug-in", "Ecore file migrated.");
    }
    catch (Throwable t)
    {
      MessageDialog.openError(new Shell(), "Migrator Plug-in", "Error: " + t.getMessage());
    }
  }

  /**
   * @param ePackage
   */
  private void handlePackage(EPackage ePackage)
  {
    EList classifiers = ePackage.getEClassifiers();
    for (Iterator it = classifiers.iterator(); it.hasNext();)
    {
      EClassifier classifier = (EClassifier) it.next();
      if (classifier instanceof EClass)
      {
        handleClass((EClass) classifier);
      }
    }

    EList subpackages = ePackage.getESubpackages();
    for (Iterator it = subpackages.iterator(); it.hasNext();)
    {
      EPackage subpackage = (EPackage) it.next();
      handlePackage(subpackage);
    }
  }

  /**
   * @param eClass
   */
  private void handleClass(EClass eClass)
  {
    boolean foundAClass = false;

    EList superTypes = eClass.getESuperTypes();
    for (Iterator it = superTypes.iterator(); it.hasNext();)
    {
      EClass superType = (EClass) it.next();
      if (!superType.isInterface())
      {
        if (superType.getClassifierID() == EcorePackage.EOBJECT)
        {
          it.remove();
        }
        else
        {
          foundAClass = true;
        }
      }
    }

    if (!foundAClass)
    {
      superTypes.add(0, cdoPersistent);
    }
  }
}
