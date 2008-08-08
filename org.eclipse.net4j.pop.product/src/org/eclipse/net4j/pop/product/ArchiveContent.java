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
 * $Id: ArchiveContent.java,v 1.1 2008-08-08 10:10:38 estepper Exp $
 */
package org.eclipse.net4j.pop.product;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Archive Content</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.net4j.pop.product.ArchiveContent#getArchive <em>Archive</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.net4j.pop.product.ProductPackage#getArchiveContent()
 * @model
 * @generated
 */
public interface ArchiveContent extends Folder
{
  /**
   * Returns the value of the '<em><b>Archive</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link org.eclipse.net4j.pop.product.Archive#getContent <em>Content</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Archive</em>' container reference isn't clear, there really should be more of a
   * description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Archive</em>' container reference.
   * @see #setArchive(Archive)
   * @see org.eclipse.net4j.pop.product.ProductPackage#getArchiveContent_Archive()
   * @see org.eclipse.net4j.pop.product.Archive#getContent
   * @model opposite="content" required="true" transient="false"
   * @generated
   */
  Archive getArchive();

  /**
   * Sets the value of the '{@link org.eclipse.net4j.pop.product.ArchiveContent#getArchive <em>Archive</em>}' container reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @param value the new value of the '<em>Archive</em>' container reference.
   * @see #getArchive()
   * @generated
   */
  void setArchive(Archive value);

} // ArchiveContent
