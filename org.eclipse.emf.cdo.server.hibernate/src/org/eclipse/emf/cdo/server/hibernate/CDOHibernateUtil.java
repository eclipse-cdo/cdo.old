/*
 * Copyright (c) 2008, 2011, 2012, 2016 Eike Stepper (Loehne, Germany) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Eike Stepper - initial API and implementation
 *    Martin Taal - added mappingProvider support
 */
package org.eclipse.emf.cdo.server.hibernate;

import org.eclipse.emf.cdo.server.internal.hibernate.HibernateStore;
import org.eclipse.emf.cdo.server.internal.hibernate.HibernateUtil;

/**
 * Various static methods that may help in setting up and dealing with {@link IHibernateStore Hibernate stores}.
 *
 * @author Eike Stepper
 * @author Martin Taal
 */
public final class CDOHibernateUtil
{
  private CDOHibernateUtil()
  {
  }

  /**
   * @since 4.1
   */
  public static IHibernateMappingProvider.Factory getMappingProviderFactoryInstance()
  {
    return HibernateUtil.getMappingProviderFactoryInstance();
  }

  /**
   * @since 4.1
   */
  public static void setMappingProviderFactoryInstance(IHibernateMappingProvider.Factory theMappingProviderFactoryInstance)
  {
    HibernateUtil.setMappingProviderFactoryInstance(theMappingProviderFactoryInstance);
  }

  public static IHibernateStore createStore(IHibernateMappingProvider mappingProvider)
  {
    return new HibernateStore(mappingProvider);
  }
}
