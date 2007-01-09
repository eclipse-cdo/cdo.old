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

  public String getModelURI()
  {
    return modelURI;
  }

  public int getClassifierID()
  {
    return classifierID;
  }
}
