package org.eclipse.emf.cdo.tests.legacy;

import org.eclipse.emf.ecore.InternalEObject;

// TODO Remove me
@Deprecated
public class Main
{
  public static final boolean LISTEN = true;

  public static final boolean LOG = false;

  public static final int COUNT = LOG ? 100 : 1000000;

  public static void main(String[] args)
  {
    Hook[] hooks = createHooks(COUNT);
    writeHooks(hooks);
    readHooks(hooks);
  }

  /*
   * IMPORTANT: Compile errors in this method might indicate an old version of EMF. Legacy support is only enabled for
   * EMF with fixed bug #247130. These compile errors do not affect native models!
   */
  private static Hook[] createHooks(int count)
  {
    Hook[] hooks = new Hook[count];
    for (int i = 0; i < hooks.length; i++)
    {
      hooks[i] = LegacyFactory.eINSTANCE.createHook();
      if (LISTEN)
      {
        ((InternalEObject)hooks[i]).eReadListeners().add(listener);
        ((InternalEObject)hooks[i]).eWriteListeners().add(listener);
      }
    }

    return hooks;
  }

  private static void writeHooks(Hook[] hooks)
  {
    long start = System.currentTimeMillis();
    for (int j = 0; j < 2; j++)
    {
      for (int i = 0; i < hooks.length; i++)
      {
        hooks[i].setName("Eike");
      }
    }

    long stop = System.currentTimeMillis();
    System.out.println("Millis for " + 2 * hooks.length + " writes: " + (stop - start));
  }

  private static void readHooks(Hook[] hooks)
  {
    long start = System.currentTimeMillis();
    for (int j = 0; j < 2; j++)
    {
      for (int i = 0; i < hooks.length; i++)
      {
        hooks[i].getName();
      }
    }

    long stop = System.currentTimeMillis();
    System.out.println("Millis for " + 2 * hooks.length + " reads: " + (stop - start));
  }

  private static final ReadWriteListener listener = new ReadWriteListener();

  private static class ReadWriteListener implements InternalEObject.EReadListener, InternalEObject.EWriteListener
  {
    public void handleRead(InternalEObject object, int featureID)
    {
      if (LOG)
      {
        System.out.println("READ: " + object + "  (" + featureID + ")");
      }
    }

    public void handleWrite(InternalEObject object, int featureID)
    {
      if (LOG)
      {
        System.out.println("WRITE: " + object + "  (" + featureID + ")");
      }
    }
  }
}
