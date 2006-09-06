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
package org.eclipse.emf.cdo.utilities.migrator.internal.actions;


import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.cdo.utilities.migrator.MigratorUtil;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;

import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;


public abstract class AbstractFileAction implements IObjectActionDelegate
{
  private static final String TITLE = "CDO Migrator Utility";

  private IWorkbenchPart targetPart;

  private IFile currentFile;

  public IFile getCurrentFile()
  {
    return currentFile;
  }

  public IWorkbenchPart getTargetPart()
  {
    return targetPart;
  }

  public void setActivePart(IAction action, IWorkbenchPart targetPart)
  {
    this.targetPart = targetPart;
  }

  public void selectionChanged(IAction action, ISelection selection)
  {
    if (selection instanceof IStructuredSelection)
    {
      IStructuredSelection structure = (IStructuredSelection)selection;
      for (Iterator it = structure.iterator(); it.hasNext();)
      {
        Object item = it.next();
        if (item instanceof IFile)
        {
          currentFile = (IFile)item;
          break;
        }
      }
    }
  }

  public void run(IAction action)
  {
    if (currentFile == null)
    {
      showError("No file selected.");
      return;
    }

    final String[] msg = {null};
    if (ensureClientProject())
    {
      IRunnableWithProgress op = new IRunnableWithProgress()
      {
        public void run(IProgressMonitor monitor) throws InvocationTargetException
        {
          try
          {
            msg[0] = doRun(currentFile, monitor);
          }

          catch (Exception ex)
          {
            throw new InvocationTargetException(ex);
          }
        }
      };

      try
      {
        PlatformUI.getWorkbench().getProgressService().run(false, false, op);
        if (msg[0] != null)
        {
          showMessage(msg[0]);
        }
      }
      catch (InterruptedException ex)
      {
      }
      catch (InvocationTargetException ex)
      {
        ex.printStackTrace();
        Throwable realException = ex.getTargetException();
        showError(realException.getLocalizedMessage());
      }
    }
  }

  protected abstract String doRun(IFile file, IProgressMonitor monitor) throws Exception;

  private boolean ensureClientProject()
  {
    IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
    IProject project = root.getProject(MigratorUtil.CLIENT_PLUGIN_ID);
    if (project == null || !project.exists())
    {
      if (!MessageDialog
              .openConfirm(new Shell(), TITLE,
                      "The CDO Client project does not exist in the workspace. Shall it be imported as source plugin?"))
      {
        return false;
      }

      try
      {
        if (!MigratorUtil.importClientPlugin())
        {
          return false;
        }
      }
      catch (InterruptedException ex)
      {
        return false;
      }
      catch (Throwable t)
      {
        t.printStackTrace();
        showError("An error occured while importing the CDO Client plugin.");
        return false;
      }
    }

    if (!project.isOpen())
    {
      if (!MessageDialog
              .openConfirm(new Shell(), TITLE,
                      "The CDO Client project exists in the workspace but is not open. Shall it be opened?"))
      {
        return false;
      }

      try
      {
        project.open(new NullProgressMonitor());
      }
      catch (CoreException ex)
      {
        ex.printStackTrace();
        showError("An error occured while opening the CDO Client project.");
        return false;
      }
    }

    return true;
  }

  protected void showMessage(String msg)
  {
    MessageDialog.openInformation(new Shell(), TITLE, msg);
  }

  protected void showError(String msg)
  {
    MessageDialog.openError(new Shell(), TITLE, msg);
  }
}
