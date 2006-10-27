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

import org.eclipse.emf.cdo.client.CDOPersistable;
import org.eclipse.emf.cdo.client.CDOResource;
import org.eclipse.emf.cdo.client.ResourceInfo;
import org.eclipse.emf.cdo.examples.client.ResourceCache;
import org.eclipse.emf.cdo.examples.client.internal.ExampleClientPlugin;
import org.eclipse.emf.cdo.examples.ui.ResourceContentProvider;
import org.eclipse.emf.cdo.examples.ui.ResourceFactoryHelper;
import org.eclipse.emf.cdo.examples.ui.ResourceLabelProvider;

import org.eclipse.emf.common.util.URI;

import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.ViewerSorter;
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
import org.eclipse.ui.dialogs.SaveAsDialog;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CDOExportWizardPage extends WizardPage
{
  private static final String SETTING_SOURCE_PATH = "CDOExportWizardPage.SOURCE_PATH";

  private static final String SETTING_RESOURCE_FACTORY = "CDOExportWizardPage.RESOURCE_FACTORY";

  private static final String SETTING_DESTINATION_URI = "CDOExportWizardPage.DESTINATION_URI";

  private CDOResource resource;

  private IStructuredSelection selection;

  private TableViewer sourcePathViewer;

  private Text destinationURIField;

  private Combo resourceFactoryField;

  private Button browseWorkspaceButton;

  private Button browseFileSystemButton;

  public CDOExportWizardPage(CDOResource resource, IStructuredSelection selection)
  {
    super("CDOExportWizardPage");
    this.selection = selection;
    this.resource = resource;
  }

  public void createControl(Composite parent)
  {
    try
    {
      ResourceCache resourceCache = resource == null ? ExampleClientPlugin.getResourceCache()
          : ExampleClientPlugin.createResourceCache(resource.getResourceManager());

      Composite control = new Composite(parent, SWT.NONE);
      control.setLayout(new GridLayout(1, false));
      control.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL
          | GridData.VERTICAL_ALIGN_FILL));

      Group sourceGroup = createGroup(control, "Source", 1, GridData.HORIZONTAL_ALIGN_FILL
          | GridData.GRAB_HORIZONTAL | GridData.VERTICAL_ALIGN_FILL | GridData.GRAB_VERTICAL);

      sourcePathViewer = new TableViewer(sourceGroup, SWT.BORDER | SWT.SINGLE | SWT.H_SCROLL
          | SWT.V_SCROLL);
      sourcePathViewer.setContentProvider(new ResourceContentProvider());
      sourcePathViewer.setLabelProvider(new ResourceLabelProvider());
      sourcePathViewer.setSorter(new ViewerSorter());
      sourcePathViewer.setInput(resourceCache);
      sourcePathViewer.getControl().setLayoutData(
          new GridData(GridData.HORIZONTAL_ALIGN_FILL | GridData.GRAB_HORIZONTAL
              | GridData.VERTICAL_ALIGN_FILL | GridData.GRAB_VERTICAL));
      sourcePathViewer.addSelectionChangedListener(new ISelectionChangedListener()
      {
        public void selectionChanged(SelectionChangedEvent event)
        {
          dialogChanged();
        }
      });

      Group destinationGroup = createGroup(control, "Destination", 2,
          GridData.HORIZONTAL_ALIGN_FILL | GridData.GRAB_HORIZONTAL);
      Label pathLabel = new Label(destinationGroup, SWT.NONE);
      pathLabel.setText("URI:");

      Composite grid = createGrid(destinationGroup, 3);

      destinationURIField = new Text(grid, SWT.BORDER);
      destinationURIField.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL
          | GridData.GRAB_HORIZONTAL));
      destinationURIField.addModifyListener(new ModifyListener()
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

      Label resourceFactoryLabel = new Label(destinationGroup, SWT.NONE);
      resourceFactoryLabel.setText("Factory:");

      resourceFactoryField = new Combo(destinationGroup, SWT.SINGLE | SWT.BORDER);
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
    SaveAsDialog dialog = new SaveAsDialog(getShell());
    dialog.setBlockOnOpen(true);
    dialog.setTitle(CDOExportWizard.TITLE);

    dialog.open();
    IPath path = dialog.getResult();
    if (path != null)
    {
      URI uri = URI.createPlatformResourceURI(path.toString());
      destinationURIField.setText(uri.toString());
    }
  }

  protected void browseFileSystem()
  {
    FileDialog dialog = new FileDialog(getShell(), SWT.SAVE);
    dialog.setText(CDOExportWizard.TITLE);
    String fileName = dialog.open();
    if (fileName != null)
    {
      String fullPath = new File(fileName).getAbsolutePath();
      URI uri = URI.createFileURI(fullPath);
      destinationURIField.setText(uri.toString());
    }
  }

  protected Group createGroup(Composite parent, String title, int numColumns, int layoutMask)
  {
    Group group = new Group(parent, SWT.NONE);
    group.setLayout(new GridLayout(numColumns, false));
    group.setLayoutData(new GridData(layoutMask));
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
      Object elem = selection.getFirstElement();
      if (elem instanceof ResourceInfo)
      {
        sourcePathViewer.setSelection(new StructuredSelection(elem));
      }
      else if (elem instanceof CDOResource)
      {
        sourcePathViewer.setSelection(new StructuredSelection(((CDOResource)elem).getInfo()));
      }
      else if (elem instanceof CDOPersistable)
      {
        CDOResource resource = ((CDOPersistable)elem).cdoGetResource();
        sourcePathViewer.setSelection(new StructuredSelection(resource.getInfo()));
      }
    }

    if (sourcePathViewer.getSelection() == null && resource != null)
    {
      sourcePathViewer.setSelection(new StructuredSelection(resource.getInfo()));
    }

    IDialogSettings settings = getDialogSettings();
    if (settings != null)
    {
      if (getSourcePath() == null)
      {
        String path = settings.get(SETTING_SOURCE_PATH);
        destinationURIField.setText(path == null ? "" : path);
      }

      String ext = settings.get(SETTING_RESOURCE_FACTORY);
      resourceFactoryField.setText(ext == null ? "" : ext);

      String uri = settings.get(SETTING_DESTINATION_URI);
      destinationURIField.setText(uri == null ? "" : uri);
    }
    else
    {
      resourceFactoryField.setText(ResourceFactoryHelper.XMI);
    }
  }

  public void saveValues()
  {
    IDialogSettings settings = getDialogSettings();
    if (settings != null)
    {
      String path = getSourcePath();
      settings.put(SETTING_SOURCE_PATH, path);

      String ext = getResourceFactoryExtension();
      settings.put(SETTING_RESOURCE_FACTORY, ext);

      String uri = getDestinationURI();
      settings.put(SETTING_DESTINATION_URI, uri);
    }
  }

  protected void dialogChanged()
  {
    setMessage(null);
    setErrorMessage(null);
    setPageComplete(true);

    String path = getSourcePath();
    if (path == null)
    {
      setMessage("Select a CDO resource to be exported.");
      setPageComplete(false);
      return;
    }

    if (getDestinationURI().length() == 0)
    {
      setMessage("Enter the destination URI.");
      setPageComplete(false);
      return;
    }

    String ext = getResourceFactoryExtension();
    if (ext.length() == 0)
    {
      setMessage("Select a resource factory to use for export.");
      setPageComplete(false);
      return;
    }

    if (ResourceFactoryHelper.getResourceFactory(ext) == null)
    {
      setErrorMessage("Invalid resource factory");
      resourceFactoryField.setFocus();
      return;
    }
  }

  public String getResourceFactoryExtension()
  {
    return resourceFactoryField.getText().trim();
  }

  public String getSourcePath()
  {
    IStructuredSelection selection = (IStructuredSelection)sourcePathViewer.getSelection();
    Object firstElement = selection.getFirstElement();
    if (firstElement instanceof ResourceInfo)
    {
      return ((ResourceInfo)firstElement).getPath();
    }

    return null;
  }

  public String getDestinationURI()
  {
    return destinationURIField.getText().trim();
  }
}
