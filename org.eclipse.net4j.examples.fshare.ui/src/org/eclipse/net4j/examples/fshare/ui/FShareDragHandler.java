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

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.TreeDragSourceEffect;

public class FShareDragHandler extends TreeDragSourceEffect
{
  private IClient client;

  private TreeViewer viewer;

  public FShareDragHandler(IClient client, TreeViewer viewer)
  {
    super(viewer.getTree());
    this.viewer = viewer;
    this.client = client;
  }

  public IClient getClient()
  {
    return client;
  }

  public TreeViewer getViewer()
  {
    return viewer;
  }

  @Override
  public void dragStart(DragSourceEvent event)
  {
    super.dragStart(event);
    System.out.println("dragStart");
  }

  @Override
  public void dragSetData(DragSourceEvent event)
  {
    super.dragSetData(event);
    System.out.println("dragSetData");
  }

  @Override
  public void dragFinished(DragSourceEvent event)
  {
    super.dragFinished(event);
    System.out.println("dragFinished");
  }
}
