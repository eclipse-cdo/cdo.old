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

  public void sendFeedbacks(final ServerFeedback[] feedbacks)
  {
    Request request = new Request(this, SIGNAL_UPLOAD_FEEDBACK, "UploadFeedback")
    {
      @Override
      protected void requesting(ExtendedDataOutputStream out) throws Exception
      {
        out.writeInt(feedbacks.length);
        for (ServerFeedback feedback : feedbacks)
        {
          ServerResource resource = feedback.getResource();
          out.writeBoolean(resource instanceof ServerFolder);
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
          Server server = getServer();
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
              folder.setUploaded(i + 1);
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
