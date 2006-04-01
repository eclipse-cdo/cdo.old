/*******************************************************************************
 * Copyright (c) 2004, 2005, 2006 Eike Stepper, Sympedia Methods and Tools.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Eike Stepper - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.cdo.core;


public interface CdoResSignals
{
  public static final byte QUERY_ALL_RESOURCES = 1;

  public static final byte QUERY_SUB_RESOURCES = 2;

  public static final byte CREATE_RESOURCE = 3;

  public static final byte REMOVE_RESOURCE = 4;

  public static final byte MOVE_RESOURCE = 5;

  public static final byte RESOURCES_CHANGED = 6;
}