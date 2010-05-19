/*******************************************************************************
 * Copyright (c) 2004 - 2010 Eike Stepper (Berlin, Germany).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Martin Fluegge - initial API and implementation
 ******************************************************************************/
package org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.edit.commands;

import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.AClass;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.AInterface;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.edit.policies.ClassdiagramBaseItemSemanticEditPolicy;

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
public class AClassImplementedInterfacesCreateCommand extends EditElementCommand
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
  public AClassImplementedInterfacesCreateCommand(CreateRelationshipRequest request, EObject source, EObject target)
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
    if (source != null && false == source instanceof AClass)
    {
      return false;
    }
    if (target != null && false == target instanceof AInterface)
    {
      return false;
    }
    if (getSource() == null)
    {
      return true; // link creation is in progress; source is not defined yet
    }
    // target may be null here but it's possible to check constraint
    return ClassdiagramBaseItemSemanticEditPolicy.LinkConstraints.canCreateAClassImplementedInterfaces_4002(
        getSource(), getTarget());
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
      getSource().getImplementedInterfaces().add(getTarget());
    }
    return CommandResult.newOKCommandResult();

  }

  /**
   * @generated
   */
  protected void setElementToEdit(EObject element)
  {
    throw new UnsupportedOperationException();
  }

  /**
   * @generated
   */
  protected AClass getSource()
  {
    return (AClass)source;
  }

  /**
   * @generated
   */
  protected AInterface getTarget()
  {
    return (AInterface)target;
  }
}
