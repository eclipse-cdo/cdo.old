package org.eclipse.emf.cdo.ui.cdouidefs.tests;

import org.eclipse.emf.cdo.cdodefs.CDODefsFactory;
import org.eclipse.emf.cdo.cdodefs.CDOSessionDef;
import org.eclipse.emf.cdo.cdodefs.CDOTransactionDef;
import org.eclipse.emf.cdo.tests.AbstractCDOTest;
import org.eclipse.emf.cdo.tests.config.IRepositoryConfig;
import org.eclipse.emf.cdo.tests.config.impl.SessionConfig;

import org.eclipse.net4j.net4jdefs.Net4jDefsFactory;
import org.eclipse.net4j.net4jdefs.TCPConnectorDef;
import org.eclipse.net4j.util.net4jutildefs.Net4jUtilDefsFactory;

public class CDOEditorDefsImplTest extends AbstractCDOTest
{

  private static final String RESOURCE_TEST1 = "/test1";

  private static final String TEST_RESOURCE = "testResource";

  public void testOpenEditor()
  {

    // doesn't work yet

    // try
    // {
    //
    // CDOSessionDef cdoSessionDef = //
    // CDODefsUtil.createSessionDef( //
    // IRepositoryConfig.REPOSITORY_NAME, //
    // CDODefsUtil.createEagerPackageRegistryDef(), //
    // Net4jDefsUtil.createTCPConnectorDef(SessionConfig.TCP.CONNECTOR_HOST));
    //
    // CDOTransactionDef transactionDef = CDODefsUtil.createCDOTransactionDef(cdoSessionDef, ResourceMode.CREATE);
    // CDOTransaction transaction = (CDOTransaction)transactionDef.getInstance();
    //
    // transaction.getSession().getPackageRegistry().putEPackage(getModel1Package());
    // CDOResource resource = transaction.createResource(TEST_RESOURCE);
    //
    // transaction.commit();
    //
    // transactionDef.setCdoSessionDef(cdoSessionDef);
    //
    // CDOEditorDef cdoEditorDef = CDOUIDefsFactory.eINSTANCE.createCDOEditorDef();
    // cdoEditorDef.setEditorID(CDOEditor.EDITOR_ID);
    // cdoEditorDef.setCdoView(transactionDef);
    // cdoEditorDef.setResourcePath(RESOURCE_TEST1);
    // cdoEditorDef.getInstance();
    // }
    // catch (Exception e)
    // {
    // fail("Exception occurred when trying to open editor!");
    // }
  }

  private CDOTransactionDef createTransactionDef(CDOSessionDef cdoSessionDef)
  {
    CDOTransactionDef cdoTransactionDef = CDODefsFactory.eINSTANCE.createCDOTransactionDef();
    cdoTransactionDef.setCdoSessionDef(cdoSessionDef);
    return cdoTransactionDef;
  }

  private CDOSessionDef createSessionDef(TCPConnectorDef connectorDef)
  {
    CDOSessionDef cdoSessionDef = CDODefsFactory.eINSTANCE.createCDOSessionDef();
    cdoSessionDef.setRepositoryName(IRepositoryConfig.REPOSITORY_NAME);
    cdoSessionDef.setConnectorDef(connectorDef);
    cdoSessionDef.setCdoPackageRegistryDef(CDODefsFactory.eINSTANCE.createCDOEagerPackageRegistryDef());
    return cdoSessionDef;
  }

  private TCPConnectorDef createTCPConnector()
  {
    TCPConnectorDef connectorDef = Net4jDefsFactory.eINSTANCE.createTCPConnectorDef();
    connectorDef.setBufferProvider(Net4jDefsFactory.eINSTANCE.createBufferPoolDef());
    connectorDef.setExecutorService(Net4jUtilDefsFactory.eINSTANCE.createThreadPoolDef());
    connectorDef.setExecutorService(Net4jUtilDefsFactory.eINSTANCE.createThreadPoolDef());
    connectorDef.setTcpSelectorDef(Net4jDefsFactory.eINSTANCE.createTCPSelectorDef());
    connectorDef.setHost(SessionConfig.TCP.CONNECTOR_HOST);
    return connectorDef;
  }
}
