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
package org.eclipse.net4j.core;


import org.eclipse.net4j.util.Net4jException;


public class AlreadyRequestingException extends Net4jException
{
  private static final long serialVersionUID = 1L;

  private Request ongoingRequest;

  private Request newRequest;

  public AlreadyRequestingException(Request ongoingRequest, Request newRequest)
  {
    super("Ongoing request: " + ongoingRequest + ", new request: " + newRequest);
  }

  public Request getOngoingRequest()
  {
    return ongoingRequest;
  }

  public Request getNewRequest()
  {
    return newRequest;
  }
}
