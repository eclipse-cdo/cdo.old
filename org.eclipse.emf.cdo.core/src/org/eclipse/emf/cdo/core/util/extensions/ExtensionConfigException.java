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
package org.eclipse.emf.cdo.core.util.extensions;


public class ExtensionConfigException extends RuntimeException
{
  /**
   * 
   */
  private static final long serialVersionUID = 3979274633562501681L;

  /**
   * 
   */
  public ExtensionConfigException()
  {
    super();
  }

  /**
   * @param arg0
   */
  public ExtensionConfigException(String arg0)
  {
    super(arg0);
  }

  /**
   * @param arg0
   */
  public ExtensionConfigException(Throwable arg0)
  {
    super(arg0);
  }

  /**
   * @param arg0
   * @param arg1
   */
  public ExtensionConfigException(String arg0, Throwable arg1)
  {
    super(arg0, arg1);
  }
}
