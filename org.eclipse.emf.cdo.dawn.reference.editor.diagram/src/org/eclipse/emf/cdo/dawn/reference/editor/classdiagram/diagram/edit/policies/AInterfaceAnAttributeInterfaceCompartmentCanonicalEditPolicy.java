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
package org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.edit.policies;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.ClassdiagramPackage;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.edit.parts.AnAttributeEditPart;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.part.ClassdiagramDiagramUpdater;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.part.ClassdiagramNodeDescriptor;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.part.ClassdiagramVisualIDRegistry;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class AInterfaceAnAttributeInterfaceCompartmentCanonicalEditPolicy extends CanonicalEditPolicy
{

  /**
   * @generated
   */
  protected List getSemanticChildrenList()
  {
    View viewObject = (View)getHost().getModel();
    LinkedList<EObject> result = new LinkedList<EObject>();
    List<ClassdiagramNodeDescriptor> childDescriptors = ClassdiagramDiagramUpdater
        .getAInterfaceAnAttributeInterfaceCompartment_7001SemanticChildren(viewObject);
    for (Iterator<ClassdiagramNodeDescriptor> it = childDescriptors.iterator(); it.hasNext();)
    {
      ClassdiagramNodeDescriptor d = it.next();
      result.add(d.getModelElement());
    }
    return result;
  }

  /**
   * @generated
   */
  protected boolean isOrphaned(Collection semanticChildren, final View view)
  {
    int visualID = ClassdiagramVisualIDRegistry.getVisualID(view);
    switch (visualID)
    {
    case AnAttributeEditPart.VISUAL_ID:
      if (!semanticChildren.contains(view.getElement()))
      {
        return true;
      }
    }
    return false;
  }

  /**
   * @generated
   */
  protected EStructuralFeature getFeatureToSynchronize()
  {
    return ClassdiagramPackage.eINSTANCE.getABasicClass_Attributes();
  }

}
