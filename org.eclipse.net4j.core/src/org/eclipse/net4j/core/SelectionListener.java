/*******************************************************************************
 * Copyright (c) 2004, 2005, 2006 Eike Stepper, Sympedia Methods and Tools.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Eike Stepper - initial API and implementation
 *******************************************************************************/
package org.eclipse.net4j.core;


import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;


public interface SelectionListener
{
  public void notifyRegistration(SelectableChannel selectable, SelectionKey key);

  public void readyForRead(SelectableChannel selectable);
}
