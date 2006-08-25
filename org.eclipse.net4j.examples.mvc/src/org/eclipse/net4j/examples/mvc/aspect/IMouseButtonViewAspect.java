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


public interface IMouseButtonViewAspect
{
  public void onMouseDoubleClick(int button, int stateMask, int x, int y);

  public void onMouseDown(int button, int stateMask, int x, int y);

  public void onMouseUp(int button, int stateMask, int x, int y);
}
