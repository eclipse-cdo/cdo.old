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
package org.eclipse.net4j.pop;

import org.eclipse.net4j.pop.delivery.IDelivery;

import java.util.Date;

/**
 * @author Eike Stepper
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface ITaskStream extends IStream
{
  public IIntegrationStream getParent();

  public IDelivery addDelivery(Date deliveryDate);

  public int getDeliveryCount();

  public IDelivery getDelivery(int index);

  public IDelivery getDeliveryByNumber(int number);

  public IDelivery[] getDeliveries();
}
