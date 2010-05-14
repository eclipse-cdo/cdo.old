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

import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.providers.ClassdiagramElementTypes;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyReferenceCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;

/**
 * @generated
 */
public class AClassCompositionsItemSemanticEditPolicy extends ClassdiagramBaseItemSemanticEditPolicy
{

  /**
   * @generated
   */
  public AClassCompositionsItemSemanticEditPolicy()
  {
    super(ClassdiagramElementTypes.AClassCompositions_4005);
  }

  /**
   * @generated
   */
  protected Command getDestroyReferenceCommand(DestroyReferenceRequest req)
  {
    return getGEFWrapper(new DestroyReferenceCommand(req));
  }

}
