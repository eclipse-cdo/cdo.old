/***************************************************************************
 * Copyright (c) 2004 - 2008 Eike Stepper, Germany, and others
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 *    Martin Taal - added mappingProvider support
 **************************************************************************/
package org.eclipse.emf.cdo.server.hibernate.id;

import org.eclipse.emf.cdo.server.hibernate.internal.id.CDOIDHibernateImpl;

/**
 * @author Eike Stepper
 */
public final class CDOIDHibernateUtil
{
  private CDOIDHibernateUtil()
  {
  }

  public static CDOIDHibernate createID()
  {
    return new CDOIDHibernateImpl();
  }
}
