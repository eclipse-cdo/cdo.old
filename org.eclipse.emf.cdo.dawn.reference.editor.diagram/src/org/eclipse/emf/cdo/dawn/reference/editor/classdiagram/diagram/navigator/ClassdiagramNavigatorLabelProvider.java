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
package org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.navigator;

import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.ClassDiagram;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.edit.parts.AClassAggregationsEditPart;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.edit.parts.AClassAssociationsEditPart;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.edit.parts.AClassCompositionsEditPart;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.edit.parts.AClassEditPart;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.edit.parts.AClassImplementedInterfacesEditPart;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.edit.parts.AClassNameEditPart;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.edit.parts.AClassSubClassesEditPart;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.edit.parts.AInterfaceEditPart;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.edit.parts.AInterfaceNameEditPart;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.edit.parts.AnAttribute2EditPart;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.edit.parts.AnAttributeEditPart;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.edit.parts.AnOperation2EditPart;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.edit.parts.AnOperationEditPart;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.edit.parts.ClassDiagramEditPart;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.part.ClassdiagramDiagramEditorPlugin;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.part.ClassdiagramVisualIDRegistry;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.providers.ClassdiagramElementTypes;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.providers.ClassdiagramParserProvider;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.ITreePathLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.ViewerLabel;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonLabelProvider;

/**
 * @generated
 */
