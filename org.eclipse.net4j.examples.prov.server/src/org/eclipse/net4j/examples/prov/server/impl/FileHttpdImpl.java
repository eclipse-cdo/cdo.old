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


import org.eclipse.net4j.examples.prov.server.FileHttpd;
import org.eclipse.net4j.spring.ValidationException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;

import java.io.File;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;


public class FileHttpdImpl extends AbstractHttpd implements FileHttpd
{
  private static final long KB = 1024;

  private static final long MB = KB * KB;

  private static final long GB = MB * KB;

  private String documentRoot;

  private boolean allowDirectoryListing;

  private boolean autoSync;

  private List welcomePages;

  private transient IFolder rootFolder;

  protected Response serve(String uri, String method, Properties headers, Properties parms)
  {
    if (isDebugEnabled())
    {
      dump(uri, method, headers, parms);
    }

    // Remove URL arguments
    uri = uri.trim().replace(File.separatorChar, '/');

    if (uri.indexOf('?') >= 0)
    {
      uri = uri.substring(0, uri.indexOf('?'));
    }

    // Prohibit getting out of current directory
    if (uri.indexOf("..") != -1)
    {
      return new Response(HTTP_FORBIDDEN, MIME_PLAINTEXT,
              "FORBIDDEN: Won't serve .. for security reasons.");
    }

    Response overridden = overrideUri(uri, method, headers, parms);
    if (overridden != null)
    {
      return overridden;
    }

    IFolder folder = rootFolder.getFolder(uri);
    boolean folderExists = folder.exists();
    if (!folderExists && autoSync)
    {
      folderExists = sync(folder);
    }

    if (folderExists)
    {
      // Browsers get confused without '/' after the directory, send a redirect.
      if (!uri.endsWith("/"))
      {
        uri += "/";
        String data = "<html><body>Redirected: <a href=\"" + uri + "\">" + uri
                + "</a></body></html>";
        Response r = new Response(HTTP_REDIRECT_TEMP, MIME_HTML, data);
        r.addHeader("Location", uri);
        return r;
      }

      for (Iterator it = welcomePages.iterator(); it.hasNext();)
      {
        String welcomePage = (String)it.next();
        IFile file = folder.getFile(welcomePage);
        if (file.exists())
        {
          return serveFile(file, uri + "/" + welcomePage, headers);
        }
      }

      if (!allowDirectoryListing)
      {
        return new Response(HTTP_FORBIDDEN, MIME_PLAINTEXT, "FORBIDDEN: No directory listing.");
      }

      return serveFolder(folder, uri, headers);
    }

    IFile file = rootFolder.getFile(uri);
    boolean fileExists = file.exists();
    if (!fileExists && autoSync)
    {
      fileExists = sync(file);
    }

    if (fileExists)
    {
      return serveFile(file, uri, headers);
    }

    return new Response(HTTP_NOTFOUND, MIME_PLAINTEXT, "Error 404, file not found.");
  }

  private boolean sync(IResource resource)
  {
    File fs = new File(resource.getLocation().toString());
    if (!fs.exists())
    {
      return false;
    }

    try
    {
      resource.refreshLocal(IResource.DEPTH_ZERO, new NullProgressMonitor());
    }
    catch (CoreException ex)
    {
      warn("Can't refresh resource " + resource, ex);
      return false;
    }

    return resource.exists();
  }

  protected Response serveFolder(IFolder folder, String path, Properties headers)
  {
    String msg = "<html><body><h1>Directory " + path + "</h1><br/>";

    if (path.length() > 1)
    {
      String u = path.substring(0, path.length() - 1);
      int slash = u.lastIndexOf('/');

      if (slash >= 0 && slash < u.length())
      {
        msg += "<b><a href=\"" + path.substring(0, slash + 1) + "\">..</a></b><br/>";
      }
    }

    try
    {
      IResource[] resources = folder.members();

      for (int i = 0; i < resources.length; ++i)
      {
        boolean dir = resources[i] instanceof IFolder;
        String member = resources[i].getName();

        if (dir)
        {
          msg += "<b>";
          member += "/";
        }

        msg += "<a href=\"" + encodeUri(path + member) + "\">" + member + "</a>";

        // Show file size
        if (!dir)
        {
          long len = getFileLength((IFile)resources[i]);
          msg += " &nbsp;<font size=2>(";

          if (len == 1)
          {
            msg += "1 byte";
          }
          else if (len < KB)
          {
            msg += len + " bytes";
          }
          else if (len < MB)
          {
            msg += len / KB + "." + (len % KB / 10 % 100) + " KB";
          }
          else if (len < GB)
          {
            msg += len / MB + "." + len % MB / 10 % 100 + " MB";
          }
          else
          {
            msg += len / GB + "." + (len % GB / 10 % 100) + " GB";
          }

          msg += ")</font>";
        }

        msg += "<br/>";

        if (dir)
        {
          msg += "</b>";
        }
      }
    }
    catch (Exception ex)
    {
      error("Error while listing directory", ex);
    }

    return new Response(HTTP_OK, MIME_HTML, msg);
  }

