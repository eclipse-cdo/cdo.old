package org.eclipse.net4j.tools.workingset;


/**
 * Initialization support for running Xtext languages without equinox extension registry
 */
public class DslStandaloneSetup extends DslStandaloneSetupGenerated
{

  public static void doSetup()
  {
    new DslStandaloneSetup().createInjectorAndDoEMFRegistration();
  }
}
