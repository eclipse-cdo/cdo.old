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
package org.eclipse.net4j.pop.task;

import org.eclipse.net4j.pop.task.util.ISaveable;
import org.eclipse.net4j.pop.task.util.ISynchronizeable;

import org.eclipse.core.runtime.IAdaptable;

/**
 * @author Eike Stepper
 */
public interface ITask extends ISynchronizeable, ISaveable, IAdaptable
{
  public ITaskRepository getRepository();

  public String getID() throws IllegalStateException;

  public String getTitle();

  public String setTitle(String title);

  public ITaskAttributeValue[] getAttributeValues();

  public void setAttributeValues(ITaskAttributeValue[] taskAttributeValues);

  public ITaskComment[] getComments();

  public ITaskComment addComment(String message);
}
