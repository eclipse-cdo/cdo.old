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
 * $Id: MergeTest.java,v 1.1 2008-07-31 12:31:36 estepper Exp $
 */
package org.eclipse.net4j.pop.tests;

import org.eclipse.net4j.pop.Merge;
import org.eclipse.net4j.pop.PopFactory;

import junit.framework.TestCase;
import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Merge</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link org.eclipse.net4j.pop.Merge#getId() <em>Id</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class MergeTest extends TestCase
{

  /**
   * The fixture for this Merge test case.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Merge fixture = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static void main(String[] args)
  {
    TestRunner.run(MergeTest.class);
  }

  /**
   * Constructs a new Merge test case with the given name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MergeTest(String name)
  {
    super(name);
  }

  /**
   * Sets the fixture for this Merge test case.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void setFixture(Merge fixture)
  {
    this.fixture = fixture;
  }

  /**
   * Returns the fixture for this Merge test case.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Merge getFixture()
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
    setFixture(PopFactory.eINSTANCE.createMerge());
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
   * Tests the '{@link org.eclipse.net4j.pop.Merge#getId() <em>Id</em>}' feature getter.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.net4j.pop.Merge#getId()
   * @generated
   */
  public void testGetId()
  {
    // TODO: implement this feature getter test method
    // Ensure that you remove @generated or mark it @generated NOT
    fail();
  }

} //MergeTest
