package org.eclipse.net4j.examples.fshare.ui.view;

import org.eclipse.net4j.examples.fshare.ui.app.Application;
import org.eclipse.net4j.examples.internal.fshare.FShareFileSystem;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.FileTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

public class FShareView extends ViewPart
{
  public static final String ID = "org.eclipse.net4j.examples.fshare.ui.view";

  private FShareFileSystem fileSystem;

  private TreeViewer viewer;

  public FShareView()
  {
  }

  @Override
  public void createPartControl(Composite parent)
  {
    fileSystem = new FShareFileSystem(Application.getTargetURL());

    int ops = DND.DROP_COPY | DND.DROP_MOVE;
    Transfer[] transfers = new Transfer[] { FileTransfer.getInstance() };

    viewer = new TreeViewer(parent, SWT.H_SCROLL | SWT.V_SCROLL);
    viewer.addDragSupport(ops, transfers, new FShareDragHandler(fileSystem, viewer));
    viewer.addDropSupport(ops, transfers, new FShareDropHandler(fileSystem, viewer));
    viewer.setContentProvider(new FShareContentProvider());
    viewer.setLabelProvider(new FShareLabelProvider());
    viewer.setComparator(new FShareComparator());
    viewer.setInput(fileSystem.getRootFolder());

    getSite().setSelectionProvider(viewer);
  }

  @Override
  public void setFocus()
  {
    viewer.getControl().setFocus();
  }
}
