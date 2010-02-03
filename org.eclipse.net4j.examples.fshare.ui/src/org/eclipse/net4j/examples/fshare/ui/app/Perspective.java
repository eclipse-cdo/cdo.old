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
package org.eclipse.net4j.examples.fshare.ui.app;

import org.eclipse.net4j.examples.fshare.ui.FShareView;
import org.eclipse.net4j.util.concurrent.ConcurrencyUtil;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

/**
 * @author Eike Stepper
 */
public class Perspective implements IPerspectiveFactory
{
  public void createInitialLayout(IPageLayout layout)
  {
    String editorArea = layout.getEditorArea();
    layout.setEditorAreaVisible(false);
    layout.setFixed(false);

    layout.addStandaloneView(FShareView.ID, false, IPageLayout.BOTTOM, 0.3f, editorArea);
    layout.addStandaloneView(IPageLayout.ID_PROGRESS_VIEW, true, IPageLayout.BOTTOM, 0.7f, FShareView.ID);
    // layout.addStandaloneView("org.eclipse.net4j.util.Net4jIntrospectorView", true, IPageLayout.BOTTOM, 0.7f,
    // IPageLayout.ID_PROGRESS_VIEW);

    // Fake job to work around bug that causes first job be shown only if at least two jobs are running
    new Job("Initializing")
    {
      @Override
      protected IStatus run(IProgressMonitor monitor)
      {
        monitor.beginTask(getName(), 100);
        for (int i = 0; i < 100; i++)
        {
          ConcurrencyUtil.sleep(30);
          monitor.worked(1);
        }

        monitor.done();
        return Status.OK_STATUS;
      }
    }.schedule();
  }
}
