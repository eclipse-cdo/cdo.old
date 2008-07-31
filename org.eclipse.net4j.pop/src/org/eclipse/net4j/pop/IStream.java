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
import org.eclipse.net4j.pop.delivery.IDelivery;
import org.eclipse.net4j.pop.delivery.IMerge;
import org.eclipse.net4j.pop.util.IElement;

import org.eclipse.mylyn.tasks.core.ITask;

import java.util.Date;

/**
 * @author Eike Stepper
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface IStream extends IElement
{
  public IPopManager getManager();

  public IPop getPop();

  public IStream getParent();

  public IBaseline getBaseline();

  public IBranch getBranch();

  public ITask getTask();

  public IMerge addMerge(Date date, IDelivery delivery);

  public int getMergeCount();

  public IMerge getMerge(int index);

  public IMerge[] getMerges();

  public IBaseline addBaseline(IBaseline baseline);

  public IBaseline addBaseline(String tagName);

  public int getBaselineCount();

  public IBaseline getBaseline(int index);

  public IBaseline getBaselineByTagName(String tagName);

  public IBaseline[] getBaselines();
}
