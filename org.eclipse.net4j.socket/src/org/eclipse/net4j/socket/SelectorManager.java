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
package org.eclipse.net4j.socket;


import org.eclipse.net4j.core.SelectionListener;
import org.eclipse.net4j.spring.Service;

import java.nio.channels.SelectableChannel;


public interface SelectorManager extends Service
{
  public void deregister(SelectableChannel selectable);

  public void register(SelectableChannel selectable, SelectionListener listener);
}
