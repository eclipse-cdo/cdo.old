/***************************************************************************
 * Copyright (c) 2004 - 2008 Eike Stepper, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 **************************************************************************/
package org.eclipse.net4j.pop.task.tests;

import org.eclipse.net4j.pop.internal.task.Task;
import org.eclipse.net4j.pop.internal.task.TaskRepository;
import org.eclipse.net4j.pop.internal.task.TaskRepositoryManager;
import org.eclipse.net4j.pop.task.internal.bugzilla.BugzillaConnector;
import org.eclipse.net4j.pop.task.spi.web.WebConfiguration;
import org.eclipse.net4j.pop.task.util.ISaveable;
import org.eclipse.net4j.pop.task.util.ISynchronizeable;
import org.eclipse.net4j.util.om.OMPlatform;
import org.eclipse.net4j.util.om.log.PrintLogHandler;
import org.eclipse.net4j.util.om.trace.PrintTraceHandler;

import junit.framework.TestCase;

/**
 * @author Eike Stepper
 */
public class TaskRepositoryManagerTest extends TestCase
{
  public TaskRepositoryManagerTest()
  {
  }

  @Override
  protected void setUp() throws Exception
  {
    OMPlatform.INSTANCE.addLogHandler(PrintLogHandler.CONSOLE);
    OMPlatform.INSTANCE.addTraceHandler(PrintTraceHandler.CONSOLE);
    OMPlatform.INSTANCE.setDebugging(true);
  }

  public void testCreateTask()
  {
    TaskRepositoryManager.INSTANCE.activate();

    BugzillaConnector connector = new BugzillaConnector();
    WebConfiguration configuration = connector.createConfiguration();
    configuration.setUrl("https://landfill.bugzilla.org/bugzilla-tip");
    configuration.setUserName("stepper@esc-net.de");
    configuration.setPassword("stepper");

    TaskRepository repository = TaskRepositoryManager.INSTANCE.createRepository("test", connector, configuration);
    repository.validate();

    Task task = repository.createTask();
    assertEquals(ISynchronizeable.IncomingState.CLEAN, task.getIncomingState());
    assertEquals(ISaveable.OutgoingState.NEW, task.getOutgoingState());
  }
}
