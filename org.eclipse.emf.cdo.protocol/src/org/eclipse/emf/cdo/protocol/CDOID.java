/***************************************************************************
 * Copyright (c) 2004 - 2008 Eike Stepper, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 **************************************************************************/
package org.eclipse.emf.cdo.protocol;

import org.eclipse.emf.cdo.internal.protocol.CDOIDNull;

/**
 * @author Eike Stepper
 */
public interface CDOID extends Comparable<CDOID>
{
  public static final CDOID NULL = new CDOIDNull();

  public long getValue();

  public boolean isNull();

  public boolean isTemporary();

  public boolean isMeta();

  public CDOID getNext();
}