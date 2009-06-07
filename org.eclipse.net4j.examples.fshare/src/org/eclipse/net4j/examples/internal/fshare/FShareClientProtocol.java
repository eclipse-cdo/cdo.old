package org.eclipse.net4j.examples.internal.fshare;

import org.eclipse.net4j.connector.IConnector;
import org.eclipse.net4j.examples.fshare.common.FShareConstants;
import org.eclipse.net4j.examples.internal.fshare.bundle.OM;
import org.eclipse.net4j.signal.Indication;
import org.eclipse.net4j.signal.Request;
import org.eclipse.net4j.signal.RequestWithConfirmation;
import org.eclipse.net4j.signal.SignalProtocol;
import org.eclipse.net4j.signal.SignalReactor;
import org.eclipse.net4j.util.WrappedException;
import org.eclipse.net4j.util.io.ExtendedDataInputStream;
import org.eclipse.net4j.util.io.ExtendedDataOutputStream;
import org.eclipse.net4j.util.io.IOUtil;

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
  public FShareClientProtocol(IConnector connector, FShareFileSystem fileSystem)
  {
    super(PROTOCOL_NAME);
    setInfraStructure(fileSystem);
    open(connector);
  }

  public void logon(final String path)
  {
    try
    {
      boolean ok = new RequestWithConfirmation<Boolean>(this, SIGNAL_LOGON, "Logon")
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
    new Job("Uploading " + source)
    {
      @Override
      protected IStatus run(final IProgressMonitor monitor)
      {
        try
        {
          new Request(FShareClientProtocol.this, SIGNAL_UPLOAD, "Upload")
          {
            private List<FShareResource> resources = new ArrayList<FShareResource>();

            private int totalSize;

            private byte[] buffer = new byte[16000];

            @Override
            protected void requesting(ExtendedDataOutputStream out) throws Exception
            {
              collectFiles(resource);
              monitor.beginTask(getName(), totalSize);

              try
              {
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

            private void writeFile(ExtendedDataOutputStream out, File file, long size, IProgressMonitor monitor)
                throws IOException
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
          }.sendAsync();
        }
        catch (Exception ex)
        {
          return new Status(IStatus.ERROR, OM.BUNDLE_ID, "Problem while uploading " + resource, ex);
        }

        return Status.OK_STATUS;
      }
    }.schedule();

    // final RequestWithMonitoring<Boolean> request_ = new RequestWithMonitoring<Boolean>(this, SIGNAL_UPLOAD)
    // {
    // private List<FShareResource> resources = new ArrayList<FShareResource>();
    //
    // private long totalSize;
    //
    // private byte[] buffer = new byte[16000];
    //
    // @Override
    // protected void requesting(ExtendedDataOutputStream out, OMMonitor monitor) throws Exception
    // {
    // try
    // {
    // collectFiles(resource);
    // monitor.begin(totalSize);
    // out.writeLong(totalSize);
    // out.writeInt(resources.size());
    //
    // for (FShareResource resource : resources)
    // {
    // String path = resource.getPath();
    // out.writeString(path);
    // if (resource instanceof FShareFile)
    // {
    // FShareFile file = (FShareFile)resource;
    // long size = file.getSize();
    // out.writeLong(size);
    // writeFile(out, new File(source.getParentFile(), path), size, monitor);
    // }
    // else
    // {
    // out.writeLong(FOLDER);
    // }
    // }
    // }
    // finally
    // {
    // monitor.done();
    // }
    // }
    //
    // @Override
    // protected Boolean confirming(ExtendedDataInputStream in, OMMonitor monitor) throws Exception
    // {
    // try
    // {
    // monitor.begin();
    // return in.readBoolean();
    // }
    // finally
    // {
    // monitor.done();
    // }
    // }
    //
    // private void collectFiles(FShareResource resource)
    // {
    // resources.add(resource);
    // if (resource instanceof FShareFile)
    // {
    // FShareFile file = (FShareFile)resource;
    // totalSize += file.getSize();
    // }
    // else
    // {
    // FShareFolder folder = (FShareFolder)resource;
    // for (FShareResource child : folder.getChildren())
    // {
    // collectFiles(child);
    // }
    // }
    // }
    //
    // private void writeFile(ExtendedDataOutputStream out, File file, long size, OMMonitor monitor) throws IOException
    // {
    // InputStream in = null;
    //
    // try
    // {
    // in = new FileInputStream(file);
    // int bufferSize = buffer.length;
    // int n = size < bufferSize ? (int)size : bufferSize;
    //
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
    // IOUtil.close(in);
    // }
    // }
    // };

    // new Job("Uploading " + source)
    // {
    // @Override
    // protected IStatus run(IProgressMonitor monitor)
    // {
    // try
    // {
    // request.send(new EclipseMonitor(monitor));
    // }
    // catch (Exception ex)
    // {
    // return new Status(IStatus.ERROR, OM.BUNDLE_ID, "Problem while uploading " + resource, ex);
    // }
    //
    // return Status.OK_STATUS;
    // }
    // }.schedule();
  }

  @Override
  protected SignalReactor createSignalReactor(short signalID)
  {
    switch (signalID)
    {
    case SIGNAL_UPLOAD_FEEDBACK:
      return new Indication(this, SIGNAL_UPLOAD_FEEDBACK, "UploadFeedback")
      {
        @Override
        protected void indicating(ExtendedDataInputStream in) throws Exception
        {
          int uploadsCount = in.readInt();
          for (int i = 0; i < uploadsCount; i++)
          {
            String basePath = in.readString();
            boolean uploadDone = in.readBoolean();

            int resourcesCount = in.readInt();
            for (int j = 0; j < resourcesCount; j++)
            {
              String path = in.readString();
              long size = in.readLong();
              long progress = in.readLong();
              getInfraStructure().setUploadFeedback(path, size, progress);
            }

            if (uploadDone)
            {
              FShareFolder baseFolder = (FShareFolder)getInfraStructure().getResource(basePath);
              baseFolder.setLocked(false);
            }
          }
        }
      };

    default:
      return null;
    }
  }
}
