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
package org.eclipse.net4j.pop;

import org.eclipse.net4j.pop.release.IRelease;
import org.eclipse.net4j.pop.release.IVersion;

import org.eclipse.mylyn.tasks.core.ITask;

import java.util.Date;

/**
 * @author Eike Stepper
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface IIntegrationStream extends IStream
{
  public IIntegrationStream getParent();

  public ITaskStream addTaskStream(IBaseline baseline, ITask task);

  public ITaskStream addTaskStream(String tagName, ITask task);

  public int getTaskStreamCount();

  public ITaskStream getTaskStream(int index);

  public ITaskStream[] getTaskStreams();

  public IRelease addRelease(Date date);

  public int getReleaseCount();

  public IRelease getRelease(int index);

  public IRelease getReleaseByVersion(IVersion version);

  public IRelease[] getReleases();
}
