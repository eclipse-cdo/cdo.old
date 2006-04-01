/*******************************************************************************
 * Copyright (c) 2004, 2005, 2006 Eike Stepper, Sympedia Methods and Tools.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Eike Stepper - initial API and implementation
 *******************************************************************************/
package org.eclipse.net4j.core.protocol;


import org.eclipse.net4j.core.BasicProtocol;
import org.eclipse.net4j.core.impl.AbstractRequestWithConfirmation;

import java.util.ArrayList;
import java.util.List;


public class GetProtocolsRequest extends AbstractRequestWithConfirmation
{
  public GetProtocolsRequest()
  {
  }

  public short getSignalId()
  {
    return BasicProtocol.GET_PROTOCOLS;
  }

  public void request()
  {
  }

  public Object confirm()
  {
    List result = new ArrayList();
    String name;

    while ((name = receiveString()) != null)
    {
      result.add(name);
    }

    return result.toArray(new String[result.size()]);
  }
}
