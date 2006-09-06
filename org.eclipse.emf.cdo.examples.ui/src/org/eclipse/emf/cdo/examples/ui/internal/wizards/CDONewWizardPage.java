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


import org.eclipse.emf.cdo.client.ClassInfo;
import org.eclipse.emf.cdo.examples.client.internal.ExampleClientPlugin;
import org.eclipse.emf.cdo.examples.ui.PackageContentProvider;
import org.eclipse.emf.cdo.examples.ui.PackageLabelProvider;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;


public class CDONewWizardPage extends WizardPage
{
  private Text resourcePathText;

  private TreeViewer rootElementViewer;

  public CDONewWizardPage()
  {
    super("wizardPage");
    setTitle(CDONewWizard.TITLE);
    setDescription("This wizard creates a new remote CDO resource that can be opened by the CDO editor.");
  }

  public String getResourcePath()
  {
    return resourcePathText.getText();
  }

  public ClassInfo getRootElement()
  {
    try
    {
      IStructuredSelection selection = (IStructuredSelection)rootElementViewer.getSelection();
      return (ClassInfo)selection.getFirstElement();
    }
    catch (ClassCastException ex)
    {
      return null;
    }
  }

  public void createControl(Composite parent)
  {
    Composite container = new Composite(parent, SWT.NULL);
    final GridLayout gridLayout = new GridLayout();
    gridLayout.numColumns = 2;
    container.setLayout(gridLayout);

    final Label resourcePathLabel = new Label(container, SWT.NONE);
    resourcePathLabel.setText("Resource &Path:");

    resourcePathText = new Text(container, SWT.BORDER);
    resourcePathText.setLayoutData(new GridData(GridData.FILL, GridData.CENTER, true, false));
    resourcePathText.addModifyListener(new ModifyListener()
    {
      public void modifyText(ModifyEvent e)
      {
        dialogChanged();
      }
    });

    final Composite composite = new Composite(container, SWT.NONE);
    composite.setLayoutData(new GridData(GridData.FILL, GridData.FILL, true, true, 2, 1));
    final GridLayout gridLayout_1 = new GridLayout();
    gridLayout_1.marginWidth = 0;
    gridLayout_1.marginHeight = 0;
    composite.setLayout(gridLayout_1);

    final Label rootElementLabel = new Label(composite, SWT.NONE);
    rootElementLabel.setText("Root &Element:");

    Tree tree = new Tree(composite, SWT.BORDER);
    tree.setLayoutData(new GridData(GridData.FILL, GridData.FILL, true, true));

    rootElementViewer = new TreeViewer(tree);
    rootElementViewer.setContentProvider(new PackageContentProvider());
    rootElementViewer.setLabelProvider(new PackageLabelProvider());
    rootElementViewer.setSorter(new ViewerSorter());
    rootElementViewer.setInput(ExampleClientPlugin.getPackageManager());
    rootElementViewer.addSelectionChangedListener(new ISelectionChangedListener()
    {
      public void selectionChanged(SelectionChangedEvent event)
      {
        dialogChanged();
      }
    });
    rootElementViewer.addDoubleClickListener(new IDoubleClickListener()
    {
      public void doubleClick(DoubleClickEvent event)
      {
        getWizard().performFinish();
        ((WizardDialog)getContainer()).close();
      }
    });

    new Label(container, SWT.NONE);

    initialize();
    dialogChanged();
    setControl(container);
  }

  private void initialize()
  {
    resourcePathText.setText("/");
    resourcePathText.setSelection(1);
    //    rootElementViewer.expandAll();
  }

  private void dialogChanged()
  {
    String resourcePath = getResourcePath();
    if (!resourcePath.startsWith("/"))
    {
      updateStatus("Resource path must start with '/'");
      return;
    }
    else if (resourcePath.length() < 2)
    {
      updateStatus("Resource path must not be the root");
      return;
    }

    IStructuredSelection selection = (IStructuredSelection)rootElementViewer.getSelection();
    Object selectedElement = selection.getFirstElement();
    if (!(selectedElement instanceof ClassInfo))
    {
      updateStatus("Select a class for the root element");
      return;
    }

    updateStatus(null);
  }

  private void updateStatus(String message)
  {
    setErrorMessage(message);
    setPageComplete(message == null);
  }
}
