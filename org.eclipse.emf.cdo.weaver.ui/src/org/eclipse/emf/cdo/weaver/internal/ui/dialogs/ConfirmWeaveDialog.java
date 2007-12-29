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
package org.eclipse.emf.cdo.weaver.internal.ui.dialogs;

import org.eclipse.emf.cdo.util.EMFUtil;
import org.eclipse.emf.cdo.weaver.BundleInfo;
import org.eclipse.emf.cdo.weaver.ICDOWeaver;
import org.eclipse.emf.cdo.weaver.internal.ui.SharedIcons;
import org.eclipse.emf.cdo.weaver.internal.ui.bundle.OM;

import org.eclipse.net4j.util.StringUtil;
import org.eclipse.net4j.util.ui.UIUtil;
import org.eclipse.net4j.util.ui.widgets.BaseDialog;
import org.eclipse.net4j.util.ui.widgets.MonitorDialog;
import org.eclipse.net4j.util.ui.widgets.PreferenceButton;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;

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
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.ui.PlatformUI;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Eike Stepper
 */
public class ConfirmWeaveDialog extends BaseDialog<TreeViewer>
{
  private static final String TITLE = "CDO Package Converter";

  private static final String MESSAGE = "Some EMF models have been detected that are not fully CDO persistence capable.\n"
      + "Select the bundles you wish to be converted with the context menu.";

  private static final Object[] NO_ELEMENTS = {};

  private Map<String, BundleInfo> bundleMap;

  private Set<String> skippedBundles = new HashSet<String>();

  private Set<String> ignoredBundles = new HashSet<String>();

  public ConfirmWeaveDialog(Map<String, BundleInfo> bundleMap)
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
    tree.setLayoutData(UIUtil.createGridData());
    tree.setHeaderVisible(true);
    tree.setLinesVisible(true);
    addColumn(tree, "Bundle", 300, SWT.LEFT);
    addColumn(tree, "Location", 600, SWT.LEFT);

    TreeViewer viewer = new TreeViewer(tree);
    viewer.setContentProvider(new WeaveContentProvider());
    viewer.setLabelProvider(new WeaveLabelProvider());
    viewer.setInput(bundleMap);

