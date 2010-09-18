/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.net4j.tools.workingset.dsl.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.net4j.tools.workingset.dsl.DslPackage;
import org.eclipse.net4j.tools.workingset.dsl.HasExpression;
import org.eclipse.net4j.tools.workingset.dsl.Kind;
import org.eclipse.net4j.tools.workingset.dsl.StringExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Has Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.net4j.tools.workingset.dsl.impl.HasExpressionImpl#getKind <em>Kind</em>}</li>
 *   <li>{@link org.eclipse.net4j.tools.workingset.dsl.impl.HasExpressionImpl#getWhat <em>What</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class HasExpressionImpl extends BooleanExpressionImpl implements HasExpression
{
  /**
   * The default value of the '{@link #getKind() <em>Kind</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getKind()
   * @generated
   * @ordered
   */
  protected static final Kind KIND_EDEFAULT = Kind.REFERENCE;

  /**
   * The cached value of the '{@link #getKind() <em>Kind</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getKind()
   * @generated
   * @ordered
   */
  protected Kind kind = KIND_EDEFAULT;

  /**
   * The cached value of the '{@link #getWhat() <em>What</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getWhat()
   * @generated
   * @ordered
   */
  protected StringExpression what;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected HasExpressionImpl()
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
    return DslPackage.Literals.HAS_EXPRESSION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Kind getKind()
  {
    return kind;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setKind(Kind newKind)
  {
    Kind oldKind = kind;
    kind = newKind == null ? KIND_EDEFAULT : newKind;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.HAS_EXPRESSION__KIND, oldKind, kind));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StringExpression getWhat()
  {
    return what;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetWhat(StringExpression newWhat, NotificationChain msgs)
  {
    StringExpression oldWhat = what;
    what = newWhat;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DslPackage.HAS_EXPRESSION__WHAT, oldWhat, newWhat);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setWhat(StringExpression newWhat)
  {
    if (newWhat != what)
    {
      NotificationChain msgs = null;
      if (what != null)
        msgs = ((InternalEObject)what).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DslPackage.HAS_EXPRESSION__WHAT, null, msgs);
      if (newWhat != null)
        msgs = ((InternalEObject)newWhat).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DslPackage.HAS_EXPRESSION__WHAT, null, msgs);
      msgs = basicSetWhat(newWhat, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.HAS_EXPRESSION__WHAT, newWhat, newWhat));
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
      case DslPackage.HAS_EXPRESSION__WHAT:
        return basicSetWhat(null, msgs);
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
      case DslPackage.HAS_EXPRESSION__KIND:
        return getKind();
      case DslPackage.HAS_EXPRESSION__WHAT:
        return getWhat();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case DslPackage.HAS_EXPRESSION__KIND:
        setKind((Kind)newValue);
        return;
      case DslPackage.HAS_EXPRESSION__WHAT:
        setWhat((StringExpression)newValue);
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
      case DslPackage.HAS_EXPRESSION__KIND:
        setKind(KIND_EDEFAULT);
        return;
      case DslPackage.HAS_EXPRESSION__WHAT:
        setWhat((StringExpression)null);
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
      case DslPackage.HAS_EXPRESSION__KIND:
        return kind != KIND_EDEFAULT;
      case DslPackage.HAS_EXPRESSION__WHAT:
        return what != null;
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
    result.append(" (kind: ");
    result.append(kind);
    result.append(')');
    return result.toString();
  }

} //HasExpressionImpl
