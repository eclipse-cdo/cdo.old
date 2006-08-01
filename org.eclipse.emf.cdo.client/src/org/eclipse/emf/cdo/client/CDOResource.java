/***************************************************************************
 * Copyright (c) 2004, 2005, 2006 Eike Stepper, Fuggerstr. 39, 10777 Berlin, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 **************************************************************************/
package org.eclipse.emf.cdo.client;


import org.eclipse.emf.ecore.resource.Resource;


public interface CDOResource extends Resource
{
  public ResourceManager getResourceManager();

  public boolean isExisting();

  public void setExisting(boolean existing);

  public String getPath();

  public int getRID();

  public void setPath(String path);
}
