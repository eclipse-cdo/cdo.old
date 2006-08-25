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
package org.eclipse.net4j.embedded.impl;


import org.eclipse.net4j.embedded.EmbeddedConnector;
import org.eclipse.net4j.spring.ValidationException;


public class ActiveEmbeddedConnectorImpl extends AbstractEmbeddedConnector
{
  public int getType()
  {
    return CLIENT;
  }

  @Override
  protected void activate() throws Exception
  {
    peer = (EmbeddedConnector) getContainer().getBean("slave");
    peer.setPeer(this);
    super.activate();

    try
    {
      peer.start();
    }
    catch (Exception ex)
    {
      throw new ValidationException("Error while starting slave " + peer, ex);
    }

  }

  @Override
  protected void deactivate() throws Exception
  {
    super.deactivate();

    if (peer != null)
    {
      peer.stop();
      peer = null;
    }

    if (isInfoEnabled()) info("Disconnected");
  }
}
