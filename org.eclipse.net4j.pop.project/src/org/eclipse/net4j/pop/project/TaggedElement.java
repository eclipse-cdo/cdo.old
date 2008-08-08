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
 * $Id: TaggedElement.java,v 1.1 2008-08-08 10:10:38 estepper Exp $
 */
package org.eclipse.net4j.pop.project;

import org.eclipse.net4j.pop.base.PopElement;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Tagged Element</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.net4j.pop.project.TaggedElement#getTag <em>Tag</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.net4j.pop.project.ProjectPackage#getTaggedElement()
 * @model abstract="true"
 * @generated
 */
public interface TaggedElement extends PopElement
{
  /**
   * Returns the value of the '<em><b>Tag</b></em>' reference.
   * It is bidirectional and its opposite is '{@link org.eclipse.net4j.pop.project.Tag#getTaggedElement <em>Tagged Element</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Tag</em>' reference isn't clear, there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Tag</em>' reference.
   * @see #setTag(Tag)
   * @see org.eclipse.net4j.pop.project.ProjectPackage#getTaggedElement_Tag()
   * @see org.eclipse.net4j.pop.project.Tag#getTaggedElement
   * @model opposite="taggedElement" required="true"
   * @generated
   */
  Tag getTag();

  /**
   * Sets the value of the '{@link org.eclipse.net4j.pop.project.TaggedElement#getTag <em>Tag</em>}' reference. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @param value
   *          the new value of the '<em>Tag</em>' reference.
   * @see #getTag()
   * @generated
   */
  void setTag(Tag value);

} // TaggedElement
