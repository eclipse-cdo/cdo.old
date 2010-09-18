package org.eclipse.net4j.tools.workingset.ui;

import org.eclipse.ui.IWorkingSet;
import org.eclipse.ui.IWorkingSetUpdater;

public class DynamicWorkingSetUpdater implements IWorkingSetUpdater
{
  public DynamicWorkingSetUpdater()
  {
  }

  public void dispose()
  {
  }

  public boolean contains(IWorkingSet workingSet)
  {
    return false;
  }

  public void add(IWorkingSet workingSet)
  {
  }

  public boolean remove(IWorkingSet workingSet)
  {
    return false;
  }
}
