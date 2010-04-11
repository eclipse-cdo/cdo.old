package org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.part;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.cdo.dawn.logging.logger.LOG;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.ClassDiagram;
import org.eclipse.emf.cdo.dawn.runtime.diagram.part.DawnDiagramEditorInterface;
import org.eclipse.emf.cdo.dawn.runtime.synchronize.DawnChangeHelper;
import org.eclipse.emf.cdo.dawn.runtime.views.listeners.DawnNotificationUtil;
import org.eclipse.emf.cdo.dawn.ui.DawnEditorInput;
import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.eclipse.emf.cdo.ui.CDOEditorInput;
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

public class DawnClassdiagramDiagramEditor extends ClassdiagramDiagramEditor implements DawnDiagramEditorInterface
{
  ClassDiagram classDiagram;

  private CDOTransaction transaction;

  public static String ID = "org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.part.DawnClassdiagramDiagramEditor";

  public DawnClassdiagramDiagramEditor()
  {
    super();
    LOG.info("CDO Editor ist starting");
    setDocumentProvider(new DawnClassdiagramDocumentProvider());
  }

  public void setInput(IEditorInput input)
  {
    LOG.info("Setting input for DawnClassdiagramDiagramEditor (" + input + ")");

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

    DawnNotificationUtil.removeTransactionChangeRecorder(getDiagram());
    DawnNotificationUtil.removeTransactionChangeRecorder(getDiagram().getElement());
    DawnNotificationUtil.removeTransactionChangeRecorder(getDiagram().eResource());
    DawnNotificationUtil.removeTransactionChangeRecorder(getDiagram().getElement().eResource());
    // DawnNotificationUtil.registerModelListeners(getDiagram(), this);
    DawnNotificationUtil.registerResourceListeners(getEditingDomain().getResourceSet(), this);
    DawnNotificationUtil.registerTransactionListeners(transaction, this);
  }

  @Override
  public void doSave(IProgressMonitor monitor)
  {

    Resource res = getEditingDomain().getResourceSet().getResources().get(0);
    // ResourceHelper.printResourceSysout(res);

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

  //

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

  @Override
  public void rollback()
  {
    transaction.rollback();

    this.getEditingDomain().getCommandStack().execute(new RecordingCommand(this.getEditingDomain())
    {
      public void doExecute()
      {
        for (Object obj : getDiagramEditPart().getChildren())
        {
          DawnChangeHelper.removeMark((EditPart)obj);

        }
        refresh(getDiagramEditPart());
      }
    });

  }

  private void refresh(EditPart e)
  {
    for (Object obj : e.getChildren())
    {
      refresh((EditPart)obj);
    }
    e.refresh();
  }

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

  // public class DawnElementChangeListener extends org.eclipse.emf.ecore.util.EContentAdapter
  // {
  //
  // private final DiagramDocumentEditor editor;
  //
  // public DawnElementChangeListener(DiagramDocumentEditor editor)
  // {
  // this.editor = editor;
  //
  // }
  //
  // @Override
  // public void notifyChanged(Notification notification)
  // {
  // DawnDiagramUpdater.refreshEditPart(editor.getDiagramEditPart());
  // ((DawnClassdiagramDocumentProvider)editor.getDocumentProvider()).changed(getEditorInput());
  // System.out.println("Change on element XXX");
  // super.notifyChanged(notification);
  // }
  // }

}
