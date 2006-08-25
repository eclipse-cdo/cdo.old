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
package org.eclipse.net4j.examples.prov.server;


import org.eclipse.net4j.spring.Service;


public interface Httpd extends Service
{
  public static final String HTTP_OK = "200 OK";

  public static final String HTTP_REDIRECT = "301 Moved Permanently";

  public static final String HTTP_REDIRECT_TEMP = "307 Temporary Redirect";

  public static final String HTTP_FORBIDDEN = "403 Forbidden";

  public static final String HTTP_NOTFOUND = "404 Not Found";

  public static final String HTTP_BADREQUEST = "400 Bad Request";

  public static final String HTTP_INTERNALERROR = "500 Internal Server Error";

  public static final String HTTP_NOTIMPLEMENTED = "501 Not Implemented";

  public static final String MIME_PLAINTEXT = "text/plain";

  public static final String MIME_HTML = "text/html";

  public static final String MIME_DEFAULT_BINARY = "application/octet-stream";

  public int getPort();

  public void addMimeType(String extension, String mimeType);

  public String removeMimeType(String extension);

  public String getMimeType(String extension);
}
