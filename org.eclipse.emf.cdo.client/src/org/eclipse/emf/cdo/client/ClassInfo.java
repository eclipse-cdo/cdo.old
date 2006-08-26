/***************************************************************************
 * Copyright (c) 2004, 2005, 2006 Eike Stepper, Germany.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 **************************************************************************/
package org.eclipse.emf.cdo.client;


import org.eclipse.emf.cdo.core.CID;
import org.eclipse.emf.cdo.mapping.ClassMapping;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;


/**
 * Stores CDO related information for an associated {@link EClass} instance. <p>
 * 
 * The most important information is the mapping specification that is determined 
 * from a mapping file or from model annotations. A {@link ClassInfo} instance 
 * is always contained in a {@link PackageInfo} instance.<p>
 * 
 * A server assigned <i>class identifier</i> ({@link CID}) uniquely identifies
 * a {@link ClassInfo instance} within the scope of a {@link PackageManager}.
 * A {@link CID} is a flat integer value.<p>
 *  
 * This interface is not expected to be implemented by clients.<p>
 * 
 * @see EClass
 * @see ClassMapping
 * @see PackageInfo
 *
 * @author Eike Stepper
 */
public interface ClassInfo
{
  /**
   * Returns the {@link CID} of this {@link ClassInfo}.<p>
   *
   * @return The {@link CID} of this {@link ClassInfo}.
   */
  public int getCID();

  /**
   * For internal use only.<p>
   */
  public void setCID(int cid);

  /**
   * Returns the name of this {@link ClassInfo}.<p>
   * 
   * Identical to calling <code>getEClass().getName()</code>.<p>
   *
   * @return The name of this {@link ClassInfo}.
   */
  public String getName();

  /**
   * Returns the fully qualified name of this {@link ClassInfo}.<p>
   * 
   * Identical to calling <code>getPackageInfo().getFullName() + "." + getName()</code>.<p>
   *
   * @return The fully qualified of this {@link ClassInfo}.
   */
  public String getFullName();

  /**
   * Returns the {@link EClass} associated with this {@link ClassInfo}.<p>
   * 
   * @return The {@link EClass} associated with this {@link ClassInfo}.
   */
  public EClass getEClass();

  /**
   * Returns the parent {@link ClassInfo} of this {@link ClassInfo}.<p>
   * 
   * @return The parent {@link ClassInfo} of this {@link ClassInfo}.
   */
  public ClassInfo getParent();

  /**
   * Returns the CDO mapping specification associated with this {@link ClassInfo}.<p>
   * 
   * @return The CDO mapping specification} associated with this {@link ClassInfo}.
   */
  public ClassMapping getMapping();

  /**
   * Returns the {@link PackageInfo} containing this {@link ClassInfo}.<p>
   * 
   * @return The {@link PackageInfo} containing this {@link ClassInfo}.
   */
  public PackageInfo getPackageInfo();

  /**
   * Returns a handle to the internal array of the {@link AttributeInfo} 
   * instances contained by this {@link ClassInfo}.<p>
   * 
   * Model inheritance is not taken into account, attributes contained in the 
   * {@link ClassInfo} instance returned by {@link #getParent()} are excluded
   * from the result.<p>
   * 
   * @return The name of this {@link ClassInfo}.
   */
  public AttributeInfo[] getAttributeInfos();

  /**
   * Returns the name of this {@link ClassInfo}.<p>
   * 
   * Identical to calling <code>getEClass().getName()</code>.<p>
   *
   * @return The name of this {@link ClassInfo}.
   */
  public EReference[] getAllReferences();

  /**
   * Returns the {@link AttributeInfo} instance associated with the given 
   * {@link EAttribute} instance.<p>
   * 
   * @param eAttribute The associated {@link EAttribute} instance.<p>
   * @return The {@link AttributeInfo} instance (or <code>null</code>).<p>
   */
  public AttributeInfo getAttributeInfo(EAttribute eAttribute);

  /**
   * Returns the {@link AttributeInfo} instance associated with the given 
   * <b>Feature ID</b>.<p>
   * 
   * @param feature The associated <b>Feature ID</b>.<p>
   * @return The {@link AttributeInfo} instance (or <code>null</code>).<p>
   */
  public AttributeInfo getAttributeInfo(int feature);
}
