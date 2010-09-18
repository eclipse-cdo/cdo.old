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

import org.eclipse.net4j.tools.workingset.dsl.AndExpression;
import org.eclipse.net4j.tools.workingset.dsl.BooleanComparison;
import org.eclipse.net4j.tools.workingset.dsl.BooleanExpression;
import org.eclipse.net4j.tools.workingset.dsl.BooleanLiteral;
import org.eclipse.net4j.tools.workingset.dsl.HasExpression;
import org.eclipse.net4j.tools.workingset.dsl.IsExpression;
import org.eclipse.net4j.tools.workingset.dsl.NotExpression;
import org.eclipse.net4j.tools.workingset.dsl.OrExpression;
import org.eclipse.net4j.tools.workingset.dsl.StringComparison;
import org.eclipse.net4j.tools.workingset.dsl.StringExpression;
import org.eclipse.net4j.tools.workingset.dsl.TestExpression;
import org.eclipse.net4j.tools.workingset.dsl.XorExpression;
import org.eclipse.net4j.tools.workingset.dsl.util.DslSwitch;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;

import java.util.Iterator;
import java.util.regex.Pattern;

/**
 * @author Eike Stepper
 */
public class BooleanEvaluator extends DslSwitch<Boolean>
{
  private StringEvaluator stringEvaluator;

  private IResource context;

  public BooleanEvaluator()
  {
    this(new StringEvaluator());
  }

  public BooleanEvaluator(StringEvaluator stringEvaluator)
  {
    this.stringEvaluator = stringEvaluator;
  }

  public StringEvaluator getStringEvaluator()
  {
    return stringEvaluator;
  }

  public void setStringEvaluator(StringEvaluator stringEvaluator)
  {
    this.stringEvaluator = stringEvaluator;
    if (stringEvaluator != null)
    {
      stringEvaluator.setContext(context);
    }
  }

  public IResource getContext()
  {
    return context;
  }

  public void setContext(IResource context)
  {
    this.context = context;
    if (stringEvaluator != null)
    {
      stringEvaluator.setContext(context);
    }
  }

  public synchronized boolean evaluate(BooleanExpression expression, IResource resource)
  {
    setContext(resource);

    try
    {
      return doSwitch(expression);
    }
    catch (Exception ex)
    {
      throw new RuntimeException("Problem evaluating " + this, ex);
    }
    finally
    {
      setContext(null);
    }
  }

  @Override
  public Boolean doSwitch(EObject theEObject)
  {
    if (theEObject == null)
    {
      return false;
    }

    return super.doSwitch(theEObject);
  }

  @Override
  public Boolean caseBooleanLiteral(BooleanLiteral object)
  {
    return object.isValue();
  }

  @Override
  public Boolean caseBooleanComparison(BooleanComparison object)
  {
    boolean left = doSwitch(object.getLeft());
    boolean right = doSwitch(object.getRight());

    switch (object.getOperator())
    {
    case EQ:
    case EQ2:
      return left == right;

    case NE:
    case NE2:
      return left != right;

    case GE:
      return !(!left && right);

    case GT:
      return left && !right;

    case LE:
      return !(left && !right);

    case LT:
      return !left && right;

    default:
      throw new IllegalStateException();
    }
  }

  @Override
  public Boolean caseStringComparison(StringComparison object)
  {
    String left = stringEvaluator.doSwitch(object.getLeft());
    String right = stringEvaluator.doSwitch(object.getRight());

    switch (object.getOperator())
    {
    case EQ:
    case EQ2:
      return left.equals(right);

    case NE:
    case NE2:
      return !left.equals(right);

    case GE:
      return left.compareTo(right) >= 0;

    case GT:
      return left.compareTo(right) > 0;

    case LE:
      return left.compareTo(right) <= 0;

    case LT:
      return left.compareTo(right) < 0;

    case LIKE:
    case LIKE2:
    {
      Pattern pattern = compilePattern(right);
      return pattern.matcher(left).matches();
    }

    case UNLIKE:
    case UNLIKE2:
    {
      Pattern pattern = compilePattern(right);
      return !pattern.matcher(left).matches();
    }

    case CONTAINS:
      return left.indexOf(right) != -1;

    case STARTS:
      return left.startsWith(right);

    case ENDS:
      return left.endsWith(right);

    default:
      throw new IllegalStateException();
    }
  }

