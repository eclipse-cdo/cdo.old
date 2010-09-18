/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.net4j.tools.workingset.dsl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Test Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.net4j.tools.workingset.dsl.TestExpression#getProperty <em>Property</em>}</li>
 *   <li>{@link org.eclipse.net4j.tools.workingset.dsl.TestExpression#getArgs <em>Args</em>}</li>
 *   <li>{@link org.eclipse.net4j.tools.workingset.dsl.TestExpression#getExpected <em>Expected</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.net4j.tools.workingset.dsl.DslPackage#getTestExpression()
 * @model
 * @generated
 */
public interface TestExpression extends BooleanExpression
{
  /**
   * Returns the value of the '<em><b>Property</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Property</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Property</em>' attribute list.
   * @see org.eclipse.net4j.tools.workingset.dsl.DslPackage#getTestExpression_Property()
   * @model unique="false"
   * @generated
   */
  EList<String> getProperty();

  /**
   * Returns the value of the '<em><b>Args</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.net4j.tools.workingset.dsl.StringExpression}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Args</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Args</em>' containment reference list.
   * @see org.eclipse.net4j.tools.workingset.dsl.DslPackage#getTestExpression_Args()
   * @model containment="true"
   * @generated
   */
  EList<StringExpression> getArgs();

  /**
   * Returns the value of the '<em><b>Expected</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Expected</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Expected</em>' containment reference.
   * @see #setExpected(StringExpression)
   * @see org.eclipse.net4j.tools.workingset.dsl.DslPackage#getTestExpression_Expected()
   * @model containment="true"
   * @generated
   */
  StringExpression getExpected();

  /**
   * Sets the value of the '{@link org.eclipse.net4j.tools.workingset.dsl.TestExpression#getExpected <em>Expected</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expected</em>' containment reference.
   * @see #getExpected()
   * @generated
   */
  void setExpected(StringExpression value);

} // TestExpression
