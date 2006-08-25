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
package org.eclipse.net4j.examples.mvc.util;


import java.util.List;


public class AmbiguousFactoriesException extends RuntimeException
{
  private static final long serialVersionUID = 3257846588767680824L;

  private List possibleFactories;

  public AmbiguousFactoriesException(List possibleFactories, String message)
  {
    super(message);
    this.possibleFactories = possibleFactories;
  }

  public AmbiguousFactoriesException(List possibleFactories)
  {
    this(possibleFactories, "Ambiguous factories " + possibleFactories);
  }

  public List getPossibleFactories()
  {
    return possibleFactories;
  }
}
