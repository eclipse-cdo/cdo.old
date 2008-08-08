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
 * $Id: Archive.java,v 1.1 2008-08-08 10:10:38 estepper Exp $
 */
package org.eclipse.net4j.pop.product;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Archive</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.net4j.pop.product.Archive#getContent <em>Content</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.net4j.pop.product.ProductPackage#getArchive()
 * @model
 * @generated
 */
public interface Archive extends File
{
  /**
   * Returns the value of the '<em><b>Content</b></em>' containment reference.
   * It is bidirectional and its opposite is '{@link org.eclipse.net4j.pop.product.ArchiveContent#getArchive <em>Archive</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Content</em>' containment reference isn't clear, there really should be more of a
   * description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Content</em>' containment reference.
   * @see #setContent(ArchiveContent)
   * @see org.eclipse.net4j.pop.product.ProductPackage#getArchive_Content()
   * @see org.eclipse.net4j.pop.product.ArchiveContent#getArchive
   * @model opposite="archive" containment="true"
   * @generated
   */
  ArchiveContent getContent();

  /**
   * Sets the value of the '{@link org.eclipse.net4j.pop.product.Archive#getContent <em>Content</em>}' containment reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @param value the new value of the '<em>Content</em>' containment reference.
   * @see #getContent()
   * @generated
   */
  void setContent(ArchiveContent value);

} // Archive
