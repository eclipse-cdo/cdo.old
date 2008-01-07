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
import org.eclipse.net4j.buddies.protocol.IMembership;
import org.eclipse.net4j.buddies.protocol.IMembershipKey;
import org.eclipse.net4j.internal.util.lifecycle.Lifecycle;
import org.eclipse.net4j.util.ObjectUtil;

import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.PlatformObject;

/**
 * @author Eike Stepper
 */
public class Membership extends Lifecycle implements IMembership
{
  private MembershipKey key;

  private long startTime;

  private transient Object[] elements;

  private Membership(IBuddy buddy, ICollaboration collaboration)
  {
    key = new MembershipKey(buddy, collaboration);
    elements = new Object[] { buddy, collaboration };
    startTime = System.currentTimeMillis();
    activate();
  }

  public IBuddy getBuddy()
  {
    return key.getBuddy();
  }

  public ICollaboration getCollaboration()
  {
    return key.getCollaboration();
  }

  public long getStartTime()
  {
    return startTime;
  }

  public Object[] getElements()
  {
    return elements;
  }

  public boolean isEmpty()
  {
    return false;
  }

  public MembershipKey getKey()
  {
    return key;
  }

  /**
   * @see PlatformObject#getAdapter(Class)
   */
  @SuppressWarnings("unchecked")
  public Object getAdapter(Class adapter)
  {
    return Platform.getAdapterManager().getAdapter(this, adapter);
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
    return key.hashCode();
  }

  @Override
  public String toString()
  {
    return key.toString();
  }

  public static IMembership create(IBuddy buddy, ICollaboration collaboration)
  {
    Membership membership = new Membership(buddy, collaboration);
    ((Buddy)buddy).addMembership(membership);
    ((Collaboration)collaboration).addMembership(membership);
    return membership;
  }
}
