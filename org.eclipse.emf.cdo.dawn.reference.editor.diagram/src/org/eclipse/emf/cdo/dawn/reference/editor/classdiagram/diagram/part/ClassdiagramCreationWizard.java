/*******************************************************************************
 * Copyright (c) 2010 Martin Fluegge (Berlin, Germany).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Martin Fluegge - initial API and implementation
 ******************************************************************************/
package org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.part;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.WorkspaceModifyOperation;

import java.lang.reflect.InvocationTargetException;

/**
 * @generated
 */
public class ClassdiagramCreationWizard extends Wizard implements INewWizard
{

  /**
   * @generated
   */
  private IWorkbench workbench;

  /**
   * @generated
   */
  protected IStructuredSelection selection;

  /**
   * @generated
   */
  protected ClassdiagramCreationWizardPage diagramModelFilePage;

  /**
   * @generated
   */
  protected ClassdiagramCreationWizardPage domainModelFilePage;

  /**
   * @generated
   */
  protected Resource diagram;

  /**
   * @generated
   */
  private boolean openNewlyCreatedDiagramEditor = true;

  /**
   * @generated
   */
  public IWorkbench getWorkbench()
  {
    return workbench;
  }

  /**
   * @generated
   */
  public IStructuredSelection getSelection()
  {
    return selection;
  }

  /**
   * @generated
   */
  public final Resource getDiagram()
  {
    return diagram;
  }

  /**
   * @generated
   */
  public final boolean isOpenNewlyCreatedDiagramEditor()
  {
    return openNewlyCreatedDiagramEditor;
  }

  /**
   * @generated
   */
  public void setOpenNewlyCreatedDiagramEditor(boolean openNewlyCreatedDiagramEditor)
  {
    this.openNewlyCreatedDiagramEditor = openNewlyCreatedDiagramEditor;
  }

  /**
   * @generated
   */
  public void init(IWorkbench workbench, IStructuredSelection selection)
  {
    this.workbench = workbench;
    this.selection = selection;
    setWindowTitle(Messages.ClassdiagramCreationWizardTitle);
    setDefaultPageImageDescriptor(ClassdiagramDiagramEditorPlugin
        .getBundledImageDescriptor("icons/wizban/NewClassdiagramWizard.gif")); //$NON-NLS-1$
    setNeedsProgressMonitor(true);
  }

  /**
   * @generated
   */
  public void addPages()
  {
    diagramModelFilePage = new ClassdiagramCreationWizardPage(
        "DiagramModelFile", getSelection(), "classdiagram_diagram"); //$NON-NLS-1$ //$NON-NLS-2$
    diagramModelFilePage.setTitle(Messages.ClassdiagramCreationWizard_DiagramModelFilePageTitle);
    diagramModelFilePage.setDescription(Messages.ClassdiagramCreationWizard_DiagramModelFilePageDescription);
    addPage(diagramModelFilePage);

    domainModelFilePage = new ClassdiagramCreationWizardPage("DomainModelFile", getSelection(), "classdiagram") { //$NON-NLS-1$ //$NON-NLS-2$

      public void setVisible(boolean visible)
      {
        if (visible)
        {
          String fileName = diagramModelFilePage.getFileName();
          fileName = fileName.substring(0, fileName.length() - ".classdiagram_diagram".length()); //$NON-NLS-1$
          setFileName(ClassdiagramDiagramEditorUtil.getUniqueFileName(getContainerFullPath(), fileName, "classdiagram")); //$NON-NLS-1$
        }
        super.setVisible(visible);
      }
    };
    domainModelFilePage.setTitle(Messages.ClassdiagramCreationWizard_DomainModelFilePageTitle);
    domainModelFilePage.setDescription(Messages.ClassdiagramCreationWizard_DomainModelFilePageDescription);
    addPage(domainModelFilePage);
  }

  /**
   * @generated
   */
  public boolean performFinish()
  {
    IRunnableWithProgress op = new WorkspaceModifyOperation(null)
    {

      protected void execute(IProgressMonitor monitor) throws CoreException, InterruptedException
      {
        diagram = ClassdiagramDiagramEditorUtil.createDiagram(diagramModelFilePage.getURI(), domainModelFilePage
            .getURI(), monitor);
        if (isOpenNewlyCreatedDiagramEditor() && diagram != null)
        {
          try
          {
            ClassdiagramDiagramEditorUtil.openDiagram(diagram);
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
}
