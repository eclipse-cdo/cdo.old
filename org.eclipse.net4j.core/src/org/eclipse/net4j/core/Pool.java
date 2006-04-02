/***************************************************************************
 * Copyright (c) 2004, 2005, 2006 Eike Stepper, Fuggerstr. 39, 10777 Berlin, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 **************************************************************************/
package org.eclipse.net4j.core;


import org.eclipse.net4j.spring.Service;


public interface Pool extends Service
{
  public Object get(Object key);

  public void put(Object key, Object object);

  public Class getPooledClass(Object key);

  public Object getDefaultKey();

  public Object get();

  public void put(Object object);

  public Class getPooledClass();
}
