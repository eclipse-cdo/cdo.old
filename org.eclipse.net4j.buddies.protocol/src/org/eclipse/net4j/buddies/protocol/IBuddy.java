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

import org.eclipse.core.runtime.IAdaptable;

import java.util.Set;

/**
 * @author Eike Stepper
 */
public interface IBuddy extends ICollaborationContainer, IAdaptable
{
  public String getUserID();

  public State getState();

  public IAccount getAccount();

  public ISession getSession();

  public Set<String> getFacilityTypes();

  // public ICollaboration join(int ID);
  //
  // public IBuddy invite(ICollaboration collaboration, String userID);
  //
  // public void kick(ICollaboration collaboration, IBuddy buddy);
  //
  // public void leave(ICollaboration collaboration);

  /**
   * @author Eike Stepper
   */
  public enum State
  {
    AVAILABLE, LONESOME, AWAY, DO_NOT_DISTURB
  }
}
