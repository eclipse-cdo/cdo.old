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
package org.eclipse.net4j.pop.code;

import org.eclipse.net4j.pop.util.IElement;

/**
 * @author Eike Stepper
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface IBranch extends IElement
{
  public String getName();

  public ITag getStartTag();

  public ITag addTag(String name);

  public int getTagCount();

  public ITag getTag(int index);

  public ITag[] getTags();

  public IBranch addBranch(String name, ITag startTag);

  public int getBranchCount();

  public IBranch getBranch(int index);

  public IBranch[] getBranchs();
}
