package org.eclipse.net4j.util.defs.tests;

import net4jdefstests.Net4jdefstestsFactory;
import net4jdefstests.TestDef;

import org.eclipse.net4j.util.lifecycle.Lifecycle;
import org.eclipse.net4j.util.lifecycle.LifecycleException;
import org.eclipse.net4j.util.lifecycle.LifecycleUtil;
import org.eclipse.net4j.util.net4jutildefs.Def;
import org.eclipse.net4j.util.net4jutildefs.impl.DefImpl;
import org.eclipse.net4j.util.tests.AbstractOMTest;

import org.eclipse.emf.common.notify.Notifier;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class DefImplTest extends AbstractOMTest
{

  private Def def;

  @Override
  public void doSetUp()
  {
    def = new BlockingTokenDef();
  }

  public void testGetInstanceReturnsSameInstance()
  {
    Object thisInstance = def.getInstance();
    Object thatInstance = def.getInstance();
    assertTrue(thisInstance == thatInstance);
  }

  public void testInstanceCreatedIsActivated()
  {
    Object thisInstance = def.getInstance();
    assertTrue(LifecycleUtil.isActive(thisInstance));
  }

  public void testNewInstanceIsCreatedIfDefWasTouchedAfterwards() throws Exception
  {
    Def def = new DefImpl()
    {
      @Override
      public boolean isTouched()
      {
        return true;
      }

      @Override
      protected Object createInstance()
      {
        return new String("");
      }

    };
    Object thisInstance = def.getInstance();
    Object thatInstance = def.getInstance();
    assertTrue(thatInstance != thisInstance);
  }

  public void testSameInstanceIfDefWasntTouched() throws Exception
  {
    Def def = new DefImpl()
    {
      @Override
      public boolean isTouched()
      {
        return false;
      }

      @Override
      protected Object createInstance()
      {
        return new String("");
      }
    };
    Object thisInstance = def.getInstance();
    Object thatInstance = def.getInstance();
    assertTrue(thatInstance == thisInstance);
  }

  public void testSetAttributeTouches()
  {
    TestDef def = Net4jdefstestsFactory.eINSTANCE.createTestDef();
    assertTrue(!def.isTouched());
    def.setAttribute("aValue");
    assertTrue(def.isTouched());
    def.getInstance(); // clears touched
    assertTrue(!def.isTouched());
  }

  public void testAddReferenceTouches()
  {
    TestDef def = Net4jdefstestsFactory.eINSTANCE.createTestDef();
    assertTrue(!def.isTouched());
    def.getReferences().add(Net4jdefstestsFactory.eINSTANCE.createTestDef());
    assertTrue(def.isTouched());
  }

  public void testSetInReferencedDefTouchesReferenchingDef()
  {
    TestDef def = Net4jdefstestsFactory.eINSTANCE.createTestDef();
    assertTrue(!def.isTouched());
    TestDef referencedDef = Net4jdefstestsFactory.eINSTANCE.createTestDef();
    def.getReferences().add(referencedDef);
    assertTrue(!referencedDef.isTouched());
    referencedDef.setAttribute("newValue");
    assertTrue(referencedDef.isTouched());
    assertTrue(def.isTouched());
  }

  public void testNewInstanceIsCreatedIfCurrentIsDeactivated() throws Exception
  {
    BlockingToken thisInstance = (BlockingToken)def.getInstance();
    LifecycleUtil.deactivate(thisInstance);
    // wait until instance gets deactivated
    thisInstance.waitForDeactivation();
    BlockingToken thatInstance = (BlockingToken)def.getInstance();
    assertTrue(thatInstance != thisInstance);
  }

  public void testNewInstanceIsCreatedIfCurrentIsUnset() throws Exception
  {
    BlockingToken thisInstance = (BlockingToken)def.getInstance();
    def.unsetInstance();
    // wait until instance gets deactivated
    thisInstance.waitForDeactivation();
    BlockingToken thatInstance = (BlockingToken)def.getInstance();
    assertTrue(thatInstance != thisInstance);
  }

  protected class BlockingTokenDef extends DefImpl
  {
    @Override
    protected Object createInstance()
    {
      return new BlockingToken();
    }
  }

  protected static class BlockingToken extends Lifecycle
  {
    private volatile boolean isActive = false;

    private ReentrantLock reentrantLock = new ReentrantLock();

    private Condition lockReleaseCondition = reentrantLock.newCondition();

    private long WAIT_TIMEOUT = 1000l;

    public void doActivate() throws LifecycleException
    {
      try
      {
        reentrantLock.lock();
        isActive = true;
      }
      finally
      {
        reentrantLock.unlock();
      }
    }

    public void doDeactivate()
    {
      try
      {
        reentrantLock.lock();
        isActive = false;
        lockReleaseCondition.signal();
      }
      finally
      {
        reentrantLock.unlock();
      }
    }

    /**
     * (Blocking) Wait for deactivation. The deactivation is triggered in a separate thread. This method allows you
     * blocking wait for deactivation
     * 
     * @throws InterruptedException
     *           the interrupted exception
     * @see Notifier#fireEvent
     */
    public void waitForDeactivation() throws InterruptedException
    {
      long startTime = System.currentTimeMillis();
      reentrantLock.lock();
      try
      {
        while (isActive)
        {
          if (isTimeout(startTime))
          {
            throw new IllegalStateException("was not deactivated while waiting for '" + WAIT_TIMEOUT + "'!");
          }

          reentrantLock.wait(WAIT_TIMEOUT);
        }
      }
      finally
      {
        reentrantLock.unlock();
      }
    }

    private boolean isTimeout(long startTime)
    {
      return System.currentTimeMillis() - startTime > WAIT_TIMEOUT;
    }
  }
}
