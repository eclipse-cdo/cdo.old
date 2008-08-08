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
package org.eclipse.net4j.pop.base.util;

/**
 * @author Eike Stepper
 */
public final class Argument
{
  private Argument()
  {
  }

  public static void check(Object arg, String argName, Class<?> argClass)
  {
    if (!argClass.isInstance(arg))
    {
      throw new IllegalArgumentException(argName);
    }
  }

  public static void check(Object arg, String argName)
  {
    if (arg == null)
    {
      throw new IllegalArgumentException(argName);
    }
  }

  public static void check(boolean expr, String argName)
  {
    if (!expr)
    {
      throw new IllegalArgumentException(argName);
    }
  }
}
