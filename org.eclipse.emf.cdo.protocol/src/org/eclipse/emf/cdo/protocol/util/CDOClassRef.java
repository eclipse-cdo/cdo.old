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
package org.eclipse.emf.cdo.protocol.util;

import org.eclipse.net4j.util.ObjectUtil;
import org.eclipse.net4j.util.stream.ExtendedDataInputStream;
import org.eclipse.net4j.util.stream.ExtendedDataOutputStream;

import java.io.IOException;

/**
 * @author Eike Stepper
 */
public final class CDOClassRef
{
  private String modelURI;

  private int classifierID;

  public CDOClassRef(String modelURI, int classifierID)
  {
    this.modelURI = modelURI;
    this.classifierID = classifierID;
  }

  public CDOClassRef(ExtendedDataInputStream in) throws IOException
  {
    modelURI = in.readString();
    classifierID = in.readInt();
  }

  public void write(ExtendedDataOutputStream out) throws IOException
  {
    out.writeString(modelURI);
    out.writeInt(classifierID);
  }

  public String getModelURI()
  {
    return modelURI;
  }

  public int getClassifierID()
  {
    return classifierID;
  }

  @Override
  public boolean equals(Object obj)
  {
    if (obj instanceof CDOClassRef)
    {
      CDOClassRef that = (CDOClassRef)obj;
      return ObjectUtil.equals(this.modelURI, that.modelURI)
          && this.classifierID == that.classifierID;
    }

    return false;
  }

  @Override
  public int hashCode()
  {
    return modelURI.hashCode() ^ classifierID;
  }

  @Override
  public String toString()
  {
    return modelURI + "#" + classifierID;
  }
}
