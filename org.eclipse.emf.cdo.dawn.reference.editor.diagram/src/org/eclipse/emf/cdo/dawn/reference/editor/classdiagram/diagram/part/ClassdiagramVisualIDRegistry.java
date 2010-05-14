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

import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.ClassDiagram;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.ClassdiagramPackage;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.edit.parts.AClassAnAttributeCompartmentEditPart;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.edit.parts.AClassAnOperationClassCompartmentEditPart;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.edit.parts.AClassEditPart;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.edit.parts.AClassNameEditPart;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.edit.parts.AInterfaceAnAttributeInterfaceCompartmentEditPart;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.edit.parts.AInterfaceAnOperationInterfaceCompartmentEditPart;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.edit.parts.AInterfaceEditPart;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.edit.parts.AInterfaceNameEditPart;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.edit.parts.AnAttribute2EditPart;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.edit.parts.AnAttributeEditPart;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.edit.parts.AnOperation2EditPart;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.edit.parts.AnOperationEditPart;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.edit.parts.ClassDiagramEditPart;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.core.runtime.Platform;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;

/**
 * This registry is used to determine which type of visual object should be created for the corresponding Diagram, Node,
 * ChildNode or Link represented by a domain model object.
 * 
 * @generated
 */
public class ClassdiagramVisualIDRegistry
{

  /**
   * @generated
   */
  private static final String DEBUG_KEY = "org.eclipse.emf.cdo.dawn.reference.editor.diagram/debug/visualID"; //$NON-NLS-1$

  /**
   * @generated
   */
  public static int getVisualID(View view)
  {
    if (view instanceof Diagram)
    {
      if (ClassDiagramEditPart.MODEL_ID.equals(view.getType()))
      {
        return ClassDiagramEditPart.VISUAL_ID;
      }
      else
      {
        return -1;
      }
    }
    return org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.part.ClassdiagramVisualIDRegistry
        .getVisualID(view.getType());
  }

  /**
   * @generated
   */
  public static String getModelID(View view)
  {
    View diagram = view.getDiagram();
    while (view != diagram)
    {
      EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
      if (annotation != null)
      {
        return (String)annotation.getDetails().get("modelID"); //$NON-NLS-1$
      }
      view = (View)view.eContainer();
    }
    return diagram != null ? diagram.getType() : null;
  }

  /**
   * @generated
   */
  public static int getVisualID(String type)
  {
    try
    {
      return Integer.parseInt(type);
    }
    catch (NumberFormatException e)
    {
      if (Boolean.TRUE.toString().equalsIgnoreCase(Platform.getDebugOption(DEBUG_KEY)))
      {
        ClassdiagramDiagramEditorPlugin.getInstance().logError(
            "Unable to parse view type as a visualID number: " + type);
      }
    }
    return -1;
  }

  /**
   * @generated
   */
  public static String getType(int visualID)
  {
    return String.valueOf(visualID);
  }

  /**
   * @generated
   */
  public static int getDiagramVisualID(EObject domainElement)
  {
    if (domainElement == null)
    {
      return -1;
    }
    if (ClassdiagramPackage.eINSTANCE.getClassDiagram().isSuperTypeOf(domainElement.eClass())
        && isDiagram((ClassDiagram)domainElement))
    {
      return ClassDiagramEditPart.VISUAL_ID;
    }
    return -1;
  }

