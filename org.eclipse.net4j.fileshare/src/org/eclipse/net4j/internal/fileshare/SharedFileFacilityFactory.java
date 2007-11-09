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
package org.eclipse.net4j.internal.fileshare;

import org.eclipse.net4j.buddies.internal.protocol.ClientFacilityFactory;
import org.eclipse.net4j.fileshare.ISharedFileFacility;
import org.eclipse.net4j.util.factory.ProductCreationException;

/**
 * @author Eike Stepper
 */
public class SharedFileFacilityFactory extends ClientFacilityFactory
{
  public SharedFileFacilityFactory()
  {
    super(ISharedFileFacility.TYPE);
  }

  public SharedFileFacility create(String description) throws ProductCreationException
  {
    return new SharedFileFacility();
  }
}
