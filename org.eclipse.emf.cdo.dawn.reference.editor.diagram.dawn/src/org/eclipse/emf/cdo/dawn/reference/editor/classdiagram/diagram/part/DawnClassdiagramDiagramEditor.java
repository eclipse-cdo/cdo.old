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

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.ClassDiagram;
import org.eclipse.emf.cdo.dawn.runtime.diagram.part.IDawnDiagramEditor;
import org.eclipse.emf.cdo.dawn.runtime.notifications.DawnNotificationUtil;
import org.eclipse.emf.cdo.dawn.runtime.synchronize.DawnChangeHelper;
import org.eclipse.emf.cdo.dawn.runtime.synchronize.DawnConflictHelper;
import org.eclipse.emf.cdo.dawn.ui.DawnEditorInput;
import org.eclipse.emf.cdo.dawn.util.DawnDiagramUpdater;
import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.eclipse.emf.cdo.ui.CDOEditorInput;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.gef.EditPart;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.net4j.util.transaction.TransactionException;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IFileEditorInput;

/**
 * @author Martin Fluegge
 */
public class DawnClassdiagramDiagramEditor extends ClassdiagramDiagramEditor implements IDawnDiagramEditor
{
  ClassDiagram classDiagram;

  private CDOTransaction transaction;

  public static String ID = "org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.part.DawnClassdiagramDiagramEditor";

  public DawnClassdiagramDiagramEditor()
  {
    super();
    ClassdiagramDiagramEditorPlugin.getInstance().logInfo("CDO Editor ist starting");
    setDocumentProvider(new DawnClassdiagramDocumentProvider());
  }

  public void setInput(IEditorInput input)
  {
    ClassdiagramDiagramEditorPlugin.getInstance().logInfo("Setting input for DawnClassdiagramDiagramEditor (" + input + ")");

    try
    {
      doSetInput(input, true);
    }
    catch (CoreException x)
    {
      x.printStackTrace(System.err);
      String title = x.getMessage();
      String msg = x.getMessage();
      Shell shell = getSite().getShell();
      ErrorDialog.openError(shell, title, msg, x.getStatus());
    }
    transaction = (CDOTransaction)((DawnEditorInput)input).getView();

    DawnNotificationUtil.registerResourceListeners(getEditingDomain().getResourceSet(), this);
    DawnNotificationUtil.registerTransactionListeners(transaction, this);
    DawnNotificationUtil.setChangeSubscriptionPolicy(transaction);
  }

  @Override
  protected void initializeGraphicalViewer()
  {
    super.initializeGraphicalViewer();
  }

  @Override
  public void doSave(IProgressMonitor monitor)
  {
    Resource res = getEditingDomain().getResourceSet().getResources().get(0);

    try
    {
      updateState(getEditorInput());
      validateState(getEditorInput());
      performSave(false, monitor);
    }
    catch (TransactionException e)
    {
      if (e.getMessage().contains("conflict"))
      {
        MessageDialog.openError(Display.getDefault().getActiveShell(), "conflict",
            "Your Resource is in conflict and cannot be committed");
      }
      else
      {
        throw e;
      }
    }
  }

  @Override
  public boolean isDirty()
  {
    return super.isDirty() | transaction.isDirty();
  }

  @Override
  public String getContributorID()
  {
    return null;
  }

  @Override
  public boolean isCDOEditor()
  {
    return true;
  }

  @Override
  public void setOwnPaletteVisible(boolean visible)
  {
  }

  @Override
  public void showServerOnlineMode(boolean online)
  {
  }

//  @Override
//  public void rollback()
//  {
//    
//    DawnConflictHelper.rollback(transaction, this);
//    
//  }

  /**
   * Have to override this method to change the the DocuemtnProvider behavior.
   */
  protected void setDocumentProvider(IEditorInput input)
  {
    if (input instanceof IFileEditorInput || input instanceof URIEditorInput || input instanceof CDOEditorInput)
    {
      setDocumentProvider(getDocumentProvider());
    }
    else
    {
      super.setDocumentProvider(input);
    }
  }

  @Override
  public void dispose()
  {
    try
    {
      super.dispose();
    }
    finally
    {
      if (transaction != null && !transaction.isClosed())
      {
        transaction.close();
      }
    }
  }

  @Override
  public CDOView getView()
  {
    // TODO Auto-generated method stub
    return transaction;
  }
}
