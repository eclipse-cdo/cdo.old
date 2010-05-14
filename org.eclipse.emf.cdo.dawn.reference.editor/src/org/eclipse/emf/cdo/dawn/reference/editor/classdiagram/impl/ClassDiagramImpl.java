/*******************************************************************************
 * Copyright (c) 2010 Martin Fluegge (Berlin, Germany).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Martin Fluegge - initial API and implementation
 ******************************************************************************/
package org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.impl;

import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.AClass;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.AInterface;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.ClassDiagram;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.ClassdiagramPackage;

import org.eclipse.emf.internal.cdo.CDOObjectImpl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Class Diagram</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.impl.ClassDiagramImpl#getTitle <em>Title</em>}</li>
 * <li>{@link org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.impl.ClassDiagramImpl#getClasses <em>Classes</em>}</li>
 * <li>{@link org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.impl.ClassDiagramImpl#getInterfaces <em>Interfaces
 * </em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class ClassDiagramImpl extends CDOObjectImpl implements ClassDiagram
{
  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  protected ClassDiagramImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return ClassdiagramPackage.Literals.CLASS_DIAGRAM;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  protected int eStaticFeatureCount()
  {
    return 0;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public String getTitle()
  {
    return (String)eGet(ClassdiagramPackage.Literals.CLASS_DIAGRAM__TITLE, true);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public void setTitle(String newTitle)
  {
    eSet(ClassdiagramPackage.Literals.CLASS_DIAGRAM__TITLE, newTitle);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @SuppressWarnings("unchecked")
  public EList<AClass> getClasses()
  {
    return (EList<AClass>)eGet(ClassdiagramPackage.Literals.CLASS_DIAGRAM__CLASSES, true);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @SuppressWarnings("unchecked")
  public EList<AInterface> getInterfaces()
  {
    return (EList<AInterface>)eGet(ClassdiagramPackage.Literals.CLASS_DIAGRAM__INTERFACES, true);
  }

} // ClassDiagramImpl
