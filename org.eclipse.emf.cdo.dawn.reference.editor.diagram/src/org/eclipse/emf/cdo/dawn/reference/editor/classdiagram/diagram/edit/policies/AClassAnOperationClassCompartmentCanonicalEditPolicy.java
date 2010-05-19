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
package org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.edit.policies;

import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.ClassdiagramPackage;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.edit.parts.AnOperation2EditPart;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.part.ClassdiagramDiagramUpdater;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.part.ClassdiagramNodeDescriptor;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.part.ClassdiagramVisualIDRegistry;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.notation.View;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @generated
 */
public class AClassAnOperationClassCompartmentCanonicalEditPolicy extends CanonicalEditPolicy
{

  /**
   * @generated
   */
  protected List getSemanticChildrenList()
  {
    View viewObject = (View)getHost().getModel();
    LinkedList<EObject> result = new LinkedList<EObject>();
    List<ClassdiagramNodeDescriptor> childDescriptors = ClassdiagramDiagramUpdater
        .getAClassAnOperationClassCompartment_7004SemanticChildren(viewObject);
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
    case AnOperation2EditPart.VISUAL_ID:
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
    return ClassdiagramPackage.eINSTANCE.getABasicClass_Operations();
  }

}
