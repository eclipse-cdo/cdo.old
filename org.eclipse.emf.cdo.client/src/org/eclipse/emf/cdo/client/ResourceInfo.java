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


import org.eclipse.emf.cdo.core.RID;


/**
 * Stores information about a {@link CDOResource} without being coupled to the lifecycle 
 * of that {@link CDOResource}.<p>
 *
 * This interface is not expected to be implemeted by clients.<p>
 * 
 * @see CDOResource
 * @author Eike Stepper
 */
public interface ResourceInfo
{
  /**
   * Returns <code>true</code> if the implicitely associated {@link CDOResource}
   * exists in the CDO repository, <code>false</code> otherwise.<p>
   *
   * @return <code>true</code> if the implicitely associated {@link CDOResource}
   * exists in the CDO repository, <code>false</code> otherwise.<p>
   */
  public boolean isExisting();

  /**
   * For internal use only.<p>
   */
  public void setExisting(boolean existing);

  /**
   * Returns the path of the implicitely associated {@link CDOResource}.<p>
   *
   * @return The path of the implicitely associated {@link CDOResource}.<p>
   */
  public String getPath();

  /**
   * For internal use only.<p>
   */
  public void setPath(String path);

  /**
   * Returns the {@link RID} of the implicitely associated {@link CDOResource}.<p>
   *
   * @return The {@link RID} of the implicitely associated {@link CDOResource}.<p>
   */
  public int getRID();
}
