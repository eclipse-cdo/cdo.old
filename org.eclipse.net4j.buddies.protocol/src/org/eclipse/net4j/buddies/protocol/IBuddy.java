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

/**
 * @author Eike Stepper
 */
public interface IBuddy extends INotifier
{
  public String getUserID();

  public State getState();

  public IBuddyAccount getAccount();

  /**
   * @author Eike Stepper
   */
  public enum State
  {
    AVAILABLE, AWAY, DO_NOT_DISTURB
  }
}
