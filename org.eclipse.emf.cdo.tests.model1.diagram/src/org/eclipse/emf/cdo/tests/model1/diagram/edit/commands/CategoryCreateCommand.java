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
package org.eclipse.emf.cdo.tests.model1.diagram.edit.commands;

import org.eclipse.emf.cdo.tests.model1.Model1Package;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class CategoryCreateCommand extends CreateElementCommand
{

  /**
   * @generated
   */
  public CategoryCreateCommand(CreateElementRequest req)
  {
    super(req);
  }

  /**
   * @generated
   */
  protected EObject getElementToEdit()
  {
    EObject container = ((CreateElementRequest)getRequest()).getContainer();
    if (container instanceof View)
    {
      container = ((View)container).getElement();
    }
    return container;
  }

  /**
   * @generated
   */
  protected EClass getEClassToEdit()
  {
    return Model1Package.eINSTANCE.getCompany();
  }

}
