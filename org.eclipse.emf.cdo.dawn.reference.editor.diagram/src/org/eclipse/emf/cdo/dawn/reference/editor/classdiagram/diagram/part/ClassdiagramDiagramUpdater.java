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

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.AClass;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.AInterface;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.AnAttribute;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.AnOperation;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.ClassDiagram;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.ClassdiagramPackage;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.edit.parts.AClassAggregationsEditPart;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.edit.parts.AClassAnAttributeCompartmentEditPart;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.edit.parts.AClassAnOperationClassCompartmentEditPart;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.edit.parts.AClassAssociationsEditPart;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.edit.parts.AClassCompositionsEditPart;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.edit.parts.AClassEditPart;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.edit.parts.AClassImplementedInterfacesEditPart;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.edit.parts.AClassSubClassesEditPart;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.edit.parts.AInterfaceAnAttributeInterfaceCompartmentEditPart;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.edit.parts.AInterfaceAnOperationInterfaceCompartmentEditPart;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.edit.parts.AInterfaceEditPart;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.edit.parts.AnAttribute2EditPart;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.edit.parts.AnAttributeEditPart;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.edit.parts.AnOperation2EditPart;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.edit.parts.AnOperationEditPart;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.edit.parts.ClassDiagramEditPart;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.providers.ClassdiagramElementTypes;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class ClassdiagramDiagramUpdater
{

  /**
   * @generated
   */
  public static List<ClassdiagramNodeDescriptor> getSemanticChildren(View view)
  {
    switch (ClassdiagramVisualIDRegistry.getVisualID(view))
    {
    case ClassDiagramEditPart.VISUAL_ID:
      return getClassDiagram_1000SemanticChildren(view);
    case AInterfaceAnAttributeInterfaceCompartmentEditPart.VISUAL_ID:
      return getAInterfaceAnAttributeInterfaceCompartment_7001SemanticChildren(view);
    case AInterfaceAnOperationInterfaceCompartmentEditPart.VISUAL_ID:
      return getAInterfaceAnOperationInterfaceCompartment_7002SemanticChildren(view);
    case AClassAnAttributeCompartmentEditPart.VISUAL_ID:
      return getAClassAnAttributeCompartment_7003SemanticChildren(view);
    case AClassAnOperationClassCompartmentEditPart.VISUAL_ID:
      return getAClassAnOperationClassCompartment_7004SemanticChildren(view);
    }
    return Collections.emptyList();
  }

  /**
   * @generated
   */
  public static List<ClassdiagramNodeDescriptor> getAInterfaceAnAttributeInterfaceCompartment_7001SemanticChildren(
      View view)
  {
    if (false == view.eContainer() instanceof View)
    {
      return Collections.emptyList();
    }
    View containerView = (View)view.eContainer();
    if (!containerView.isSetElement())
    {
      return Collections.emptyList();
    }
    AInterface modelElement = (AInterface)containerView.getElement();
    LinkedList<ClassdiagramNodeDescriptor> result = new LinkedList<ClassdiagramNodeDescriptor>();
    for (Iterator it = modelElement.getAttributes().iterator(); it.hasNext();)
    {
      AnAttribute childElement = (AnAttribute)it.next();
      int visualID = ClassdiagramVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == AnAttributeEditPart.VISUAL_ID)
      {
        result.add(new ClassdiagramNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List<ClassdiagramNodeDescriptor> getAInterfaceAnOperationInterfaceCompartment_7002SemanticChildren(
      View view)
  {
    if (false == view.eContainer() instanceof View)
    {
      return Collections.emptyList();
    }
    View containerView = (View)view.eContainer();
    if (!containerView.isSetElement())
    {
      return Collections.emptyList();
    }
    AInterface modelElement = (AInterface)containerView.getElement();
    LinkedList<ClassdiagramNodeDescriptor> result = new LinkedList<ClassdiagramNodeDescriptor>();
    for (Iterator it = modelElement.getOperations().iterator(); it.hasNext();)
    {
      AnOperation childElement = (AnOperation)it.next();
      int visualID = ClassdiagramVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == AnOperationEditPart.VISUAL_ID)
      {
        result.add(new ClassdiagramNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List<ClassdiagramNodeDescriptor> getAClassAnAttributeCompartment_7003SemanticChildren(View view)
  {
    if (false == view.eContainer() instanceof View)
    {
      return Collections.emptyList();
    }
    View containerView = (View)view.eContainer();
    if (!containerView.isSetElement())
    {
      return Collections.emptyList();
    }
    AClass modelElement = (AClass)containerView.getElement();
    LinkedList<ClassdiagramNodeDescriptor> result = new LinkedList<ClassdiagramNodeDescriptor>();
    for (Iterator it = modelElement.getAttributes().iterator(); it.hasNext();)
    {
      AnAttribute childElement = (AnAttribute)it.next();
      int visualID = ClassdiagramVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == AnAttribute2EditPart.VISUAL_ID)
      {
        result.add(new ClassdiagramNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List<ClassdiagramNodeDescriptor> getAClassAnOperationClassCompartment_7004SemanticChildren(View view)
  {
    if (false == view.eContainer() instanceof View)
    {
      return Collections.emptyList();
    }
    View containerView = (View)view.eContainer();
    if (!containerView.isSetElement())
    {
      return Collections.emptyList();
    }
    AClass modelElement = (AClass)containerView.getElement();
    LinkedList<ClassdiagramNodeDescriptor> result = new LinkedList<ClassdiagramNodeDescriptor>();
    for (Iterator it = modelElement.getOperations().iterator(); it.hasNext();)
    {
      AnOperation childElement = (AnOperation)it.next();
      int visualID = ClassdiagramVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == AnOperation2EditPart.VISUAL_ID)
      {
        result.add(new ClassdiagramNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List<ClassdiagramNodeDescriptor> getClassDiagram_1000SemanticChildren(View view)
  {
    if (!view.isSetElement())
    {
      return Collections.emptyList();
    }
    ClassDiagram modelElement = (ClassDiagram)view.getElement();
    LinkedList<ClassdiagramNodeDescriptor> result = new LinkedList<ClassdiagramNodeDescriptor>();
    for (Iterator it = modelElement.getInterfaces().iterator(); it.hasNext();)
    {
      AInterface childElement = (AInterface)it.next();
      int visualID = ClassdiagramVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == AInterfaceEditPart.VISUAL_ID)
      {
        result.add(new ClassdiagramNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    for (Iterator it = modelElement.getClasses().iterator(); it.hasNext();)
    {
      AClass childElement = (AClass)it.next();
      int visualID = ClassdiagramVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == AClassEditPart.VISUAL_ID)
      {
        result.add(new ClassdiagramNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List<ClassdiagramLinkDescriptor> getContainedLinks(View view)
  {
    switch (ClassdiagramVisualIDRegistry.getVisualID(view))
    {
    case ClassDiagramEditPart.VISUAL_ID:
      return getClassDiagram_1000ContainedLinks(view);
    case AInterfaceEditPart.VISUAL_ID:
      return getAInterface_2001ContainedLinks(view);
    case AClassEditPart.VISUAL_ID:
      return getAClass_2002ContainedLinks(view);
    case AnAttributeEditPart.VISUAL_ID:
      return getAnAttribute_3001ContainedLinks(view);
    case AnOperationEditPart.VISUAL_ID:
      return getAnOperation_3002ContainedLinks(view);
    case AnAttribute2EditPart.VISUAL_ID:
      return getAnAttribute_3003ContainedLinks(view);
    case AnOperation2EditPart.VISUAL_ID:
      return getAnOperation_3004ContainedLinks(view);
    }
    return Collections.emptyList();
  }

  /**
   * @generated
   */
  public static List<ClassdiagramLinkDescriptor> getIncomingLinks(View view)
  {
    switch (ClassdiagramVisualIDRegistry.getVisualID(view))
    {
    case AInterfaceEditPart.VISUAL_ID:
      return getAInterface_2001IncomingLinks(view);
    case AClassEditPart.VISUAL_ID:
      return getAClass_2002IncomingLinks(view);
    case AnAttributeEditPart.VISUAL_ID:
      return getAnAttribute_3001IncomingLinks(view);
    case AnOperationEditPart.VISUAL_ID:
      return getAnOperation_3002IncomingLinks(view);
    case AnAttribute2EditPart.VISUAL_ID:
      return getAnAttribute_3003IncomingLinks(view);
    case AnOperation2EditPart.VISUAL_ID:
      return getAnOperation_3004IncomingLinks(view);
    }
    return Collections.emptyList();
  }

  /**
   * @generated
   */
  public static List<ClassdiagramLinkDescriptor> getOutgoingLinks(View view)
  {
    switch (ClassdiagramVisualIDRegistry.getVisualID(view))
    {
    case AInterfaceEditPart.VISUAL_ID:
      return getAInterface_2001OutgoingLinks(view);
    case AClassEditPart.VISUAL_ID:
      return getAClass_2002OutgoingLinks(view);
    case AnAttributeEditPart.VISUAL_ID:
      return getAnAttribute_3001OutgoingLinks(view);
    case AnOperationEditPart.VISUAL_ID:
      return getAnOperation_3002OutgoingLinks(view);
    case AnAttribute2EditPart.VISUAL_ID:
      return getAnAttribute_3003OutgoingLinks(view);
    case AnOperation2EditPart.VISUAL_ID:
      return getAnOperation_3004OutgoingLinks(view);
    }
    return Collections.emptyList();
  }

  /**
   * @generated
   */
  public static List<ClassdiagramLinkDescriptor> getClassDiagram_1000ContainedLinks(View view)
  {
    return Collections.emptyList();
  }

  /**
   * @generated
   */
  public static List<ClassdiagramLinkDescriptor> getAInterface_2001ContainedLinks(View view)
  {
    return Collections.emptyList();
  }

  /**
   * @generated
   */
  public static List<ClassdiagramLinkDescriptor> getAClass_2002ContainedLinks(View view)
  {
    AClass modelElement = (AClass)view.getElement();
    LinkedList<ClassdiagramLinkDescriptor> result = new LinkedList<ClassdiagramLinkDescriptor>();
    result.addAll(getOutgoingFeatureModelFacetLinks_AClass_SubClasses_4001(modelElement));
    result.addAll(getOutgoingFeatureModelFacetLinks_AClass_ImplementedInterfaces_4002(modelElement));
    result.addAll(getOutgoingFeatureModelFacetLinks_AClass_Associations_4003(modelElement));
    result.addAll(getOutgoingFeatureModelFacetLinks_AClass_Aggregations_4004(modelElement));
    result.addAll(getOutgoingFeatureModelFacetLinks_AClass_Compositions_4005(modelElement));
    return result;
  }

  /**
   * @generated
   */
  public static List<ClassdiagramLinkDescriptor> getAnAttribute_3001ContainedLinks(View view)
  {
    return Collections.emptyList();
  }

  /**
   * @generated
   */
  public static List<ClassdiagramLinkDescriptor> getAnOperation_3002ContainedLinks(View view)
  {
    return Collections.emptyList();
  }

  /**
   * @generated
   */
  public static List<ClassdiagramLinkDescriptor> getAnAttribute_3003ContainedLinks(View view)
  {
    return Collections.emptyList();
  }

  /**
   * @generated
   */
  public static List<ClassdiagramLinkDescriptor> getAnOperation_3004ContainedLinks(View view)
  {
    return Collections.emptyList();
  }

  /**
   * @generated
   */
  public static List<ClassdiagramLinkDescriptor> getAInterface_2001IncomingLinks(View view)
  {
    AInterface modelElement = (AInterface)view.getElement();
    Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
    LinkedList<ClassdiagramLinkDescriptor> result = new LinkedList<ClassdiagramLinkDescriptor>();
    result.addAll(getIncomingFeatureModelFacetLinks_AClass_ImplementedInterfaces_4002(modelElement, crossReferences));
    return result;
  }

  /**
   * @generated
   */
  public static List<ClassdiagramLinkDescriptor> getAClass_2002IncomingLinks(View view)
  {
    AClass modelElement = (AClass)view.getElement();
    Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
    LinkedList<ClassdiagramLinkDescriptor> result = new LinkedList<ClassdiagramLinkDescriptor>();
    result.addAll(getIncomingFeatureModelFacetLinks_AClass_SubClasses_4001(modelElement, crossReferences));
    result.addAll(getIncomingFeatureModelFacetLinks_AClass_Associations_4003(modelElement, crossReferences));
    result.addAll(getIncomingFeatureModelFacetLinks_AClass_Aggregations_4004(modelElement, crossReferences));
    result.addAll(getIncomingFeatureModelFacetLinks_AClass_Compositions_4005(modelElement, crossReferences));
    return result;
  }

  /**
   * @generated
   */
  public static List<ClassdiagramLinkDescriptor> getAnAttribute_3001IncomingLinks(View view)
  {
    return Collections.emptyList();
  }

  /**
   * @generated
   */
  public static List<ClassdiagramLinkDescriptor> getAnOperation_3002IncomingLinks(View view)
  {
    return Collections.emptyList();
  }

  /**
   * @generated
   */
  public static List<ClassdiagramLinkDescriptor> getAnAttribute_3003IncomingLinks(View view)
  {
    return Collections.emptyList();
  }

  /**
   * @generated
   */
  public static List<ClassdiagramLinkDescriptor> getAnOperation_3004IncomingLinks(View view)
  {
    return Collections.emptyList();
  }

  /**
   * @generated
   */
  public static List<ClassdiagramLinkDescriptor> getAInterface_2001OutgoingLinks(View view)
  {
    return Collections.emptyList();
  }

  /**
   * @generated
   */
  public static List<ClassdiagramLinkDescriptor> getAClass_2002OutgoingLinks(View view)
  {
    AClass modelElement = (AClass)view.getElement();
    LinkedList<ClassdiagramLinkDescriptor> result = new LinkedList<ClassdiagramLinkDescriptor>();
    result.addAll(getOutgoingFeatureModelFacetLinks_AClass_SubClasses_4001(modelElement));
    result.addAll(getOutgoingFeatureModelFacetLinks_AClass_ImplementedInterfaces_4002(modelElement));
    result.addAll(getOutgoingFeatureModelFacetLinks_AClass_Associations_4003(modelElement));
    result.addAll(getOutgoingFeatureModelFacetLinks_AClass_Aggregations_4004(modelElement));
    result.addAll(getOutgoingFeatureModelFacetLinks_AClass_Compositions_4005(modelElement));
    return result;
  }

  /**
   * @generated
   */
  public static List<ClassdiagramLinkDescriptor> getAnAttribute_3001OutgoingLinks(View view)
  {
    return Collections.emptyList();
  }

  /**
   * @generated
   */
  public static List<ClassdiagramLinkDescriptor> getAnOperation_3002OutgoingLinks(View view)
  {
    return Collections.emptyList();
  }

  /**
   * @generated
   */
  public static List<ClassdiagramLinkDescriptor> getAnAttribute_3003OutgoingLinks(View view)
  {
    return Collections.emptyList();
  }

  /**
   * @generated
   */
  public static List<ClassdiagramLinkDescriptor> getAnOperation_3004OutgoingLinks(View view)
  {
    return Collections.emptyList();
  }

  /**
   * @generated
   */
  private static Collection<ClassdiagramLinkDescriptor> getIncomingFeatureModelFacetLinks_AClass_SubClasses_4001(
      AClass target, Map crossReferences)
  {
    LinkedList<ClassdiagramLinkDescriptor> result = new LinkedList<ClassdiagramLinkDescriptor>();
    Collection settings = (Collection)crossReferences.get(target);
    for (Iterator it = settings.iterator(); it.hasNext();)
    {
      EStructuralFeature.Setting setting = (EStructuralFeature.Setting)it.next();
      if (setting.getEStructuralFeature() == ClassdiagramPackage.eINSTANCE.getAClass_SubClasses())
      {
        result.add(new ClassdiagramLinkDescriptor(setting.getEObject(), target,
            ClassdiagramElementTypes.AClassSubClasses_4001, AClassSubClassesEditPart.VISUAL_ID));
      }
    }
    return result;
  }

  /**
   * @generated
   */
  private static Collection<ClassdiagramLinkDescriptor> getIncomingFeatureModelFacetLinks_AClass_ImplementedInterfaces_4002(
      AInterface target, Map crossReferences)
  {
    LinkedList<ClassdiagramLinkDescriptor> result = new LinkedList<ClassdiagramLinkDescriptor>();
    Collection settings = (Collection)crossReferences.get(target);
    for (Iterator it = settings.iterator(); it.hasNext();)
    {
      EStructuralFeature.Setting setting = (EStructuralFeature.Setting)it.next();
      if (setting.getEStructuralFeature() == ClassdiagramPackage.eINSTANCE.getAClass_ImplementedInterfaces())
      {
        result.add(new ClassdiagramLinkDescriptor(setting.getEObject(), target,
            ClassdiagramElementTypes.AClassImplementedInterfaces_4002, AClassImplementedInterfacesEditPart.VISUAL_ID));
      }
    }
    return result;
  }

  /**
   * @generated
   */
  private static Collection<ClassdiagramLinkDescriptor> getIncomingFeatureModelFacetLinks_AClass_Associations_4003(
      AClass target, Map crossReferences)
  {
    LinkedList<ClassdiagramLinkDescriptor> result = new LinkedList<ClassdiagramLinkDescriptor>();
    Collection settings = (Collection)crossReferences.get(target);
    for (Iterator it = settings.iterator(); it.hasNext();)
    {
      EStructuralFeature.Setting setting = (EStructuralFeature.Setting)it.next();
      if (setting.getEStructuralFeature() == ClassdiagramPackage.eINSTANCE.getAClass_Associations())
      {
        result.add(new ClassdiagramLinkDescriptor(setting.getEObject(), target,
            ClassdiagramElementTypes.AClassAssociations_4003, AClassAssociationsEditPart.VISUAL_ID));
      }
    }
    return result;
  }

  /**
   * @generated
   */
  private static Collection<ClassdiagramLinkDescriptor> getIncomingFeatureModelFacetLinks_AClass_Aggregations_4004(
      AClass target, Map crossReferences)
  {
    LinkedList<ClassdiagramLinkDescriptor> result = new LinkedList<ClassdiagramLinkDescriptor>();
    Collection settings = (Collection)crossReferences.get(target);
    for (Iterator it = settings.iterator(); it.hasNext();)
    {
      EStructuralFeature.Setting setting = (EStructuralFeature.Setting)it.next();
      if (setting.getEStructuralFeature() == ClassdiagramPackage.eINSTANCE.getAClass_Aggregations())
      {
        result.add(new ClassdiagramLinkDescriptor(setting.getEObject(), target,
            ClassdiagramElementTypes.AClassAggregations_4004, AClassAggregationsEditPart.VISUAL_ID));
      }
    }
    return result;
  }

  /**
   * @generated
   */
  private static Collection<ClassdiagramLinkDescriptor> getIncomingFeatureModelFacetLinks_AClass_Compositions_4005(
      AClass target, Map crossReferences)
  {
    LinkedList<ClassdiagramLinkDescriptor> result = new LinkedList<ClassdiagramLinkDescriptor>();
    Collection settings = (Collection)crossReferences.get(target);
    for (Iterator it = settings.iterator(); it.hasNext();)
    {
      EStructuralFeature.Setting setting = (EStructuralFeature.Setting)it.next();
      if (setting.getEStructuralFeature() == ClassdiagramPackage.eINSTANCE.getAClass_Compositions())
      {
        result.add(new ClassdiagramLinkDescriptor(setting.getEObject(), target,
            ClassdiagramElementTypes.AClassCompositions_4005, AClassCompositionsEditPart.VISUAL_ID));
      }
    }
    return result;
  }

  /**
   * @generated
   */
  private static Collection<ClassdiagramLinkDescriptor> getOutgoingFeatureModelFacetLinks_AClass_SubClasses_4001(
      AClass source)
  {
    LinkedList<ClassdiagramLinkDescriptor> result = new LinkedList<ClassdiagramLinkDescriptor>();
    for (Iterator destinations = source.getSubClasses().iterator(); destinations.hasNext();)
    {
      AClass destination = (AClass)destinations.next();
      result.add(new ClassdiagramLinkDescriptor(source, destination, ClassdiagramElementTypes.AClassSubClasses_4001,
          AClassSubClassesEditPart.VISUAL_ID));
    }
    return result;
  }

  /**
   * @generated
   */
  private static Collection<ClassdiagramLinkDescriptor> getOutgoingFeatureModelFacetLinks_AClass_ImplementedInterfaces_4002(
      AClass source)
  {
    LinkedList<ClassdiagramLinkDescriptor> result = new LinkedList<ClassdiagramLinkDescriptor>();
    for (Iterator destinations = source.getImplementedInterfaces().iterator(); destinations.hasNext();)
    {
      AInterface destination = (AInterface)destinations.next();
      result.add(new ClassdiagramLinkDescriptor(source, destination,
          ClassdiagramElementTypes.AClassImplementedInterfaces_4002, AClassImplementedInterfacesEditPart.VISUAL_ID));
    }
    return result;
  }

  /**
   * @generated
   */
  private static Collection<ClassdiagramLinkDescriptor> getOutgoingFeatureModelFacetLinks_AClass_Associations_4003(
      AClass source)
  {
    LinkedList<ClassdiagramLinkDescriptor> result = new LinkedList<ClassdiagramLinkDescriptor>();
    for (Iterator destinations = source.getAssociations().iterator(); destinations.hasNext();)
    {
      AClass destination = (AClass)destinations.next();
      result.add(new ClassdiagramLinkDescriptor(source, destination, ClassdiagramElementTypes.AClassAssociations_4003,
          AClassAssociationsEditPart.VISUAL_ID));
    }
    return result;
  }

  /**
   * @generated
   */
  private static Collection<ClassdiagramLinkDescriptor> getOutgoingFeatureModelFacetLinks_AClass_Aggregations_4004(
      AClass source)
  {
    LinkedList<ClassdiagramLinkDescriptor> result = new LinkedList<ClassdiagramLinkDescriptor>();
    for (Iterator destinations = source.getAggregations().iterator(); destinations.hasNext();)
    {
      AClass destination = (AClass)destinations.next();
      result.add(new ClassdiagramLinkDescriptor(source, destination, ClassdiagramElementTypes.AClassAggregations_4004,
          AClassAggregationsEditPart.VISUAL_ID));
    }
    return result;
  }

  /**
   * @generated
   */
  private static Collection<ClassdiagramLinkDescriptor> getOutgoingFeatureModelFacetLinks_AClass_Compositions_4005(
      AClass source)
  {
    LinkedList<ClassdiagramLinkDescriptor> result = new LinkedList<ClassdiagramLinkDescriptor>();
    for (Iterator destinations = source.getCompositions().iterator(); destinations.hasNext();)
    {
      AClass destination = (AClass)destinations.next();
      result.add(new ClassdiagramLinkDescriptor(source, destination, ClassdiagramElementTypes.AClassCompositions_4005,
          AClassCompositionsEditPart.VISUAL_ID));
    }
    return result;
  }

}
