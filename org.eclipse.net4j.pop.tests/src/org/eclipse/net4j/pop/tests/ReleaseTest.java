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
 * $Id: ReleaseTest.java,v 1.3 2008-08-01 07:53:26 estepper Exp $
 */
package org.eclipse.net4j.pop.tests;

import org.eclipse.net4j.pop.PopFactory;
import org.eclipse.net4j.pop.Release;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Release</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link org.eclipse.net4j.pop.Release#startMaintenance() <em>Start Maintenance</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class ReleaseTest extends TargetTest
{

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static void main(String[] args)
  {
    TestRunner.run(ReleaseTest.class);
  }

  /**
   * Constructs a new Release test case with the given name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ReleaseTest(String name)
  {
    super(name);
  }

  /**
   * Returns the fixture for this Release test case.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected Release getFixture()
  {
    return (Release)fixture;
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
    setFixture(PopFactory.eINSTANCE.createRelease());
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

  /**
   * Tests the '{@link org.eclipse.net4j.pop.Release#startMaintenance() <em>Start Maintenance</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.net4j.pop.Release#startMaintenance()
   * @generated
   */
  public void testStartMaintenance()
  {
    // TODO: implement this operation test method
    // Ensure that you remove @generated or mark it @generated NOT
    fail();
  }

} //ReleaseTest
