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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.providers.ClassdiagramElementTypes;
import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeConnectionTool;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeCreationTool;

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
    List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
    types.add(ClassdiagramElementTypes.AClass_2002);
    NodeToolEntry entry = new NodeToolEntry(Messages.Class1CreationTool_title, Messages.Class1CreationTool_desc, types);
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
    List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
    types.add(ClassdiagramElementTypes.AInterface_2001);
    NodeToolEntry entry = new NodeToolEntry(Messages.Interface2CreationTool_title,
        Messages.Interface2CreationTool_desc, types);
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
    List/* <IElementType> */types = new ArrayList/* <IElementType> */(2);
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
    List/* <IElementType> */types = new ArrayList/* <IElementType> */(2);
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
    List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
    types.add(ClassdiagramElementTypes.AClassSubClasses_4001);
    LinkToolEntry entry = new LinkToolEntry(Messages.Inherits1CreationTool_title, Messages.Inherits1CreationTool_desc,
        types);
    entry.setId("createInherits1CreationTool"); //$NON-NLS-1$
    entry.setSmallIcon(ClassdiagramElementTypes.getImageDescriptor(ClassdiagramElementTypes.AClassSubClasses_4001));
    entry.setLargeIcon(entry.getSmallIcon());
    return entry;
  }

  /**
   * @generated
   */
  private ToolEntry createImplements2CreationTool()
  {
    List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
    types.add(ClassdiagramElementTypes.AClassImplementedInterfaces_4002);
    LinkToolEntry entry = new LinkToolEntry(Messages.Implements2CreationTool_title,
        Messages.Implements2CreationTool_desc, types);
    entry.setId("createImplements2CreationTool"); //$NON-NLS-1$
    entry.setSmallIcon(ClassdiagramDiagramEditorPlugin
        .findImageDescriptor("/org.mftech.diagram.uml.class.edit/icons/full/obj16/Relationship.gif")); //$NON-NLS-1$
    entry.setLargeIcon(ClassdiagramDiagramEditorPlugin
        .findImageDescriptor("/org.mftech.diagram.uml.class.edit/icons/full/obj16/Relationship.gif")); //$NON-NLS-1$
    return entry;
  }

  /**
   * @generated
   */
  private ToolEntry createAssociation3CreationTool()
  {
    List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
    types.add(ClassdiagramElementTypes.AClassAssociations_4003);
    LinkToolEntry entry = new LinkToolEntry(Messages.Association3CreationTool_title,
        Messages.Association3CreationTool_desc, types);
    entry.setId("createAssociation3CreationTool"); //$NON-NLS-1$
    entry.setSmallIcon(ClassdiagramElementTypes.getImageDescriptor(ClassdiagramElementTypes.AClassAssociations_4003));
    entry.setLargeIcon(entry.getSmallIcon());
    return entry;
  }

  /**
   * @generated
   */
  private ToolEntry createAggregation4CreationTool()
  {
    List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
    types.add(ClassdiagramElementTypes.AClassAggregations_4004);
    LinkToolEntry entry = new LinkToolEntry(Messages.Aggregation4CreationTool_title,
        Messages.Aggregation4CreationTool_desc, types);
    entry.setId("createAggregation4CreationTool"); //$NON-NLS-1$
    entry.setSmallIcon(ClassdiagramElementTypes.getImageDescriptor(ClassdiagramElementTypes.AClassAggregations_4004));
    entry.setLargeIcon(entry.getSmallIcon());
    return entry;
  }

  /**
   * @generated
   */
  private ToolEntry createComposition5CreationTool()
  {
    List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
    types.add(ClassdiagramElementTypes.AClassCompositions_4005);
    LinkToolEntry entry = new LinkToolEntry(Messages.Composition5CreationTool_title,
        Messages.Composition5CreationTool_desc, types);
    entry.setId("createComposition5CreationTool"); //$NON-NLS-1$
    entry.setSmallIcon(ClassdiagramElementTypes.getImageDescriptor(ClassdiagramElementTypes.AClassCompositions_4005));
    entry.setLargeIcon(entry.getSmallIcon());
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
    private final List elementTypes;

    /**
     * @generated
     */
    private NodeToolEntry(String title, String description, List elementTypes)
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
    private final List relationshipTypes;

    /**
     * @generated
     */
    private LinkToolEntry(String title, String description, List relationshipTypes)
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
