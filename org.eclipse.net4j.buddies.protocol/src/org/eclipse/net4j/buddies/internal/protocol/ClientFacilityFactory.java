/***************************************************************************
 * Copyright (c) 2004 - 2007 Eike Stepper, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 **************************************************************************/
package org.eclipse.net4j.buddies.internal.protocol;

import org.eclipse.net4j.internal.util.factory.Factory;

/**
 * @author Eike Stepper
 */
public abstract class ClientFacilityFactory extends Factory
{
  public static final String PRODUCT_GROUP = "org.eclipse.net4j.buddies.clientFacilities";

  public ClientFacilityFactory(String type)
  {
    super(PRODUCT_GROUP, type);
  }
}