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

import org.eclipse.net4j.buddies.protocol.IMessage;
import org.eclipse.net4j.util.factory.ProductCreationException;

/**
 * @author Eike Stepper
 */
public class Test1Facility extends Facility
{
  public Test1Facility(String type)
  {
    super(type);
  }

  public void handleMessage(IMessage message)
  {
    throw new UnsupportedOperationException();
  }

  /**
   * @author Eike Stepper
   */
  public static final class ClientFactory extends ClientFacilityFactory
  {
    public ClientFactory()
    {
      super(Test1Facility.class.getSimpleName());
    }

    public Object create(String description) throws ProductCreationException
    {
      return new Test1Facility(getType());
    }
  }

  /**
   * @author Eike Stepper
   */
  public static final class ServerFactory extends ServerFacilityFactory
  {
    public ServerFactory()
    {
      super(Test1Facility.class.getSimpleName());
    }

    public Object create(String description) throws ProductCreationException
    {
      return new Test1Facility(getType());
    }
  }
}
