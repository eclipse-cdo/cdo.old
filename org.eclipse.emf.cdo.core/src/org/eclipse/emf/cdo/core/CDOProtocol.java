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


import org.eclipse.net4j.transport.Protocol;


/**
 * Defines symbolic constants to be 
 * used in payload traffic of the CDO protocol.<p>
 *
 * @author Eike Stepper
 */
public interface CDOProtocol extends Protocol, CDODataTypes, CDOSignals
{
  /**
   * The identifying name of the CDO protocol.<p>
   */
  public static final String PROTOCOL_NAME = "cdo";

  /**
   * The String prefix of CDO scheme URIs.<p>
   */
  public static final String PROTOCOL_SCHEME = PROTOCOL_NAME + "://";

  /**
   * A constant that can be passed instead of a resource identifier ({@link RID})
   * to denote global scope for an extent (in contrast to resource-wide scope).<p>
   */
  public static final int GLOBAL_EXTENT = 0;

  /**
   * A constant that can be passed instead of a resource identifier ({@link RID})
   * to denote global scope for cross referencing (in contrast to resource-wide scope).<p>
   */
  public static final int GLOBAL_XREFS = 0;

  /**
   * The slash string.<p>
   */
  public static final String SLASH = "/";

  /**
   * For internal use only.<p>
   */
  public static final byte FEATURE_SET = 1;

  /**
   * For internal use only.<p>
   */
  public static final byte FEATURE_UNSET = 2;

  /**
   * For internal use only.<p>
   */
  public static final byte LIST_ADD = 3;

  /**
   * For internal use only.<p>
   */
  public static final byte LIST_REMOVE = 4;

  /**
   * For internal use only.<p>
   */
  public static final byte LIST_MOVE = 5;

  /**
   * For internal use only.<p>
   */
  public static final long NO_MORE_OBJECTS = 0;

  /**
   * For internal use only.<p>
   */
  public static final int NO_MORE_SEGMENTS = 0;

  /**
   * For internal use only.<p>
   */
  public static final byte NO_MORE_REFERENCE_CHANGES = 0;

  /**
   * For internal use only.<p>
   */
  public static final long NO_MORE_OBJECT_CHANGES = 0;

  /**
   * For internal use only.<p>
   */
  public static final int UNKNOWN_RID = -1;
}
