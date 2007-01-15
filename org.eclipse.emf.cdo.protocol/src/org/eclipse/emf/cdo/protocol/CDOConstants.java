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
 * @author Eike Stepper
 */
public interface CDOConstants
{
  public static final String PROTOCOL_NAME = "cdo";

  public static final String CDORESOURCE_PACKAGE_URI = "http://www.eclipse.org/emf/CDO/resource/1.0.0";

  public static final String CDORESOURCE_PACKAGE_NAME = "cdoresource";

  public static final String CDORESOURCE_CLASS_NAME = "CDOResource";

  public static final int CDORESOURCE_CLASS_ID = 0;

  public static final String CDORESOURCE_CONTENTS_NAME = "contents";

  public static final int CDORESOURCE_CONTENTS_ID = 0;

  public static final short OPEN_SESSION_SIGNAL = 1;

  public static final short ADD_MODELS_SIGNAL = 2;

  public static final short MODELS_ADDED_SIGNAL = 3;

  public static final short LOAD_RESOURCE_ID_SIGNAL = 4;

  public static final short LOAD_RESOURCE_PATH_SIGNAL = 5;

  public static final short COMMIT_TRANSACTION_SIGNAL = 6;

  public static final int ERROR_REPOSITORY_NOT_FOUND = -1;

  public static final int ERROR_NO_SESSION = -2;
}
