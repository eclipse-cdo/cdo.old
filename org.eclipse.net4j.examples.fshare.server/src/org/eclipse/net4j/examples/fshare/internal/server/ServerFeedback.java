package org.eclipse.net4j.examples.fshare.internal.server;

import org.eclipse.net4j.util.concurrent.Worker;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Eike Stepper
 */
public class ServerFeedback
{
  private static long counter;

  private Long id;

  private ServerResource resource;

  private int progress;

  private ServerFeedback(ServerResource resource)
  {
    synchronized (ServerFeedback.class)
    {
      id = ++counter;
    }

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
  public static class Manager extends Worker
  {
    private static final long INTERVAL = 1000L;

    private Server server;

    private Map<ServerResource, ServerFeedback> feedbacks = initFeedbacks();

    public Manager(Server server)
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

    @Override
    protected void work(WorkContext context) throws Exception
    {
      ServerFeedback[] toBeSent = null;
      synchronized (this)
      {
        if (!feedbacks.isEmpty())
        {
          toBeSent = feedbacks.values().toArray(new ServerFeedback[feedbacks.size()]);
          feedbacks = initFeedbacks();
        }
      }

      if (toBeSent != null)
      {
        Arrays.sort(toBeSent, new Comparator<ServerFeedback>()
        {
          public int compare(ServerFeedback f1, ServerFeedback f2)
          {
            return f1.id.compareTo(f2.id);
          }
        });

        for (ServerProtocol session : server.getSessions())
        {
          if (session.isActive())
          {
            session.sendFeedbacks(toBeSent);
          }
        }
      }

      context.nextWork(INTERVAL);
    }

    private HashMap<ServerResource, ServerFeedback> initFeedbacks()
    {
      return new HashMap<ServerResource, ServerFeedback>();
    }
  }
}
