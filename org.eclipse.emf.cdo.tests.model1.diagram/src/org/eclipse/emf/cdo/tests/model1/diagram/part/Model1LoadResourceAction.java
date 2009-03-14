/*
 * Copyright (c) 2008 Open Canarias S.L. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *    Victor Roldan Betancort - GMF models creation and initial generation
 *    Eike Stepper - maintenance
 */
package org.eclipse.emf.cdo.tests.model1.diagram.part;

import org.eclipse.emf.cdo.tests.model1.diagram.edit.parts.CompanyEditPart;

import org.eclipse.emf.edit.ui.action.LoadResourceAction;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

/**
 * @generated
 */
public class Model1LoadResourceAction implements IObjectActionDelegate
{

  /**
   * @generated
   */
  private CompanyEditPart mySelectedElement;

  /**
   * @generated
   */
  private Shell myShell;

  /**
   * @generated
   */
  public void setActivePart(IAction action, IWorkbenchPart targetPart)
  {
    myShell = targetPart.getSite().getShell();
  }

  /**
   * @generated
   */
  public void run(IAction action)
  {
    LoadResourceAction.LoadResourceDialog loadResourceDialog = new LoadResourceAction.LoadResourceDialog(myShell,
        mySelectedElement.getEditingDomain());
    loadResourceDialog.open();
  }

  /**
   * @generated
   */
  public void selectionChanged(IAction action, ISelection selection)
  {
    mySelectedElement = null;
    if (selection instanceof IStructuredSelection)
    {
      IStructuredSelection structuredSelection = (IStructuredSelection)selection;
      if (structuredSelection.size() == 1 && structuredSelection.getFirstElement() instanceof CompanyEditPart)
      {
        mySelectedElement = (CompanyEditPart)structuredSelection.getFirstElement();
      }
    }
    action.setEnabled(isEnabled());
  }

  /**
   * @generated
   */
  private boolean isEnabled()
  {
    return mySelectedElement != null;
  }

}
