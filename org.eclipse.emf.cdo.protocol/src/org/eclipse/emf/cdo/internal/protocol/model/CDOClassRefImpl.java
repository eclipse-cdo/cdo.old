package org.eclipse.emf.cdo.internal.protocol.model;

import org.eclipse.emf.cdo.protocol.model.CDOClassRef;

import org.eclipse.net4j.util.stream.ExtendedDataInputStream;
import org.eclipse.net4j.util.stream.ExtendedDataOutputStream;

import java.io.IOException;
import java.text.MessageFormat;

/**
 * TODO Optimize transfer of {@link CDOClassRefImpl} instances
 * 
 * @author Eike Stepper
 */
public final class CDOClassRefImpl implements CDOClassRef
{
  private String packageURI;

  private int classifierID;

  public CDOClassRefImpl(String packageURI, int classifierID)
  {
    this.packageURI = packageURI;
    this.classifierID = classifierID;
  }

  public CDOClassRefImpl(ExtendedDataInputStream in, String defaultURI) throws IOException
  {
    // TODO Optimize transfer of URIs
    packageURI = in.readString();
    if (packageURI == null)
    {
      packageURI = defaultURI;
    }

    classifierID = in.readInt();
  }

  public void write(ExtendedDataOutputStream out, String defaultURI) throws IOException
  {
    // TODO Optimize transfer of URIs
    out.writeString(packageURI.equals(defaultURI) ? null : packageURI);
    out.writeInt(classifierID);
  }

  public String getPackageURI()
  {
    return packageURI;
  }

  public int getClassifierID()
  {
    return classifierID;
  }

  @Override
  public String toString()
  {
    return MessageFormat.format("CDOClassRef({0}, {1})", packageURI, classifierID);
  }
}