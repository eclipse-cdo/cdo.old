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
package org.eclipse.net4j.examples.prov.client.protocol;


import org.eclipse.net4j.core.impl.AbstractRequestWithConfirmation;
import org.eclipse.net4j.examples.prov.Feature;
import org.eclipse.net4j.examples.prov.ProvFactory;
import org.eclipse.net4j.examples.prov.ProvisioningProtocol;
import org.eclipse.net4j.util.IOHelper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;


public class UploadArchiveRequest extends AbstractRequestWithConfirmation
{
  private String fileName;

  public UploadArchiveRequest(String fileName)
  {
    this.fileName = fileName;
  }

  public short getSignalId()
  {
    return ProvisioningProtocol.UPLOAD_ARCHIVE;
  }

  public void request()
  {
    InputStream is = null;

    try
    {
      File file = new File(fileName);
      transmitString(file.getName());

      long size = file.length();
      transmitLong(size);

      is = new FileInputStream(file);
      byte[] buffer = new byte[4096];
      int read;

      while ((read = is.read(buffer)) != -1)
      {
        for (int i = 0; i < read; i++)
        {
          transmitByte(buffer[i]);
        }
      }
    }
    catch (FileNotFoundException ex)
    {
      error("Archive not found: " + fileName, ex);
    }
    catch (IOException ex)
    {
      error("Error while reading archive: " + fileName, ex);
    }
    finally
    {
      IOHelper.close(is);
    }
  }

  public Object confirm()
  {
    int count = receiveInt();

    if (count == -1)
    {
      return null;
    }

    Feature[] features = new Feature[count];

    for (int i = 0; i < count; i++)
    {
      String id = receiveString();
      String version = receiveString();

      features[i] = ProvFactory.eINSTANCE.createFeature();
      features[i].setId(id);
      features[i].setVersion(version);
    }

    return features;
  }
}
