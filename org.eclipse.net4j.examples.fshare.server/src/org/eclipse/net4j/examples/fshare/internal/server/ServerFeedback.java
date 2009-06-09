package org.eclipse.net4j.examples.fshare.internal.server;

import org.eclipse.net4j.util.concurrent.Worker;

import java.util.Comparator;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author Eike Stepper
 */
public class ServerFeedback
{
  private ServerResource resource;

  private int progress;

  private ServerFeedback(ServerResource resource)
  {
    this.resource = resource;
  }

  public ServerResource getResource()
  {
    return resource;
  }

  public int getProgress()
  {
    return progress;
  }

  /**
   * @author Eike Stepper
   */
  public static class Manager extends Worker implements Comparator<ServerResource>
  {
    private static final long INTERVAL = 1000L;

    private ServerApplication server;

    private SortedMap<ServerResource, ServerFeedback> feedbacks = new TreeMap<ServerResource, ServerFeedback>(this);

    public Manager(ServerApplication server)
    {
      this.server = server;
    }

    public synchronized void addFeedback(ServerResource resource, int progress)
    {
      ServerFeedback feedback = feedbacks.get(resource);
      if (feedback == null)
      {
        feedback = new ServerFeedback(resource);
        feedbacks.put(resource, feedback);
      }

      feedback.progress += progress;
    }

    /**
     * The comparator ensures that folders are iterated before their contents. Shorter resource paths come first.
     */
    public int compare(ServerResource r1, ServerResource r2)
    {
      Integer length1 = r1.getPath().length();
      Integer length2 = r2.getPath().length();
      return length1.compareTo(length2);
    }

    @Override
    protected void work(WorkContext context) throws Exception
    {
      SortedMap<ServerResource, ServerFeedback> toBeSent = null;
      synchronized (this)
      {
        if (!feedbacks.isEmpty())
        {
          toBeSent = feedbacks;
          feedbacks = new TreeMap<ServerResource, ServerFeedback>(this);
        }
      }

      if (toBeSent != null)
      {
        for (ServerProtocol session : server.getSessions())
        {
          if (session.isActive())
          {
            session.sendFeedback(toBeSent);
          }
        }
      }

      context.nextWork(INTERVAL);
    }
  }
}
