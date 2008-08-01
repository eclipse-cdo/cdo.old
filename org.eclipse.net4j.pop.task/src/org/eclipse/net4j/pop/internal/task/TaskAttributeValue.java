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
package org.eclipse.net4j.pop.internal.task;

import org.eclipse.net4j.pop.task.ITaskAttribute;
import org.eclipse.net4j.pop.task.ITaskAttributeValue;

/**
 * @author Eike Stepper
 */
public class TaskAttributeValue implements ITaskAttributeValue
{
  private ITaskAttribute attribute;

  private String value;

  public TaskAttributeValue(ITaskAttribute attribute)
  {
    this.attribute = attribute;
  }

  public ITaskAttribute getAttribute()
  {
    return attribute;
  }

  public String getValue()
  {
    return value;
  }

  public String setValue(String value)
  {
    String oldValue = this.value;
    this.value = value;
    return oldValue;
  }
}
