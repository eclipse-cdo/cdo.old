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
package org.eclipse.emf.cdo.weaver;

import org.eclipse.emf.cdo.internal.weaver.CDOWeaver;

import java.net.URL;

/**
 * @author Eike Stepper
 */
public interface ICDOWeaver
{
  public static final ICDOWeaver INSTANCE = CDOWeaver.INSTANCE;

  public void test();

  public void weave(URL[] classURLs);
}