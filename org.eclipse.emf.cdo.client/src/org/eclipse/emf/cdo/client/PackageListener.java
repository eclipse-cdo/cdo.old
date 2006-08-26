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
package org.eclipse.emf.cdo.client;


/**
 * Can be registered with a {@link PackageManager} to be subsequently notified about
 * newly added packages.<p>
 *
 * @author Eike Stepper
 */
public interface PackageListener
{
  /**
   * Called by the {@link PackageManager} this {@link PackageListener} is 
   * registered with to notify about newly added packages.<p>
   * 
   * {@link PackageManager} API has to be used to determine the set of 
   * packages currently managed by the calling {@link PackageManager}.<p> 
   */
  public void notifyAddedPackage();
}
