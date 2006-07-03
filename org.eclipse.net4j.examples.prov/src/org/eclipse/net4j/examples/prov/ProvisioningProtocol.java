/***************************************************************************
 * Copyright (c) 2004-2006 Eike Stepper, Fuggerstr. 39, 10777 Berlin, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 **************************************************************************/
package org.eclipse.net4j.examples.prov;


import org.eclipse.net4j.core.Protocol;


public interface ProvisioningProtocol extends Protocol
{
  public static final String PROTOCOL_NAME = "org.eclipse.net4j.examples.prov";

  public static final short LOAD_SITE = 1;

  public static final short SAVE_SITE = 2;

  public static final short UNLOCK_SITE = 3;

  public static final short UPLOAD_ARCHIVE = 4;

  public static final short REMOVE_FEATURE = 5;
}
