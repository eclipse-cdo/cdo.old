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

import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.edit.policies.AClassImplementedInterfacesItemSemanticEditPolicy;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.PolylineDecoration;
import org.eclipse.draw2d.RotatableDecoration;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITreeBranchEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class AClassImplementedInterfacesEditPart extends ConnectionNodeEditPart implements ITreeBranchEditPart
{

  /**
   * @generated
   */
  public static final int VISUAL_ID = 4002;

  /**
   * @generated
   */
  public AClassImplementedInterfacesEditPart(View view)
  {
    super(view);
  }

  /**
   * @generated
   */
  protected void createDefaultEditPolicies()
  {
    super.createDefaultEditPolicies();
    installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new AClassImplementedInterfacesItemSemanticEditPolicy());
  }

  /**
   * Creates figure for this edit part. Body of this method does not depend on settings in generation model so you may
   * safely remove <i>generated</i> tag and modify it.
   * 
   * @generated
   */

  protected Connection createConnectionFigure()
  {
    return new AClassImplementedInterfacesFigure();
  }

  /**
   * @generated
   */
  public AClassImplementedInterfacesFigure getPrimaryShape()
  {
    return (AClassImplementedInterfacesFigure)getFigure();
  }

  /**
   * @generated
   */
  public class AClassImplementedInterfacesFigure extends PolylineConnectionEx
  {

    /**
     * @generated
     */
    public AClassImplementedInterfacesFigure()
    {
      this.setLineWidth(1);
      this.setLineStyle(Graphics.LINE_DASH);

      setTargetDecoration(createTargetDecoration());
    }

    /**
     * @generated
     */
    private RotatableDecoration createTargetDecoration()
    {
      PolylineDecoration df = new PolylineDecoration();
      df.setLineWidth(1);
      return df;
    }

  }

}
