/**
 * Copyright (c) 2004 - 2008 Eike Stepper, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 *
 * $Id: PopElement.java,v 1.1 2008-08-08 10:10:32 estepper Exp $
 */
package org.eclipse.net4j.pop.base;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Pop Element</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.net4j.pop.base.PopElement#getClass_ <em>Class</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.net4j.pop.base.BasePackage#getPopElement()
 * @model abstract="true"
 * @generated
 */
public interface PopElement extends Identifiable, Displayable
{

  /**
   * Returns the value of the '<em><b>Class</b></em>' attribute. <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Class</em>' attribute isn't clear, there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * 
   * @return the value of the '<em>Class</em>' attribute.
   * @see org.eclipse.net4j.pop.base.BasePackage#getPopElement_Class()
   * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
   * @generated
   */
  String getClass_();
} // PopElement
