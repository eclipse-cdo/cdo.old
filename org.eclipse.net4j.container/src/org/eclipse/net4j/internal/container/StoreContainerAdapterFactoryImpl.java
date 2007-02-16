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
package org.eclipse.net4j.internal.container;

import org.eclipse.net4j.container.Container;
import org.eclipse.net4j.container.ContainerAdapter;
import org.eclipse.net4j.container.ContainerAdapterFactory;
import org.eclipse.net4j.container.StoreConstants;

import java.io.File;

public final class StoreContainerAdapterFactoryImpl implements ContainerAdapterFactory
{
  private File store;

  public StoreContainerAdapterFactoryImpl(File store)
  {
    this.store = store;
  }

  public String getType()
  {
    return StoreConstants.TYPE;
  }

  public ContainerAdapter createAdapter(Container container)
  {
    return new StoreContainerAdapterImpl(container, store);
  }
}