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
package org.eclipse.emf.cdo.client.protocol;


import org.eclipse.net4j.core.impl.AbstractIndication;

import org.eclipse.emf.cdo.core.CdoResSignals;


public class ResourceChangedIndication extends AbstractIndication
{
  public short getSignalId()
  {
    return CdoResSignals.RESOURCE_CHANGED;
  }

  public void indicate()
  {
    int changeKind = receiveInt();
    int rid = receiveInt();
    String path = receiveString();
    ((CdoResClientProtocolImpl) getProtocol()).resourceChanged(getChannel(), rid,path, changeKind);
  }
}
