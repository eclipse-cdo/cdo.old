/**
 * Copyright (c) 2004 - 2008 Eike Stepper, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 * 
 *
 * $Id: DeliveryTest.java,v 1.1 2008-07-31 12:31:36 estepper Exp $
 */
package org.eclipse.net4j.pop.tests;

import org.eclipse.net4j.pop.Delivery;
import org.eclipse.net4j.pop.PopFactory;

import junit.framework.TestCase;
import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Delivery</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class DeliveryTest extends TestCase
{

  /**
   * The fixture for this Delivery test case.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Delivery fixture = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static void main(String[] args)
  {
    TestRunner.run(DeliveryTest.class);
  }

  /**
   * Constructs a new Delivery test case with the given name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DeliveryTest(String name)
  {
    super(name);
  }

  /**
   * Sets the fixture for this Delivery test case.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void setFixture(Delivery fixture)
  {
    this.fixture = fixture;
  }

  /**
   * Returns the fixture for this Delivery test case.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Delivery getFixture()
  {
    return fixture;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see junit.framework.TestCase#setUp()
   * @generated
   */
  @Override
  protected void setUp() throws Exception
  {
    setFixture(PopFactory.eINSTANCE.createDelivery());
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see junit.framework.TestCase#tearDown()
   * @generated
   */
  @Override
  protected void tearDown() throws Exception
  {
    setFixture(null);
  }

} //DeliveryTest
