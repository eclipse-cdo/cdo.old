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
package org.eclipse.net4j.examples.server.internal;


import org.eclipse.net4j.spring.Container;


public abstract class AbstractBackendInitializer implements IBackendInitializer
{
  protected String name;

  protected Container parent;

  public AbstractBackendInitializer()
  {
  }

  public Container initializeContainer(String name, Container parent)
  {
    this.name = name;
    this.parent = parent;
    System.out.println("Initializing container " + name + " (" + parent.getFullName() + ")");

    preInitialize();
    Container container = initialize();
    postInitialize();

    return container;
  }

  protected abstract Container initialize();

  protected void preInitialize()
  {
  }

  protected void postInitialize()
  {
  }
}
