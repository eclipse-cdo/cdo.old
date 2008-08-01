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
package org.eclipse.net4j.internal.pop.code;

import org.eclipse.net4j.internal.pop.util.Element;
import org.eclipse.net4j.pop.code.IBranch;
import org.eclipse.net4j.pop.code.ITag;

import java.text.MessageFormat;

/**
 * @author Eike Stepper
 */
public class Tag extends Element implements ITag
{
  private IBranch branch;

  private String name;

  public Tag(IBranch branch, String name)
  {
    checkArgument(branch, "branch");
    checkArgument(name, "name");
    this.branch = branch;
    this.name = name;
  }

  public IBranch getBranch()
  {
    return branch;
  }

  public String getName()
  {
    return name;
  }

  @Override
  public String toString()
  {
    return MessageFormat.format("Branch[branch={0}, name={1}]", branch.getName(), name);
  }
}
