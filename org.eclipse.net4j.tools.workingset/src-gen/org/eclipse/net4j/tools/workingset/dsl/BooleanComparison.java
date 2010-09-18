/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.net4j.tools.workingset.dsl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Boolean Comparison</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.net4j.tools.workingset.dsl.BooleanComparison#getLeft <em>Left</em>}</li>
 *   <li>{@link org.eclipse.net4j.tools.workingset.dsl.BooleanComparison#getOperator <em>Operator</em>}</li>
 *   <li>{@link org.eclipse.net4j.tools.workingset.dsl.BooleanComparison#getRight <em>Right</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.net4j.tools.workingset.dsl.DslPackage#getBooleanComparison()
 * @model
 * @generated
 */
public interface BooleanComparison extends BooleanExpression
{
  /**
   * Returns the value of the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Left</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Left</em>' containment reference.
   * @see #setLeft(BooleanExpression)
   * @see org.eclipse.net4j.tools.workingset.dsl.DslPackage#getBooleanComparison_Left()
   * @model containment="true"
   * @generated
   */
  BooleanExpression getLeft();

  /**
   * Sets the value of the '{@link org.eclipse.net4j.tools.workingset.dsl.BooleanComparison#getLeft <em>Left</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Left</em>' containment reference.
   * @see #getLeft()
   * @generated
   */
  void setLeft(BooleanExpression value);

  /**
   * Returns the value of the '<em><b>Operator</b></em>' attribute.
   * The literals are from the enumeration {@link org.eclipse.net4j.tools.workingset.dsl.ComparisonOperator}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Operator</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Operator</em>' attribute.
   * @see org.eclipse.net4j.tools.workingset.dsl.ComparisonOperator
   * @see #setOperator(ComparisonOperator)
   * @see org.eclipse.net4j.tools.workingset.dsl.DslPackage#getBooleanComparison_Operator()
   * @model
   * @generated
   */
  ComparisonOperator getOperator();

  /**
   * Sets the value of the '{@link org.eclipse.net4j.tools.workingset.dsl.BooleanComparison#getOperator <em>Operator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Operator</em>' attribute.
   * @see org.eclipse.net4j.tools.workingset.dsl.ComparisonOperator
   * @see #getOperator()
   * @generated
   */
  void setOperator(ComparisonOperator value);

  /**
   * Returns the value of the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Right</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Right</em>' containment reference.
   * @see #setRight(BooleanExpression)
   * @see org.eclipse.net4j.tools.workingset.dsl.DslPackage#getBooleanComparison_Right()
   * @model containment="true"
   * @generated
   */
  BooleanExpression getRight();

  /**
   * Sets the value of the '{@link org.eclipse.net4j.tools.workingset.dsl.BooleanComparison#getRight <em>Right</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Right</em>' containment reference.
   * @see #getRight()
   * @generated
   */
  void setRight(BooleanExpression value);

} // BooleanComparison
