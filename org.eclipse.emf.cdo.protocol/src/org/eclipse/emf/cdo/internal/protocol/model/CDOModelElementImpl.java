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
package org.eclipse.emf.cdo.internal.protocol.model;

import org.eclipse.emf.cdo.internal.protocol.bundle.CDOProtocol;
import org.eclipse.emf.cdo.protocol.model.CDOModelElement;

import org.eclipse.net4j.util.om.trace.ContextTracer;
import org.eclipse.net4j.util.stream.ExtendedDataInputStream;
import org.eclipse.net4j.util.stream.ExtendedDataOutputStream;

import java.io.IOException;

/**
 * @author Eike Stepper
 */
public class CDOModelElementImpl implements CDOModelElement
{
  private static final ContextTracer MODEL = new ContextTracer(CDOProtocol.DEBUG_MODEL,
      CDOModelElementImpl.class);

  private int id = UNINITIALIZED_ID;

  private String name;

  private Object peerData;

  public CDOModelElementImpl(int id, String name)
  {
    this.id = id;
    this.name = name;
  }

  public CDOModelElementImpl(ExtendedDataInputStream in) throws IOException
  {
    id = in.readInt();
    name = in.readString();
  }

  public void write(ExtendedDataOutputStream out) throws IOException
  {
    out.writeInt(id);
    out.writeString(name);
  }

  public int getID()
  {
    return id;
  }

  public String getName()
  {
    return name;
  }

  public Object getPeerData()
  {
    return peerData;
  }

  public void setID(int id)
  {
    if (this.id == id)
    {
      throw new IllegalArgumentException("this.id == id == " + id);
    }

    if (MODEL.isEnabled())
    {
      MODEL.format("Setting ID: {0} --> {1}", this, id);
    }

    this.id = id;
  }

  public void setPeerData(Object peerData)
  {
    if (MODEL.isEnabled())
    {
      MODEL.format("Setting peerData: {0} --> {1}", this, peerData);
    }

    this.peerData = peerData;
  }
}
