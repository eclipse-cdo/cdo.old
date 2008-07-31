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
import org.eclipse.net4j.pop.ITaskStream;
import org.eclipse.net4j.pop.delivery.IDelivery;

import java.text.MessageFormat;
import java.util.Date;

/**
 * @author Eike Stepper
 */
public class Delivery extends Element implements IDelivery
{
  private ITaskStream stream;

  private int number;

  private Date date;

  public Delivery(ITaskStream stream, int number, Date date)
  {
    checkArgument(stream, "stream");
    checkArgument(number > 0, "number");
    checkArgument(date, "date");
    this.stream = stream;
    this.date = date;
    this.number = number;
  }

  public int getNumber()
  {
    return number;
  }

  public Date getDate()
  {
    return date;
  }

  public ITaskStream getStream()
  {
    return stream;
  }

  @Override
  public String toString()
  {
    return MessageFormat.format("Delivery[branch={0}, number={1}, date={2,date} {2,time}]", stream.getBranch()
        .getName(), number, date);
  }
}
