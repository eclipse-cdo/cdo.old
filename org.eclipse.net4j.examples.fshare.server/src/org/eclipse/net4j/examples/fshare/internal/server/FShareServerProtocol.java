package org.eclipse.net4j.examples.fshare.internal.server;

import org.eclipse.net4j.examples.fshare.common.FShareConstants;
import org.eclipse.net4j.signal.IndicationWithMonitoring;
import org.eclipse.net4j.signal.IndicationWithResponse;
import org.eclipse.net4j.signal.SignalProtocol;
import org.eclipse.net4j.signal.SignalReactor;
import org.eclipse.net4j.util.factory.ProductCreationException;
import org.eclipse.net4j.util.io.ExtendedDataInputStream;
import org.eclipse.net4j.util.io.ExtendedDataOutputStream;
import org.eclipse.net4j.util.io.IOUtil;
import org.eclipse.net4j.util.om.monitor.OMMonitor;

import org.eclipse.spi.net4j.ServerProtocolFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

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

  @Override
  protected SignalReactor createSignalReactor(short signalID)
  {
    switch (signalID)
    {
    case SIGNAL_LOGON:
      return new IndicationWithResponse(this, SIGNAL_LOGON)
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
      return new IndicationWithMonitoring(this, SIGNAL_UPLOAD)
      {
        private byte[] buffer = new byte[16000];

        @Override
        protected void indicating(ExtendedDataInputStream in, OMMonitor monitor) throws Exception
        {
          File rootFolder = new File(getInfraStructure().getPath());

          long totalSize = in.readLong();
          monitor.begin(totalSize);

          int count = in.readInt();
          for (int i = 0; i < count; i++)
          {
            String path = in.readString();
            File target = new File(rootFolder, path);

            long size = in.readLong();
            if (size == FOLDER)
            {
              monitor.checkCanceled();
              IOUtil.mkdirs(target);
            }
            else
            {
              readFile(in, target, size, monitor);
            }
          }
        }

        @Override
        protected void responding(ExtendedDataOutputStream out, OMMonitor monitor) throws Exception
        {
          try
          {
            monitor.begin();
            out.writeBoolean(true);
          }
          finally
          {
            monitor.done();
          }
        }

        private void readFile(ExtendedDataInputStream in, File file, long size, OMMonitor monitor) throws IOException
        {
          OutputStream out = null;

          try
          {
            out = new FileOutputStream(file);
            int bufferSize = buffer.length;

            int n = size < bufferSize ? (int)size : bufferSize;
            while (n > 0 && (n = in.read(buffer, 0, n)) != -1)
            {
              out.write(buffer, 0, n);
              monitor.worked(n);
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
