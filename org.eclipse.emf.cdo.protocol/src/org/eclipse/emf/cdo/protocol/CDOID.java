package org.eclipse.emf.cdo.protocol;

import org.eclipse.emf.cdo.internal.protocol.CDOIDNull;

/**
 * @author Eike Stepper
 */
public interface CDOID extends Comparable<CDOID>
{
  public static final CDOID NULL = new CDOIDNull();

  public long getValue();

  public boolean isNull();

  public boolean isTemporary();

  public boolean isMeta();

  public CDOID getNext();
}