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
public final class FShareUtil
{
  public static final char SLASH = '/';

  private FShareUtil()
  {
  }

  public static String[] splitPathFirst(String path)
  {
    path = trimPath(path);
    int slash = path.indexOf(SLASH);
    if (slash == -1)
    {
      return new String[] { path, null };
    }

    return new String[] { path.substring(0, slash), path.substring(slash + 1) };
  }

  public static String[] splitPathLast(String path)
  {
    path = trimPath(path);
    int slash = path.lastIndexOf(SLASH);
    if (slash == -1)
    {
      return new String[] { null, path };
    }

    return new String[] { path.substring(0, slash), path.substring(slash + 1) };
  }

  private static String trimPath(String path)
  {
    int length = path.length();
    if (length != 0 && path.charAt(0) == SLASH)
    {
      path = path.substring(1);
      --length;
    }

    if (length != 0 && path.charAt(length - 1) == SLASH)
    {
      path = path.substring(0, length - 1);
    }

    return path;
  }
}
