/***************************************************************************
 * Copyright (c) 2004 - 2008 Eike Stepper, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 **************************************************************************/
package org.eclipse.net4j.internal.pop;

import org.eclipse.net4j.internal.pop.release.Release;
import org.eclipse.net4j.internal.pop.util.ElementContainer;
import org.eclipse.net4j.internal.pop.util.StreamProxyContainer;
import org.eclipse.net4j.pop.IBaseline;
import org.eclipse.net4j.pop.IIntegrationStream;
import org.eclipse.net4j.pop.ITaskStream;
import org.eclipse.net4j.pop.code.IBranch;
import org.eclipse.net4j.pop.code.ITag;
import org.eclipse.net4j.pop.release.IRelease;
import org.eclipse.net4j.pop.release.IVersion;

import org.eclipse.mylyn.tasks.core.ITask;

import java.util.Date;

/**
 * @author Eike Stepper
 */
public abstract class IntegrationStream extends Stream implements IIntegrationStream
{
  protected StreamProxyContainer<ITaskStream> taskStreamContainer = new StreamProxyContainer<ITaskStream>(this);

  protected ElementContainer<IRelease> releaseContainer = new ElementContainer<IRelease>(this);

  protected IntegrationStream(IBaseline baseline, IBranch branch, ITask task)
  {
    super(baseline, branch, task);
  }

  @Override
  public IIntegrationStream getParent()
  {
    return (IIntegrationStream)super.getParent();
  }

  public ITaskStream addTaskStream(IBaseline baseline, ITask task)
  {
    checkArgument(baseline, "baseline");
    checkArgument(task, "task");
    // if (baseline instanceof IRelease)
    // {
    // IRelease release = (IRelease)baseline;
    // baseline = ReleaseProxy.proxy(release);
    // }
    // else
    // {
    // baseline = BaselineProxy.proxy(baseline);
    // }

    IBranch branch = getPop().getCodeStrategy().createTaskBranch(baseline, task);
    ITaskStream taskStream = new TaskStream(baseline, branch, task);
    taskStreamContainer.addElement(taskStream);
    return taskStream;
  }

  public ITaskStream addTaskStream(String tagName, ITask task)
  {
    IBaseline baseline = addBaseline(tagName);
    return addTaskStream(baseline, task);
  }

  public ITaskStream getTaskStream(int index)
  {
    checkArgument(index >= 0, "index");
    return taskStreamContainer.getElement(index);
  }

  public int getTaskStreamCount()
  {
    return taskStreamContainer.getElementCount();
  }

  public ITaskStream[] getTaskStreams()
  {
    return taskStreamContainer.getElements(ITaskStream.class);
  }

  public IRelease getRelease(int index)
  {
    checkArgument(index >= 0, "index");
    return releaseContainer.getElement(index);
  }

  public int getReleaseCount()
  {
    return releaseContainer.getElementCount();
  }

  public IRelease getReleaseByVersion(IVersion version)
  {
    checkArgument(version, "version");
    for (IRelease release : getReleases())
    {
      if (release.getVersion().equals(version))
      {
        return release;
      }
    }

    return null;
  }

  @Override
  public String toString()
  {
    return null;
  }

  public IRelease[] getReleases()
  {
    return releaseContainer.getElements(IRelease.class);
  }

  protected IRelease addRelease(IVersion version, Date date)
  {
    ITag tag = getPop().getCodeStrategy().createReleaseTag(this, version);
    IRelease release = new Release(this, version, tag, date);
    releaseContainer.addElement(ReleaseProxy.proxy(release));
    baselineContainer.addElement(release);
    return release;
  }
}
