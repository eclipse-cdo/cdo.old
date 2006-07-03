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


public class UnknownAspectException extends RuntimeException
{
  private static final long serialVersionUID = 3976741376002044471L;

  private Class aspect;

  public UnknownAspectException(Class aspect, String message)
  {
    super(message);
    this.aspect = aspect;
  }

  public UnknownAspectException(Class aspect)
  {
    this(aspect, "Unknown aspect " + aspect);
  }

  public Class getAspect()
  {
    return aspect;
  }
}
