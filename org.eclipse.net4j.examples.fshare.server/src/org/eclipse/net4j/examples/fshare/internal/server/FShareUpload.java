package org.eclipse.net4j.examples.fshare.internal.server;

import org.eclipse.net4j.examples.fshare.common.FShareConstants;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FShareUpload
{
  private FShareServerProtocol session;

  private List<Feedback> feedbacks = new LinkedList<Feedback>();

  private boolean done;

  public FShareUpload(FShareServerProtocol session)
  {
    this.session = session;
  }

  public FShareUpload(FShareUpload source)
  {
    synchronized (source)
    {
      session = source.session;
      for (Iterator<Feedback> it = source.feedbacks.iterator(); it.hasNext();)
      {
        Feedback feedback = it.next();
        feedbacks.add(new Feedback(feedback));
        if (feedback.isDone())
        {
          it.remove();
        }
      }
    }
  }

  public synchronized void folderAdded(String path)
  {
    Feedback feedback = new Feedback(path);
    feedbacks.add(feedback);
  }

  public synchronized Feedback fileBegin(String path, long size)
  {
    Feedback feedback = new Feedback(path, size);
    feedbacks.add(feedback);
    return feedback;
  }

  public List<Feedback> getResources()
  {
    return feedbacks;
  }

  public boolean isDone()
  {
    return done;
  }

  public void setDone()
  {
    done = true;
  }

  /**
   * @author Eike Stepper
   */
  public static class Feedback
  {
    public String path;

    public long size;

    public long progress;

    public Feedback(String path, long size)
    {
      this.path = path;
      this.size = size;
    }

    public Feedback(String path)
    {
      this.path = path;
      size = FShareConstants.FOLDER;
      progress = FShareConstants.FOLDER;
    }

    public Feedback(Feedback source)
    {
      path = source.path;
      size = source.size;
    }

    public boolean isDone()
    {
      return progress == size;
    }
  }
}
