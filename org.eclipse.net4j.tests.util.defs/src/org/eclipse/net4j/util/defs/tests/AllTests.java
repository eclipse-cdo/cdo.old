package org.eclipse.net4j.util.defs.tests;

import junit.framework.Test;
import junit.framework.TestSuite;


public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite("Tests for org.eclipse.net4j.util.defs");
		//$JUnit-BEGIN$

		suite.addTestSuite(DefImplTest.class);
		
		//$JUnit-END$
		return suite;
	}

}
