/***************************************************************************
 * Copyright (c) 2004-2006 Eike Stepper, Fuggerstr. 39, 10777 Berlin, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 **************************************************************************/
package org.eclipse.net4j.examples.mvc;


import org.eclipse.net4j.examples.mvc.aspect.IMetaDataAspect;


public interface IBinding<TARGET> extends IMetaDataAspect
{
  /**
   * The implementation of this method must not access the state of this instance, since it is
   * called from an abstract constructor.
   */
  public Class getAspect();

  public IController<TARGET> getController();

  public String getTargetName();

  public TARGET getTarget();

  public TARGET setTarget(TARGET target);

  public IAdapter<TARGET> getAdapter();
}
