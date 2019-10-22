/*
 * Copyright (c) 2008, 2011, 2012, 2015 Eike Stepper (Loehne, Germany) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Eike Stepper - initial API and implementation
 */
package org.eclipse.emf.cdo.server.hibernate;

import org.eclipse.emf.cdo.server.IStoreChunkReader;

/**
 * Hibernate specific implementation of the {@link IStoreChunkReader}.
 *
 * @author Eike Stepper
 * @noextend This interface is not intended to be extended by clients.
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface IHibernateStoreChunkReader extends IStoreChunkReader
{
  /**
   * @since 2.0
   */
  public IHibernateStoreAccessor getAccessor();
}
