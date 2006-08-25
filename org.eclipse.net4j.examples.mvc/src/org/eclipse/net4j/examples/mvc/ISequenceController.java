/***************************************************************************
 * Copyright (c) 2004, 2005, 2006 Eike Stepper, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 **************************************************************************/
package org.eclipse.net4j.examples.mvc;


import org.eclipse.net4j.examples.mvc.binding.EnablementViewBinding;
import org.eclipse.net4j.examples.mvc.binding.SelectionViewBinding;


public interface ISequenceController<SEQUENCE_TARGET, RECORD_TARGET, VIEW_TARGET> extends
        IController<Object>
{
  public SEQUENCE_TARGET getSequenceTarget();

  public SEQUENCE_TARGET setSequenceTarget(SEQUENCE_TARGET target);

  public IRecordController<RECORD_TARGET, VIEW_TARGET> getRecordController();

  public void setRecordController(IRecordController<RECORD_TARGET, VIEW_TARGET> recordController);

  public EnablementViewBinding<VIEW_TARGET> getDeleteEnablementBinding();

  public SelectionViewBinding<VIEW_TARGET> getDeleteSelectionBinding();

  public SelectionViewBinding<VIEW_TARGET> getNewSelectionBinding();

  public void setNewBinding(String newTargetName);

  public void setDeleteBinding(String deleteTargetName);

  public int getCurrentIndex();

  public void gotoFirst();

  public void gotoLast();

  public void gotoNext();

  public void gotoPrevious();

  public void gotoIndex(int index);

  public boolean isRecordDirty();

  public void setRecordDirty(boolean on);

  public boolean isRecordTransient();

  public void setRecordTransient(boolean on);

  public boolean isTransientCreation();

  public void setTransientCreation(boolean on);
}
