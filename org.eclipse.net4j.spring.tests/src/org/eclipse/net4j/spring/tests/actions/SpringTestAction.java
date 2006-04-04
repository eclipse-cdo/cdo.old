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
package org.eclipse.net4j.spring.tests.actions;


import org.eclipse.net4j.spring.Container;
import org.eclipse.net4j.spring.db.ContextClassLoaderDataSource;
import org.eclipse.net4j.spring.impl.ContainerImpl;
import org.eclipse.net4j.spring.tests.Net4jSpringTestPlugin;
import org.eclipse.net4j.util.eclipse.AbstractPlugin;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;

import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;


/**
 * Our sample action implements workbench action delegate.
 * The action proxy will be created by the workbench and
 * shown in the UI. When the user tries to use the action,
 * this delegate will be created and execution will be 
 * delegated to it.
 * @see IWorkbenchWindowActionDelegate
 */
public class SpringTestAction implements IWorkbenchWindowActionDelegate
{
  /**
   * The constructor.
   */
  public SpringTestAction()
  {
  }

  /**
   * The action has been activated. The argument of the
   * method represents the 'real' action sitting
   * in the workbench UI.
   * @see IWorkbenchWindowActionDelegate#run
   */
  public void run(IAction action)
  {
    try
    {
      test_ContextClassLoaderDataSource_Container_OK();
    }
    catch (Throwable t)
    {
      t.printStackTrace();
    }
  }

  protected void test_ContextClassLoaderDataSource_Standalone_OK() throws SQLException
  {
    Connection connection = null;
    ContextClassLoaderDataSource dataSource = null;

    ClassLoader orig = Thread.currentThread().getContextClassLoader();
    Thread.currentThread().setContextClassLoader(getClass().getClassLoader());

    try
    {
      dataSource = new ContextClassLoaderDataSource("org.gjt.mm.mysql.Driver",
          "jdbc:mysql://localhost/springTest", "root", "");
      dataSource.afterPropertiesSet();

      connection = dataSource.getConnection();
      System.out.println(connection.getCatalog());
    }
    catch (Exception ex)
    {
      ex.printStackTrace();
    }
    finally
    {
      if (connection != null) connection.close();
      Thread.currentThread().setContextClassLoader(orig);
    }
  }

  protected void test_ContextClassLoaderDataSource_Container_OK() throws SQLException
  {
    Connection connection = null;

    try
    {
      String base = AbstractPlugin
          .getBundleLocation(Net4jSpringTestPlugin.getDefault().getBundle());
      String location = "META-INF/springTest.xml";
      ClassLoader loader = getClass().getClassLoader();

      Container container = new ContainerImpl(base, location, "spring.test", null, loader);
      Object tmp = container.getBean("dataSource2");
      DataSource dataSource = (DataSource) tmp;

      connection = dataSource.getConnection();
      System.out.println(connection.getCatalog());
    }
    catch (Exception ex)
    {
      ex.printStackTrace();
    }
    finally
    {
      if (connection != null) connection.close();
    }
  }

  protected void test_SingleConnectionDataSource_Standalone_ERROR() throws SQLException
  {
    Connection connection = null;
    SingleConnectionDataSource dataSource = null;

    ClassLoader orig = Thread.currentThread().getContextClassLoader();
    Thread.currentThread().setContextClassLoader(getClass().getClassLoader());

    try
    {
      Class.forName("org.gjt.mm.mysql.Driver");
      dataSource = new SingleConnectionDataSource("org.gjt.mm.mysql.Driver",
          "jdbc:mysql://localhost/springTest", "root", "", false);

      connection = dataSource.getConnection();
      System.out.println(connection.getCatalog());
    }
    catch (Exception ex)
    {
      ex.printStackTrace();
    }
    finally
    {
      if (connection != null) connection.close();
      Thread.currentThread().setContextClassLoader(orig);
    }
  }

  protected void test_SingleConnectionDataSource_Container_ERROR() throws SQLException
  {
    Connection connection = null;

    ClassLoader loader = getClass().getClassLoader();
    ClassLoader orig = Thread.currentThread().getContextClassLoader();
    Thread.currentThread().setContextClassLoader(loader);

    try
    {
      Class.forName("java.sql.DriverManager", true, loader);
      Class.forName("org.gjt.mm.mysql.Driver", true, loader);

      String base = AbstractPlugin
          .getBundleLocation(Net4jSpringTestPlugin.getDefault().getBundle());
      String location = "META-INF/springTest.xml";

      Container container = new ContainerImpl(base, location, "spring.test", null, loader);
      Object tmp = container.getBean("dataSource1");
      DataSource dataSource = (DataSource) tmp;

      connection = dataSource.getConnection();
      System.out.println(connection.getCatalog());
    }
    catch (Exception ex)
    {
      ex.printStackTrace();
    }
    finally
    {
      if (connection != null) connection.close();
      Thread.currentThread().setContextClassLoader(orig);
    }
  }

  /**
   * Selection in the workbench has been changed. We 
   * can change the state of the 'real' action here
   * if we want, but this can only happen after 
   * the delegate has been created.
   * @see IWorkbenchWindowActionDelegate#selectionChanged
   */
  public void selectionChanged(IAction action, ISelection selection)
  {
  }

  /**
   * We can use this method to dispose of any system
   * resources we previously allocated.
   * @see IWorkbenchWindowActionDelegate#dispose
   */
  public void dispose()
  {
  }

  /**
   * We will cache window object in order to
   * be able to provide parent shell for the message dialog.
   * @see IWorkbenchWindowActionDelegate#init
   */
  public void init(IWorkbenchWindow window)
  {
  }
}
