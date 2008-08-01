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
package org.eclipse.net4j.pop.util;

import org.eclipse.net4j.util.event.IEvent;
import org.eclipse.net4j.util.event.INotifier;

import org.eclipse.core.runtime.IAdaptable;

/**
 * @author Eike Stepper
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface IElement extends INotifier.Introspection, IAdaptable
{
  /**
   * @author Eike Stepper
   */
  public interface ElementEvent extends IEvent
  {
    public IElement getSourceElement();
  }

  /**
   * @author Eike Stepper
   */
  public interface ReferenceEvent extends ElementEvent
  {
  }

  /**
   * @author Eike Stepper
   */
  public interface AddedEvent extends ReferenceEvent
  {
    public IElement getAddedElement();
  }

  /**
   * @author Eike Stepper
   */
  public interface RemovedEvent extends ReferenceEvent
  {
    public IElement getRemovedElement();
  }
}