  @Override
  public Boolean caseOrExpression(OrExpression object)
  {
    boolean left = doSwitch(object.getLeft());
    boolean right = doSwitch(object.getRight());
    return left || right;
  }

  @Override
  public Boolean caseXorExpression(XorExpression object)
  {
    boolean left = doSwitch(object.getLeft());
    boolean right = doSwitch(object.getRight());
    return left ^ right;
  }

  @Override
  public Boolean caseAndExpression(AndExpression object)
  {
    boolean left = doSwitch(object.getLeft());
    boolean right = doSwitch(object.getRight());
    return left && right;
  }

  @Override
  public Boolean caseNotExpression(NotExpression object)
  {
    boolean right = doSwitch(object.getRight());
    return !right;
  }

  @Override
  public Boolean caseIsExpression(IsExpression object)
  {
    int type = context.getType();
    switch (object.getType())
    {
    case FILE:
      return type == IResource.FILE;

    case FOLDER:
      return type == IResource.FOLDER;

    case CONTAINER:
      return type == IResource.FOLDER || type == IResource.PROJECT;

    case PROJECT:
      return type == IResource.PROJECT;

    default:
      throw new IllegalStateException();
    }
  }

  @Override
  public Boolean caseHasExpression(HasExpression object)
  {
    String what = stringEvaluator.doSwitch(object.getWhat());
    switch (object.getKind())
    {
    case NATURE:
      return hasNature(what);

    case BUILDER:
      return hasBuilder(what);

    case REFERENCE:
      return hasReference(what);

    default:
      throw new IllegalStateException();
    }
  }

  @Override
  public Boolean caseTestExpression(TestExpression object)
  {
    String property = TesterRegistry.makeProperty(object.getProperty());
    Object[] args = makeArgs(object.getArgs());
    Object expected = stringEvaluator.doSwitch(object.getExpected());
    return TesterRegistry.INSTANCE.test(context, property, args, expected);
  }

  @Override
  public String toString()
  {
    return context.getFullPath().toPortableString();
  }

  private String[] makeArgs(EList<StringExpression> args)
  {
    String[] result = new String[args.size()];
    Iterator<StringExpression> iterator = args.iterator();
    for (int i = 0; i < result.length; i++)
    {
      String arg = stringEvaluator.doSwitch(iterator.next());
      result[i] = arg;
    }

    return result;
  }

  private boolean hasNature(String what)
  {
    String[] natureIds = getProjectDescription().getNatureIds();
    for (int i = 0; i < natureIds.length; i++)
    {
      String natureId = natureIds[i];
      if (natureId.equals(what))
      {
        return true;
      }
    }

    return false;
  }

  private Boolean hasBuilder(String what)
  {
    ICommand[] buildSpec = getProjectDescription().getBuildSpec();
    for (int i = 0; i < buildSpec.length; i++)
    {
      String builderName = buildSpec[i].getBuilderName();
      if (builderName.equals(what))
      {
        return true;
      }
    }

    return false;
  }

  private Boolean hasReference(String what)
  {
    IProject[] referencedProjects = getProjectDescription().getReferencedProjects();
    for (int i = 0; i < referencedProjects.length; i++)
    {
      String referencedProject = referencedProjects[i].getName();
      if (referencedProject.equals(what))
      {
        return true;
      }
    }

    return false;
  }

  private IProjectDescription getProjectDescription()
  {
    IProject project = context.getProject();

    try
    {
      return project.getDescription();
    }
    catch (CoreException ex)
    {
      throw new RuntimeException("Failed to access description of project " + project.getName(), ex);
    }
  }

  protected Pattern compilePattern(String regex)
  {
    return Pattern.compile(regex);
  }
}
