/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.net4j.tools.workingset.dsl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Has Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.net4j.tools.workingset.dsl.HasExpression#getKind <em>Kind</em>}</li>
 *   <li>{@link org.eclipse.net4j.tools.workingset.dsl.HasExpression#getWhat <em>What</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.net4j.tools.workingset.dsl.DslPackage#getHasExpression()
 * @model
 * @generated
 */
public interface HasExpression extends BooleanExpression
{
  /**
   * Returns the value of the '<em><b>Kind</b></em>' attribute.
   * The literals are from the enumeration {@link org.eclipse.net4j.tools.workingset.dsl.Kind}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Kind</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Kind</em>' attribute.
   * @see org.eclipse.net4j.tools.workingset.dsl.Kind
   * @see #setKind(Kind)
   * @see org.eclipse.net4j.tools.workingset.dsl.DslPackage#getHasExpression_Kind()
   * @model
   * @generated
   */
  Kind getKind();

  /**
   * Sets the value of the '{@link org.eclipse.net4j.tools.workingset.dsl.HasExpression#getKind <em>Kind</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Kind</em>' attribute.
   * @see org.eclipse.net4j.tools.workingset.dsl.Kind
   * @see #getKind()
   * @generated
   */
  void setKind(Kind value);

  /**
   * Returns the value of the '<em><b>What</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>What</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>What</em>' containment reference.
   * @see #setWhat(StringExpression)
   * @see org.eclipse.net4j.tools.workingset.dsl.DslPackage#getHasExpression_What()
   * @model containment="true"
   * @generated
   */
  StringExpression getWhat();

  /**
   * Sets the value of the '{@link org.eclipse.net4j.tools.workingset.dsl.HasExpression#getWhat <em>What</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>What</em>' containment reference.
   * @see #getWhat()
   * @generated
   */
  void setWhat(StringExpression value);

} // HasExpression
