/***************************************************************************
 * Copyright (c) 2004 - 2008 Eike Stepper, Germany, and others
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 *    Martin Taal - added hibernate specifics
 **************************************************************************/
package org.eclipse.emf.cdo.server.hibernate.internal.id;

import org.eclipse.net4j.util.io.ExtendedDataInput;
import org.eclipse.net4j.util.io.ExtendedDataOutput;

import java.io.IOException;

/**
 * @author Eike Stepper
 * @author Martin Taal
 */
public class CDOIDHibernateLongImpl extends CDOIDHibernateImpl
{
  private static final long serialVersionUID = 1L;

  public CDOIDHibernateLongImpl()
  {
  }

  public CDOIDHibernateLongImpl(String idStr)
  {
    setId(new Long(idStr));
  }

  @Override
  protected int getIDType()
  {
    return HB_ID_TYPE_LONG;
  }

  @Override
  public Long getId()
  {
    return (Long)super.getId();
  }

  protected void setIdFromString(String idAsString)
  {
    setId(new Long(idAsString));
  }

  @Override
  protected void readId(ExtendedDataInput in) throws IOException
  {
    setId(in.readLong());
  }

  @Override
  protected void writeId(ExtendedDataOutput out) throws IOException
  {
    out.writeLong(getId());
  }
}
