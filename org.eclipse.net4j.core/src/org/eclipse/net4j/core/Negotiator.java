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
package org.eclipse.net4j.core;


import org.eclipse.net4j.spring.Service;


public interface Negotiator extends Service
{
  /**
   * Executes a negotitation between two connectors.
   * 
   * @param connector
   *          The connector to be used in the negotiation phase.
   * @throws NegotiationException
   *           If an error occurs in the negotiation phase.
   */
  public void negotiate(Connector connector) throws NegotiationException;
}
