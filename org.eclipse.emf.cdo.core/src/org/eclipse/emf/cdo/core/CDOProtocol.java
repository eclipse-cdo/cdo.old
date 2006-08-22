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


import org.eclipse.net4j.core.Protocol;


public interface CDOProtocol extends Protocol, CDODataTypes, CDOSignals
{
  public static final String PROTOCOL_NAME = "cdo";

  public static final String PROTOCOL_SCHEME = PROTOCOL_NAME + "://";

  public static final byte FEATURE_SET = 1;

  public static final byte FEATURE_UNSET = 2;

  public static final byte LIST_ADD = 3;

  public static final byte LIST_REMOVE = 4;

  public static final byte LIST_MOVE = 5;

  public static final int NO_MORE_OBJECTS = 0;

  public static final int NO_MORE_SEGMENTS = 0;

  public static final byte NO_MORE_REFERENCE_CHANGES = 0;

  public static final long NO_MORE_OBJECT_CHANGES = 0;

  public static final int UNKNOWN_RID = -1;

  public static final byte GLOBAL_EXTENT = 0;

  public static final String SLASH = "/";
}
