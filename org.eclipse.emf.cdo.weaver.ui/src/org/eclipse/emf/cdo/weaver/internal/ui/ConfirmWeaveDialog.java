/***************************************************************************
 * Copyright (c) 2004 - 2007 Eike Stepper, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 **************************************************************************/
package org.eclipse.emf.cdo.weaver.internal.ui;

import org.eclipse.emf.cdo.internal.weaver.CDOWeaver;
import org.eclipse.emf.cdo.util.EMFUtil;
import org.eclipse.emf.cdo.weaver.ICDOWeaver;
import org.eclipse.emf.cdo.weaver.internal.ui.bundle.OM;

import org.eclipse.net4j.ui.widgets.BaseDialog;
import org.eclipse.net4j.ui.widgets.MonitorDialog;
import org.eclipse.net4j.ui.widgets.PreferenceButton;
import org.eclipse.net4j.util.StringUtil;
import org.eclipse.net4j.util.om.monitor.MonitorUtil;
import org.eclipse.net4j.util.om.monitor.MonitoredJob;
import org.eclipse.net4j.util.om.monitor.OMMonitor;
import org.eclipse.net4j.util.om.monitor.OMSubMonitor;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableColorProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.ui.PlatformUI;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;

/**
 * @author Eike Stepper
 */
public class ConfirmWeaveDialog extends BaseDialog<TreeViewer>
{
  private static final String TITLE = "CDO Package Weaver";

  private static final String MESSAGE = "Some EMF models have been detected that are not fully CDO persistence capable.\n"
      + "Select the bundles you wish to be converted with the context menu.";

  private static final Object[] NO_CHILDREN = {};

  private Map<String, SortedSet<PackageInfo>> bundleMap;

  private Set<String> skippedBundles = new HashSet();

  private Set<String> ignoredBundles = new HashSet();

  public ConfirmWeaveDialog(Map<String, SortedSet<PackageInfo>> bundleMap)
  {
    super(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), DEFAULT_SHELL_STYLE | SWT.APPLICATION_MODAL,
        TITLE, MESSAGE, OM.Activator.INSTANCE.getDialogSettings());

