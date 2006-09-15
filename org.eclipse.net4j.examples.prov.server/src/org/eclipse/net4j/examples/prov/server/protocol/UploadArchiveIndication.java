/***************************************************************************
 * Copyright (c) 2004, 2005, 2006 Eike Stepper, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 **************************************************************************/
package org.eclipse.net4j.examples.prov.server.protocol;


import org.eclipse.net4j.core.ITempManager;
import org.eclipse.net4j.core.Indication;
import org.eclipse.net4j.core.impl.AbstractIndicationWithResponse;
import org.eclipse.net4j.examples.prov.Feature;
import org.eclipse.net4j.examples.prov.ProvisioningProtocol;
import org.eclipse.net4j.examples.prov.server.SiteManager;
import org.eclipse.net4j.util.IOHelper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;


public class UploadArchiveIndication extends AbstractIndicationWithResponse implements Indication
{
  private Feature[] features;

  private ITempManager tempManager;

  public UploadArchiveIndication(ITempManager tempManager)
  {
    this.tempManager = tempManager;
  }

  public short getSignalId()
  {
    return ProvisioningProtocol.UPLOAD_ARCHIVE;
  }

  public void indicate()
  {
    String fileName = receiveString();
    long size = receiveLong();

    byte[] buffer = new byte[4096];
    int bufferSize = 0;

    File temp = null;
    File file = null;
    OutputStream os = null;

    try
    {
      temp = tempManager.createTempFolder("upload");
      file = new File(temp, fileName);
      os = new FileOutputStream(file);

      for (int i = 0; i < size; i++)
      {
        buffer[bufferSize++] = receiveByte();

        if (bufferSize == buffer.length)
        {
          os.write(buffer);
          bufferSize = 0;
        }
      }

      if (bufferSize > 0)
      {
        os.write(buffer, 0, bufferSize);
      }
    }
    catch (IOException ex)
    {
      error("Error while receiving archive", ex);
    }
    finally
    {
      IOHelper.close(os);
    }

    if (file != null)
    {
      features = getSiteManager().addResource(file, fileName);
    }

    tempManager.release(temp);
  }

  public void respond()
  {
    if (features == null)
    {
      transmitInt(-1);
    }
    else
    {
      transmitInt(features.length);

      for (int i = 0; i < features.length; i++)
      {
        Feature feature = features[i];
        transmitString(feature.getId());
        transmitString(feature.getVersion());
      }
    }
  }

  private SiteManager getSiteManager()
  {
    return ((ProvisioningServerProtocol)getProtocol()).getSiteManager();
  }
}
