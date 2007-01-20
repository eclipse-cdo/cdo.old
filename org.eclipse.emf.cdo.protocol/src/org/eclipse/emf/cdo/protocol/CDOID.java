package org.eclipse.emf.cdo.protocol;

import org.eclipse.emf.cdo.internal.protocol.CDOIDNull;

/**
 * @author Eike Stepper
 */
public interface CDOID
{
  public static final CDOID NULL = new CDOIDNull();

  public long getValue();
}