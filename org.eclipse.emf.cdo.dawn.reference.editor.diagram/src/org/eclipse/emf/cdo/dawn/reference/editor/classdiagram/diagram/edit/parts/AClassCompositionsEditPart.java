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
package org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.edit.parts;

import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.edit.policies.AClassCompositionsItemSemanticEditPolicy;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.PolygonDecoration;
import org.eclipse.draw2d.RotatableDecoration;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITreeBranchEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Color;

/**
 * @generated
 */
public class AClassCompositionsEditPart extends ConnectionNodeEditPart implements ITreeBranchEditPart
{

  /**
   * @generated
   */
  public static final int VISUAL_ID = 4005;

  /**
   * @generated
   */
  public AClassCompositionsEditPart(View view)
  {
    super(view);
  }

  /**
   * @generated
   */
  protected void createDefaultEditPolicies()
  {
    super.createDefaultEditPolicies();
    installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new AClassCompositionsItemSemanticEditPolicy());
  }

  /**
   * Creates figure for this edit part. Body of this method does not depend on settings in generation model so you may
   * safely remove <i>generated</i> tag and modify it.
   * 
   * @generated
   */

  protected Connection createConnectionFigure()
  {
    return new AClassCompositionClassesFigure();
  }

  /**
   * @generated
   */
  public AClassCompositionClassesFigure getPrimaryShape()
  {
    return (AClassCompositionClassesFigure)getFigure();
  }

  /**
   * @generated
   */
  public class AClassCompositionClassesFigure extends PolylineConnectionEx
  {

    /**
     * @generated
     */
    public AClassCompositionClassesFigure()
    {
      this.setLineWidth(1);

      setTargetDecoration(createTargetDecoration());
    }

    /**
     * @generated
     */
    private RotatableDecoration createTargetDecoration()
    {
      PolygonDecoration df = new PolygonDecoration();
      df.setFill(true);
      df.setLineWidth(1);
      df.setBackgroundColor(DF_BACK);
      PointList pl = new PointList();
      pl.addPoint(getMapMode().DPtoLP(-2), getMapMode().DPtoLP(2));
      pl.addPoint(getMapMode().DPtoLP(0), getMapMode().DPtoLP(0));
      pl.addPoint(getMapMode().DPtoLP(-2), getMapMode().DPtoLP(-2));
      pl.addPoint(getMapMode().DPtoLP(-4), getMapMode().DPtoLP(0));
      pl.addPoint(getMapMode().DPtoLP(-2), getMapMode().DPtoLP(2));
      df.setTemplate(pl);
      df.setScale(getMapMode().DPtoLP(7), getMapMode().DPtoLP(3));
      return df;
    }

  }

  /**
   * @generated
   */
  static final Color DF_BACK = new Color(null, 0, 0, 0);

}
