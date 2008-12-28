package org.eclipse.net4j.defs.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests
{

  public static Test suite()
  {
    TestSuite suite = new TestSuite("Test for org.eclipse.net4j.defs");
    // $JUnit-BEGIN$

    suite.addTestSuite(TCPAcceptorDefImplTest.class);
    suite.addTestSuite(TCPConnectorDefImplTest.class);
    suite.addTestSuite(JVMAcceptorDefImplTest.class);
    suite.addTestSuite(JVMConnectorDefImplTest.class);

    // $JUnit-END$
    return suite;
  }

}
