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
package org.eclipse.emf.cdo.protocol.model;

import org.eclipse.emf.cdo.protocol.util.CDOClassRef;

/**
 * @author Eike Stepper
 */
public interface CDOFeature extends CDOModelElement
{
  public abstract int getType();

  public abstract boolean isMany();

  public abstract boolean isReference();

  public abstract CDOClass getReferenceClass();

  public abstract CDOClass getCDOClass();

  public abstract CDOPackage getCDOPackage();

  public abstract CDOModelResolver getClassResolver();

  public abstract CDOClassRef getReferenceClassRef();
}