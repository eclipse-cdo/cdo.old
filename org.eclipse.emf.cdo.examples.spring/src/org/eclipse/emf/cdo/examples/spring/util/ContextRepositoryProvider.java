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
package org.eclipse.emf.cdo.examples.spring.util;

import org.eclipse.emf.cdo.server.IRepository;
import org.eclipse.emf.cdo.server.IRepositoryProvider;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author Eike Stepper
 */
public class ContextRepositoryProvider implements IRepositoryProvider, ApplicationContextAware
{
  private ApplicationContext context;

  public ContextRepositoryProvider()
  {
  }

  public void setApplicationContext(ApplicationContext context) throws BeansException
  {
    this.context = context;
  }

  public IRepository getRepository(String name)
  {
    Object repository = context.getBean(name, IRepository.class);
    if (repository == null)
    {
      throw new IllegalStateException("Repository not found: " + name);
    }

    return (IRepository)repository;
  }
}
