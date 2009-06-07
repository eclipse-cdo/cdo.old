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

import org.eclipse.net4j.examples.fshare.IFile;
import org.eclipse.net4j.examples.fshare.IFileSystem;
import org.eclipse.net4j.examples.fshare.IFolder;
import org.eclipse.net4j.examples.fshare.IResource;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;

public final class FShareContentProvider implements ITreeContentProvider, IFileSystem.Listener
{
  private IFolder rootFolder;

  private TreeViewer viewer;

  public FShareContentProvider()
  {
  }

  public Object getParent(Object element)
  {
    if (element instanceof IResource)
    {
      IResource resource = (IResource)element;
      return resource.getParent();
    }

    return null;
  }

  public Object[] getElements(Object element)
  {
    return getChildren(element);
  }

  public Object[] getChildren(Object element)
  {
    if (element instanceof IFolder)
    {
      IFolder folder = (IFolder)element;
      return folder.getChildren();
    }

    return new Object[0];
  }

  public boolean hasChildren(Object element)
  {
    return getChildren(element).length != 0;
  }

  public void inputChanged(Viewer viewer, Object oldInput, Object newInput)
  {
    this.viewer = (TreeViewer)viewer;
    rootFolder = (IFolder)newInput;
    rootFolder.getFileSystem().addListener(this);
  }

  public void dispose()
  {
    rootFolder.getFileSystem().removeListener(this);
    rootFolder = null;
    viewer = null;
  }

  public void protocolClosed(IFileSystem fileSystem)
  {
    if (!viewer.getControl().isDisposed())
    {
      // TODO: implement FShareContentProvider.protocolClosed(fileSystem)
      throw new UnsupportedOperationException();
    }
  }

  public void resourceAdded(final IResource resource)
  {
    updateUI(new Runnable()
    {
      public void run()
      {
        refreshViewer(resource.getParent());
      }
    });
  }

  public void progressChanged(final IFile file)
  {
    updateUI(new Runnable()
    {
      public void run()
      {
        viewer.update(file, null);
      }
    });
  }

  public void folderUnlocked(final IFolder folder)
  {
    updateUI(new Runnable()
    {
      public void run()
      {
        refreshViewer(folder);
      }
    });
  }

  private void updateUI(Runnable runnable)
  {
    Control control = viewer.getControl();
    if (control.isDisposed())
    {
      return;
    }

    Display display = control.getDisplay();
    if (display.getThread() == Thread.currentThread())
    {
      runnable.run();
    }
    else
    {
      display.asyncExec(runnable);
    }
  }

  private void refreshViewer(IFolder folder)
  {
    if (folder == rootFolder)
    {
      viewer.refresh();
    }
    else
    {
      viewer.refresh(folder);
    }
  }
}
