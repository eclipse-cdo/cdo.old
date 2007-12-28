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
package org.eclipse.net4j.buddies.internal.protocol;

import org.eclipse.net4j.buddies.protocol.IBuddy;
import org.eclipse.net4j.buddies.protocol.ICollaboration;
import org.eclipse.net4j.buddies.protocol.IMembershipKey;
import org.eclipse.net4j.util.ObjectUtil;

/**
 * @author Eike Stepper
 */
public class MembershipKey implements IMembershipKey
{
  private IBuddy buddy;

  private ICollaboration collaboration;

  public MembershipKey(IBuddy buddy, ICollaboration collaboration)
  {
    this.buddy = buddy;
    this.collaboration = collaboration;
  }

  public IBuddy getBuddy()
  {
    return buddy;
  }

  public ICollaboration getCollaboration()
  {
    return collaboration;
  }

  @Override
  public boolean equals(Object obj)
  {
    if (obj == this)
    {
      return true;
    }

    if (obj instanceof IMembershipKey)
    {
      IMembershipKey key = (IMembershipKey)obj;
      return ObjectUtil.equals(getBuddy(), key.getBuddy())
          && ObjectUtil.equals(getCollaboration(), key.getCollaboration());
    }

    return false;
  }

  @Override
  public int hashCode()
  {
    return ObjectUtil.hashCode(buddy) ^ ObjectUtil.hashCode(collaboration);
  }

  @Override
  public String toString()
  {
    return buddy + "(" + collaboration + ")";
  }
}