    this.bundleMap = bundleMap;
    ignoredBundles = OM.getIgnoredBundles();
    skippedBundles.addAll(bundleMap.keySet());
    skippedBundles.removeAll(ignoredBundles);
  }

  @Override
  protected void createUI(Composite parent)
  {
    Tree tree = new Tree(parent, SWT.MULTI);
    tree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
    tree.setHeaderVisible(true);
    tree.setLinesVisible(true);
    tree.setLinesVisible(true);
    addColumn(tree, "Bundle", 300, SWT.LEFT);
    addColumn(tree, "Location", 300, SWT.LEFT);

    TreeViewer viewer = new TreeViewer(tree);
    viewer.setContentProvider(new WeaveContentProvider());
    viewer.setLabelProvider(new WeaveLabelProvider());
    viewer.setInput(bundleMap);

    setCurrentViewer(viewer);
  }

  private void addColumn(Tree tree, String title, int width, int alignment)
  {
    TreeColumn column = new TreeColumn(tree, alignment);
    column.setText(title);
    column.setWidth(width);
  }

  @Override
  protected void createButtonsForButtonBar(Composite parent)
  {
    super.createButtonsForButtonBar(parent);
    final PreferenceButton showIgnored = new PreferenceButton(parent, SWT.CHECK, OM.PREF_SHOW_IGNORED_BUNDLES);
    showIgnored.setText("Show ignored bundles");
    showIgnored.addSelectionListener(new SelectionAdapter()
    {
      @Override
      public void widgetSelected(SelectionEvent e)
      {
        OM.PREF_SHOW_IGNORED_BUNDLES.setValue(showIgnored.getSelection());
        getCurrentViewer().refresh(true);
      }
    });

    PreferenceButton startup = new PreferenceButton(parent, SWT.CHECK, OM.PREF_CHECK_DURING_STARTUP);
    startup.setText("Check during startup");
  }

  @Override
  protected void okPressed()
  {
    OM.setIgnoredBundles(ignoredBundles);

    final Set<String> symbolicNames = new HashSet(bundleMap.keySet());
    symbolicNames.removeAll(skippedBundles);
    symbolicNames.removeAll(ignoredBundles);
    if (!symbolicNames.isEmpty())
    {
      MonitorDialog dialog = new MonitorDialog(getShell(), getShellStyle(), "Converting Bundles", OM.Activator.INSTANCE
          .getDialogSettings());
      dialog.run(true, true, new Runnable()
      {
        public void run()
        {
          weave(symbolicNames);
        }
      });

      // IProgressService progressService =
      // PlatformUI.getWorkbench().getProgressService();
      // progressService.showInDialog(null, new WeaveJob(symbolicNames));

      // Job job = new WeaveJob(symbolicNames);
      // job.schedule();
    }

    super.okPressed();
  }

  @Override
  protected void fillContextMenu(IMenuManager manager, TreeViewer viewer)
  {
    final List<String> symbolicNames = getSelectedBundles();
    if (!symbolicNames.isEmpty())
    {
      manager.add(new Action("Convert", SharedIcons.getDescriptor(SharedIcons.ETOOL_CONVERT))
      {
        @Override
        public void run()
        {
          skippedBundles.removeAll(symbolicNames);
          ignoredBundles.removeAll(symbolicNames);
          getCurrentViewer().refresh(true);
        }
      });

      manager.add(new Action("Skip this time")
      {
        @Override
        public void run()
        {
          skippedBundles.addAll(symbolicNames);
          ignoredBundles.removeAll(symbolicNames);
          getCurrentViewer().refresh(true);
        }
      });

      manager.add(new Action("Ignore forever")
      {
        @Override
        public void run()
        {
          skippedBundles.removeAll(symbolicNames);
          ignoredBundles.addAll(symbolicNames);
          getCurrentViewer().refresh(true);
        }
      });

      manager.add(new Separator());

      manager.add(new Action("Browse archives...", SharedIcons.getDescriptor(SharedIcons.ETOOL_BROWSE_ARCHIVES))
      {
        @Override
        public void run()
        {
        }
      });

      manager.add(new Action("Browse folders...", SharedIcons.getDescriptor(SharedIcons.ETOOL_BROWSE_FOLDERS))
      {
        @Override
        public void run()
        {
        }
      });
    }
  }

  public static void weave(Set<String> symbolicNames)
  {
    List<File> list = new ArrayList();
    OMMonitor monitor = MonitorUtil.begin(2 * symbolicNames.size(), "Converting bundles");
    for (String symbolicName : symbolicNames)
    {
      URL bundleURL = CDOWeaver.getBundleURL(symbolicName);
      list.add(new File(bundleURL.getFile()));
      monitor.worked("Located bundle " + symbolicName);
    }

    OMSubMonitor subMonitor = monitor.fork(symbolicNames.size());
    try
    {
      File[] locations = list.toArray(new File[list.size()]);
      File[] newLocations = ICDOWeaver.INSTANCE.weave(locations);
      for (int i = 0; i < locations.length; i++)
      {
        System.out.println(locations[i] + " --> " + newLocations[i]);
      }
    }
    finally
    {
      subMonitor.join("Converted all bundles");
    }
  }

  private List<String> getSelectedBundles()
  {
    List<String> symbolicNames = new ArrayList();
    IStructuredSelection selection = (IStructuredSelection)getCurrentViewer().getSelection();
    for (Iterator it = selection.iterator(); it.hasNext();)
    {
      Object element = it.next();
      if (element instanceof String)
      {
        symbolicNames.add((String)element);
      }
    }

    return symbolicNames;
  }

  /**
   * @author Eike Stepper
   */
  private static final class WeaveJob extends MonitoredJob
  {
    private Set<String> symbolicNames;

    private WeaveJob(Set<String> symbolicNames)
    {
      super(OM.BUNDLE_ID, "Converting bundles");
      this.symbolicNames = symbolicNames;
    }

    @Override
    protected void run() throws Exception
    {
      weave(symbolicNames);
    }
  }

  /**
   * @author Eike Stepper
   */
  private class WeaveContentProvider implements ITreeContentProvider
  {
    public WeaveContentProvider()
    {
    }

    public void dispose()
    {
    }

    public void inputChanged(Viewer viewer, Object oldInput, Object newInput)
    {
      bundleMap = (Map<String, SortedSet<PackageInfo>>)newInput;
    }

    public Object[] getElements(Object inputElement)
    {
      return getChildren(inputElement);
    }

    public Object[] getChildren(Object parentElement)
    {
      if (parentElement == bundleMap)
      {
        List<String> list = new ArrayList();
        for (String symbolicName : bundleMap.keySet())
        {
          if (OM.PREF_SHOW_IGNORED_BUNDLES.getValue() || !ignoredBundles.contains(symbolicName))
          {
            list.add(symbolicName);
          }
        }

        Collections.sort(list);
        return list.toArray();
      }

      if (parentElement instanceof String)
      {
        String symbolicName = (String)parentElement;
        SortedSet<PackageInfo> packageInfos = bundleMap.get(symbolicName);
        return packageInfos.toArray();
      }

      if (parentElement instanceof PackageInfo)
      {
        PackageInfo packageInfo = (PackageInfo)parentElement;
        EPackage ePackage = EPackage.Registry.INSTANCE.getEPackage(packageInfo.getPackageURI());
        List<EClass> eClasses = EMFUtil.getPersistentClasses(ePackage);
        Collections.sort(eClasses, new Comparator()
        {
          public int compare(Object o1, Object o2)
          {
            return StringUtil.compare(((EClass)o1).getName(), ((EClass)o2).getName());
          }
        });

        return eClasses.toArray();
      }

      return NO_CHILDREN;
    }

    public Object getParent(Object element)
    {
      if (element instanceof EClass)
      {
        EClass eClass = (EClass)element;
        String uri = eClass.getEPackage().getNsURI();
        for (SortedSet<PackageInfo> packageInfos : bundleMap.values())
        {
          for (PackageInfo packageInfo : packageInfos)
          {
            if (uri.equals(packageInfo.getPackageURI()))
            {
              return packageInfo;
            }
          }
        }
      }

      if (element instanceof PackageInfo)
      {
        PackageInfo packageInfo = (PackageInfo)element;
        return packageInfo.getBundleSymbolicName();
      }

      return null;
    }

    public boolean hasChildren(Object element)
    {
      return getChildren(element).length != 0;
    }
  }

  /**
   * @author Eike Stepper
   */
  private class WeaveLabelProvider extends LabelProvider implements ITableLabelProvider, ITableColorProvider
  {
    private final Color gray = Display.getCurrent().getSystemColor(SWT.COLOR_GRAY);

    public WeaveLabelProvider()
    {
    }

    @Override
    public String getText(Object element)
    {
      if (element instanceof PackageInfo)
      {
        PackageInfo packageInfo = (PackageInfo)element;
        return packageInfo.getPackageURI();
      }

      if (element instanceof EClass)
      {
        EClass eClass = (EClass)element;
        return eClass.getName();
      }

      return element.toString();
    }

    @Override
    public Image getImage(Object element)
    {
      if (element instanceof PackageInfo)
      {
        return SharedIcons.getImage(SharedIcons.OBJ_PACKAGE);
      }

      if (element instanceof EClass)
      {
        return SharedIcons.getImage(SharedIcons.OBJ_CLASS);
      }

      if (element instanceof String)
      {
        if (skippedBundles.contains(element))
        {
          return SharedIcons.getImage(SharedIcons.OBJ_PLUGIN_SKIP);
        }

        if (ignoredBundles.contains(element))
        {
          return SharedIcons.getImage(SharedIcons.OBJ_PLUGIN_IGNORE);
        }

        return SharedIcons.getImage(SharedIcons.OBJ_PLUGIN_CONVERT);
      }

      return null;
    }

    public String getColumnText(Object element, int columnIndex)
    {
      if (columnIndex == 0)
      {
        return getText(element);
      }

      if (element instanceof String)
      {
        return (String)element;
      }

      return null;
    }

    public Image getColumnImage(Object element, int columnIndex)
    {
      if (columnIndex == 0)
      {
        return getImage(element);
      }

      if (element instanceof String)
      {
        String symbolicName = (String)element;
        if (symbolicName.toLowerCase().endsWith(".jar"))
        {
          return SharedIcons.getImage(SharedIcons.OBJ_ARCHIVE);
        }
        else
        {
          return SharedIcons.getImage(SharedIcons.OBJ_FOLDER);
        }
      }

      return null;
    }

    public Color getBackground(Object element, int columnIndex)
    {
      return null;
    }

    public Color getForeground(Object element, int columnIndex)
    {
      if (ignoredBundles.contains(element))
      {
        return gray;
      }

      return null;
    }
  }
}
