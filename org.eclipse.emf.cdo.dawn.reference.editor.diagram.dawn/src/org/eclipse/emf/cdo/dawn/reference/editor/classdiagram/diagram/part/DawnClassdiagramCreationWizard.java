package org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.part;

/*******************************************************************************
 * Copyright (c) 2009 Martin Flügge (Berlin, Germany).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Martin Flügge - initial API and implementation
 ******************************************************************************/

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.cdo.dawn.logging.logger.LOG;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.WorkspaceModifyOperation;

/**
 * @generated
 */
// TODO generation
public class DawnClassdiagramCreationWizard extends ClassdiagramCreationWizard implements INewWizard
{
  public boolean performFinish()
  {
    IRunnableWithProgress op = new WorkspaceModifyOperation(null)
    {

      protected void execute(IProgressMonitor monitor) throws CoreException, InterruptedException
      {
        URI diagramResourceURI = URI.createURI("dawn://repo1/" + diagramModelFilePage.getURI().lastSegment());
        URI domainModelResourceURI = URI.createURI("cdo://" + domainModelFilePage.getURI().lastSegment());

        LOG.info("Notational Resource URI : " + diagramResourceURI);
        LOG.info("Semantic Resource URI: " + domainModelResourceURI);

        // TODO read the URIs from the pages and create the specific file
        diagram = DawnClassdiagramDiagramEditorUtil.createDiagram(diagramResourceURI, domainModelResourceURI, monitor);

        if (isOpenNewlyCreatedDiagramEditor() && diagram != null)
        {
          try
          {
            DawnClassdiagramDiagramEditorUtil.openDiagram(diagram);
          }
          catch (PartInitException e)
          {
            ErrorDialog.openError(getContainer().getShell(), Messages.ClassdiagramCreationWizardOpenEditorError, null,
                e.getStatus());
          }
        }
      }
    };
    try
    {
      getContainer().run(false, true, op);
    }
    catch (InterruptedException e)
    {
      return false;
    }
    catch (InvocationTargetException e)
    {
      if (e.getTargetException() instanceof CoreException)
      {
        ErrorDialog.openError(getContainer().getShell(), Messages.ClassdiagramCreationWizardCreationError, null,
            ((CoreException)e.getTargetException()).getStatus());
      }
      else
      {
        ClassdiagramDiagramEditorPlugin.getInstance().logError("Error creating diagram", e.getTargetException()); //$NON-NLS-1$
      }
      return false;
    }
    return diagram != null;
  }

  // public boolean performFinish()
  // {
  // IRunnableWithProgress op = new WorkspaceModifyOperation(null)
  // {
  //
  // protected void execute(IProgressMonitor monitor) throws CoreException, InterruptedException
  // {
  //
  // // URI cdoURI = URI.createURI("cdo://repo1/" +diagramModelFilePage.getURI().lastSegment());
  // URI cdoURI = URI.createURI("dawn://repo1/" + diagramModelFilePage.getURI().lastSegment());
  // System.out.println("CONNECTING to: " + cdoURI);
  //
  // diagram = DawnClassdiagramDiagramEditorUtil.createDiagram(cdoURI, monitor);
  // // diagram = DawnClassdiagramDiagramEditorUtil.createDiagram(diagramModelFilePage.getURI(), monitor);
  //
  // if (isOpenNewlyCreatedDiagramEditor() && diagram != null)
  // {
  // try
  // {
  // DawnClassdiagramDiagramEditorUtil.openDiagram(diagram);
  // }
  // catch (PartInitException e)
  // {
  // ErrorDialog.openError(getContainer().getShell(), Messages.ClassdiagramCreationWizardOpenEditorError, null,
  // e.getStatus());
  // }
  // }
  // }
  // };
  // try
  // {
  // getContainer().run(false, true, op);
  // }
  // catch (InterruptedException e)
  // {
  // return false;
  // }
  // catch (InvocationTargetException e)
  // {
  // if (e.getTargetException() instanceof CoreException)
  // {
  // ErrorDialog.openError(getContainer().getShell(), Messages.ClassdiagramCreationWizardCreationError, null,
  // ((CoreException)e.getTargetException()).getStatus());
  // }
  // else
  // {
  //        ClassdiagramDiagramEditorPlugin.getInstance().logError("Error creating diagram", e.getTargetException()); //$NON-NLS-1$
  // }
  // return false;
  // }
  // return diagram != null;
  // }
}
