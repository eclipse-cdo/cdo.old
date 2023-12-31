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

import org.eclipse.emf.cdo.tests.model1.Order;
import org.eclipse.emf.cdo.tests.model1.OrderDetail;
import org.eclipse.emf.cdo.tests.model1.diagram.edit.policies.Model1BaseItemSemanticEditPolicy;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;

/**
 * @generated
 */
public class OrderOrderDetails2ReorientCommand extends EditElementCommand
{

  /**
   * @generated
   */
  private final int reorientDirection;

  /**
   * @generated
   */
  private final EObject referenceOwner;

  /**
   * @generated
   */
  private final EObject oldEnd;

  /**
   * @generated
   */
  private final EObject newEnd;

  /**
   * @generated
   */
  public OrderOrderDetails2ReorientCommand(ReorientReferenceRelationshipRequest request)
  {
    super(request.getLabel(), null, request);
    reorientDirection = request.getDirection();
    referenceOwner = request.getReferenceOwner();
    oldEnd = request.getOldRelationshipEnd();
    newEnd = request.getNewRelationshipEnd();
  }

  /**
   * @generated
   */
  public boolean canExecute()
  {
    if (false == referenceOwner instanceof Order)
    {
      return false;
    }
    if (reorientDirection == ReorientRelationshipRequest.REORIENT_SOURCE)
    {
      return canReorientSource();
    }
    if (reorientDirection == ReorientRelationshipRequest.REORIENT_TARGET)
    {
      return canReorientTarget();
    }
    return false;
  }

  /**
   * @generated
   */
  protected boolean canReorientSource()
  {
    if (!(oldEnd instanceof OrderDetail && newEnd instanceof Order))
    {
      return false;
    }
    return Model1BaseItemSemanticEditPolicy.LinkConstraints.canExistOrderOrderDetails_4004(getNewSource(),
        getOldTarget());
  }

  /**
   * @generated
   */
  protected boolean canReorientTarget()
  {
    if (!(oldEnd instanceof OrderDetail && newEnd instanceof OrderDetail))
    {
      return false;
    }
    return Model1BaseItemSemanticEditPolicy.LinkConstraints.canExistOrderOrderDetails_4004(getOldSource(),
        getNewTarget());
  }

  /**
   * @generated
   */
  protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException
  {
    if (!canExecute())
    {
      throw new ExecutionException("Invalid arguments in reorient link command"); //$NON-NLS-1$
    }
    if (reorientDirection == ReorientRelationshipRequest.REORIENT_SOURCE)
    {
      return reorientSource();
    }
    if (reorientDirection == ReorientRelationshipRequest.REORIENT_TARGET)
    {
      return reorientTarget();
    }
    throw new IllegalStateException();
  }

  /**
   * @generated
   */
  protected CommandResult reorientSource() throws ExecutionException
  {
    getOldSource().getOrderDetails().remove(getOldTarget());
    getNewSource().getOrderDetails().add(getOldTarget());
    return CommandResult.newOKCommandResult(referenceOwner);
  }

  /**
   * @generated
   */
  protected CommandResult reorientTarget() throws ExecutionException
  {
    getOldSource().getOrderDetails().remove(getOldTarget());
    getOldSource().getOrderDetails().add(getNewTarget());
    return CommandResult.newOKCommandResult(referenceOwner);
  }

  /**
   * @generated
   */
  protected Order getOldSource()
  {
    return (Order)referenceOwner;
  }

  /**
   * @generated
   */
  protected Order getNewSource()
  {
    return (Order)newEnd;
  }

  /**
   * @generated
   */
  protected OrderDetail getOldTarget()
  {
    return (OrderDetail)oldEnd;
  }

  /**
   * @generated
   */
  protected OrderDetail getNewTarget()
  {
    return (OrderDetail)newEnd;
  }
}
