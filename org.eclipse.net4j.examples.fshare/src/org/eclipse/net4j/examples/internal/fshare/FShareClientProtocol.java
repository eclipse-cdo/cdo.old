package org.eclipse.net4j.examples.internal.fshare;

import org.eclipse.net4j.connector.IConnector;
import org.eclipse.net4j.examples.fshare.common.FShareConstants;
import org.eclipse.net4j.examples.internal.fshare.bundle.OM;
import org.eclipse.net4j.signal.RequestWithConfirmation;
import org.eclipse.net4j.signal.RequestWithMonitoring;
import org.eclipse.net4j.signal.SignalProtocol;
import org.eclipse.net4j.util.WrappedException;
import org.eclipse.net4j.util.io.ExtendedDataInputStream;
import org.eclipse.net4j.util.io.ExtendedDataOutputStream;
import org.eclipse.net4j.util.io.IOUtil;
import org.eclipse.net4j.util.om.monitor.EclipseMonitor;
import org.eclipse.net4j.util.om.monitor.OMMonitor;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Eike Stepper
 */
public class FShareClientProtocol extends SignalProtocol<FShareFileSystem> implements FShareConstants
{
  public FShareClientProtocol(IConnector connector)
  {
    super(PROTOCOL_NAME);
    open(connector);
  }

  public void logon(final String path)
  {
    try
    {
      boolean ok = new RequestWithConfirmation<Boolean>(this, SIGNAL_LOGON)
      {
        @Override
        protected void requesting(ExtendedDataOutputStream out) throws Exception
        {
          out.writeString(path);
        }

        @Override
        protected Boolean confirming(ExtendedDataInputStream in) throws Exception
        {
          return in.readBoolean();
        }
      }.send();

      if (!ok)
      {
        throw new SecurityException("Logon failed");
      }
    }
    catch (Exception ex)
    {
      throw WrappedException.wrap(ex);
    }
  }

  public void upload(final FShareResource resource, final File source)
  {
    final RequestWithMonitoring<Boolean> request = new RequestWithMonitoring<Boolean>(this, SIGNAL_UPLOAD)
    {
      private List<FShareResource> resources = new ArrayList<FShareResource>();

      private long totalSize;

      private byte[] buffer = new byte[16000];

      @Override
      protected void requesting(ExtendedDataOutputStream out, OMMonitor monitor) throws Exception
      {
        try
        {
          collectFiles(resource);
          monitor.begin(totalSize);
          out.writeLong(totalSize);
          out.writeInt(resources.size());

          for (FShareResource resource : resources)
          {
            String path = resource.getPath();
            out.writeString(path);
            if (resource instanceof FShareFile)
            {
              FShareFile file = (FShareFile)resource;
              long size = file.getSize();
              out.writeLong(size);
              writeFile(out, new File(source.getParentFile(), path), size, monitor);
            }
            else
            {
              out.writeLong(FOLDER);
            }
          }
        }
        finally
        {
          monitor.done();
        }
      }

      @Override
      protected Boolean confirming(ExtendedDataInputStream in, OMMonitor monitor) throws Exception
      {
        try
        {
          monitor.begin();
          return in.readBoolean();
        }
        finally
        {
          monitor.done();
        }
      }

      private void collectFiles(FShareResource resource)
      {
        resources.add(resource);
        if (resource instanceof FShareFile)
        {
          FShareFile file = (FShareFile)resource;
          totalSize += file.getSize();
        }
        else
        {
          FShareFolder folder = (FShareFolder)resource;
          for (FShareResource child : folder.getChildren())
          {
            collectFiles(child);
          }
        }
      }

      private void writeFile(ExtendedDataOutputStream out, File file, long size, OMMonitor monitor) throws IOException
      {
        InputStream in = null;

        try
        {
          in = new FileInputStream(file);
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
          IOUtil.close(in);
        }
      }
    };

    new Job("Uploading " + source)
    {
      @Override
      protected IStatus run(IProgressMonitor monitor)
      {
        try
        {
          request.send(new EclipseMonitor(monitor));
        }
        catch (Exception ex)
        {
          return new Status(IStatus.ERROR, OM.BUNDLE_ID, "Problem while uploading " + resource, ex);
        }

        return Status.OK_STATUS;
      }
    }.schedule();
  }
}
