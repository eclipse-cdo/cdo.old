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
package org.eclipse.net4j.examples.prov.server;


public class ProvException extends RuntimeException
{
  /**
   * 
   */
  private static final long serialVersionUID = 3616445683461601078L;

  public ProvException()
  {
    super();
  }

  public ProvException(String arg0)
  {
    super(arg0);
  }

  public ProvException(String arg0, Throwable arg1)
  {
    super(arg0, arg1);
  }

  public ProvException(Throwable arg0)
  {
    super(arg0);
  }
}