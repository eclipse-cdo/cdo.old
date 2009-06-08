package org.eclipse.net4j.examples.fshare.internal.server;

import org.eclipse.net4j.examples.fshare.common.FShareConstants;
import org.eclipse.net4j.signal.Indication;
import org.eclipse.net4j.signal.IndicationWithResponse;
import org.eclipse.net4j.signal.SignalProtocol;
import org.eclipse.net4j.signal.SignalReactor;
import org.eclipse.net4j.util.factory.ProductCreationException;
import org.eclipse.net4j.util.io.ExtendedDataInputStream;
import org.eclipse.net4j.util.io.ExtendedDataOutputStream;

import org.eclipse.spi.net4j.ServerProtocolFactory;

import java.io.IOException;

/**
 * @author Eike Stepper
 */
public class ServerProtocol extends SignalProtocol<Server> implements FShareConstants
{
  public ServerProtocol(Server server)
  {
    super(PROTOCOL_NAME);
    setInfraStructure(server);
  }

  public Server getServer()
  {
    return getInfraStructure();
  }

  public void sendFeedback(/* final List<FShareUpload> uploads */)
  {
    // try
    // {
    // new Request(this, SIGNAL_UPLOAD_FEEDBACK, "UploadFeedback")
    // {
    // @Override
    // protected void requesting(ExtendedDataOutputStream out) throws Exception
    // {
    // out.writeInt(uploads.size());
    // for (FShareUpload upload : uploads)
    // {
    // out.writeString(upload.getPath());
    // out.writeBoolean(upload.isDone());
    //
    // List<Feedback> feedbacks = upload.getFeedbacks();
    // out.writeInt(feedbacks.size());
    // for (Feedback feedback : feedbacks)
    // {
    // out.writeString(feedback.path);
    // out.writeLong(feedback.size);
    // out.writeLong(feedback.progress);
    // }
    // }
    // }
    // }.sendAsync();
    // }
    // catch (Exception ex)
    // {
    // throw WrappedException.wrap(ex);
    // }
  }

  @Override
  protected SignalReactor createSignalReactor(short signalID)
  {
    switch (signalID)
    {
    case SIGNAL_LOGON:
      return new IndicationWithResponse(this, SIGNAL_LOGON, "Logon")
      {
        private boolean ok = false;

        @Override
        protected void indicating(ExtendedDataInputStream in) throws Exception
        {
          String path = in.readString();
          if (path.equals(getServer().getRootFolder().getTarget().getAbsolutePath()))
          {
            ok = getServer().addSession(ServerProtocol.this);
          }
        }

        @Override
        protected void responding(ExtendedDataOutputStream out) throws Exception
        {
          out.writeBoolean(ok);
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
          }
        }
      };

    case SIGNAL_UPLOAD:
      return new Indication(this, SIGNAL_UPLOAD, "Upload")
      {

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
            for (int i = 0; i < size; i++)
            {
              readResource(in, buffer, folder);
            }
          }
          else
          {
            ServerFile file = new ServerFile(parent, name, size);
            parent.addChild(file);
            file.writeToDisk(in, buffer);
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
    private Server server;

    public Factory(Server server)
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
