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

import org.eclipse.net4j.internal.pop.delivery.Merge;
import org.eclipse.net4j.internal.pop.util.Element;
import org.eclipse.net4j.internal.pop.util.ElementContainer;
import org.eclipse.net4j.pop.IBaseline;
import org.eclipse.net4j.pop.IPop;
import org.eclipse.net4j.pop.IStream;
import org.eclipse.net4j.pop.InternalPopManager;
import org.eclipse.net4j.pop.code.IBranch;
import org.eclipse.net4j.pop.delivery.IDelivery;
import org.eclipse.net4j.pop.delivery.IMerge;
import org.eclipse.net4j.util.ImplementationError;

import org.eclipse.mylyn.tasks.core.ITask;

import java.util.Date;

/**
 * @author Eike Stepper
 */
public abstract class Stream extends Element implements IStream
{
  protected ElementContainer<IBaseline> baselineContainer = new ElementContainer<IBaseline>(this);

  protected ElementContainer<IMerge> mergeContainer = new ElementContainer<IMerge>(this);

  private IBaseline baseline;

  private IBranch branch;

  private ITask task;

  protected Stream(IBaseline baseline, IBranch branch, ITask task)
  {
    checkArgument(baseline != null || this instanceof IPop, "baseline");
    checkArgument(branch, "branch");
    checkArgument(task, "task");
    this.baseline = baseline;
    this.branch = branch;
    this.task = task;
  }

  @Deprecated
  protected InternalPopManager getManager()
  {
    return (InternalPopManager)getPop().getManager();
  }

  public IBaseline getBaseline()
  {
    return baseline;
  }

  public IBranch getBranch()
  {
    return branch;
  }

  public ITask getTask()
  {
    return task;
  }

  public IStream getParent()
  {
    if (baseline == null)
    {
      return null;
    }

    return baseline.getStream();
  }

  /**
   * Must be overridden by {@link IPop} implementations (i.e. {@link Pop}).
   */
  public IPop getPop()
  {
    if (this instanceof IPop)
    {
      throw new ImplementationError();
    }

    return getParent().getPop();
  }

  public IMerge addMerge(Date date, IDelivery delivery)
  {
    checkArgument(date, "date");
    checkArgument(delivery, "delivery");
    IMerge merge = new Merge(this, date, delivery);
    mergeContainer.addElement(merge);
    return merge;
  }

  public IMerge getMerge(int index)
  {
    checkArgument(index >= 0, "index");
    return mergeContainer.getElement(index);
  }

  public int getMergeCount()
  {
    return mergeContainer.getElementCount();
  }

  public IMerge[] getMerges()
  {
    return mergeContainer.getElements(IMerge.class);
  }

  public IBaseline addBaseline(IBaseline baseline)
  {
    baselineContainer.addElement(BaselineProxy.proxy(baseline));
    return baseline;
  }

  public IBaseline addBaseline(String tagName)
  {
    checkArgument(tagName, "tagName");
    IBaseline baseline = new Baseline(this, tagName);
    return addBaseline(baseline);
  }

  public IBaseline getBaseline(int index)
  {
    checkArgument(index >= 0, "index");
    return baselineContainer.getElement(index);
  }

  public int getBaselineCount()
  {
    return baselineContainer.getElementCount();
  }

  public IBaseline getBaselineByTagName(String tagName)
  {
    checkArgument(tagName, "tagName");
    for (IBaseline baseline : getBaselines())
    {
      if (baseline.getTag().getName().equals(tagName))
      {
        return baseline;
      }
    }

    return null;
  }

  public IBaseline[] getBaselines()
  {
    return baselineContainer.getElements(IBaseline.class);
  }
}
