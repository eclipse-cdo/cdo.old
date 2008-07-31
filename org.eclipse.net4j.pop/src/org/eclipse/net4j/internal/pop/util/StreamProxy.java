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

import org.eclipse.net4j.pop.IStream;
import org.eclipse.net4j.pop.InternalPopManager;
import org.eclipse.net4j.util.ImplementationError;
import org.eclipse.net4j.util.ObjectUtil;

import org.eclipse.mylyn.tasks.core.ITask;

import java.lang.ref.WeakReference;
import java.text.MessageFormat;

/**
 * @author Eike Stepper
 */
public final class StreamProxy<STREAM extends IStream> extends Element
{
  private InternalPopManager manager;

  private ITask task;

  private WeakReference<STREAM> cache;

  // private StreamProxy(IPopManager manager, ITask task)
  // {
  // Element.checkArgument(manager, "manager");
  // Element.checkArgument(task, "task");
  // }

  private StreamProxy(STREAM stream)
  {
    Element.checkArgument(stream, "stream");
    manager = (InternalPopManager)stream.getPop().getManager();
    task = stream.getTask();
    cacheStream(stream);
  }

  private void cacheStream(STREAM element)
  {
    cache = new WeakReference<STREAM>(element);
  }

  public InternalPopManager getManager()
  {
    return manager;
  }

  public ITask getTask()
  {
    return task;
  }

  public boolean isProxyFor(STREAM stream)
  {
    return ObjectUtil.equals(manager, stream.getManager()) && ObjectUtil.equals(task, stream.getTask());
  }

  @Override
  public boolean equals(Object obj)
  {
    if (obj == this)
    {
      return true;
    }

    if (obj instanceof StreamProxy)
    {
      StreamProxy<?> that = (StreamProxy<?>)obj;
      return ObjectUtil.equals(manager, that.manager) && ObjectUtil.equals(task, that.task);
    }

    return false;
  }

  @Override
  public int hashCode()
  {
    return manager.hashCode() ^ task.hashCode();
  }

  @Override
  public String toString()
  {
    return MessageFormat.format("StreamProxy[task={0}]", task.getTaskId());
  }

  public STREAM unproxy()
  {
    if (cache != null)
    {
      STREAM stream = cache.get();
      if (stream != null)
      {
        return stream;
      }
    }

    STREAM stream = resolve();
    if (stream == null)
    {
      throw new ImplementationError("doResolve() must not return null");
    }

    cacheStream(stream);
    return stream;
  }

  @SuppressWarnings("unchecked")
  protected STREAM resolve()
  {
    return (STREAM)getManager().getStream(task);
  }

  public static <STREAM extends IStream> StreamProxy<STREAM> proxy(STREAM stream)
  {
    return new StreamProxy<STREAM>(stream);
  }
}
