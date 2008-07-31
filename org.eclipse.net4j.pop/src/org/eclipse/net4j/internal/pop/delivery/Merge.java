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
package org.eclipse.net4j.internal.pop.delivery;

import org.eclipse.net4j.internal.pop.util.Element;
import org.eclipse.net4j.internal.pop.util.StreamProxy;
import org.eclipse.net4j.pop.IStream;
import org.eclipse.net4j.pop.ITaskStream;
import org.eclipse.net4j.pop.delivery.IDelivery;
import org.eclipse.net4j.pop.delivery.IMerge;

import java.text.MessageFormat;
import java.util.Date;

/**
 * @author Eike Stepper
 */
public class Merge extends Element implements IMerge
{
  private IStream stream;

  private Date date;

  private StreamProxy<ITaskStream> deliveryStream;

  private int deliveryNumber;

  public Merge(IStream stream, Date date, IDelivery delivery)
  {
    checkArgument(stream, "stream");
    checkArgument(date, "date");
    checkArgument(delivery, "delivery");
    this.stream = stream;
    this.date = date;
    deliveryStream = StreamProxy.proxy(delivery.getStream());
    deliveryNumber = delivery.getNumber();
  }

  public IStream getStream()
  {
    return stream;
  }

  public Date getDate()
  {
    return date;
  }

  public IDelivery getDelivery()
  {
    ITaskStream taskStream = deliveryStream.unproxy();
    return taskStream.getDeliveryByNumber(deliveryNumber);
  }

  @Override
  public String toString()
  {
    return MessageFormat.format("Merge[branch={0}, date={1,date} {1,time}, task={2}, number={3}]", stream.getBranch()
        .getName(), date, deliveryStream.getTask().getTaskId(), deliveryNumber);
  }
}
