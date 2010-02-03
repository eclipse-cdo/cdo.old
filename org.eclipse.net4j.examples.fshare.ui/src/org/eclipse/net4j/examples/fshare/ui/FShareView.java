/**
 * Copyright (c) 2004 - 2010 Eike Stepper (Berlin, Germany) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Eike Stepper - initial API and implementation
 *
 *  Initial Publication:
 *    Eclipse Magazin - http://www.eclipse-magazin.de
 */
package org.eclipse.net4j.examples.fshare.ui;

import org.eclipse.net4j.examples.fshare.ui.app.Application;
import org.eclipse.net4j.examples.internal.fshare.Client;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.FileTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

/**
 * @author Eike Stepper
 */
public class FShareView extends ViewPart
{
  public static final String ID = "org.eclipse.net4j.examples.fshare.ui.view";

  private Client client;

  private TreeViewer viewer;

  public FShareView()
  {
  }

  @Override
  public void createPartControl(Composite parent)
  {
    client = new Client(Application.getTargetURL());

    int ops = DND.DROP_COPY | DND.DROP_MOVE;
    Transfer[] transfers = new Transfer[] { FileTransfer.getInstance() };

    viewer = new TreeViewer(parent, SWT.H_SCROLL | SWT.V_SCROLL);
    viewer.addDragSupport(ops, transfers, new FShareDragHandler(client, viewer));
    viewer.addDropSupport(ops, transfers, new FShareDropHandler(client, viewer));
    viewer.setContentProvider(new FShareContentProvider());
    viewer.setLabelProvider(new FShareLabelProvider());
    viewer.setComparator(new FShareComparator());
    viewer.setInput(client.getRootFolder());

    getSite().setSelectionProvider(viewer);
  }

  @Override
  public void setFocus()
  {
    viewer.getControl().setFocus();
  }
}
