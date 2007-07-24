package org.eclipse.emf.cdo.internal.protocol;

import org.eclipse.net4j.util.ImplementationError;

/**
 * @author Eike Stepper
 */
public final class CDOIDNull extends CDOIDImpl
{
  private static final long VALUE = 0L;

  public CDOIDNull()
  {
    super(VALUE);
    if (CDOIDImpl.NULL != null)
    {
      throw new ImplementationError("NULL is already created");
    }
  }

  @Override
  public boolean isNull()
  {
    return true;
  }

  @Override
  public boolean equals(Object obj)
  {
    return CDOIDImpl.NULL == obj;
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
}