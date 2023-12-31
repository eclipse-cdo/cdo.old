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
package org.eclipse.emf.cdo.tests.model1.diagram.edit.policies;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyReferenceCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;

/**
 * @generated
 */
public class CategoryProducts2ItemSemanticEditPolicy extends Model1BaseItemSemanticEditPolicy
{

  /**
   * @generated
   */
  protected Command getDestroyReferenceCommand(DestroyReferenceRequest req)
  {
    return getGEFWrapper(new DestroyReferenceCommand(req)
    {

      protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info)
          throws ExecutionException
      {
        EObject referencedObject = getReferencedObject();
        Resource resource = referencedObject.eResource();
        CommandResult result = super.doExecuteWithResult(progressMonitor, info);
        resource.getContents().add(referencedObject);
        return result;
      }

    });
  }

}
