package org.eclipse.emf.cdo.client.ocl;


import org.eclipse.emf.ocl.helper.HelperUtil;
import org.eclipse.emf.ocl.helper.IOCLHelper;
import org.eclipse.emf.ocl.parser.EnvironmentFactory;


public final class CDOHelperUtil
{
  private CDOHelperUtil()
  {
  }

  public static IOCLHelper createOCLHelper()
  {
    return createOCLHelper(false);
  }

  public static IOCLHelper createOCLHelper(boolean globalExtents)
  {
    EnvironmentFactory environmentFactory = new org.eclipse.emf.cdo.client.ocl.internal.CDOEnvironmentFactory(
        globalExtents);
    return HelperUtil.createOCLHelper(environmentFactory);
  }
}
