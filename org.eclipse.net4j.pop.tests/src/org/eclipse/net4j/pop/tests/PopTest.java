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
 * $Id: PopTest.java,v 1.3 2008-08-01 07:53:24 estepper Exp $
 */
package org.eclipse.net4j.pop.tests;

import org.eclipse.net4j.pop.Pop;
import org.eclipse.net4j.pop.PopFactory;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Pop</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link org.eclipse.net4j.pop.Pop#addCommitter(java.lang.String, java.lang.String, java.lang.String, java.util.Date) <em>Add Committer</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class PopTest extends DevelopmentStreamTest
{

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static void main(String[] args)
  {
    TestRunner.run(PopTest.class);
  }

  /**
   * Constructs a new Pop test case with the given name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PopTest(String name)
  {
    super(name);
  }

  /**
   * Returns the fixture for this Pop test case.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected Pop getFixture()
  {
    return (Pop)fixture;
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
    setFixture(PopFactory.eINSTANCE.createPop());
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
   * Tests the '{@link org.eclipse.net4j.pop.Pop#addCommitter(java.lang.String, java.lang.String, java.lang.String, java.util.Date) <em>Add Committer</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.net4j.pop.Pop#addCommitter(java.lang.String, java.lang.String, java.lang.String, java.util.Date)
   * @generated
   */
  public void testAddCommitter__String_String_String_Date()
  {
    // TODO: implement this operation test method
    // Ensure that you remove @generated or mark it @generated NOT
    fail();
  }

} //PopTest
