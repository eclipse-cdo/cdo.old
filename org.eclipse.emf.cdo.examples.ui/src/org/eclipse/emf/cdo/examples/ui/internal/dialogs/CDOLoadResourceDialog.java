/***************************************************************************
 * Copyright (c) 2004, 2005, 2006 Eike Stepper, Fuggerstr. 39, 10777 Berlin, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 **************************************************************************/
package org.eclipse.emf.cdo.examples.ui.internal.dialogs;


import org.eclipse.emf.cdo.client.ResourceInfo;
import org.eclipse.emf.cdo.examples.client.internal.ExampleClientPlugin;
import org.eclipse.emf.cdo.examples.ui.internal.ResourceContentProvider;
import org.eclipse.emf.cdo.examples.ui.internal.ResourceLabelProvider;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class CDOLoadResourceDialog extends Dialog
{
  private TableViewer resourcesViewer;

  private List<ResourceInfo> resourceInfos = new ArrayList<ResourceInfo>();

  public CDOLoadResourceDialog(Shell parentShell)
  {
    super(parentShell);
  }

  public List<ResourceInfo> getResourceInfos()
  {
    return resourceInfos;
  }

  @Override
  protected Control createDialogArea(Composite parent)
  {
    Composite container = (Composite)super.createDialogArea(parent);

    final Table table = new Table(container, SWT.BORDER | SWT.MULTI);
    table.setLayoutData(new GridData(GridData.FILL, GridData.FILL, true, true));

    resourcesViewer = new TableViewer(table);
    resourcesViewer.setContentProvider(new ResourceContentProvider());
    resourcesViewer.setLabelProvider(new ResourceLabelProvider());
    resourcesViewer.setSorter(new ViewerSorter());
    resourcesViewer.setInput(ExampleClientPlugin.getResourceCache());
    resourcesViewer.addSelectionChangedListener(new ISelectionChangedListener()
    {
      public void selectionChanged(SelectionChangedEvent event)
      {
        resourceInfos.clear();
        IStructuredSelection selection = (IStructuredSelection)resourcesViewer.getSelection();
        for (Iterator it = selection.iterator(); it.hasNext();)
        {
          ResourceInfo element = (ResourceInfo)it.next();
          resourceInfos.add(element);
        }

        dialogChanged();
      }
    });

    dialogChanged();
    return container;
  }

  @Override
  protected void createButtonsForButtonBar(Composite parent)
  {
    createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
    createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
  }

  @Override
  protected Point getInitialSize()
  {
    return new Point(500, 375);
  }

  private void dialogChanged()
  {
    Button ok = getButton(IDialogConstants.OK_ID);
    if (ok != null)
    {
      ok.setEnabled(!resourceInfos.isEmpty());
    }
  }
}
