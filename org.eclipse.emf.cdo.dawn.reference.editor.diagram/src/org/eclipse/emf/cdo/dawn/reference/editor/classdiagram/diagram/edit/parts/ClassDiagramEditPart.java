/*******************************************************************************
 * Copyright (c) 2010 Martin Fluegge (Berlin, Germany).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Martin Fluegge - initial API and implementation
 ******************************************************************************/
package org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.edit.parts;

import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.edit.policies.ClassDiagramCanonicalEditPolicy;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.edit.policies.ClassDiagramItemSemanticEditPolicy;

import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class ClassDiagramEditPart extends DiagramEditPart
{

  /**
   * @generated
   */
  public final static String MODEL_ID = "Classdiagram"; //$NON-NLS-1$

  /**
   * @generated
   */
  public static final int VISUAL_ID = 1000;

  /**
   * @generated
   */
  public ClassDiagramEditPart(View view)
  {
    super(view);
  }

  /**
   * @generated
   */
  protected void createDefaultEditPolicies()
  {
    super.createDefaultEditPolicies();
    installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new ClassDiagramItemSemanticEditPolicy());
    installEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new ClassDiagramCanonicalEditPolicy());
    // removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.POPUPBAR_ROLE);
  }

}
