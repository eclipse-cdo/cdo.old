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

public class UpdateClasspathAction extends AbstractFileAction
{
  public UpdateClasspathAction()
  {
    super(false);
  }

  @Override
  protected String doRun(IFile file, IProgressMonitor monitor) throws Exception
  {
    String fullPath = file.getFullPath().toString();
    boolean ok = MigratorUtil.updateClasspath(fullPath);
    if (!ok)
    {
      return "The classpath was already set for CDO. MANIFEST.MF was not modified.";
    }

    return "MANIFEST.MF was modified.";
  }
}
