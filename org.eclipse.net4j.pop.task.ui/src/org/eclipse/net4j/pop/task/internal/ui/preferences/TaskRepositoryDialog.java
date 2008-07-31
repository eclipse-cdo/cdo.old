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

import org.eclipse.net4j.pop.task.ITaskRepositoryConfiguration;
import org.eclipse.net4j.pop.task.ITaskRepositoryConnector;
import org.eclipse.net4j.pop.task.ITaskRepositoryManager;
import org.eclipse.net4j.pop.task.internal.ui.bundle.OM;
import org.eclipse.net4j.pop.task.spi.ui.TaskRepositoryConfigurer;
import org.eclipse.net4j.pop.task.ui.ITaskRepositoryConfigurer;
import org.eclipse.net4j.util.ObjectUtil;
import org.eclipse.net4j.util.StringUtil;
import org.eclipse.net4j.util.event.IEvent;
import org.eclipse.net4j.util.event.IListener;
import org.eclipse.net4j.util.ui.StaticContentProvider;
import org.eclipse.net4j.util.ui.UIUtil;

import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Eike Stepper
 */
public class TaskRepositoryDialog extends TitleAreaDialog
{
  private Text nameText;

  private ComboViewer connectorViewer;

  private Group propertiesGroup;

  private String name;

  private ITaskRepositoryConnector connector;

  private ITaskRepositoryConfiguration configuration;

  private Map<ITaskRepositoryConnector, ITaskRepositoryConfiguration> configurations = new HashMap<ITaskRepositoryConnector, ITaskRepositoryConfiguration>();

  private IListener configurationListener = new IListener()
  {
    public void notifyEvent(IEvent event)
    {
      dialogChanged();
    }
  };

  private ITaskRepositoryConfigurer configurer;

  private Control control;

  public TaskRepositoryDialog(Shell parentShell)
  {
    super(parentShell);
    setShellStyle(SWT.SHELL_TRIM);
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public ITaskRepositoryConnector getConnector()
  {
    return connector;
  }

  public ITaskRepositoryConfiguration getConfiguration()
  {
    return configuration;
  }

  public void setConnector(ITaskRepositoryConnector connector)
  {
    this.connector = connector;
  }

  public void setConfiguration(ITaskRepositoryConfiguration configuration)
  {
    if (this.configuration != null)
    {
      this.configuration.removeListener(configurationListener);
    }

    this.configuration = configuration;
    if (configuration != null)
    {
      configurations.put(configuration.getConnector(), configuration);
      configuration.addListener(configurationListener);
    }
  }

  @Override
  protected void configureShell(Shell newShell)
  {
    super.configureShell(newShell);
    newShell.setText(getTitle());
  }

  @Override
  public boolean close()
  {
    if (configuration != null)
    {
      configuration.removeListener(configurationListener);
    }

    return super.close();
  }

  @Override
  protected Control createDialogArea(Composite parent)
  {
    Composite result = (Composite)super.createDialogArea(parent);
    GridLayout layout = new GridLayout(1, false);
    layout.marginWidth = 10;

    Composite composite = new Composite(result, SWT.NONE);
    composite.setLayout(layout);
    composite.setLayoutData(UIUtil.createGridData(true, true));

    setTitle(getTitle());
    setMessage("Select a task repository connector and enter the configuration properties.");

    GridLayout topLayout = new GridLayout(2, false);
    topLayout.marginWidth = 0;
    topLayout.marginHeight = 0;

    Composite top = new Composite(composite, SWT.NONE);
    top.setLayout(topLayout);
    top.setLayoutData(UIUtil.createGridData(true, false));

    new Label(top, SWT.NONE).setText("Name:");
    nameText = new Text(top, SWT.BORDER);
    nameText.setLayoutData(UIUtil.createGridData(true, false));
    nameText.setEnabled(name == null);

    Collection<ITaskRepositoryConnector> connectors = ITaskRepositoryManager.INSTANCE.getConnectors().values();
    new Label(top, SWT.NONE).setText("Connector:");
    connectorViewer = new ComboViewer(top, SWT.BORDER);
    connectorViewer.setContentProvider(new StaticContentProvider(connectors));
    connectorViewer.setInput(ITaskRepositoryManager.INSTANCE);
    connectorViewer.setLabelProvider(new LabelProvider());

    propertiesGroup = new Group(composite, 2);
    propertiesGroup.setLayout(UIUtil.createGridLayout(1));
    propertiesGroup.setLayoutData(UIUtil.createGridData());

    initValues();

    nameText.addModifyListener(new ModifyListener()
    {
      public void modifyText(ModifyEvent e)
      {
        dialogChanged();
      }
    });

    connectorViewer.addSelectionChangedListener(new ISelectionChangedListener()
    {
      public void selectionChanged(SelectionChangedEvent event)
      {
        dialogChanged();
      }
    });

    return result;
  }

  private void initValues()
  {
    nameText.setText(StringUtil.safe(name));
    if (connector == null)
    {
      String connectorName = OM.PREF_DEFAULT_CONNECTOR.getValue();
      Map<String, ITaskRepositoryConnector> connectors = ITaskRepositoryManager.INSTANCE.getConnectors();
      connector = connectors.get(connectorName);
      if (connector == null && !connectors.isEmpty())
      {
        connector = connectors.values().iterator().next();
      }
    }

    if (connector != null)
    {
      connectorViewer.setSelection(new StructuredSelection(connector));
    }

    showConfiguration();
    validateValues();
  }

  private void dialogChanged()
  {
    name = nameText.getText();

    IStructuredSelection selection = (IStructuredSelection)connectorViewer.getSelection();
    ITaskRepositoryConnector connector = (ITaskRepositoryConnector)selection.getFirstElement();
    if (!ObjectUtil.equals(connector, this.connector))
    {
      this.connector = connector;
      OM.PREF_DEFAULT_CONNECTOR.setValue(connector == null ? "" : connector.getName());
      showConfiguration();
    }

    validateValues();
  }

  private void validateValues()
  {
    if (StringUtil.isEmpty(name))
    {
      updateStatus("Task repository name is empty");
      return;
    }

    if (connector != null)
    {
      try
      {
        connector.validateConfiguration(configuration);
      }
      catch (Exception ex)
      {
        String message = ex.getMessage();
        if (StringUtil.isEmpty(message))
        {
          message = "An error occurred while validating the connector properties.\nSee the Error Log for details.";
          OM.LOG.error(ex);
        }

        updateStatus(message);
        return;
      }
    }

    updateStatus(null);
  }

  private void showConfiguration()
  {
    if (control != null)
    {
      control.dispose();
      control = null;
    }

    if (connector != null)
    {
      String name = connector.getName();
      configurer = TaskRepositoryConfigurer.Registry.INSTANCE.getConfigurers().get(name);
      if (configurer != null)
      {
        ITaskRepositoryConfiguration config = configurations.get(connector);
        if (config == null)
        {
          config = connector.createConfiguration();
          configurations.put(connector, config);
        }

        setConfiguration(config);
        control = configurer.createControl(propertiesGroup, configuration);
        if (control != null)
        {
          control.setLayoutData(UIUtil.createGridData(true, true));
        }
      }
    }
    else
    {
      configurer = null;
    }

    propertiesGroup.layout();
  }

  private void updateStatus(String message)
  {
    setErrorMessage(message);
    // setPageComplete(message == null);
  }

  private String getTitle()
  {
    return (StringUtil.isEmpty(name) ? "New" : "Change") + " Task Repository";
  }
}
