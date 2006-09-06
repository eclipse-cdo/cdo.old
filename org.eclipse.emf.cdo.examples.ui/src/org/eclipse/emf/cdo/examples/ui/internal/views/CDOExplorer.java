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
package org.eclipse.emf.cdo.examples.ui.internal.views;


import org.eclipse.net4j.core.Channel;

import org.eclipse.emf.cdo.client.CDOResource;
import org.eclipse.emf.cdo.client.ResourceInfo;
import org.eclipse.emf.cdo.client.protocol.ClientCDOResProtocolImpl;
import org.eclipse.emf.cdo.examples.client.ResourceCache;
import org.eclipse.emf.cdo.examples.client.internal.ExampleClientPlugin;
import org.eclipse.emf.cdo.examples.ui.ResourceContentProvider;
import org.eclipse.emf.cdo.examples.ui.ResourceLabelProvider;
import org.eclipse.emf.cdo.examples.ui.UIUtils;
import org.eclipse.emf.cdo.examples.ui.internal.actions.CDOCreateResourceAction;
import org.eclipse.emf.cdo.examples.ui.internal.actions.CDOExportResourceAction;
import org.eclipse.emf.cdo.examples.ui.internal.actions.CDOImportResourceAction;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.part.ViewPart;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class CDOExplorer extends ViewPart implements ISelectionProvider
{
  public static final String VIEW_ID = "org.eclipse.emf.cdo.examples.ui.CDOExplorer";

  public static CDOExplorer INSTANCE;

  private ResourceCache resourceCache;

  private TableViewer viewer;

  private Action deleteResourceAction;

  private CDOCreateResourceAction createResourceAction;

  private CDOImportResourceAction importResourceAction;

  private CDOExportResourceAction exportResourceAction;

  private Action openResourceAction;

  public CDOExplorer()
  {
    if (INSTANCE != null) throw new IllegalStateException();
    resourceCache = ExampleClientPlugin.getResourceCache();
  }

  public synchronized void createPartControl(Composite parent)
  {
    viewer = new TableViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
    viewer.setContentProvider(new ResourceContentProvider());
    viewer.setLabelProvider(new ResourceLabelProvider());
    viewer.setSorter(new ViewerSorter());
    viewer.setInput(resourceCache);

    makeActions();
    hookContextMenu();
    hookDoubleClickAction();
    contributeToActionBars();

    getSite().setSelectionProvider(this);
    INSTANCE = this;
  }

  public void addSelectionChangedListener(ISelectionChangedListener listener)
  {
    viewer.addSelectionChangedListener(listener);
  }

  public ISelection getSelection()
  {
    return viewer.getSelection();
  }

  public void removeSelectionChangedListener(ISelectionChangedListener listener)
  {
    viewer.removeSelectionChangedListener(listener);
  }

  public void setSelection(ISelection selection)
  {
    viewer.setSelection(selection);
  }

  @Override
  public void dispose()
  {
    INSTANCE = null;
    super.dispose();
  }

  private void hookContextMenu()
  {
    MenuManager menuMgr = new MenuManager("#PopupMenu");
    menuMgr.setRemoveAllWhenShown(true);
    menuMgr.addMenuListener(new IMenuListener()
    {
      public void menuAboutToShow(IMenuManager manager)
      {
        CDOExplorer.this.fillContextMenu(manager);
      }
    });
    Menu menu = menuMgr.createContextMenu(viewer.getControl());
    viewer.getControl().setMenu(menu);
    getSite().registerContextMenu(menuMgr, viewer);
  }

  private void contributeToActionBars()
  {
    IActionBars bars = getViewSite().getActionBars();
    fillLocalPullDown(bars.getMenuManager());
    fillLocalToolBar(bars.getToolBarManager());
  }

  private void fillLocalPullDown(IMenuManager manager)
  {
    manager.add(createResourceAction);
    manager.add(new Separator());
    manager.add(deleteResourceAction);
    manager.add(new Separator());
    manager.add(importResourceAction);
    manager.add(exportResourceAction);
  }

  private void fillContextMenu(IMenuManager manager)
  {
    manager.add(deleteResourceAction);
    manager.add(exportResourceAction);
    manager.add(new Separator());
    // Other plug-ins can contribute there actions here
    manager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
  }

  private void fillLocalToolBar(IToolBarManager manager)
  {
    manager.add(createResourceAction);
    manager.add(deleteResourceAction);
    manager.add(new Separator());
    manager.add(importResourceAction);
    manager.add(exportResourceAction);
  }

  private void makeActions()
  {
    createResourceAction = new CDOCreateResourceAction();
    importResourceAction = new CDOImportResourceAction();
    exportResourceAction = new CDOExportResourceAction();

    deleteResourceAction = new Action()
    {
      public void run()
      {
        if (MessageDialog.openQuestion(viewer.getControl().getShell(), "CDO Explorer",
                "Sure to delete the selected resources from the CDO repository?"))
        {
          Set<Integer> rids = new HashSet<Integer>();
          ISelection selection = viewer.getSelection();
          if (selection instanceof IStructuredSelection)
          {
            IStructuredSelection ssel = (IStructuredSelection)selection;
            for (Iterator it = ssel.iterator(); it.hasNext();)
            {
              Object element = it.next();
              if (element instanceof ResourceInfo)
              {
                ResourceInfo resourceInfo = (ResourceInfo)element;
                int rid = resourceInfo.getRID();
                rids.add(rid);
              }
              else if (element instanceof CDOResource)
              {
                CDOResource resource = (CDOResource)element;
                int rid = resource.getRID();
                rids.add(rid);
              }
            }
          }

          if (rids.isEmpty())
          {
            showMessage("No CDO resource is selected.");
            return;
          }

          Channel channel = resourceCache.getChannel();
          boolean ok = ClientCDOResProtocolImpl.deleteResources(channel, rids);
          if (ok)
          {
            showMessage("Resources have been successfully deleted.");
          }
          else
          {
            showMessage("Resources have not been deleted.");
          }
        }
      }
    };

    deleteResourceAction.setText("Delete CDO Resource");
    deleteResourceAction.setToolTipText("Delete CDO Resource");
    deleteResourceAction.setImageDescriptor(UIUtils
            .getImageDescriptor("full/ctool16/DeleteCDOResource"));

    openResourceAction = new Action()
    {
      public void run()
      {
        ISelection selection = viewer.getSelection();
        Object obj = ((IStructuredSelection)selection).getFirstElement();
        if (obj instanceof ResourceInfo)
        {
          UIUtils.openCDOEditor((ResourceInfo)obj);
        }
      }
    };
  }

  private void hookDoubleClickAction()
  {
    viewer.addDoubleClickListener(new IDoubleClickListener()
    {
      public void doubleClick(DoubleClickEvent event)
      {
        openResourceAction.run();
      }
    });
  }

  private void showMessage(String message)
  {
    MessageDialog.openInformation(viewer.getControl().getShell(), "CDO Explorer", message);
  }

  public void setFocus()
  {
    viewer.getControl().setFocus();
  }
}
