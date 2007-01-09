package org.eclipse.emf.cdo.protocol;

import org.eclipse.net4j.util.stream.ExtendedDataOutputStream;

import java.io.IOException;

/**
 * @author Eike Stepper
 */
public interface CDOID
{
  public int getRID();

  public int getOID();

  public void write(ExtendedDataOutputStream out) throws IOException;
}