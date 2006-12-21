package org.eclipse.emf.cdo.core.util.emf;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.change.ChangeFactory;
import org.eclipse.emf.ecore.change.ChangeKind;
import org.eclipse.emf.ecore.change.ListChange;

public class ChangeEListCompare extends AbstractEListCompare
{
  public ChangeEListCompare()
  {
  }

  /**
   * Convenience method added to allow subclasses to modify the default implementation 
   * for the scenario in which an element was added to the monitored list.
   * @see #createListChanges(EList, EList, EList) 
   */
  protected void createAddListChange(EList oldList, EList changesList, Object newObject, int index)
  {
    ListChange listChange = createListChange(changesList, ChangeKind.ADD_LITERAL, index);
    listChange.getValues().add(newObject);
    oldList.add(index, newObject);    
  }

  /**
   * Convenience method added to allow subclasses to modify the default implementation 
   * for the scenario in which an element was removed from the monitored list.
   * @see #createListChanges(EList, EList, EList) 
   */
  protected void createRemoveListChange(EList oldList, EList changesList, Object newObject, int index)
  {
    createListChange(changesList, ChangeKind.REMOVE_LITERAL, index);
    oldList.remove(index);
  }

  /**
   * Convenience method added to allow subclasses to modify the default implementation 
   * for the scenario in which an element was moved in the monitored list.
   * @see #createListChanges(EList, EList, EList) 
   */
  protected void createMoveListChange(EList oldList, EList changesList, Object newObject, int index, int toIndex)
  {
    ListChange listChange = createListChange(changesList, ChangeKind.MOVE_LITERAL, index);
    listChange.setMoveToIndex(toIndex);
    oldList.move(toIndex, index);
   }  

  protected ListChange createListChange(EList changesList, ChangeKind kind, int index)
  {
    ListChange listChange = ChangeFactory.eINSTANCE.createListChange();
    listChange.setKind(kind);
    listChange.setIndex(index);
    changesList.add(listChange);
    return listChange;
  }
}
