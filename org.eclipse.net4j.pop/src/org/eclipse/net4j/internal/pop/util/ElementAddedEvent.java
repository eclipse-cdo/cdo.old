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
import org.eclipse.net4j.util.event.Event;

/**
 * @author Eike Stepper
 */
public class ElementAddedEvent extends Event implements IElement.RemovedEvent
{
  private static final long serialVersionUID = 1L;

  private IElement removedElement;

  public ElementAddedEvent(IElement sourceElement, IElement removedElement)
  {
    super(sourceElement);
    this.removedElement = removedElement;
  }

  public IElement getSourceElement()
  {
    return (IElement)getSource();
  }

  public IElement getRemovedElement()
  {
    return removedElement;
  }
}
