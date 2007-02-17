/***************************************************************************
 * Copyright (c) 2004-2007 Eike Stepper, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 **************************************************************************/
package org.eclipse.emf.cdo.internal.container;

import org.eclipse.emf.cdo.container.CDOSessionDescription;

import org.eclipse.net4j.util.ObjectUtil;

import org.eclipse.internal.net4j.util.Value;

import java.text.MessageFormat;

/**
 * @author Eike Stepper
 */
public class CDOSessionDescriptionImpl extends Value implements CDOSessionDescription
{
  private static final long serialVersionUID = 1L;

  private String connectorDescription;

  private String repositoryName;

  public CDOSessionDescriptionImpl(String connectorDescription, String repositoryName)
  {
    this.connectorDescription = connectorDescription;
    this.repositoryName = repositoryName;
  }

  public String getConnectorDescription()
  {
    return connectorDescription;
  }

  public String getRepositoryName()
  {
    return repositoryName;
  }

  @Override
  protected Object clone() throws CloneNotSupportedException
  {
    return this;
  }

  @Override
  public boolean equals(Object obj)
  {
    if (obj instanceof CDOSessionDescription)
    {
      CDOSessionDescription that = (CDOSessionDescription)obj;
      return ObjectUtil.equals(this.connectorDescription, that.getConnectorDescription())
          && ObjectUtil.equals(this.repositoryName, that.getRepositoryName());
    }

    return false;
  }

  @Override
  public int hashCode()
  {
    return connectorDescription.hashCode() ^ repositoryName.hashCode();
  }

  @Override
  public String toString()
  {
    return MessageFormat.format("{0}:{1}", connectorDescription, repositoryName);
  }
}
