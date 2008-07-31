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
package org.eclipse.net4j.internal.pop;

import org.eclipse.net4j.internal.pop.code.Committer;
import org.eclipse.net4j.internal.pop.util.ElementContainer;
import org.eclipse.net4j.pop.IPop;
import org.eclipse.net4j.pop.InternalPopManager;
import org.eclipse.net4j.pop.code.IBranch;
import org.eclipse.net4j.pop.code.ICodeStrategy;
import org.eclipse.net4j.pop.code.ICommitter;

import org.eclipse.mylyn.tasks.core.ITask;

import java.text.MessageFormat;
import java.util.Date;

/**
 * @author Eike Stepper
 */
public class Pop extends DevelopmentStream implements IPop
{
  protected ElementContainer<ICommitter> committerContainer = new ElementContainer<ICommitter>(this);

  private InternalPopManager manager;

  private String name;

  private ICodeStrategy strategy;

  public Pop(InternalPopManager manager, String name, ICodeStrategy strategy, IBranch branch, ITask task)
  {
    super(null, branch, task);
    checkArgument(manager, "manager");
    checkArgument(name, "name");
    checkArgument(strategy, "strategy");
    this.manager = manager;
    this.name = name;
    this.strategy = strategy;
    manager.putStream(this);
  }

  public InternalPopManager getManager()
  {
    return manager;
  }

  @Override
  public IPop getParent()
  {
    return null;
  }

  @Override
  public IPop getPop()
  {
    return this;
  }

  public String getName()
  {
    return name;
  }

  public ICodeStrategy getCodeStrategy()
  {
    return strategy;
  }

  public ICommitter addCommitter(String codeAccount, Date entryDate, Date exitDate)
  {
    checkArgument(codeAccount, "codeAccount");
    checkArgument(entryDate, "entryDate");
    ICommitter committer = new Committer(this, codeAccount, entryDate, exitDate);
    committerContainer.addElement(committer);
    return committer;
  }

  public ICommitter getCommitter(int index)
  {
    checkArgument(index >= 0, "index");
    return committerContainer.getElement(index);
  }

  public int getCommitterCount()
  {
    return committerContainer.getElementCount();
  }

  public ICommitter[] getCommitters()
  {
    return committerContainer.getElements(ICommitter.class);
  }

  @Override
  public String toString()
  {
    return MessageFormat.format("Pop[name={0}, branch={1}, task={2}]", name, getBranch().getName(), getTask()
        .getTaskId());
  }
}
