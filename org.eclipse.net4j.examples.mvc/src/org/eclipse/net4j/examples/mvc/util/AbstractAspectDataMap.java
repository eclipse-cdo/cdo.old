/***************************************************************************
 * Copyright (c) 2004-2006 Eike Stepper, Fuggerstr. 39, 10777 Berlin, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 **************************************************************************/
package org.eclipse.net4j.examples.mvc.util;


import java.util.HashMap;
import java.util.Map;


public abstract class AbstractAspectDataMap<DATA, TARGET>
{
  private Map<Class, DATA> map = new HashMap<Class, DATA>();

  public Class[] getAspects()
  {
    return (Class[])map.keySet().toArray(new Class[map.size()]);
  }

  public boolean hasAspect(Class aspect)
  {
    return map.containsKey(aspect);
  }

  public DATA getAspectData(Class aspect) throws UnknownAspectException
  {
    DATA data = map.get(aspect);

    if (data == null)
    {
      throw new UnknownAspectException(aspect);
    }

    return data;
  }

  public void putAspectData(Class aspect, DATA data) throws DuplicateAspectException
  {
    DATA old = map.put(aspect, data);

    if (old != null)
    {
      throw new DuplicateAspectException(aspect);
    }
  }

  public DATA removeAspectData(Class aspect) throws UnknownAspectException
  {
    DATA data = map.remove(aspect);

    if (data == null)
    {
      throw new UnknownAspectException(aspect);
    }

    return data;
  }

  public DATA ensureAspectData(Class aspect)
  {
    if (hasAspect(aspect))
    {
      return getAspectData(aspect);
    }

    DATA data = createData();
    putAspectData(aspect, data);
    return data;
  }

  protected abstract DATA createData();
}
