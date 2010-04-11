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
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.ClassdiagramPackage;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.edit.parts.AnOperation2EditPart;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.part.ClassdiagramDiagramUpdater;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.part.ClassdiagramNodeDescriptor;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.part.ClassdiagramVisualIDRegistry;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class AClassAnOperationClassCompartmentCanonicalEditPolicy extends CanonicalEditPolicy
{

  /**
   * @generated
   */
  Set myFeaturesToSynchronize;

  /**
   * @generated
   */
  protected List getSemanticChildrenList()
  {
    View viewObject = (View)getHost().getModel();
    List result = new LinkedList();
    for (Iterator it = ClassdiagramDiagramUpdater.getAClassAnOperationClassCompartment_7004SemanticChildren(viewObject)
        .iterator(); it.hasNext();)
    {
      result.add(((ClassdiagramNodeDescriptor)it.next()).getModelElement());
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
  protected String getDefaultFactoryHint()
  {
    return null;
  }

  /**
   * @generated
   */
  protected Set getFeaturesToSynchronize()
  {
    if (myFeaturesToSynchronize == null)
    {
      myFeaturesToSynchronize = new HashSet();
      myFeaturesToSynchronize.add(ClassdiagramPackage.eINSTANCE.getABasicClass_Operations());
    }
    return myFeaturesToSynchronize;
  }

}
