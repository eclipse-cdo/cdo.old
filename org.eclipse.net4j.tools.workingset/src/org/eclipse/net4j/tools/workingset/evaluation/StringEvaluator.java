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

import org.eclipse.net4j.tools.workingset.dsl.ConcatExpression;
import org.eclipse.net4j.tools.workingset.dsl.PropertyAccess;
import org.eclipse.net4j.tools.workingset.dsl.StringExpression;
import org.eclipse.net4j.tools.workingset.dsl.StringLiteral;
import org.eclipse.net4j.tools.workingset.dsl.util.DslSwitch;

import org.eclipse.core.resources.IResource;

/**
 * @author Eike Stepper
 */
public class StringEvaluator extends DslSwitch<String>
{
  private IResource context;

  public StringEvaluator()
  {
  }

  public IResource getContext()
  {
    return context;
  }

  public void setContext(IResource context)
  {
    this.context = context;
  }

  public synchronized String evaluate(StringExpression expression, IResource resource)
  {
    setContext(resource);

    try
    {
      return doSwitch(expression);
    }
    finally
    {
      setContext(null);
    }
  }

  @Override
  public String caseStringLiteral(StringLiteral object)
  {
    return object.getValue();
  }

  @Override
  public String casePropertyAccess(PropertyAccess object)
  {
    String property = object.getProperty();
    return PropertyRegistry.INSTANCE.access(context, property);
  }

  @Override
  public String caseConcatExpression(ConcatExpression object)
  {
    String left = doSwitch(object.getLeft());
    String right = doSwitch(object.getRight());
    return left + right;
  }
}
