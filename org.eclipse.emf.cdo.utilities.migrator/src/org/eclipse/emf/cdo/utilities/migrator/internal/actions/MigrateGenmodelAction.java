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
package org.eclipse.emf.cdo.utilities.migrator.internal.actions;


import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.cdo.utilities.migrator.MigratorUtil;


public class MigrateGenmodelAction extends AbstractFileAction
{
  @Override
  protected String doRun(IFile file, IProgressMonitor monitor) throws Exception
  {
    String fullPath = getCurrentFile().getFullPath().toString();
    boolean modified = MigratorUtil.migrateGenmodel(fullPath);
    if (!modified)
    {
      return "Genmodel file was already properly migrated.";
    }

    return "Genmodel file migrated.";
  }
}
