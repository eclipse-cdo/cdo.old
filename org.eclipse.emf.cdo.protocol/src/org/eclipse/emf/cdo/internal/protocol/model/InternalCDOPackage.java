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
package org.eclipse.emf.cdo.internal.protocol.model;

import org.eclipse.emf.cdo.protocol.id.CDOIDMetaRange;
import org.eclipse.emf.cdo.protocol.model.CDOClass;
import org.eclipse.emf.cdo.protocol.model.CDOPackage;
import org.eclipse.emf.cdo.protocol.model.CDOPackageManager;

import org.eclipse.net4j.util.io.ExtendedDataInput;
import org.eclipse.net4j.util.io.ExtendedDataOutput;

import java.io.IOException;

/**
 * @author Eike Stepper
 */
public interface InternalCDOPackage extends CDOPackage, InternalCDOModelElement
{
  public void setPackageManager(CDOPackageManager packageManager);

  public void setPersistent(boolean persistent);

  public void setMetaIDRange(CDOIDMetaRange metaIDRange);

  public void setEcore(String ecore);

  public void addClass(CDOClass cdoClass);

  public void read(ExtendedDataInput in) throws IOException;

  public void write(ExtendedDataOutput out) throws IOException;
}
