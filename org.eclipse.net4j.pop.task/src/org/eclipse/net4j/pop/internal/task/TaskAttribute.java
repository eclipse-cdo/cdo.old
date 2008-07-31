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
import org.eclipse.net4j.pop.task.ITaskRepositoryConnector;

import org.eclipse.core.runtime.PlatformObject;

/**
 * @author Eike Stepper
 */
public class TaskAttribute extends PlatformObject implements ITaskAttribute
{
  private ITaskRepositoryConnector connector;

  private String name;

  private Type type;

  private boolean changeable;;

  private boolean required;;

  private boolean many;

  public TaskAttribute(ITaskRepositoryConnector connector, String name, Type type, boolean changeable,
      boolean required, boolean many)
  {
    this.connector = connector;
    this.name = name;
    this.type = type;
    this.changeable = changeable;
    this.required = required;
    this.many = many;
  }

  public ITaskRepositoryConnector getConnector()
  {
    return connector;
  }

  public String getName()
  {
    return name;
  }

  public Type getType()
  {
    return type;
  }

  public boolean isChangeable()
  {
    return changeable;
  }

  public boolean isRequired()
  {
    return required;
  }

  public boolean isMany()
  {
    return many;
  }

  public String[] getChoices()
  {
    return connector.getAttributeChoices(this);
  };
}
