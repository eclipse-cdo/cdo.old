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

import org.eclipse.net4j.util.io.ExtendedDataInputStream;
import org.eclipse.net4j.util.io.IOUtil;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author Eike Stepper
 */
public class ServerFile extends ServerResource
{
  public ServerFile(ServerFolder parent, String name, int size)
  {
    super(parent, name, size);
  }

  public void writeToDisk(ExtendedDataInputStream in, byte[] buffer, ServerFeedback.Manager feedbackManager)
      throws IOException
  {
    int rest = getSize();
    OutputStream out = null;

    try
    {
      out = new FileOutputStream(getTarget());
      feedbackManager.addFeedback(this, 0);

      int n = Math.min(rest, buffer.length);
      while (n > 0 && (n = in.read(buffer, 0, n)) != -1)
      {
        out.write(buffer, 0, n);
        setUploaded(getUploaded() + n);
        feedbackManager.addFeedback(this, n);
        rest -= n;
        n = Math.min(rest, buffer.length);
      }
    }
    finally
    {
      IOUtil.close(out);
    }
  }
}
