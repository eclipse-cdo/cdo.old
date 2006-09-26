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
package org.eclipse.emf.cdo.examples.ui;


import org.eclipse.emf.cdo.client.ClassInfo;
import org.eclipse.emf.cdo.client.PackageInfo;
import org.eclipse.emf.cdo.client.PackageManager;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

import java.util.List;


public final class PackageContentProvider implements ITreeContentProvider
{
  public PackageContentProvider()
  {
  }

  public Object[] getChildren(Object parentElement)
  {
    if (parentElement instanceof PackageManager)
    {
      PackageManager packageManager = (PackageManager)parentElement;
      List<PackageInfo> packages = packageManager.getPackages();
      return packages.toArray();
    }

    if (parentElement instanceof PackageInfo)
    {
      PackageInfo packageInfo = (PackageInfo)parentElement;
      return packageInfo.getClasses();
    }

    return new Object[0];
  }

  public Object getParent(Object element)
  {
    if (element instanceof PackageInfo)
    {
      PackageInfo packageInfo = (PackageInfo)element;
      return packageInfo.getPackageManager();
    }

    if (element instanceof ClassInfo)
    {
      ClassInfo classInfo = (ClassInfo)element;
      return classInfo.getPackageInfo();
    }

    return null;
  }

  public boolean hasChildren(Object element)
  {
    return getChildren(element).length > 0;
  }

  public Object[] getElements(Object inputElement)
  {
    return getChildren(inputElement);
  }

  public void dispose()
  {
  }

  public void inputChanged(Viewer viewer, Object oldInput, Object newInput)
  {
  }
}