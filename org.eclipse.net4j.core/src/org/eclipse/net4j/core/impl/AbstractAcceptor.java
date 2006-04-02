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
package org.eclipse.net4j.core.impl;


import org.eclipse.net4j.core.Acceptor;
import org.eclipse.net4j.core.Connector;
import org.eclipse.net4j.core.Executor;
import org.eclipse.net4j.core.Task;
import org.eclipse.net4j.spring.impl.ServiceImpl;


public abstract class AbstractAcceptor extends ServiceImpl implements Acceptor
{
  private Executor slaveStarter;

  public Executor getSlaveStarter()
  {
    return slaveStarter;
  }

  public void setSlaveStarter(Executor slaveStarter)
  {
    doSet("slaveStarter", slaveStarter);
  }

  public void accept(Connector slave)
  {
    if (slaveStarter != null)
    {
      try
      {
        slaveStarter.execute(new StartSlaveTask(slave), null);
      }
      catch (Exception ex)
      {
        error("Error while starting slave " + slave, ex);
      }
    }
    else
    {
      startSlave(slave);
    }
  }

  protected void startSlave(Connector slave)
  {
    try
    {
      slave.start();
    }
    catch (Exception ex)
    {
      error("Error while starting slave " + slave, ex);
    }
  }

  private class StartSlaveTask implements Task
  {
    private Connector slave;

    public StartSlaveTask(Connector slave)
    {
      this.slave = slave;
    }

    public void execute() throws Exception
    {
      startSlave(slave);
    }
  }
}
