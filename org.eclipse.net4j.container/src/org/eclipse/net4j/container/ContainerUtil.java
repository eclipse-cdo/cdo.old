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
package org.eclipse.net4j.container;

import org.eclipse.net4j.internal.container.ContainerImpl;

import java.io.File;

/**
 * @author Eike Stepper
 */
public final class ContainerUtil
{
  private ContainerUtil()
  {
  }

  public static Container createContainer()
  {
    return new ContainerImpl();
  }

  public static Container createContainer(File file)
  {
    return new ContainerImpl(file);
  }
}
