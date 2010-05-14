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
package org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.part;

import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.providers.ClassdiagramElementTypes;

import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeConnectionTool;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeCreationTool;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @generated
 */
public class ClassdiagramPaletteFactory
{

  /**
   * @generated
   */
  public void fillPalette(PaletteRoot paletteRoot)
  {
    paletteRoot.add(createNode1Group());
    paletteRoot.add(createConnections2Group());
  }

  /**
   * Creates "Node" palette tool group
   * 
   * @generated
   */
  private PaletteContainer createNode1Group()
  {
    PaletteDrawer paletteContainer = new PaletteDrawer(Messages.Node1Group_title);
    paletteContainer.setId("createNode1Group"); //$NON-NLS-1$
    paletteContainer.add(createClass1CreationTool());
    paletteContainer.add(createInterface2CreationTool());
    paletteContainer.add(createAnAttribute3CreationTool());
    paletteContainer.add(createAnOperation4CreationTool());
    return paletteContainer;
  }

  /**
   * Creates "Connections" palette tool group
   * 
   * @generated
   */
  private PaletteContainer createConnections2Group()
  {
    PaletteDrawer paletteContainer = new PaletteDrawer(Messages.Connections2Group_title);
    paletteContainer.setId("createConnections2Group"); //$NON-NLS-1$
    paletteContainer.add(createInherits1CreationTool());
    paletteContainer.add(createImplements2CreationTool());
    paletteContainer.add(createAssociation3CreationTool());
    paletteContainer.add(createAggregation4CreationTool());
    paletteContainer.add(createComposition5CreationTool());
    return paletteContainer;
  }

  /**
   * @generated
   */
  private ToolEntry createClass1CreationTool()
  {
    NodeToolEntry entry = new NodeToolEntry(Messages.Class1CreationTool_title, Messages.Class1CreationTool_desc,
        Collections.singletonList(ClassdiagramElementTypes.AClass_2002));
    entry.setId("createClass1CreationTool"); //$NON-NLS-1$
    entry.setSmallIcon(ClassdiagramElementTypes.getImageDescriptor(ClassdiagramElementTypes.AClass_2002));
    entry.setLargeIcon(entry.getSmallIcon());
    return entry;
  }

  /**
   * @generated
   */
  private ToolEntry createInterface2CreationTool()
  {
    NodeToolEntry entry = new NodeToolEntry(Messages.Interface2CreationTool_title,
        Messages.Interface2CreationTool_desc, Collections.singletonList(ClassdiagramElementTypes.AInterface_2001));
    entry.setId("createInterface2CreationTool"); //$NON-NLS-1$
    entry.setSmallIcon(ClassdiagramElementTypes.getImageDescriptor(ClassdiagramElementTypes.AInterface_2001));
    entry.setLargeIcon(entry.getSmallIcon());
    return entry;
  }

  /**
   * @generated
   */
  private ToolEntry createAnAttribute3CreationTool()
  {
    ArrayList<IElementType> types = new ArrayList<IElementType>(2);
    types.add(ClassdiagramElementTypes.AnAttribute_3001);
    types.add(ClassdiagramElementTypes.AnAttribute_3003);
    NodeToolEntry entry = new NodeToolEntry(Messages.AnAttribute3CreationTool_title,
        Messages.AnAttribute3CreationTool_desc, types);
    entry.setId("createAnAttribute3CreationTool"); //$NON-NLS-1$
    entry.setSmallIcon(ClassdiagramElementTypes.getImageDescriptor(ClassdiagramElementTypes.AnAttribute_3001));
    entry.setLargeIcon(entry.getSmallIcon());
    return entry;
  }

  /**
   * @generated
   */
  private ToolEntry createAnOperation4CreationTool()
  {
    ArrayList<IElementType> types = new ArrayList<IElementType>(2);
    types.add(ClassdiagramElementTypes.AnOperation_3002);
    types.add(ClassdiagramElementTypes.AnOperation_3004);
    NodeToolEntry entry = new NodeToolEntry(Messages.AnOperation4CreationTool_title,
        Messages.AnOperation4CreationTool_desc, types);
    entry.setId("createAnOperation4CreationTool"); //$NON-NLS-1$
    entry.setSmallIcon(ClassdiagramElementTypes.getImageDescriptor(ClassdiagramElementTypes.AnOperation_3002));
    entry.setLargeIcon(entry.getSmallIcon());
    return entry;
  }

  /**
   * @generated
   */
  private ToolEntry createInherits1CreationTool()
  {
    LinkToolEntry entry = new LinkToolEntry(Messages.Inherits1CreationTool_title, Messages.Inherits1CreationTool_desc,
        Collections.singletonList(ClassdiagramElementTypes.AClassSubClasses_4001));
    entry.setId("createInherits1CreationTool"); //$NON-NLS-1$
    entry.setSmallIcon(ClassdiagramDiagramEditorPlugin
        .findImageDescriptor("/org.eclipse.emf.cdo.dawn.reference.editor.edit/icons/full/obj16/inherits.png")); //$NON-NLS-1$
    entry.setLargeIcon(ClassdiagramDiagramEditorPlugin
        .findImageDescriptor("/org.eclipse.emf.cdo.dawn.reference.editor.edit/icons/full/obj16/inherits.png")); //$NON-NLS-1$
    return entry;
  }

