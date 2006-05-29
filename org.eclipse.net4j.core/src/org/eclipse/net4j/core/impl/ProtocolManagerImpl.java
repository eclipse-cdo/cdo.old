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


import org.eclipse.net4j.core.Protocol;
import org.eclipse.net4j.core.ProtocolManager;
import org.eclipse.net4j.spring.impl.ServiceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;


public class ProtocolManagerImpl extends ServiceImpl implements ProtocolManager
{
  protected static final int INITIAL_CAPACITY = 23;

  protected List<Protocol> protocols = new ArrayList<Protocol>();

  protected HashMap<String, Protocol> serverProtocols = new HashMap<String, Protocol>(INITIAL_CAPACITY);

  protected HashMap<String, Protocol> clientProtocols = new HashMap<String, Protocol>(INITIAL_CAPACITY);

  protected int protocolCount;

  public Protocol lookupClient(String name)
  {
    return clientProtocols.get(name);
  }

  public Protocol lookupServer(String name)
  {
    return serverProtocols.get(name);
  }

  public void deregister(Protocol protocol)
  {
    // TODO Auto-generated method stub
  }

  public void register(Protocol protocol)
  {
    String name = protocol.getName();
    protocols.add(protocol);

    if (protocol.isServer())
    {
      if (isDebugEnabled()) debug("Registering server-side protocol: " + name);
      serverProtocols.put(name, protocol);
      if (clientProtocols.get(name) == null)
      {
        ++protocolCount;
      }
    }

    if (protocol.isClient())
    {
      if (isDebugEnabled()) debug("Registering client-side protocol: " + name);
      clientProtocols.put(name, protocol);
      if (serverProtocols.get(name) == null)
      {
        ++protocolCount;
      }
    }
  }

  public Iterator<Protocol> getClientProtocols()
  {
    return clientProtocols.values().iterator();
  }

  public Iterator<Protocol> getServerProtocols()
  {
    return serverProtocols.values().iterator();
  }

  public int getProtocolCount()
  {
    return protocolCount;
  }
}
