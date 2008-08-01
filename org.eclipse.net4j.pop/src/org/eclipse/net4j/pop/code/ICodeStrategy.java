package org.eclipse.net4j.pop.code;

import org.eclipse.net4j.pop.IBaseline;
import org.eclipse.net4j.pop.IIntegrationStream;
import org.eclipse.net4j.pop.release.IRelease;
import org.eclipse.net4j.pop.release.IVersion;
import org.eclipse.net4j.pop.util.IElement;

import org.eclipse.mylyn.tasks.core.ITask;

/**
 * @author Eike Stepper
 */
public interface ICodeStrategy extends IElement
{
  public static final ICodeStrategy DEFAULT = new org.eclipse.net4j.internal.pop.code.DefaultCodeStrategy();

  public IBranch createMaintenanceBranch(IRelease baseline, ITask task);

  public IBranch createTaskBranch(IBaseline baseline, ITask task);

  public IBaseline createTaskBaseline(IIntegrationStream stream, ITask task);

  public ITag createReleaseTag(IIntegrationStream stream, IVersion version);

  public ITag createMilestoneTag(IRelease release, String name);
}
