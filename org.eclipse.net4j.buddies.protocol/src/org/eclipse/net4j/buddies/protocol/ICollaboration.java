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

import java.util.Map;

/**
 * @author Eike Stepper
 */
public interface ICollaboration extends IBuddyContainer
{
  public long getID();

  public String getTitle();

  public String getDescription();

  public Visibility getVisibility();

  public boolean isPublic();

  public void setPublic(String title, String description);

  public void setPrivate();

  public Map<String, IFacility> getFacilities();

  public void sendMessage(IMessage message);

  public enum Visibility
  {
    PRIVATE, PUBLIC
  }
}