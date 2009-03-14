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
package org.eclipse.emf.cdo.tests.model1.diagram.edit.parts;

import org.eclipse.emf.cdo.tests.model1.diagram.edit.policies.Model1TextSelectionEditPolicy;
import org.eclipse.emf.cdo.tests.model1.diagram.edit.policies.OrderDetailCanonicalEditPolicy;
import org.eclipse.emf.cdo.tests.model1.diagram.edit.policies.OrderDetailItemSemanticEditPolicy;
import org.eclipse.emf.cdo.tests.model1.diagram.part.Model1VisualIDRegistry;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ConstrainedToolbarLayoutEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class OrderDetailEditPart extends ShapeNodeEditPart
{

  /**
   * @generated
   */
  public static final int VISUAL_ID = 2005;

  /**
   * @generated
   */
  protected IFigure contentPane;

  /**
   * @generated
   */
  protected IFigure primaryShape;

  /**
   * @generated
   */
  public OrderDetailEditPart(View view)
  {
    super(view);
  }

  /**
   * @generated
   */
  protected void createDefaultEditPolicies()
  {
    super.createDefaultEditPolicies();
    installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new OrderDetailItemSemanticEditPolicy());
    installEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new OrderDetailCanonicalEditPolicy());
    installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
    // XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable
    // editpolicies
    // removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
  }

  /**
   * @generated
   */
  protected LayoutEditPolicy createLayoutEditPolicy()
  {

    ConstrainedToolbarLayoutEditPolicy lep = new ConstrainedToolbarLayoutEditPolicy()
    {

      protected EditPolicy createChildEditPolicy(EditPart child)
      {
        if (child.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE) == null)
        {
          if (child instanceof ITextAwareEditPart)
          {
            return new Model1TextSelectionEditPolicy();
          }
        }
        return super.createChildEditPolicy(child);
      }
    };
    return lep;
  }

  /**
   * @generated
   */
  protected IFigure createNodeShape()
  {
    SalesOrderFigure figure = new SalesOrderFigure();
    return primaryShape = figure;
  }

  /**
   * @generated
   */
  public SalesOrderFigure getPrimaryShape()
  {
    return (SalesOrderFigure)primaryShape;
  }

  /**
   * @generated
   */
  protected boolean addFixedChild(EditPart childEditPart)
  {
    if (childEditPart instanceof OrderDetailPriceEditPart)
    {
      ((OrderDetailPriceEditPart)childEditPart).setLabel(getPrimaryShape().getFigureSalesOrderNameFigure());
      return true;
    }
    return false;
  }

  /**
   * @generated
   */
  protected boolean removeFixedChild(EditPart childEditPart)
  {

    return false;
  }

  /**
   * @generated
   */
  protected void addChildVisual(EditPart childEditPart, int index)
  {
    if (addFixedChild(childEditPart))
    {
      return;
    }
    super.addChildVisual(childEditPart, -1);
  }

  /**
   * @generated
   */
  protected void removeChildVisual(EditPart childEditPart)
  {
    if (removeFixedChild(childEditPart))
    {
      return;
    }
    super.removeChildVisual(childEditPart);
  }

  /**
   * @generated
   */
  protected IFigure getContentPaneFor(IGraphicalEditPart editPart)
  {

    return super.getContentPaneFor(editPart);
  }

  /**
   * @generated
   */
  protected NodeFigure createNodePlate()
  {
    DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(getMapMode().DPtoLP(40), getMapMode().DPtoLP(40));
    return result;
  }

  /**
   * Creates figure for this edit part. Body of this method does not depend on settings in generation model so you may
   * safely remove <i>generated</i> tag and modify it.
   * 
   * @generated
   */
  protected NodeFigure createNodeFigure()
  {
    NodeFigure figure = createNodePlate();
    figure.setLayoutManager(new StackLayout());
    IFigure shape = createNodeShape();
    figure.add(shape);
    contentPane = setupContentPane(shape);
    return figure;
  }

  /**
   * Default implementation treats passed figure as content pane. Respects layout one may have set for generated figure.
   * 
   * @param nodeShape
   *          instance of generated figure class
   * @generated
   */
  protected IFigure setupContentPane(IFigure nodeShape)
  {
    if (nodeShape.getLayoutManager() == null)
    {
      ConstrainedToolbarLayout layout = new ConstrainedToolbarLayout();
      layout.setSpacing(getMapMode().DPtoLP(5));
      nodeShape.setLayoutManager(layout);
    }
    return nodeShape; // use nodeShape itself as contentPane
  }

  /**
   * @generated
   */
  public IFigure getContentPane()
  {
    if (contentPane != null)
    {
      return contentPane;
    }
    return super.getContentPane();
  }

  /**
   * @generated
   */
  public EditPart getPrimaryChildEditPart()
  {
    return getChildBySemanticHint(Model1VisualIDRegistry.getType(OrderDetailPriceEditPart.VISUAL_ID));
  }

  /**
   * @generated
   */
  public class SalesOrderFigure extends RectangleFigure
  {

    /**
     * @generated
     */
    private WrappingLabel fFigureSalesOrderStereotypeFigure;

    /**
     * @generated
     */
    private WrappingLabel fFigureSalesOrderNameFigure;

    /**
     * @generated
     */
    public SalesOrderFigure()
    {

      ToolbarLayout layoutThis = new ToolbarLayout();
      layoutThis.setStretchMinorAxis(true);
      layoutThis.setMinorAlignment(ToolbarLayout.ALIGN_CENTER);

      layoutThis.setSpacing(5);
      layoutThis.setVertical(true);

      this.setLayoutManager(layoutThis);

      createContents();
    }

    /**
     * @generated
     */
    private void createContents()
    {

      fFigureSalesOrderStereotypeFigure = new WrappingLabel();
      fFigureSalesOrderStereotypeFigure.setText("<<SalesOrder>>");

      this.add(fFigureSalesOrderStereotypeFigure);

      fFigureSalesOrderNameFigure = new WrappingLabel();
      fFigureSalesOrderNameFigure.setText("...");

      this.add(fFigureSalesOrderNameFigure);

    }

    /**
     * @generated
     */
    private boolean myUseLocalCoordinates = false;

    /**
     * @generated
     */
    protected boolean useLocalCoordinates()
    {
      return myUseLocalCoordinates;
    }

    /**
     * @generated
     */
    protected void setUseLocalCoordinates(boolean useLocalCoordinates)
    {
      myUseLocalCoordinates = useLocalCoordinates;
    }

    /**
     * @generated
     */
    public WrappingLabel getFigureSalesOrderStereotypeFigure()
    {
      return fFigureSalesOrderStereotypeFigure;
    }

    /**
     * @generated
     */
    public WrappingLabel getFigureSalesOrderNameFigure()
    {
      return fFigureSalesOrderNameFigure;
    }

  }

}
