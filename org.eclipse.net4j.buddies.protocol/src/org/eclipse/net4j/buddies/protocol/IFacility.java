/***************************************************************************
 * Copyright (c) 2004 - 2007 Eike Stepper, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 **************************************************************************/
package org.eclipse.net4j.buddies.protocol;

import org.eclipse.net4j.util.event.INotifier;

import org.eclipse.core.runtime.IAdaptable;

/**
 * @author Eike Stepper
 */
public interface IFacility extends INotifier, IAdaptable
{
  public String getType();

  public ICollaboration getCollaboration();

  public void setCollaboration(ICollaboration collaboration);

  public void handleMessage(IMessage message);

}