public class ClassdiagramNavigatorLabelProvider extends LabelProvider implements ICommonLabelProvider,
    ITreePathLabelProvider
{

  /**
   * @generated
   */
  static
  {
    ClassdiagramDiagramEditorPlugin.getInstance().getImageRegistry().put(
        "Navigator?UnknownElement", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
    ClassdiagramDiagramEditorPlugin.getInstance().getImageRegistry().put(
        "Navigator?ImageNotFound", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
  }

  /**
   * @generated
   */
  public void updateLabel(ViewerLabel label, TreePath elementPath)
  {
    Object element = elementPath.getLastSegment();
    if (element instanceof ClassdiagramNavigatorItem && !isOwnView(((ClassdiagramNavigatorItem)element).getView()))
    {
      return;
    }
    label.setText(getText(element));
    label.setImage(getImage(element));
  }

  /**
   * @generated
   */
  public Image getImage(Object element)
  {
    if (element instanceof ClassdiagramNavigatorGroup)
    {
      ClassdiagramNavigatorGroup group = (ClassdiagramNavigatorGroup)element;
      return ClassdiagramDiagramEditorPlugin.getInstance().getBundledImage(group.getIcon());
    }

    if (element instanceof ClassdiagramNavigatorItem)
    {
      ClassdiagramNavigatorItem navigatorItem = (ClassdiagramNavigatorItem)element;
      if (!isOwnView(navigatorItem.getView()))
      {
        return super.getImage(element);
      }
      return getImage(navigatorItem.getView());
    }

    return super.getImage(element);
  }

  /**
   * @generated
   */
  public Image getImage(View view)
  {
    switch (ClassdiagramVisualIDRegistry.getVisualID(view))
    {
    case AClassAggregationsEditPart.VISUAL_ID:
      return getImage(
          "Navigator?Link?http://class.uml.diagram.mftech.org?AClass?aggregations", ClassdiagramElementTypes.AClassAggregations_4004); //$NON-NLS-1$
    case ClassDiagramEditPart.VISUAL_ID:
      return getImage(
          "Navigator?Diagram?http://class.uml.diagram.mftech.org?ClassDiagram", ClassdiagramElementTypes.ClassDiagram_1000); //$NON-NLS-1$
    case AnOperationEditPart.VISUAL_ID:
      return getImage(
          "Navigator?Node?http://class.uml.diagram.mftech.org?AnOperation", ClassdiagramElementTypes.AnOperation_3002); //$NON-NLS-1$
    case AClassSubClassesEditPart.VISUAL_ID:
      return getImage(
          "Navigator?Link?http://class.uml.diagram.mftech.org?AClass?subClasses", ClassdiagramElementTypes.AClassSubClasses_4001); //$NON-NLS-1$
    case AnAttributeEditPart.VISUAL_ID:
      return getImage(
          "Navigator?Node?http://class.uml.diagram.mftech.org?AnAttribute", ClassdiagramElementTypes.AnAttribute_3001); //$NON-NLS-1$
    case AClassCompositionsEditPart.VISUAL_ID:
      return getImage(
          "Navigator?Link?http://class.uml.diagram.mftech.org?AClass?compositions", ClassdiagramElementTypes.AClassCompositions_4005); //$NON-NLS-1$
    case AClassAssociationsEditPart.VISUAL_ID:
      return getImage(
          "Navigator?Link?http://class.uml.diagram.mftech.org?AClass?associations", ClassdiagramElementTypes.AClassAssociations_4003); //$NON-NLS-1$
    case AnOperation2EditPart.VISUAL_ID:
      return getImage(
          "Navigator?Node?http://class.uml.diagram.mftech.org?AnOperation", ClassdiagramElementTypes.AnOperation_3004); //$NON-NLS-1$
    case AnAttribute2EditPart.VISUAL_ID:
      return getImage(
          "Navigator?Node?http://class.uml.diagram.mftech.org?AnAttribute", ClassdiagramElementTypes.AnAttribute_3003); //$NON-NLS-1$
    case AClassImplementedInterfacesEditPart.VISUAL_ID:
      return getImage(
          "Navigator?Link?http://class.uml.diagram.mftech.org?AClass?implementedInterfaces", ClassdiagramElementTypes.AClassImplementedInterfaces_4002); //$NON-NLS-1$
    case AClassEditPart.VISUAL_ID:
      return getImage(
          "Navigator?TopLevelNode?http://class.uml.diagram.mftech.org?AClass", ClassdiagramElementTypes.AClass_2002); //$NON-NLS-1$
    case AInterfaceEditPart.VISUAL_ID:
      return getImage(
          "Navigator?TopLevelNode?http://class.uml.diagram.mftech.org?AInterface", ClassdiagramElementTypes.AInterface_2001); //$NON-NLS-1$
    }
    return getImage("Navigator?UnknownElement", null); //$NON-NLS-1$
  }

  /**
   * @generated
   */
  private Image getImage(String key, IElementType elementType)
  {
    ImageRegistry imageRegistry = ClassdiagramDiagramEditorPlugin.getInstance().getImageRegistry();
    Image image = imageRegistry.get(key);
    if (image == null && elementType != null && ClassdiagramElementTypes.isKnownElementType(elementType))
    {
      image = ClassdiagramElementTypes.getImage(elementType);
      imageRegistry.put(key, image);
    }

    if (image == null)
    {
      image = imageRegistry.get("Navigator?ImageNotFound"); //$NON-NLS-1$
      imageRegistry.put(key, image);
    }
    return image;
  }

  /**
   * @generated
   */
  public String getText(Object element)
  {
    if (element instanceof ClassdiagramNavigatorGroup)
    {
      ClassdiagramNavigatorGroup group = (ClassdiagramNavigatorGroup)element;
      return group.getGroupName();
    }

    if (element instanceof ClassdiagramNavigatorItem)
    {
      ClassdiagramNavigatorItem navigatorItem = (ClassdiagramNavigatorItem)element;
      if (!isOwnView(navigatorItem.getView()))
      {
        return null;
      }
      return getText(navigatorItem.getView());
    }

    return super.getText(element);
  }

  /**
   * @generated
   */
  public String getText(View view)
  {
    if (view.getElement() != null && view.getElement().eIsProxy())
    {
      return getUnresolvedDomainElementProxyText(view);
    }
    switch (ClassdiagramVisualIDRegistry.getVisualID(view))
    {
    case AClassAggregationsEditPart.VISUAL_ID:
      return getAClassAggregations_4004Text(view);
    case ClassDiagramEditPart.VISUAL_ID:
      return getClassDiagram_1000Text(view);
    case AnOperationEditPart.VISUAL_ID:
      return getAnOperation_3002Text(view);
    case AClassSubClassesEditPart.VISUAL_ID:
      return getAClassSubClasses_4001Text(view);
    case AnAttributeEditPart.VISUAL_ID:
      return getAnAttribute_3001Text(view);
    case AClassCompositionsEditPart.VISUAL_ID:
      return getAClassCompositions_4005Text(view);
    case AClassAssociationsEditPart.VISUAL_ID:
      return getAClassAssociations_4003Text(view);
    case AnOperation2EditPart.VISUAL_ID:
      return getAnOperation_3004Text(view);
    case AnAttribute2EditPart.VISUAL_ID:
      return getAnAttribute_3003Text(view);
    case AClassImplementedInterfacesEditPart.VISUAL_ID:
      return getAClassImplementedInterfaces_4002Text(view);
    case AClassEditPart.VISUAL_ID:
      return getAClass_2002Text(view);
    case AInterfaceEditPart.VISUAL_ID:
      return getAInterface_2001Text(view);
    }
    return getUnknownElementText(view);
  }

  /**
   * @generated
   */
  private String getClassDiagram_1000Text(View view)
  {
    ClassDiagram domainModelElement = (ClassDiagram)view.getElement();
    if (domainModelElement != null)
    {
      return domainModelElement.getTitle();
    }
    else
    {
      ClassdiagramDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 1000); //$NON-NLS-1$
      return ""; //$NON-NLS-1$
    }
  }

  /**
   * @generated
   */
  private String getAInterface_2001Text(View view)
  {
    IParser parser = ClassdiagramParserProvider.getParser(ClassdiagramElementTypes.AInterface_2001,
        view.getElement() != null ? view.getElement() : view, ClassdiagramVisualIDRegistry
            .getType(AInterfaceNameEditPart.VISUAL_ID));
    if (parser != null)
    {
      return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
          ParserOptions.NONE.intValue());
    }
    else
    {
      ClassdiagramDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5001); //$NON-NLS-1$
      return ""; //$NON-NLS-1$
    }
  }

  /**
   * @generated
   */
  private String getAClass_2002Text(View view)
  {
    IParser parser = ClassdiagramParserProvider.getParser(ClassdiagramElementTypes.AClass_2002,
        view.getElement() != null ? view.getElement() : view, ClassdiagramVisualIDRegistry
            .getType(AClassNameEditPart.VISUAL_ID));
    if (parser != null)
    {
      return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
          ParserOptions.NONE.intValue());
    }
    else
    {
      ClassdiagramDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5002); //$NON-NLS-1$
      return ""; //$NON-NLS-1$
    }
  }

  /**
   * @generated
   */
  private String getAnAttribute_3001Text(View view)
  {
    IParser parser = ClassdiagramParserProvider.getParser(ClassdiagramElementTypes.AnAttribute_3001,
        view.getElement() != null ? view.getElement() : view, ClassdiagramVisualIDRegistry
            .getType(AnAttributeEditPart.VISUAL_ID));
    if (parser != null)
    {
      return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
          ParserOptions.NONE.intValue());
    }
    else
    {
      ClassdiagramDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 3001); //$NON-NLS-1$
      return ""; //$NON-NLS-1$
    }
  }

  /**
   * @generated
   */
  private String getAnOperation_3002Text(View view)
  {
    IParser parser = ClassdiagramParserProvider.getParser(ClassdiagramElementTypes.AnOperation_3002,
        view.getElement() != null ? view.getElement() : view, ClassdiagramVisualIDRegistry
            .getType(AnOperationEditPart.VISUAL_ID));
    if (parser != null)
    {
      return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
          ParserOptions.NONE.intValue());
    }
    else
    {
      ClassdiagramDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 3002); //$NON-NLS-1$
      return ""; //$NON-NLS-1$
    }
  }

  /**
   * @generated
   */
  private String getAnAttribute_3003Text(View view)
  {
    IParser parser = ClassdiagramParserProvider.getParser(ClassdiagramElementTypes.AnAttribute_3003,
        view.getElement() != null ? view.getElement() : view, ClassdiagramVisualIDRegistry
            .getType(AnAttribute2EditPart.VISUAL_ID));
    if (parser != null)
    {
      return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
          ParserOptions.NONE.intValue());
    }
    else
    {
      ClassdiagramDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 3003); //$NON-NLS-1$
      return ""; //$NON-NLS-1$
    }
  }

  /**
   * @generated
   */
  private String getAnOperation_3004Text(View view)
  {
    IParser parser = ClassdiagramParserProvider.getParser(ClassdiagramElementTypes.AnOperation_3004,
        view.getElement() != null ? view.getElement() : view, ClassdiagramVisualIDRegistry
            .getType(AnOperation2EditPart.VISUAL_ID));
    if (parser != null)
    {
      return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
          ParserOptions.NONE.intValue());
    }
    else
    {
      ClassdiagramDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 3004); //$NON-NLS-1$
      return ""; //$NON-NLS-1$
    }
  }

  /**
   * @generated
   */
  private String getAClassSubClasses_4001Text(View view)
  {
    return ""; //$NON-NLS-1$
  }

  /**
   * @generated
   */
  private String getAClassImplementedInterfaces_4002Text(View view)
  {
    return ""; //$NON-NLS-1$
  }

  /**
   * @generated
   */
  private String getAClassAssociations_4003Text(View view)
  {
    return ""; //$NON-NLS-1$
  }

  /**
   * @generated
   */
  private String getAClassAggregations_4004Text(View view)
  {
    return ""; //$NON-NLS-1$
  }

  /**
   * @generated
   */
  private String getAClassCompositions_4005Text(View view)
  {
    return ""; //$NON-NLS-1$
  }

  /**
   * @generated
   */
  private String getUnknownElementText(View view)
  {
    return "<UnknownElement Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$  //$NON-NLS-2$
  }

  /**
   * @generated
   */
  private String getUnresolvedDomainElementProxyText(View view)
  {
    return "<Unresolved domain element Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$  //$NON-NLS-2$
  }

  /**
   * @generated
   */
  public void init(ICommonContentExtensionSite aConfig)
  {
  }

  /**
   * @generated
   */
  public void restoreState(IMemento aMemento)
  {
  }

  /**
   * @generated
   */
  public void saveState(IMemento aMemento)
  {
  }

  /**
   * @generated
   */
  public String getDescription(Object anElement)
  {
    return null;
  }

  /**
   * @generated
   */
  private boolean isOwnView(View view)
  {
    return ClassDiagramEditPart.MODEL_ID.equals(ClassdiagramVisualIDRegistry.getModelID(view));
  }

}
