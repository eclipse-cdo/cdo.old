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

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.ViewerDropAdapter;
import org.eclipse.swt.dnd.TransferData;

public class FShareDropHandler extends ViewerDropAdapter
{
  public FShareDropHandler(TreeViewer viewer)
  {
    super(viewer);
  }

  @Override
  public boolean validateDrop(Object target, int operation, TransferData transferType)
  {
    return false;
  }

  @Override
  public boolean performDrop(Object data)
  {
    return false;
  }
}
