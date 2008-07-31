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
package org.eclipse.net4j.pop.task;

import org.eclipse.core.runtime.IAdaptable;

/**
 * @author Eike Stepper
 */
public interface ITaskAttribute extends IAdaptable
{
  public ITaskRepositoryConnector getConnector();

  public String getName();

  public Type getType();

  public boolean isChangeable();

  public boolean isRequired();

  public boolean isMany();

  public String[] getChoices();

  /**
   * @author Eike Stepper
   */
  public enum Type
  {
    BOOLEAN, INTEGER, STRING, DATE, CHOICE, USER, TASK
  }
}
