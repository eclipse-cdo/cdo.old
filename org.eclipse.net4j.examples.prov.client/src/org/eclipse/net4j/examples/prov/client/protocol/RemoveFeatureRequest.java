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
package org.eclipse.net4j.examples.prov.client.protocol;


import org.eclipse.net4j.core.impl.AbstractRequestWithConfirmation;
import org.eclipse.net4j.examples.prov.ProvisioningProtocol;


public class RemoveFeatureRequest extends AbstractRequestWithConfirmation
{
  public RemoveFeatureRequest()
  {
  }

  public short getSignalId()
  {
    return ProvisioningProtocol.REMOVE_FEATURE;
  }

  public void request()
  {
  }

  public Object confirm()
  {
    return null;
  }
}
