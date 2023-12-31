/**
 * Copyright (c) 2004 - 2010 Eike Stepper (Berlin, Germany) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Eike Stepper - initial API and implementation
 *
 *  Initial Publication:
 *    Eclipse Magazin - http://www.eclipse-magazin.de
 */
package org.eclipse.net4j.examples.internal.fshare;

import org.eclipse.net4j.connector.IConnector;
import org.eclipse.net4j.examples.fshare.common.FShareConstants;
import org.eclipse.net4j.signal.Indication;
import org.eclipse.net4j.signal.Request;
import org.eclipse.net4j.signal.RequestWithConfirmation;
import org.eclipse.net4j.signal.SignalProtocol;
import org.eclipse.net4j.signal.SignalReactor;
import org.eclipse.net4j.util.WrappedException;
import org.eclipse.net4j.util.io.ExtendedDataInputStream;
import org.eclipse.net4j.util.io.ExtendedDataOutputStream;

import org.eclipse.core.runtime.IProgressMonitor;

import java.io.File;

/**
 * @author Eike Stepper
 */
public class ClientProtocol extends SignalProtocol<Client> implements FShareConstants
{
  public ClientProtocol(IConnector connector, Client client)
  {
    super(PROTOCOL_NAME);
    setInfraStructure(client);
    open(connector);
  }

  public Client getClient()
  {
    return getInfraStructure();
  }

  public int[] logon(final String path)
  {
    RequestWithConfirmation<int[]> request = new RequestWithConfirmation<int[]>(this, SIGNAL_LOGON, "Logon")
    {
      @Override
      protected void requesting(ExtendedDataOutputStream out) throws Exception
      {
        out.writeString(path);
      }

      @Override
      protected int[] confirming(ExtendedDataInputStream in) throws Exception
      {
        // rootFolder.size and rootFolder.uploaded
        return new int[] { in.readInt(), in.readInt() };
      }
    };

    try
    {
      return request.send();
    }
    catch (Exception ex)
    {
      throw WrappedException.wrap(ex);
    }
  }

  public int loadChildren(final ClientFolder parent)
  {
    RequestWithConfirmation<Integer> request = new RequestWithConfirmation<Integer>(this, SIGNAL_LOAD_CHILDREN,
        "LoadChildren")
    {
      @Override
      protected void requesting(ExtendedDataOutputStream out) throws Exception
      {
        out.writeString(parent.getPath());
      }

      @Override
      protected Integer confirming(ExtendedDataInputStream in) throws Exception
      {
        int count = in.readInt();
        parent.setSize(count);
        for (int i = 0; i < count; i++)
        {
          String name = in.readString();
          int size = in.readInt();
          int uploaded = in.readInt();

          boolean type = in.readBoolean();
          if (type == FOLDER)
          {
            ClientFolder folder = new ClientFolder(parent, name, size);
            folder.setUploaded(uploaded);
            parent.addChild(folder, false, false);
          }
          else
          {
            ClientFile file = new ClientFile(parent, name, size);
            file.setUploaded(uploaded);
            parent.addChild(file, false, false);
          }
        }

        return count;
      }
    };

    try
    {
      return request.send();
    }
    catch (Exception ex)
    {
      throw WrappedException.wrap(ex);
    }
  }

  public void upload(final ClientResource resource, final File source, final IProgressMonitor monitor)
  {
    Request request = new Request(ClientProtocol.this, SIGNAL_UPLOAD, "Upload")
    {
      @Override
      protected void requesting(ExtendedDataOutputStream out) throws Exception
      {
        out.writeString(resource.getParent().getPath());
        resource.upload(out, source, new byte[16000], monitor);
      }
    };

    try
    {
      monitor.beginTask("", resource.getTotalFileSize());
      request.sendAsync();
    }
    catch (Exception ex)
    {
      throw WrappedException.wrap(ex);
    }
    finally
    {
      monitor.done();
    }
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
          int feedbacksCount = in.readInt();
          for (int i = 0; i < feedbacksCount; i++)
          {
            boolean isFolder = in.readBoolean();
            String path = in.readString();
            int size = in.readInt();
            int progress = in.readInt();
            getClient().setUploadFeedback(isFolder, path, size, progress);
          }
        }
      };

    default:
      return null;
    }
  }
}
