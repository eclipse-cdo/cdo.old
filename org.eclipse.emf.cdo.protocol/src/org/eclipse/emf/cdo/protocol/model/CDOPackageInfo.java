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
package org.eclipse.emf.cdo.protocol.model;

import org.eclipse.emf.cdo.protocol.id.CDOIDRange;

/**
 * TODO Add read(), write(), ...
 * 
 * @author Eike Stepper
 */
public final class CDOPackageInfo
{
  private String packageURI;

  private boolean dynamic;

  private CDOIDRange metaIDRange;

  public CDOPackageInfo(String packageURI, boolean dynamic, CDOIDRange metaIDRange)
  {
    this.packageURI = packageURI;
    this.dynamic = dynamic;
    this.metaIDRange = metaIDRange;
  }

  public String getPackageURI()
  {
    return packageURI;
  }

  public boolean isDynamic()
  {
    return dynamic;
  }

  public CDOIDRange getMetaIDRange()
  {
    return metaIDRange;
  }
}
