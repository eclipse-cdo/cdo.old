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

import org.eclipse.net4j.buddies.protocol.IMessage;
import org.eclipse.net4j.fileshare.ISharedFile;
import org.eclipse.net4j.fileshare.ISharedFileRepository;

/**
 * @author Eike Stepper
 */
public class SharedFileRepository extends SharedFileFacility implements ISharedFileRepository
{
  public SharedFileRepository()
  {
  }

  @Override
  public ISharedFile addSharedFile(String path)
  {
    throw new UnsupportedOperationException();
  }

  @Override
  public void handleMessage(IMessage message)
  {
    sendMessage(message);
  }
}
