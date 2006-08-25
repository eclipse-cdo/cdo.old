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
package org.eclipse.emf.cdo.utilities.migrator;


import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;

import java.io.IOException;
import java.util.Collections;


public abstract class AbstractResourceAction extends AbstractFileAction
{
  /**
   * @param resourceSet
   * @param uri
   * @return
   */
  protected Resource loadResource(ResourceSet resourceSet, String uri)
  {
    Resource resource = resourceSet.createResource(URI.createPlatformResourceURI(uri));

    try
    {
      resource.load(Collections.EMPTY_MAP);
    }
    catch (IOException ex)
    {
      MessageDialog.openError(new Shell(), "Migrator Plug-in", "Error: " + ex.getMessage());
      return null;
    }

    return resource;
  }
}
