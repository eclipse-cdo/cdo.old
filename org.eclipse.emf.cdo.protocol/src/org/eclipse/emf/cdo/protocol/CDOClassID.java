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
package org.eclipse.emf.cdo.protocol;

import org.eclipse.net4j.util.stream.ExtendedDataInputStream;
import org.eclipse.net4j.util.stream.ExtendedDataOutputStream;

import java.io.IOException;

/**
 * @author Eike Stepper
 */
public final class CDOClassID
{
  private static final char SEPARATOR = '#';

  private int modelID;

  private int classifierID;

  public CDOClassID(int modelID, int classifierID)
  {
    this.modelID = modelID;
    this.classifierID = classifierID;
  }

  public CDOClassID(ExtendedDataInputStream in) throws IOException
  {
    modelID = in.readInt();
    classifierID = in.readInt();
  }

  public int getModelID()
  {
    return modelID;
  }

  public int getClassifierID()
  {
    return classifierID;
  }

  public void write(ExtendedDataOutputStream out) throws IOException
  {
    out.writeInt(modelID);
    out.writeInt(classifierID);
  }

  @Override
  public boolean equals(Object obj)
  {
    if (obj instanceof CDOClassID)
    {
      CDOClassID that = (CDOClassID)obj;
      return this.modelID == that.modelID && this.classifierID == that.classifierID;
    }

    return false;
  }

  @Override
  public int hashCode()
  {
    return modelID ^ classifierID;
  }

  @Override
  public String toString()
  {
    return "" + modelID + SEPARATOR + classifierID;
  }
}
