/***************************************************************************
 * Copyright (c) 2004, 2005, 2006 Eike Stepper, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 **************************************************************************/
package org.eclipse.emf.cdo.core;


/**
 * An <i>object identifier</i> of type <code>long</code>.<p>
 * 
 * An {@link OID} is assigned to a <code>CDOPersistable</code> instance by the 
 * CDO server and uniquely identifies this instance within the scope of a whole 
 * CDO repository. The value of an {@link OID} is bitwise composed of:<p>
 * <ul>
 * <li> A <i>resource identifier</i> ({@link RID}).
 * <li> An <i>object identifier fragment</i> ({@link OIDFragment}) that is unique 
 * within the resource specified by the {@link RID}.
 * </ul>
 * 
 * The number of bits to be used for each of the 
 * parts can be configured to reflect varying needs of the application. An
 * application with many small resources would require more {@link RID}
 * bits and fewer {@link OIDFragment} bits. An application with a few 
 * large resources would require fewer {@link RID} bits and more 
 * {@link OIDFragment} bits.<p>
 * 
 * @see RID
 * @see OIDFragment
 * @see OIDEncoder
 * @author Eike Stepper
 */
public interface OID
{
}
