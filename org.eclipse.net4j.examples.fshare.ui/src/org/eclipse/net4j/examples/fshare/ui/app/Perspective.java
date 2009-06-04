package org.eclipse.net4j.examples.fshare.ui.app;

import org.eclipse.net4j.examples.fshare.ui.view.FShareView;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class Perspective implements IPerspectiveFactory
{
  public void createInitialLayout(IPageLayout layout)
  {
    String editorArea = layout.getEditorArea();
    layout.setEditorAreaVisible(false);
    layout.setFixed(false);

    layout.addStandaloneView("org.eclipse.ui.views.ProgressView", false, IPageLayout.BOTTOM, 0.7f, editorArea);
    layout.addStandaloneView(FShareView.ID, false, IPageLayout.BOTTOM, 0.3f, editorArea);
  }
}
