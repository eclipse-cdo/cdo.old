package org.eclipse.net4j.examples.fshare.internal.server;

import org.eclipse.net4j.examples.fshare.common.FShareConstants;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FShareUpload
{
  private FShareServerProtocol session;

  private String path;

  private boolean done;

  private List<Feedback> feedbacks = new LinkedList<Feedback>();

  public FShareUpload(FShareServerProtocol session, String path)
  {
    this.session = session;
    this.path = path;
  }

  public FShareUpload(FShareUpload source)
  {
    synchronized (source)
    {
      session = source.session;
      path = source.path;
      done = source.done;
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

  public FShareServerProtocol getSession()
  {
    return session;
  }

  public String getPath()
  {
    return path;
  }

  public boolean isDone()
  {
    return done;
  }

  public List<Feedback> getFeedbacks()
  {
    return feedbacks;
  }

  public synchronized long getProgress(String path)
  {
    for (Feedback feedback : feedbacks)
    {
      if (path.equals(feedback.path))
      {
        return feedback.progress;
      }
    }

    return FShareConstants.FOLDER;
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

  public synchronized void setDone()
  {
    done = true;
  }

  /**
   * @author Eike Stepper
   */
  public static class Feedback
  {
    public volatile String path;

    public volatile long size;

    public volatile long progress;

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
      progress = source.progress;
    }

    public boolean isDone()
    {
      return progress == size;
    }
  }
}
