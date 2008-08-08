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
 * $Id: DevelopmentStream.java,v 1.1 2008-08-08 10:10:38 estepper Exp $
 */
package org.eclipse.net4j.pop.project;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Development Stream</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.net4j.pop.project.DevelopmentStream#getMaintenanceStreams <em>Maintenance Streams</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.net4j.pop.project.ProjectPackage#getDevelopmentStream()
 * @model abstract="true"
 * @generated
 */
public interface DevelopmentStream extends IntegrationStream
{
  /**
   * Returns the value of the '<em><b>Maintenance Streams</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.net4j.pop.project.MaintenanceStream}.
   * It is bidirectional and its opposite is '{@link org.eclipse.net4j.pop.project.MaintenanceStream#getParent <em>Parent</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Maintenance Streams</em>' reference list isn't clear, there really should be more of a
   * description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Maintenance Streams</em>' containment reference list.
   * @see org.eclipse.net4j.pop.project.ProjectPackage#getDevelopmentStream_MaintenanceStreams()
   * @see org.eclipse.net4j.pop.project.MaintenanceStream#getParent
   * @model opposite="parent" containment="true" resolveProxies="true"
   * @generated
   */
  EList<MaintenanceStream> getMaintenanceStreams();

} // DevelopmentStream
