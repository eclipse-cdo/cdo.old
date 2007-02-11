package org.eclipse.emf.cdo.internal.protocol;

import org.eclipse.emf.cdo.protocol.CDOID;

import org.eclipse.net4j.util.stream.ExtendedDataInputStream;
import org.eclipse.net4j.util.stream.ExtendedDataOutputStream;

import java.io.IOException;

/**
 * @author Eike Stepper
 */
public class CDOIDImpl implements CDOID
{
  private long value;

  CDOIDImpl(long value)
  {
    this.value = value;
  }

  public long getValue()
  {
    return value;
  }

  public boolean isTemporary()
  {
    return value < 0;
  }

  @Override
  public boolean equals(Object obj)
  {
    if (obj instanceof CDOIDImpl)
    {
      CDOIDImpl that = (CDOIDImpl)obj;
      return this.value == that.value;
    }

    return false;
  }

  /**
   * @see Long#hashCode()
   */
  @Override
  public int hashCode()
  {
    return (int)(value ^ (value >>> 32));
  }

  @Override
  public String toString()
  {
    return Long.toString(value);
  }

  public static CDOID create(long value)
  {
    if (value == 0)
    {
      return NULL;
    }

    return new CDOIDImpl(value);
  }

  public static CDOID copy(CDOID source)
  {
    return source;
  }

  public static CDOID parse(String s) throws NumberFormatException
  {
    long value = Long.parseLong(s);
    return create(value);
  }

  public static CDOID read(ExtendedDataInputStream in) throws IOException
  {
    long value = in.readLong();
    return create(value);
  }

  public static void write(ExtendedDataOutputStream out, CDOID id) throws IOException
  {
    out.writeLong(id == null ? 0L : id.getValue());
  }
}