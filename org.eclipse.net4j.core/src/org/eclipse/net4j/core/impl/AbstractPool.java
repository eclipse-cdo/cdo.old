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
package org.eclipse.net4j.core.impl;


import org.eclipse.net4j.core.Pool;
import org.eclipse.net4j.spring.impl.ServiceImpl;
import org.eclipse.net4j.util.ImplementationError;
import org.eclipse.net4j.util.StringHelper;
import org.eclipse.net4j.util.thread.Worker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;


public abstract class AbstractPool extends ServiceImpl implements Pool
{
  public static final int DEFAULT_MAXIMUM_CAPACITY = 100;

  public static final int DEFAULT_MINIMUM_CAPACITY = 10;

  public static final boolean DEFAULT_VALIDATING = false;

  public static final long DEFAULT_WORKER_INTERVAL = 1000;

  protected Map checkouts = new HashMap(211);

  protected Map keyToQueueMap = new HashMap(211);

  protected int level;

  protected int maximumCapacity = DEFAULT_MAXIMUM_CAPACITY;

  protected int minimumCapacity = DEFAULT_MINIMUM_CAPACITY;

  protected Random randomGenerator = new Random(System.currentTimeMillis());

  protected List sortedWeightsArray = new ArrayList(10);

  protected boolean validating = DEFAULT_VALIDATING;

  protected Cleaner worker;

  protected long workerInterval = DEFAULT_WORKER_INTERVAL;

  /**
   * @param key
   * @return
   */
  protected abstract Class doGetPooledClass(Object key);

  public Object get()
  {
    Object key = getDefaultKey();
    return get(key);
  }

  public Object get(Object key)
  {
    if (key == null)
    {
      throw new IllegalArgumentException("key is not non-null");
    }

    synchronized (this)
    {
      Queue queue = getQueue(key);
      queue.incWeight();

      Object object;
      if (queue.isEmpty())
      {
        try
        {
          object = newPooled(key);
        }
        catch (Exception ex)
        {
          error("Error while creating pool element for key " + key, ex);
          return null;
        }

        queue.enqueue(object);
        ++level;

        if (isDebugEnabled())
          debug("created new object " + getPooledLabel(object) + " (queues = " + getPoolState()
                  + ")");
      }

      object = queue.dequeue();
      --level;

      if (validating)
      {
        checkouts.put(object, object);
      }

      if (isDebugEnabled())
        debug("checked out " + getPooledLabel(object) + " (queues = " + getPoolState() + ")");
      return object;
    }
  }

  public int getLevel()
  {
    synchronized (this)
    {
      return level;
    }
  }

  public Class getPooledClass()
  {
    Object key = getDefaultKey();
    return getPooledClass(key);
  }

  public Class getPooledClass(Object key)
  {
    if (key == null)
    {
      throw new IllegalArgumentException("key is not non-null");
    }

    return doGetPooledClass(key);
  }

  public void put(Object object)
  {
    Object key = getDefaultKey();
    put(key, object);
  }

  public void put(Object key, Object object)
  {
    if (key == null)
    {
      throw new IllegalArgumentException("key is not non-null");
    }

    if (object == null)
    {
      throw new IllegalArgumentException("object is not non-null");
    }

    // System.out.println("put(" + key + ", " + getPooledLabel(object));

    if (isDebugEnabled())
      debug("checking in " + getPooledLabel(object) + " (queues = " + getPoolState() + ")");

    Object objectToUse = object;

    if (validating)
    {
      Class base = getPooledClass(key);
      if (!base.isInstance(objectToUse))
      {
        String msg = "object " + getPooledLabel(objectToUse) + " does not inherit class "
                + doGetPooledClass(key);
        fatal(msg);
        throw new ImplementationError(msg);
      }
    }

    synchronized (this)
    {
      if (validating)
      {
        Object checkout = checkouts.remove(objectToUse);
        if (checkout == null)
        {
          String msg = "object " + getPooledLabel(objectToUse) + " is not checked out";
          fatal(msg);
          throw new ImplementationError(msg);
        }

        objectToUse = checkout;
      }

      Queue queue = (Queue)keyToQueueMap.get(key);
      if (queue == null)
      {
        if (isDebugEnabled()) debug("Creating queue " + key);
        queue = new Queue(key);
        keyToQueueMap.put(key, queue);
      }

      queue.enqueue(objectToUse);
      ++level;
    }
  }

  public int getMaximumCapacity()
  {
    return maximumCapacity;
  }

  public int getMinimumCapacity()
  {
    return minimumCapacity;
  }

  public long getWorkerInterval()
  {
    return workerInterval;
  }

  protected void activate() throws Exception
  {
    super.activate();
    worker = new Cleaner();
    worker.setDaemon(true);
    worker.startup();
  }

  protected void deactivate() throws Exception
  {
    worker.shutdown(200);
    worker = null;
    super.deactivate();
  }

  public static String getPooledLabel(Object pooled)
  {
    return pooled.getClass().getName() + "(id=" + pooled.hashCode() + "): "
            + StringHelper.removePrefix(pooled.toString(), "java.nio.DirectByteBuffer");
  }

  public String getPoolState()
  {
    boolean first = true;
    StringBuffer buffer = new StringBuffer();

    for (Iterator it = keyToQueueMap.values().iterator(); it.hasNext();)
    {
      Queue queue = (Queue)it.next();
      buffer.append((first ? "" : ", ") + queue.getKey() + ":" + queue.size());
      first = false;
    }

    return buffer.toString();
  }

