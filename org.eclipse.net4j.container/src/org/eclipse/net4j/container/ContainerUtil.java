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
import org.eclipse.net4j.transport.IBufferPool;
import org.eclipse.net4j.transport.IBufferProvider;

import org.eclipse.internal.net4j.transport.BufferFactory;
import org.eclipse.internal.net4j.transport.BufferPool;
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

  public static IBufferProvider createBufferFactory(short bufferCapacity)
  {
    return new BufferFactory(bufferCapacity);
  }

  public static IBufferProvider createBufferFactory()
  {
    return new BufferFactory(BufferUtil.DEFAULT_BUFFER_CAPACITY);
  }

  public static IBufferPool createBufferPool(IBufferProvider factory)
  {
    return new BufferPool(factory);
  }

  public static IBufferPool createBufferPool(short bufferCapacity)
  {
    return createBufferPool(createBufferFactory(bufferCapacity));
  }

  public static IBufferPool createBufferPool()
  {
    return createBufferPool(createBufferFactory());
  }
}
