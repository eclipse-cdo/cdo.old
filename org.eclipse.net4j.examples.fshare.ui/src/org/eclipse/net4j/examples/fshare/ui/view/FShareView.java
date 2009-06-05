package org.eclipse.net4j.examples.fshare.ui.view;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

public class FShareView extends ViewPart
{
  public static final String ID = "org.eclipse.net4j.examples.fshare.ui.view";

  private TreeViewer viewer;

  public void createPartControl(Composite parent)
  {
    viewer = new TreeViewer(parent, SWT.H_SCROLL | SWT.V_SCROLL);
    viewer.setContentProvider(new FShareContentProvider());
    viewer.setLabelProvider(new FShareLabelProvider());
    viewer.setInput(getViewSite());
  }

  public void setFocus()
  {
    viewer.getControl().setFocus();
  }
}
