package org.eclipse.net4j.defs.tests;

import org.eclipse.net4j.defs.tests.util.Net4jDefsTestUtil;
import org.eclipse.net4j.internal.tcp.TCPConnector;
import org.eclipse.net4j.net4jdefs.Net4jDefsFactory;
import org.eclipse.net4j.net4jdefs.TCPAcceptorDef;
import org.eclipse.net4j.tcp.ITCPAcceptor;
import org.eclipse.net4j.util.lifecycle.LifecycleUtil;
import org.eclipse.net4j.util.net4jutildefs.Net4jUtilDefsFactory;
import org.eclipse.net4j.util.tests.AbstractOMTest;

/**
 * @author André Dietisheim
 */
public class TCPAcceptorDefImplTest extends AbstractOMTest
{

  private static final long TIMEOUT = 10000l;

  private static final long DELAY = 500l;

  private static final String HOST = "localhost";

  private static final int PORT = 2036;

  private static final String USERID = "André";

  private static final String PASSWORD = "aPassword";

  private TCPConnector tcpConnector;

  @Override
  protected void doSetUp() throws Exception
  {
    tcpConnector = Net4jDefsTestUtil.createTCPClientConnector(HOST, PORT, Net4jDefsTestUtil.createTCPSelector());
  }

  @Override
  protected void doTearDown() throws Exception
  {
    LifecycleUtil.deactivate(tcpConnector);
  }

  public void testAcceptorDefOpensConnection()
  {
    TCPAcceptorDef tcpAcceptorDef = createTCPAcceptorDef();

    ITCPAcceptor tcpAcceptor = (ITCPAcceptor)tcpAcceptorDef.getInstance();

    assertTrue(LifecycleUtil.isActive(tcpAcceptor));

    LifecycleUtil.activate(tcpConnector);
    boolean connected = tcpConnector.waitForConnection(DELAY + TIMEOUT);

    assertTrue(connected);
    assertTrue(LifecycleUtil.isActive(tcpConnector));

    LifecycleUtil.deactivate(tcpAcceptor);
  }

  public void testCredentialsProvider()
  {
    // doesn't work yet
    // UserManager does not add its users yet
    
    // TCPAcceptorDef tcpAcceptorDef = createTCPAcceptorDef();
    //
    // User user = Net4jDefsFactory.eINSTANCE.createUser();
    // user.setUserID(USERID);
    // user.setPassword(PASSWORD);
    //
    // UserManagerDef userManagerDef = Net4jDefsFactory.eINSTANCE.createUserManagerDef();
    // userManagerDef.getUser().add(user);
    //
    // ChallengeNegotiatorDef challengeNegotiatorDef = Net4jDefsFactory.eINSTANCE.createChallengeNegotiatorDef();
    // challengeNegotiatorDef.setRandomizer(Net4jDefsFactory.eINSTANCE.createRandomizerDef());
    // challengeNegotiatorDef.setUserManager(userManagerDef);
    //
    // tcpAcceptorDef.setNegotiator(challengeNegotiatorDef);
    // ITCPAcceptor tcpAcceptor = (ITCPAcceptor)tcpAcceptorDef.getInstance();
    // assertTrue(LifecycleUtil.isActive(tcpAcceptor));
    //
    // Net4jDefsTestUtil.addNegotiator(USERID, PASSWORD, tcpConnector);
    // LifecycleUtil.activate(tcpConnector);
    //
    // boolean connected = tcpConnector.waitForConnection(DELAY + TIMEOUT);
    // assertTrue(connected);
    //
    // LifecycleUtil.deactivate(tcpConnector);
    //
    // Net4jDefsTestUtil.removeNegotiator(tcpConnector);
    // LifecycleUtil.deactivate(tcpAcceptor);
  }

  private TCPAcceptorDef createTCPAcceptorDef()
  {
    TCPAcceptorDef tcpAcceptorDef = Net4jDefsFactory.eINSTANCE.createTCPAcceptorDef();
    tcpAcceptorDef.setHost(HOST);
    tcpAcceptorDef.setPort(PORT);
    tcpAcceptorDef.setBufferProvider(Net4jDefsFactory.eINSTANCE.createBufferPoolDef());
    tcpAcceptorDef.setExecutorService(Net4jUtilDefsFactory.eINSTANCE.createThreadPoolDef());
    tcpAcceptorDef.setTcpSelectorDef(Net4jDefsFactory.eINSTANCE.createTCPSelectorDef());
    return tcpAcceptorDef;
  }

}
