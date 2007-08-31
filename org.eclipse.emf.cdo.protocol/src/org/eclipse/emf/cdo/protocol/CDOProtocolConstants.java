/***************************************************************************
 * Copyright (c) 2004 - 2007 Eike Stepper, Germany.
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
 * @author Eike Stepper
 */
public interface CDOProtocolConstants
{
  public static final String PROTOCOL_NAME = "cdo";

  public static final short SIGNAL_OPEN_SESSION = 1;

  public static final short SIGNAL_VIEWS_CHANGED = 2;

  public static final short SIGNAL_RESOURCE_ID = 3;

  public static final short SIGNAL_RESOURCE_PATH = 4;

  public static final short SIGNAL_LOAD_PACKAGE = 5;

  public static final short SIGNAL_LOAD_REVISION = 6;

  public static final short SIGNAL_COMMIT_TRANSACTION = 7;

  public static final short SIGNAL_INVALIDATION = 8;

  public static final int ERROR_REPOSITORY_NOT_FOUND = -1;

  public static final int ERROR_NO_SESSION = -2;

  public static final byte VIEW_TRANSACTION = 1;

  public static final byte VIEW_AUDIT = 2;

  public static final byte VIEW_READONLY = 3;

  public static final byte VIEW_CLOSED = 4;
}
