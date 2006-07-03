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
package org.eclipse.net4j.core.impl;


import org.eclipse.net4j.core.ConnectionLimitExceededException;
import org.eclipse.net4j.core.ConnectionManager;
import org.eclipse.net4j.core.Connector;
import org.eclipse.net4j.spring.impl.ServiceImpl;

import java.util.HashSet;
import java.util.Set;


public class ConnectionManagerImpl extends ServiceImpl implements ConnectionManager
{
  public static final int INITIAL_CAPACITY = 211;

  public static final int DEFAULT_MAXIMUM = Integer.MAX_VALUE;

  private int maxConnections = DEFAULT_MAXIMUM;

  private transient Set<Connector> connectors = new HashSet<Connector>(INITIAL_CAPACITY);

  public int getMaxConnections()
  {
    return maxConnections;
  }

  public void setMaxConnections(int maxConnections)
  {
    doSet("maxConnections", maxConnections);
  }

  public void registerConnector(Connector connector) throws ConnectionLimitExceededException
  {
    if (connectors.size() >= maxConnections)
    {
      throw new ConnectionLimitExceededException("Limit of " + maxConnections
              + " connections is exceeded");
    }

    if (isDebugEnabled()) debug("Registering connector: " + connector);
    connectors.add(connector);
  }

  public void deregisterConnector(Connector connector)
  {
    connectors.remove(connector);
    if (isDebugEnabled()) debug("Deregistered connector: " + connector);
  }

  public Connector[] getConnectors()
  {
    return connectors.toArray(new Connector[connectors.size()]);
  }
}
