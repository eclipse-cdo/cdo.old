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
package org.eclipse.emf.cdo.protocol.model;

import org.eclipse.emf.cdo.protocol.util.CDOClassID;
import org.eclipse.emf.cdo.protocol.util.CDOClassRef;

/**
 * @author Eike Stepper
 */
public interface CDOModelResolver
{
  public String getPackageURI(int modelID);

  public int getPackageID(String uri);

  public CDOPackage getCDOPackage(int modelID);

  public CDOPackage getCDOPackage(String uri);

  public CDOPackage[] getCDOPackages();

  public CDOClass getCDOClass(CDOClassID classID);

  public CDOClass getCDOClass(CDOClassRef classRef);
}
