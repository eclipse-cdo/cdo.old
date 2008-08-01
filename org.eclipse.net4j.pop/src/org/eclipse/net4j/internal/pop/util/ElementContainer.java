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

import org.eclipse.net4j.pop.util.IElement;

import java.lang.reflect.Array;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Eike Stepper
 */
public class ElementContainer<ELEMENT extends IElement> extends Element
{
  private List<ELEMENT> elements = new ArrayList<ELEMENT>();

  private Element delegator;

  public ElementContainer(Element delegator)
  {
    this.delegator = delegator;
  }

  public Element getDelegator()
  {
    return delegator;
  }

  public void addElement(ELEMENT element)
  {
    synchronized (elements)
    {
      if (elements.contains(element))
      {
        throw new IllegalStateException("Duplicate element: " + element);
      }

      elements.add(element);
      delegator.fireEvent(new ElementAddedEvent(delegator, element));
    }
  }

  public void removeElement(ELEMENT element)
  {
    synchronized (elements)
    {
      if (!elements.remove(element))
      {
        delegator.fireEvent(new ElementRemovedEvent(delegator, element));
      }
    }
  }

  public int getElementCount()
  {
    synchronized (elements)
    {
      return elements.size();
    }
  }

  public ELEMENT getElement(int index)
  {
    synchronized (elements)
    {
      return elements.get(index);
    }
  }

  public List<ELEMENT> getElements()
  {
    return elements;
  }

  @SuppressWarnings("unchecked")
  public ELEMENT[] getElements(Class<ELEMENT> componentType)
  {
    synchronized (elements)
    {
      ELEMENT[] prototype = (ELEMENT[])Array.newInstance(componentType, elements.size());
      return elements.toArray(prototype);
    }
  }

  @Override
  public String toString()
  {
    return MessageFormat.format("{0}[{1}]", getClass().getSimpleName(), elements);
  }
}
