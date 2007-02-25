/***************************************************************************
 * Copyright (c) 2004-2007 Eike Stepper, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 **************************************************************************/
package org.eclipse.net4j.container;

import org.eclipse.net4j.internal.container.ContainerImpl;
import org.eclipse.net4j.transport.BufferPool;
import org.eclipse.net4j.transport.BufferProvider;

import org.eclipse.internal.net4j.transport.BufferFactoryImpl;
import org.eclipse.internal.net4j.transport.BufferPoolImpl;
import org.eclipse.internal.net4j.transport.BufferUtil;

import java.io.File;

/**
 * @author Eike Stepper
 */
public final class ContainerUtil
{
  private ContainerUtil()
  {
  }

  public static Container createContainer()
  {
    return new ContainerImpl();
  }

  public static Container createContainer(File file)
  {
    return new ContainerImpl(file);
  }

  public static BufferProvider createBufferFactory(short bufferCapacity)
  {
    return new BufferFactoryImpl(bufferCapacity);
  }

  public static BufferProvider createBufferFactory()
  {
    return new BufferFactoryImpl(BufferUtil.DEFAULT_BUFFER_CAPACITY);
  }

  public static BufferPool createBufferPool(BufferProvider factory)
  {
    return new BufferPoolImpl(factory);
  }

  public static BufferPool createBufferPool(short bufferCapacity)
  {
    return createBufferPool(createBufferFactory(bufferCapacity));
  }

  public static BufferPool createBufferPool()
  {
    return createBufferPool(createBufferFactory());
  }
}
