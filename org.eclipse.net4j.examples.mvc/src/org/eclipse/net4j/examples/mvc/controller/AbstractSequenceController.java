/***************************************************************************
 * Copyright (c) 2004-2006 Eike Stepper, Fuggerstr. 39, 10777 Berlin, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 **************************************************************************/
package org.eclipse.net4j.examples.mvc.controller;


import org.eclipse.net4j.examples.mvc.IController;
import org.eclipse.net4j.examples.mvc.IRecordController;
import org.eclipse.net4j.examples.mvc.ISequenceController;
import org.eclipse.net4j.examples.mvc.IAdapter.Manager;
import org.eclipse.net4j.examples.mvc.binding.EnablementViewBinding;
import org.eclipse.net4j.examples.mvc.binding.SelectionViewBinding;
import org.eclipse.net4j.examples.mvc.binding.SequenceModelBinding;


public abstract class AbstractSequenceController<SEQUENCE_TARGET, RECORD_TARGET, VIEW_TARGET>
        extends Controller<Object> implements
        ISequenceController<SEQUENCE_TARGET, RECORD_TARGET, VIEW_TARGET>
{
  public static final String SEQUENCE_TARGET_NAME = "sequence";

  private int currentIndex = -1;

  private boolean transientCreation;

  private SequenceModelBinding<SEQUENCE_TARGET> sequenceModelBinding;

  private IRecordController<RECORD_TARGET, VIEW_TARGET> recordController;

  private SelectionViewBinding<VIEW_TARGET> newSelectionBinding;

  private EnablementViewBinding<VIEW_TARGET> deleteEnablementBinding;

  private SelectionViewBinding<VIEW_TARGET> deleteSelectionBinding;

  /**
   * 
   * @param adapterManager
   * @param name
   * @param sequenceModelTargetName
   * @param recordController
   */
  public AbstractSequenceController(Manager<Object> adapterManager, String name,
          String sequenceModelTargetName,
          IRecordController<RECORD_TARGET, VIEW_TARGET> recordController)
  {
    super(adapterManager, name);
    this.recordController = recordController;

    sequenceModelBinding = new SequenceModelBinding(this, sequenceModelTargetName)
    {
      public void onAdd(int index, Object item)
      {
        onModelAdd(index, item);
      }

      public void onMove(int fromIndex, int toIndex)
      {
        onModelMove(fromIndex, toIndex);
      }

      public void onRemove(int index, Object item)
      {
        onModelRemove(index, item);
      }

      public void onSet(int index, Object newItem, Object oldItem)
      {
        onModelSet(index, newItem, oldItem);
      }
    };
  }

  public EnablementViewBinding<VIEW_TARGET> getDeleteEnablementBinding()
  {
    return deleteEnablementBinding;
  }

  public SelectionViewBinding<VIEW_TARGET> getDeleteSelectionBinding()
  {
    return deleteSelectionBinding;
  }

  public SelectionViewBinding<VIEW_TARGET> getNewSelectionBinding()
  {
    return newSelectionBinding;
  }

  public void setNewBinding(String newTargetName)
  {
    newSelectionBinding = new SelectionViewBinding<VIEW_TARGET>((IController)this, newTargetName)
    {
      public boolean onSelection(Object item, int detail, int x, int y, int width, int height,
              int stateMask, boolean doit)
      {
        newItem();
        return true;
      }
    };
  }

  public void setDeleteBinding(String deleteTargetName)
  {
    deleteEnablementBinding = new EnablementViewBinding<VIEW_TARGET>((IController)this,
            deleteTargetName);

    deleteSelectionBinding = new SelectionViewBinding<VIEW_TARGET>((IController)this,
            deleteTargetName)
    {
      public boolean onSelection(Object item, int detail, int x, int y, int width, int height,
              int stateMask, boolean doit)
      {
        deleteItem();
        return true;
      }
    };
  }

  public int getCurrentIndex()
  {
    return currentIndex;
  }

  public void setCurrentIndex(int currentIndex)
  {
    this.currentIndex = currentIndex;
  }

  public boolean isRecordDirty()
  {
    return getRecordController() == null ? false : getRecordController().isDirty();
  }

  public void setRecordDirty(boolean on)
  {
    if (getRecordController() != null)
    {
      getRecordController().setDirty(on);
    }
  }

  public boolean isRecordTransient()
  {
    return getRecordController() == null ? true : getRecordController().isDirty();
  }

  public void setRecordTransient(boolean on)
  {
    if (getRecordController() != null)
    {
      getRecordController().setTransient(on);
    }
  }

  public boolean isTransientCreation()
  {
    return transientCreation;
  }

  public void setTransientCreation(boolean on)
  {
    transientCreation = on;
  }

  public SEQUENCE_TARGET getSequenceTarget()
  {
    return (SEQUENCE_TARGET)getTarget(SEQUENCE_TARGET_NAME);
  }

  public SEQUENCE_TARGET setSequenceTarget(SEQUENCE_TARGET target)
  {
    return (SEQUENCE_TARGET)putTarget(SEQUENCE_TARGET_NAME, target);
  }

  public IRecordController<RECORD_TARGET, VIEW_TARGET> getRecordController()
  {
    return recordController;
  }

  public void setRecordController(IRecordController<RECORD_TARGET, VIEW_TARGET> recordController)
  {
    this.recordController = recordController;
  }

  public SequenceModelBinding<SEQUENCE_TARGET> getSequenceModelBinding()
  {
    return sequenceModelBinding;
  }

  public void gotoFirst()
  {
    int newIndex = getSequenceModelBinding().size() > 0 ? 0 : -1;
    gotoIndex(newIndex);
  }

  public void gotoLast()
  {
    int newIndex = getSequenceModelBinding().size() - 1;
    gotoIndex(newIndex);
  }

  public void gotoNext()
  {
    int newIndex = getCurrentIndex()
            + (getCurrentIndex() < getSequenceModelBinding().size() - 1 ? 1 : 0);
    gotoIndex(newIndex);
  }

  public void gotoPrevious()
  {
    int newIndex = getCurrentIndex() - (getCurrentIndex() > 0 ? 1 : 0);
    gotoIndex(newIndex);
  }

  public void afterTargetsSet()
  {
    super.afterTargetsSet();
    init();
  }

  public boolean mayClose()
  {
    if (isRecordDirty())
    {
      return leaveDirtyRecord();
    }

    return super.mayClose();
  }

  protected void onRetarget(String name, Object newTarget, Object oldTarget)
  {
    if (SEQUENCE_TARGET_NAME.equals(name))
    {
      init();
    }
  }

  protected String itemToString(Object item)
  {
    return item.toString();
  }

  protected boolean leaveDirtyRecord()
  {
    if (getRecordController() != null)
    {
      getRecordController().saveView();
    }

    return true;
  }

  protected boolean confirmDelete()
  {
    return true;
  }

  protected Object createNewItem()
  {
    return null;
  }

  protected void newItem()
  {
    if (getRecordController() != null)
    {
      if (getRecordController().isDirty())
      {
        if (!leaveDirtyRecord())
        {
          return;
        }
      }
    }

    Object item = createNewItem();
    if (item == null)
    {
      return;
    }

    if (getSequenceModelBinding().add(item))
    {
      int index = getSequenceModelBinding().indexOf(item);
      gotoIndex(index);

      setRecordTransient(isTransientCreation());
    }

    updateEnablements();
  }

  protected void deleteItem()
  {
    if (!confirmDelete())
    {
      return;
    }

    getSequenceModelBinding().remove(getCurrentIndex());

    if (getCurrentIndex() < getSequenceModelBinding().size())
    {
      gotoIndex(getCurrentIndex());
    }
    else
    {
      gotoLast();
    }

    updateEnablements();
  }

  protected void updateEnablements()
  {
    getDeleteEnablementBinding().setEnabled(getCurrentIndex() != -1);
  }

  protected abstract void init();

  protected abstract void onModelSet(int index, Object newItem, Object oldItem);

  protected abstract void onModelRemove(int index, Object item);

  protected abstract void onModelMove(int fromIndex, int toIndex);

  protected abstract void onModelAdd(int index, Object item);
}
