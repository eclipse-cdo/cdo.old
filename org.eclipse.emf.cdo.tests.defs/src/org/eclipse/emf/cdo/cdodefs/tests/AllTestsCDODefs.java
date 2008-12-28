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
package org.eclipse.emf.cdo.cdodefs.tests;

import org.eclipse.emf.cdo.tests.config.impl.ConfigTest;
import org.eclipse.emf.cdo.tests.config.impl.ConfigTestSuite;

import java.util.List;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author André Dietisheim
 */
public class AllTestsCDODefs extends ConfigTestSuite
{

  public static Test suite()
  {
    return new AllTestsCDODefs().getTestSuite("CDO Defs Tests");
  }

  @Override
  protected void initConfigSuites(TestSuite parent)
  {
    addScenario(parent, COMBINED, MEM, TCP, NATIVE);
  }

  @Override
  protected void initTestClasses(List<Class<? extends ConfigTest>> testClasses)
  {
    testClasses.add(EGlobalPackageDefImplTest.class);
    testClasses.add(CDOPackageRegistryDefImplTest.class);
    testClasses.add(CDOSessionDefImplTest.class);
    testClasses.add(CDOViewDefImplTest.class);
    testClasses.add(CDOAuditDefImplTest.class);
    testClasses.add(CDOTransactionDefImplTest.class);
    testClasses.add(CDOViewDefImplTest.class);
    testClasses.add(CDOResourceDefImplTest.class);
  }
}
