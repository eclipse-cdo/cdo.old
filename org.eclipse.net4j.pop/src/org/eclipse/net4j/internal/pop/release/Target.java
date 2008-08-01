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
package org.eclipse.net4j.internal.pop.release;

import org.eclipse.net4j.internal.pop.util.Element;
import org.eclipse.net4j.pop.code.ITag;
import org.eclipse.net4j.pop.release.ITarget;

import java.util.Date;

/**
 * @author Eike Stepper
 */
public abstract class Target extends Element implements ITarget
{
  private ITag tag;

  private Date date;

  protected Target(ITag tag, Date date)
  {
    checkArgument(tag, "tag");
    this.tag = tag;
    this.date = date;
  }

  public ITag getTag()
  {
    return tag;
  }

  public Date getDate()
  {
    return date;
  }
}
