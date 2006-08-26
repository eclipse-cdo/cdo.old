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


import org.eclipse.emf.cdo.mapping.AttributeMapping;
import org.eclipse.emf.cdo.mapping.ClassMapping;
import org.eclipse.emf.cdo.mapping.PackageMapping;
import org.eclipse.emf.ecore.EPackage;


/**
 * Provides the CDO mapping specification for package and the contained classes 
 * and attributes.<p>
 * 
 * An instance of {@link MappingProvider} is associated with a single package. 
 * It is used by the {@link PackageManager} to associate an {@link EPackage}
 * instance with a {@link PackageInfo} instance and provide additional mapping
 * information. The mapping information is used by the CDO server to initially create
 * the tables needed for the classes and attributes in this package.<p>
 * 
 * No matter where the mapping information actually comes from, the 
 * {@link PackageManager} will serialize it to an XML file in the current
 * working directory. The name of this <i>mapping file</i> is the name of the
 * underlying Ecore model, converted to lower case, appended with <code>.xml</code>.<p>
 * 
 * This interface is expected to be implemented in order to specify different kinds
 * of sources for package structure and mapping information.<p>
 * 
 * TODO Make MappingProvider configurable (beanify).
 *
 * @see PackageManager
 * @see PackageMapping
 * @see ClassMapping
 * @see AttributeMapping
 * @author Eike Stepper
 */
public interface MappingProvider
{
  /**
   * Returns the {@link PackageMapping} for the package of this {@link MappingProvider}.<p>
   *
   * @return The {@link PackageMapping} for the package of this {@link MappingProvider}.<p>
   */
  public PackageMapping getPackageMapping();

  /**
   * Returns the {@link ClassMapping} for a class of this {@link MappingProvider}.<p>
   *
   * @param className The name of the class to return the {@link ClassMapping} for.<p>
   * @return The {@link ClassMapping} (or <code>null</code>).<p>
   */
  public ClassMapping getClassMapping(String className);

  /**
   * Returns the {@link AttributeMapping} for an attribute of this {@link MappingProvider}.<p>
   *
   * @param className The name of a class to search the attribute within.<p>
   * @param attributeName The name of the attribute to return the {@link AttributeMapping} for.<p>
   * @return The {@link AttributeMapping} (or <code>null</code>).<p>
   */
  public AttributeMapping getAttributeMapping(String className, String attributeName);
}
