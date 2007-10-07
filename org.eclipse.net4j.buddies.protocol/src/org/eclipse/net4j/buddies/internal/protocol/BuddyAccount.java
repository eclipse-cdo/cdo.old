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
package org.eclipse.net4j.buddies.internal.protocol;

import org.eclipse.net4j.buddies.protocol.IBuddyAccount;
import org.eclipse.net4j.util.ObjectUtil;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Eike Stepper
 */
public class BuddyAccount implements IBuddyAccount, Serializable
{
  private static final long serialVersionUID = 1L;

  private String userID;

  private String password;

  private String nickName;

  private Map<String, String> properties = new HashMap<String, String>();

  protected BuddyAccount()
  {
  }

  public BuddyAccount(String userID, String password)
  {
    this.userID = userID;
    this.password = password;
  }

  public String getUserID()
  {
    return userID;
  }

  public String getPassword()
  {
    return password;
  }

  public void setPassword(String password)
  {
    this.password = password;
  }

  public boolean authenticate(String password)
  {
    return ObjectUtil.equals(password, this.password);
  }

  public String getNickName()
  {
    return nickName;
  }

  public void setNickName(String nickName)
  {
    this.nickName = nickName;
  }

  public Map<String, String> getProperties()
  {
    return properties;
  }
}
