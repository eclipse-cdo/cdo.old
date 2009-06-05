package org.eclipse.net4j.examples.internal.fshare;

import org.eclipse.net4j.connector.IConnector;
import org.eclipse.net4j.examples.fshare.common.FShareConstants;
import org.eclipse.net4j.signal.RequestWithConfirmation;
import org.eclipse.net4j.signal.SignalProtocol;
import org.eclipse.net4j.util.WrappedException;
import org.eclipse.net4j.util.io.ExtendedDataInputStream;
import org.eclipse.net4j.util.io.ExtendedDataOutputStream;

public class FShareClientProtocol extends SignalProtocol<FileSystem> implements FShareConstants
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
}
