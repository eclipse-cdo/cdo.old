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
package org.eclipse.net4j.internal.pop;

import org.eclipse.net4j.internal.pop.delivery.Delivery;
import org.eclipse.net4j.internal.pop.util.ElementContainer;
import org.eclipse.net4j.pop.IBaseline;
import org.eclipse.net4j.pop.IIntegrationStream;
import org.eclipse.net4j.pop.ITaskStream;
import org.eclipse.net4j.pop.code.IBranch;
import org.eclipse.net4j.pop.delivery.IDelivery;

import org.eclipse.mylyn.tasks.core.ITask;

import java.text.MessageFormat;
import java.util.Date;
import java.util.List;

/**
 * @author Eike Stepper
 */
public class TaskStream extends Stream implements ITaskStream
{
  protected ElementContainer<IDelivery> deliveryContainer = new ElementContainer<IDelivery>(this);

  public TaskStream(IBaseline baseline, IBranch branch, ITask task)
  {
    super(baseline, branch, task);
  }

  @Override
  public IIntegrationStream getParent()
  {
    return (IIntegrationStream)super.getParent();
  }

  public IDelivery addDelivery(Date deliveryDate)
  {
    checkArgument(deliveryDate, "deliveryDate");
    List<IDelivery> elements = deliveryContainer.getElements();
    synchronized (elements)
    {
      IDelivery delivery = new Delivery(this, elements.size() + 1, deliveryDate);
      deliveryContainer.addElement(delivery);
      return delivery;
    }
  }

  public IDelivery getDeliveryByNumber(int number)
  {
    checkArgument(number > 0, "number");
    for (IDelivery delivery : getDeliveries())
    {
      if (delivery.getNumber() == number)
      {
        return delivery;
      }
    }

    return null;
  }

  public IDelivery getDelivery(int index)
  {
    checkArgument(index >= 0, "index");
    return deliveryContainer.getElement(index);
  }

  public int getDeliveryCount()
  {
    return deliveryContainer.getElementCount();
  }

  public IDelivery[] getDeliveries()
  {
    return deliveryContainer.getElements(IDelivery.class);
  }

  @Override
  public String toString()
  {
    return MessageFormat.format("TaskStream[branch={0}, task={1}]", getBranch().getName(), getTask().getTaskId());
  }
}
