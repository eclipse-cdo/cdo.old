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

import org.eclipse.emf.cdo.protocol.id.CDOIDObject;
import org.eclipse.emf.cdo.protocol.id.CDOIDObjectFactory;

import org.eclipse.net4j.util.io.ExtendedDataInput;

/**
 * @author Eike Stepper
 */
public class CDOIDHibernateFactoryImpl implements CDOIDObjectFactory
{
  public CDOIDHibernateFactoryImpl()
  {
  }

  public CDOIDObject createCDOIDObject(ExtendedDataInput in)
  {
    return new CDOIDHibernateImpl();
  }
}
