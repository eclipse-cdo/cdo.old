/**
 * Copyright (c) 2004 - 2010 Eike Stepper (Berlin, Germany) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Eike Stepper - initial API and implementation
 *
 *  Initial Publication:
 *    Eclipse Magazin - http://www.eclipse-magazin.de
 */
package org.eclipse.net4j.examples.fshare.common;

/**
 * @author Eike Stepper
 */
public interface FShareConstants
{
  public static final String PROTOCOL_NAME = "FShare";

  public static final short SIGNAL_LOGON = 1;

  public static final short SIGNAL_LOAD_CHILDREN = 2;

  public static final short SIGNAL_UPLOAD = 3;

  public static final short SIGNAL_UPLOAD_FEEDBACK = 4;

  public static final boolean FILE = false;

  public static final boolean FOLDER = true;
}
