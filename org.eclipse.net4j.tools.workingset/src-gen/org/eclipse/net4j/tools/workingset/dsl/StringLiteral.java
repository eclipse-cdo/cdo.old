/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.net4j.tools.workingset.dsl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>String Literal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.net4j.tools.workingset.dsl.StringLiteral#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.net4j.tools.workingset.dsl.DslPackage#getStringLiteral()
 * @model
 * @generated
 */
public interface StringLiteral extends StringExpression
{
  /**
   * Returns the value of the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' attribute.
   * @see #setValue(String)
   * @see org.eclipse.net4j.tools.workingset.dsl.DslPackage#getStringLiteral_Value()
   * @model
   * @generated
   */
  String getValue();

  /**
   * Sets the value of the '{@link org.eclipse.net4j.tools.workingset.dsl.StringLiteral#getValue <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' attribute.
   * @see #getValue()
   * @generated
   */
  void setValue(String value);

} // StringLiteral
