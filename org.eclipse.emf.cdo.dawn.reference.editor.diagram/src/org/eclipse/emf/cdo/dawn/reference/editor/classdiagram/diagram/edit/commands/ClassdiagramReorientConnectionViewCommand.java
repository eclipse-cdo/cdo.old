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
package org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.diagram.edit.commands;

import org.eclipse.emf.transaction.TransactionalEditingDomain;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;

import java.util.List;

/**
 * @generated
 */
public class ClassdiagramReorientConnectionViewCommand extends AbstractTransactionalCommand
{

  /**
   * @generated
   */
  private IAdaptable edgeAdaptor;

  /**
   * @generated
   */
  public ClassdiagramReorientConnectionViewCommand(TransactionalEditingDomain editingDomain, String label)
  {
    super(editingDomain, label, null);
  }

  /**
   * @generated
   */
  public List getAffectedFiles()
  {
    View view = (View)edgeAdaptor.getAdapter(View.class);
    if (view != null)
    {
      return getWorkspaceFiles(view);
    }
    return super.getAffectedFiles();
  }

  /**
   * @generated
   */
  public IAdaptable getEdgeAdaptor()
  {
    return edgeAdaptor;
  }

  /**
   * @generated
   */
  public void setEdgeAdaptor(IAdaptable edgeAdaptor)
  {
    this.edgeAdaptor = edgeAdaptor;
  }

  /**
   * @generated
   */
  protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info)
  {
    assert null != edgeAdaptor : "Null child in ClassdiagramReorientConnectionViewCommand"; //$NON-NLS-1$
    Edge edge = (Edge)getEdgeAdaptor().getAdapter(Edge.class);
    assert null != edge : "Null edge in ClassdiagramReorientConnectionViewCommand"; //$NON-NLS-1$
    View tempView = edge.getSource();
    edge.setSource(edge.getTarget());
    edge.setTarget(tempView);
    return CommandResult.newOKCommandResult();
  }
}
