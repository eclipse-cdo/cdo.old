package org.eclipse.net4j.spring.tests;


import org.eclipse.net4j.spring.tests.SampleSpringTest;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for org.eclipse.net4j.spring.tests");
//      TODO: add real JUnit tests here, as in org.eclipse.net4j.tests.AllTests.java
        suite.addTestSuite(SampleSpringTest.class);
        return suite;
	}

}
