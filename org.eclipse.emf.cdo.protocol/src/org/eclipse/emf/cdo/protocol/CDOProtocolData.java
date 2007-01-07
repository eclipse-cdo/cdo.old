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
package org.eclipse.emf.cdo.protocol;

/**
 * @author Eike Stepper
 */
public final class CDOProtocolData
{
  private String repositoryName;

  private String userName;

  public CDOProtocolData(String repositoryName, String userName)
  {
    this.repositoryName = repositoryName;
    this.userName = userName;
  }

  public String getRepositoryName()
  {
    return repositoryName;
  }

  public String getUserName()
  {
    return userName;
  }
}
