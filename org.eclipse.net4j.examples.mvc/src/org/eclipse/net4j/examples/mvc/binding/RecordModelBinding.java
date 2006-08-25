/***************************************************************************
 * Copyright (c) 2004, 2005, 2006 Eike Stepper, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 **************************************************************************/
package org.eclipse.net4j.examples.mvc.binding;


import org.eclipse.net4j.examples.mvc.IAdapter;
import org.eclipse.net4j.examples.mvc.IController;
import org.eclipse.net4j.examples.mvc.aspect.IRecordModelAspect;
import org.eclipse.net4j.examples.mvc.util.NoAdapterException;


public class RecordModelBinding<TARGET> extends AbstractBinding<TARGET> implements
        IRecordModelAspect
{
  public RecordModelBinding(IController<TARGET> controller, String targetName)
  {
    super(controller, targetName);
  }

  public Class getAspect()
  {
    return IRecordModelAspect.class;
  }

  public IRecordModelAspect getRecordModelAdapter() throws NoAdapterException
  {
    IAdapter<TARGET> adapter = getAdapter();

    if (adapter == null)
    {
      throw new NoAdapterException(this);
    }

    return (IRecordModelAspect)adapter;
  }

  public int getFieldCount()
  {
    return getRecordModelAdapter().getFieldCount();
  }

  public String[] getFieldNames()
  {
    return getRecordModelAdapter().getFieldNames();
  }

  public Class getFieldType(String fieldName)
  {
    return getRecordModelAdapter().getFieldType(fieldName);
  }

  public Object getValue(String fieldName)
  {
    return getRecordModelAdapter().getValue(fieldName);
  }

  public void setValue(String fieldName, Object value)
  {
    getRecordModelAdapter().setValue(fieldName, value);
  }

  public void onAdd(String fieldName, Object item)
  {
  }

  public void onAdd(String fieldName, Object key, Object value)
  {
  }

  public void onAdd(String fieldName, Object item, int index)
  {
  }

  public void onMove(String fieldName, int fromIndex, int toIndex)
  {
  }

  public void onRemove(String fieldName, Object item)
  {
  }

  public void onRemove(String fieldName, Object key, Object value)
  {
  }

  public void onRemove(String fieldName, Object item, int index)
  {
  }

  public void onSet(String fieldName, Object newValue, Object oldValue)
  {
  }

  public Object onVerify(String fieldName, Object newValue)
  {
    return newValue;
  }
}
