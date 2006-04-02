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
package org.eclipse.net4j.core.protocol;


import org.eclipse.net4j.core.ControlProtocol;
import org.eclipse.net4j.core.Protocol;
import org.eclipse.net4j.core.ProtocolManager;
import org.eclipse.net4j.core.impl.AbstractIndicationWithResponse;

import java.util.Iterator;


public class GetProtocolsIndication extends AbstractIndicationWithResponse
{
  private ProtocolManager protocolManager;

  public GetProtocolsIndication(ProtocolManager protocolManager)
  {
    this.protocolManager = protocolManager;
  }

  public short getSignalId()
  {
    return ControlProtocol.GET_PROTOCOLS;
  }

  public void indicate()
  {
  }

  public void respond()
  {
    for (Iterator iter = protocolManager.getServerProtocols(); iter.hasNext();)
    {
      Protocol protocol = (Protocol)iter.next();
      transmitString(protocol.getName());
    }

    transmitString(null);
  }
}
