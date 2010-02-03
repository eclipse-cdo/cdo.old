/**
 * Copyright (c) 2004 - 2010 Eike Stepper (Berlin, Germany) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Eike Stepper - initial API and implementation
 */
package org.eclipse.net4j.examples.fshare.ui;

import org.eclipse.net4j.examples.fshare.IClient;
import org.eclipse.net4j.examples.fshare.IFolder;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.ViewerDropAdapter;
import org.eclipse.swt.dnd.FileTransfer;
import org.eclipse.swt.dnd.TransferData;

public class FShareDropHandler extends ViewerDropAdapter
{
  private IClient client;

  public FShareDropHandler(IClient client, TreeViewer viewer)
  {
    super(viewer);
    this.client = client;
  }

  @Override
  public boolean validateDrop(Object target, int operation, TransferData transferType)
  {
    if (!FileTransfer.getInstance().isSupportedType(transferType))
    {
      return false;
    }

    IFolder folder = getFolder(target);
    return folder != null && folder.getUploadedPercent() == 100;
  }

  @Override
  public boolean performDrop(Object data)
  {
    IFolder folder = getFolder(getCurrentTarget());
    if (folder == null)
    {
      return false;
    }

    folder.performDrop((String[])data);
    return true;
  }

  private IFolder getFolder(Object target)
  {
    if (target == null)
    {
      return client.getRootFolder();
    }

    if (target instanceof IFolder)
    {
      return (IFolder)target;
    }

    return null;
  }
}
