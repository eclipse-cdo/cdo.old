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
package org.eclipse.net4j.examples.mvc.util;


public class Pair<FIRST, SECOND> implements IPair<FIRST, SECOND>
{
  private FIRST first;

  private SECOND second;

  public Pair(FIRST first, SECOND second)
  {
    this.first = first;
    this.second = second;
  }

  public Pair()
  {
    this(null, null);
  }

  public FIRST getFirst()
  {
    return first;
  }

  public void setFirst(FIRST first)
  {
    this.first = first;
  }

  public SECOND getSecond()
  {
    return second;
  }

  public void setSecond(SECOND second)
  {
    this.second = second;
  }

  public boolean equals(Object arg)
  {
    if (arg instanceof Pair)
    {
      Pair that = (Pair)arg;
      return nullSafeEquals(this.first, that.first) && nullSafeEquals(this.second, that.second);
    }

    return false;
  }

  public int hashCode()
  {
    return first.hashCode() ^ second.hashCode();
  }

  public String toString()
  {
    return "Pair(" + first + ", " + second + ")";
  }

  private boolean nullSafeEquals(Object arg1, Object arg2)
  {
    if (arg1 == null)
    {
      return arg2 == null;
    }

    return arg1.equals(arg2);
  }
}
