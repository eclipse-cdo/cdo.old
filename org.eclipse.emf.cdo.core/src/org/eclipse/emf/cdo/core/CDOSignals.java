/***************************************************************************
 * Copyright (c) 2004, 2005, 2006 Eike Stepper, Fuggerstr. 39, 10777 Berlin, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 **************************************************************************/
package org.eclipse.emf.cdo.core;


public interface CDOSignals
{
  public static final byte ANNOUNCE_PACKAGE = 1;

  public static final byte DESCRIBE_PACKAGE = 2;

  public static final byte RESOURCE_RID = 3;

  public static final byte RESOURCE_PATH = 4;

  public static final byte LOAD_RESOURCE = 5;

  public static final byte LOAD_OBJECT = 6;

  public static final byte COMMIT_TRANSACTION = 7;

  public static final byte INVALIDATE_OBJECT = 8;

  public static final byte QUERY_EXTENT = 9;
}
