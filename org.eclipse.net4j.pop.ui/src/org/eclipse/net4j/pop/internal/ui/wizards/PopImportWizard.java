/***************************************************************************
 * Copyright (c) 2004 - 2008 Eike Stepper, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 **************************************************************************/
package org.eclipse.net4j.pop.internal.ui.wizards;

import org.eclipse.jface.viewers.DecoratingLabelProvider;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.mylyn.internal.tasks.core.ITaskRepositoryFilter;
import org.eclipse.mylyn.internal.tasks.ui.views.TaskRepositoriesSorter;
import org.eclipse.mylyn.internal.tasks.ui.views.TaskRepositoryLabelProvider;
import org.eclipse.mylyn.internal.tasks.ui.wizards.MultiRepositoryAwareWizard;
import org.eclipse.mylyn.internal.tasks.ui.wizards.SelectRepositoryPage;
import org.eclipse.mylyn.tasks.core.TaskRepository;
import org.eclipse.mylyn.tasks.ui.TasksUi;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IImportWizard;
import org.eclipse.ui.PlatformUI;

/**
 * @author Eike Stepper
 */
public class PopImportWizard extends MultiRepositoryAwareWizard implements IImportWizard
{
  // private SelectRepositoryPage page;
  //
  // private ISelection selection;

  public PopImportWizard()
  {
    super(new SelectPopRepositoryPage(), "HURRA");
    setNeedsProgressMonitor(true);
  }

  // @Override
  // public void init(IWorkbench workbench, IStructuredSelection selection)
  // {
  // this.selection = selection;
  // }
  //
  // @Override
  // public void addPages()
  // {
  // page = new SelectRepositoryPage();
  // addPage(page);
  // }
  //
  // @Override
  // public boolean performFinish()
  // {
  // IRunnableWithProgress op = new IRunnableWithProgress()
  // {
  // public void run(IProgressMonitor monitor) throws InvocationTargetException
  // {
  // try
  // {
  // doFinish(monitor);
  // }
  // catch (CoreException e)
  // {
  // throw new InvocationTargetException(e);
  // }
  // finally
  // {
  // monitor.done();
  // }
  // }
  // };
  //
  // try
  // {
  // getContainer().run(true, false, op);
  // }
  // catch (InterruptedException e)
  // {
  // return false;
  // }
  // catch (InvocationTargetException e)
  // {
  // Throwable realException = e.getTargetException();
  // MessageDialog.openError(getShell(), "Error", realException.getMessage());
  // return false;
  // }
  // return true;
  // }
  //
  // private void doFinish(IProgressMonitor monitor) throws CoreException
  // {
  // monitor.beginTask("Creating ", 2);
  // monitor.worked(1);
  // monitor.worked(1);
  // }

  /**
   * @author Eike Stepper
   */
  private static final class SelectPopRepositoryPage extends SelectRepositoryPage
  {
    public SelectPopRepositoryPage()
    {
      super(ITaskRepositoryFilter.CAN_QUERY);
    }

    @Override
    protected IWizard createWizard(final TaskRepository taskRepository)
    {
      Wizard wizard = new Wizard()
      {
        @Override
        public boolean performFinish()
        {
          return false;
        }
      };

      wizard.addPage(new SelectPopPage(taskRepository));
      return wizard;
    }
  }

  /**
   * @author Eike Stepper
   */
  private static class SelectPopPage extends WizardPage
  {
    private TaskRepository taskRepository;

    private TableViewer viewer;

    public SelectPopPage(TaskRepository taskRepository)
    {
      super("SelectPopPage");
      setTitle("Import Pop");
      setDescription("Select a Pop.");
      this.taskRepository = taskRepository;
    }

    public TaskRepository getTaskRepository()
    {
      return taskRepository;
    }

    public void createControl(Composite parent)
    {
      Composite container = new Composite(parent, SWT.NULL);
      GridLayout layout = new GridLayout();
      container.setLayout(layout);
      layout.numColumns = 1;

      viewer = new TableViewer(container, SWT.BORDER | SWT.SINGLE | SWT.H_SCROLL | SWT.V_SCROLL);
      viewer.getControl().setLayoutData(new GridData(GridData.FILL_BOTH));
      viewer.setContentProvider(new RepositoryContentProvider());
      viewer.setLabelProvider(new DecoratingLabelProvider(new TaskRepositoryLabelProvider(), PlatformUI.getWorkbench()
          .getDecoratorManager().getLabelDecorator()));
      viewer.setSorter(new TaskRepositoriesSorter());
      viewer.setInput(this);
      viewer.addDoubleClickListener(new IDoubleClickListener()
      {
        public void doubleClick(DoubleClickEvent event)
        {
        }
      });

      dialogChanged();
      setControl(container);
    }

    private void dialogChanged()
    {
    }

    protected void updateStatus(String message)
    {
      setErrorMessage(message);
      setPageComplete(message == null);
    }

    /**
     * @author Eike Stepper
     */
    private static class RepositoryContentProvider implements IStructuredContentProvider
    {
      public void inputChanged(Viewer v, Object oldInput, Object newInput)
      {
      }

      public void dispose()
      {
      }

      public Object[] getElements(Object parent)
      {
        return TasksUi.getRepositoryManager().getAllRepositories().toArray();
      }
    }
  }
}
