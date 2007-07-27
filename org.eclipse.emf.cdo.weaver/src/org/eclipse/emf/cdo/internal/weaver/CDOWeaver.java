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
package org.eclipse.emf.cdo.internal.weaver;

import org.eclipse.emf.cdo.weaver.ICDOWeaver;

import org.aspectj.weaver.loadtime.WeavingURLClassLoader;

import java.net.URL;

/**
 * @author Eike Stepper
 */
public class CDOWeaver implements ICDOWeaver
{
  public static final CDOWeaver INSTANCE = new CDOWeaver();

  private CDOWeaver()
  {
  }

  public void weave()
  {
    ClassLoader parent = null;
    URL[] classURLs = {};
    URL[] aspectURLs = {};
    WeavingURLClassLoader classLoader = new WeavingURLClassLoader(classURLs, aspectURLs, parent);
  }

  public static void main(String[] args) throws Exception
  {
    INSTANCE.weave();
  }
}
