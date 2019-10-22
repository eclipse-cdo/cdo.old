/*
 * Copyright (c) 2010-2012 Eike Stepper (Loehne, Germany) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Victor Roldan Betancort - initial API and implementation
 */
package org.eclipse.emf.cdo.server.internal.db4o;

/**
 * @author Victor Roldan Betancort
 */
public class DB4OWrappedValue<TYPE> extends DB4OIdentifiableObject
{
  private TYPE value;

  public DB4OWrappedValue(String id, TYPE value)
  {
    setId(id);
    setValue(value);
  }

  public TYPE getValue()
  {
    return value;
  }

  private void setValue(TYPE value)
  {
    this.value = value;
  }

}
