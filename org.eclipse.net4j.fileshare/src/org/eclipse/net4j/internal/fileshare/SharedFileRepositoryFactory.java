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

import org.eclipse.net4j.buddies.internal.protocol.ServerFacilityFactory;
import org.eclipse.net4j.util.factory.ProductCreationException;

/**
 * @author Eike Stepper
 */
public class SharedFileRepositoryFactory extends ServerFacilityFactory
{
  public static final String TYPE = "fileshare";

  public SharedFileRepositoryFactory()
  {
    super(TYPE);
  }

  public SharedFileRepository create(String description) throws ProductCreationException
  {
    return new SharedFileRepository();
  }
}
