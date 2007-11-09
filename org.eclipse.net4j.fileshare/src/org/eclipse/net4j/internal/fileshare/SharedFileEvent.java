/***************************************************************************
 * Copyright (c) 2004 - 2007 Eike Stepper, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 **************************************************************************/
package org.eclipse.net4j.internal.fileshare;

import org.eclipse.net4j.fileshare.ISharedFile;
import org.eclipse.net4j.fileshare.ISharedFileEvent;
import org.eclipse.net4j.fileshare.ISharedFileFacility;
import org.eclipse.net4j.internal.util.event.Event;

/**
 * @author Eike Stepper
 */
public class SharedFileEvent extends Event implements ISharedFileEvent
{
  private static final long serialVersionUID = 1L;

  private ISharedFile sharedFile;

  public SharedFileEvent(ISharedFileFacility facility, ISharedFile sharedFile)
  {
    super(facility);
    this.sharedFile = sharedFile;
  }

  public ISharedFileFacility getFacility()
  {
    return (ISharedFileFacility)getSource();
  }

  public ISharedFile getSharedFile()
  {
    return sharedFile;
  }
}
