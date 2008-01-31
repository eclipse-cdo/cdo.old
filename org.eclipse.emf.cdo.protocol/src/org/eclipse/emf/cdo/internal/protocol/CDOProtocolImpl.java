/***************************************************************************
 * Copyright (c) 2004 - 2008 Eike Stepper, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 **************************************************************************/
package org.eclipse.emf.cdo.internal.protocol;

import org.eclipse.emf.cdo.protocol.CDOProtocol;
import org.eclipse.emf.cdo.protocol.CDOProtocolConstants;
import org.eclipse.emf.cdo.protocol.CDOProtocolSession;

import org.eclipse.net4j.signal.SignalProtocol;

/**
 * @author Eike Stepper
 */
public abstract class CDOProtocolImpl extends SignalProtocol implements CDOProtocol
{
  public CDOProtocolImpl()
  {
  }

  @Override
  public String getType()
  {
    return CDOProtocolConstants.PROTOCOL_NAME;
  }

  public CDOProtocolSession getSession()
  {
    return (CDOProtocolSession)getInfraStructure();
  }
}
