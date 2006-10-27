/***************************************************************************
 * Copyright (c) 2004, 2005, 2006 Eike Stepper, Fuggerstr. 39, 10777 Berlin, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 **************************************************************************/
package org.eclipse.emf.cdo.core;


/**
 * Converts between the external and configurable internal representations of an 
 * <i>object identifier</i> ({@link OID}).<p>
 *
 * <b>Note:</b> An {@link OIDEncoder} service is needed both at server 
 * and at client side. Their bit mask configurations have to be identical 
 * under all circumstances! Exactly one {@link OIDEncoder} service is 
 * used by a CDO <code>Mapper</code> service. It's configuration
 * must match the needs of <b>all</b> applications using this 
 * <code>Mapper</code> service.<p>
 * 
 * @author Eike Stepper
 */
public interface OIDEncoder
{
  /**
   * Extracts the {@link RID} from a packed {@link OID}.<p>
   *
   * @param oid The {@link OID} value to extract the {@link RID} from.
   * @return The extracted {@link RID} value.
   */
  public int getRID(long oid);

  /**
   * Extracts the {@link OID} fragment from a packed {@link OID}.<p>
   *
   * @param oid The {@link OID} value to extract the {@link OID} fragment from.
   * @return The extracted {@link OID} fragment value.
   */
  public long getOIDFragment(long oid);

  /**
   * Computes the packed {@link OID} from a given {@link RID} and {@link OID} fragment.<p>
   *
   * @param rid The {@link RID} part.
   * @param oidFragment The {@link OID} fragment part.
   * @return The packed {@link OID} value
   */
  public long getOID(int rid, long oidFragment);

  /**
   * Computes the string representation of an {@link OID}.<p>
   *
   * @param rid The {@link RID} part of the {@link OID}.
   * @param oidFragment The {@link OID} fragment part of the {@link OID}.
   * @return The string representation of the {@link OID}.
   */
  public String toString(int rid, long oidFragment);

  /**
   * Computes the string representation of an {@link OID}.<p>
   *
   * @param oid The packed {@link OID} value.
   * @return The string representation of the {@link OID}.
   */
  public String toString(long oid);
}
