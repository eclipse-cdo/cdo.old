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
package org.eclipse.net4j.buddies.protocol;

import java.util.Map;

/**
 * @author Eike Stepper
 */
public interface IAccount
{
  public String getUserID();

  public void setPassword(String password);

  public boolean authenticate(String password);

  public Map<String, String> getProperties();

  public void touch();

  public long getTimeStamp();
}
