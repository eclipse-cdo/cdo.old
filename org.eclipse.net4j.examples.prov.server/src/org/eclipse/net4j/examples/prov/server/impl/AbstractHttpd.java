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


import org.eclipse.net4j.examples.prov.server.DateFormatter;
import org.eclipse.net4j.examples.prov.server.Httpd;
import org.eclipse.net4j.examples.prov.server.HttpdException;
import org.eclipse.net4j.examples.prov.server.UrlCodec;
import org.eclipse.net4j.spring.ValidationException;
import org.eclipse.net4j.spring.impl.ServiceImpl;
import org.eclipse.net4j.util.thread.Worker;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Date;
import java.util.Enumeration;
import java.util.Map;
import java.util.Properties;
import java.util.StringTokenizer;


public abstract class AbstractHttpd extends ServiceImpl implements Httpd
{
  public static final boolean TRACING = false;

  protected int port;

  /**
   * Hashtable mapping (String)FILENAME_EXTENSION -> (String)MIME_TYPE
   */
  protected Map mimeTypes;

  protected DateFormatter dateFormatter;

  protected UrlCodec urlCodec;

  private transient Worker worker;

  private transient ServerSocket serverSocket;

  public void addMimeType(String extension, String mimeType)
  {
    mimeTypes.put(extension, mimeType);
  }

  public String removeMimeType(String extension)
  {
    return (String)mimeTypes.remove(extension);
  }

  public String getMimeType(String extension)
  {
    return (String)mimeTypes.get(extension);
  }

  protected abstract Response serve(String uri, String method, Properties header, Properties parms);

  protected void dump(String uri, String method, Properties header, Properties parms)
  {
    debug(method + " " + uri);

    if (TRACING)
    {
      Enumeration e = header.propertyNames();
      while (e.hasMoreElements())
      {
        String value = (String)e.nextElement();
        debug("  HDR: " + value + ": " + header.getProperty(value));
      }

      debug("  HDR:");
      e = parms.propertyNames();
      boolean hasPrm = false;

      while (e.hasMoreElements())
      {
        hasPrm = true;
        String value = (String)e.nextElement();
        debug("  PRM: " + value + ": " + parms.getProperty(value));
      }

      if (hasPrm) debug("  PRM:");
    }
  }

  /**
   * HTTP response. Return one of these from serve().
   */
  public static class Response
  {
    /**
     * HTTP status code after processing, e.g. "200 OK", HTTP_OK
     */
    public String status;

    /**
     * MIME type of content, e.g. "text/html"
     */
    public String mimeType;

    /**
     * Data of the response, may be null.
     */
    public InputStream data;

    /**
     * Headers for the HTTP response. Use addHeader() to add lines.
     */
    public Properties header = new Properties();

    /**
     * Default constructor: response = HTTP_OK, data = mime = 'null'
     */
    public Response()
    {
      this.status = AbstractHttpd.HTTP_OK;
    }

    /**
     * Basic constructor.
     */
    public Response(String status, String mimeType, InputStream data)
    {
      this.status = status;
      this.mimeType = mimeType;
      this.data = data;
    }

    /**
     * Convenience method that makes an InputStream out of given text.
     */
    public Response(String status, String mimeType, String txt)
    {
      this(status, mimeType, new ByteArrayInputStream(txt.getBytes()));
    }

    /**
     * Adds given line to the header.
     */
    public void addHeader(String name, String value)
    {
      header.put(name, value);
    }
  }

  private class Session extends Worker
  {
    private static final String LF = "\r\n";

    private Socket socket;

    public Session(Socket s)
    {
      super(getFullBeanName() + ".Session");

      socket = s;
      // setDaemon(true);
      startup();
    }

