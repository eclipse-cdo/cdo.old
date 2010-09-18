/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.net4j.tools.workingset.dsl.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.net4j.tools.workingset.dsl.DslPackage;
import org.eclipse.net4j.tools.workingset.dsl.StringExpression;
import org.eclipse.net4j.tools.workingset.dsl.TestExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Test Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.net4j.tools.workingset.dsl.impl.TestExpressionImpl#getProperty <em>Property</em>}</li>
 *   <li>{@link org.eclipse.net4j.tools.workingset.dsl.impl.TestExpressionImpl#getArgs <em>Args</em>}</li>
 *   <li>{@link org.eclipse.net4j.tools.workingset.dsl.impl.TestExpressionImpl#getExpected <em>Expected</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TestExpressionImpl extends BooleanExpressionImpl implements TestExpression
{
  /**
   * The cached value of the '{@link #getProperty() <em>Property</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProperty()
   * @generated
   * @ordered
   */
  protected EList<String> property;

  /**
   * The cached value of the '{@link #getArgs() <em>Args</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getArgs()
   * @generated
   * @ordered
   */
  protected EList<StringExpression> args;

  /**
   * The cached value of the '{@link #getExpected() <em>Expected</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExpected()
   * @generated
   * @ordered
   */
  protected StringExpression expected;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TestExpressionImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return DslPackage.Literals.TEST_EXPRESSION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getProperty()
  {
    if (property == null)
    {
      property = new EDataTypeEList<String>(String.class, this, DslPackage.TEST_EXPRESSION__PROPERTY);
    }
    return property;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<StringExpression> getArgs()
  {
    if (args == null)
    {
      args = new EObjectContainmentEList<StringExpression>(StringExpression.class, this, DslPackage.TEST_EXPRESSION__ARGS);
    }
    return args;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StringExpression getExpected()
  {
    return expected;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetExpected(StringExpression newExpected, NotificationChain msgs)
  {
    StringExpression oldExpected = expected;
    expected = newExpected;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DslPackage.TEST_EXPRESSION__EXPECTED, oldExpected, newExpected);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExpected(StringExpression newExpected)
  {
    if (newExpected != expected)
    {
      NotificationChain msgs = null;
      if (expected != null)
        msgs = ((InternalEObject)expected).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DslPackage.TEST_EXPRESSION__EXPECTED, null, msgs);
      if (newExpected != null)
        msgs = ((InternalEObject)newExpected).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DslPackage.TEST_EXPRESSION__EXPECTED, null, msgs);
      msgs = basicSetExpected(newExpected, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.TEST_EXPRESSION__EXPECTED, newExpected, newExpected));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case DslPackage.TEST_EXPRESSION__ARGS:
        return ((InternalEList<?>)getArgs()).basicRemove(otherEnd, msgs);
      case DslPackage.TEST_EXPRESSION__EXPECTED:
        return basicSetExpected(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case DslPackage.TEST_EXPRESSION__PROPERTY:
        return getProperty();
      case DslPackage.TEST_EXPRESSION__ARGS:
        return getArgs();
      case DslPackage.TEST_EXPRESSION__EXPECTED:
        return getExpected();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case DslPackage.TEST_EXPRESSION__PROPERTY:
        getProperty().clear();
        getProperty().addAll((Collection<? extends String>)newValue);
        return;
      case DslPackage.TEST_EXPRESSION__ARGS:
        getArgs().clear();
        getArgs().addAll((Collection<? extends StringExpression>)newValue);
        return;
      case DslPackage.TEST_EXPRESSION__EXPECTED:
        setExpected((StringExpression)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case DslPackage.TEST_EXPRESSION__PROPERTY:
        getProperty().clear();
        return;
      case DslPackage.TEST_EXPRESSION__ARGS:
        getArgs().clear();
        return;
      case DslPackage.TEST_EXPRESSION__EXPECTED:
        setExpected((StringExpression)null);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case DslPackage.TEST_EXPRESSION__PROPERTY:
        return property != null && !property.isEmpty();
      case DslPackage.TEST_EXPRESSION__ARGS:
        return args != null && !args.isEmpty();
      case DslPackage.TEST_EXPRESSION__EXPECTED:
        return expected != null;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (property: ");
    result.append(property);
    result.append(')');
    return result.toString();
  }

} //TestExpressionImpl
