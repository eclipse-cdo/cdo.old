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
package org.eclipse.emf.cdo.protocol.model;

import org.eclipse.emf.cdo.internal.protocol.model.CDOClassResolverImpl;

/**
 * @author Eike Stepper
 */
public interface CDOClassResolver
{
  public static final CDOClassResolver INSTANCE = new CDOClassResolverImpl();

  /**
   * TODO Check if the functionality of this class could be moved to a static util method
   */
  public CDOClass resolveClass(CDOClassRef classRef);
}