    protected long doWorkStep(int progress)
    {
      try
      {
        InputStream is = socket.getInputStream();
        if (is == null)
        {
          return NO_PAUSE;
        }

        BufferedReader in = new BufferedReader(new InputStreamReader(is));

        // Read the request line
        StringTokenizer st = new StringTokenizer(in.readLine());
        if (!st.hasMoreTokens())
        {
          sendError(HTTP_BADREQUEST, "BAD REQUEST: Syntax error. Usage: GET /example/file.html");
        }

        String method = st.nextToken();

        if (!st.hasMoreTokens())
        {
          sendError(HTTP_BADREQUEST, "BAD REQUEST: Missing URI. Usage: GET /example/file.html");
        }

        String uri = decodePercent(st.nextToken());

        // Decode parameters from the URI
        Properties parms = new Properties();
        int qmi = uri.indexOf('?');
        if (qmi >= 0)
        {
          decodeParms(uri.substring(qmi + 1), parms);
          uri = decodePercent(uri.substring(0, qmi));
        }

        // If there's another token, it's protocol version,
        // followed by HTTP headers. Ignore version but parse headers.
        Properties header = new Properties();
        if (st.hasMoreTokens())
        {
          String line = in.readLine();
          while (line.trim().length() > 0)
          {
            int p = line.indexOf(':');
            header.put(line.substring(0, p).trim(), line.substring(p + 1).trim());
            line = in.readLine();
          }
        }

        // If the method is POST, there may be parameters
        // in data section, too, read another line:
        if (method.equalsIgnoreCase("POST")) decodeParms(in.readLine(), parms);

        // Ok, now do the serve()
        Response r = serve(uri, method, header, parms);
        if (r == null)
        {
          sendError(HTTP_INTERNALERROR, "SERVER INTERNAL ERROR: Serve() returned a null response.");
        }
        else
        {
          sendResponse(r.status, r.mimeType, r.header, r.data);
        }

        in.close();
      }
      catch (IOException ex)
      {
        try
        {
          sendError(HTTP_INTERNALERROR, "SERVER INTERNAL ERROR: IOException: " + ex.getMessage());
        }
        catch (Throwable t)
        {
        }
      }
      catch (InterruptedException ignore)
      {
        // Thrown by sendError, ignore and exit the thread.
      }

      return TERMINATE;
    }

    /**
     * Decodes the percent encoding scheme. <br/> For example: "an+example%20string" -> "an example
     * string"
     */
    private String decodePercent(String str) throws InterruptedException
    {
      try
      {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < str.length(); i++)
        {
          char c = str.charAt(i);
          switch (c)
          {
          case '+':
            sb.append(' ');
            break;
          case '%':
            sb.append((char)Integer.parseInt(str.substring(i + 1, i + 3), 16));
            i += 2;
            break;
          default:
            sb.append(c);
            break;
          }
        }
        return new String(sb.toString().getBytes());
      }
      catch (Exception e)
      {
        sendError(HTTP_BADREQUEST, "BAD REQUEST: Bad percent-encoding.");
        return null;
      }
    }

    /**
     * Decodes parameters in percent-encoded URI-format ( e.g.
     * "name=Jack%20Daniels&pass=Single%20Malt" ) and adds them to given Properties.
     */
    private void decodeParms(String parms, Properties p) throws InterruptedException
    {
      if (parms == null) return;

      StringTokenizer st = new StringTokenizer(parms, "&");
      while (st.hasMoreTokens())
      {
        String e = st.nextToken();
        int sep = e.indexOf('=');
        if (sep >= 0)
          p.put(decodePercent(e.substring(0, sep)).trim(), decodePercent(e.substring(sep + 1)));
      }
    }

    /**
     * Returns an error message as a HTTP response and throws InterruptedException to stop furhter
     * request processing.
     */
    private void sendError(String status, String msg) throws InterruptedException
    {
      sendResponse(status, MIME_PLAINTEXT, null, new ByteArrayInputStream(msg.getBytes()));
      throw new InterruptedException();
    }

