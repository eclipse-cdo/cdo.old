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
package org.eclipse.emf.cdo.internal.protocol.id;

import org.eclipse.net4j.util.io.ExtendedDataInput;
import org.eclipse.net4j.util.io.ExtendedDataOutput;

import java.io.IOException;

/**
 * @author Eike Stepper
 */
public final class CDOIDNullImpl extends AbstractCDOID
{
  public static final CDOIDNullImpl INSTANCE = new CDOIDNullImpl();

  private static final long serialVersionUID = 1L;

  private CDOIDNullImpl()
  {
  }

  public Type getType()
  {
    return Type.NULL;
  }

  public void read(ExtendedDataInput in) throws IOException
  {
    // Do nothing
  }

  public void write(ExtendedDataOutput out) throws IOException
  {
    // Do nothing
  }

  @Override
  public boolean equals(Object obj)
  {
    return obj == INSTANCE;
  }

  @Override
  public int hashCode()
  {
    return 0;
  }

  @Override
  public String toString()
  {
    return "NULL";
  }
}
