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
package org.eclipse.net4j.pop.task.internal.ui.preferences;

import org.eclipse.net4j.pop.task.ITaskRepository;
import org.eclipse.net4j.pop.task.ITaskRepositoryConfiguration;
import org.eclipse.net4j.pop.task.ITaskRepositoryConnector;
import org.eclipse.net4j.pop.task.ITaskRepositoryManager;
import org.eclipse.net4j.util.container.IContainer;
import org.eclipse.net4j.util.ui.UIUtil;
import org.eclipse.net4j.util.ui.prefs.OMPreferencePage;
import org.eclipse.net4j.util.ui.views.ContainerItemProvider;
import org.eclipse.net4j.util.ui.widgets.TextAndDisable;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;

/**
 * @author Eike Stepper
 */
public class TaskPreferencePage extends OMPreferencePage
{
  private TableViewer repoViewer;

  private TextAndDisable autoSync;

  private RepositoryItemProvider repoItemProvider;

  private Button addRepoButton;

  private Button removeRepoButton;

  private Button changeRepoButton;

  private ITaskRepository repository;

  public TaskPreferencePage()
  {
    super(org.eclipse.net4j.pop.internal.task.bundle.OM.PREFS);
    repoItemProvider = new RepositoryItemProvider();
  }

  @Override
  public void dispose()
  {
    repoItemProvider.dispose();
    super.dispose();
  }

  @Override
  protected Control createUI(Composite parent)
  {
    Composite composite = UIUtil.createGridComposite(parent, 1);
    ((GridLayout)composite.getLayout()).verticalSpacing = 5;
    composite.setLayoutData(UIUtil.createGridData());

    Group repoGroup = new Group(composite, 2);
    repoGroup.setLayout(new GridLayout(2, false));
    repoGroup.setLayoutData(UIUtil.createGridData());
    repoGroup.setText("Task repositories");

    repoViewer = new TableViewer(repoGroup, SWT.BORDER | SWT.SINGLE);
    repoViewer.getControl().setLayoutData(UIUtil.createGridData());
    repoViewer.setContentProvider(repoItemProvider);
    repoViewer.setInput(ITaskRepositoryManager.INSTANCE);
    repoViewer.setLabelProvider(repoItemProvider);
    repoViewer.addSelectionChangedListener(new ISelectionChangedListener()
    {
      public void selectionChanged(SelectionChangedEvent event)
      {
        IStructuredSelection selection = (IStructuredSelection)repoViewer.getSelection();
        repository = (ITaskRepository)selection.getFirstElement();
        dialogChanged();
      }
    });

    repoViewer.addDoubleClickListener(new IDoubleClickListener()
    {
      public void doubleClick(DoubleClickEvent event)
      {
        changeRepository();
      }
    });

    Composite repoButtons = new Composite(repoGroup, SWT.NONE);
    repoButtons.setLayout(new GridLayout(1, false));
    repoButtons.setLayoutData(UIUtil.createGridData(false, false));

    addRepoButton = new Button(repoButtons, SWT.PUSH);
    addRepoButton.setLayoutData(UIUtil.createGridData(true, false));
    addRepoButton.setText("&Add...");
    addRepoButton.addSelectionListener(new SelectionAdapter()
    {
      @Override
      public void widgetSelected(SelectionEvent e)
      {
        addRepository();
      }
    });

    changeRepoButton = new Button(repoButtons, SWT.PUSH);
    changeRepoButton.setLayoutData(UIUtil.createGridData(true, false));
    changeRepoButton.setText("&Change...");
    changeRepoButton.addSelectionListener(new SelectionAdapter()
    {
      @Override
      public void widgetSelected(SelectionEvent e)
      {
        changeRepository();
      }
    });

    removeRepoButton = new Button(repoButtons, SWT.PUSH);
    removeRepoButton.setLayoutData(UIUtil.createGridData(true, false));
    removeRepoButton.setText("&Remove...");
    removeRepoButton.addSelectionListener(new SelectionAdapter()
    {
      @Override
      public void widgetSelected(SelectionEvent e)
      {
        removeRepository();
      }
    });

    Group syncGroup = new Group(composite, SWT.NONE);
    syncGroup.setLayout(new GridLayout(2, false));
    syncGroup.setText("Automatic synchronization");
    syncGroup.setLayoutData(UIUtil.createGridData(true, false));

    new Label(syncGroup, SWT.NONE).setText("Every minutes:");
    autoSync = new TextAndDisable(syncGroup, SWT.BORDER, "0");
    autoSync.setLayoutData(UIUtil.createGridData(true, false));

    initValues();
    return composite;
  }