    setCurrentViewer(viewer);
  }

  @Override
  protected void createButtonsForButtonBar(Composite parent)
  {
    super.createButtonsForButtonBar(parent);
    final PreferenceButton showIgnored = new PreferenceButton(parent, SWT.CHECK, "Show ignored bundles",
        OM.PREF_SHOW_IGNORED_BUNDLES);
    showIgnored.getButton().addSelectionListener(new SelectionAdapter()
    {
      @Override
      public void widgetSelected(SelectionEvent e)
      {
        OM.PREF_SHOW_IGNORED_BUNDLES.setValue(showIgnored.getSelection());
        getCurrentViewer().refresh(true);
      }
    });

    new PreferenceButton(parent, SWT.CHECK, "Check during startup", OM.PREF_CHECK_DURING_STARTUP);
  }

  @Override
  protected void okPressed()
  {
    OM.setIgnoredBundles(ignoredBundles);

    final List<BundleInfo> bundleInfos = new ArrayList<BundleInfo>();
    for (BundleInfo bundleInfo : bundleMap.values())
    {
      String name = bundleInfo.getName();
      if (!skippedBundles.contains(name) && !ignoredBundles.contains(name))
      {
        bundleInfos.add(bundleInfo);
      }
    }

    super.okPressed();

    if (!bundleInfos.isEmpty())
    {
      MonitorDialog dialog = new MonitorDialog(getShell(), getShellStyle(), "Converting Bundles", OM.Activator.INSTANCE
          .getDialogSettings());
      dialog.run(true, true, new Runnable()
      {
        public void run()
        {
          ICDOWeaver.INSTANCE.weave(bundleInfos);
        }
      });
    }
  }

  @Override
  protected void fillContextMenu(IMenuManager manager, TreeViewer viewer)
  {
    final List<String> selectedBundles = getSelectedBundles();
    if (!selectedBundles.isEmpty())
    {
      manager.add(new Action("Convert", SharedIcons.getDescriptor(SharedIcons.ETOOL_CONVERT))
      {
        @Override
        public void run()
        {
          skippedBundles.removeAll(selectedBundles);
          ignoredBundles.removeAll(selectedBundles);
          getCurrentViewer().refresh(true);
        }
      });

      manager.add(new Action("Skip this time")
      {
        @Override
        public void run()
        {
          skippedBundles.addAll(selectedBundles);
          ignoredBundles.removeAll(selectedBundles);
          getCurrentViewer().refresh(true);
        }
      });

      manager.add(new Action("Ignore forever")
      {
        @Override
        public void run()
        {
          skippedBundles.removeAll(selectedBundles);
          ignoredBundles.addAll(selectedBundles);
          getCurrentViewer().refresh(true);
        }
      });

      if (selectedBundles.size() == 1)
      {
        String symbolicName = selectedBundles.get(0);
        final BundleInfo bundleInfo = bundleMap.get(symbolicName);
        manager.add(new Separator());

        manager.add(new Action("Browse archives...", SharedIcons.getDescriptor(SharedIcons.ETOOL_BROWSE_ARCHIVES))
        {
          @Override
          public void run()
          {
            FileDialog dialog = new FileDialog(getShell(), getShellStyle());
            dialog.setFileName(bundleInfo.getName() + "_" + bundleInfo.getVersion() + ICDOWeaver.JAR_SUFFIX);
            String path = dialog.open();
            if (path != null)
            {
              bundleInfo.setLocation(new File(path));
              getCurrentViewer().refresh(true);
            }
          }
        });

        manager.add(new Action("Browse folders...", SharedIcons.getDescriptor(SharedIcons.ETOOL_BROWSE_FOLDERS))
        {
          @Override
          public void run()
          {
            DirectoryDialog dialog = new DirectoryDialog(getShell(), getShellStyle());
            dialog.setFilterPath(bundleInfo.getName() + "_" + bundleInfo.getVersion());
            String path = dialog.open();
            if (path != null)
            {
              bundleInfo.setLocation(new File(path));
              getCurrentViewer().refresh(true);
            }
          }
        });
      }
    }
  }

  private void addColumn(Tree tree, String title, int width, int alignment)
  {
    TreeColumn column = new TreeColumn(tree, alignment);
    column.setText(title);
    column.setWidth(width);
  }

  private List<String> getSelectedBundles()
  {
    List<String> selectedBundles = new ArrayList<String>();
    IStructuredSelection selection = (IStructuredSelection)getCurrentViewer().getSelection();
    for (Iterator<?> it = selection.iterator(); it.hasNext();)
    {
      Object element = it.next();
      if (element instanceof BundleInfo)
      {
        selectedBundles.add(((BundleInfo)element).getName());
      }
    }

    return selectedBundles;
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
    }

    public Object[] getElements(Object inputElement)
    {
      return getChildren(inputElement);
    }

    public Object[] getChildren(Object parentElement)
    {
      if (parentElement == bundleMap)
      {
        List<BundleInfo> list = new ArrayList<BundleInfo>();
        for (BundleInfo bundleInfo : bundleMap.values())
        {
          if (OM.PREF_SHOW_IGNORED_BUNDLES.getValue() || !ignoredBundles.contains(bundleInfo.getName()))
          {
            list.add(bundleInfo);
          }
        }

        Collections.sort(list);
        return list.toArray();
      }

      if (parentElement instanceof BundleInfo)
      {
        BundleInfo bundleInfo = (BundleInfo)parentElement;
        return bundleInfo.getPackageURIs().toArray();
      }

      if (parentElement instanceof String)
      {
        String packageURI = (String)parentElement;
        EPackage ePackage = EPackage.Registry.INSTANCE.getEPackage(packageURI);
        List<EClass> eClasses = EMFUtil.getPersistentClasses(ePackage);
        Collections.sort(eClasses, new Comparator<EClass>()
        {
          public int compare(EClass c1, EClass c2)
          {
            return StringUtil.compare(c1.getName(), c2.getName());
          }
        });

        return eClasses.toArray();
      }

      if (parentElement instanceof EClass)
      {
        EClass eClass = (EClass)parentElement;
        return eClass.getEStructuralFeatures().toArray();
      }

      return NO_ELEMENTS;
    }

    public Object getParent(Object element)
    {
      if (element instanceof EStructuralFeature)
      {
        EStructuralFeature eFeature = (EStructuralFeature)element;
        return eFeature.getEContainingClass();
      }

      if (element instanceof EClass)
      {
        EClass eClass = (EClass)element;
        return eClass.getEPackage().getNsURI();
      }

      if (element instanceof String)
      {
        String packageURI = (String)element;
        for (BundleInfo bundleInfo : bundleMap.values())
        {
          for (String uri : bundleInfo.getPackageURIs())
          {
            if (uri.equals(packageURI))
            {
              return bundleInfo;
            }
          }
        }
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
      if (element instanceof BundleInfo)
      {
        BundleInfo bundleInfo = (BundleInfo)element;
        return bundleInfo.getName();
      }

      if (element instanceof String)
      {
        String packageURI = (String)element;
        return packageURI;
      }

      if (element instanceof EClass)
      {
        EClass eClass = (EClass)element;
        return eClass.getName();
      }

      if (element instanceof EStructuralFeature)
      {
        EStructuralFeature eFeature = (EStructuralFeature)element;
        return eFeature.getName();
      }

      return element.toString();
    }

    @Override
    public Image getImage(Object element)
    {
      if (element instanceof EStructuralFeature)
      {
        return SharedIcons.getImage(SharedIcons.OBJ_FEATURE);
      }

      if (element instanceof EClass)
      {
        return SharedIcons.getImage(SharedIcons.OBJ_CLASS);
      }

      if (element instanceof String)
      {
        return SharedIcons.getImage(SharedIcons.OBJ_PACKAGE);
      }

      if (element instanceof BundleInfo)
      {
        BundleInfo bundleInfo = (BundleInfo)element;
        if (skippedBundles.contains(bundleInfo.getName()))
        {
          return SharedIcons.getImage(SharedIcons.OBJ_PLUGIN_SKIP);
        }

        if (ignoredBundles.contains(bundleInfo.getName()))
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

      if (element instanceof BundleInfo)
      {
        BundleInfo bundleInfo = (BundleInfo)element;
        File location = bundleInfo.getLocation();
        if (location != null)
        {
          return location.getAbsolutePath();
        }
      }

      return null;
    }

    public Image getColumnImage(Object element, int columnIndex)
    {
      if (columnIndex == 0)
      {
        return getImage(element);
      }

      if (element instanceof BundleInfo)
      {
        BundleInfo bundleInfo = (BundleInfo)element;
        if (bundleInfo.getLocation() == null)
        {
          return SharedIcons.getImage(SharedIcons.OBJ_ERROR);
        }

        if (bundleInfo.isArchive())
        {
          return SharedIcons.getImage(SharedIcons.OBJ_ARCHIVE);
        }

        return SharedIcons.getImage(SharedIcons.OBJ_FOLDER);
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
