/***************************************************************************
 * Copyright (c) 2004 - 2008 Eike Stepper, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 **************************************************************************/
package org.eclipse.net4j.pop;

import org.eclipse.net4j.pop.code.ICodeStrategy;
import org.eclipse.net4j.pop.code.ICommitter;

import java.util.Date;

/**
 * Represents a <em>point of process</em>, a concept similar to a <em>project</em>.
 * <p>
 * 
 * @author Eike Stepper
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface IPop extends IDevelopmentStream
{
  /**
   * Returns <code>null</code>.
   */
  public IPop getParent();

  public String getName();

  public ICodeStrategy getCodeStrategy();

  public ICommitter addCommitter(String codeAccount, Date entryDate, Date exitDate);

  public int getCommitterCount();

  public ICommitter getCommitter(int index);

  public ICommitter[] getCommitters();
}
