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
package org.eclipse.net4j.socket.impl;


import org.eclipse.net4j.spring.ValidationException;


public class PassiveSocketConnectorImpl extends AbstractSocketConnector
{
  public int getType()
  {
    return SERVER;
  }

  @Override
  protected void validate() throws ValidationException
  {
    super.validate();
    assertNotNull("connectionManager");
  }

  @Override
  protected void deactivate() throws Exception
  {
    super.deactivate();

    if (getSocketChannel() != null)
    {
      getSocketChannel().close();
      setSocketChannel(null);
      if (isInfoEnabled()) info("Disconnected");
    }
  }
}
