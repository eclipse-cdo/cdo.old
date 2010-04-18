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

import org.eclipse.emf.cdo.dawn.logging.logger.LOG;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.part.ClassdiagramVisualIDRegistry;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.notation.View;

public class DawnClassdiagramEditPartFactory extends ClassdiagramEditPartFactory
{
  public DawnClassdiagramEditPartFactory()
  {
    super();
    LOG.info("Using DawnClassdiagramEditPartFactory instead of the original one");
  }

  public EditPart createEditPart(EditPart context, Object model)
  {
    if (model instanceof View)
    {
      View view = (View)model;
      switch (ClassdiagramVisualIDRegistry.getVisualID(view))
      {
      case DawnClassDiagramEditPart.VISUAL_ID:
        return new DawnClassDiagramEditPart(view);
      }
    }

    return super.createEditPart(context, model);
  }
}
