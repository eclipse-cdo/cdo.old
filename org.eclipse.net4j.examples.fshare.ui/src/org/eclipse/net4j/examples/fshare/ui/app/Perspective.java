package org.eclipse.net4j.examples.fshare.ui.app;

import org.eclipse.net4j.examples.fshare.ui.view.FShareView;
import org.eclipse.net4j.util.concurrent.ConcurrencyUtil;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class Perspective implements IPerspectiveFactory
{
  public void createInitialLayout(IPageLayout layout)
  {
    String editorArea = layout.getEditorArea();
    layout.setEditorAreaVisible(false);
    layout.setFixed(false);

    layout.addStandaloneView(FShareView.ID, false, IPageLayout.BOTTOM, 0.3f, editorArea);
    layout.addStandaloneView("org.eclipse.ui.views.ProgressView", true, IPageLayout.BOTTOM, 0.7f, FShareView.ID);

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
