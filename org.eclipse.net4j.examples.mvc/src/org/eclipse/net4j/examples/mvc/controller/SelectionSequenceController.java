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
package org.eclipse.net4j.examples.mvc.controller;


import org.eclipse.net4j.examples.mvc.IRecordController;
import org.eclipse.net4j.examples.mvc.ISequenceController;
import org.eclipse.net4j.examples.mvc.IAdapter.Manager;
import org.eclipse.net4j.examples.mvc.binding.SelectionViewBinding;


public class SelectionSequenceController<SEQUENCE_TARGET, RECORD_TARGET, VIEW_TARGET> extends
        AbstractSequenceController<SEQUENCE_TARGET, RECORD_TARGET, VIEW_TARGET> implements
        ISequenceController<SEQUENCE_TARGET, RECORD_TARGET, VIEW_TARGET>
{
  private SelectionViewBinding<VIEW_TARGET> selectionViewBinding;

  public SelectionSequenceController(Manager<Object> adapterManager, String name,
          String sequenceModelTargetName, String selectionViewTargetName,
          IRecordController<RECORD_TARGET, VIEW_TARGET> recordController)
  {
    super(adapterManager, name, sequenceModelTargetName, recordController);

    selectionViewBinding = new SelectionViewBinding(this, selectionViewTargetName)
    {
      public boolean onSelection(Object item, int detail, int x, int y, int width, int height,
              int stateMask, boolean doit)
      {
        int index = getSelectionIndex();
        return onViewSelection(index);
      }
    };
  }

  public SelectionViewBinding<VIEW_TARGET> getSelectionViewBinding()
  {
    return selectionViewBinding;
  }

  protected void init()
  {
    if (getSequenceModelBinding().isEmpty())
    {
      if (getRecordController() != null)
      {
        getRecordController().enableView(false);
      }

      return;
    }

    if (getRecordController() != null)
    {
      RECORD_TARGET recordTarget = (RECORD_TARGET)getSequenceModelBinding().get(0);
      getRecordController().setRecordTarget(recordTarget);
      getRecordController().loadView();
    }

    if (getSelectionViewBinding().getTarget() == null
            || getSequenceModelBinding().getTarget() == null)
    {
      return;
    }

    for (Object item : getSequenceModelBinding())
    {
      getSelectionViewBinding().add(itemToString(item));
    }

    gotoFirst();
  }

  public void gotoIndex(int index)
  {
    int oldIndex = getCurrentIndex();

    if (index != oldIndex)
    {
      if (getRecordController().isDirty())
      {
        if (!leaveDirtyRecord())
        {
          return;
        }
      }
    }

    setCurrentIndex(index);
    getSelectionViewBinding().setSelection(index);

    if (getRecordController() != null)
    {
      if (index == -1)
      {
        getRecordController().enableView(false);
        getRecordController().clearView();
      }
      else
      {
        getRecordController().enableView(true);
        RECORD_TARGET recordTarget = (RECORD_TARGET)getSequenceModelBinding().get(index);
        getRecordController().setRecordTarget(recordTarget);
        getRecordController().loadView();
      }
    }
  }

  @Override
  protected void onModelSet(int index, Object newItem, Object oldItem)
  {
  }

  @Override
  protected void onModelRemove(int index, Object item)
  {
    getSelectionViewBinding().remove(index);
  }

  @Override
  protected void onModelMove(int fromIndex, int toIndex)
  {
  }

  @Override
  protected void onModelAdd(int index, Object item)
  {
    getSelectionViewBinding().add(itemToString(item), index);
  }

  protected boolean onViewSelection(int index)
  {
    gotoIndex(index);
    return true;
  }
}
