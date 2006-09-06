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
package org.eclipse.emf.cdo.examples.ui.internal.wizards;


import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.cdo.examples.ui.ResourceFactoryHelper;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.ResourceListSelectionDialog;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class CDOImportWizardPage extends WizardPage
{
  private static final String SETTING_SOURCE_URI = "CDOImportWizardPage.SOURCE_URI";

  private static final String SETTING_RESOURCE_FACTORY = "CDOImportWizardPage.RESOURCE_FACTORY";

  private static final String SETTING_DESTINATION_PATH = "CDOImportWizardPage.DESTINATION_PATH";

  private IStructuredSelection selection;

  private Text sourceURIField;

  private Combo resourceFactoryField;

  private Button browseWorkspaceButton;

  private Button browseFileSystemButton;

  private Text destinationPathField;

  public CDOImportWizardPage(IStructuredSelection selection)
  {
    super("CDOImportWizardPage");
    this.selection = selection;
  }

  public void createControl(Composite parent)
  {
    try
    {
      Composite control = new Composite(parent, SWT.NONE);
      control.setLayout(new GridLayout(1, false));
      control.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL
              | GridData.VERTICAL_ALIGN_FILL));

      Group sourceGroup = createGroup(control, "Source");

      Label sourceURILabel = new Label(sourceGroup, SWT.NONE);
      sourceURILabel.setText("URI:");

      Composite grid = createGrid(sourceGroup, 3);

      sourceURIField = new Text(grid, SWT.BORDER);
      sourceURIField.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL
              | GridData.GRAB_HORIZONTAL));
      sourceURIField.addModifyListener(new ModifyListener()
      {
        public void modifyText(ModifyEvent e)
        {
          dialogChanged();
        }
      });

      browseWorkspaceButton = new Button(grid, SWT.PUSH);
      browseWorkspaceButton.setText("Workspace...");
      browseWorkspaceButton.addSelectionListener(new SelectionListener()
      {
        public void widgetDefaultSelected(SelectionEvent e)
        {
          widgetSelected(e);
        }

        public void widgetSelected(SelectionEvent e)
        {
          browseWorkspace();
        }
      });

      browseFileSystemButton = new Button(grid, SWT.PUSH);
      browseFileSystemButton.setText("File System...");
      browseFileSystemButton.addSelectionListener(new SelectionListener()
      {
        public void widgetDefaultSelected(SelectionEvent e)
        {
          widgetSelected(e);
        }

        public void widgetSelected(SelectionEvent e)
        {
          browseFileSystem();
        }
      });

      Label resourceFactoryLabel = new Label(sourceGroup, SWT.NONE);
      resourceFactoryLabel.setText("Factory:");

      resourceFactoryField = new Combo(sourceGroup, SWT.SINGLE | SWT.BORDER);
      resourceFactoryField.addModifyListener(new ModifyListener()
      {
        public void modifyText(ModifyEvent e)
        {
          dialogChanged();
        }
      });
      resourceFactoryField.addSelectionListener(new SelectionListener()
      {
        public void widgetDefaultSelected(SelectionEvent e)
        {
          widgetSelected(e);
        }

        public void widgetSelected(SelectionEvent e)
        {
          dialogChanged();
        }
      });

      Group destinationGroup = createGroup(control, "Destination");
      Label pathLabel = new Label(destinationGroup, SWT.NONE);
      pathLabel.setText("Path:");

      destinationPathField = new Text(destinationGroup, SWT.BORDER);
      destinationPathField.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL
              | GridData.GRAB_HORIZONTAL));
      destinationPathField.addModifyListener(new ModifyListener()
      {
        public void modifyText(ModifyEvent e)
        {
          dialogChanged();
        }
      });

      initValues();
      setControl(control);
    }
    catch (Exception ex)
    {
      ex.printStackTrace();
    }
  }

  protected void browseWorkspace()
  {
    IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
    ResourceListSelectionDialog dialog = new ResourceListSelectionDialog(getShell(), root,
            IResource.FILE);
    dialog.setBlockOnOpen(true);
    dialog.setAllowUserToToggleDerived(true);
    dialog.setTitle(CDOImportWizard.TITLE);

    dialog.open();
    Object[] result = dialog.getResult();
    if (result != null && result.length != 0 && result[0] instanceof IFile)
    {
      String fullPath = ((IFile)result[0]).getFullPath().toString();
      URI uri = URI.createPlatformResourceURI(fullPath);
      sourceURIField.setText(uri.toString());
    }
  }

  protected void browseFileSystem()
  {
    FileDialog dialog = new FileDialog(getShell(), SWT.OPEN);
    dialog.setText(CDOImportWizard.TITLE);
    String fileName = dialog.open();
    if (fileName != null)
    {
      String fullPath = new File(fileName).getAbsolutePath();
      URI uri = URI.createFileURI(fullPath);
      sourceURIField.setText(uri.toString());
    }
  }

  protected Group createGroup(Composite parent, String title)
  {
    Group group = new Group(parent, SWT.NONE);
    group.setLayout(new GridLayout(2, false));
    group.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL | GridData.GRAB_HORIZONTAL));
    group.setText(title);
    return group;
  }

  protected Composite createGrid(Composite parent, int numColumns)
  {
    GridData gd = new GridData(GridData.HORIZONTAL_ALIGN_FILL | GridData.GRAB_HORIZONTAL);
    GridLayout layout = new GridLayout(numColumns, false);
    layout.marginHeight = 0;
    layout.marginWidth = 0;

    Composite grid = new Composite(parent, SWT.NONE);
    grid.setLayoutData(gd);
    grid.setLayout(layout);
    return grid;
  }

  protected void initValues()
  {
    List<String> extensions = new ArrayList<String>(ResourceFactoryHelper.getExtensions());
    Collections.sort(extensions);
    for (String ext : extensions)
    {
      resourceFactoryField.add(ext);
    }

    if (selection != null)
    {
      Object firstElement = selection.getFirstElement();
      if (firstElement instanceof IFile)
      {
        IFile file = (IFile)firstElement;
        sourceURIField.setText("platform:/resource" + file.getFullPath().toString());
      }
    }

    IDialogSettings settings = getDialogSettings();
    if (settings != null)
    {
      if (getSourceURI().length() == 0)
      {
        String uri = settings.get(SETTING_SOURCE_URI);
        sourceURIField.setText(uri == null ? "" : uri);
      }

      String ext = settings.get(SETTING_RESOURCE_FACTORY);
      resourceFactoryField.setText(ext == null ? "" : ext);

      String path = settings.get(SETTING_DESTINATION_PATH);
      destinationPathField.setText(path == null ? "" : path);
    }
    else
    {
      resourceFactoryField.setText(ResourceFactoryHelper.XMI);
    }

    sourceURIField.selectAll();
  }

  public void saveValues()
  {
    IDialogSettings settings = getDialogSettings();
    if (settings != null)
    {
      String uri = getSourceURI();
      settings.put(SETTING_SOURCE_URI, uri);

      String ext = getResourceFactoryExtension();
      settings.put(SETTING_RESOURCE_FACTORY, ext);

      String path = getDestinationPath();
      settings.put(SETTING_DESTINATION_PATH, path);
    }
  }

  protected void dialogChanged()
  {
    setMessage(null);
    setErrorMessage(null);

    String uri = getSourceURI();
    if (uri.length() == 0)
    {
      setMessage("Enter the URI of the file to be imported.");
      return;
    }

    String ext = getResourceFactoryExtension();
    if (ext.length() == 0)
    {
      setMessage("Select a resource factory to use for import.");
      return;
    }

    if (ResourceFactoryHelper.getResourceFactory(ext) == null)
    {
      setErrorMessage("Invalid resource factory");
      resourceFactoryField.setFocus();
      return;
    }

    if (getDestinationPath().length() == 0)
    {
      setMessage("Enter the destinationy path.");
      return;
    }
  }

  public String getResourceFactoryExtension()
  {
    return resourceFactoryField.getText().trim();
  }

  public String getSourceURI()
  {
    return sourceURIField.getText().trim();
  }

  public String getDestinationPath()
  {
    return destinationPathField.getText().trim();
  }
}
