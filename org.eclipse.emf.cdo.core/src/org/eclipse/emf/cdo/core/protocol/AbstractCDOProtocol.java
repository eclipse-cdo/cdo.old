/***************************************************************************
 * Copyright (c) 2004, 2005, 2006 Eike Stepper, Fuggerstr. 39, 10777 Berlin, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 **************************************************************************/
package org.eclipse.emf.cdo.core.protocol;


import org.eclipse.net4j.core.Channel;
import org.eclipse.net4j.core.impl.AbstractProtocol;
import org.eclipse.net4j.util.ImplementationError;

import org.eclipse.emf.cdo.core.CDOProtocol;


public abstract class AbstractCDOProtocol extends AbstractProtocol implements CDOProtocol
{
  public String getName()
  {
    return PROTOCOL_NAME;
  }

  protected static void assertValidChannel(Channel channel)
  {
    if (!channel.getProtocol().getName().equals(PROTOCOL_NAME))
    {
      throw new ImplementationError("CDO protocol not associated with channel " + channel);
    }
  }
}
