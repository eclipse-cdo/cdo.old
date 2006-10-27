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

import org.eclipse.emf.cdo.utilities.migrator.MigratorUtil;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;

public class MigrateEcoreAction extends AbstractFileAction
{
  public MigrateEcoreAction()
  {
    super(true);
  }

  @Override
  protected String doRun(IFile file, IProgressMonitor monitor) throws Exception
  {
    String fullPath = file.getFullPath().toString();
    int modifications = MigratorUtil.migrateEcore(fullPath);
    if (modifications == 0)
    {
      return "Ecore file was already properly migrated. No classes have been modified.";
    }

    return "Ecore file migrated. " + modifications + " classes have been modified.";
  }
}
