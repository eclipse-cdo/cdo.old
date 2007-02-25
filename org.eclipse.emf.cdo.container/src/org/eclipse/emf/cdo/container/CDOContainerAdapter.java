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
package org.eclipse.emf.cdo.container;

import org.eclipse.emf.cdo.CDOSession;

import org.eclipse.net4j.container.ContainerAdapter;
import org.eclipse.net4j.transport.ConnectorException;
import org.eclipse.net4j.util.registry.IRegistry;

/**
 * @author Eike Stepper
 */
public interface CDOContainerAdapter extends ContainerAdapter
{
  public IRegistry<String, CDOSession> getSessionRegistry();

  public CDOSession getSession(String description) throws ConnectorException;
}
