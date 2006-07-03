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
package org.eclipse.net4j.examples.mvc.util;


import org.eclipse.net4j.examples.mvc.IBinding;


public class NoAdapterException extends RuntimeException
{
  private static final long serialVersionUID = 3258125869133411890L;

  private IBinding binding;

  public NoAdapterException(IBinding binding, String message)
  {
    super(message);
    this.binding = binding;
  }

  public NoAdapterException(IBinding binding)
  {
    this(binding, "No Adapter for binding " + binding);
  }

  public IBinding getBinding()
  {
    return binding;
  }
}