    /**
     * Sends given response to the socket.
     */
    private void sendResponse(String status, String mime, Properties header, InputStream data)
    {
      try
      {
        if (status == null)
        {
          throw new IllegalArgumentException("status == null");
        }

        OutputStream out = socket.getOutputStream();
        PrintWriter pw = new PrintWriter(out);
        print(pw, "HTTP/1.0 " + status + " \r\n");

        if (mime != null)
        {
          print(pw, "Content-Type: " + mime + LF);
        }

        if (header != null)
        {
          Enumeration e = header.keys();
          while (e.hasMoreElements())
          {
            String key = (String)e.nextElement();
            String value = header.getProperty(key);
            print(pw, key + ": " + value + LF);
          }
        }

        if (header == null || header.getProperty("Date") == null)
        {
          print(pw, "Date: " + dateFormatter.format(new Date()) + LF);
        }

        print(pw, LF);
        pw.flush();

        if (data != null)
        {
          byte[] buffer = new byte[2048];
          int bytesRead = 2048;

          while (bytesRead == 2048)
          {
            bytesRead = data.read(buffer, 0, 2048);
            out.write(buffer, 0, bytesRead);
          }
        }

        out.flush();
        out.close();

        if (data != null)
        {
          data.close();
        }
      }
      catch (IOException ioe)
      {
        try
        {
          socket.close();
        }
        catch (Throwable ignore)
        {
        }
      }
    }

    private void print(PrintWriter pw, String string)
    {
      if (TRACING && isDebugEnabled())
      {
        debug("  OUT: "
                + (string.endsWith(LF) ? string.substring(0, string.length() - LF.length())
                        : string));
      }

      pw.print(string);
    }
  };

  /**
   * URL-encodes everything between "/"-characters. Encodes spaces as '%20' instead of '+'.
   */
  protected String encodeUri(String uri)
  {
    String newUri = "";
    StringTokenizer st = new StringTokenizer(uri, "/ ", true);
    while (st.hasMoreTokens())
    {
      String tok = st.nextToken();
      if (tok.equals("/"))
        newUri += "/";
      else if (tok.equals(" "))
        newUri += "%20";
      else
        newUri += urlCodec.encode(tok);
    }
    return newUri;
  }

  public int getPort()
  {
    return port;
  }

  public void setPort(int port)
  {
    doSet("port", port);
  }

  protected void validate() throws ValidationException
  {
    super.validate();
    assertNotNull("mimeTypes");
    if (port <= 0) throw new ValidationException("Port is not a positive integer");
  }

  protected void activate() throws Exception
  {
    super.activate();

    try
    {
      serverSocket = new ServerSocket(port);
      worker = new Worker(getFullBeanName() + ".Listener")
      {
        protected long doWorkStep(int progress)
        {
          try
          {
            if (serverSocket == null || serverSocket.isClosed())
            {
              return TERMINATE;
            }

            Socket socket = serverSocket.accept();
            new Session(socket);
          }
          catch (IOException ex)
          {
            if (serverSocket != null && !serverSocket.isClosed())
            {
              AbstractHttpd.this.warn("Error while accepting HTTP session", ex);
            }
          }

          return NO_PAUSE;
        }
      };

      worker.setDaemon(true);
      worker.startup();
    }
    catch (Exception ex)
    {
      throw new HttpdException("Error while starting Httpd", ex);
    }
  }

  protected void deactivate() throws Exception
  {
    if (serverSocket != null)
    {
      serverSocket.close();
      serverSocket = null;
    }

    // TODO handle container shutdown for prototype beans
    if (worker != null)
    {
      worker.shutdown(200);
      worker = null;
    }

    super.deactivate();
  }

  public Map getMimeTypes()
  {
    return mimeTypes;
  }

  public void setMimeTypes(Map mimeTypes)
  {
    doSet("mimeTypes", mimeTypes);
  }

  public DateFormatter getDateFormatter()
  {
    return dateFormatter;
  }

  public void setDateFormatter(DateFormatter dateFormatter)
  {
    doSet("dateFormatter", dateFormatter);
  }

  public UrlCodec getUrlCodec()
  {
    return urlCodec;
  }

  public void setUrlCodec(UrlCodec urlCodec)
  {
    doSet("urlCodec", urlCodec);
  }
}
