package org.eclipse.net4j.examples.internal.fshare;

import org.eclipse.net4j.examples.fshare.IFile;
import org.eclipse.net4j.examples.fshare.common.FShareConstants;
import org.eclipse.net4j.util.io.ExtendedDataOutputStream;
import org.eclipse.net4j.util.io.IOUtil;

import org.eclipse.core.runtime.IProgressMonitor;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Eike Stepper
 */
public class ClientFile extends ClientResource implements IFile
{
  public ClientFile(ClientFolder parent, String name, int size)
  {
    super(parent.getFileSystem(), parent, name, size);
  }

  @Override
  public void upload(ExtendedDataOutputStream out, File source, byte[] buffer, IProgressMonitor monitor)
      throws IOException
  {
    super.upload(out, source, buffer, monitor);
    out.writeBoolean(FShareConstants.FILE);

    InputStream in = null;
    int rest = getSize();

    try
    {
      in = new FileInputStream(source);
      int n = Math.min(rest, buffer.length);
      while (n > 0 && (n = in.read(buffer, 0, n)) != -1)
      {
        out.write(buffer, 0, n);
        monitor.worked(n);
        rest -= n;
        n = Math.min(rest, buffer.length);
      }
    }
    finally
    {
      IOUtil.close(in);
      monitor.setTaskName("");
    }
  }

  @Override
  public int getTotalFileSize()
  {
    return getSize();
  }
}
