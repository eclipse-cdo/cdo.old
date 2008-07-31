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

import org.eclipse.net4j.internal.pop.util.Element;
import org.eclipse.net4j.internal.pop.util.StreamProxy;
import org.eclipse.net4j.pop.IBaseline;
import org.eclipse.net4j.pop.IStream;
import org.eclipse.net4j.pop.code.ITag;

import java.text.MessageFormat;
import java.util.Date;

/**
 * @author Eike Stepper
 */
public class Baseline extends Element implements IBaseline
{
  private StreamProxy<IStream> stream;

  private ITag tag;

  private Date date;

  public Baseline(IStream stream, ITag tag, Date date)
  {
    checkArgument(stream, "stream");
    checkArgument(tag, "tag");
    checkArgument(date, "date");
    this.stream = StreamProxy.proxy(stream);
    this.tag = tag;
    this.date = date;
  }

  public IStream getStream()
  {
    return stream.unproxy();
  }

  public ITag getTag()
  {
    return tag;
  }

  public Date getDate()
  {
    return date;
  }

  @Override
  public String toString()
  {
    return MessageFormat.format("Baseline[tag={0}, date={1,date} {1,time}]", tag.getName(), date);
  }
}
