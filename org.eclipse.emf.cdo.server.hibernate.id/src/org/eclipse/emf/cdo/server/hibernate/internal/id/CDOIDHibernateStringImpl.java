/**
 * Copyright (c) 2004 - 2009 Eike Stepper (Berlin, Germany) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 *    Martin Taal - added hibernate specifics
 */
package org.eclipse.emf.cdo.server.hibernate.internal.id;

import org.eclipse.net4j.util.io.ExtendedDataInput;
import org.eclipse.net4j.util.io.ExtendedDataOutput;

import java.io.IOException;

/**
 * @author Eike Stepper
 * @author Martin Taal
 */
public class CDOIDHibernateStringImpl extends CDOIDHibernateImpl
{
  private static final long serialVersionUID = 1L;

  @Override
  protected int getIDType()
  {
    return HB_ID_TYPE_STRING;
  }

  public CDOIDHibernateStringImpl()
  {
  }

  @Override
  public String getId()
  {
    return (String)super.getId();
  }

  @Override
  protected void setIdFromString(String idAsString)
  {
    setId(idAsString);
  }

  @Override
  protected void readId(ExtendedDataInput in) throws IOException
  {
    setId(in.readString());
  }

  @Override
  protected void writeId(ExtendedDataOutput out) throws IOException
  {
    out.writeString(getId());
  }
}
