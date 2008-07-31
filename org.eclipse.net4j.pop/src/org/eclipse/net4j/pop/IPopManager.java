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

import org.eclipse.net4j.pop.code.IBranch;
import org.eclipse.net4j.pop.code.ICodeStrategy;
import org.eclipse.net4j.pop.util.IElement;

import org.eclipse.mylyn.tasks.core.ITask;

/**
 * @author Eike Stepper
 */
public interface IPopManager extends IElement
{
  public ITask getTask(String taskId);

  public IStream getStream(ITask task);

  public IPop createPop(String name, IBranch branch, ITask task, ICodeStrategy codeStrategy);

  public IPop createPop(String name, IBranch branch, ITask task);
}
