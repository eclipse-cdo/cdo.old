/***************************************************************************
 * Copyright (c) 2004, 2005, 2006 Eike Stepper, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 **************************************************************************/
package org.eclipse.net4j.spring;


public interface Service extends Loggable
{
  public int getState();

  public boolean isAutoStart();

  public boolean isStarted();

  public boolean isActive();

  public void start() throws Exception;

  public void stop() throws Exception;

  public void addStateListener(StateListener listener);

  public void removeStateListener(StateListener listener);

  public void dump();

  /**
   * Only for unit test.
   */
  public void testSetState(byte state);
}
