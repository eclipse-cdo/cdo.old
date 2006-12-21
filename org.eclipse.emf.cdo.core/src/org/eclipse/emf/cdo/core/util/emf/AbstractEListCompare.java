package org.eclipse.emf.cdo.core.util.emf;


import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;

import java.util.Iterator;


public abstract class AbstractEListCompare
{
  protected AbstractEListCompare()
  {
  }

  public final void createListChanges(EList oldList, EList newList, EList changesList)
  {
    int index = 0;
    for (Iterator objects = newList.iterator(); objects.hasNext(); ++index)
    {
      Object newObject = objects.next();
      if (oldList.size() <= index)
      {
        createAddListChange(oldList, changesList, newObject, index);
      }
      else
      {
        boolean done;
        do
        {
          done = true;
          Object targetObject = oldList.get(index);
          if (targetObject == null ? newObject != null : !targetObject.equals(newObject))
          {
            int position = ECollections.indexOf(oldList, newObject, index);
            if (position != -1)
            {
              int targetIndex = ECollections.indexOf(newList, targetObject, index);
              if (targetIndex == -1)
              {
                createRemoveListChange(oldList, changesList, newObject, index);
                done = false;
              }
              else if (targetIndex > position)
              {
                if (oldList.size() <= targetIndex)
                {
                  targetIndex = oldList.size() - 1;
                }
                createMoveListChange(oldList, changesList, newObject, index, targetIndex);
                done = false;
              }
              else
              {
                createMoveListChange(oldList, changesList, newObject, position, index);
              }
            }
            else
            {
              createAddListChange(oldList, changesList, newObject, index);
            }
          }
        }
        while (!done);
      }
    }
    for (int i = oldList.size(); i > index;)
    {
      createRemoveListChange(oldList, changesList, null, --i);
    }
  }

  protected abstract void createAddListChange(EList oldList, EList changesList, Object newObject,
      int index);

  protected abstract void createRemoveListChange(EList oldList, EList changesList,
      Object newObject, int index);

  protected abstract void createMoveListChange(EList oldList, EList changesList, Object newObject,
      int index, int toIndex);
}
