/*
 * Copyright (c) 2008 Open Canarias S.L. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *    Victor Roldan Betancort - GMF models creation and initial generation
 *    Eike Stepper - maintenance
 */
package org.eclipse.emf.cdo.tests.model1.diagram.part;

import org.eclipse.emf.common.util.URI;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;

/**
 * @generated
 */
public class Model1CreationWizardPage extends WizardNewFileCreationPage
{

  /**
   * @generated
   */
  private final String fileExtension;

  /**
   * @generated
   */
  public Model1CreationWizardPage(String pageName, IStructuredSelection selection, String fileExtension)
  {
    super(pageName, selection);
    this.fileExtension = fileExtension;
  }

  /**
   * Override to create files with this extension.
   * 
   * @generated
   */
  protected String getExtension()
  {
    return fileExtension;
  }

  /**
   * @generated
   */
  public URI getURI()
  {
    return URI.createPlatformResourceURI(getFilePath().toString(), false);
  }

  /**
   * @generated
   */
  protected IPath getFilePath()
  {
    IPath path = getContainerFullPath();
    if (path == null)
    {
      path = new Path(""); //$NON-NLS-1$
    }
    String fileName = getFileName();
    if (fileName != null)
    {
      path = path.append(fileName);
    }
    return path;
  }

  /**
   * @generated
   */
  public void createControl(Composite parent)
  {
    super.createControl(parent);
    setFileName(Model1DiagramEditorUtil.getUniqueFileName(getContainerFullPath(), getFileName(), getExtension()));
    setPageComplete(validatePage());
  }

  /**
   * @generated
   */
  protected boolean validatePage()
  {
    if (!super.validatePage())
    {
      return false;
    }
    String extension = getExtension();
    if (extension != null && !getFilePath().toString().endsWith("." + extension))
    {
      setErrorMessage(NLS.bind(Messages.Model1CreationWizardPageExtensionError, extension));
      return false;
    }
    return true;
  }
}
