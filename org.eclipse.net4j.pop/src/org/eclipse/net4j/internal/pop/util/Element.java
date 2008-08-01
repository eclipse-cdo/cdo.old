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
import org.eclipse.net4j.util.event.Notifier;

import org.eclipse.core.runtime.Platform;

/**
 * @author Eike Stepper
 */
public abstract class Element extends Notifier implements IElement
{
  protected Element()
  {
  }

  // TODO Enforce Object protocol
  // @Override
  // public abstract boolean equals(Object obj);
  //
  // @Override
  // public abstract int hashCode();

  @Override
  public abstract String toString();

  @SuppressWarnings("unchecked")
  public Object getAdapter(Class adapterType)
  {
    return Platform.getAdapterManager().getAdapter(this, adapterType);
  }

  public static void checkArgument(Object arg, String argName, Class<?> argClass)
  {
    if (!argClass.isInstance(arg))
    {
      throw new IllegalArgumentException(argName);
    }
  }

  public static void checkArgument(Object arg, String argName)
  {
    if (arg == null)
    {
      throw new IllegalArgumentException(argName);
    }
  }

  public static void checkArgument(boolean expr, String argName)
  {
    if (!expr)
    {
      throw new IllegalArgumentException(argName);
    }
  }
}
