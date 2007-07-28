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

import org.eclipse.emf.cdo.util.EMFUtil;
import org.eclipse.emf.cdo.weaver.internal.ui.bundle.OM;

import org.eclipse.net4j.ui.widgets.PreferenceButton;
import org.eclipse.net4j.util.StringUtil;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.ITreeSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

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
public class ConfirmWeaveDialog extends TitleAreaDialog
{
  private static final String TITLE = "CDO Package Weaver";

  private static final Object[] NO_CHILDREN = {};

  private Map<String, SortedSet<PackageInfo>> bundleMap;

  private Set<String> skippedBundles = new HashSet();

  private Set<String> ignoredBundles = new HashSet();

  private TreeViewer viewer;

  public ConfirmWeaveDialog(Map<String, SortedSet<PackageInfo>> bundleMap)
  {
    super(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell());
    setShellStyle(getShellStyle() | SWT.APPLICATION_MODAL | SWT.MAX | SWT.TITLE | SWT.RESIZE);

    this.bundleMap = bundleMap;
    ignoredBundles = OM.getIgnoredBundles();
    skippedBundles.addAll(bundleMap.keySet());
    skippedBundles.removeAll(ignoredBundles);
  }

  @Override
  protected void configureShell(Shell newShell)
  {
    super.configureShell(newShell);
    newShell.setText(TITLE);
  }

  @Override
  protected Control createDialogArea(Composite parent)
  {
    Composite composite = (Composite)super.createDialogArea(parent);
    setTitle("The following EMF models have been detected that\n" //
        + "are not fully CDO persistence capable. Select the\n" // 
        + "model elements to be automatically converted."); //

    viewer = new TreeViewer(composite, SWT.MULTI);
    viewer.getTree().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
    viewer.setContentProvider(new WeaveContentProvider());
    viewer.setLabelProvider(new WeaveLabelProvider());
    viewer.setInput(bundleMap);

    hookContextMenu();
    return composite;
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
        viewer.refresh(true);
      }
    });

    PreferenceButton startup = new PreferenceButton(parent, SWT.CHECK, OM.PREF_CHECK_DURING_STARTUP);
    startup.setText("Check during startup");
  }

  @Override
  protected void okPressed()
  {
    OM.setIgnoredBundles(ignoredBundles);
    super.okPressed();
  }

  protected void hookContextMenu()
  {
    MenuManager menuMgr = new MenuManager("#PopupMenu");
    menuMgr.setRemoveAllWhenShown(true);
    menuMgr.addMenuListener(new IMenuListener()
    {
      public void menuAboutToShow(IMenuManager manager)
      {
        ITreeSelection selection = (ITreeSelection)viewer.getSelection();
        fillContextMenu(manager, selection);
      }
    });

    Menu menu = menuMgr.createContextMenu(viewer.getControl());
    viewer.getControl().setMenu(menu);
  }

  protected void fillContextMenu(IMenuManager manager, ITreeSelection selection)
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
          viewer.refresh(true);
        }
      });

      manager.add(new Action("Skip this time", SharedIcons.getDescriptor(SharedIcons.ETOOL_SKIP))
      {
        @Override
        public void run()
        {
          skippedBundles.addAll(symbolicNames);
          ignoredBundles.removeAll(symbolicNames);
          viewer.refresh(true);
        }
      });

      manager.add(new Action("Ignore forever")
      {
        @Override
        public void run()
        {
          skippedBundles.removeAll(symbolicNames);
          ignoredBundles.addAll(symbolicNames);
          viewer.refresh(true);
        }
      });
    }
  }

  protected List<String> getSelectedBundles()
  {
    List<String> symbolicNames = new ArrayList();
    IStructuredSelection selection = (IStructuredSelection)viewer.getSelection();
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
  private class WeaveLabelProvider extends LabelProvider
  {
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
  }
}
