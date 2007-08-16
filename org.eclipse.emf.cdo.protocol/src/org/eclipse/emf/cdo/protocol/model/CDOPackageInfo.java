package org.eclipse.emf.cdo.protocol.model;

import org.eclipse.emf.cdo.protocol.CDOIDRange;

/**
 * TODO Add read(), write(), ...
 * 
 * @author Eike Stepper
 */
public final class CDOPackageInfo
{
  private String packageURI;

  private boolean dynamic;

  private CDOIDRange metaIDRange;

  public CDOPackageInfo(String packageURI, boolean dynamic, CDOIDRange metaIDRange)
  {
    this.packageURI = packageURI;
    this.dynamic = dynamic;
    this.metaIDRange = metaIDRange;
  }

  public String getPackageURI()
  {
    return packageURI;
  }

  public boolean isDynamic()
  {
    return dynamic;
  }

  public CDOIDRange getMetaIDRange()
  {
    return metaIDRange;
  }
}