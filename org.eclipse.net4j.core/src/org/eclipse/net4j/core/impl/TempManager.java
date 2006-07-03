package org.eclipse.net4j.core.impl;


import org.eclipse.net4j.core.Executor;
import org.eclipse.net4j.core.ITempManager;
import org.eclipse.net4j.core.Task;
import org.eclipse.net4j.spring.ValidationException;
import org.eclipse.net4j.spring.impl.ServiceImpl;
import org.eclipse.net4j.util.IOHelper;
import org.eclipse.net4j.util.UnderlyingIOException;

import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;


public class TempManager extends ServiceImpl implements ITempManager
{
  public static final long DEFAULT_RELEASE_DELAY = 1000;

  private Executor releaseExecutor;

  private long releaseDelay = DEFAULT_RELEASE_DELAY;

  private int releaseTimerCounter = 0;

  private int tempCounter = 0;

  private transient File rootFolder;

  public Executor getReleaseExecutor()
  {
    return releaseExecutor;
  }

  public void setReleaseExecutor(Executor releaseExecutor)
  {
    doSet("releaseExecutor", releaseExecutor);
  }

  public long getReleaseDelay()
  {
    return releaseDelay;
  }

  public void setReleaseDelay(long releaseDelay)
  {
    doSet("releaseDelay", releaseDelay);
  }

  public int getTempCounter()
  {
    return tempCounter;
  }

  public int getReleaseTimerCounter()
  {
    return releaseTimerCounter;
  }

  public File createTempFile(String prefix, String suffix)
  {
    try
    {
      File temp;

      do
      {
        String name = getTempName(prefix, suffix);
        temp = new File(rootFolder, name);

      }
      while (temp.exists() || !temp.createNewFile());

      return temp;
    }
    catch (IOException ex)
    {
      throw new UnderlyingIOException("Could not create temp file", ex);
    }
  }

  public File createTempFile(String prefix)
  {
    return createTempFile(prefix, null);
  }

  public File createTempFile()
  {
    return createTempFile(null);
  }

  public File createTempFolder(String prefix, String suffix)
  {
    File temp;

    do
    {
      String name = getTempName(prefix, suffix);
      temp = new File(rootFolder, name);

    }
    while (temp.exists() || !temp.mkdirs());

    return temp;
  }

  public File createTempFolder(String prefix)
  {
    return createTempFolder(prefix, null);
  }

  public File createTempFolder()
  {
    return createTempFolder(null);
  }

  public synchronized void release(final File temp)
  {
    if (temp == null)
    {
      return;
    }

    if (releaseDelay > 0)
    {
      Timer timer = new Timer(getFullBeanName() + ".ReleaseTimer-" + (++releaseTimerCounter));

      timer.schedule(new TimerTask()
      {
        @Override
        public void run()
        {
          doRelease(temp);
        }
      }, releaseDelay);
    }
    else
    {
      doRelease(temp);
    }
  }

  protected void doRelease(File temp)
  {
    try
    {
      releaseExecutor.execute(new ReleaseTask(temp), null);
    }
    catch (Exception ex)
    {
      warn("Problem while scheduling release of temp file " + temp, ex);
    }
  }

  @Override
  protected void validate() throws ValidationException
  {
    super.validate();
    assertNotNull("releaseExecutor");
  }

  @Override
  protected void activate() throws Exception
  {
    super.activate();
    rootFolder = IOHelper.createTempFolder(getFullBeanName());
  }

  @Override
  protected void deactivate() throws Exception
  {
    IOHelper.deleteFile(rootFolder);
    super.deactivate();
  }

  /**
   * @param prefix
   * @param suffix
   * @return
   */
  private synchronized String getTempName(String prefix, String suffix)
  {
    return (prefix == null ? "" : prefix) + (++tempCounter) + (suffix == null ? ".tmp" : suffix);
  }


  private class ReleaseTask implements Task
  {
    private File temp;

    public ReleaseTask(File temp)
    {
      this.temp = temp;
    }

    public void execute() throws Exception
    {
      if (isDebugEnabled()) debug("Deleting temp file " + temp.getName());
      IOHelper.deleteFile(temp);

      if (temp.exists())
      {
        warn("Could not delete temp file " + temp);
        release(temp);
      }
    }
  }
}
