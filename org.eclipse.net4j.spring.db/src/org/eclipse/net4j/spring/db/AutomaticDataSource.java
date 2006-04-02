/***************************************************************************
 * Copyright (c) 2004, 2005, 2006 Eike Stepper, Fuggerstr. 39, 10777 Berlin, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 **************************************************************************/
package org.eclipse.net4j.spring.db;


import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.DriverConnectionFactory;
import org.apache.commons.dbcp.PoolableConnectionFactory;
import org.apache.commons.dbcp.PoolingDataSource;
import org.apache.commons.dbcp.SQLNestedException;
import org.apache.commons.pool.impl.GenericKeyedObjectPool;
import org.apache.commons.pool.impl.GenericKeyedObjectPoolFactory;
import org.apache.commons.pool.impl.GenericObjectPool;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;

import javax.sql.DataSource;


// TODO extend DefaultBean and delegate to BasicDataSource
public class AutomaticDataSource extends BasicDataSource
{

  /* (non-Javadoc)
   * @see org.apache.commons.dbcp.BasicDataSource#createDataSource()
   */
  protected synchronized DataSource createDataSource() throws SQLException
  {
    // Return the pool if we have already created it
    if (dataSource != null)
    {
      return (dataSource);
    }

    Driver driver = loadDriver();

    // Can't test without a validationQuery
    if (validationQuery == null)
    {
      setTestOnBorrow(false);
      setTestOnReturn(false);
      setTestWhileIdle(false);
    }

    createPool();

    createConnectionFactory(driver);

    // Create and return the pooling data source to manage the connections
    dataSource = new PoolingDataSource(connectionPool);
    ((PoolingDataSource) dataSource)
        .setAccessToUnderlyingConnectionAllowed(isAccessToUnderlyingConnectionAllowed());
    dataSource.setLogWriter(logWriter);

    try
    {
      for (int i = 0; i < initialSize; i++)
      {
        connectionPool.addObject();
      }
    }
    catch (Exception e)
    {
      throw new SQLNestedException("Error preloading the connection pool", e);
    }

    return dataSource;
  }

  private void createConnectionFactory(Driver driver) throws SQLNestedException
  {
    // Set up statement pool, if desired
    GenericKeyedObjectPoolFactory statementPoolFactory = null;
    if (isPoolPreparedStatements())
    {
      statementPoolFactory = new GenericKeyedObjectPoolFactory(null, -1, // unlimited maxActive (per key)
          GenericKeyedObjectPool.WHEN_EXHAUSTED_FAIL, 0, // maxWait
          1, // maxIdle (per key) 
          maxOpenPreparedStatements);
    }

    // Set up the driver connection factory we will use
    if (username != null)
    {
      connectionProperties.put("user", username);
    }
    else
    {
      log("DBCP DataSource configured without a 'username'");
    }

    if (password != null)
    {
      connectionProperties.put("password", password);
    }
    else
    {
      log("DBCP DataSource configured without a 'password'");
    }

    DriverConnectionFactory driverConnectionFactory = new DriverConnectionFactory(driver, url,
        connectionProperties);

    // Set up the poolable connection factory we will use
    PoolableConnectionFactory connectionFactory = null;
    try
    {
      connectionFactory = new PoolableConnectionFactory(driverConnectionFactory, connectionPool,
          statementPoolFactory, validationQuery, defaultReadOnly, defaultAutoCommit,
          defaultTransactionIsolation, defaultCatalog, null);
      if (connectionFactory == null)
      {
        throw new SQLException("Cannot create PoolableConnectionFactory");
      }
      validateConnectionFactory(connectionFactory);
    }
    catch (RuntimeException e)
    {
      throw e;
    }
    catch (Exception e)
    {
      throw new SQLNestedException("Cannot create PoolableConnectionFactory (" + e.getMessage()
          + ")", e);
    }
  }

  private void createPool()
  {
    connectionPool = new GenericObjectPool();
    connectionPool.setMaxActive(maxActive);
    connectionPool.setMaxIdle(maxIdle);
    connectionPool.setMinIdle(minIdle);
    connectionPool.setMaxWait(maxWait);
    connectionPool.setTestOnBorrow(testOnBorrow);
    connectionPool.setTestOnReturn(testOnReturn);
    connectionPool.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
    connectionPool.setNumTestsPerEvictionRun(numTestsPerEvictionRun);
    connectionPool.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
    connectionPool.setTestWhileIdle(testWhileIdle);
  }

  private Driver loadDriver() throws SQLNestedException
  {
    try
    {
      ClassLoader loader = Thread.currentThread().getContextClassLoader();
      Class clazz = loader.loadClass(driverClassName);
      log("class for " + driverClassName + ": " + clazz);
      return (Driver) clazz.newInstance();
    }
    catch (Throwable t)
    {
      String message = "Cannot load JDBC driver class '" + driverClassName + "'";
      logWriter.println(message);
      t.printStackTrace(logWriter);
      throw new SQLNestedException(message, t);
    }
  }

  private void log(String message)
  {
    if (logWriter != null)
    {
      logWriter.println(message);
    }
  }

  private static void validateConnectionFactory(PoolableConnectionFactory connectionFactory)
      throws Exception
  {
    Connection conn = null;
    try
    {
      conn = (Connection) connectionFactory.makeObject();
      connectionFactory.activateObject(conn);
      connectionFactory.validateConnection(conn);
      connectionFactory.passivateObject(conn);
    }
    finally
    {
      connectionFactory.destroyObject(conn);
    }
  }

}