  @Override
  public boolean performOk()
  {
    org.eclipse.net4j.pop.internal.task.bundle.OM.PREF_AUTO_SYNC.setValue(Integer.parseInt(autoSync.getValue()));
    return super.performOk();
  }

  protected void initValues()
  {
    autoSync.setValue(String.valueOf(org.eclipse.net4j.pop.internal.task.bundle.OM.PREF_AUTO_SYNC.getValue()));
  }

  @Override
  protected void dialogChanged()
  {
    removeRepoButton.setEnabled(repository != null);
    changeRepoButton.setEnabled(repository != null);
  }

  private void addRepository()
  {
    try
    {
      TaskRepositoryDialog dialog = new TaskRepositoryDialog(getShell());
      if (dialog.open() == TaskRepositoryDialog.OK)
      {
        String name = dialog.getName();
        ITaskRepositoryConnector connector = dialog.getConnector();
        ITaskRepositoryConfiguration configuration = dialog.getConfiguration();
        repository = ITaskRepositoryManager.INSTANCE.createRepository(name, connector, configuration);
        repoViewer.setSelection(new StructuredSelection(repository));
      }
    }
    catch (RuntimeException ex)
    {
      String message = "An error occurred while adding the new task repository.\nSee the Error Log for details.";
      MessageDialog.openError(getShell(), "Add Task Repository", message);
      throw ex;
    }
  }

  private void changeRepository()
  {
    try
    {
      TaskRepositoryDialog dialog = new TaskRepositoryDialog(getShell());
      dialog.setName(repository.getName());
      dialog.setConnector(repository.getConnector());
      dialog.setConfiguration(repository.getConfiguration());
      if (dialog.open() == TaskRepositoryDialog.OK)
      {
        ITaskRepositoryConnector connector = dialog.getConnector();
        ITaskRepositoryConfiguration configuration = dialog.getConfiguration();
        repository.change(connector, configuration);
      }
    }
    catch (RuntimeException ex)
    {
      String message = "An error occurred while changing the task repository.\nSee the Error Log for details.";
      MessageDialog.openError(getShell(), "Change Task Repository", message);
      throw ex;
    }
  }

  private void removeRepository()
  {
    String name = repository.getName();
    String message = "Do you want to remove the \"" + name + "\" task repository?";
    if (MessageDialog.openQuestion(getShell(), "Remove Task Repository", message))
    {
      ITaskRepositoryManager.INSTANCE.removeRepository(name);
    }
  }

  /**
   * @author Eike Stepper
   */
  public class RepositoryItemProvider extends ContainerItemProvider<IContainer<Object>>
  {
    public RepositoryItemProvider()
    {
    }

    @Override
    public String getText(Object obj)
    {
      if (obj instanceof ITaskRepository)
      {
        ITaskRepository repository = (ITaskRepository)obj;
        return repository.getName() + " (" + repository.getConnector().getName() + ")";
      }

      return super.getText(obj);
    }

    @Override
    protected void connectInput(IContainer<Object> input)
    {
      super.connectInput(input);
      ITaskRepositoryManager.INSTANCE.addListener(this);
    }

    @Override
    protected void disconnectInput(IContainer<Object> input)
    {
      ITaskRepositoryManager.INSTANCE.removeListener(this);
      super.disconnectInput(input);
    }
  }
}
