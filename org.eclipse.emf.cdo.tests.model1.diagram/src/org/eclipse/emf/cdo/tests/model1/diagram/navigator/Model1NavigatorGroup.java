/*
 * Copyright (c) 2008 Open Canarias S.L. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *    Victor Roldan Betancort - GMF models creation and initial generation
 *    Eike Stepper - maintenance
 */
package org.eclipse.emf.cdo.tests.model1.diagram.navigator;

import java.util.Collection;
import java.util.LinkedList;

/**
 * @generated
 */
public class Model1NavigatorGroup extends Model1AbstractNavigatorItem
{

  /**
   * @generated
   */
  private String myGroupName;

  /**
   * @generated
   */
  private String myIcon;

  /**
   * @generated
   */
  private Collection myChildren = new LinkedList();

  /**
   * @generated
   */
  Model1NavigatorGroup(String groupName, String icon, Object parent)
  {
    super(parent);
    myGroupName = groupName;
    myIcon = icon;
  }

  /**
   * @generated
   */
  public String getGroupName()
  {
    return myGroupName;
  }

  /**
   * @generated
   */
  public String getIcon()
  {
    return myIcon;
  }

  /**
   * @generated
   */
  public Object[] getChildren()
  {
    return myChildren.toArray();
  }

  /**
   * @generated
   */
  public void addChildren(Collection children)
  {
    myChildren.addAll(children);
  }

  /**
   * @generated
   */
  public void addChild(Object child)
  {
    myChildren.add(child);
  }

  /**
   * @generated
   */
  public boolean isEmpty()
  {
    return myChildren.size() == 0;
  }

  /**
   * @generated
   */
  public boolean equals(Object obj)
  {
    if (obj instanceof org.eclipse.emf.cdo.tests.model1.diagram.navigator.Model1NavigatorGroup)
    {
      org.eclipse.emf.cdo.tests.model1.diagram.navigator.Model1NavigatorGroup anotherGroup = (org.eclipse.emf.cdo.tests.model1.diagram.navigator.Model1NavigatorGroup)obj;
      if (getGroupName().equals(anotherGroup.getGroupName()))
      {
        return getParent().equals(anotherGroup.getParent());
      }
    }
    return super.equals(obj);
  }

  /**
   * @generated
   */
  public int hashCode()
  {
    return getGroupName().hashCode();
  }

}
