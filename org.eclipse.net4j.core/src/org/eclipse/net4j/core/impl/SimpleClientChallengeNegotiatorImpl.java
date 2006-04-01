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
package org.eclipse.net4j.core.impl;


public class SimpleClientChallengeNegotiatorImpl extends AbstractClientChallengeNegotiator
{
  private String userName;

  private transient String password; // Transient to prevent from logging

  public String getUserName()
  {
    return userName;
  }

  public void setUserName(String userName)
  {
    doSet("userName", userName);
  }

  public String getPassword()
  {
    return password;
  }

  public void setPassword(String password)
  {
    doSet("password", password);
  }

  public LoginCredentials getLoginCredentials()
  {
    return new LoginCredentials()
    {
      public String getUserName()
      {
        return SimpleClientChallengeNegotiatorImpl.this.getUserName();
      }

      public String getPassword()
      {
        return SimpleClientChallengeNegotiatorImpl.this.getPassword();
      }
    };
  }
}
