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

import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.edit.policies.AClassItemSemanticEditPolicy;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.edit.policies.ClassdiagramTextSelectionEditPolicy;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.part.ClassdiagramVisualIDRegistry;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.providers.ClassdiagramElementTypes;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ConstrainedToolbarLayoutEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Color;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @generated
 */
public class AClassEditPart extends ShapeNodeEditPart
{

  /**
   * @generated
   */
  public static final int VISUAL_ID = 2002;

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
  public AClassEditPart(View view)
  {
    super(view);
  }

  /**
   * @generated
   */
  protected void createDefaultEditPolicies()
  {
    installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CreationEditPolicy());
    super.createDefaultEditPolicies();
    installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new AClassItemSemanticEditPolicy());
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
            return new ClassdiagramTextSelectionEditPolicy();
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
    AClassFigure figure = new AClassFigure();
    return primaryShape = figure;
  }

  /**
   * @generated
   */
  public AClassFigure getPrimaryShape()
  {
    return (AClassFigure)primaryShape;
  }

  /**
   * @generated
   */
  protected boolean addFixedChild(EditPart childEditPart)
  {
    if (childEditPart instanceof AClassNameEditPart)
    {
      ((AClassNameEditPart)childEditPart).setLabel(getPrimaryShape().getFigureAClassNameFigure());
      return true;
    }
    if (childEditPart instanceof AClassAnAttributeCompartmentEditPart)
    {
      IFigure pane = getPrimaryShape().getFigureClassAttributes();
      setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way
      pane.add(((AClassAnAttributeCompartmentEditPart)childEditPart).getFigure());
      return true;
    }
    if (childEditPart instanceof AClassAnOperationClassCompartmentEditPart)
    {
      IFigure pane = getPrimaryShape().getFigureClassOperations();
      setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way
      pane.add(((AClassAnOperationClassCompartmentEditPart)childEditPart).getFigure());
      return true;
    }
    return false;
  }

  /**
   * @generated
   */
  protected boolean removeFixedChild(EditPart childEditPart)
  {
    if (childEditPart instanceof AClassNameEditPart)
    {
      return true;
    }
    if (childEditPart instanceof AClassAnAttributeCompartmentEditPart)
    {
      IFigure pane = getPrimaryShape().getFigureClassAttributes();
      setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way
      pane.remove(((AClassAnAttributeCompartmentEditPart)childEditPart).getFigure());
      return true;
    }
    if (childEditPart instanceof AClassAnOperationClassCompartmentEditPart)
    {
      IFigure pane = getPrimaryShape().getFigureClassOperations();
      setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way
      pane.remove(((AClassAnOperationClassCompartmentEditPart)childEditPart).getFigure());
      return true;
    }
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
    if (editPart instanceof AClassAnAttributeCompartmentEditPart)
    {
      return getPrimaryShape().getFigureClassAttributes();
    }
    if (editPart instanceof AClassAnOperationClassCompartmentEditPart)
    {
      return getPrimaryShape().getFigureClassOperations();
    }
    return getContentPane();
  }

  /**
   * @generated
   */
  protected NodeFigure createNodePlate()
  {
    DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(40, 40);
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
      layout.setSpacing(5);
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
  protected void setForegroundColor(Color color)
  {
    if (primaryShape != null)
    {
      primaryShape.setForegroundColor(color);
    }
  }

  /**
   * @generated
   */
  protected void setBackgroundColor(Color color)
  {
    if (primaryShape != null)
    {
      primaryShape.setBackgroundColor(color);
    }
  }

  /**
   * @generated
   */
  protected void setLineWidth(int width)
  {
    if (primaryShape instanceof Shape)
    {
      ((Shape)primaryShape).setLineWidth(width);
    }
  }

  /**
   * @generated
   */
  protected void setLineType(int style)
  {
    if (primaryShape instanceof Shape)
    {
      ((Shape)primaryShape).setLineStyle(style);
    }
  }

  /**
   * @generated
   */
  public EditPart getPrimaryChildEditPart()
  {
    return getChildBySemanticHint(ClassdiagramVisualIDRegistry.getType(AClassNameEditPart.VISUAL_ID));
  }

  /**
   * @generated
   */
  public List<IElementType> getMARelTypesOnSource()
  {
    ArrayList<IElementType> types = new ArrayList<IElementType>(5);
    types.add(ClassdiagramElementTypes.AClassSubClasses_4001);
    types.add(ClassdiagramElementTypes.AClassImplementedInterfaces_4002);
    types.add(ClassdiagramElementTypes.AClassAssociations_4003);
    types.add(ClassdiagramElementTypes.AClassAggregations_4004);
    types.add(ClassdiagramElementTypes.AClassCompositions_4005);
    return types;
  }

  /**
   * @generated
   */
  public List<IElementType> getMARelTypesOnSourceAndTarget(IGraphicalEditPart targetEditPart)
  {
    LinkedList<IElementType> types = new LinkedList<IElementType>();
    if (targetEditPart instanceof org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.edit.parts.AClassEditPart)
    {
      types.add(ClassdiagramElementTypes.AClassSubClasses_4001);
    }
    if (targetEditPart instanceof AInterfaceEditPart)
    {
      types.add(ClassdiagramElementTypes.AClassImplementedInterfaces_4002);
    }
    if (targetEditPart instanceof org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.edit.parts.AClassEditPart)
    {
      types.add(ClassdiagramElementTypes.AClassAssociations_4003);
    }
    if (targetEditPart instanceof org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.edit.parts.AClassEditPart)
    {
      types.add(ClassdiagramElementTypes.AClassAggregations_4004);
    }
    if (targetEditPart instanceof org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.edit.parts.AClassEditPart)
    {
      types.add(ClassdiagramElementTypes.AClassCompositions_4005);
    }
    return types;
  }

  /**
   * @generated
   */
  public List<IElementType> getMATypesForTarget(IElementType relationshipType)
  {
    LinkedList<IElementType> types = new LinkedList<IElementType>();
    if (relationshipType == ClassdiagramElementTypes.AClassSubClasses_4001)
    {
      types.add(ClassdiagramElementTypes.AClass_2002);
    }
    else if (relationshipType == ClassdiagramElementTypes.AClassImplementedInterfaces_4002)
    {
      types.add(ClassdiagramElementTypes.AInterface_2001);
    }
    else if (relationshipType == ClassdiagramElementTypes.AClassAssociations_4003)
    {
      types.add(ClassdiagramElementTypes.AClass_2002);
    }
    else if (relationshipType == ClassdiagramElementTypes.AClassAggregations_4004)
    {
      types.add(ClassdiagramElementTypes.AClass_2002);
    }
    else if (relationshipType == ClassdiagramElementTypes.AClassCompositions_4005)
    {
      types.add(ClassdiagramElementTypes.AClass_2002);
    }
    return types;
  }

  /**
   * @generated
   */
  public List<IElementType> getMARelTypesOnTarget()
  {
    ArrayList<IElementType> types = new ArrayList<IElementType>(4);
    types.add(ClassdiagramElementTypes.AClassSubClasses_4001);
    types.add(ClassdiagramElementTypes.AClassAssociations_4003);
    types.add(ClassdiagramElementTypes.AClassAggregations_4004);
    types.add(ClassdiagramElementTypes.AClassCompositions_4005);
    return types;
  }

  /**
   * @generated
   */
  public List<IElementType> getMATypesForSource(IElementType relationshipType)
  {
    LinkedList<IElementType> types = new LinkedList<IElementType>();
    if (relationshipType == ClassdiagramElementTypes.AClassSubClasses_4001)
    {
      types.add(ClassdiagramElementTypes.AClass_2002);
    }
    else if (relationshipType == ClassdiagramElementTypes.AClassAssociations_4003)
    {
      types.add(ClassdiagramElementTypes.AClass_2002);
    }
    else if (relationshipType == ClassdiagramElementTypes.AClassAggregations_4004)
    {
      types.add(ClassdiagramElementTypes.AClass_2002);
    }
    else if (relationshipType == ClassdiagramElementTypes.AClassCompositions_4005)
    {
      types.add(ClassdiagramElementTypes.AClass_2002);
    }
    return types;
  }

  /**
   * @generated
   */
  public EditPart getTargetEditPart(Request request)
  {
    if (request instanceof CreateViewAndElementRequest)
    {
      CreateElementRequestAdapter adapter = ((CreateViewAndElementRequest)request).getViewAndElementDescriptor()
          .getCreateElementRequestAdapter();
      IElementType type = (IElementType)adapter.getAdapter(IElementType.class);
      if (type == ClassdiagramElementTypes.AnAttribute_3003)
      {
        return getChildBySemanticHint(ClassdiagramVisualIDRegistry
            .getType(AClassAnAttributeCompartmentEditPart.VISUAL_ID));
      }
      if (type == ClassdiagramElementTypes.AnOperation_3004)
      {
        return getChildBySemanticHint(ClassdiagramVisualIDRegistry
            .getType(AClassAnOperationClassCompartmentEditPart.VISUAL_ID));
      }
    }
    return super.getTargetEditPart(request);
  }

  /**
   * @generated
   */
  public class AClassFigure extends RectangleFigure
  {

    /**
     * @generated
     */
    private RectangleFigure fFigureClassAttributes;

    /**
     * @generated
     */
    private WrappingLabel fFigureAClassNameFigure;

    /**
     * @generated
     */
    private RectangleFigure fFigureClassOperations;

    /**
     * @generated
     */
    public AClassFigure()
    {

      ToolbarLayout layoutThis = new ToolbarLayout();
      layoutThis.setStretchMinorAxis(true);
      layoutThis.setMinorAlignment(ToolbarLayout.ALIGN_CENTER);

      layoutThis.setSpacing(0);
      layoutThis.setVertical(true);

      this.setLayoutManager(layoutThis);

      this.setLineWidth(1);
      this.setBackgroundColor(THIS_BACK);
      createContents();
    }

    /**
     * @generated
     */
    private void createContents()
    {

      fFigureAClassNameFigure = new WrappingLabel();
      fFigureAClassNameFigure.setText("<...>");

      this.add(fFigureAClassNameFigure);

      fFigureClassAttributes = new RectangleFigure();
      fFigureClassAttributes.setLineWidth(1);

      this.add(fFigureClassAttributes);
      fFigureClassAttributes.setLayoutManager(new StackLayout());

      fFigureClassOperations = new RectangleFigure();
      fFigureClassOperations.setLineWidth(1);

      this.add(fFigureClassOperations);
      fFigureClassOperations.setLayoutManager(new StackLayout());

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
    public RectangleFigure getFigureClassAttributes()
    {
      return fFigureClassAttributes;
    }

    /**
     * @generated
     */
    public WrappingLabel getFigureAClassNameFigure()
    {
      return fFigureAClassNameFigure;
    }

    /**
     * @generated
     */
    public RectangleFigure getFigureClassOperations()
    {
      return fFigureClassOperations;
    }

  }

  /**
   * @generated
   */
  static final Color THIS_BACK = new Color(null, 230, 230, 255);

}
