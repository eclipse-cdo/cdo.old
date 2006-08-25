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
package org.eclipse.net4j.examples.prov.server;


import org.eclipse.net4j.examples.server.internal.AbstractBackendInitializer;
import org.eclipse.net4j.spring.Container;


public class ProvServerBackendInitializer extends AbstractBackendInitializer
{
  public ProvServerBackendInitializer()
  {
  }

  @Override
  protected Container initialize()
  {
    Container container = ProvServerPlugin.getContainer();
    ProvServerPlugin.getHttpd();
    return container;
  }
}
