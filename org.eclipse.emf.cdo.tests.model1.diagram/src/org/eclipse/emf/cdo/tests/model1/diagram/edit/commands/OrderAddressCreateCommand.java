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

import org.eclipse.emf.cdo.tests.model1.Model1Factory;
import org.eclipse.emf.cdo.tests.model1.Product1;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class OrderAddressCreateCommand extends CreateElementCommand
{

  /**
   * @generated
   */
  public OrderAddressCreateCommand(CreateElementRequest req)
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
  public boolean canExecute()
  {
    if (getEClass() != null)
    {
      return getEClass().isSuperTypeOf(getEClassToEdit());
    }
    return true;
  }

  /**
   * @generated
   */
  protected EReference getContainmentFeature()
  {
    return null;
  }

  /**
   * @generated
   */
  protected EObject doDefaultElementCreation()
  {
    // Uncomment to put "phantom" objects into the diagram file.
    // org.eclipse.emf.ecore.resource.Resource resource =
    // ((org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest) getRequest()).getContainer().eResource();
    // if (resource == null) {
    // return null;
    // }
    Resource resource = getElementToEdit().eResource();
    Product1 newElement = Model1Factory.eINSTANCE.createProduct1();

    resource.getContents().add(newElement);
    return newElement;
  }

}
