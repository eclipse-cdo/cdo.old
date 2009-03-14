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
package org.eclipse.emf.cdo.tests.model1.diagram.part;

import org.eclipse.emf.ecore.EObject;

/**
 * @generated
 */
public class Model1NodeDescriptor
{

  /**
   * @generated
   */
  private EObject myModelElement;

  /**
   * @generated
   */
  private int myVisualID;

  /**
   * @generated
   */
  private String myType;

  /**
   * @generated
   */
  public Model1NodeDescriptor(EObject modelElement, int visualID)
  {
    myModelElement = modelElement;
    myVisualID = visualID;
  }

  /**
   * @generated
   */
  public EObject getModelElement()
  {
    return myModelElement;
  }

  /**
   * @generated
   */
  public int getVisualID()
  {
    return myVisualID;
  }

  /**
   * @generated
   */
  public String getType()
  {
    if (myType == null)
    {
      myType = Model1VisualIDRegistry.getType(getVisualID());
    }
    return myType;
  }

}
