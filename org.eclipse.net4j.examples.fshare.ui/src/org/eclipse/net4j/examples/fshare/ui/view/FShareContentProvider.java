/**
 * Copyright (c) 2004 - 2009 Eike Stepper (Berlin, Germany) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Eike Stepper - initial API and implementation
 */
package org.eclipse.net4j.examples.fshare.ui.view;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;

public final class FShareContentProvider implements ITreeContentProvider
{
  private TreeViewer viewer;

  public Object getParent(Object element)
  {
    return null;
  }

  public Object[] getElements(Object inputElement)
  {
    return getChildren(inputElement);
  }

  public Object[] getChildren(Object parentElement)
  {
    return new Object[0];
  }

  public boolean hasChildren(Object element)
  {
    return getChildren(element).length != 0;
  }

  public void inputChanged(Viewer viewer, Object oldInput, Object newInput)
  {
    this.viewer = (TreeViewer)viewer;
  }

  public void dispose()
  {
  }
}
