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


import org.eclipse.net4j.spring.Service;


public interface OIDEncoder extends Service
{
  public int getRID(long oid);

  public long getOIDFragment(long oid);

  public long getOID(int rid, long oidFragment);

  public String toString(int rid, long oidFragment);

  public String toString(long oid);
}
