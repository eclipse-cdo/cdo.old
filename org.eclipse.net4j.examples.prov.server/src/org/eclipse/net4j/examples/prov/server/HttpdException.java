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


public class HttpdException extends ProvException
{
  /**
   * 
   */
  private static final long serialVersionUID = 3258410629743390775L;

  public HttpdException()
  {
    super();
  }

  public HttpdException(String arg0)
  {
    super(arg0);
  }

  public HttpdException(String arg0, Throwable arg1)
  {
    super(arg0, arg1);
  }

  public HttpdException(Throwable arg0)
  {
    super(arg0);
  }
}
