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
package org.eclipse.net4j.examples.mvc.adapter;


import org.eclipse.net4j.examples.mvc.IBinding;
import org.eclipse.net4j.examples.mvc.aspect.IRecordModelAspect;
import org.eclipse.net4j.examples.mvc.util.NoTargetException;


public abstract class AbstractRecordModelAdapter<TARGET> extends AbstractAdapter<TARGET> implements
        IRecordModelAspect
{
  public AbstractRecordModelAdapter(Factory<TARGET> factory)
  {
    super(factory);
  }

  public int getFieldCount() throws NoTargetException
  {
    return getFieldNames().length;
  }

  @Override
  protected void connectTarget(Class aspect)
  {
  }

  @Override
  protected void disconnectTarget(Class aspect)
  {
  }

  public Object onVerify(String fieldName, Object newValue)
  {
    for (IBinding<TARGET> binding : getBindings(IRecordModelAspect.class))
    {
      newValue = ((IRecordModelAspect)binding).onVerify(fieldName, newValue);
    }

    return newValue;
  }

  public void onAdd(String fieldName, Object item)
  {
    for (IBinding<TARGET> binding : getBindings(IRecordModelAspect.class))
    {
      ((IRecordModelAspect)binding).onAdd(fieldName, item);
    }
  }

  public void onRemove(String fieldName, Object item)
  {
    for (IBinding<TARGET> binding : getBindings(IRecordModelAspect.class))
    {
      ((IRecordModelAspect)binding).onRemove(fieldName, item);
    }
  }

  public void onAdd(String fieldName, Object item, int index)
  {
    for (IBinding<TARGET> binding : getBindings(IRecordModelAspect.class))
    {
      ((IRecordModelAspect)binding).onAdd(fieldName, item, index);
    }
  }

  public void onRemove(String fieldName, Object item, int index)
  {
    for (IBinding<TARGET> binding : getBindings(IRecordModelAspect.class))
    {
      ((IRecordModelAspect)binding).onRemove(fieldName, item, index);
    }
  }

  public void onMove(String fieldName, int fromIndex, int toIndex)
  {
    for (IBinding<TARGET> binding : getBindings(IRecordModelAspect.class))
    {
      ((IRecordModelAspect)binding).onMove(fieldName, fromIndex, toIndex);
    }
  }

  public void onAdd(String fieldName, Object key, Object value)
  {
    for (IBinding<TARGET> binding : getBindings(IRecordModelAspect.class))
    {
      ((IRecordModelAspect)binding).onAdd(fieldName, key, value);
    }
  }

  public void onRemove(String fieldName, Object key, Object value)
  {
    for (IBinding<TARGET> binding : getBindings(IRecordModelAspect.class))
    {
      ((IRecordModelAspect)binding).onRemove(fieldName, key, value);
    }
  }

  public void onSet(String fieldName, Object newValue, Object oldValue)
  {
    for (IBinding<TARGET> binding : getBindings(IRecordModelAspect.class))
    {
      ((IRecordModelAspect)binding).onSet(fieldName, newValue, oldValue);
    }
  }
}
