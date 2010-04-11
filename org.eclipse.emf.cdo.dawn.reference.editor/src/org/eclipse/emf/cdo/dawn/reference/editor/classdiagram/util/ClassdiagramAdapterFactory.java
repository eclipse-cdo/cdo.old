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
package org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.util;

import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.ABasicClass;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.AClass;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.AClassChild;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.AInterface;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.AParameter;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.AnAttribute;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.AnOperation;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.ClassDiagram;
import org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.ClassdiagramPackage;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> The <b>Adapter Factory</b> for the model. It provides an adapter <code>createXXX</code>
 * method for each class of the model. <!-- end-user-doc -->
 * 
 * @see org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.ClassdiagramPackage
 * @generated
 */
public class ClassdiagramAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  protected static ClassdiagramPackage modelPackage;

  /**
   * Creates an instance of the adapter factory. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public ClassdiagramAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = ClassdiagramPackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object. <!-- begin-user-doc --> This implementation
   * returns <code>true</code> if the object is either the model's package or is an instance object of the model. <!--
   * end-user-doc -->
   * 
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object)
  {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  protected ClassdiagramSwitch<Adapter> modelSwitch = new ClassdiagramSwitch<Adapter>()
  {
    @Override
    public Adapter caseAClass(AClass object)
    {
      return createAClassAdapter();
    }

    @Override
    public Adapter caseAInterface(AInterface object)
    {
      return createAInterfaceAdapter();
    }

    @Override
    public Adapter caseClassDiagram(ClassDiagram object)
    {
      return createClassDiagramAdapter();
    }

    @Override
    public Adapter caseAnAttribute(AnAttribute object)
    {
      return createAnAttributeAdapter();
    }

    @Override
    public Adapter caseAnOperation(AnOperation object)
    {
      return createAnOperationAdapter();
    }

    @Override
    public Adapter caseABasicClass(ABasicClass object)
    {
      return createABasicClassAdapter();
    }

    @Override
    public Adapter caseAParameter(AParameter object)
    {
      return createAParameterAdapter();
    }

    @Override
    public Adapter caseAClassChild(AClassChild object)
    {
      return createAClassChildAdapter();
    }

    @Override
    public Adapter defaultCase(EObject object)
    {
      return createEObjectAdapter();
    }
  };

  /**
   * Creates an adapter for the <code>target</code>. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @param target
   *          the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target)
  {
    return modelSwitch.doSwitch((EObject)target);
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.AClass
   * <em>AClass</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
   * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   * 
   * @return the new adapter.
   * @see org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.AClass
   * @generated
   */
  public Adapter createAClassAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '
   * {@link org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.AInterface <em>AInterface</em>}'. <!-- begin-user-doc
   * --> This default implementation returns null so that we can easily ignore cases; it's useful to ignore a case when
   * inheritance will catch all the cases anyway. <!-- end-user-doc -->
   * 
   * @return the new adapter.
   * @see org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.AInterface
   * @generated
   */
  public Adapter createAInterfaceAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '
   * {@link org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.ClassDiagram <em>Class Diagram</em>}'. <!--
   * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
   * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   * 
   * @return the new adapter.
   * @see org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.ClassDiagram
   * @generated
   */
  public Adapter createClassDiagramAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '
   * {@link org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.AnAttribute <em>An Attribute</em>}'. <!--
   * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
   * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   * 
   * @return the new adapter.
   * @see org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.AnAttribute
   * @generated
   */
  public Adapter createAnAttributeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '
   * {@link org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.AnOperation <em>An Operation</em>}'. <!--
   * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
   * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   * 
   * @return the new adapter.
   * @see org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.AnOperation
   * @generated
   */
  public Adapter createAnOperationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '
   * {@link org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.ABasicClass <em>ABasic Class</em>}'. <!--
   * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
   * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   * 
   * @return the new adapter.
   * @see org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.ABasicClass
   * @generated
   */
  public Adapter createABasicClassAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '
   * {@link org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.AParameter <em>AParameter</em>}'. <!-- begin-user-doc
   * --> This default implementation returns null so that we can easily ignore cases; it's useful to ignore a case when
   * inheritance will catch all the cases anyway. <!-- end-user-doc -->
   * 
   * @return the new adapter.
   * @see org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.AParameter
   * @generated
   */
  public Adapter createAParameterAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '
   * {@link org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.AClassChild <em>AClass Child</em>}'. <!--
   * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
   * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
   * 
   * @return the new adapter.
   * @see org.eclipse.emf.cdo.dawn.reference.editor.classdiagram.AClassChild
   * @generated
   */
  public Adapter createAClassChildAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for the default case. <!-- begin-user-doc --> This default implementation returns null. <!--
   * end-user-doc -->
   * 
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter()
  {
    return null;
  }

} // ClassdiagramAdapterFactory
