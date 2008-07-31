package org.eclipse.net4j.pop.task.spi.web;

import org.eclipse.net4j.pop.spi.task.TaskRepositoryConfiguration;
import org.eclipse.net4j.pop.task.ITaskRepositoryConfiguration;
import org.eclipse.net4j.util.ObjectUtil;
import org.eclipse.net4j.util.io.ExtendedDataInputStream;
import org.eclipse.net4j.util.io.ExtendedDataOutputStream;
import org.eclipse.net4j.util.io.ExtendedIOHandler;
import org.eclipse.net4j.util.io.ExtendedInputHandler;

import org.eclipse.equinox.security.storage.ISecurePreferences;
import org.eclipse.equinox.security.storage.StorageException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.ByteArrayRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author Eike Stepper
 */
public class WebConfiguration extends TaskRepositoryConfiguration
{
  private String url;

  private String userName;

  private String password;

  private HttpClient httpClient = new HttpClient();

  public WebConfiguration(WebConnector connector)
  {
    super(connector);
  }

  protected WebConfiguration(WebConfiguration source)
  {
    super(source);
    url = source.url;
    userName = source.userName;
    password = source.password;
  }

  public String getUrl()
  {
    return url;
  }

  public void setUrl(String url)
  {
    this.url = url;
    fireConfigurationChangedEvent();
  }

  public String getUserName()
  {
    return userName;
  }

  public void setUserName(String userName)
  {
    this.userName = userName;
    fireConfigurationChangedEvent();
  }

  public void setPassword(String password)
  {
    this.password = password;
    fireConfigurationChangedEvent();
  }

  public ITaskRepositoryConfiguration copy()
  {
    return new WebConfiguration(this);
  }

  public void load(ISecurePreferences preferences) throws StorageException
  {
    url = preferences.get("url", "");
    userName = preferences.get("userName", "");
    password = preferences.get("password", "");
  }

  public void save(ISecurePreferences preferences) throws StorageException
  {
    preferences.put("url", url, false);
    preferences.put("userName", userName, false);
    preferences.put("password", password, true);
  }

  @Override
  public boolean equals(Object obj)
  {
    if (obj == this)
    {
      return true;
    }

    if (obj instanceof WebConfiguration)
    {
      WebConfiguration that = (WebConfiguration)obj;
      return ObjectUtil.equals(url, that.url) && ObjectUtil.equals(userName, that.userName)
          && ObjectUtil.equals(password, that.password);
    }

    return false;
  }

  @Override
  public int hashCode()
  {
    return ObjectUtil.hashCode(url) ^ ObjectUtil.hashCode(userName) ^ ObjectUtil.hashCode(password);
  }

  @Override
  public String toString()
  {
    return url;
  }

  public void request(String resource, HttpMethodParams params, LineHandler handler) throws IOException
  {
    String resourceURL = getResourceURL(resource);
    PostMethod method = createHTTPMethod(resourceURL);
    if (params != null)
    {
      method.setParams(params);
    }

    try
    {
      httpClient.executeMethod(method);
      InputStream bodyInputStream = method.getResponseBodyAsStream();
      BufferedReader reader = new BufferedReader(new InputStreamReader(bodyInputStream));
      String line;
      while ((line = reader.readLine()) != null)
      {
        if (!handler.handleLine(line))
        {
          break;
        }
      }
    }
    finally
    {
      method.releaseConnection();
    }
  }

  public void request(String resource, HttpMethodParams params, ExtendedInputHandler handler) throws IOException
  {
    String resourceURL = getResourceURL(resource);
    PostMethod method = createHTTPMethod(resourceURL);
    method.setParams(params);

    try
    {
      httpClient.executeMethod(method);
      InputStream bodyInputStream = method.getResponseBodyAsStream();
      ExtendedDataInputStream in = new ExtendedDataInputStream(bodyInputStream);
      handler.handleIn(in);
    }
    finally
    {
      method.releaseConnection();
    }
  }

  public void request(String resource, ExtendedIOHandler handler) throws IOException
  {
    String resourceURL = getResourceURL(resource);
    PostMethod method = createHTTPMethod(resourceURL);

    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    ExtendedDataOutputStream out = new ExtendedDataOutputStream(baos);
    handler.handleOut(out);
    out.flush();
    method.setRequestEntity(new ByteArrayRequestEntity(baos.toByteArray()));

    try
    {
      httpClient.executeMethod(method);
      InputStream bodyInputStream = method.getResponseBodyAsStream();
      ExtendedDataInputStream in = new ExtendedDataInputStream(bodyInputStream);
      handler.handleIn(in);
    }
    finally
    {
      method.releaseConnection();
    }
  }

  protected PostMethod createHTTPMethod(String url)
  {
    PostMethod method = new PostMethod(url);
    method.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    method.setDoAuthentication(true);
    return method;
  }

  private String getResourceURL(String resource)
  {
    StringBuilder builder = new StringBuilder(url);
    if (!url.endsWith("/"))
    {
      builder.append("/");
    }

    builder.append(resource);
    String resourceURL = builder.toString();
    return resourceURL;
  }
}
