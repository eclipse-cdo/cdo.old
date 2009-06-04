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
import org.eclipse.jface.viewers.Viewer;

public final class FShareContentProvider implements ITreeContentProvider
{
  public void inputChanged(Viewer viewer, Object oldInput, Object newInput)
  {
  }

  public void dispose()
  {
  }

  public Object[] getElements(Object inputElement)
  {
    return null;
  }

  public boolean hasChildren(Object element)
  {
    return false;
  }

  public Object getParent(Object element)
  {
    return null;
  }

  public Object[] getChildren(Object parentElement)
  {
    return null;
  }
}