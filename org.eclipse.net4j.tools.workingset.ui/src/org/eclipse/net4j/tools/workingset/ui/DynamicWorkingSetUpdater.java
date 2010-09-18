package org.eclipse.net4j.tools.workingset.ui;

import org.eclipse.ui.IWorkingSet;
import org.eclipse.ui.IWorkingSetUpdater;

import java.util.HashSet;
import java.util.Set;

public class DynamicWorkingSetUpdater implements IWorkingSetUpdater
{
  private Set<IWorkingSet> workingSets = new HashSet<IWorkingSet>();

  public DynamicWorkingSetUpdater()
  {
  }

  public void dispose()
  {
  }

  public boolean contains(IWorkingSet workingSet)
  {
    return workingSets.contains(workingSet);
  }

  public void add(IWorkingSet workingSet)
  {
    System.out.println("add: " + workingSet);
    workingSets.add(workingSet);
  }

  public boolean remove(IWorkingSet workingSet)
  {
    System.out.println("remove: " + workingSet);
    return workingSets.remove(workingSet);
  }
}
