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
 * TODO The {@link CDOClass} class.
 * <p>
 * 
 * @author Eike Stepper
 */
public interface CDOClass
{

  public abstract CDOPackage getCDOPackage();

  public abstract int getClassifierID();

  public abstract String getName();

  public abstract boolean isAbstract();

  public abstract CDOFeature[] getCDOFeatures();

  public abstract CDOClassID getClassID();

  public abstract CDOClassRef getClassRef();

  public abstract CDOClassResolver getClassResolver();

}