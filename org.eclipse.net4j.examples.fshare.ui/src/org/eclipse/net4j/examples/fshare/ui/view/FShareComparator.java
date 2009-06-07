package org.eclipse.net4j.examples.fshare.ui.view;

import org.eclipse.net4j.examples.fshare.IFile;

import org.eclipse.jface.viewers.ViewerComparator;

public class FShareComparator extends ViewerComparator
{
  public FShareComparator()
  {
  }

  @Override
  public int category(Object element)
  {
    if (element instanceof IFile)
    {
      return 1;
    }

    return super.category(element);
  }
}