  protected class Cleaner extends Worker
  {

    public Cleaner()
    {
      super(getFullBeanName() + ".Cleaner");
    }

    public long doWorkStep(int progress)
    {
      synchronized (AbstractPool.this)
      {
        int level = getLevel();

        if (level < minimumCapacity)
        {
          enforcePolicy(minimumCapacity - level);
        }
        else if (level > maximumCapacity)
        {
          enforcePolicy(maximumCapacity - level);
        }

        doAging();
      }

      return workerInterval;
    }
  }

  protected class Queue implements Comparable
  {
    protected Object key;

    protected int weight;

    protected LinkedList list = new LinkedList();

    public Queue(Object key)
    {
      this.key = key;
    }

    public Iterator iterator()
    {
      return list.iterator();
    }

    public void enqueue(Object object)
    {
      synchronized (list)
      {
        list.addFirst(object);
      }
    }

    public Object dequeue()
    {
      synchronized (list)
      {
        Object object = list.removeFirst();
        return object;
      }
    }

    /**
     * @return
     */
    public boolean isEmpty()
    {
      return list.isEmpty();
    }

    /**
     * @return Returns the weight.
     */
    public int getWeight()
    {
      return weight;
    }

    public void incWeight()
    {
      ++weight;
    }

    public void decWeight()
    {
      if (weight > 0) --weight;
    }

    /**
     * @return Returns the key.
     */
    public Object getKey()
    {
      return key;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    public int compareTo(Object o)
    {
      if (o == null || !(o instanceof Queue))
      {
        String msg = "Wrong object: " + o;
        fatal(msg);
        throw new ImplementationError(msg);
      }

      int w = ((Queue)o).getWeight();
      if (weight < w)
      {
        return -1;
      }
      else if (weight > w)
      {
        return 1;
      }

      return 0;
    }

    public int size()
    {
      return list.size();
    }
  }

  /**
   * 
   */
  protected void doAging()
  {
    if (sortedWeightsArray.size() > 0)
    {
      int index = randomGenerator.nextInt(sortedWeightsArray.size());
      Queue queue = (Queue)sortedWeightsArray.get(index);
      queue.decWeight();

      // if (isDebugEnabled()) debug("Aged queue " + queue);
    }
  }

  protected void enforcePolicy(int amount)
  {
    Queue queue = null;

    switch (sortedWeightsArray.size())
    {
    case 0:
      return;
    case 1:
      queue = (Queue)sortedWeightsArray.get(0);
      break;
    default:
      Collections.sort(sortedWeightsArray);
    }

    if (amount > 0)
    {
      if (queue == null)
      {
        queue = (Queue)sortedWeightsArray.get(sortedWeightsArray.size() - 1);
      }

      grow(queue, 1);
    }
    else
    {
      if (queue == null)
      {
        queue = (Queue)sortedWeightsArray.get(0);
      }

      shrink(queue, 1);
    }
  }

  protected Queue getQueue(Object key)
  {
    Queue queue = (Queue)keyToQueueMap.get(key);
    if (queue == null)
    {
      queue = new Queue(key);
      keyToQueueMap.put(key, queue);
      sortedWeightsArray.add(queue);
    }

    return queue;
  }

  /**
   * Expects to be called from code synchronized on this DefaultPool.
   * 
   * @param amount
   */
  protected void grow(Queue queue, int amount)
  {
    for (int i = 0; i < amount && level < maximumCapacity; i++)
    {
      Object key = queue.getKey();

      try
      {
        Object pooled = newPooled(key);
        if (isDebugEnabled())
        {
          debug("created new object " + getPooledLabel(pooled) + " (queues = " + getPoolState()
                  + ")");
        }

        queue.enqueue(pooled);
        ++level;
      }
      catch (Exception ex)
      {
        error("Error while creating pool element for key " + key, ex);
        return;
      }
    }
  }

  /**
   * @param key
   * @return
   */
  protected abstract Object newPooled(Object key) throws Exception;

  /**
   * Expects to be called from code synchronized on this DefaultPool.
   * 
   * @param amount
   */
  protected void shrink(Queue queue, int amount)
  {
    for (int i = 0; i < amount && level > minimumCapacity; i++)
    {
      queue.dequeue();
      --level;
    }
  }

  /**
   * @return
   */
  public Object getDefaultKey()
  {
    return this;
  }

  /**
   * @return Returns the validating.
   */
  public boolean isValidating()
  {
    return validating;
  }

  /**
   * @param validating
   *          The validating to set.
   */
  public void setValidating(boolean validating)
  {
    doSet("validating", validating);
  }

  /**
   * @param maximumCapacity
   *          The maximumCapacity to set.
   */
  public void setMaximumCapacity(int maximumCapacity)
  {
    doSet("maximumCapacity", maximumCapacity);
  }

  /**
   * @param minimumCapacity
   *          The minimumCapacity to set.
   */
  public void setMinimumCapacity(int minimumCapacity)
  {
    doSet("minimumCapacity", minimumCapacity);
  }

  /**
   * @param workerInterval
   *          The workerInterval to set.
   */
  public void setWorkerInterval(long workerInterval)
  {
    doSet("workerInterval", workerInterval);
  }
}