  /**
   * @generated
   */
  private ToolEntry createImplements2CreationTool()
  {
    LinkToolEntry entry = new LinkToolEntry(Messages.Implements2CreationTool_title,
        Messages.Implements2CreationTool_desc, Collections
            .singletonList(ClassdiagramElementTypes.AClassImplementedInterfaces_4002));
    entry.setId("createImplements2CreationTool"); //$NON-NLS-1$
    entry.setSmallIcon(ClassdiagramDiagramEditorPlugin
        .findImageDescriptor("/org.eclipse.emf.cdo.dawn.reference.editor.edit/icons/full/obj16/implements.png")); //$NON-NLS-1$
    entry.setLargeIcon(ClassdiagramDiagramEditorPlugin
        .findImageDescriptor("/org.eclipse.emf.cdo.dawn.reference.editor.edit/icons/full/obj16/implements.png")); //$NON-NLS-1$
    return entry;
  }

  /**
   * @generated
   */
  private ToolEntry createAssociation3CreationTool()
  {
    LinkToolEntry entry = new LinkToolEntry(Messages.Association3CreationTool_title,
        Messages.Association3CreationTool_desc, Collections
            .singletonList(ClassdiagramElementTypes.AClassAssociations_4003));
    entry.setId("createAssociation3CreationTool"); //$NON-NLS-1$
    entry.setSmallIcon(ClassdiagramDiagramEditorPlugin
        .findImageDescriptor("/org.eclipse.emf.cdo.dawn.reference.editor.edit/icons/full/obj16/association.png")); //$NON-NLS-1$
    entry.setLargeIcon(ClassdiagramDiagramEditorPlugin
        .findImageDescriptor("/org.eclipse.emf.cdo.dawn.reference.editor.edit/icons/full/obj16/association.png")); //$NON-NLS-1$
    return entry;
  }

  /**
   * @generated
   */
  private ToolEntry createAggregation4CreationTool()
  {
    LinkToolEntry entry = new LinkToolEntry(Messages.Aggregation4CreationTool_title,
        Messages.Aggregation4CreationTool_desc, Collections
            .singletonList(ClassdiagramElementTypes.AClassAggregations_4004));
    entry.setId("createAggregation4CreationTool"); //$NON-NLS-1$
    entry.setSmallIcon(ClassdiagramDiagramEditorPlugin
        .findImageDescriptor("/org.eclipse.emf.cdo.dawn.reference.editor.edit/icons/full/obj16/aggregation.png")); //$NON-NLS-1$
    entry.setLargeIcon(ClassdiagramDiagramEditorPlugin
        .findImageDescriptor("/org.eclipse.emf.cdo.dawn.reference.editor.edit/icons/full/obj16/aggregation.png")); //$NON-NLS-1$
    return entry;
  }

  /**
   * @generated
   */
  private ToolEntry createComposition5CreationTool()
  {
    LinkToolEntry entry = new LinkToolEntry(Messages.Composition5CreationTool_title,
        Messages.Composition5CreationTool_desc, Collections
            .singletonList(ClassdiagramElementTypes.AClassCompositions_4005));
    entry.setId("createComposition5CreationTool"); //$NON-NLS-1$
    entry.setSmallIcon(ClassdiagramDiagramEditorPlugin
        .findImageDescriptor("/org.eclipse.emf.cdo.dawn.reference.editor.edit/icons/full/obj16/composition.png")); //$NON-NLS-1$
    entry.setLargeIcon(ClassdiagramDiagramEditorPlugin
        .findImageDescriptor("/org.eclipse.emf.cdo.dawn.reference.editor.edit/icons/full/obj16/composition.png")); //$NON-NLS-1$
    return entry;
  }

  /**
   * @generated
   */
  private static class NodeToolEntry extends ToolEntry
  {

    /**
     * @generated
     */
    private final List<IElementType> elementTypes;

    /**
     * @generated
     */
    private NodeToolEntry(String title, String description, List<IElementType> elementTypes)
    {
      super(title, description, null, null);
      this.elementTypes = elementTypes;
    }

    /**
     * @generated
     */
    public Tool createTool()
    {
      Tool tool = new UnspecifiedTypeCreationTool(elementTypes);
      tool.setProperties(getToolProperties());
      return tool;
    }
  }

  /**
   * @generated
   */
  private static class LinkToolEntry extends ToolEntry
  {

    /**
     * @generated
     */
    private final List<IElementType> relationshipTypes;

    /**
     * @generated
     */
    private LinkToolEntry(String title, String description, List<IElementType> relationshipTypes)
    {
      super(title, description, null, null);
      this.relationshipTypes = relationshipTypes;
    }

    /**
     * @generated
     */
    public Tool createTool()
    {
      Tool tool = new UnspecifiedTypeConnectionTool(relationshipTypes);
      tool.setProperties(getToolProperties());
      return tool;
    }
  }
}
