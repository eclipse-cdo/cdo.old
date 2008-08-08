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
 * $Id: Displayable.java,v 1.1 2008-08-08 10:10:32 estepper Exp $
 */
package org.eclipse.net4j.pop.base;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Displayable</b></em>'. <!-- end-user-doc -->
 * 
 * @see org.eclipse.net4j.pop.base.BasePackage#getDisplayable()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface Displayable extends EObject
{
  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @model kind="operation" required="true"
   * @generated
   */
  String getDisplayString();

} // Displayable
