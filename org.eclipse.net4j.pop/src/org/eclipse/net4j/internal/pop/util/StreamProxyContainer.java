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
package org.eclipse.net4j.internal.pop.util;

import org.eclipse.net4j.pop.IStream;

import java.lang.reflect.Array;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Eike Stepper
 */
public class StreamProxyContainer<STREAM extends IStream> extends Element
{
  private List<StreamProxy<STREAM>> proxies = new ArrayList<StreamProxy<STREAM>>();

  private Element delegator;

  public StreamProxyContainer(Element delegator)
  {
    this.delegator = delegator;
  }

  public Element getDelegator()
  {
    return delegator;
  }

  public List<StreamProxy<STREAM>> getProxies()
  {
    return proxies;
  }

  public void addElement(STREAM stream)
  {
    StreamProxy<STREAM> proxy = StreamProxy.proxy(stream);
    synchronized (proxies)
    {
      if (proxies.contains(proxy))
      {
        throw new IllegalStateException("Duplicate element: " + stream);
      }

      proxies.add(proxy);
      delegator.fireEvent(new ElementAddedEvent(delegator, stream));
    }
  }

  public void removeElement(STREAM stream)
  {
    synchronized (proxies)
    {
      for (Iterator<StreamProxy<STREAM>> it = proxies.iterator(); it.hasNext();)
      {
        StreamProxy<STREAM> proxy = it.next();
        if (proxy.isProxyFor(stream))
        {
          it.remove();
          delegator.fireEvent(new ElementRemovedEvent(delegator, stream));
          break;
        }
      }
    }
  }

  public int getElementCount()
  {
    synchronized (proxies)
    {
      return proxies.size();
    }
  }

  public STREAM getElement(int index)
  {
    synchronized (proxies)
    {
      return proxies.get(index).unproxy();
    }
  }

  @SuppressWarnings("unchecked")
  public STREAM[] getElements(Class<STREAM> componentType)
  {
    synchronized (proxies)
    {
      STREAM[] prototype = (STREAM[])Array.newInstance(componentType, proxies.size());
      for (int i = 0; i < prototype.length; i++)
      {
        prototype[i] = proxies.get(i).unproxy();
      }

      return prototype;
    }
  }

  @Override
  public String toString()
  {
    return MessageFormat.format("{0}[{1}]", getClass().getSimpleName(), proxies);
  }
}
