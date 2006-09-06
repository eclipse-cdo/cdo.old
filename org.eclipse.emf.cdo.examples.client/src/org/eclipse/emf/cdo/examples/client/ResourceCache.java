/***************************************************************************
 * Copyright (c) 2004, 2005, 2006 Eike Stepper, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 **************************************************************************/
package org.eclipse.emf.cdo.examples.client;


import org.eclipse.net4j.core.Channel;

import org.eclipse.emf.cdo.client.ResourceInfo;

import java.util.List;


public interface ResourceCache
{
  public List<ResourceInfo> getAllResources();

  public Channel getChannel();

  public void addListener(Listener listener);

  public void removeListener(Listener listener);

  public void dispose();


  public static interface Listener
  {
    public void notifyResourcesChanged(ResourceCache cache);
  }
}