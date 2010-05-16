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

import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.part.ClassdiagramDiagramEditorPlugin;
import org.eclipse.emf.cdo.dawn.runtime.synchronize.DawnConflictHelper;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @author Martin Fluegge
 */
public class DawnClassDiagramEditPart extends ClassDiagramEditPart
{

  // /**
  // * @generated
  // */
  //  public final static String MODEL_ID = "Classdiagram"; //$NON-NLS-1$
  //
  // /**
  // * @generated
  // */
  // public static final int VISUAL_ID = 1000;

  /**
   * @generated
   */
  public DawnClassDiagramEditPart(View view)
  {
    super(view);
    ClassdiagramDiagramEditorPlugin.getInstance().logInfo("Using DawnClassDiagramEditPart instead of the original one");
  }

  @Override
  protected void removeChild(EditPart child)
  {
    if (DawnConflictHelper.isConflicted((EObject)child.getModel()))
    {
      return;
    }
    super.removeChild(child);
  }
}
