package org.eclipse.net4j.examples.fshare.ui.view;

import org.eclipse.net4j.examples.fshare.ui.app.Application;
import org.eclipse.net4j.examples.internal.fshare.FileSystem;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

public class FShareView extends ViewPart
{
  public static final String ID = "org.eclipse.net4j.examples.fshare.ui.view";

  private FileSystem fileSystem;

  private TreeViewer viewer;

  public FShareView()
  {
  }

  @Override
  public void createPartControl(Composite parent)
  {
    fileSystem = new FileSystem(Application.getTargetURL());

    viewer = new TreeViewer(parent, SWT.H_SCROLL | SWT.V_SCROLL);
    viewer.setContentProvider(new FShareContentProvider(fileSystem));
    viewer.setLabelProvider(new FShareLabelProvider());
    viewer.setInput(getViewSite());
  }

  @Override
  public void setFocus()
  {
    viewer.getControl().setFocus();
  }
}
