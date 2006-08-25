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
package org.eclipse.net4j.embedded;


import org.eclipse.net4j.core.Connector;
import org.eclipse.net4j.core.impl.BufferImpl;


public interface EmbeddedConnector extends Connector
{
  public void receive(int channelIndex, BufferImpl buffer);

  public EmbeddedConnector getPeer();

  public void setPeer(EmbeddedConnector peer);
}
