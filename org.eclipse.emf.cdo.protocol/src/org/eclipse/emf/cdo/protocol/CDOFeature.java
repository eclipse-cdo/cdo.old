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
package org.eclipse.emf.cdo.protocol;

/**
 * TODO The {@link CDOFeature} class.
 * <p>
 * 
 * @author Eike Stepper
 */
public interface CDOFeature
{

  public abstract CDOClass getCDOClass();

  public abstract int getFeatureID();

  public abstract String getName();

  public abstract int getType();

  public abstract boolean isMany();

  public abstract boolean isReference();

  public abstract CDOClass getReferenceType();

  public abstract CDOClassRef getReferenceClassRef();

  public abstract CDOClassResolver getClassResolver();

  public abstract CDOPackage getCDOPackage();

}