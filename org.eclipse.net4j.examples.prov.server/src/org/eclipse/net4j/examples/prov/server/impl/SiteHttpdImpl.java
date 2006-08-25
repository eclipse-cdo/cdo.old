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
package org.eclipse.net4j.examples.prov.server.impl;


import org.eclipse.net4j.examples.prov.server.SiteHttpd;
import org.eclipse.net4j.examples.prov.server.SiteManager;
import org.eclipse.net4j.spring.ValidationException;

import java.util.Properties;


public class SiteHttpdImpl extends FileHttpdImpl implements SiteHttpd
{
  protected SiteManager siteManager;

  protected Response overrideUri(String path, String method, Properties headers, Properties parms)
  {
    if (path.equals(SITE_MANIFEST))
    {
      return serveSiteManifest();
    }

    return null;
  }

  protected Response serveSiteManifest()
  {
    String data = siteManager.generateManifest();
    return new Response(HTTP_OK, MIME_PLAINTEXT, data);
  }

  public SiteManager getSiteManager()
  {
    return siteManager;
  }

  public void setSiteManager(SiteManager siteManager)
  {
    doSet("siteManager", siteManager);
  }

  public String getDocumentRoot()
  {
    return getSiteManager().getRootFolder().getFullPath().toString();
  }

  public void setDocumentRoot(String documentRoot)
  {
    throw new UnsupportedOperationException("setDocumentRoot() is not allowed for sites");
  }

  protected void validate() throws ValidationException
  {
    // Set private field in super class to prevent ValidationException
    super.setDocumentRoot(getDocumentRoot());

    super.validate();
    assertNotNull("siteManager");
  }
}
