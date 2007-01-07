package org.eclipse.emf.cdo.internal.protocol;

import org.eclipse.emf.cdo.protocol.CDOID;

/**
 * @author Eike Stepper
 */
public final class CDOIDImpl implements CDOID
{
  /**
   * TODO Stores the {@link char} value of the {@link #SEPARATOR} property.
   * <p>
   */
  public static final char SEPARATOR = ':';

  private static final int INITIAL_ID = 0;

  private static int lastTransientID = INITIAL_ID;

  /**
   * TODO Check if RID is necessary at all
   */
  private int rid;

  private int oid;

  public CDOIDImpl()
  {
    rid = 0;
    oid = --lastTransientID;
  }

  public CDOIDImpl(int rid, int oid)
  {
    this.rid = rid;
    this.oid = oid;
  }

  public CDOIDImpl(CDOID source)
  {
    this(source.getRID(), source.getOID());
  }

  public CDOIDImpl(String s)
  {
    int pos = s.indexOf(SEPARATOR);
    if (pos == -1)
    {
      throw new IllegalArgumentException("No separator: " + s);
    }

    String s1 = s.substring(0, pos - 1);
    if (s1.length() == 0)
    {
      throw new IllegalArgumentException("No RID: " + s);
    }

    String s2 = s.substring(pos + 1);
    if (s2.length() == 0)
    {
      throw new IllegalArgumentException("No OID: " + s);
    }

    rid = Integer.parseInt(s1);
    oid = Integer.parseInt(s2);
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
}