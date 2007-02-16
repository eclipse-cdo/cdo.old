package org.eclipse.net4j.container.internal.ui.views;

import org.eclipse.net4j.container.Container;
import org.eclipse.net4j.container.ContainerManager;
import org.eclipse.net4j.transport.Acceptor;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;

public class Net4jExplorerView extends ViewPart
{
  private static final Container CONTAINER = ContainerManager.INSTANCE.getContainer();

  private static final String[] TAB_LABELS = { "Adapters", "Factories", "Acceptors", "Connectors" };

  private static final boolean[] WITH_TREE = { false, true, false, true };

  private static final int TABS = TAB_LABELS.length;

  private static final ItemProvider[] ITEM_PROVIDERS = { new AdaptersItemProvider(), new FactoriesItemProvider(),
      new AcceptorsItemProvider(), new ConnectorsItemProvider() };

  private TabFolder tabFolder;

  private Control[] tabControls = new Control[TABS];

  private StructuredViewer[] viewers = new StructuredViewer[TABS];

  // private DrillDownAdapter drillDownAdapter;

  private Action addAcceptorAction;

  // private Action action2;

  private Action doubleClickAction;

  public Net4jExplorerView()
  {
  }

  public void createPartControl(Composite parent)
  {
    tabFolder = new TabFolder(parent, SWT.NULL);
    for (int i = 0; i < TAB_LABELS.length; i++)
    {
      tabControls[0] = createTabControl(tabFolder, i, TAB_LABELS[i]);
    }

    makeActions();
    hookContextMenu();
    hookDoubleClickAction();
    contributeToActionBars();
  }

  private Control createTabControl(TabFolder parent, int index, String label)
  {
    viewers[index] = createViewer(parent, index);
    Control control = viewers[index].getControl();
    control.setLayoutData(new GridData(GridData.FILL_BOTH));

    final TabItem factoryTab = new TabItem(tabFolder, SWT.NULL);
    factoryTab.setText(label);
    factoryTab.setControl(control);
    return control;
  }

  private StructuredViewer createViewer(Composite parent, int index)
  {
    int style = SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL;
    StructuredViewer viewer = WITH_TREE[index] ? new TreeViewer(parent, style) : new TableViewer(parent, style);

    // drillDownAdapter = new DrillDownAdapter(viewer);
    viewer.setContentProvider(ITEM_PROVIDERS[index]);
    viewer.setLabelProvider(ITEM_PROVIDERS[index]);
    viewer.setSorter(new Net4jExplorerNameSorter());
    viewer.setInput(CONTAINER);
    return viewer;
  }

  private void hookContextMenu()
  {
    MenuManager menuMgr = new MenuManager("#PopupMenu");
    menuMgr.setRemoveAllWhenShown(true);
    menuMgr.addMenuListener(new IMenuListener()
    {
      public void menuAboutToShow(IMenuManager manager)
      {
        Net4jExplorerView.this.fillContextMenu(manager);
      }
    });
    Menu menu = menuMgr.createContextMenu(getCurrentViewer().getControl());
    getCurrentViewer().getControl().setMenu(menu);
    getSite().registerContextMenu(menuMgr, getCurrentViewer());
  }

  private StructuredViewer getCurrentViewer()
  {
    int index = tabFolder.getSelectionIndex();
    return viewers[index];
  }

  private void contributeToActionBars()
  {
    IActionBars bars = getViewSite().getActionBars();
    fillLocalPullDown(bars.getMenuManager());
    fillLocalToolBar(bars.getToolBarManager());
  }

  private void fillLocalPullDown(IMenuManager manager)
  {
    manager.add(addAcceptorAction);
    // manager.add(new Separator());
    // manager.add(action2);
  }

  private void fillContextMenu(IMenuManager manager)
  {
    manager.add(addAcceptorAction);
    // manager.add(action2);
    // manager.add(new Separator());
    // drillDownAdapter.addNavigationActions(manager);

    // Other plug-ins can contribute there actions here
    manager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
  }

  private void fillLocalToolBar(IToolBarManager manager)
  {
    manager.add(addAcceptorAction);
    // manager.add(action2);
    // manager.add(new Separator());
    // drillDownAdapter.addNavigationActions(manager);
  }

  private void makeActions()
  {
    addAcceptorAction = new Action()
    {
      public void run()
      {
        InputDialog dialog = new InputDialog(getCurrentViewer().getControl().getShell(), "Net4j Explorer",
            "Enter an acceptor description:", null, null);
        if (dialog.open() == InputDialog.OK)
        {
          String description = dialog.getValue();
          Acceptor acceptor = CONTAINER.getAcceptor(description);
          if (acceptor == null)
          {
            showMessage("Error while creating acceptor for description" + description);
          }
        }
      }
    };
    addAcceptorAction.setText("Add Acceptor");
    addAcceptorAction.setToolTipText("Add an acceptor");
    addAcceptorAction.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(
        ISharedImages.IMG_TOOL_NEW_WIZARD));

    // action2 = new Action()
    // {
    // public void run()
    // {
    // showMessage("Action 2 executed");
    // }
    // };
    // action2.setText("Action 2");
    // action2.setToolTipText("Action 2 tooltip");
    // action2.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(
    // ISharedImages.IMG_OBJS_INFO_TSK));

    doubleClickAction = new Action()
    {
      public void run()
      {
        ISelection selection = getCurrentViewer().getSelection();
        Object obj = ((IStructuredSelection)selection).getFirstElement();
        showMessage("Double-click detected on " + obj.toString());
      }
    };
  }

  private void hookDoubleClickAction()
  {
    getCurrentViewer().addDoubleClickListener(new IDoubleClickListener()
    {
      public void doubleClick(DoubleClickEvent event)
      {
        doubleClickAction.run();
      }
    });
  }

  private void showMessage(String message)
  {
    MessageDialog.openInformation(getCurrentViewer().getControl().getShell(), "Net4j Explorer", message);
  }

  public void setFocus()
  {
    getCurrentViewer().getControl().setFocus();
  }
}