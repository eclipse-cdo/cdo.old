/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.net4j.tools.workingset.dsl.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.net4j.tools.workingset.dsl.AndExpression;
import org.eclipse.net4j.tools.workingset.dsl.BooleanComparison;
import org.eclipse.net4j.tools.workingset.dsl.BooleanExpression;
import org.eclipse.net4j.tools.workingset.dsl.BooleanLiteral;
import org.eclipse.net4j.tools.workingset.dsl.ComparisonOperator;
import org.eclipse.net4j.tools.workingset.dsl.ConcatExpression;
import org.eclipse.net4j.tools.workingset.dsl.DslFactory;
import org.eclipse.net4j.tools.workingset.dsl.DslPackage;
import org.eclipse.net4j.tools.workingset.dsl.HasExpression;
import org.eclipse.net4j.tools.workingset.dsl.IsExpression;
import org.eclipse.net4j.tools.workingset.dsl.Kind;
import org.eclipse.net4j.tools.workingset.dsl.NotExpression;
import org.eclipse.net4j.tools.workingset.dsl.OrExpression;
import org.eclipse.net4j.tools.workingset.dsl.PropertyAccess;
import org.eclipse.net4j.tools.workingset.dsl.StringComparison;
import org.eclipse.net4j.tools.workingset.dsl.StringExpression;
import org.eclipse.net4j.tools.workingset.dsl.StringLiteral;
import org.eclipse.net4j.tools.workingset.dsl.StringOperator;
import org.eclipse.net4j.tools.workingset.dsl.TestExpression;
import org.eclipse.net4j.tools.workingset.dsl.Type;
import org.eclipse.net4j.tools.workingset.dsl.XorExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DslPackageImpl extends EPackageImpl implements DslPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass booleanExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass booleanLiteralEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass stringExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass stringLiteralEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass propertyAccessEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass orExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass xorExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass andExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass booleanComparisonEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass stringComparisonEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass notExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass isExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass hasExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass testExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass concatExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum comparisonOperatorEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum stringOperatorEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum typeEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum kindEEnum = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see org.eclipse.net4j.tools.workingset.dsl.DslPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private DslPackageImpl()
  {
    super(eNS_URI, DslFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   * 
   * <p>This method is used to initialize {@link DslPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static DslPackage init()
  {
    if (isInited) return (DslPackage)EPackage.Registry.INSTANCE.getEPackage(DslPackage.eNS_URI);

    // Obtain or create and register package
    DslPackageImpl theDslPackage = (DslPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof DslPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new DslPackageImpl());

    isInited = true;

    // Create package meta-data objects
    theDslPackage.createPackageContents();

    // Initialize created meta-data
    theDslPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theDslPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(DslPackage.eNS_URI, theDslPackage);
    return theDslPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBooleanExpression()
  {
    return booleanExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBooleanLiteral()
  {
    return booleanLiteralEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getBooleanLiteral_Value()
  {
    return (EAttribute)booleanLiteralEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getStringExpression()
  {
    return stringExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getStringLiteral()
  {
    return stringLiteralEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getStringLiteral_Value()
  {
    return (EAttribute)stringLiteralEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPropertyAccess()
  {
    return propertyAccessEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPropertyAccess_Property()
  {
    return (EAttribute)propertyAccessEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getOrExpression()
  {
    return orExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOrExpression_Left()
  {
    return (EReference)orExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOrExpression_Right()
  {
    return (EReference)orExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getXorExpression()
  {
    return xorExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getXorExpression_Left()
  {
    return (EReference)xorExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getXorExpression_Right()
  {
    return (EReference)xorExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAndExpression()
  {
    return andExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAndExpression_Left()
  {
    return (EReference)andExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAndExpression_Right()
  {
    return (EReference)andExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBooleanComparison()
  {
    return booleanComparisonEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBooleanComparison_Left()
  {
    return (EReference)booleanComparisonEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getBooleanComparison_Operator()
  {
    return (EAttribute)booleanComparisonEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBooleanComparison_Right()
  {
    return (EReference)booleanComparisonEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getStringComparison()
  {
    return stringComparisonEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStringComparison_Left()
  {
    return (EReference)stringComparisonEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getStringComparison_Operator()
  {
    return (EAttribute)stringComparisonEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStringComparison_Right()
  {
    return (EReference)stringComparisonEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNotExpression()
  {
    return notExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNotExpression_Right()
  {
    return (EReference)notExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getIsExpression()
  {
    return isExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getIsExpression_Type()
  {
    return (EAttribute)isExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getHasExpression()
  {
    return hasExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getHasExpression_Kind()
  {
    return (EAttribute)hasExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getHasExpression_What()
  {
    return (EReference)hasExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTestExpression()
  {
    return testExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTestExpression_Property()
  {
    return (EAttribute)testExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTestExpression_Args()
  {
    return (EReference)testExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTestExpression_Expected()
  {
    return (EReference)testExpressionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getConcatExpression()
  {
    return concatExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getConcatExpression_Left()
  {
    return (EReference)concatExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getConcatExpression_Right()
  {
    return (EReference)concatExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getComparisonOperator()
  {
    return comparisonOperatorEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getStringOperator()
  {
    return stringOperatorEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getType()
  {
    return typeEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getKind()
  {
    return kindEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DslFactory getDslFactory()
  {
    return (DslFactory)getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void createPackageContents()
  {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    booleanExpressionEClass = createEClass(BOOLEAN_EXPRESSION);

    booleanLiteralEClass = createEClass(BOOLEAN_LITERAL);
    createEAttribute(booleanLiteralEClass, BOOLEAN_LITERAL__VALUE);

    stringExpressionEClass = createEClass(STRING_EXPRESSION);

    stringLiteralEClass = createEClass(STRING_LITERAL);
    createEAttribute(stringLiteralEClass, STRING_LITERAL__VALUE);

    propertyAccessEClass = createEClass(PROPERTY_ACCESS);
    createEAttribute(propertyAccessEClass, PROPERTY_ACCESS__PROPERTY);

    orExpressionEClass = createEClass(OR_EXPRESSION);
    createEReference(orExpressionEClass, OR_EXPRESSION__LEFT);
    createEReference(orExpressionEClass, OR_EXPRESSION__RIGHT);

    xorExpressionEClass = createEClass(XOR_EXPRESSION);
    createEReference(xorExpressionEClass, XOR_EXPRESSION__LEFT);
    createEReference(xorExpressionEClass, XOR_EXPRESSION__RIGHT);

    andExpressionEClass = createEClass(AND_EXPRESSION);
    createEReference(andExpressionEClass, AND_EXPRESSION__LEFT);
    createEReference(andExpressionEClass, AND_EXPRESSION__RIGHT);

    booleanComparisonEClass = createEClass(BOOLEAN_COMPARISON);
    createEReference(booleanComparisonEClass, BOOLEAN_COMPARISON__LEFT);
    createEAttribute(booleanComparisonEClass, BOOLEAN_COMPARISON__OPERATOR);
    createEReference(booleanComparisonEClass, BOOLEAN_COMPARISON__RIGHT);

    stringComparisonEClass = createEClass(STRING_COMPARISON);
    createEReference(stringComparisonEClass, STRING_COMPARISON__LEFT);
    createEAttribute(stringComparisonEClass, STRING_COMPARISON__OPERATOR);
    createEReference(stringComparisonEClass, STRING_COMPARISON__RIGHT);

    notExpressionEClass = createEClass(NOT_EXPRESSION);
    createEReference(notExpressionEClass, NOT_EXPRESSION__RIGHT);

    isExpressionEClass = createEClass(IS_EXPRESSION);
    createEAttribute(isExpressionEClass, IS_EXPRESSION__TYPE);

    hasExpressionEClass = createEClass(HAS_EXPRESSION);
    createEAttribute(hasExpressionEClass, HAS_EXPRESSION__KIND);
    createEReference(hasExpressionEClass, HAS_EXPRESSION__WHAT);

    testExpressionEClass = createEClass(TEST_EXPRESSION);
    createEAttribute(testExpressionEClass, TEST_EXPRESSION__PROPERTY);
    createEReference(testExpressionEClass, TEST_EXPRESSION__ARGS);
    createEReference(testExpressionEClass, TEST_EXPRESSION__EXPECTED);

    concatExpressionEClass = createEClass(CONCAT_EXPRESSION);
    createEReference(concatExpressionEClass, CONCAT_EXPRESSION__LEFT);
    createEReference(concatExpressionEClass, CONCAT_EXPRESSION__RIGHT);

    // Create enums
    comparisonOperatorEEnum = createEEnum(COMPARISON_OPERATOR);
    stringOperatorEEnum = createEEnum(STRING_OPERATOR);
    typeEEnum = createEEnum(TYPE);
    kindEEnum = createEEnum(KIND);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void initializePackageContents()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    booleanLiteralEClass.getESuperTypes().add(this.getBooleanExpression());
    stringExpressionEClass.getESuperTypes().add(this.getBooleanExpression());
    stringLiteralEClass.getESuperTypes().add(this.getStringExpression());
    propertyAccessEClass.getESuperTypes().add(this.getStringExpression());
    orExpressionEClass.getESuperTypes().add(this.getBooleanExpression());
    xorExpressionEClass.getESuperTypes().add(this.getBooleanExpression());
    andExpressionEClass.getESuperTypes().add(this.getBooleanExpression());
    booleanComparisonEClass.getESuperTypes().add(this.getBooleanExpression());
    stringComparisonEClass.getESuperTypes().add(this.getBooleanExpression());
    notExpressionEClass.getESuperTypes().add(this.getBooleanExpression());
    isExpressionEClass.getESuperTypes().add(this.getBooleanExpression());
    hasExpressionEClass.getESuperTypes().add(this.getBooleanExpression());
    testExpressionEClass.getESuperTypes().add(this.getBooleanExpression());
    concatExpressionEClass.getESuperTypes().add(this.getStringExpression());

    // Initialize classes and features; add operations and parameters
    initEClass(booleanExpressionEClass, BooleanExpression.class, "BooleanExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(booleanLiteralEClass, BooleanLiteral.class, "BooleanLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getBooleanLiteral_Value(), ecorePackage.getEBoolean(), "value", null, 0, 1, BooleanLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(stringExpressionEClass, StringExpression.class, "StringExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(stringLiteralEClass, StringLiteral.class, "StringLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getStringLiteral_Value(), ecorePackage.getEString(), "value", null, 0, 1, StringLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(propertyAccessEClass, PropertyAccess.class, "PropertyAccess", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getPropertyAccess_Property(), ecorePackage.getEString(), "property", null, 0, 1, PropertyAccess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(orExpressionEClass, OrExpression.class, "OrExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getOrExpression_Left(), this.getBooleanExpression(), null, "left", null, 0, 1, OrExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getOrExpression_Right(), this.getBooleanExpression(), null, "right", null, 0, 1, OrExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(xorExpressionEClass, XorExpression.class, "XorExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getXorExpression_Left(), this.getBooleanExpression(), null, "left", null, 0, 1, XorExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getXorExpression_Right(), this.getBooleanExpression(), null, "right", null, 0, 1, XorExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(andExpressionEClass, AndExpression.class, "AndExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAndExpression_Left(), this.getBooleanExpression(), null, "left", null, 0, 1, AndExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAndExpression_Right(), this.getBooleanExpression(), null, "right", null, 0, 1, AndExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(booleanComparisonEClass, BooleanComparison.class, "BooleanComparison", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getBooleanComparison_Left(), this.getBooleanExpression(), null, "left", null, 0, 1, BooleanComparison.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getBooleanComparison_Operator(), this.getComparisonOperator(), "operator", null, 0, 1, BooleanComparison.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getBooleanComparison_Right(), this.getBooleanExpression(), null, "right", null, 0, 1, BooleanComparison.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(stringComparisonEClass, StringComparison.class, "StringComparison", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getStringComparison_Left(), this.getStringExpression(), null, "left", null, 0, 1, StringComparison.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getStringComparison_Operator(), this.getStringOperator(), "operator", null, 0, 1, StringComparison.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getStringComparison_Right(), this.getStringExpression(), null, "right", null, 0, 1, StringComparison.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(notExpressionEClass, NotExpression.class, "NotExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getNotExpression_Right(), this.getBooleanExpression(), null, "right", null, 0, 1, NotExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(isExpressionEClass, IsExpression.class, "IsExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getIsExpression_Type(), this.getType(), "type", null, 0, 1, IsExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(hasExpressionEClass, HasExpression.class, "HasExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getHasExpression_Kind(), this.getKind(), "kind", null, 0, 1, HasExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getHasExpression_What(), this.getStringExpression(), null, "what", null, 0, 1, HasExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(testExpressionEClass, TestExpression.class, "TestExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTestExpression_Property(), ecorePackage.getEString(), "property", null, 0, -1, TestExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTestExpression_Args(), this.getStringExpression(), null, "args", null, 0, -1, TestExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTestExpression_Expected(), this.getStringExpression(), null, "expected", null, 0, 1, TestExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(concatExpressionEClass, ConcatExpression.class, "ConcatExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getConcatExpression_Left(), this.getStringExpression(), null, "left", null, 0, 1, ConcatExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getConcatExpression_Right(), this.getStringExpression(), null, "right", null, 0, 1, ConcatExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Initialize enums and add enum literals
    initEEnum(comparisonOperatorEEnum, ComparisonOperator.class, "ComparisonOperator");
    addEEnumLiteral(comparisonOperatorEEnum, ComparisonOperator.EQ);
    addEEnumLiteral(comparisonOperatorEEnum, ComparisonOperator.EQ2);
    addEEnumLiteral(comparisonOperatorEEnum, ComparisonOperator.NE);
    addEEnumLiteral(comparisonOperatorEEnum, ComparisonOperator.NE2);
    addEEnumLiteral(comparisonOperatorEEnum, ComparisonOperator.GT);
    addEEnumLiteral(comparisonOperatorEEnum, ComparisonOperator.GE);
    addEEnumLiteral(comparisonOperatorEEnum, ComparisonOperator.LT);
    addEEnumLiteral(comparisonOperatorEEnum, ComparisonOperator.LE);

    initEEnum(stringOperatorEEnum, StringOperator.class, "StringOperator");
    addEEnumLiteral(stringOperatorEEnum, StringOperator.EQ);
    addEEnumLiteral(stringOperatorEEnum, StringOperator.EQ2);
    addEEnumLiteral(stringOperatorEEnum, StringOperator.NE);
    addEEnumLiteral(stringOperatorEEnum, StringOperator.NE2);
    addEEnumLiteral(stringOperatorEEnum, StringOperator.GT);
    addEEnumLiteral(stringOperatorEEnum, StringOperator.GE);
    addEEnumLiteral(stringOperatorEEnum, StringOperator.LT);
    addEEnumLiteral(stringOperatorEEnum, StringOperator.LE);
    addEEnumLiteral(stringOperatorEEnum, StringOperator.LIKE);
    addEEnumLiteral(stringOperatorEEnum, StringOperator.LIKE2);
    addEEnumLiteral(stringOperatorEEnum, StringOperator.UNLIKE);
    addEEnumLiteral(stringOperatorEEnum, StringOperator.UNLIKE2);
    addEEnumLiteral(stringOperatorEEnum, StringOperator.STARTS);
    addEEnumLiteral(stringOperatorEEnum, StringOperator.ENDS);
    addEEnumLiteral(stringOperatorEEnum, StringOperator.CONTAINS);

    initEEnum(typeEEnum, Type.class, "Type");
    addEEnumLiteral(typeEEnum, Type.FILE);
    addEEnumLiteral(typeEEnum, Type.FOLDER);
    addEEnumLiteral(typeEEnum, Type.CONTAINER);
    addEEnumLiteral(typeEEnum, Type.PROJECT);

    initEEnum(kindEEnum, Kind.class, "Kind");
    addEEnumLiteral(kindEEnum, Kind.REFERENCE);
    addEEnumLiteral(kindEEnum, Kind.NATURE);
    addEEnumLiteral(kindEEnum, Kind.BUILDER);

    // Create resource
    createResource(eNS_URI);
  }

} //DslPackageImpl
