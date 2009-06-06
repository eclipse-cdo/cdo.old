package org.eclipse.net4j.examples.fshare.internal.server;

import org.eclipse.net4j.examples.fshare.common.FShareConstants;
import org.eclipse.net4j.signal.IndicationWithResponse;
import org.eclipse.net4j.signal.SignalProtocol;
import org.eclipse.net4j.signal.SignalReactor;
import org.eclipse.net4j.util.factory.ProductCreationException;
import org.eclipse.net4j.util.io.ExtendedDataInputStream;
import org.eclipse.net4j.util.io.ExtendedDataOutputStream;

import org.eclipse.spi.net4j.ServerProtocolFactory;

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
            ok = true;
          }
        }

        @Override
        protected void responding(ExtendedDataOutputStream out) throws Exception
        {
          out.writeBoolean(ok);
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
