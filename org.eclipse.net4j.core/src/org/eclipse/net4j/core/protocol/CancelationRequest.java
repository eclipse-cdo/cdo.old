/***************************************************************************
 * Copyright (c) 2004-2006 Eike Stepper, Fuggerstr. 39, 10777 Berlin, Germany.
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
import org.eclipse.net4j.core.impl.AbstractRequestWithConfirmation;


public class CancelationRequest extends AbstractRequestWithConfirmation
{
  private short channelIndex;

  private String code;

  public CancelationRequest(short channelIndex, String code)
  {
    this.channelIndex = channelIndex;
    this.code = code;
  }

  public short getSignalId()
  {
    return ControlProtocol.CANCELATION;
  }

  public void request()
  {
    transmitShort(channelIndex);
    transmitString(code);
  }

  public Object confirm()
  {
    return null;
  }
}
