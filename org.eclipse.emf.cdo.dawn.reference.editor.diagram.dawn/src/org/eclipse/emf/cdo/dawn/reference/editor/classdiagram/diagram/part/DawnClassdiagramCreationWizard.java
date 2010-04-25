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

/*******************************************************************************
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
import org.eclipse.emf.cdo.dawn.runtime.preferences.PreferenceConstants;
import org.eclipse.emf.cdo.dawn.ui.wizards.DawnCreateNewDiagramResourceWizardPage;
import org.eclipse.emf.cdo.dawn.ui.wizards.DawnCreateNewResourceWizardPage;
import org.eclipse.emf.cdo.dawn.util.connection.CDOConnectionUtil;
import org.eclipse.emf.cdo.session.CDOSession;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.WorkspaceModifyOperation;

/**
 * @author Martin Fluegge
 */
public class DawnClassdiagramCreationWizard extends ClassdiagramCreationWizard implements INewWizard
{
  private CDOView view;

  private DawnCreateNewDiagramResourceWizardPage dawnDiagramModelFilePage;

  private DawnCreateNewResourceWizardPage dawnDomainModelFilePage;

  public DawnClassdiagramCreationWizard()
  {
    super();
    // CDOConnectionUtil.instance.init("repo1", "tcp", "localhost");
    CDOConnectionUtil.instance.init(PreferenceConstants.getRepositoryName(), PreferenceConstants.getProtocol(),
        PreferenceConstants.getServerName());
    CDOSession session = CDOConnectionUtil.instance.openSession();
    view = CDOConnectionUtil.instance.openView(session);
  }

  public boolean performFinish()
  {
    ClassdiagramDiagramEditorPlugin.getInstance().logInfo("Notational Model: " + dawnDiagramModelFilePage.getURI().lastSegment());
    ClassdiagramDiagramEditorPlugin.getInstance().logInfo("Notational Model URI: " + dawnDiagramModelFilePage.getURI());
    ClassdiagramDiagramEditorPlugin.getInstance().logInfo("Domain Model: " + dawnDomainModelFilePage.getURI().lastSegment());
    ClassdiagramDiagramEditorPlugin.getInstance().logInfo("Domain Model URI: " + dawnDomainModelFilePage.getURI());
    IRunnableWithProgress op = new WorkspaceModifyOperation(null)
    {
      protected void execute(IProgressMonitor monitor) throws CoreException, InterruptedException
      {
        URI diagramResourceURI = dawnDiagramModelFilePage.getURI();
        URI domainModelResourceURI = dawnDomainModelFilePage.getURI();

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

  @Override
  public void addPages()
  {
    dawnDiagramModelFilePage = new DawnCreateNewDiagramResourceWizardPage("classdiagram_diagram", false, view);
    dawnDiagramModelFilePage.setTitle(Messages.ClassdiagramCreationWizard_DiagramModelFilePageTitle);
    dawnDiagramModelFilePage.setDescription(Messages.ClassdiagramCreationWizard_DiagramModelFilePageDescription);
    dawnDiagramModelFilePage.setCreateAutomaticResourceName(true);
    addPage(dawnDiagramModelFilePage);

    dawnDomainModelFilePage = new DawnCreateNewResourceWizardPage("", true, view)
    {
      public void setVisible(boolean visible)
      {
        if (visible)
        {
          URI uri = dawnDiagramModelFilePage.getURI();
          String fileName = uri.lastSegment();
          fileName = fileName.substring(0, fileName.length() - ".classdiagram_diagram".length()); //$NON-NLS-1$
          fileName += ".classdiagram";
          dawnDomainModelFilePage.setResourceNamePrefix(fileName);
          dawnDomainModelFilePage.setResourcePath(dawnDiagramModelFilePage.getResourcePath());
        }
        super.setVisible(visible);
      }
    };
    dawnDomainModelFilePage.setTitle(Messages.ClassdiagramCreationWizard_DomainModelFilePageTitle);
    dawnDomainModelFilePage.setDescription(Messages.ClassdiagramCreationWizard_DomainModelFilePageDescription);

    // allows to connect to an existing resource
    dawnDomainModelFilePage.setResourceValidationType(DawnCreateNewResourceWizardPage.VALIDATION_WARN);
    addPage(dawnDomainModelFilePage);
  }

  @Override
  public void dispose()
  {
    view.close();
  }
}
