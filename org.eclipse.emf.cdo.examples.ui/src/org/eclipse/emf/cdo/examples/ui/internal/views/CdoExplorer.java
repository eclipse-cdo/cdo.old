package org.eclipse.emf.cdo.example.ui.internal.views;


import org.eclipse.emf.cdo.client.ResourceInfo;
import org.eclipse.emf.cdo.example.client.CdoExampleClientPlugin;
import org.eclipse.emf.cdo.example.ui.internal.ResourceContentProvider;
import org.eclipse.emf.cdo.example.ui.internal.ResourceLabelProvider;
import org.eclipse.emf.cdo.example.ui.internal.UiUtils;
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


public class CdoExplorer extends ViewPart
{
  public static final String VIEW_ID = "org.eclipse.emf.cdo.example.ui.CdoExplorer";

  public static CdoExplorer INSTANCE;

  private TableViewer viewer;

  private Action newResourceAction;

  private Action deleteResourceAction;

  private Action openResourceAction;

  //  private Channel cdoResChannel;

  public CdoExplorer()
  {
    if (INSTANCE != null) throw new IllegalStateException();
  }

  public synchronized void createPartControl(Composite parent)
  {
    viewer = new TableViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
    viewer.setContentProvider(new ResourceContentProvider());
    viewer.setLabelProvider(new ResourceLabelProvider());
    viewer.setSorter(new ViewerSorter());
    viewer.setInput(CdoExampleClientPlugin.getResourceCache());

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
        CdoExplorer.this.fillContextMenu(manager);
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
        UiUtils.openCdoNewWizard();
      }
    };
    newResourceAction.setText("New CDO Resource");
    newResourceAction.setToolTipText("New CDO Resource");
    newResourceAction.setImageDescriptor(UiUtils.getImageDescriptor("full/ctool16/NewCdoResource"));

    deleteResourceAction = new Action()
    {
      public void run()
      {
        showMessage("Not implemented, yet: Delete CDO Resource");
      }
    };
    deleteResourceAction.setText("Delete CDO Resource");
    deleteResourceAction.setToolTipText("Delete CDO Resource");
    deleteResourceAction.setImageDescriptor(UiUtils
            .getImageDescriptor("full/ctool16/DeleteCdoResource"));

    openResourceAction = new Action()
    {
      public void run()
      {
        ISelection selection = viewer.getSelection();
        Object obj = ((IStructuredSelection)selection).getFirstElement();
        if (obj instanceof ResourceInfo)
        {
          UiUtils.openCdoEditor((ResourceInfo)obj);
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
