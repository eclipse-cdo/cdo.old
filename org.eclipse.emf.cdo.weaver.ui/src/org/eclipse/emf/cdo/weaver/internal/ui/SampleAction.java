package org.eclipse.emf.cdo.weaver.internal.ui;

import org.eclipse.emf.cdo.weaver.ICDOWeaver;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;

public class SampleAction implements IWorkbenchWindowActionDelegate
{
  public SampleAction()
  {
  }

  public void run(IAction action)
  {
    ICDOWeaver.INSTANCE.test();
  }

  public void selectionChanged(IAction action, ISelection selection)
  {
  }

  public void dispose()
  {
  }

  public void init(IWorkbenchWindow window)
  {
  }
}