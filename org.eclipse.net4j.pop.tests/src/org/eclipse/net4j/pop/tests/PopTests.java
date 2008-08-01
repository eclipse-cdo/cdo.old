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
 * $Id: PopTests.java,v 1.3 2008-08-01 07:53:25 estepper Exp $
 */
package org.eclipse.net4j.pop.tests;

import junit.framework.Test;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test suite for the '<em><b>pop</b></em>' package.
 * <!-- end-user-doc -->
 * @generated
 */
public class PopTests extends TestSuite
{

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static void main(String[] args)
  {
    TestRunner.run(suite());
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static Test suite()
  {
    TestSuite suite = new PopTests("pop Tests");
    suite.addTestSuite(StreamManagerTest.class);
    suite.addTestSuite(TaskStreamTest.class);
    suite.addTestSuite(MaintenanceStreamTest.class);
    suite.addTestSuite(PopTest.class);
    suite.addTestSuite(CommitterTest.class);
    suite.addTestSuite(ReleaseTest.class);
    suite.addTestSuite(MilestoneTest.class);
    suite.addTestSuite(MergeTest.class);
    return suite;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PopTests(String name)
  {
    super(name);
  }

} //PopTests