  protected long getFileLength(IFile file)
  {
    return new File(file.getLocation().toString()).length();
  }

  protected Response serveFile(IFile file, String path, Properties headers)
  {
    String mime = getMimeType(file);
    long len = getFileLength(file);

    try
    {
      // Support (simple) skipping:
      long startFrom = 0;
      String range = headers.getProperty("Range");

      if (range != null)
      {
        if (range.startsWith("bytes="))
        {
          range = range.substring("bytes=".length());
          int minus = range.indexOf('-');

          if (minus > 0)
          {
            range = range.substring(0, minus);
          }

          try
          {
            startFrom = Long.parseLong(range);
          }
          catch (NumberFormatException nfe)
          {
          }
        }
      }

      InputStream fis = file.getContents();
      fis.skip(startFrom);

      Response r = new Response(HTTP_OK, mime, fis);
      r.addHeader("Content-length", Long.toString(len - startFrom));
      r.addHeader("Content-range", Long.toString(startFrom) + "-" + (len - 1) + "/" + len);
      return r;
    }
    catch (Exception ex)
    {
      return new Response(HTTP_INTERNALERROR, MIME_PLAINTEXT, ex.toString());
    }
  }

  protected String getMimeType(IFile file)
  {
    String ext = file.getFileExtension();
    String mime = null;

    if (ext != null && ext.length() != 0)
    {
      mime = getMimeType(ext.toLowerCase());
    }

    if (mime == null)
    {
      mime = MIME_DEFAULT_BINARY;
    }

    return mime;
  }

  protected Response overrideUri(String path, String method, Properties headers, Properties parms)
  {
    return null;
  }

  public IFolder getRootFolder()
  {
    return rootFolder;
  }

  public String getDocumentRoot()
  {
    return documentRoot;
  }

  public void setDocumentRoot(String documentRoot)
  {
    doSet("documentRoot", documentRoot);
  }

  public boolean isAllowDirectoryListing()
  {
    return allowDirectoryListing;
  }

  public void setAllowDirectoryListing(boolean allowDirectoryListing)
  {
    doSet("allowDirectoryListing", allowDirectoryListing);
  }

  public boolean isAutoSync()
  {
    return autoSync;
  }

  public void setAutoSync(boolean autoSync)
  {
    doSet("autoSync", autoSync);
  }

  public List getWelcomePages()
  {
    return welcomePages;
  }

  public void setWelcomePages(List welcomePages)
  {
    doSet("welcomePages", welcomePages);
  }

  protected void validate() throws ValidationException
  {
    super.validate();
    assertNotNull("documentRoot");
    assertNotNull("welcomePages");

    try
    {
      IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
      rootFolder = root.getFolder(new Path(getDocumentRoot()));
    }
    catch (Exception ex)
    {
      throw new ValidationException("Error while computing documentRoot", ex);
    }

    // Make sure we won't die of an exception later
    if (!rootFolder.exists())
    {
      try
      {
        rootFolder.create(true, true, new NullProgressMonitor());
      }
      catch (CoreException ex)
      {
        throw new ValidationException("Error while creating documentRoot " + getDocumentRoot(), ex);
      }
    }
    else
    {
      if (!(rootFolder instanceof IFolder))
      {
        throw new ValidationException("documentRoot is not a directory");
      }

      try
      {
        rootFolder.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
      }
      catch (CoreException ex)
      {
        throw new ValidationException("Error while refreshing documentRoot", ex);
      }
    }
  }
}
