/**
 * Copyright (c) 2004 - 2009 Eike Stepper (Berlin, Germany) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 *
 * $Id: MangoEditPlugin.java,v 1.6 2009-01-10 14:54:18 estepper Exp $
 */
package org.eclipse.emf.cdo.tests.mango.provider;

import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.ResourceLocator;

/**
 * This is the central singleton for the Mango edit plugin. <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public final class MangoEditPlugin extends EMFPlugin
{
  /**
   * Keep track of the singleton. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public static final MangoEditPlugin INSTANCE = new MangoEditPlugin();

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
  public MangoEditPlugin()
  {
    super(new ResourceLocator[] {});
  }

  /**
   * Returns the singleton instance of the Eclipse plugin. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @return the singleton instance.
   * @generated
   */
  @Override
  public ResourceLocator getPluginResourceLocator()
  {
    return plugin;
  }

  /**
   * Returns the singleton instance of the Eclipse plugin. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @return the singleton instance.
   * @generated
   */
  public static Implementation getPlugin()
  {
    return plugin;
  }

  /**
   * The actual implementation of the Eclipse <b>Plugin</b>. <!-- begin-user-doc --> <!-- end-user-doc -->
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
