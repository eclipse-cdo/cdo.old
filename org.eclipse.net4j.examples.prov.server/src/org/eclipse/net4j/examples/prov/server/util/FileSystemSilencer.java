/***************************************************************************
 * Copyright (c) 2004-2006 Eike Stepper, Fuggerstr. 39, 10777 Berlin, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 **************************************************************************/
package org.eclipse.net4j.examples.prov.server.util;


import org.eclipse.net4j.util.IOHelper;
import org.eclipse.net4j.util.ImplementationError;
import org.eclipse.net4j.util.thread.Worker;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class FileSystemSilencer
{
  private File fileToFinish;

  private long lastModification;

  private Map<File, FolderInfo> folders = new HashMap<File, FolderInfo>();

  private Set<File> newFiles = new HashSet<File>();

  private Set<File> silentFiles = new HashSet<File>();

  private Worker folderWorker = new FolderWorker();

  private Worker fileWorker = new FileWorker();

  public FileSystemSilencer(File fileToFinish)
  {
    this.fileToFinish = fileToFinish;
    touch();
  }

  public static void waitForSilence(File fileToFinish)
  {
    FileSystemSilencer silencer = new FileSystemSilencer(fileToFinish);
    silencer.waitForSilence();
  }

  public void waitForSilence()
  {
    // long start = System.currentTimeMillis();

    if (fileToFinish.isFile())
    {
      synchronized (newFiles)
      {
        newFiles.add(fileToFinish);
      }
    }
    else
    {
      synchronized (folders)
      {
        folders.put(fileToFinish, new FolderInfo());
      }

      folderWorker.startup();
    }

    fileWorker.startup();

    try
    {
      folderWorker.join();
    }
    catch (InterruptedException ignore)
    {
    }

    try
    {
      fileWorker.join();
    }
    catch (InterruptedException ignore)
    {
    }
  }

  private void touch()
  {
    lastModification = System.currentTimeMillis();
  }

  private static class FolderInfo
  {
    private int memberCount;

    public int getMemberCount()
    {
      return memberCount;
    }

    public void setMemberCount(int memberCount)
    {
      this.memberCount = memberCount;
    }
  }

  private class FolderWorker extends Worker
  {
    private Map.Entry<File, FolderInfo>[] folderEntries = new Map.Entry[0];

    private int currentIndex = 0;

    public FolderWorker()
    {
      super("FileSystemSilencer.FolderWorker");
    }

    @Override
    protected long doWorkStep(int progress)
    {
      if (currentIndex < folderEntries.length)
      {
        File folder = folderEntries[currentIndex].getKey();
        FolderInfo folderInfo = folderEntries[currentIndex].getValue();
        File[] members = folder.listFiles();

        if (members.length > folderInfo.getMemberCount())
        {
          folderInfo.setMemberCount(members.length);
          handleMembers(members);
          touch();
        }

        ++currentIndex;
        return NO_PAUSE;
      }
      else
      {
        long pause = System.currentTimeMillis() - lastModification;

        if (pause > 1000 && newFiles.isEmpty())
        {
          return TERMINATE;
        }
        else
        {
          synchronized (folders)
          {
            folderEntries = folders.entrySet().toArray(new Map.Entry[folders.size()]);
            currentIndex = 0;
          }

          return 10;
        }
      }
    }

    private void handleMembers(File[] members)
    {
      for (int i = 0; i < members.length; i++)
      {
        File member = members[i];

        if (member.isFile())
        {
          synchronized (silentFiles)
          {
            if (silentFiles.contains(member))
            {
              continue;
            }
          }

          synchronized (newFiles)
          {
            if (!newFiles.contains(member))
            {
              newFiles.add(member);
            }
          }
        }
        else if (member.isDirectory())
        {
          synchronized (folders)
          {
            FolderInfo folderInfo = folders.get(member);

            if (folderInfo == null)
            {
              folderInfo = new FolderInfo();
              folders.put(member, folderInfo);
            }
          }
        }
        else
        {
          throw new ImplementationError("Member is neither file nor directory: " + member);
        }
      }
    }
  }

  private class FileWorker extends Worker
  {
    private File[] files = new File[0];

    private int currentIndex = 0;

    public FileWorker()
    {
      super("FileSystemSilencer.FileWorker");
    }

    @Override
    protected long doWorkStep(int progress)
    {
      if (currentIndex < files.length)
      {
        File file = files[currentIndex];

        if (isSilent(file))
        {
          synchronized (newFiles)
          {
            newFiles.remove(file);
          }

          synchronized (silentFiles)
          {
            silentFiles.add(file);
          }
        }
        else
        {
          touch();
        }

        ++currentIndex;
      }
      else
      {
        synchronized (newFiles)
        {
          long pause = System.currentTimeMillis() - lastModification;

          if (pause > 1000 && newFiles.isEmpty())
          {
            return TERMINATE;
          }
          else
          {
            files = newFiles.toArray(new File[newFiles.size()]);
            currentIndex = 0;
          }
        }
      }

      return 10;
    }

    private boolean isSilent(File file)
    {
      OutputStream os = null;

      try
      {
        os = new FileOutputStream(file, true);
      }
      catch (Exception ex)
      {
        return false;
      }
      finally
      {
        IOHelper.close(os);
      }

      return true;
    }
  }
}
