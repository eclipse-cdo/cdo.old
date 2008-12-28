package org.eclipse.net4j.defs.tests;

import org.eclipse.net4j.Net4jUtil;
import org.eclipse.net4j.buffer.IBufferPool;
import org.eclipse.net4j.internal.jvm.JVMAcceptor;
import org.eclipse.net4j.jvm.IJVMAcceptor;
import org.eclipse.net4j.jvm.IJVMConnector;
import org.eclipse.net4j.net4jdefs.JVMConnectorDef;
import org.eclipse.net4j.net4jdefs.Net4jDefsFactory;
import org.eclipse.net4j.util.lifecycle.LifecycleUtil;
import org.eclipse.net4j.util.net4jutildefs.Net4jUtilDefsFactory;
import org.eclipse.net4j.util.tests.AbstractOMTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author André Dietisheim
 */
public class JVMConnectorDefImplTest extends AbstractOMTest
{

  private static final String NAME = "test1";

  public void testIncompleteInitializationThrowsIllegalArgumentException()
  {
    try
    {
      Net4jDefsFactory.eINSTANCE.createJVMConnectorDef().getInstance();
      fail("IllegalStateException expected!");
    }
    catch (IllegalStateException e)
    {
    }
  }

  public void testConnectorLaunchableOpensConnection()
  {
    IJVMAcceptor jvmAcceptor = createJVMAcceptor();

    JVMConnectorDef jvmConnectorDef = Net4jDefsFactory.eINSTANCE.createJVMConnectorDef();

    jvmConnectorDef.setBufferProvider(Net4jDefsFactory.eINSTANCE.createBufferPoolDef());
    jvmConnectorDef.setExecutorService(Net4jUtilDefsFactory.eINSTANCE.createThreadPoolDef());
    jvmConnectorDef.setName(NAME);
    IJVMConnector jvmConnector = (IJVMConnector)jvmConnectorDef.getInstance();
    jvmConnector.connect(500L);
    assertTrue(jvmConnector.isConnected());

    LifecycleUtil.deactivate(jvmConnector);
    LifecycleUtil.deactivate(jvmAcceptor);
  }

  private IJVMAcceptor createJVMAcceptor()
  {
    ExecutorService threadPool = Executors.newCachedThreadPool();
    LifecycleUtil.activate(threadPool);

    IBufferPool bufferPool = Net4jUtil.createBufferPool();
    LifecycleUtil.activate(bufferPool);

    JVMAcceptor jvmAcceptor = new JVMAcceptor();
    jvmAcceptor.setName(NAME);
    jvmAcceptor.getConfig().setBufferProvider(bufferPool);
    jvmAcceptor.getConfig().setReceiveExecutor(threadPool);
    LifecycleUtil.activate(jvmAcceptor);

    return jvmAcceptor;
  }
}
