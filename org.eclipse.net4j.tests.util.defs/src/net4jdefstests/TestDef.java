/**
 * <copyright>
 * </copyright>
 *
 * $Id: TestDef.java,v 1.1 2008-12-28 18:07:20 estepper Exp $
 */
package net4jdefstests;

import org.eclipse.net4j.util.net4jutildefs.Def;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Test Def</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net4jdefstests.TestDef#getReferences <em>References</em>}</li>
 *   <li>{@link net4jdefstests.TestDef#getAttribute <em>Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @see net4jdefstests.Net4jdefstestsPackage#getTestDef()
 * @model
 * @generated
 */
public interface TestDef extends Def {
	/**
	 * Returns the value of the '<em><b>References</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.net4j.util.net4jutildefs.Def}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>References</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>References</em>' reference list.
	 * @see net4jdefstests.Net4jdefstestsPackage#getTestDef_References()
	 * @model
	 * @generated
	 */
	EList<Def> getReferences();

	/**
	 * Returns the value of the '<em><b>Attribute</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attribute</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attribute</em>' attribute.
	 * @see #setAttribute(String)
	 * @see net4jdefstests.Net4jdefstestsPackage#getTestDef_Attribute()
	 * @model
	 * @generated
	 */
	String getAttribute();

	/**
	 * Sets the value of the '{@link net4jdefstests.TestDef#getAttribute <em>Attribute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attribute</em>' attribute.
	 * @see #getAttribute()
	 * @generated
	 */
	void setAttribute(String value);

} // TestDef
