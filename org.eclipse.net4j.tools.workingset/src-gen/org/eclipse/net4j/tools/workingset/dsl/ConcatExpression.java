/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.net4j.tools.workingset.dsl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Concat Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.net4j.tools.workingset.dsl.ConcatExpression#getLeft <em>Left</em>}</li>
 *   <li>{@link org.eclipse.net4j.tools.workingset.dsl.ConcatExpression#getRight <em>Right</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.net4j.tools.workingset.dsl.DslPackage#getConcatExpression()
 * @model
 * @generated
 */
public interface ConcatExpression extends StringExpression
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
   * @see #setLeft(StringExpression)
   * @see org.eclipse.net4j.tools.workingset.dsl.DslPackage#getConcatExpression_Left()
   * @model containment="true"
   * @generated
   */
  StringExpression getLeft();

  /**
   * Sets the value of the '{@link org.eclipse.net4j.tools.workingset.dsl.ConcatExpression#getLeft <em>Left</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Left</em>' containment reference.
   * @see #getLeft()
   * @generated
   */
  void setLeft(StringExpression value);

  /**
   * Returns the value of the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Right</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Right</em>' containment reference.
   * @see #setRight(StringExpression)
   * @see org.eclipse.net4j.tools.workingset.dsl.DslPackage#getConcatExpression_Right()
   * @model containment="true"
   * @generated
   */
  StringExpression getRight();

  /**
   * Sets the value of the '{@link org.eclipse.net4j.tools.workingset.dsl.ConcatExpression#getRight <em>Right</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Right</em>' containment reference.
   * @see #getRight()
   * @generated
   */
  void setRight(StringExpression value);

} // ConcatExpression
