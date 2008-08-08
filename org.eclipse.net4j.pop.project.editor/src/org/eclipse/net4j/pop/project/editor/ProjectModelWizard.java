/**
 * Copyright (c) 2004 - 2008 Eike Stepper, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 *
 * $Id: ProjectModelWizard.java,v 1.1 2008-08-08 10:10:33 estepper Exp $
 */
package org.eclipse.net4j.pop.project.editor;

import org.eclipse.net4j.pop.base.editor.BaseModelWizard;
import org.eclipse.net4j.pop.project.ProjectPackage;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @generated NOT
 */
public class ProjectModelWizard extends BaseModelWizard
{
  public static final List<String> FILE_EXTENSIONS = Collections.unmodifiableList(Arrays
      .asList(ProjectEditorPlugin.INSTANCE.getString("_UI_ProjectEditorFilenameExtensions").split("\\s*,\\s*"))); //$NON-NLS-1$ //$NON-NLS-2$

  public static final String FORMATTED_FILE_EXTENSIONS = ProjectEditorPlugin.INSTANCE.getString(
      "_UI_ProjectEditorFilenameExtensions").replaceAll("\\s*,\\s*", ", ");

  public ProjectModelWizard()
  {
    super(ProjectPackage.eINSTANCE, FILE_EXTENSIONS, FORMATTED_FILE_EXTENSIONS);
    // plugin = ProjectEditorPlugin.INSTANCE;
  }
}
