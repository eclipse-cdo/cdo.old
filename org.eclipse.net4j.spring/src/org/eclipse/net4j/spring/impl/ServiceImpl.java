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
package org.eclipse.net4j.spring.impl;


import org.eclipse.net4j.spring.InactiveException;
import org.eclipse.net4j.spring.Loggable;
import org.eclipse.net4j.spring.NotStoppedException;
import org.eclipse.net4j.spring.Service;
import org.eclipse.net4j.spring.StateListener;
import org.eclipse.net4j.spring.ValidationException;
import org.eclipse.net4j.util.BitHelper;
import org.eclipse.net4j.util.ImplementationError;
import org.eclipse.net4j.util.fsm.StateMachine;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class ServiceImpl extends LoggableImpl implements Service, StateListener, InitializingBean,
    DisposableBean, ApplicationListener
{
  protected static final int STATE_BITS = 3;

  protected static final int STATE_PAD = 0;

  protected static final int STATE_MASK = BitHelper.getMask(STATE_BITS, STATE_PAD);

  protected static final int SINGLETON_BITS = 1;

  protected static final int SINGLETON_PAD = STATE_PAD + STATE_BITS;

  protected static final int SINGLETON_MASK = BitHelper.getMask(SINGLETON_BITS, SINGLETON_PAD);

  protected static final int AUTOSTART_ON_BITS = 1;

  protected static final int AUTOSTART_ON_PAD = SINGLETON_PAD + SINGLETON_BITS;

  protected static final int AUTOSTART_ON_MASK = BitHelper.getMask(AUTOSTART_ON_BITS,
      AUTOSTART_ON_PAD);

  protected static final int AUTOSTART_OFF_BITS = 1;

  protected static final int AUTOSTART_OFF_PAD = AUTOSTART_ON_PAD + AUTOSTART_ON_BITS;

  protected static final int AUTOSTART_OFF_MASK = BitHelper.getMask(AUTOSTART_OFF_BITS,
      AUTOSTART_OFF_PAD);

  //  protected static final int SINGLETON_MASK = 0x08;
  //
  //  protected static final int AUTOSTART_ON_MASK = 0x10;
  //
  //  protected static final int AUTOSTART_OFF_MASK = 0x20;

  protected static final int SERVICE_BITS = AUTOSTART_OFF_PAD + AUTOSTART_OFF_BITS;

  protected transient int flags;

  private transient List listeners;

  private static Map prototypeCounters = new HashMap();

  private static StateMachine stateMachine = new ServiceStateMachine();

  public ServiceImpl()
  {
    setSingleton(true);
    setState(ServiceStateMachine.STATE_STOPPED);
  }

  public boolean isSingleton()
  {
    return (flags & SINGLETON_MASK) != 0;
  }

  private void setSingleton(boolean singleton)
  {
    if (singleton)
    {
      flags |= SINGLETON_MASK;
    }
    else
    {
      flags &= ~SINGLETON_MASK;
    }
  }

  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException
  {
    super.setApplicationContext(applicationContext);
    String name = getBeanName();

    // Assume singleton for tests (beanName==null)
    setSingleton(name == null ? true : applicationContext.isSingleton(name));
  }

  public boolean isAutoStart()
  {
    if ((flags & AUTOSTART_ON_MASK) != 0)
    {
      return true;
    }

    if ((flags & AUTOSTART_OFF_MASK) != 0)
    {
      return false;
    }

    return isSingleton();
  }

  public void setAutoStart(boolean autoStart)
  {
    if (autoStart)
    {
      flags &= ~AUTOSTART_OFF_MASK;
      flags |= AUTOSTART_ON_MASK;
    }
    else
    {
      flags &= ~AUTOSTART_ON_MASK;
      flags |= AUTOSTART_OFF_MASK;
    }
  }

  public int getState()
  {
    return flags & STATE_MASK;
  }

  public void setState(int state)
  {
    flags &= ~STATE_MASK;
    flags |= state & STATE_MASK;
  }

  public boolean isActive()
  {
    return getState() == ServiceStateMachine.STATE_ACTIVE;
  }

  public boolean isStarted()
  {
    switch (getState())
    {
      case ServiceStateMachine.STATE_INCONSISTENT:
      case ServiceStateMachine.STATE_ACTIVE:
        return true;
      default:
        return false;
    }
  }

  public void addStateListener(StateListener listener)
  {
    synchronized (this)
    {
      //if (isDebugEnabled()) debug("adding state listener " + listener);
      if (listeners == null) listeners = new LinkedList();
      listeners.add(listener);
    }
  }

  public void removeStateListener(StateListener listener)
  {
    synchronized (this)
    {
      if (listeners != null)
      {
        listeners.remove(listener);
        //if (isDebugEnabled()) debug("removed state listener " + listener);
      }
    }
  }

  public void start() throws Exception
  {
    synchronized (this)
    {
      processServiceEvent(ServiceStateMachine.EVENT_START, null);
    }
  }

  public void stop() throws Exception
  {
    synchronized (this)
    {
      processServiceEvent(ServiceStateMachine.EVENT_STOP, null);
    }
  }

  /* (non-Javadoc)
   * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
   */
  public void afterPropertiesSet() throws Exception
  {
    if (isAutoStart())
    {
      synchronized (this)
      {
        start();
      }
    }
  }

  public void onApplicationEvent(ApplicationEvent event)
  {
    if (!isActive()) return;

    if (event instanceof ContextClosedEvent)
    {
      ContextClosedEvent contextClosedEvent = (ContextClosedEvent) event;
      ApplicationContext app1 = contextClosedEvent.getApplicationContext();
      ApplicationContext app2 = getContainer();
      //      if (isDebugEnabled()) debug("Shutdown of container " + app1);

      if (app1 == app2)
      {
        try
        {
          //          if (isDebugEnabled()) debug("DISPATCHING SHUTDOWN");
          stop();
        }
        catch (Exception ex)
        {
          error("Error while stopping shutdown dispatcher", ex);
        }
      }
    }
  }

  /* (non-Javadoc)
   * @see org.springframework.beans.factory.DisposableBean#destroy()
   */
  public void destroy() throws Exception
  {
    synchronized (this)
    {
      processServiceEvent(ServiceStateMachine.EVENT_DISPOSE, null);
    }
  }

  public void notifyDependencyActivated(Service notifier)
  {
    synchronized (this)
    {
      processServiceEvent(ServiceStateMachine.EVENT_DEPENDENCY_ACTIVATED, notifier);
    }
  }

  public void notifyDependencyDeactivating(Service notifier)
  {
    synchronized (this)
    {
      processServiceEvent(ServiceStateMachine.EVENT_DEPENDENCY_DEACTIVATED, notifier);
    }
  }

  protected void validate() throws ValidationException
  {
  }

  public void dump()
  {
    dump(true);
  }

  protected void dump(boolean withInternals)
  {
    dump(true, new ArrayList());
  }

  protected void dump(boolean withInternals, List attributes)
  {
    if (withInternals)
    {
      attributes.add("autoStart = " + isAutoStart());
      attributes.add("singleton = " + isSingleton());
      attributes.add("state = " + stateMachine.getStateName(getState()));
    }

    for (Class clazz = getClass(); clazz != null; clazz = clazz.getSuperclass())
    {
      Field[] fields = clazz.getDeclaredFields();

      for (int i = 0; i < fields.length; i++)
      {
        Field field = fields[i];
        int modifiers = field.getModifiers();

        if (!Modifier.isTransient(modifiers) && !Modifier.isStatic(modifiers)
            && !Modifier.isFinal(modifiers))
        {
          try
          {
            boolean accessible = field.isAccessible();
            if (!accessible) field.setAccessible(true);

            Object value = field.get(this);
            attributes.add(field.getName()
                + " = "
                + (value == null ? "null" : (value instanceof Loggable ? ((Loggable) value)
                    .getFullBeanName() : value.toString())));

            if (accessible != field.isAccessible()) field.setAccessible(accessible);
          }
          catch (IllegalAccessException ignore)
          {
          }
        }
      }
    }

    Collections.sort(attributes);
    for (Iterator iter = attributes.iterator(); iter.hasNext();)
    {
      String attribute = (String) iter.next();
      debug("--> " + attribute);
    }
  }

  protected void activate() throws Exception
  {
  }

  protected void deactivate() throws Exception
  {
  }

  private void handleActivation() throws Exception
  {
    if (isDebugEnabled()) debug("Activating");

    activate();

    if (listeners != null)
    {
      for (Iterator iter = listeners.iterator(); iter.hasNext();)
      {
        StateListener listener = (StateListener) iter.next();
        listener.notifyDependencyActivated(this);
      }
    }
  }

  private void handleDeactivation() throws Exception
  {
    if (isDebugEnabled()) debug("Deactivating");

    if (listeners != null)
    {
      for (Iterator iter = listeners.iterator(); iter.hasNext();)
      {
        StateListener listener = (StateListener) iter.next();
        listener.notifyDependencyDeactivating(this);
      }
    }

    deactivate();
  }

  protected void dispose() throws Exception
  {
    if (isDebugEnabled()) debug("Disposing");
  }

  ////////////////////////////////////////////////////
  // Properties
  ////////////////////////////////////////////////////

  private void propertyNotFoundError(String propertyName, Exception ex)
  {
    String msg = "Property " + propertyName + " not found";
    error(msg);
    throw new ImplementationError(msg, ex);
  }

  private void propertyNotAccessibleError(String propertyName, Exception ex)
  {
    String msg = "Property " + propertyName + " not accessible";
    error(msg);
    throw new ImplementationError(msg, ex);
  }

  private Field searchField(String propertyName)
  {
    if (propertyName == null) throw new IllegalArgumentException("propertyName");

    Class clazz = ServiceImpl.this.getClass();
    Field field = null;

    while (field == null)
    {
      try
      {
        field = clazz.getDeclaredField(propertyName);
      }
      catch (NoSuchFieldException ex)
      {
        clazz = clazz.getSuperclass();
        if (clazz == Object.class)
        {
          propertyNotFoundError(propertyName, ex);
        }
      }
    }

    return field;
  }

  private void checkTypeIdentity(Field field, Class type)
  {
    if (field.getType() != type)
    {
      throw new ImplementationError("property " + field.getName() + " of wrong type "
          + field.getType() + " for value of type " + type);
    }
  }

  protected void doSet(final String propertyName, final boolean value)
  {
    // assertStopped();

    try
    {
      Field field = searchField(propertyName);
      boolean accessible = field.isAccessible();
      if (!accessible) field.setAccessible(true);

      checkTypeIdentity(field, boolean.class);
      field.setBoolean(ServiceImpl.this, value);

      if (accessible != field.isAccessible()) field.setAccessible(accessible);
    }
    catch (SecurityException ex)
    {
      propertyNotAccessibleError(propertyName, ex);
    }
    catch (IllegalAccessException ex)
    {
      propertyNotAccessibleError(propertyName, ex);
    }
  }

  protected void doSet(final String propertyName, final char value)
  {
    // assertStopped();

    try
    {
      Field field = searchField(propertyName);
      boolean accessible = field.isAccessible();
      if (!accessible) field.setAccessible(true);

      checkTypeIdentity(field, char.class);
      field.setChar(ServiceImpl.this, value);

      if (accessible != field.isAccessible()) field.setAccessible(accessible);
    }
    catch (SecurityException ex)
    {
      propertyNotAccessibleError(propertyName, ex);
    }
    catch (IllegalAccessException ex)
    {
      propertyNotAccessibleError(propertyName, ex);
    }
  }

  protected void doSet(final String propertyName, final byte value)
  {
    // assertStopped();

    try
    {
      Field field = searchField(propertyName);
      boolean accessible = field.isAccessible();
      if (!accessible) field.setAccessible(true);

      checkTypeIdentity(field, byte.class);
      field.setByte(ServiceImpl.this, value);

      if (accessible != field.isAccessible()) field.setAccessible(accessible);
    }
    catch (SecurityException ex)
    {
      propertyNotAccessibleError(propertyName, ex);
    }
    catch (IllegalAccessException ex)
    {
      propertyNotAccessibleError(propertyName, ex);
    }
  }

  protected void doSet(final String propertyName, final short value)
  {
    // assertStopped();

    try
    {
      Field field = searchField(propertyName);
      boolean accessible = field.isAccessible();
      if (!accessible) field.setAccessible(true);

      checkTypeIdentity(field, short.class);
      field.setShort(ServiceImpl.this, value);

      if (accessible != field.isAccessible()) field.setAccessible(accessible);
    }
    catch (SecurityException ex)
    {
      propertyNotAccessibleError(propertyName, ex);
    }
    catch (IllegalAccessException ex)
    {
      propertyNotAccessibleError(propertyName, ex);
    }
  }

  protected void doSet(final String propertyName, final int value)
  {
    // assertStopped();

    try
    {
      Field field = searchField(propertyName);
      boolean accessible = field.isAccessible();
      if (!accessible) field.setAccessible(true);

      checkTypeIdentity(field, int.class);
      field.setInt(ServiceImpl.this, value);

      if (accessible != field.isAccessible()) field.setAccessible(accessible);
    }
    catch (SecurityException ex)
    {
      propertyNotAccessibleError(propertyName, ex);
    }
    catch (IllegalAccessException ex)
    {
      propertyNotAccessibleError(propertyName, ex);
    }
  }

  protected void doSet(final String propertyName, final long value)
  {
    // assertStopped();

    try
    {
      Field field = searchField(propertyName);
      boolean accessible = field.isAccessible();
      if (!accessible) field.setAccessible(true);

      checkTypeIdentity(field, long.class);
      field.setLong(ServiceImpl.this, value);

      if (accessible != field.isAccessible()) field.setAccessible(accessible);
    }
    catch (SecurityException ex)
    {
      propertyNotAccessibleError(propertyName, ex);
    }
    catch (IllegalAccessException ex)
    {
      propertyNotAccessibleError(propertyName, ex);
    }
  }

  protected void doSet(final String propertyName, final float value)
  {
    // assertStopped();

    try
    {
      Field field = searchField(propertyName);
      boolean accessible = field.isAccessible();
      if (!accessible) field.setAccessible(true);

      checkTypeIdentity(field, float.class);
      field.setFloat(ServiceImpl.this, value);

      if (accessible != field.isAccessible()) field.setAccessible(accessible);
    }
    catch (SecurityException ex)
    {
      propertyNotAccessibleError(propertyName, ex);
    }
    catch (IllegalAccessException ex)
    {
      propertyNotAccessibleError(propertyName, ex);
    }
  }

  protected void doSet(final String propertyName, final double value)
  {
    // assertStopped();

    try
    {
      Field field = searchField(propertyName);
      boolean accessible = field.isAccessible();
      if (!accessible) field.setAccessible(true);

      checkTypeIdentity(field, double.class);
      field.setDouble(ServiceImpl.this, value);

      if (accessible != field.isAccessible()) field.setAccessible(accessible);
    }
    catch (SecurityException ex)
    {
      propertyNotAccessibleError(propertyName, ex);
    }
    catch (IllegalAccessException ex)
    {
      propertyNotAccessibleError(propertyName, ex);
    }
  }

  protected void doSet(final String propertyName, final Object value)
  {
    // assertStopped();

    try
    {
      Field field = searchField(propertyName);
      boolean accessible = field.isAccessible();
      if (!accessible) field.setAccessible(true);

      if (value != null && !field.getType().isInstance(value))
      {
        throw new ImplementationError("property " + field.getName() + " of wrong type "
            + field.getType() + " for value of type " + value.getClass());
      }

      Object old = field.get(ServiceImpl.this);
      if (old != null && old instanceof Service)
      {
        ((Service) old).removeStateListener(ServiceImpl.this);
      }

      field.set(ServiceImpl.this, value);
      if (value != null && value instanceof Service)
      {
        ((Service) value).addStateListener(ServiceImpl.this);
      }

      if (accessible != field.isAccessible()) field.setAccessible(accessible);
    }
    catch (SecurityException ex)
    {
      propertyNotAccessibleError(propertyName, ex);
    }
    catch (IllegalAccessException ex)
    {
      propertyNotAccessibleError(propertyName, ex);
    }
  }

  protected void adjustPrototypeBeanName()
  {
    int counter = getPrototypeCounter(getFullBeanName());
    setBeanName(getBeanName() + "-" + counter);
  }

  protected int getPrototypeCounter(String name)
  {
    PrototypeCounter counter = (PrototypeCounter) prototypeCounters.get(name);

    if (counter == null)
    {
      counter = new PrototypeCounter();
      prototypeCounters.put(name, counter);
    }

    return counter.getValue();
  }

  ////////////////////////////////////////////////////////
  // Validation
  ////////////////////////////////////////////////////////

  protected static final int VALIDITY_CONSISTENT = 0;

  protected static final int VALIDITY_INCONSISTENT = 1;

  protected static final int VALIDITY_INVALID = 2;

  protected void assertActive()
  {
    if (!isActive()) throw new InactiveException();
  }

  protected void assertStopped()
  {
    if (isActive()) throw new NotStoppedException();
  }

  protected void assertNotNull(final String propertyName) throws ValidationException
  {
    try
    {
      Field field = searchField(propertyName);
      boolean accessible = field.isAccessible();
      if (!accessible) field.setAccessible(true);

      if (field.get(this) == null)
      {
        throw new ValidationException("property " + propertyName + " is not non-null");
      }

      if (accessible != field.isAccessible()) field.setAccessible(accessible);
    }
    catch (SecurityException ex)
    {
      propertyNotAccessibleError(propertyName, ex);
    }
    catch (IllegalAccessException ex)
    {
      propertyNotAccessibleError(propertyName, ex);
    }
  }

  protected void assertNull(final String propertyName) throws ValidationException
  {
    try
    {
      Field field = searchField(propertyName);
      boolean accessible = field.isAccessible();
      if (!accessible) field.setAccessible(true);

      if (field.get(this) != null)
      {
        throw new ValidationException("property " + propertyName + " is not null");
      }

      if (accessible != field.isAccessible()) field.setAccessible(accessible);
    }
    catch (SecurityException ex)
    {
      propertyNotAccessibleError(propertyName, ex);
    }
    catch (IllegalAccessException ex)
    {
      propertyNotAccessibleError(propertyName, ex);
    }
  }

  /**
   * @return
   */
  protected Service searchInconsistency()
  {
    for (Class clazz = getClass(); clazz != null; clazz = clazz.getSuperclass())
    {
      Field[] fields = clazz.getDeclaredFields();
      for (int i = 0; i < fields.length; i++)
      {
        try
        {
          boolean accessible = fields[i].isAccessible();
          if (!accessible) fields[i].setAccessible(true);
          Object value = fields[i].get(this);
          if (accessible != fields[i].isAccessible()) fields[i].setAccessible(accessible);

          if (value instanceof Service)
          {
            Service dependency = (Service) value;
            if (!dependency.isActive())
            {
              return dependency;
            }
          }
        }
        catch (IllegalAccessException ignore)
        {
        }
      }
    }

    return null;
  }

  private void processServiceEvent(int event, Object data)
  {
    try
    {
      stateMachine.process(this, event, data);
    }
    catch (Exception ex)
    {
      error("Error while processing ServiceEvent " + stateMachine.getEventName(event), ex);
    }
  }


  public static class ServiceStateMachine extends StateMachine<ServiceImpl>
  {
    public static final byte STATE_STOPPED = 0;

    public static final byte STATE_STOPPING = 1;

    public static final byte STATE_INCONSISTENT = 2;

    public static final byte STATE_ACTIVE = 3;

    public static final byte STATE_DISPOSED = 4;

    public static final byte EVENT_DEPENDENCY_ACTIVATED = 0;

    public static final byte EVENT_DEPENDENCY_DEACTIVATED = 1;

    public static final byte EVENT_START = 2;

    public static final byte EVENT_STOP = 3;

    public static final byte EVENT_DISPOSE = 4;

    public static final String[] STATE_NAMES = { "STOPPED", "STOPPING", "INCONSISTENT", "ACTIVE",
        "DISPOSED"};

    public static final String[] EVENT_NAMES = { "DEPENDENCY_ACTIVATED", "DEPENDENCY_DEACTIVATED",
        "START", "STOP", "DISPOSE"};

    public ServiceStateMachine()
    {
      super(STATE_NAMES, EVENT_NAMES);

      ignore(STATE_STOPPED, EVENT_DEPENDENCY_ACTIVATED);
      ignore(STATE_STOPPED, EVENT_DEPENDENCY_DEACTIVATED);
      handle(STATE_STOPPED, EVENT_START, new Transition_Start());
      ignore(STATE_STOPPED, EVENT_STOP);
      handle(STATE_STOPPED, EVENT_DISPOSE, new Transition_Dispose());

      ignore(STATE_STOPPING, EVENT_DEPENDENCY_ACTIVATED);
      ignore(STATE_STOPPING, EVENT_DEPENDENCY_DEACTIVATED);
      ignore(STATE_STOPPING, EVENT_START);
      ignore(STATE_STOPPING, EVENT_STOP);
      ignore(STATE_STOPPING, EVENT_DISPOSE);

      handle(STATE_INCONSISTENT, EVENT_DEPENDENCY_ACTIVATED,
          new Transition_Inconsistent_DependencyActivated());
      ignore(STATE_INCONSISTENT, EVENT_DEPENDENCY_DEACTIVATED);
      ignore(STATE_INCONSISTENT, EVENT_START);
      handle(STATE_INCONSISTENT, EVENT_STOP, new Transition_Stop());
      handle(STATE_INCONSISTENT, EVENT_DISPOSE, new Transition_Dispose());

      ignore(STATE_ACTIVE, EVENT_DEPENDENCY_ACTIVATED);
      handle(STATE_ACTIVE, EVENT_DEPENDENCY_DEACTIVATED,
          new Transition_Active_DependencyDeactivated());
      ignore(STATE_ACTIVE, EVENT_START);
      handle(STATE_ACTIVE, EVENT_STOP, new Transition_Stop());
      handle(STATE_ACTIVE, EVENT_DISPOSE, new Transition_Dispose());

      ignore(STATE_DISPOSED, EVENT_DEPENDENCY_ACTIVATED);
      ignore(STATE_DISPOSED, EVENT_DEPENDENCY_DEACTIVATED);
      ignore(STATE_DISPOSED, EVENT_START);
      ignore(STATE_DISPOSED, EVENT_STOP);
      ignore(STATE_DISPOSED, EVENT_DISPOSE);
    }

    @Override
    protected int getState(ServiceImpl subject)
    {
      return subject.getState();
    }

    @Override
    protected void setState(ServiceImpl subject, int state)
    {
      subject.setState(state);
    }


    private class Transition_Active_DependencyDeactivated implements ITransition<ServiceImpl>
    {
      public void process(ServiceImpl subject, int event, Object data) throws Exception
      {
        subject.setState(STATE_INCONSISTENT);
      }
    }


    private class Transition_Dispose implements ITransition<ServiceImpl>
    {
      public void process(ServiceImpl subject, int event, Object data) throws Exception
      {
        boolean wasActive = subject.isActive();
        subject.setState(STATE_DISPOSED);
        if (wasActive) subject.handleDeactivation();
      }
    }


    private class Transition_Inconsistent_DependencyActivated implements ITransition<ServiceImpl>
    {
      public void process(ServiceImpl subject, int event, Object data) throws Exception
      {
        Service dependency = subject.searchInconsistency();
        boolean wasActive = subject.isActive();

        if (dependency != null)
        {
          subject.setState(STATE_INCONSISTENT);
          if (wasActive) subject.handleDeactivation();
        }
        else
        {
          subject.setState(STATE_ACTIVE);
          if (!wasActive) subject.handleActivation();
        }
      }
    }


    private class Transition_Start implements ITransition<ServiceImpl>
    {
      public void process(ServiceImpl subject, int event, Object data) throws Exception
      {
        if (!subject.isSingleton())
        {
          subject.adjustPrototypeBeanName();
        }

        if (subject.isDebugEnabled()) subject.debug("Validating " + subject.getClass().getName());
        subject.validate();
        if (subject.isDebugEnabled()) subject.dump(false);

        // Assume active state to cope with circular dependencies
        subject.setState(STATE_ACTIVE);
        Service dependency = subject.searchInconsistency();

        if (dependency == null)
        {
          subject.handleActivation();
        }
        else
        {
          subject.setState(STATE_INCONSISTENT);

          if (subject.isDebugEnabled())
          {
            subject.debug("Dependency " + dependency.getFullBeanName()
                + " is inactive - activation deferred");
          }
        }
      }
    }


    private class Transition_Stop implements ITransition<ServiceImpl>
    {
      public void process(ServiceImpl subject, int event, Object data) throws Exception
      {
        if (subject.isStarted())
        {
          subject.setState(STATE_STOPPING);
          subject.handleDeactivation();
        }

        subject.setState(STATE_STOPPED);
      }
    }
  }


  private static class PrototypeCounter
  {
    private int value;

    public int getValue()
    {
      return ++value;
    }
  }

  /**
   * Only for unit test.
   */
  public void testSetState(byte state)
  {
    debug("set state = " + state + " for test");
    setState(state);
  }
}
