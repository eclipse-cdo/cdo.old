/*******************************************************************************
 * Copyright (c) 2004 - 2010 Eike Stepper (Berlin, Germany).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Martin Fluegge - initial API and implementation
 ******************************************************************************/
package org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.part;

import org.eclipse.emf.cdo.dawn.diagram.part.IDawnDiagramEditor;
import org.eclipse.emf.cdo.dawn.notifications.DawnNotificationUtil;
import org.eclipse.emf.cdo.dawn.ui.DawnEditorInput;
import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.eclipse.emf.cdo.ui.CDOEditorInput;
import org.eclipse.emf.cdo.view.CDOView;

import org.eclipse.net4j.util.transaction.TransactionException;

import org.eclipse.emf.common.ui.URIEditorInput;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.AbstractDocumentProvider;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IFileEditorInput;

/**
 * @author Martin Fluegge
 */
public class DawnClassdiagramDiagramEditor extends ClassdiagramDiagramEditor implements IDawnDiagramEditor
{

  private CDOTransaction transaction;

  private boolean dirty;

  public static String ID = "org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.part.DawnClassdiagramDiagramEditor";

  public DawnClassdiagramDiagramEditor()
  {
    super();
    ClassdiagramDiagramEditorPlugin.getInstance().logInfo("CDO Editor ist starting");
    setDocumentProvider(new DawnClassdiagramDocumentProvider());
  }

  @Override
  public void setInput(IEditorInput input)
  {
    ClassdiagramDiagramEditorPlugin.getInstance().logInfo(
        "Setting input for DawnClassdiagramDiagramEditor (" + input + ")");

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
    try
    {
      dirty = false;
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
    // return super.isDirty() | transaction.isDirty();
    // return transaction.isDirty();
    // return super.isDirty() ;
    return dirty;
  }

  public String getContributorID()
  {
    return null;
  }

  /**
   * Have to override this method to change the the DocuemtnProvider behavior.
   */
  @Override
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

  public CDOView getView()
  {
    // TODO Auto-generated method stub
    return transaction;
  }

  public void setDirty()
  {
    dirty = true;
    ((AbstractDocumentProvider)getDocumentProvider()).changed(getEditorInput());
  }
}
