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
package org.eclipse.net4j.internal.pop.release;

import org.eclipse.net4j.internal.pop.util.ElementContainer;
import org.eclipse.net4j.pop.IIntegrationStream;
import org.eclipse.net4j.pop.code.ITag;
import org.eclipse.net4j.pop.release.IMilestone;
import org.eclipse.net4j.pop.release.IRelease;
import org.eclipse.net4j.pop.release.IVersion;

import java.text.MessageFormat;
import java.util.Date;

/**
 * @author Eike Stepper
 */
public class Release extends Target implements IRelease
{
  protected ElementContainer<IMilestone> milestoneContainer = new ElementContainer<IMilestone>(this);

  private IIntegrationStream stream;

  private IVersion version;

  public Release(IIntegrationStream stream, IVersion version, ITag tag, Date date)
  {
    super(tag, date);
    checkArgument(stream, "stream");
    checkArgument(version, "version");
    this.stream = stream;
    this.version = version;
  }

  public IIntegrationStream getStream()
  {
    return stream;
  }

  public IVersion getVersion()
  {
    return version;
  }

  public IMilestone addMilestone(String name, Date date)
  {
    ITag tag = getStream().getPop().getCodeStrategy().createMilestoneTag(this, name);
    IMilestone milestone = new Milestone(this, name, tag, date);
    milestoneContainer.addElement(milestone);
    stream.addBaseline(milestone);
    return milestone;
  }

  public IMilestone getMilestone(int index)
  {
    return milestoneContainer.getElement(index);
  }

  public int getMilestoneCount()
  {
    return milestoneContainer.getElementCount();
  }

  public IMilestone[] getMilestones()
  {
    return milestoneContainer.getElements(IMilestone.class);
  }

  @Override
  public String toString()
  {
    return MessageFormat.format("Release[branch={0}, version={1}, tag={2}]", stream.getBranch().getName(), version,
        getTag().getName());
  }
}
