/**
 * Copyright (c) 2004 - 2009 Eike Stepper (Berlin, Germany) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Eike Stepper - initial API and implementation
 */
package org.eclipse.net4j.tools.workingset.evaluation;

import org.eclipse.net4j.tools.workingset.DslRuntimeModule;

import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.StringInputStream;

import com.google.inject.Guice;
import com.google.inject.Injector;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Eike Stepper
 */
public class Definition implements Serializable
{
  private static final long serialVersionUID = 1L;

  private String expression;

  private List<String> result = new ArrayList<String>();

  private transient XtextResource resource;

  public Definition()
  {
  }

  public Definition(String expression)
  {
    this.expression = expression;
  }

  public String getExpression()
  {
    return expression;
  }

  public void setExpression(String expression)
  {
    this.expression = expression;
  }

  public List<String> getResult()
  {
    return result;
  }

  public XtextResource getResource()
  {
    return resource;
  }

  public void evaluate()
  {
    Injector injector = Guice.createInjector(new DslRuntimeModule());
    resource = injector.getInstance(XtextResource.class);

    try
    {
      resource.load(new StringInputStream(expression, resource.getEncoding()), Collections.emptyMap());
    }
    catch (Exception e)
    {
      throw new RuntimeException(e);
    }
  }
}
