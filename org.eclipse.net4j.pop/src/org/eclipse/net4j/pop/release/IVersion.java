/***************************************************************************
 * Copyright (c) 2004 - 2008 Eike Stepper, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 **************************************************************************/
package org.eclipse.net4j.pop.release;

import org.eclipse.core.runtime.IAdaptable;

/**
 * @author Eike Stepper
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface IVersion extends IAdaptable, Comparable<IVersion>
{
  public int getMajor();

  public int getMinor();

  public int getMicro();

  public boolean isMajor();

  public boolean isMinor();

  public boolean isMicro();

  public IVersion nextMajor(int increment);

  public IVersion nextMinor(int increment);

  public IVersion nextMicro();

  public String toString(boolean forceMicro);
}
