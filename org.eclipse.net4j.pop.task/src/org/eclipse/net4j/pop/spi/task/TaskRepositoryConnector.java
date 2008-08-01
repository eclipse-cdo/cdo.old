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
package org.eclipse.net4j.pop.spi.task;

import org.eclipse.net4j.pop.internal.task.TaskAttribute;
import org.eclipse.net4j.pop.task.ITaskAttribute;
import org.eclipse.net4j.pop.task.ITaskRepositoryConnector;
import org.eclipse.net4j.util.ObjectUtil;
import org.eclipse.net4j.util.StringUtil;

import org.eclipse.core.runtime.PlatformObject;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Eike Stepper
 */
public abstract class TaskRepositoryConnector extends PlatformObject implements ITaskRepositoryConnector
{
  private String name;

  private Map<String, ITaskAttribute> attributes = new HashMap<String, ITaskAttribute>();

  private ITaskAttribute titleAttribute;

  private ITaskAttribute stateAttribute;

  protected TaskRepositoryConnector(String name)
  {
    this.name = name;
    initAttributes();
    if (stateAttribute == null)
    {
      throw new IllegalStateException("State attribute missing");
    }
  }

  protected abstract void initAttributes();

  public String getName()
  {
    return name;
  }

  public Map<String, ITaskAttribute> getAttributes()
  {
    return attributes;
  }

  public ITaskAttribute getTitleAttribute()
  {
    return titleAttribute;
  }

  public ITaskAttribute getStateAttribute()
  {
    return stateAttribute;
  }

  public int compareTo(ITaskRepositoryConnector o)
  {
    return StringUtil.compare(name, o.getName());
  }

  @Override
  public boolean equals(Object obj)
  {
    if (obj == this)
    {
      return true;
    }

    if (obj instanceof ITaskRepositoryConnector)
    {
      ITaskRepositoryConnector that = (ITaskRepositoryConnector)obj;
      return ObjectUtil.equals(name, that.getName());
    }

    return false;
  }

  @Override
  public int hashCode()
  {
    return ObjectUtil.hashCode(name);
  }

  @Override
  public String toString()
  {
    return name;
  }

  protected final ITaskAttribute addBooleanAttribute(String name, boolean changeable, boolean required, boolean many)
  {
    return addAttribute(name, ITaskAttribute.Type.BOOLEAN, changeable, required, many);
  }

  protected final ITaskAttribute addIntegerAttribute(String name, boolean changeable, boolean required, boolean many)
  {
    return addAttribute(name, ITaskAttribute.Type.INTEGER, changeable, required, many);
  }

  protected final ITaskAttribute addStringAttribute(String name, boolean changeable, boolean required, boolean many)
  {
    return addAttribute(name, ITaskAttribute.Type.STRING, changeable, required, many);
  }

  protected final ITaskAttribute addDateAttribute(String name, boolean changeable, boolean required, boolean many)
  {
    return addAttribute(name, ITaskAttribute.Type.DATE, changeable, required, many);
  }

  protected final ITaskAttribute addChoiceAttribute(String name, boolean changeable, boolean required, boolean many)
  {
    return addAttribute(name, ITaskAttribute.Type.CHOICE, changeable, required, many);
  }

  protected final ITaskAttribute addTaskAttribute(String name, boolean changeable, boolean required, boolean many)
  {
    return addAttribute(name, ITaskAttribute.Type.TASK, changeable, required, many);
  }

  protected final ITaskAttribute addUserAttribute(String name, boolean changeable, boolean required, boolean many)
  {
    return addAttribute(name, ITaskAttribute.Type.USER, changeable, required, many);
  }

  protected final ITaskAttribute addTitleAttribute(String name)
  {
    return titleAttribute = addAttribute(name, ITaskAttribute.Type.STRING, true, true, false);
  }

  protected final ITaskAttribute addStateAttribute(String name)
  {
    return stateAttribute = addAttribute(name, ITaskAttribute.Type.CHOICE, true, true, false);
  }

  private ITaskAttribute addAttribute(String name, ITaskAttribute.Type type, boolean changeable, boolean required,
      boolean many)
  {
    ITaskAttribute attribute = new TaskAttribute(this, name, type, changeable, required, many);
    attributes.put(attribute.getName(), attribute);
    return attribute;
  }
}
