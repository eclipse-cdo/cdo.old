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
package org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.providers;

import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.edit.parts.ClassDiagramEditPart;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.edit.policies.DawnClassDiagramCanonicalEditPolicy;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.part.ClassdiagramDiagramEditorPlugin;

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.CreateEditPoliciesOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.IEditPolicyProvider;

/**
 * @author Martin Fluegge
 */
public class DawnClassdiagramEditPolicyProvider extends AbstractProvider implements IEditPolicyProvider
{
  public static String ID = "org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.providers.DawnClassdiagramEditPolicyProvider";

  public boolean provides(IOperation operation)
  {
    if (operation instanceof CreateEditPoliciesOperation)
    {
      CreateEditPoliciesOperation editPoliciesOperation = (CreateEditPoliciesOperation)operation;
      if (editPoliciesOperation.getEditPart() instanceof ClassDiagramEditPart)
      {
        return true;
      }
    }
    return false;
  }

  public void createEditPolicies(EditPart editPart)
  {
    if (editPart instanceof ClassDiagramEditPart)
    {
      ClassdiagramDiagramEditorPlugin.getInstance().logInfo("Overwriting CANONICAL EDITING POLICY in " + editPart);
      editPart.installEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new DawnClassDiagramCanonicalEditPolicy());
    }
  }
}
