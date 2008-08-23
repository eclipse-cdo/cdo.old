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
package org.eclipse.emf.cdo.server.hibernate.internal.id;

import org.eclipse.emf.cdo.common.id.CDOIDObject;
import org.eclipse.emf.cdo.common.id.CDOIDObjectFactory;
import org.eclipse.emf.cdo.server.hibernate.id.CDOIDHibernate;

import org.eclipse.net4j.util.WrappedException;
import org.eclipse.net4j.util.io.ExtendedDataInput;

import java.io.IOException;
import java.io.Serializable;

/**
 * @author Eike Stepper
 */
public class CDOIDHibernateFactoryImpl implements CDOIDObjectFactory
{
  private static CDOIDHibernateFactoryImpl instance = new CDOIDHibernateFactoryImpl();

  public static CDOIDHibernateFactoryImpl getInstance()
  {
    return instance;
  }

  public static void setInstance(CDOIDHibernateFactoryImpl instance)
  {
    CDOIDHibernateFactoryImpl.instance = instance;
  }

  public CDOIDHibernateFactoryImpl()
  {
  }

  public CDOIDObject createCDOIDObject(ExtendedDataInput in)
  {
    try
    {
      int idType = in.readInt();
      switch (idType)
      {
      case CDOIDHibernateImpl.HB_ID_TYPE_SERIALIZABLE:
        return new CDOIDHibernateImpl();
      case CDOIDHibernateImpl.HB_ID_TYPE_LONG:
        return new CDOIDHibernateLongImpl();
      case CDOIDHibernateImpl.HB_ID_TYPE_STRING:
        return new CDOIDHibernateStringImpl();
      default:
        throw new IllegalArgumentException("IDTYPE " + idType + " not supported");
      }
    }
    catch (IOException ex)
    {
      throw WrappedException.wrap(ex);
    }
  }

  public CDOIDHibernate createCDOID(Serializable id, String entityName)
  {
    CDOIDHibernate cdoID;
    if (id instanceof Long)
    {
      cdoID = new CDOIDHibernateLongImpl();
    }
    else if (id instanceof String)
    {
      cdoID = new CDOIDHibernateStringImpl();
    }
    else
    {
      cdoID = new CDOIDHibernateImpl();
    }

    cdoID.setId(id);
    cdoID.setEntityName(entityName);
    return cdoID;
  }

  public CDOIDObject createCDOIDObject(String fragmentPart)
  {
    // TODO: implement CDOIDHibernateFactoryImpl.createCDOIDObject(fragmentPart)
    throw new UnsupportedOperationException();
  }
}
