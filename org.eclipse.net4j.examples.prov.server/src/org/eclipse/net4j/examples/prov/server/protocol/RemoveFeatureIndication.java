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
package org.eclipse.net4j.examples.prov.server.protocol;


import org.eclipse.net4j.core.Indication;
import org.eclipse.net4j.core.impl.AbstractIndicationWithResponse;
import org.eclipse.net4j.examples.prov.ProvisioningProtocol;


public class RemoveFeatureIndication extends AbstractIndicationWithResponse implements Indication
{
  public RemoveFeatureIndication()
  {
  }

  public short getSignalId()
  {
    return ProvisioningProtocol.REMOVE_FEATURE;
  }

  public void indicate()
  {
  }

  public void respond()
  {
  }
}
