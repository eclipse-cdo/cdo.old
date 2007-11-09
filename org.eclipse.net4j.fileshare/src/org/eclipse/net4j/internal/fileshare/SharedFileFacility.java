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

import org.eclipse.net4j.buddies.internal.protocol.Facility;
import org.eclipse.net4j.buddies.protocol.IMessage;
import org.eclipse.net4j.fileshare.ISharedFile;
import org.eclipse.net4j.fileshare.ISharedFileFacility;
import org.eclipse.net4j.util.io.IORuntimeException;
import org.eclipse.net4j.util.io.IOUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Eike Stepper
 */
public class SharedFileFacility extends Facility implements ISharedFileFacility
{
  private List<ISharedFile> sharedFiles = new ArrayList<ISharedFile>();

  public SharedFileFacility()
  {
    super(TYPE);
  }

  public ISharedFile[] getSharedFiles()
  {
    synchronized (sharedFiles)
    {
      return sharedFiles.toArray(new ISharedFile[sharedFiles.size()]);
    }
  }

  public ISharedFile addSharedFile(String path)
  {
    File file = new File(path);
    if (!file.exists())
    {
      throw new IORuntimeException("File not found: " + path);
    }

    if (!file.isFile())
    {
      throw new IORuntimeException("Not a file: " + path);
    }

    byte[] content = IOUtil.readFile(file);
    String name = file.getName();

    AddMessage message = new AddMessage(content, name);
    sendMessage(message);

    SharedFile sharedFile = addSharedFile(message.getSenderID(), content, name);
    return sharedFile;
  }

  @Override
  protected void handleMessage(IMessage message)
  {
    if (message instanceof AddMessage)
    {
      addSharedFile(message.getSenderID(), ((AddMessage)message).getContent(), ((AddMessage)message).getName());
    }
  }

  protected SharedFile addSharedFile(String senderID, byte[] content, String name)
  {
    SharedFile sharedFile = new SharedFile(System.currentTimeMillis(), senderID, content, name);
    synchronized (sharedFiles)
    {
      sharedFiles.add(sharedFile);
    }

    fireEvent(new SharedFileEvent(this, sharedFile));
    return sharedFile;
  }
}
