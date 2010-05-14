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

import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.edit.commands.AnAttribute2CreateCommand;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.providers.ClassdiagramElementTypes;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

/**
 * @generated
 */
public class AClassAnAttributeCompartmentItemSemanticEditPolicy extends ClassdiagramBaseItemSemanticEditPolicy
{

  /**
   * @generated
   */
  public AClassAnAttributeCompartmentItemSemanticEditPolicy()
  {
    super(ClassdiagramElementTypes.AClass_2002);
  }

  /**
   * @generated
   */
  protected Command getCreateCommand(CreateElementRequest req)
  {
    if (ClassdiagramElementTypes.AnAttribute_3003 == req.getElementType())
    {
      return getGEFWrapper(new AnAttribute2CreateCommand(req));
    }
    return super.getCreateCommand(req);
  }

}
