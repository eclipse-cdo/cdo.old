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
import org.eclipse.net4j.examples.mvc.aspect.ISequenceModelAspect;


public abstract class AbstractSequenceModelAdapter<TARGET> extends AbstractAdapter<TARGET>
        implements ISequenceModelAspect
{
  public AbstractSequenceModelAdapter(Factory<TARGET> factory)
  {
    super(factory);
  }

  public void onRemove(int index, Object item)
  {
    for (IBinding<TARGET> binding : getBindings(ISequenceModelAspect.class))
    {
      ((ISequenceModelAspect)binding).onRemove(index, item);
    }
  }

  public void onAdd(int index, Object item)
  {
    for (IBinding<TARGET> binding : getBindings(ISequenceModelAspect.class))
    {
      ((ISequenceModelAspect)binding).onAdd(index, item);
    }
  }

  public void onSet(int index, Object newItem, Object oldItem)
  {
    for (IBinding<TARGET> binding : getBindings(ISequenceModelAspect.class))
    {
      ((ISequenceModelAspect)binding).onSet(index, newItem, oldItem);
    }
  }

  public void onMove(int fromIndex, int toIndex)
  {
    for (IBinding<TARGET> binding : getBindings(ISequenceModelAspect.class))
    {
      ((ISequenceModelAspect)binding).onMove(fromIndex, toIndex);
    }
  }

  public Object onVerify(int index, Object newItem)
  {
    for (IBinding<TARGET> binding : getBindings(ISequenceModelAspect.class))
    {
      newItem = ((ISequenceModelAspect)binding).onVerify(index, newItem);
    }

    return null;
  }
}
