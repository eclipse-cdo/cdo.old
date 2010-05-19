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

import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.providers.ClassdiagramElementTypes;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class AnOperation2ItemSemanticEditPolicy extends ClassdiagramBaseItemSemanticEditPolicy
{

  /**
   * @generated
   */
  public AnOperation2ItemSemanticEditPolicy()
  {
    super(ClassdiagramElementTypes.AnOperation_3004);
  }

  /**
   * @generated
   */
  protected Command getDestroyElementCommand(DestroyElementRequest req)
  {
    View view = (View)getHost().getModel();
    CompositeTransactionalCommand cmd = new CompositeTransactionalCommand(getEditingDomain(), null);
    cmd.setTransactionNestingEnabled(false);
    EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
    if (annotation == null)
    {
      // there are indirectly referenced children, need extra commands: false
      addDestroyShortcutsCommand(cmd, view);
      // delete host element
      cmd.add(new DestroyElementCommand(req));
    }
    else
    {
      cmd.add(new DeleteCommand(getEditingDomain(), view));
    }
    return getGEFWrapper(cmd.reduce());
  }

}
