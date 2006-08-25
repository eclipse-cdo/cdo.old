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
package org.eclipse.net4j.examples.mvc.binding;


import org.eclipse.net4j.examples.mvc.IAdapter;
import org.eclipse.net4j.examples.mvc.IController;
import org.eclipse.net4j.examples.mvc.aspect.IMetaDataAspect;
import org.eclipse.net4j.examples.mvc.util.NoAdapterException;


public class MetaDataBinding<TARGET> extends AbstractBinding<TARGET>
{
  public MetaDataBinding(IController<TARGET> controller, String targetName)
  {
    super(controller, targetName);
  }

  public Class getAspect()
  {
    return IMetaDataAspect.class;
  }

  public IMetaDataAspect getMetaDataAspect()
  {
    IAdapter<TARGET> adapter = getAdapter();

    if (adapter == null)
    {
      throw new NoAdapterException(this);
    }

    return (IMetaDataAspect)adapter;
  }
}
