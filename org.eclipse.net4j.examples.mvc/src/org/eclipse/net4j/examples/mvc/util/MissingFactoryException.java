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


import java.util.Set;


public class MissingFactoryException extends RuntimeException
{
  private static final long serialVersionUID = 3257846588767680824L;

  private Set possibleFactories;

  private Class aspect;

  private Class targetClass;

  public MissingFactoryException(Class aspect, Class targetClass, String message)
  {
    super(message);
    this.aspect = aspect;
    this.targetClass = targetClass;
  }

  public MissingFactoryException(Class aspect, Class targetClass)
  {
    this(aspect, targetClass, "No factory for aspect " + aspect + " and targetClass " + targetClass);
  }

  public Class getAspect()
  {
    return aspect;
  }

  public Set getPossibleFactories()
  {
    return possibleFactories;
  }

  public Class getTargetClass()
  {
    return targetClass;
  }
}
