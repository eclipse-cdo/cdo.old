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
import org.eclipse.net4j.util.io.IOUtil;

import java.io.File;
import java.io.Serializable;

/**
 * @author Eike Stepper
 */
public class SharedFile implements ISharedFile, Serializable
{
  private static final long serialVersionUID = 1L;

  private long creationTime;

  private String creatorID;

  private File file;

  public SharedFile(long creationTime, String creatorID, File file)
  {
    this.creationTime = creationTime;
    this.creatorID = creatorID;
    this.file = file;
  }

  public long getCreationTime()
  {
    return creationTime;
  }

  public String getCreatorID()
  {
    return creatorID;
  }

  public File getFile()
  {
    return file;
  }

  public byte[] getContent()
  {
    return IOUtil.readFile(file);
  }

  public String getName()
  {
    return file.getName();
  }
}
