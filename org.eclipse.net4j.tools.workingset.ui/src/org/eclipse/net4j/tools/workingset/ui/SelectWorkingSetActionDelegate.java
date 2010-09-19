package org.eclipse.net4j.tools.workingset.ui;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IViewActionDelegate;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkingSetManager;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.IWorkingSetSelectionDialog;

public class SelectWorkingSetActionDelegate implements IViewActionDelegate
{
  private IViewPart view;

  public void init(IViewPart view)
  {
    this.view = view;
  }

  public void selectionChanged(IAction action, ISelection selection)
  {
  }

  public void run(IAction action)
  {
    IWorkingSetManager manager = PlatformUI.getWorkbench().getWorkingSetManager();
    IWorkingSetSelectionDialog dialog = manager.createWorkingSetSelectionDialog(view.getSite().getShell(), false);
    dialog.open();
  }
}
