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

import org.eclipse.emf.cdo.tests.model1.PurchaseOrder;
import org.eclipse.emf.cdo.tests.model1.Supplier;
import org.eclipse.emf.cdo.tests.model1.diagram.edit.policies.Model1BaseItemSemanticEditPolicy;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;

/**
 * @generated
 */
public class CategoryProductsCreateCommand extends EditElementCommand
{

  /**
   * @generated
   */
  private final EObject source;

  /**
   * @generated
   */
  private final EObject target;

  /**
   * @generated
   */
  public CategoryProductsCreateCommand(CreateRelationshipRequest request, EObject source, EObject target)
  {
    super(request.getLabel(), null, request);
    this.source = source;
    this.target = target;
  }

  /**
   * @generated
   */
  public boolean canExecute()
  {
    if (source == null && target == null)
    {
      return false;
    }
    if (source != null && false == source instanceof PurchaseOrder)
    {
      return false;
    }
    if (target != null && false == target instanceof Supplier)
    {
      return false;
    }
    if (getSource() == null)
    {
      return true; // link creation is in progress; source is not defined yet
    }
    // target may be null here but it's possible to check constraint
    return Model1BaseItemSemanticEditPolicy.LinkConstraints.canCreatePurchaseOrderSupplier_4002(getSource(),
        getTarget());
  }

  /**
   * @generated
   */
  protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException
  {
    if (!canExecute())
    {
      throw new ExecutionException("Invalid arguments in create link command"); //$NON-NLS-1$
    }
    if (getSource() != null && getTarget() != null)
    {
      getSource().setSupplier(getTarget());
    }
    return CommandResult.newOKCommandResult();
  }

  /**
   * @generated
   */
  protected PurchaseOrder getSource()
  {
    return (PurchaseOrder)source;
  }

  /**
   * @generated
   */
  protected Supplier getTarget()
  {
    return (Supplier)target;
  }
}
