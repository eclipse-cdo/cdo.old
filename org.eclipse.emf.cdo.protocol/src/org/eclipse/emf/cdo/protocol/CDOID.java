package org.eclipse.emf.cdo.protocol;

import org.eclipse.emf.cdo.internal.protocol.CDOIDImpl;

import org.eclipse.net4j.util.stream.ExtendedDataOutputStream;

import java.io.IOException;

/**
 * @author Eike Stepper
 */
public interface CDOID
{
  public static final CDOID NULL = CDOIDImpl.internalCreateNull();

  public int getRID();

  public int getOID();

  public void write(ExtendedDataOutputStream out) throws IOException;
}