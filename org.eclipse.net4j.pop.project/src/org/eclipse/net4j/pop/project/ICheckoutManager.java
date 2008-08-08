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
package org.eclipse.net4j.pop.project;

import org.eclipse.net4j.util.container.IContainer;

import org.eclipse.core.runtime.IAdaptable;

/**
 * @author Eike Stepper
 */
public interface ICheckoutManager extends IContainer<Checkout>, IAdaptable
{
  public PopProject getPopProject();

  public Checkout[] getCheckouts();

  public boolean hasCheckout(CheckoutDiscriminator discriminator);

  public Checkout getCheckout(CheckoutDiscriminator discriminator);

  public Checkout checkout(CheckoutDiscriminator discriminator);

  public Checkout getActiveCheckout();

  public void setActiveCheckout(Checkout checkout);

  public boolean isCheckoutActive(Checkout checkout);
}
