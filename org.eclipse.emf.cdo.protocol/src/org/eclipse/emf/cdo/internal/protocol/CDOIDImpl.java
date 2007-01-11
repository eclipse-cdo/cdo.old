package org.eclipse.emf.cdo.internal.protocol;

import org.eclipse.emf.cdo.protocol.CDOID;
import org.eclipse.emf.cdo.protocol.util.ImplementationError;

import org.eclipse.net4j.util.stream.ExtendedDataInputStream;
import org.eclipse.net4j.util.stream.ExtendedDataOutputStream;

import java.io.IOException;

/**
 * @author Eike Stepper
 */
public final class CDOIDImpl implements CDOID
{
  private static final char SEPARATOR = ':';

  private static final int INITIAL_ID = 0;

  private static int lastTransientID = INITIAL_ID;

  private static boolean NULL_CREATED;

  /**
   * TODO Check if RID is necessary at all
   */
  private int rid;

  private int oid;

  private CDOIDImpl(int rid, int oid)
  {
    this.rid = rid;
    this.oid = oid;
  }

  public int getRID()
  {
    return rid;
  }

  public void setRID(int rid)
  {
    this.rid = rid;
  }

  public int getOID()
  {
    return oid;
  }

  public void setOID(int oid)
  {
    this.oid = oid;
  }

  public void write(ExtendedDataOutputStream out) throws IOException
  {
    out.writeInt(rid);
    out.writeInt(oid);
  }

  @Override
  public boolean equals(Object obj)
  {
    if (obj instanceof CDOIDImpl)
    {
      CDOIDImpl that = (CDOIDImpl)obj;
      return this.rid == that.rid && this.oid == that.oid;
    }

    return false;
  }

  @Override
  public int hashCode()
  {
    return rid ^ oid;
  }

  @Override
  public String toString()
  {
    return "" + rid + SEPARATOR + oid;
  }

  public static void internalReset()
  {
    lastTransientID = INITIAL_ID;
  }

  public static CDOID createNew()
  {
    return new CDOIDImpl(0, --lastTransientID);
  }

  public static CDOID create(int rid, int oid)
  {
    if (rid == 0 && oid == 0)
    {
      return NULL;
    }

    return new CDOIDImpl(rid, oid);
  }

  public static CDOID copy(CDOID source)
  {
    return source;
    // return create(((CDOIDImpl)source).rid, ((CDOIDImpl)source).oid);
  }

  public static CDOID read(ExtendedDataInputStream in) throws IOException
  {
    int rid = in.readInt();
    int oid = in.readInt();
    return create(rid, oid);
  }

  public static CDOID parse(String s) throws NumberFormatException
  {
    int pos = s.indexOf(SEPARATOR);
    if (pos == -1)
    {
      throw new NumberFormatException("No separator: " + s);
    }

    String s1 = s.substring(0, pos - 1);
    if (s1.length() == 0)
    {
      throw new NumberFormatException("No RID: " + s);
    }

    String s2 = s.substring(pos + 1);
    if (s2.length() == 0)
    {
      throw new NumberFormatException("No OID: " + s);
    }

    int rid = Integer.parseInt(s1);
    int oid = Integer.parseInt(s2);
    return create(rid, oid);
  }

  public static CDOID internalCreateNull()
  {
    if (NULL_CREATED)
    {
      throw new ImplementationError("NULL is already created");
    }

    NULL_CREATED = true;
    return new CDOID()
    {
      public int getOID()
      {
        return 0;
      }

      public int getRID()
      {
        return 0;
      }

      public void write(ExtendedDataOutputStream out) throws IOException
      {
        out.writeInt(0);
        out.writeInt(0);
      }

      @Override
      public boolean equals(Object obj)
      {
        return NULL == obj;
      }

      @Override
      public int hashCode()
      {
        return 0;
      }

      @Override
      public String toString()
      {
        return "NULL";
      }
    };
  }
}