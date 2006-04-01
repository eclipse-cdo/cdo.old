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
package org.eclipse.net4j.core.protocol;


import org.eclipse.net4j.core.BasicProtocol;
import org.eclipse.net4j.core.impl.AbstractProtocol;


public abstract class AbstractBasicProtocol extends AbstractProtocol implements BasicProtocol
{
  public String getName()
  {
    return PROTOCOL_NAME;
  }
}
