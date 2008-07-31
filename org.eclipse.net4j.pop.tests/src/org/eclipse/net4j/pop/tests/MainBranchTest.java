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
 * $Id: MainBranchTest.java,v 1.1 2008-07-31 12:31:36 estepper Exp $
 */
package org.eclipse.net4j.pop.tests;

import org.eclipse.net4j.pop.MainBranch;
import org.eclipse.net4j.pop.PopFactory;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Main Branch</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class MainBranchTest extends BranchTest
{

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static void main(String[] args)
  {
    TestRunner.run(MainBranchTest.class);
  }

  /**
   * Constructs a new Main Branch test case with the given name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MainBranchTest(String name)
  {
    super(name);
  }

  /**
   * Returns the fixture for this Main Branch test case.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected MainBranch getFixture()
  {
    return (MainBranch)fixture;
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
    setFixture(PopFactory.eINSTANCE.createMainBranch());
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

} //MainBranchTest
