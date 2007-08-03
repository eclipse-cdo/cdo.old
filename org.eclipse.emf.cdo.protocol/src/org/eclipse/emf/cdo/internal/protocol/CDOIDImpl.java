package org.eclipse.emf.cdo.internal.protocol;

import org.eclipse.emf.cdo.internal.protocol.model.CDOClassRefImpl;
import org.eclipse.emf.cdo.protocol.CDOID;
import org.eclipse.emf.cdo.protocol.CDOIDTyped;
import org.eclipse.emf.cdo.protocol.model.CDOClassRef;

import org.eclipse.net4j.util.io.ExtendedDataInputStream;
import org.eclipse.net4j.util.io.ExtendedDataOutputStream;

import java.io.IOException;

/**
 * @author Eike Stepper
 */
public class CDOIDImpl implements CDOID
{
  private static final byte BYTE_ONE = 1;

  private long value;

  CDOIDImpl(long value)
  {
    this.value = value;
  }

  public long getValue()
  {
    return value;
  }

  public boolean isNull()
  {
    return false;
  }

  public boolean isTemporary()
  {
    return value < 0;
  }

  public boolean isMeta()
  {
    return (value & BYTE_ONE) != 0;
  }

  public CDOID getNext()
  {
    return CDOIDImpl.create(value < 0 ? value - 2 : value + 2);
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
    return (int)(value ^ value >>> 32);
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

  public static CDOIDTyped create(long value, CDOClassRef type)
  {
    if (value == 0)
    {
      throw new IllegalArgumentException("value == 0");
    }

    if (type == null)
    {
      throw new IllegalArgumentException("type == null");
    }

    return new Typed(value, type);
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
    boolean typed = in.readBoolean();
    if (typed)
    {
      CDOClassRefImpl type = new CDOClassRefImpl(in, null);
      return create(value, type);
    }

    return create(value);
  }

  public static void write(ExtendedDataOutputStream out, CDOID id) throws IOException
  {
    out.writeLong(id == null ? 0L : id.getValue());
    if (id instanceof CDOIDTyped)
    {
      CDOIDTyped typed = (CDOIDTyped)id;
      out.writeBoolean(true);

      CDOClassRefImpl type = (CDOClassRefImpl)typed.getType();
      type.write(out, null);
    }
    else
    {
      out.writeBoolean(false);
    }
  }

  /**
   * @author Eike Stepper
   */
  public static class Typed extends CDOIDImpl implements CDOIDTyped
  {
    private CDOClassRef type;

    Typed(long value, CDOClassRef type)
    {
      super(value);
      this.type = type;
    }

    public CDOClassRef getType()
    {
      return type;
    }
  }
}