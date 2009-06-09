package org.eclipse.net4j.examples.fshare.internal.server;

import org.eclipse.net4j.examples.fshare.common.FShareConstants;
import org.eclipse.net4j.signal.Indication;
import org.eclipse.net4j.signal.IndicationWithResponse;
import org.eclipse.net4j.signal.Request;
import org.eclipse.net4j.signal.SignalProtocol;
import org.eclipse.net4j.signal.SignalReactor;
import org.eclipse.net4j.util.WrappedException;
import org.eclipse.net4j.util.factory.ProductCreationException;
import org.eclipse.net4j.util.io.ExtendedDataInputStream;
import org.eclipse.net4j.util.io.ExtendedDataOutputStream;

import org.eclipse.spi.net4j.ServerProtocolFactory;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

/**
 * @author Eike Stepper
 */
public class ServerProtocol extends SignalProtocol<ServerApplication> implements FShareConstants
{
  public ServerProtocol(ServerApplication server)
  {
    super(PROTOCOL_NAME);
    setInfraStructure(server);
  }

  public ServerApplication getServer()
  {
    return getInfraStructure();
  }

  public void sendFeedbacks(final Collection<ServerFeedback> feedbacks)
  {
    Request request = new Request(this, SIGNAL_UPLOAD_FEEDBACK, "UploadFeedback")
    {
      @Override
      protected void requesting(ExtendedDataOutputStream out) throws Exception
      {
        out.writeInt(feedbacks.size());
        for (ServerFeedback feedback : feedbacks)
        {
          ServerResource resource = feedback.getResource();
          out.writeString(resource.getPath());
          out.writeInt(resource.getSize());
          out.writeInt(feedback.getProgress());
        }
      }
    };

    try
    {
      request.sendAsync();
    }
    catch (Exception ex)
    {
      throw WrappedException.wrap(ex);
    }
  }

  @Override
  protected SignalReactor createSignalReactor(short signalID)
  {
    switch (signalID)
    {
    case SIGNAL_LOGON:
      return new IndicationWithResponse(this, SIGNAL_LOGON, "Logon")
      {
        @Override
        protected void indicating(ExtendedDataInputStream in) throws Exception
        {
          String logonPath = new File(in.readString()).getAbsolutePath();
          String serverPath = getServer().getRootFolder().getTarget().getAbsolutePath();
          if (!logonPath.equals(serverPath))
          {
            throw new SecurityException("Logon denied");
          }
        }

        @Override
        protected void responding(ExtendedDataOutputStream out) throws Exception
        {
          ServerApplication server = getServer();
          server.addSession(ServerProtocol.this);

          ServerFolder rootFolder = server.getRootFolder();
          out.writeInt(rootFolder.getSize());
          out.writeInt(rootFolder.getUploaded());
        }
      };

    case SIGNAL_LOAD_CHILDREN:
      return new IndicationWithResponse(this, SIGNAL_LOAD_CHILDREN, "LoadChildren")
      {
        private ServerFolder folder;

        @Override
        protected void indicating(ExtendedDataInputStream in) throws Exception
        {
          String path = in.readString();
          folder = (ServerFolder)getServer().getResource(path);
        }

        @Override
        protected void responding(ExtendedDataOutputStream out) throws Exception
        {
          ServerResource[] children = folder.getChildren();
          out.writeInt(children.length);
          for (ServerResource child : children)
          {
            out.writeString(child.getName());
            out.writeInt(child.getSize());
            out.writeInt(child.getUploaded());
            out.writeBoolean(child instanceof ServerFolder);
          }
        }
      };

    case SIGNAL_UPLOAD:
      return new Indication(this, SIGNAL_UPLOAD, "Upload")
      {
        ServerFeedback.Manager feedbackManager = getServer().getFeedbackManager();

        @Override
        protected void indicating(ExtendedDataInputStream in) throws Exception
        {
          String parentPath = in.readString();
          ServerFolder parent = (ServerFolder)getServer().getResource(parentPath);
          readResource(in, new byte[16000], parent);
        }

        private void readResource(ExtendedDataInputStream in, byte[] buffer, ServerFolder parent) throws IOException
        {
          String name = in.readString();
          int size = in.readInt();
          boolean type = in.readBoolean();
          if (type == FOLDER)
          {
            ServerFolder folder = new ServerFolder(parent, name, size);
            parent.addChild(folder);
            folder.mkdirs();
            feedbackManager.addFeedback(folder, 0);
            for (int i = 0; i < size; i++)
            {
              readResource(in, buffer, folder);
              feedbackManager.addFeedback(folder, 1);
            }
          }
          else
          {
            ServerFile file = new ServerFile(parent, name, size);
            parent.addChild(file);
            file.writeToDisk(in, buffer, feedbackManager);
          }
        }
      };

    default:
      return null;
    }
  }

  /**
   * @author Eike Stepper
   */
  public static class Factory extends ServerProtocolFactory
  {
    private ServerApplication server;

    public Factory(ServerApplication server)
    {
      super(PROTOCOL_NAME);
      this.server = server;
    }

    public Object create(String description) throws ProductCreationException
    {
      return new ServerProtocol(server);
    }
  }
}
