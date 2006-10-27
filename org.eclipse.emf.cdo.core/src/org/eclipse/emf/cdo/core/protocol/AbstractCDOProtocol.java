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
package org.eclipse.emf.cdo.core.protocol;


import org.eclipse.net4j.signal.SignalProtocol;
import org.eclipse.net4j.transport.Channel;

import org.eclipse.emf.cdo.core.CDOProtocol;


public abstract class AbstractCDOProtocol extends SignalProtocol implements CDOProtocol
{
  public AbstractCDOProtocol(Channel channel)
  {
    super(channel);
  }

  public String getProtocolID()
  {
    return PROTOCOL_NAME;
  }
}
