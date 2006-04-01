/*******************************************************************************
 * Copyright (c) 2004, 2005, 2006 Eike Stepper, Sympedia Methods and Tools.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Eike Stepper - initial API and implementation
 *******************************************************************************/
package org.eclipse.net4j.spring.db;


import org.eclipse.net4j.spring.ValidationException;
import org.eclipse.net4j.spring.impl.ServiceImpl;
import org.eclipse.net4j.util.ImplementationError;

import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.datasource.SmartDataSource;

import java.util.Properties;

import java.io.PrintWriter;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;


public class ContextClassLoaderDataSource extends ServiceImpl implements SmartDataSource
{
  protected String driverClassName = "";

  protected String url = "";

  protected String username = "";

  protected transient String password = "";

  protected transient Driver driver;

  protected transient Connection connection;

  /**
   * Constructor for bean-style configuration.
   */
  public ContextClassLoaderDataSource()
  {
  }

  /**
   * Create a new ContextClassLoaderDataSource with the given parameters.
   */
  public ContextClassLoaderDataSource(String driverClassName, String url, String username,
      String password) throws CannotGetJdbcConnectionException
  {
    setDriverClassName(driverClassName);
    setUrl(url);
    setUsername(username);
    setPassword(password);
  }

  public void setDriverClassName(String driverClassName)
  {
    //    doSet("driverClassName", driverClassName);
    this.driverClassName = driverClassName;
  }

  public String getDriverClassName()
  {
    return driverClassName;
  }

  public void setUrl(String url)
  {
    //    doSet("url", url);
    this.url = url;
  }

  public String getUrl()
  {
    return url;
  }

  public void setUsername(String username)
  {
    //    doSet("username", username);
    this.username = username;
  }

  public String getUsername()
  {
    return username;
  }

  public void setPassword(String password)
  {
    //    doSet("password", password);
    this.password = password;
  }

  public String getPassword()
  {
    return password;
  }

  /**
   * This DataSource returns the same connection every time:
   * Don't close it when returning one to the "pool".
   */
  public boolean shouldClose(Connection con)
  {
    return false;
  }

  public Connection getConnection() throws SQLException
  {
    if (connection == null)
    {
      connection = getConnection(username, password);
    }
    return connection;
  }

  public Connection getConnection(String username, String password) throws SQLException
  {
    Properties connectionProperties = new Properties();
    if (username != null)
    {
      connectionProperties.put("user", username);
    }

    if (password != null)
    {
      connectionProperties.put("password", password);
    }

    if (connection != null) throw new ImplementationError("There is already a connection");
    connection = driver.connect(url, connectionProperties);
    return connection;
  }

  /**
   * Returns 0: means use default system timeout.
   */
  public int getLoginTimeout() throws SQLException
  {
    return 0;
  }

  public void setLoginTimeout(int timeout) throws SQLException
  {
    throw new UnsupportedOperationException("setLoginTimeout");
  }

  /**
   * LogWriter methods are unsupported.
   */
  public PrintWriter getLogWriter()
  {
    throw new UnsupportedOperationException("getLogWriter");
  }

  /**
   * LogWriter methods are unsupported.
   */
  public void setLogWriter(PrintWriter pw) throws SQLException
  {
  }

  protected void validate() throws ValidationException
  {
    super.validate();
    assertNotNull("driverClassName");

    try
    {
      ClassLoader loader = Thread.currentThread().getContextClassLoader();
      Class clazz = loader.loadClass(driverClassName);
      driver = (Driver) clazz.newInstance();
    }
    catch (Throwable t)
    {
      throw new ValidationException("Error while loading JDBC driver " + driverClassName, t);
    }

    assertNotNull("driver");
  }
}