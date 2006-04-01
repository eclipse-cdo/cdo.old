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
package org.eclipse.net4j.spring;


import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.io.ResourceLoader;


public interface Container extends ConfigurableApplicationContext, ResourceLoader
{
  public static final String CONTAINER_PATH_SEPARATOR = ".";

  public static final String URL_PROTOCOL_PLUGIN = "plugin";

  public String getName();

  public String getParentName();

  public String getFullName();

  public Container getParentContainer();

  public void stop();

  //  public interface Descriptor
  //  {
  //    public boolean isAutoStart();
  //
  //    public String getName();
  //
  //    public String getParentName();
  //
  //    public String getFullName();
  //
  //    public Container getContainer();
  //
  //    public boolean isStarted();
  //
  //    public void addReadyListener(ReadyListener listener);
  //
  //    public void removeReadyListener(ReadyListener listener);
  //  }
  //
  //
  //  public interface Registry 
  //  {
  //    public Object getBean(String fullName);
  //
  //    public Container getContainer(String fullName);
  //
  //    public Descriptor getDescriptor(String fullName);
  //
  //    public Descriptor put(Descriptor descriptor);
  //
  //    public boolean containsKey(String fullName);
  //
  //    public Iterator iterator();
  //
  //    public boolean isEmpty();
  //
  //    public int size();
  //  }
  //
  //  public interface ReadyListener
  //  {
  //    public void notifyReady(Container.Descriptor descriptor);
  //  }
}