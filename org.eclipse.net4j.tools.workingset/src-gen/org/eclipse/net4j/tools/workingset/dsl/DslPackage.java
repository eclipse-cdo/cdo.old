/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.net4j.tools.workingset.dsl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.net4j.tools.workingset.dsl.DslFactory
 * @model kind="package"
 * @generated
 */
public interface DslPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "dsl";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/net4j/tools/workingset";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "dsl";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  DslPackage eINSTANCE = org.eclipse.net4j.tools.workingset.dsl.impl.DslPackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.net4j.tools.workingset.dsl.impl.BooleanExpressionImpl <em>Boolean Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.net4j.tools.workingset.dsl.impl.BooleanExpressionImpl
   * @see org.eclipse.net4j.tools.workingset.dsl.impl.DslPackageImpl#getBooleanExpression()
   * @generated
   */
  int BOOLEAN_EXPRESSION = 0;

  /**
   * The number of structural features of the '<em>Boolean Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOLEAN_EXPRESSION_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.eclipse.net4j.tools.workingset.dsl.impl.BooleanLiteralImpl <em>Boolean Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.net4j.tools.workingset.dsl.impl.BooleanLiteralImpl
   * @see org.eclipse.net4j.tools.workingset.dsl.impl.DslPackageImpl#getBooleanLiteral()
   * @generated
   */
  int BOOLEAN_LITERAL = 1;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOLEAN_LITERAL__VALUE = BOOLEAN_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Boolean Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOLEAN_LITERAL_FEATURE_COUNT = BOOLEAN_EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.net4j.tools.workingset.dsl.impl.StringExpressionImpl <em>String Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.net4j.tools.workingset.dsl.impl.StringExpressionImpl
   * @see org.eclipse.net4j.tools.workingset.dsl.impl.DslPackageImpl#getStringExpression()
   * @generated
   */
  int STRING_EXPRESSION = 2;

  /**
   * The number of structural features of the '<em>String Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_EXPRESSION_FEATURE_COUNT = BOOLEAN_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.net4j.tools.workingset.dsl.impl.StringLiteralImpl <em>String Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.net4j.tools.workingset.dsl.impl.StringLiteralImpl
   * @see org.eclipse.net4j.tools.workingset.dsl.impl.DslPackageImpl#getStringLiteral()
   * @generated
   */
  int STRING_LITERAL = 3;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_LITERAL__VALUE = STRING_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>String Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_LITERAL_FEATURE_COUNT = STRING_EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.net4j.tools.workingset.dsl.impl.PropertyAccessImpl <em>Property Access</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.net4j.tools.workingset.dsl.impl.PropertyAccessImpl
   * @see org.eclipse.net4j.tools.workingset.dsl.impl.DslPackageImpl#getPropertyAccess()
   * @generated
   */
  int PROPERTY_ACCESS = 4;

  /**
   * The feature id for the '<em><b>Property</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_ACCESS__PROPERTY = STRING_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Property Access</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_ACCESS_FEATURE_COUNT = STRING_EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.net4j.tools.workingset.dsl.impl.OrExpressionImpl <em>Or Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.net4j.tools.workingset.dsl.impl.OrExpressionImpl
   * @see org.eclipse.net4j.tools.workingset.dsl.impl.DslPackageImpl#getOrExpression()
   * @generated
   */
  int OR_EXPRESSION = 5;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OR_EXPRESSION__LEFT = BOOLEAN_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OR_EXPRESSION__RIGHT = BOOLEAN_EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Or Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OR_EXPRESSION_FEATURE_COUNT = BOOLEAN_EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.net4j.tools.workingset.dsl.impl.XorExpressionImpl <em>Xor Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.net4j.tools.workingset.dsl.impl.XorExpressionImpl
   * @see org.eclipse.net4j.tools.workingset.dsl.impl.DslPackageImpl#getXorExpression()
   * @generated
   */
  int XOR_EXPRESSION = 6;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XOR_EXPRESSION__LEFT = BOOLEAN_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XOR_EXPRESSION__RIGHT = BOOLEAN_EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Xor Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XOR_EXPRESSION_FEATURE_COUNT = BOOLEAN_EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.net4j.tools.workingset.dsl.impl.AndExpressionImpl <em>And Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.net4j.tools.workingset.dsl.impl.AndExpressionImpl
   * @see org.eclipse.net4j.tools.workingset.dsl.impl.DslPackageImpl#getAndExpression()
   * @generated
   */
  int AND_EXPRESSION = 7;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND_EXPRESSION__LEFT = BOOLEAN_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND_EXPRESSION__RIGHT = BOOLEAN_EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>And Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND_EXPRESSION_FEATURE_COUNT = BOOLEAN_EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.net4j.tools.workingset.dsl.impl.BooleanComparisonImpl <em>Boolean Comparison</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.net4j.tools.workingset.dsl.impl.BooleanComparisonImpl
   * @see org.eclipse.net4j.tools.workingset.dsl.impl.DslPackageImpl#getBooleanComparison()
   * @generated
   */
  int BOOLEAN_COMPARISON = 8;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOLEAN_COMPARISON__LEFT = BOOLEAN_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOLEAN_COMPARISON__OPERATOR = BOOLEAN_EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOLEAN_COMPARISON__RIGHT = BOOLEAN_EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Boolean Comparison</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOLEAN_COMPARISON_FEATURE_COUNT = BOOLEAN_EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.eclipse.net4j.tools.workingset.dsl.impl.StringComparisonImpl <em>String Comparison</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.net4j.tools.workingset.dsl.impl.StringComparisonImpl
   * @see org.eclipse.net4j.tools.workingset.dsl.impl.DslPackageImpl#getStringComparison()
   * @generated
   */
  int STRING_COMPARISON = 9;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_COMPARISON__LEFT = BOOLEAN_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_COMPARISON__OPERATOR = BOOLEAN_EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_COMPARISON__RIGHT = BOOLEAN_EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>String Comparison</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_COMPARISON_FEATURE_COUNT = BOOLEAN_EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.eclipse.net4j.tools.workingset.dsl.impl.NotExpressionImpl <em>Not Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.net4j.tools.workingset.dsl.impl.NotExpressionImpl
   * @see org.eclipse.net4j.tools.workingset.dsl.impl.DslPackageImpl#getNotExpression()
   * @generated
   */
  int NOT_EXPRESSION = 10;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NOT_EXPRESSION__RIGHT = BOOLEAN_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Not Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NOT_EXPRESSION_FEATURE_COUNT = BOOLEAN_EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.net4j.tools.workingset.dsl.impl.IsExpressionImpl <em>Is Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.net4j.tools.workingset.dsl.impl.IsExpressionImpl
   * @see org.eclipse.net4j.tools.workingset.dsl.impl.DslPackageImpl#getIsExpression()
   * @generated
   */
  int IS_EXPRESSION = 11;

  /**
   * The feature id for the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IS_EXPRESSION__TYPE = BOOLEAN_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Is Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IS_EXPRESSION_FEATURE_COUNT = BOOLEAN_EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.net4j.tools.workingset.dsl.impl.HasExpressionImpl <em>Has Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.net4j.tools.workingset.dsl.impl.HasExpressionImpl
   * @see org.eclipse.net4j.tools.workingset.dsl.impl.DslPackageImpl#getHasExpression()
   * @generated
   */
  int HAS_EXPRESSION = 12;

  /**
   * The feature id for the '<em><b>Kind</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int HAS_EXPRESSION__KIND = BOOLEAN_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>What</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int HAS_EXPRESSION__WHAT = BOOLEAN_EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Has Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int HAS_EXPRESSION_FEATURE_COUNT = BOOLEAN_EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.net4j.tools.workingset.dsl.impl.TestExpressionImpl <em>Test Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.net4j.tools.workingset.dsl.impl.TestExpressionImpl
   * @see org.eclipse.net4j.tools.workingset.dsl.impl.DslPackageImpl#getTestExpression()
   * @generated
   */
  int TEST_EXPRESSION = 13;

  /**
   * The feature id for the '<em><b>Property</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEST_EXPRESSION__PROPERTY = BOOLEAN_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Args</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEST_EXPRESSION__ARGS = BOOLEAN_EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Expected</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEST_EXPRESSION__EXPECTED = BOOLEAN_EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Test Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEST_EXPRESSION_FEATURE_COUNT = BOOLEAN_EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.eclipse.net4j.tools.workingset.dsl.impl.ConcatExpressionImpl <em>Concat Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.net4j.tools.workingset.dsl.impl.ConcatExpressionImpl
   * @see org.eclipse.net4j.tools.workingset.dsl.impl.DslPackageImpl#getConcatExpression()
   * @generated
   */
  int CONCAT_EXPRESSION = 14;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONCAT_EXPRESSION__LEFT = STRING_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONCAT_EXPRESSION__RIGHT = STRING_EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Concat Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONCAT_EXPRESSION_FEATURE_COUNT = STRING_EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.net4j.tools.workingset.dsl.ComparisonOperator <em>Comparison Operator</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.net4j.tools.workingset.dsl.ComparisonOperator
   * @see org.eclipse.net4j.tools.workingset.dsl.impl.DslPackageImpl#getComparisonOperator()
   * @generated
   */
  int COMPARISON_OPERATOR = 15;

  /**
   * The meta object id for the '{@link org.eclipse.net4j.tools.workingset.dsl.StringOperator <em>String Operator</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.net4j.tools.workingset.dsl.StringOperator
   * @see org.eclipse.net4j.tools.workingset.dsl.impl.DslPackageImpl#getStringOperator()
   * @generated
   */
  int STRING_OPERATOR = 16;

  /**
   * The meta object id for the '{@link org.eclipse.net4j.tools.workingset.dsl.Type <em>Type</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.net4j.tools.workingset.dsl.Type
   * @see org.eclipse.net4j.tools.workingset.dsl.impl.DslPackageImpl#getType()
   * @generated
   */
  int TYPE = 17;

  /**
   * The meta object id for the '{@link org.eclipse.net4j.tools.workingset.dsl.Kind <em>Kind</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.net4j.tools.workingset.dsl.Kind
   * @see org.eclipse.net4j.tools.workingset.dsl.impl.DslPackageImpl#getKind()
   * @generated
   */
  int KIND = 18;


  /**
   * Returns the meta object for class '{@link org.eclipse.net4j.tools.workingset.dsl.BooleanExpression <em>Boolean Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Boolean Expression</em>'.
   * @see org.eclipse.net4j.tools.workingset.dsl.BooleanExpression
   * @generated
   */
  EClass getBooleanExpression();

  /**
   * Returns the meta object for class '{@link org.eclipse.net4j.tools.workingset.dsl.BooleanLiteral <em>Boolean Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Boolean Literal</em>'.
   * @see org.eclipse.net4j.tools.workingset.dsl.BooleanLiteral
   * @generated
   */
  EClass getBooleanLiteral();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.net4j.tools.workingset.dsl.BooleanLiteral#isValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.eclipse.net4j.tools.workingset.dsl.BooleanLiteral#isValue()
   * @see #getBooleanLiteral()
   * @generated
   */
  EAttribute getBooleanLiteral_Value();

  /**
   * Returns the meta object for class '{@link org.eclipse.net4j.tools.workingset.dsl.StringExpression <em>String Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>String Expression</em>'.
   * @see org.eclipse.net4j.tools.workingset.dsl.StringExpression
   * @generated
   */
  EClass getStringExpression();

  /**
   * Returns the meta object for class '{@link org.eclipse.net4j.tools.workingset.dsl.StringLiteral <em>String Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>String Literal</em>'.
   * @see org.eclipse.net4j.tools.workingset.dsl.StringLiteral
   * @generated
   */
  EClass getStringLiteral();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.net4j.tools.workingset.dsl.StringLiteral#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.eclipse.net4j.tools.workingset.dsl.StringLiteral#getValue()
   * @see #getStringLiteral()
   * @generated
   */
  EAttribute getStringLiteral_Value();

  /**
   * Returns the meta object for class '{@link org.eclipse.net4j.tools.workingset.dsl.PropertyAccess <em>Property Access</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Property Access</em>'.
   * @see org.eclipse.net4j.tools.workingset.dsl.PropertyAccess
   * @generated
   */
  EClass getPropertyAccess();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.net4j.tools.workingset.dsl.PropertyAccess#getProperty <em>Property</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Property</em>'.
   * @see org.eclipse.net4j.tools.workingset.dsl.PropertyAccess#getProperty()
   * @see #getPropertyAccess()
   * @generated
   */
  EAttribute getPropertyAccess_Property();

  /**
   * Returns the meta object for class '{@link org.eclipse.net4j.tools.workingset.dsl.OrExpression <em>Or Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Or Expression</em>'.
   * @see org.eclipse.net4j.tools.workingset.dsl.OrExpression
   * @generated
   */
  EClass getOrExpression();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.net4j.tools.workingset.dsl.OrExpression#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see org.eclipse.net4j.tools.workingset.dsl.OrExpression#getLeft()
   * @see #getOrExpression()
   * @generated
   */
  EReference getOrExpression_Left();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.net4j.tools.workingset.dsl.OrExpression#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see org.eclipse.net4j.tools.workingset.dsl.OrExpression#getRight()
   * @see #getOrExpression()
   * @generated
   */
  EReference getOrExpression_Right();

  /**
   * Returns the meta object for class '{@link org.eclipse.net4j.tools.workingset.dsl.XorExpression <em>Xor Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Xor Expression</em>'.
   * @see org.eclipse.net4j.tools.workingset.dsl.XorExpression
   * @generated
   */
  EClass getXorExpression();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.net4j.tools.workingset.dsl.XorExpression#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see org.eclipse.net4j.tools.workingset.dsl.XorExpression#getLeft()
   * @see #getXorExpression()
   * @generated
   */
  EReference getXorExpression_Left();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.net4j.tools.workingset.dsl.XorExpression#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see org.eclipse.net4j.tools.workingset.dsl.XorExpression#getRight()
   * @see #getXorExpression()
   * @generated
   */
  EReference getXorExpression_Right();

  /**
   * Returns the meta object for class '{@link org.eclipse.net4j.tools.workingset.dsl.AndExpression <em>And Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>And Expression</em>'.
   * @see org.eclipse.net4j.tools.workingset.dsl.AndExpression
   * @generated
   */
  EClass getAndExpression();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.net4j.tools.workingset.dsl.AndExpression#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see org.eclipse.net4j.tools.workingset.dsl.AndExpression#getLeft()
   * @see #getAndExpression()
   * @generated
   */
  EReference getAndExpression_Left();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.net4j.tools.workingset.dsl.AndExpression#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see org.eclipse.net4j.tools.workingset.dsl.AndExpression#getRight()
   * @see #getAndExpression()
   * @generated
   */
  EReference getAndExpression_Right();

  /**
   * Returns the meta object for class '{@link org.eclipse.net4j.tools.workingset.dsl.BooleanComparison <em>Boolean Comparison</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Boolean Comparison</em>'.
   * @see org.eclipse.net4j.tools.workingset.dsl.BooleanComparison
   * @generated
   */
  EClass getBooleanComparison();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.net4j.tools.workingset.dsl.BooleanComparison#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see org.eclipse.net4j.tools.workingset.dsl.BooleanComparison#getLeft()
   * @see #getBooleanComparison()
   * @generated
   */
  EReference getBooleanComparison_Left();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.net4j.tools.workingset.dsl.BooleanComparison#getOperator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Operator</em>'.
   * @see org.eclipse.net4j.tools.workingset.dsl.BooleanComparison#getOperator()
   * @see #getBooleanComparison()
   * @generated
   */
  EAttribute getBooleanComparison_Operator();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.net4j.tools.workingset.dsl.BooleanComparison#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see org.eclipse.net4j.tools.workingset.dsl.BooleanComparison#getRight()
   * @see #getBooleanComparison()
   * @generated
   */
  EReference getBooleanComparison_Right();

  /**
   * Returns the meta object for class '{@link org.eclipse.net4j.tools.workingset.dsl.StringComparison <em>String Comparison</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>String Comparison</em>'.
   * @see org.eclipse.net4j.tools.workingset.dsl.StringComparison
   * @generated
   */
  EClass getStringComparison();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.net4j.tools.workingset.dsl.StringComparison#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see org.eclipse.net4j.tools.workingset.dsl.StringComparison#getLeft()
   * @see #getStringComparison()
   * @generated
   */
  EReference getStringComparison_Left();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.net4j.tools.workingset.dsl.StringComparison#getOperator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Operator</em>'.
   * @see org.eclipse.net4j.tools.workingset.dsl.StringComparison#getOperator()
   * @see #getStringComparison()
   * @generated
   */
  EAttribute getStringComparison_Operator();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.net4j.tools.workingset.dsl.StringComparison#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see org.eclipse.net4j.tools.workingset.dsl.StringComparison#getRight()
   * @see #getStringComparison()
   * @generated
   */
  EReference getStringComparison_Right();

  /**
   * Returns the meta object for class '{@link org.eclipse.net4j.tools.workingset.dsl.NotExpression <em>Not Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Not Expression</em>'.
   * @see org.eclipse.net4j.tools.workingset.dsl.NotExpression
   * @generated
   */
  EClass getNotExpression();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.net4j.tools.workingset.dsl.NotExpression#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see org.eclipse.net4j.tools.workingset.dsl.NotExpression#getRight()
   * @see #getNotExpression()
   * @generated
   */
  EReference getNotExpression_Right();

  /**
   * Returns the meta object for class '{@link org.eclipse.net4j.tools.workingset.dsl.IsExpression <em>Is Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Is Expression</em>'.
   * @see org.eclipse.net4j.tools.workingset.dsl.IsExpression
   * @generated
   */
  EClass getIsExpression();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.net4j.tools.workingset.dsl.IsExpression#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type</em>'.
   * @see org.eclipse.net4j.tools.workingset.dsl.IsExpression#getType()
   * @see #getIsExpression()
   * @generated
   */
  EAttribute getIsExpression_Type();

  /**
   * Returns the meta object for class '{@link org.eclipse.net4j.tools.workingset.dsl.HasExpression <em>Has Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Has Expression</em>'.
   * @see org.eclipse.net4j.tools.workingset.dsl.HasExpression
   * @generated
   */
  EClass getHasExpression();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.net4j.tools.workingset.dsl.HasExpression#getKind <em>Kind</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Kind</em>'.
   * @see org.eclipse.net4j.tools.workingset.dsl.HasExpression#getKind()
   * @see #getHasExpression()
   * @generated
   */
  EAttribute getHasExpression_Kind();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.net4j.tools.workingset.dsl.HasExpression#getWhat <em>What</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>What</em>'.
   * @see org.eclipse.net4j.tools.workingset.dsl.HasExpression#getWhat()
   * @see #getHasExpression()
   * @generated
   */
  EReference getHasExpression_What();

  /**
   * Returns the meta object for class '{@link org.eclipse.net4j.tools.workingset.dsl.TestExpression <em>Test Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Test Expression</em>'.
   * @see org.eclipse.net4j.tools.workingset.dsl.TestExpression
   * @generated
   */
  EClass getTestExpression();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.net4j.tools.workingset.dsl.TestExpression#getProperty <em>Property</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Property</em>'.
   * @see org.eclipse.net4j.tools.workingset.dsl.TestExpression#getProperty()
   * @see #getTestExpression()
   * @generated
   */
  EAttribute getTestExpression_Property();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.net4j.tools.workingset.dsl.TestExpression#getArgs <em>Args</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Args</em>'.
   * @see org.eclipse.net4j.tools.workingset.dsl.TestExpression#getArgs()
   * @see #getTestExpression()
   * @generated
   */
  EReference getTestExpression_Args();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.net4j.tools.workingset.dsl.TestExpression#getExpected <em>Expected</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expected</em>'.
   * @see org.eclipse.net4j.tools.workingset.dsl.TestExpression#getExpected()
   * @see #getTestExpression()
   * @generated
   */
  EReference getTestExpression_Expected();

  /**
   * Returns the meta object for class '{@link org.eclipse.net4j.tools.workingset.dsl.ConcatExpression <em>Concat Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Concat Expression</em>'.
   * @see org.eclipse.net4j.tools.workingset.dsl.ConcatExpression
   * @generated
   */
  EClass getConcatExpression();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.net4j.tools.workingset.dsl.ConcatExpression#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see org.eclipse.net4j.tools.workingset.dsl.ConcatExpression#getLeft()
   * @see #getConcatExpression()
   * @generated
   */
  EReference getConcatExpression_Left();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.net4j.tools.workingset.dsl.ConcatExpression#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see org.eclipse.net4j.tools.workingset.dsl.ConcatExpression#getRight()
   * @see #getConcatExpression()
   * @generated
   */
  EReference getConcatExpression_Right();

  /**
   * Returns the meta object for enum '{@link org.eclipse.net4j.tools.workingset.dsl.ComparisonOperator <em>Comparison Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Comparison Operator</em>'.
   * @see org.eclipse.net4j.tools.workingset.dsl.ComparisonOperator
   * @generated
   */
  EEnum getComparisonOperator();

  /**
   * Returns the meta object for enum '{@link org.eclipse.net4j.tools.workingset.dsl.StringOperator <em>String Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>String Operator</em>'.
   * @see org.eclipse.net4j.tools.workingset.dsl.StringOperator
   * @generated
   */
  EEnum getStringOperator();

  /**
   * Returns the meta object for enum '{@link org.eclipse.net4j.tools.workingset.dsl.Type <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Type</em>'.
   * @see org.eclipse.net4j.tools.workingset.dsl.Type
   * @generated
   */
  EEnum getType();

  /**
   * Returns the meta object for enum '{@link org.eclipse.net4j.tools.workingset.dsl.Kind <em>Kind</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Kind</em>'.
   * @see org.eclipse.net4j.tools.workingset.dsl.Kind
   * @generated
   */
  EEnum getKind();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  DslFactory getDslFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link org.eclipse.net4j.tools.workingset.dsl.impl.BooleanExpressionImpl <em>Boolean Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.net4j.tools.workingset.dsl.impl.BooleanExpressionImpl
     * @see org.eclipse.net4j.tools.workingset.dsl.impl.DslPackageImpl#getBooleanExpression()
     * @generated
     */
    EClass BOOLEAN_EXPRESSION = eINSTANCE.getBooleanExpression();

    /**
     * The meta object literal for the '{@link org.eclipse.net4j.tools.workingset.dsl.impl.BooleanLiteralImpl <em>Boolean Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.net4j.tools.workingset.dsl.impl.BooleanLiteralImpl
     * @see org.eclipse.net4j.tools.workingset.dsl.impl.DslPackageImpl#getBooleanLiteral()
     * @generated
     */
    EClass BOOLEAN_LITERAL = eINSTANCE.getBooleanLiteral();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BOOLEAN_LITERAL__VALUE = eINSTANCE.getBooleanLiteral_Value();

    /**
     * The meta object literal for the '{@link org.eclipse.net4j.tools.workingset.dsl.impl.StringExpressionImpl <em>String Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.net4j.tools.workingset.dsl.impl.StringExpressionImpl
     * @see org.eclipse.net4j.tools.workingset.dsl.impl.DslPackageImpl#getStringExpression()
     * @generated
     */
    EClass STRING_EXPRESSION = eINSTANCE.getStringExpression();

    /**
     * The meta object literal for the '{@link org.eclipse.net4j.tools.workingset.dsl.impl.StringLiteralImpl <em>String Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.net4j.tools.workingset.dsl.impl.StringLiteralImpl
     * @see org.eclipse.net4j.tools.workingset.dsl.impl.DslPackageImpl#getStringLiteral()
     * @generated
     */
    EClass STRING_LITERAL = eINSTANCE.getStringLiteral();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STRING_LITERAL__VALUE = eINSTANCE.getStringLiteral_Value();

    /**
     * The meta object literal for the '{@link org.eclipse.net4j.tools.workingset.dsl.impl.PropertyAccessImpl <em>Property Access</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.net4j.tools.workingset.dsl.impl.PropertyAccessImpl
     * @see org.eclipse.net4j.tools.workingset.dsl.impl.DslPackageImpl#getPropertyAccess()
     * @generated
     */
    EClass PROPERTY_ACCESS = eINSTANCE.getPropertyAccess();

    /**
     * The meta object literal for the '<em><b>Property</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PROPERTY_ACCESS__PROPERTY = eINSTANCE.getPropertyAccess_Property();

    /**
     * The meta object literal for the '{@link org.eclipse.net4j.tools.workingset.dsl.impl.OrExpressionImpl <em>Or Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.net4j.tools.workingset.dsl.impl.OrExpressionImpl
     * @see org.eclipse.net4j.tools.workingset.dsl.impl.DslPackageImpl#getOrExpression()
     * @generated
     */
    EClass OR_EXPRESSION = eINSTANCE.getOrExpression();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OR_EXPRESSION__LEFT = eINSTANCE.getOrExpression_Left();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OR_EXPRESSION__RIGHT = eINSTANCE.getOrExpression_Right();

    /**
     * The meta object literal for the '{@link org.eclipse.net4j.tools.workingset.dsl.impl.XorExpressionImpl <em>Xor Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.net4j.tools.workingset.dsl.impl.XorExpressionImpl
     * @see org.eclipse.net4j.tools.workingset.dsl.impl.DslPackageImpl#getXorExpression()
     * @generated
     */
    EClass XOR_EXPRESSION = eINSTANCE.getXorExpression();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference XOR_EXPRESSION__LEFT = eINSTANCE.getXorExpression_Left();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference XOR_EXPRESSION__RIGHT = eINSTANCE.getXorExpression_Right();

    /**
     * The meta object literal for the '{@link org.eclipse.net4j.tools.workingset.dsl.impl.AndExpressionImpl <em>And Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.net4j.tools.workingset.dsl.impl.AndExpressionImpl
     * @see org.eclipse.net4j.tools.workingset.dsl.impl.DslPackageImpl#getAndExpression()
     * @generated
     */
    EClass AND_EXPRESSION = eINSTANCE.getAndExpression();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference AND_EXPRESSION__LEFT = eINSTANCE.getAndExpression_Left();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference AND_EXPRESSION__RIGHT = eINSTANCE.getAndExpression_Right();

    /**
     * The meta object literal for the '{@link org.eclipse.net4j.tools.workingset.dsl.impl.BooleanComparisonImpl <em>Boolean Comparison</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.net4j.tools.workingset.dsl.impl.BooleanComparisonImpl
     * @see org.eclipse.net4j.tools.workingset.dsl.impl.DslPackageImpl#getBooleanComparison()
     * @generated
     */
    EClass BOOLEAN_COMPARISON = eINSTANCE.getBooleanComparison();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BOOLEAN_COMPARISON__LEFT = eINSTANCE.getBooleanComparison_Left();

    /**
     * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BOOLEAN_COMPARISON__OPERATOR = eINSTANCE.getBooleanComparison_Operator();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BOOLEAN_COMPARISON__RIGHT = eINSTANCE.getBooleanComparison_Right();

    /**
     * The meta object literal for the '{@link org.eclipse.net4j.tools.workingset.dsl.impl.StringComparisonImpl <em>String Comparison</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.net4j.tools.workingset.dsl.impl.StringComparisonImpl
     * @see org.eclipse.net4j.tools.workingset.dsl.impl.DslPackageImpl#getStringComparison()
     * @generated
     */
    EClass STRING_COMPARISON = eINSTANCE.getStringComparison();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STRING_COMPARISON__LEFT = eINSTANCE.getStringComparison_Left();

    /**
     * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STRING_COMPARISON__OPERATOR = eINSTANCE.getStringComparison_Operator();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STRING_COMPARISON__RIGHT = eINSTANCE.getStringComparison_Right();

    /**
     * The meta object literal for the '{@link org.eclipse.net4j.tools.workingset.dsl.impl.NotExpressionImpl <em>Not Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.net4j.tools.workingset.dsl.impl.NotExpressionImpl
     * @see org.eclipse.net4j.tools.workingset.dsl.impl.DslPackageImpl#getNotExpression()
     * @generated
     */
    EClass NOT_EXPRESSION = eINSTANCE.getNotExpression();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NOT_EXPRESSION__RIGHT = eINSTANCE.getNotExpression_Right();

    /**
     * The meta object literal for the '{@link org.eclipse.net4j.tools.workingset.dsl.impl.IsExpressionImpl <em>Is Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.net4j.tools.workingset.dsl.impl.IsExpressionImpl
     * @see org.eclipse.net4j.tools.workingset.dsl.impl.DslPackageImpl#getIsExpression()
     * @generated
     */
    EClass IS_EXPRESSION = eINSTANCE.getIsExpression();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute IS_EXPRESSION__TYPE = eINSTANCE.getIsExpression_Type();

    /**
     * The meta object literal for the '{@link org.eclipse.net4j.tools.workingset.dsl.impl.HasExpressionImpl <em>Has Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.net4j.tools.workingset.dsl.impl.HasExpressionImpl
     * @see org.eclipse.net4j.tools.workingset.dsl.impl.DslPackageImpl#getHasExpression()
     * @generated
     */
    EClass HAS_EXPRESSION = eINSTANCE.getHasExpression();

    /**
     * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute HAS_EXPRESSION__KIND = eINSTANCE.getHasExpression_Kind();

    /**
     * The meta object literal for the '<em><b>What</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference HAS_EXPRESSION__WHAT = eINSTANCE.getHasExpression_What();

    /**
     * The meta object literal for the '{@link org.eclipse.net4j.tools.workingset.dsl.impl.TestExpressionImpl <em>Test Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.net4j.tools.workingset.dsl.impl.TestExpressionImpl
     * @see org.eclipse.net4j.tools.workingset.dsl.impl.DslPackageImpl#getTestExpression()
     * @generated
     */
    EClass TEST_EXPRESSION = eINSTANCE.getTestExpression();

    /**
     * The meta object literal for the '<em><b>Property</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TEST_EXPRESSION__PROPERTY = eINSTANCE.getTestExpression_Property();

    /**
     * The meta object literal for the '<em><b>Args</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TEST_EXPRESSION__ARGS = eINSTANCE.getTestExpression_Args();

    /**
     * The meta object literal for the '<em><b>Expected</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TEST_EXPRESSION__EXPECTED = eINSTANCE.getTestExpression_Expected();

    /**
     * The meta object literal for the '{@link org.eclipse.net4j.tools.workingset.dsl.impl.ConcatExpressionImpl <em>Concat Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.net4j.tools.workingset.dsl.impl.ConcatExpressionImpl
     * @see org.eclipse.net4j.tools.workingset.dsl.impl.DslPackageImpl#getConcatExpression()
     * @generated
     */
    EClass CONCAT_EXPRESSION = eINSTANCE.getConcatExpression();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONCAT_EXPRESSION__LEFT = eINSTANCE.getConcatExpression_Left();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONCAT_EXPRESSION__RIGHT = eINSTANCE.getConcatExpression_Right();

    /**
     * The meta object literal for the '{@link org.eclipse.net4j.tools.workingset.dsl.ComparisonOperator <em>Comparison Operator</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.net4j.tools.workingset.dsl.ComparisonOperator
     * @see org.eclipse.net4j.tools.workingset.dsl.impl.DslPackageImpl#getComparisonOperator()
     * @generated
     */
    EEnum COMPARISON_OPERATOR = eINSTANCE.getComparisonOperator();

    /**
     * The meta object literal for the '{@link org.eclipse.net4j.tools.workingset.dsl.StringOperator <em>String Operator</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.net4j.tools.workingset.dsl.StringOperator
     * @see org.eclipse.net4j.tools.workingset.dsl.impl.DslPackageImpl#getStringOperator()
     * @generated
     */
    EEnum STRING_OPERATOR = eINSTANCE.getStringOperator();

    /**
     * The meta object literal for the '{@link org.eclipse.net4j.tools.workingset.dsl.Type <em>Type</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.net4j.tools.workingset.dsl.Type
     * @see org.eclipse.net4j.tools.workingset.dsl.impl.DslPackageImpl#getType()
     * @generated
     */
    EEnum TYPE = eINSTANCE.getType();

    /**
     * The meta object literal for the '{@link org.eclipse.net4j.tools.workingset.dsl.Kind <em>Kind</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.net4j.tools.workingset.dsl.Kind
     * @see org.eclipse.net4j.tools.workingset.dsl.impl.DslPackageImpl#getKind()
     * @generated
     */
    EEnum KIND = eINSTANCE.getKind();

  }

} //DslPackage
