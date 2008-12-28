package org.eclipse.emf.cdo.cdodefs.tests;

import org.eclipse.emf.cdo.CDOSession;
import org.eclipse.emf.cdo.cdodefs.CDODefsFactory;
import org.eclipse.emf.cdo.cdodefs.CDOSessionDef;
import org.eclipse.emf.cdo.cdodefs.util.CDODefsUtil;
import org.eclipse.emf.cdo.tests.AbstractCDOTest;
import org.eclipse.emf.cdo.tests.config.IRepositoryConfig;
import org.eclipse.emf.cdo.tests.config.impl.SessionConfig;

import org.eclipse.net4j.net4jdefs.util.Net4jDefsUtil;
import org.eclipse.net4j.util.lifecycle.LifecycleUtil;

/**
 * @author André Dietisheim
 */
public class CDOSessionDefImplTest extends AbstractCDOTest
{

  public void testNoPackageRegistryThrows()
  {
    try
    {
      CDOSessionDef cdoSessionDef = CDODefsFactory.eINSTANCE.createCDOSessionDef();
      cdoSessionDef.setConnectorDef( //
          Net4jDefsUtil.createTCPConnectorDef(SessionConfig.TCP.CONNECTOR_HOST));
      cdoSessionDef.setLegacySupportEnabled(false);
      cdoSessionDef.setRepositoryName(IRepositoryConfig.REPOSITORY_NAME);
      cdoSessionDef.getInstance();
      fail("IllegalStateException expected!");
    }
    catch (IllegalStateException e)
    {
    }
  }

  public void testConnectorAndFailOverStrategyAreMutuallyExclusive()
  {
    try
    {
      CDOSessionDef cdoSessionDef = CDODefsFactory.eINSTANCE.createCDOSessionDef();
      cdoSessionDef.setConnectorDef( //
          Net4jDefsUtil.createTCPConnectorDef(SessionConfig.TCP.CONNECTOR_HOST));
      cdoSessionDef.setFailOverStrategyDef(CDODefsFactory.eINSTANCE.createRetryFailOverStrategyDef());
      fail("IllegalStateException expected!");
    }
    catch (IllegalStateException e)
    {
    }

    try
    {
      CDOSessionDef cdoSessionDef = CDODefsFactory.eINSTANCE.createCDOSessionDef();
      cdoSessionDef.setFailOverStrategyDef(CDODefsFactory.eINSTANCE.createRetryFailOverStrategyDef());
      cdoSessionDef.setConnectorDef( //
          Net4jDefsUtil.createTCPConnectorDef(SessionConfig.TCP.CONNECTOR_HOST));
      fail("IllegalStateException expected!");
    }
    catch (IllegalStateException e)
    {
    }
  }

  public void testConnectorAndFailMayBeUnset()
  {
    try
    {
      CDOSessionDef cdoSessionDef = CDODefsFactory.eINSTANCE.createCDOSessionDef();
      cdoSessionDef.setFailOverStrategyDef(CDODefsFactory.eINSTANCE.createRetryFailOverStrategyDef());
      cdoSessionDef.unsetFailOverStrategyDef();
      cdoSessionDef.setConnectorDef( //
          Net4jDefsUtil.createTCPConnectorDef(SessionConfig.TCP.CONNECTOR_HOST));
    }
    catch (IllegalStateException e)
    {
      fail("IllegalStateException occured!");
    }

    try
    {
      CDOSessionDef cdoSessionDef = CDODefsFactory.eINSTANCE.createCDOSessionDef();
      cdoSessionDef.setConnectorDef( //
          Net4jDefsUtil.createTCPConnectorDef(SessionConfig.TCP.CONNECTOR_HOST));
      cdoSessionDef.unsetConnectorDef();
      cdoSessionDef.setFailOverStrategyDef(CDODefsFactory.eINSTANCE.createRetryFailOverStrategyDef());
    }
    catch (IllegalStateException e)
    {
      fail("IllegalStateException occured!");
    }
  }

  public void testSessionInstanceIsActive()
  {
    CDOSessionDef cdoSessionDef = CDODefsFactory.eINSTANCE.createCDOSessionDef();
    cdoSessionDef.setConnectorDef( //
        Net4jDefsUtil.createTCPConnectorDef(SessionConfig.TCP.CONNECTOR_HOST));
    cdoSessionDef.setLegacySupportEnabled(false);
    cdoSessionDef.setRepositoryName(IRepositoryConfig.REPOSITORY_NAME);
    cdoSessionDef.setCdoPackageRegistryDef(CDODefsUtil.createEagerPackageRegistryDef());
    CDOSession cdoSession = (CDOSession)cdoSessionDef.getInstance();
    assertTrue(LifecycleUtil.isActive(cdoSession));
  }
}
