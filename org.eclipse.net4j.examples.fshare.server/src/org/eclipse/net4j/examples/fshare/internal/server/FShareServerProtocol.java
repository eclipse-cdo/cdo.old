package org.eclipse.net4j.examples.fshare.internal.server;

import org.eclipse.net4j.examples.fshare.common.FShareConstants;
import org.eclipse.net4j.examples.fshare.internal.server.FShareUpload.Feedback;
import org.eclipse.net4j.signal.Indication;
import org.eclipse.net4j.signal.IndicationWithResponse;
import org.eclipse.net4j.signal.Request;
import org.eclipse.net4j.signal.SignalProtocol;
import org.eclipse.net4j.signal.SignalReactor;
import org.eclipse.net4j.util.WrappedException;
import org.eclipse.net4j.util.factory.ProductCreationException;
import org.eclipse.net4j.util.io.ExtendedDataInputStream;
import org.eclipse.net4j.util.io.ExtendedDataOutputStream;
import org.eclipse.net4j.util.io.IOUtil;

import org.eclipse.spi.net4j.ServerProtocolFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * @author Eike Stepper
 */
public class FShareServerProtocol extends SignalProtocol<FShareServer> implements FShareConstants
{
  public FShareServerProtocol(FShareServer server)
  {
    super(PROTOCOL_NAME);
    setInfraStructure(server);
  }

  public void notifyUploads(final List<FShareUpload> uploads)
  {
    try
    {
      new Request(this, SIGNAL_UPLOAD_FEEDBACK, "UploadFeedback")
      {
        @Override
        protected void requesting(ExtendedDataOutputStream out) throws Exception
        {
          out.writeInt(uploads.size());
          for (FShareUpload upload : uploads)
          {
            out.writeBoolean(upload.isDone());

            List<Feedback> feedbacks = upload.getFeedbacks();
            out.writeInt(feedbacks.size());
            for (Feedback feedback : feedbacks)
            {
              out.writeString(feedback.path);
              out.writeLong(feedback.size);
              out.writeLong(feedback.progress);
            }
          }
        }
      }.sendAsync();
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
        private boolean ok = false;

        @Override
        protected void indicating(ExtendedDataInputStream in) throws Exception
        {
          String path = in.readString();
          String path2 = getInfraStructure().getPath();
          if (path2.equals(path))
          {
            ok = getInfraStructure().addSession(FShareServerProtocol.this);
          }
        }

        @Override
        protected void responding(ExtendedDataOutputStream out) throws Exception
        {
          out.writeBoolean(ok);
        }
      };

    case SIGNAL_UPLOAD:
      return new Indication(this, SIGNAL_UPLOAD, "Upload")
      {
        private File rootFolder = new File(getInfraStructure().getPath());

        private FShareUpload upload = getInfraStructure().addUpload(FShareServerProtocol.this);

        private byte[] buffer = new byte[16000];

        @Override
        protected void indicating(ExtendedDataInputStream in) throws Exception
        {
          int count = in.readInt();
          for (int i = 0; i < count; i++)
          {
            String path = in.readString();
            File target = new File(rootFolder, path);

            long size = in.readLong();
            if (size == FOLDER)
            {
              IOUtil.mkdirs(target);
              upload.folderAdded(path);
            }
            else
            {
              readFile(in, path, size);
            }
          }

          upload.setDone();
        }

        private void readFile(ExtendedDataInputStream in, String path, long size) throws IOException
        {
          OutputStream out = null;
          Feedback feedback = upload.fileBegin(path, size);

          try
          {
            out = new FileOutputStream(new File(rootFolder, path));
            int bufferSize = buffer.length;

            int n = size < bufferSize ? (int)size : bufferSize;
            while (n > 0 && (n = in.read(buffer, 0, n)) != -1)
            {
              out.write(buffer, 0, n);
              feedback.progress += n;
              size -= n;
              n = size < bufferSize ? (int)size : bufferSize;
            }
          }
          finally
          {
            IOUtil.close(out);
          }
        }
      };

      // return new IndicationWithMonitoring(this, SIGNAL_UPLOAD)
      // {
      // private byte[] buffer = new byte[16000];
      //
      // @Override
      // protected void indicating(ExtendedDataInputStream in, OMMonitor monitor) throws Exception
      // {
      // File rootFolder = new File(getInfraStructure().getPath());
      //
      // long totalSize = in.readLong();
      // monitor.begin(totalSize);
      //
      // int count = in.readInt();
      // for (int i = 0; i < count; i++)
      // {
      // String path = in.readString();
      // File target = new File(rootFolder, path);
      //
      // long size = in.readLong();
      // if (size == FOLDER)
      // {
      // monitor.checkCanceled();
      // IOUtil.mkdirs(target);
      // }
      // else
      // {
      // readFile(in, target, size, monitor);
      // }
      // }
      // }
      //
      // @Override
      // protected void responding(ExtendedDataOutputStream out, OMMonitor monitor) throws Exception
      // {
      // try
      // {
      // monitor.begin();
      // out.writeBoolean(true);
      // }
      // finally
      // {
      // monitor.done();
      // }
      // }
      //
      // private void readFile(ExtendedDataInputStream in, File file, long size, OMMonitor monitor) throws IOException
      // {
      // OutputStream out = null;
      //
      // try
      // {
      // out = new FileOutputStream(file);
      // int bufferSize = buffer.length;
      //
      // int n = size < bufferSize ? (int)size : bufferSize;
      // while (n > 0 && (n = in.read(buffer, 0, n)) != -1)
      // {
      // out.write(buffer, 0, n);
      // monitor.worked(n);
      // size -= n;
      // n = size < bufferSize ? (int)size : bufferSize;
      // }
      // }
      // finally
      // {
      // IOUtil.close(out);
      // }
      // }
      // };
      //
    default:
      return null;
    }
  }

  /**
   * @author Eike Stepper
   */
  public static class Factory extends ServerProtocolFactory
  {
    private FShareServer server;

    public Factory(FShareServer server)
    {
      super(PROTOCOL_NAME);
      this.server = server;
    }

    public Object create(String description) throws ProductCreationException
    {
      return new FShareServerProtocol(server);
    }
  }
}
