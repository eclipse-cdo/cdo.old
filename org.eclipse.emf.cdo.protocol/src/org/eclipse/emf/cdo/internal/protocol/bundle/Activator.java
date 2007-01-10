package org.eclipse.emf.cdo.internal.protocol.bundle;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public final class Activator implements BundleActivator
{
  public Activator()
  {
  }

  public void start(BundleContext context) throws Exception
  {
    CDOProtocol.BUNDLE.setBundleContext(context);
  }

  public void stop(BundleContext context) throws Exception
  {
    CDOProtocol.BUNDLE.setBundleContext(null);
  }
}
