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
package org.eclipse.emf.cdo.examples.library.ui.internal;

import org.eclipse.emf.cdo.client.internal.Activator;
import org.eclipse.emf.cdo.core.CDOProtocol;

import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.ResourceLocator;

/**
 * This is the central singleton for the Library edit plugin. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public final class ExampleLibraryUIActivator extends EMFPlugin
{
  /**
   * @ADDED
   */
  public static final String RESOURCE_URI1 = CDOProtocol.PROTOCOL_SCHEME + "/cdo/test/res1";

  /**
   * @ADDED
   */
  public static final String RESOURCE_URI2 = CDOProtocol.PROTOCOL_SCHEME + "/cdo/test/res2";

  /**
   * Keep track of the singleton. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public static final ExampleLibraryUIActivator INSTANCE = new ExampleLibraryUIActivator();

  /**
   * Keep track of the singleton. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  private static Implementation plugin;

  /**
   * Create the instance. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public ExampleLibraryUIActivator()
  {
    super(new ResourceLocator[] { Activator.INSTANCE, });
  }

  /**
   * Returns the singleton instance of the Eclipse plugin. <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   * 
   * @return the singleton instance.
   * @generated
   */
  public ResourceLocator getPluginResourceLocator()
  {
    return plugin;
  }

  /**
   * Returns the singleton instance of the Eclipse plugin. <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   * 
   * @return the singleton instance.
   * @generated
   */
  public static Implementation getPlugin()
  {
    return plugin;
  }

  /**
   * The actual implementation of the Eclipse <b>Plugin</b>. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public static class Implementation extends EclipsePlugin
  {
    /**
     * Creates an instance. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Implementation()
    {
      super();

      // Remember the static instance.
      //
      plugin = this;
    }
  }

}
