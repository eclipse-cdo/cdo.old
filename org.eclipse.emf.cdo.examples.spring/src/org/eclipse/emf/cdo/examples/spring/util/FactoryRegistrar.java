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
package org.eclipse.emf.cdo.examples.spring.util;

import org.eclipse.net4j.util.ObjectUtil;
import org.eclipse.net4j.util.factory.IFactory;
import org.eclipse.net4j.util.factory.IFactoryKey;
import org.eclipse.net4j.util.registry.IRegistry;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author Eike Stepper
 */
public class FactoryRegistrar implements BeanPostProcessor
{
  private IRegistry<IFactoryKey, IFactory> registry;

  private String productGroup;

  public FactoryRegistrar()
  {
  }

  public IRegistry<IFactoryKey, IFactory> getRegistry()
  {
    return registry;
  }

  public void setRegistry(IRegistry<IFactoryKey, IFactory> registry)
  {
    this.registry = registry;
  }

  public String getProductGroup()
  {
    return productGroup;
  }

  public void setProductGroup(String productGroup)
  {
    this.productGroup = productGroup;
  }

  public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException
  {
    return bean;
  }

  public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException
  {
    if (bean instanceof IFactory)
    {
      IFactory factory = (IFactory)bean;
      IFactoryKey key = factory.getKey();
      if (productGroup == null || ObjectUtil.equals(productGroup, key.getProductGroup()))
      {
        registry.put(key, factory);
      }
    }

    return bean;
  }
}