  /**
   * @generated
   */
  public static int getNodeVisualID(View containerView, EObject domainElement)
  {
    if (domainElement == null)
    {
      return -1;
    }
    String containerModelID = org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.part.ClassdiagramVisualIDRegistry
        .getModelID(containerView);
    if (!ClassDiagramEditPart.MODEL_ID.equals(containerModelID))
    {
      return -1;
    }
    int containerVisualID;
    if (ClassDiagramEditPart.MODEL_ID.equals(containerModelID))
    {
      containerVisualID = org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.part.ClassdiagramVisualIDRegistry
          .getVisualID(containerView);
    }
    else
    {
      if (containerView instanceof Diagram)
      {
        containerVisualID = ClassDiagramEditPart.VISUAL_ID;
      }
      else
      {
        return -1;
      }
    }
    switch (containerVisualID)
    {
    case ClassDiagramEditPart.VISUAL_ID:
      if (ClassdiagramPackage.eINSTANCE.getAInterface().isSuperTypeOf(domainElement.eClass()))
      {
        return AInterfaceEditPart.VISUAL_ID;
      }
      if (ClassdiagramPackage.eINSTANCE.getAClass().isSuperTypeOf(domainElement.eClass()))
      {
        return AClassEditPart.VISUAL_ID;
      }
      break;
    case AInterfaceAnAttributeInterfaceCompartmentEditPart.VISUAL_ID:
      if (ClassdiagramPackage.eINSTANCE.getAnAttribute().isSuperTypeOf(domainElement.eClass()))
      {
        return AnAttributeEditPart.VISUAL_ID;
      }
      break;
    case AInterfaceAnOperationInterfaceCompartmentEditPart.VISUAL_ID:
      if (ClassdiagramPackage.eINSTANCE.getAnOperation().isSuperTypeOf(domainElement.eClass()))
      {
        return AnOperationEditPart.VISUAL_ID;
      }
      break;
    case AClassAnAttributeCompartmentEditPart.VISUAL_ID:
      if (ClassdiagramPackage.eINSTANCE.getAnAttribute().isSuperTypeOf(domainElement.eClass()))
      {
        return AnAttribute2EditPart.VISUAL_ID;
      }
      break;
    case AClassAnOperationClassCompartmentEditPart.VISUAL_ID:
      if (ClassdiagramPackage.eINSTANCE.getAnOperation().isSuperTypeOf(domainElement.eClass()))
      {
        return AnOperation2EditPart.VISUAL_ID;
      }
      break;
    }
    return -1;
  }

  /**
   * @generated
   */
  public static boolean canCreateNode(View containerView, int nodeVisualID)
  {
    String containerModelID = org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.part.ClassdiagramVisualIDRegistry
        .getModelID(containerView);
    if (!ClassDiagramEditPart.MODEL_ID.equals(containerModelID))
    {
      return false;
    }
    int containerVisualID;
    if (ClassDiagramEditPart.MODEL_ID.equals(containerModelID))
    {
      containerVisualID = org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.part.ClassdiagramVisualIDRegistry
          .getVisualID(containerView);
    }
    else
    {
      if (containerView instanceof Diagram)
      {
        containerVisualID = ClassDiagramEditPart.VISUAL_ID;
      }
      else
      {
        return false;
      }
    }
    switch (containerVisualID)
    {
    case ClassDiagramEditPart.VISUAL_ID:
      if (AInterfaceEditPart.VISUAL_ID == nodeVisualID)
      {
        return true;
      }
      if (AClassEditPart.VISUAL_ID == nodeVisualID)
      {
        return true;
      }
      break;
    case AInterfaceEditPart.VISUAL_ID:
      if (AInterfaceNameEditPart.VISUAL_ID == nodeVisualID)
      {
        return true;
      }
      if (AInterfaceAnAttributeInterfaceCompartmentEditPart.VISUAL_ID == nodeVisualID)
      {
        return true;
      }
      if (AInterfaceAnOperationInterfaceCompartmentEditPart.VISUAL_ID == nodeVisualID)
      {
        return true;
      }
      break;
    case AClassEditPart.VISUAL_ID:
      if (AClassNameEditPart.VISUAL_ID == nodeVisualID)
      {
        return true;
      }
      if (AClassAnAttributeCompartmentEditPart.VISUAL_ID == nodeVisualID)
      {
        return true;
      }
      if (AClassAnOperationClassCompartmentEditPart.VISUAL_ID == nodeVisualID)
      {
        return true;
      }
      break;
    case AInterfaceAnAttributeInterfaceCompartmentEditPart.VISUAL_ID:
      if (AnAttributeEditPart.VISUAL_ID == nodeVisualID)
      {
        return true;
      }
      break;
    case AInterfaceAnOperationInterfaceCompartmentEditPart.VISUAL_ID:
      if (AnOperationEditPart.VISUAL_ID == nodeVisualID)
      {
        return true;
      }
      break;
    case AClassAnAttributeCompartmentEditPart.VISUAL_ID:
      if (AnAttribute2EditPart.VISUAL_ID == nodeVisualID)
      {
        return true;
      }
      break;
    case AClassAnOperationClassCompartmentEditPart.VISUAL_ID:
      if (AnOperation2EditPart.VISUAL_ID == nodeVisualID)
      {
        return true;
      }
      break;
    }
    return false;
  }

  /**
   * @generated
   */
  public static int getLinkWithClassVisualID(EObject domainElement)
  {
    if (domainElement == null)
    {
      return -1;
    }
    return -1;
  }

  /**
   * User can change implementation of this method to handle some specific situations not covered by default logic.
   * 
   * @generated
   */
  private static boolean isDiagram(ClassDiagram element)
  {
    return true;
  }

}
