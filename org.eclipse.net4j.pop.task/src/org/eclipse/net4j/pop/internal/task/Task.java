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

import org.eclipse.net4j.pop.task.ITask;
import org.eclipse.net4j.pop.task.ITaskAttribute;
import org.eclipse.net4j.pop.task.ITaskAttributeValue;
import org.eclipse.net4j.pop.task.ITaskComment;

import org.eclipse.core.runtime.PlatformObject;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Eike Stepper
 */
public class Task extends PlatformObject implements ITask
{
  private TaskRepository repository;

  private String id;

  private Map<ITaskAttribute, ITaskAttributeValue> attributeValues;

  private IncomingState incomingState;

  private OutgoingState outgoingState;

  public Task(TaskRepository repository)
  {
    this.repository = repository;
    incomingState = IncomingState.CLEAN;
    outgoingState = OutgoingState.NEW;
  }

  public TaskRepository getRepository()
  {
    return repository;
  }

  public String getID() throws IllegalStateException
  {
    if (outgoingState == OutgoingState.NEW)
    {
      throw new IllegalStateException("Task is new");
    }

    return id;
  }

  public String getTitle()
  {
    ITaskAttribute attribute = repository.getConnector().getTitleAttribute();
    return getValue(attribute);
  }

  public String setTitle(String title)
  {
    ITaskAttribute attribute = repository.getConnector().getTitleAttribute();
    return setValue(attribute, title);
  }

  public ITaskAttributeValue getAttributeValue(ITaskAttribute attribute)
  {
    initAttributeValues();
    return attributeValues.get(attribute);
  }

  public ITaskAttributeValue[] getAttributeValues()
  {
    // TODO Implement Task.getAttributeValues()
    throw new UnsupportedOperationException("Not yet implemented");
  }

  public void setAttributeValues(ITaskAttributeValue[] taskAttributeValues)
  {
    // TODO Implement Task.setAttributeValues(taskAttributeValues)
    throw new UnsupportedOperationException("Not yet implemented");
  }

  public ITaskComment[] getComments()
  {
    // TODO Implement Task.getComments()
    throw new UnsupportedOperationException("Not yet implemented");
  }

  public ITaskComment addComment(String message)
  {
    // TODO Implement Task.addComment(message)
    throw new UnsupportedOperationException("Not yet implemented");
  }

  public IncomingState getIncomingState()
  {
    return incomingState;
  }

  public OutgoingState getOutgoingState()
  {
    return outgoingState;
  }

  public void sync()
  {
    switch (incomingState)
    {
    case STALE:
    case CLEAN:
      doSync();
      incomingState = IncomingState.CLEAN;
    }
  }

  public void save()
  {
    switch (outgoingState)
    {
    case NEW:
    case MODIFIED:
      doSave();
      outgoingState = OutgoingState.CLEAN;
    }
  }

  private void doSync()
  {
    // TODO Implement Task.doSync()
    throw new UnsupportedOperationException("Not yet implemented");
  }

  private void doSave()
  {
    // TODO Implement Task.doSave()
    throw new UnsupportedOperationException("Not yet implemented");
  }

  private void initAttributeValues()
  {
    if (attributeValues == null)
    {
      attributeValues = new HashMap<ITaskAttribute, ITaskAttributeValue>();
    }
  }

  private String getValue(ITaskAttribute attribute)
  {
    ITaskAttributeValue attributeValue = getAttributeValue(attribute);
    if (attributeValue == null)
    {
      return null;
    }

    return attributeValue.getValue();
  }

  private String setValue(ITaskAttribute attribute, String value)
  {
    if (!attribute.isChangeable() && outgoingState != OutgoingState.NEW)
    {
      throw new IllegalStateException("Attribute is not changeable: " + attribute.getName());
    }

    ITaskAttributeValue attributeValue = getAttributeValue(attribute);
    if (attributeValue == null)
    {
      attributeValue = new TaskAttributeValue(attribute);
      attributeValues.put(attribute, attributeValue);
    }

    return attributeValue.setValue(value);
  }
}
