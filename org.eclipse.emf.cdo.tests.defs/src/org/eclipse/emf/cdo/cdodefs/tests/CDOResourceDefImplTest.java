package org.eclipse.emf.cdo.cdodefs.tests;

import org.eclipse.emf.cdo.CDOTransaction;
import org.eclipse.emf.cdo.cdodefs.CDOResourceDef;
import org.eclipse.emf.cdo.cdodefs.CDOSessionDef;
import org.eclipse.emf.cdo.cdodefs.ResourceMode;
import org.eclipse.emf.cdo.cdodefs.util.CDODefsUtil;
import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.cdo.tests.AbstractCDOTest;
import org.eclipse.emf.cdo.tests.config.IRepositoryConfig;
import org.eclipse.emf.cdo.tests.config.impl.SessionConfig;
import org.eclipse.emf.cdo.util.InvalidURIException;

import org.eclipse.net4j.net4jdefs.util.Net4jDefsUtil;

import org.eclipse.emf.common.util.WrappedException;

public class CDOResourceDefImplTest extends AbstractCDOTest
{
  private static final String TEST_RESOURCE = "/test1";

  public void testGetOrCreateResourceCreatesIfResourceDoesNotExist()
  {
    CDOSessionDef cdoSessionDef = //
    CDODefsUtil.createSessionDef( //
        IRepositoryConfig.REPOSITORY_NAME, //
        CDODefsUtil.createEagerPackageRegistryDef(), //
        Net4jDefsUtil.createTCPConnectorDef(SessionConfig.TCP.CONNECTOR_HOST));

    CDOResourceDef resourceDef = CDODefsUtil.createCDOResourceDef(CDODefsUtil.createCDOTransactionDef(cdoSessionDef));
    resourceDef.setResourceMode(ResourceMode.GET_OR_CREATE);
    resourceDef.setPath(TEST_RESOURCE);
    CDOResource cdoResource = (CDOResource)resourceDef.getInstance();
    assertNotNull(cdoResource);

    // clean up
    CDOTransaction transaction = (CDOTransaction)resourceDef.getCdoTransaction().getInstance();
    transaction.getSession().close();
  }

  public void testGetResourceFailsIfDoesExist()
  {
    CDOSessionDef cdoSessionDef = //

    CDODefsUtil.createSessionDef( //
        IRepositoryConfig.REPOSITORY_NAME, //
        CDODefsUtil.createEagerPackageRegistryDef(), //
        Net4jDefsUtil.createTCPConnectorDef(SessionConfig.TCP.CONNECTOR_HOST));

    CDOResourceDef resourceDef = CDODefsUtil.createCDOResourceDef(//
        CDODefsUtil.createCDOTransactionDef(cdoSessionDef));
    resourceDef.setResourceMode(ResourceMode.GET);
    resourceDef.setPath(TEST_RESOURCE);
    try
    {
      CDOResource cdoResource = (CDOResource)resourceDef.getInstance();
      // assertNull(cdoResource);
      fail("Exception expected!");
    }
    catch (WrappedException e)
    {
      assertTrue(e.getCause().getClass() == InvalidURIException.class);
    }
    finally
    {
      // clean up
      CDOTransaction transaction = (CDOTransaction)resourceDef.getCdoTransaction().getInstance();
      transaction.getSession().close();
    }
  }
}
