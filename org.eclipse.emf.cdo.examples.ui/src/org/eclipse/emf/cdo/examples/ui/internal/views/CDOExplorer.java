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
package org.eclipse.emf.cdo.example.ui.internal.views;


import org.eclipse.emf.cdo.client.ResourceInfo;
import org.eclipse.emf.cdo.example.client.internal.ExampleClientPlugin;
import org.eclipse.emf.cdo.example.ui.internal.ResourceContentProvider;
import org.eclipse.emf.cdo.example.ui.internal.ResourceLabelProvider;
import org.eclipse.emf.cdo.example.ui.internal.UIUtils;
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
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.part.ViewPart;


public class CDOExplorer extends ViewPart
{
  public static final String VIEW_ID = "org.eclipse.emf.cdo.example.ui.CDOExplorer";

  public static CDOExplorer INSTANCE;

  private TableViewer viewer;

  private Action newResourceAction;

  private Action deleteResourceAction;

  private Action openResourceAction;

  //  private Channel cdoResChannel;

  public CDOExplorer()
  {
    if (INSTANCE != null) throw new IllegalStateException();
  }

  public synchronized void createPartControl(Composite parent)
  {
    viewer = new TableViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
    viewer.setContentProvider(new ResourceContentProvider());
    viewer.setLabelProvider(new ResourceLabelProvider());
    viewer.setSorter(new ViewerSorter());
    viewer.setInput(ExampleClientPlugin.getResourceCache());

    makeActions();
    hookContextMenu();
    hookDoubleClickAction();
    contributeToActionBars();
    INSTANCE = this;
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
    manager.add(newResourceAction);
    manager.add(new Separator());
    manager.add(deleteResourceAction);
  }

  private void fillContextMenu(IMenuManager manager)
  {
    manager.add(newResourceAction);
    manager.add(deleteResourceAction);
    manager.add(new Separator());
    // Other plug-ins can contribute there actions here
    manager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
  }

  private void fillLocalToolBar(IToolBarManager manager)
  {
    manager.add(newResourceAction);
    manager.add(deleteResourceAction);
  }

  private void makeActions()
  {
    newResourceAction = new Action()
    {
      public void run()
      {
        UIUtils.openCDONewWizard();
      }
    };
    newResourceAction.setText("New CDO Resource");
    newResourceAction.setToolTipText("New CDO Resource");
    newResourceAction.setImageDescriptor(UIUtils.getImageDescriptor("full/ctool16/NewCDOResource"));

    deleteResourceAction = new Action()
    {
      public void run()
      {
        showMessage("Not implemented, yet: Delete CDO Resource");
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
