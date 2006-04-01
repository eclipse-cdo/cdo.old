/*******************************************************************************
 * Copyright (c) 2004, 2005, 2006 Eike Stepper, Sympedia Methods and Tools.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Eike Stepper - initial API and implementation
 *******************************************************************************/
package org.eclipse.net4j.core.impl;


import org.eclipse.net4j.core.BufferPool;
import org.eclipse.net4j.spring.impl.ServiceImpl;

import java.lang.ref.SoftReference;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;


public class BufferPoolImpl extends ServiceImpl implements BufferPool
{
  public static final int DEFAULT_BUFFER_SIZE = 4096;

  protected int bufferSize = DEFAULT_BUFFER_SIZE;

  private transient Queue<SoftReference<BufferImpl>> queue = new ConcurrentLinkedQueue();

  public BufferPoolImpl()
  {
  }

  public int getBufferSize()
  {
    return bufferSize;
  }

  public void setBufferSize(int bufferSize)
  {
    doSet("bufferSize", bufferSize);
  }

  public BufferImpl getBuffer()
  {
    BufferImpl buffer;
    do
    {
      SoftReference<BufferImpl> ref = queue.poll();
      if (ref == null)
      {
        return newBuffer();
      }

      buffer = ref.get();
    } while (buffer == null);

    buffer.clear();
    return buffer;
  }

  public void releaseBuffer(BufferImpl buffer)
  {
    queue.add(new SoftReference<BufferImpl>(buffer));
  }

  protected BufferImpl newBuffer()
  {
    return new BufferImpl(bufferSize);
  }
}
