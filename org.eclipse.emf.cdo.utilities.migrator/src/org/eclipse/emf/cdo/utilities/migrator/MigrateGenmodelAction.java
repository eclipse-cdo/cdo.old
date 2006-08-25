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


import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IActionDelegate;

import java.util.Collections;


public class MigrateGenmodelAction extends AbstractResourceAction
{
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

      Resource usedResource = loadResource(resourceSet, "org.eclipse.emf.cdo.client/model/client.genmodel");
      GenModel usedModel = (GenModel) usedResource.getContents().get(0);
      GenPackage usedPackage = (GenPackage) usedModel.getGenPackages().get(0);

      Resource resource = loadResource(resourceSet, getCurrentFile().getFullPath().toString());
      GenModel genModel = (GenModel) resource.getContents().get(0);

      genModel.getUsedGenPackages().add(usedPackage);
      genModel.setDynamicTemplates(true);
      genModel.setTemplateDirectory("platform:resource/org.eclipse.emf.cdo.client/templates");

      resource.save(Collections.EMPTY_MAP);
      MessageDialog.openInformation(new Shell(), "Migrator Plug-in", "Genmodel file migrated.");
    }
    catch (Throwable t)
    {
      MessageDialog.openError(new Shell(), "Migrator Plug-in", "Error: " + t.getMessage());
    }
  }
}
