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
package org.eclipse.net4j.pop.util;

import org.eclipse.net4j.internal.pop.MylynPopManager;
import org.eclipse.net4j.internal.pop.code.MainBranch;
import org.eclipse.net4j.pop.IPopManager;
import org.eclipse.net4j.pop.code.IBranch;

import org.eclipse.mylyn.tasks.core.IRepositoryManager;
import org.eclipse.mylyn.tasks.core.data.ITaskDataManager;

/**
 * @author Eike Stepper
 */
public final class PopUtil
{
  private PopUtil()
  {
  }

  public static IPopManager createManager(IRepositoryManager repositoryManager, ITaskDataManager taskDataManager)
  {
    return new MylynPopManager(repositoryManager, taskDataManager);
  }

  public static IBranch createMainBranch(String name)
  {
    return new MainBranch(name);
  }
}
