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
package org.eclipse.emf.cdo.internal.protocol.event;

import org.eclipse.emf.cdo.protocol.event.CDOEvent;
import org.eclipse.emf.cdo.protocol.event.CDOEventSource;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Eike Stepper
 */
public class CDOEventImpl implements CDOEvent
{
  private List<CDOEventSource> sources = new ArrayList(1);

  public List<CDOEventSource> getSources()
  {
    return sources;
  }

  public boolean hasSource(CDOEventSource source)
  {
    if (!sources.isEmpty())
    {
      for (CDOEventSource s : sources)
      {
        if (s == source)
        {
          return true;
        }
      }
    }

    return false;
  }
}
