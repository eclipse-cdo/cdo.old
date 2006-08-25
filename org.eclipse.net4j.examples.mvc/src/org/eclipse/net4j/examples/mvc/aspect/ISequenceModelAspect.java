/***************************************************************************
 * Copyright (c) 2004, 2005, 2006 Eike Stepper, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 **************************************************************************/
package org.eclipse.net4j.examples.mvc.aspect;


import java.util.List;


public interface ISequenceModelAspect extends List
{
  public Object onVerify(int index, Object newItem);

  public void onSet(int index, Object newItem, Object oldItem);

  public void onAdd(int index, Object item);

  public void onRemove(int index, Object item);

  public void onMove(int fromIndex, int toIndex);
}
